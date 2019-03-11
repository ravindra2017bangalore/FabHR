package com.csipl.hrms.service.employee;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.employee.EmpHierarchyDTO;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.employee.OrgHierarchyDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.authorization.repository.RoleMasterRepository;
import com.csipl.hrms.service.authorization.repository.UserRoleRepository;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.repository.BankDetailsRepository;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.hrms.service.employee.repository.EmployeeSkillRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.employee.repository.UserRepository;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.organization.StorageService;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Transactional
@Service("employeeService")
public class EmployeePersonalInformationServiceImpl implements EmployeePersonalInformationService {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private final Logger logger = LoggerFactory.getLogger(EmployeePersonalInformationServiceImpl.class);

	@Autowired
	StorageService storageService;

	@Autowired
	CompanyService companyService;

	@Autowired
	private EmployeePersonalInformationRepository employeePersonalInformationRepository;

	@Autowired
	private EmployeeSkillRepository employeeSkillRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleMasterRepository roleMasterRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private MasterBookRepository masterBookRepository;

	@Autowired
	private MandatoryInfoCheckRepository mandatoryInfoCheckRepository;

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Autowired
	private ReportPayOutRepository reportPayOutRepository;
	
	
	//@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	MailService mailService;

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private org.springframework.core.env.Environment env;

	/**
	 * Save OR update employee object with file into Database
	 * 
	 * @throws ErrorHandling
	 */
	@Override
	public Employee save(Employee employee, MultipartFile file, boolean fileFlag) throws ErrorHandling {
		Long count = 0l;
		Long adhar = 0l;
		User newUser = new User();
		Employee newEmployee = null;
		String bookCode = "EMPNO";
		if (employee.getEmployeeId() != null && employee.isNewSkillValues()) {
			employeeSkillRepository.deleteEmployeeSkill(employee.getEmployeeId());
		}
		adhar = aadharCheck(employee.getAdharNumber(), employee.getEmployeeId());
		Company companyDomain = new Company();
		companyDomain = companyService.getCompany(employee.getCompany().getCompanyId());
		if (employee.getEmployeeId() == null) {
			logger.info("Save method new Employee JOINING ");
			count = checkPayRollForEmployeeJoining(employee.getCompany().getCompanyId(),
					DateUtils.getDateStringWithYYYYMMDD(employee.getDateOfJoining()),
					employee.getDepartment().getDepartmentId());
			if (count > 0) {
				logger.info("Payroll already process for  MONTH "
						+ DateUtils.getDateStringWithYYYYMMDD(employee.getDateOfJoining()) + " Department"
						+ employee.getDepartment().getDepartmentId() + "Company ID"
						+ employee.getCompany().getCompanyId());
				throw new ErrorHandling("Entry denied, payroll has been created already.");
			}

			MasterBook masterBook = masterBookRepository.findMasterBook(employee.getCompany().getCompanyId(), bookCode);
			BigDecimal lastNumberValue;
			lastNumberValue = masterBook.getLastNo();
			long longValue;
			longValue = lastNumberValue.longValue() + 1;
			BigDecimal newDecimalValue = new BigDecimal(longValue);
			employee.setEmployeeCode(masterBook.getPrefixBook() + newDecimalValue);
			// newEmployee =
			// employeePersonalInformationRepository.save(employee);
			logger.info("Addhar Validation AAdhar Count " + adhar+"-----"+employee.getUserId()+""+employee.getUserIdUpdate());
			
		
			if (adhar < 1) {
				newEmployee = employeePersonalInformationRepository.save(employee);
			} else {
				throw new ErrorHandling(" Aadhar number already exists ");
			}
			MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
			mandatoryInfoCheck.setUserId(employee.getUserId());
			mandatoryInfoCheck.setUserIdUpdate(employee.getUserIdUpdate());
			mandatoryInfoCheck.setDateCreated(employee.getDateCreated());
			mandatoryInfoCheck.setDateUpdate(employee.getDateUpdate());
			mandatoryInfoCheck.setEmployee(newEmployee);
			mandatoryInfoCheck.setUi("YES");
			mandatoryInfoCheckRepository.save(mandatoryInfoCheck);

			String fileName = "";
			if (fileFlag) {
				fileName = "Employee_" + newEmployee.getEmployeeId().toString();
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				fileName = fileName + "." + extension;
				logger.info(" File with extension " + fileName);

				String path = File.separator + "images" + File.separator + "employeeImages";
				String dbPath = path + File.separator + fileName;
				storageService.store(file, path, fileName);
				newEmployee.setEmployeeLogoPath(dbPath);
			}

			masterBook.setLastNo(newDecimalValue);
			masterBook.setCompany(employee.getCompany());
			newUser.setCompany(newEmployee.getCompany());
			newUser.setGroupg(newEmployee.getGroupg());
			newUser.setUserPassword(
					AppUtils.SHA1(newEmployee.getEmployeeCode() + HrmsGlobalConstantUtil.USER_PASSWORD));
			newUser.setNameOfUser(masterBook.getPrefixBook() + newDecimalValue);
			newUser.setLoginName(newUser.getNameOfUser() + "-" + companyDomain.getDomainName());
			newUser.setSuserId(newEmployee.getUserId());
			UserRole userRole = new UserRole();
			RoleMaster roleMaster = roleMasterRepository.getRoleMasterId();
			userRole.setUser(newUser);
			userRole.setRoleMaster(roleMaster);
			userRole.setSUserId(HrmsGlobalConstantUtil.SUPER_USER_ID);
			logger.info("user role object=>  User Id" + userRole.getUser().getUserId());
			userRepository.save(newUser);
			masterBookRepository.save(masterBook);
			userRoleRepository.save(userRole);

		} else {
			logger.info("Old Employee Updation case employeeId=>>>" + employee.getEmployeeId() + "Employee CODE=>> "
					+ employee.getEmployeeCode());
			List<EmployeeBank> employeeBanks = bankDetailsRepository.findAllBankDetails(employee.getEmployeeId());
			for (EmployeeBank employeeBank : employeeBanks) {
				employeeBank.setActiveStatus(employee.getActiveStatus());
				employeeBank.setEmployee(employee);
			}
			employee.setEmployeeBanks(employeeBanks);
			if (employee.getAddress1() != null) {
				logger.info("User Table Updation Case emailId=>>" + employee.getAddress1().getEmailId());
				newUser = userRepository.findUser(employee.getEmployeeCode());
				newUser.setAddress(employee.getAddress1());
				newUser.setEmailOfUser(employee.getAddress1().getEmailId());
				newUser = userRepository.save(newUser);
			}
			logger.info("Addhar Validation AAdhar Count " + adhar);
			if (adhar < 1) {
				newEmployee = employeePersonalInformationRepository.save(employee);
			} else {
				throw new ErrorHandling(" Aadhar number already exists ");
			}
			String fileName = "";
			if (fileFlag) {
				fileName = "Employee_" + newEmployee.getEmployeeId().toString();
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				fileName = fileName + "." + extension;
				logger.info(" File with extension " + fileName);
				String path = File.separator + "images" + File.separator + "employeeImages";
				String dbPath = path + File.separator + fileName;
				storageService.store(file, path, fileName);
				newEmployee.setEmployeeLogoPath(dbPath);
			}
		}
		return newEmployee;
	}

	/**
	 * To get List of employees from Database based on company
	 */
	@Override
	public List<Object[]> findAllPersonalInformationDetails(Long companyId) {
		String status="AC";
		return  employeePersonalInformationRepository.findAllEmployees(companyId,status);
 	}

	/**
	 * To get employee object from Database based on employeeCode
	 */
	@Override
	public Employee findEmployees(String employeeCode, Long companyId) {
		return employeePersonalInformationRepository.findEmployees(employeeCode, companyId);
	}

	/**
	 * To get employee object from Database based on employeeId (primary key)
	 */
	@Override
	public Employee findEmployeesById(long employeeId) {
		return employeePersonalInformationRepository.findOne(employeeId);
	}

	/**
	 * Save OR update employees List into Database
	 */
	@Override
	public void saveAll(List<Employee> employeeList) {
		logger.info("saveAll method is calling ");
		employeePersonalInformationRepository.save(employeeList);
	}

	/**
	 * To get List of employees from Database based on companyId and departmentId
	 */
	@Override
	public List<Employee> findAllEmpByDeptId(Long companyId, Long departmentId) {
		return employeePersonalInformationRepository.findAllEmpByDeptId(companyId, departmentId);
	}

	/**
	 * To get List of Deactivated Or Currently not working employees from Database
	 * based on companyId
	 */
	@Override
	public List<Employee> getAllDeactivateEmployees(Long companyId) {
		return employeePersonalInformationRepository.findAllDeactivateEmployees(companyId);
	}

	/**
	 * To get List of employees from Database based on companyId
	 */
	@Override
	public List<Employee> fetchEmployee(Long companyId) {

		List<Employee> employees = new ArrayList<Employee>();
		List<Object[]> employeeList = employeePersonalInformationRepository.fetchEmployee(companyId);

		for (Object[] empObj : employeeList) {
			Employee emp = new Employee();

			long empId = ConverterUtil.getLong(empObj[0]);
			emp.setEmployeeId(empId);
			emp.setEmployeeCode(empObj[1].toString());
			emp.setFirstName(empObj[2].toString());
			emp.setLastName(empObj[3].toString());
			employees.add(emp);
		}
		return employees;
	}

	/**
	 * To get List of employees from Database based on companyId for Employee
	 * Searching
	 */
	public List<Object[]> searchEmployee(Long companyId) {
		List<Object[]> employeeList = employeePersonalInformationRepository.searchEmployee(companyId);
		return employeeList;
	}

	/**
	 * To get employee from Database based on employeeId
	 */
	@Override
	public Employee getEmployeeInfo(Long employeeId) {
		return employeePersonalInformationRepository.findOne(employeeId);
	}

	/**
	 * To get count value from Database for Checking Aadhar number duplicate or not
	 */
	@Override
	public Long aadharCheck(String adharNumber, Long employeeId) {
		if (employeeId == null)
			employeeId = 0l;
		return employeePersonalInformationRepository.aadharCheck(adharNumber,
				ActiveStatusEnum.ActiveStatus.getActiveStatus(), employeeId);

	}

	@Override
	public List<Employee> findBirthDayEmployees(Long companyId) {
		return employeePersonalInformationRepository.findBirthDayEmployees(companyId);
	}

	@Override
	public List<Employee> findAnniversaryEmployees(Long companyId) {
		return employeePersonalInformationRepository.findAnniversaryEmployees(companyId);
	}

	@Override
	public List<Employee> findJoiningAnniversaryEmployees(Long companyId) {
		return employeePersonalInformationRepository.findJoiningAnniversaryEmployees(companyId);
	}

	@Override
	public Long checkPayRollForEmployeeJoining(Long companyId, String processMonth, Long departmentId) {
		System.out.println("processmonth>>" + processMonth + "departmentId" + departmentId);
		return reportPayOutRepository.checkPayRollForEmployeeJoining(companyId, processMonth, departmentId);
	}

	@Override
	public List<EmpHierarchyDTO> orgHierarchyList(Long employeeId) {
		Employee employee = employeePersonalInformationRepository.findOne(employeeId);
		List<Object[]> employeeListObj = employeePersonalInformationRepository.orgHierarchyList(employeeId);
		List<EmpHierarchyDTO> empHierarchyDtoList = new ArrayList<EmpHierarchyDTO>();
		List<EmpHierarchyDTO> empHierarchyDtoListParent = new ArrayList<EmpHierarchyDTO>();
		for (Object[] empObj : employeeListObj) {
			EmpHierarchyDTO empHierarchyDtoObj = new EmpHierarchyDTO();
			Long empId = empObj[0] != null ? Long.parseLong(empObj[0].toString()) : null;
			String firstName = empObj[1] != null ? (String) empObj[1] : null;
			String lastName = empObj[2] != null ? (String) empObj[2] : null;
			String employeeCode = empObj[3] != null ? (String) empObj[3] : null;
			String employeeLogoPath = empObj[4] != null ? (String) empObj[4] : null;
			Long managerId = empObj[5] != null ? Long.parseLong(empObj[5].toString()) : null;
			String departmentName = empObj[8] != null ? (String) empObj[8] : null;
			empHierarchyDtoObj.setEmployeeId(empId);
			empHierarchyDtoObj.setText(firstName + " " + lastName + " (" + departmentName + ")");
			empHierarchyDtoObj.setUrl(employeeLogoPath);
			empHierarchyDtoList.add(empHierarchyDtoObj);
		}
		EmpHierarchyDTO empHierarchyDto = new EmpHierarchyDTO();

		empHierarchyDto.setEmployeeId(employeeId);
		empHierarchyDto.setItems(empHierarchyDtoList);
		empHierarchyDto.setEmployeeId(employeeId);
		empHierarchyDto.setText(employee.getFirstName() + " " + employee.getLastName() + " ("
				+ employee.getDepartment().getDepartmentName() + ")");
		empHierarchyDtoListParent.add(empHierarchyDto);

		return empHierarchyDtoListParent;
	}

 
	@Override
	public void saveCandidateImage(Long employeeId, MultipartFile file) {
		 
		String fileName = "";
 		fileName = "Employee_" + employeeId.toString();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		fileName = fileName + "." + extension;
		System.out.println(" File with extension " + fileName);

		String path = File.separator + "images" + File.separator + "employeeImages";
		String dbPath = path + File.separator + fileName;
		storageService.store(file, path, fileName);
		employeePersonalInformationRepository.saveCandidateImage(dbPath, employeeId);

	}
	public List<Object[]> getOnBoardProgessBar(Long progressBar) {
		return employeePersonalInformationRepository.getOnBoardProgessBar(progressBar);

	}
	@Override
	public void onboardMail(Employee employee) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			String emailLink= AppUtils.url + employee.getEmployeeId();
			String path = env.getProperty("application.url");
			Map model = new HashMap();
			model.put("firstName", employee.getFirstName());
			model.put("lastName", employee.getLastName());
			model.put("EmployeeCode",employee.getEmployeeCode());
			model.put("passward","comp@123");
			model.put("url", path);
			
			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"templates/Onboard.vm", "UTF-8", model);
			mimeMessageHelper.setFrom("amit.jaiswal@computronics.in");
			mimeMessageHelper.setSubject("Onboard");
			mimeMessageHelper.setTo(employee.getAddress1().getEmailId());
			mimeMessageHelper.setText(text, true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object[] getEmpShiftName(Long employeeId) {
		return employeePersonalInformationRepository.getEmpShiftName(employeeId);
	}

	@Override
	public List<Object[]> getEmpReportingToEmail(Long employeeId) {
		return employeePersonalInformationRepository.getEmpReportingToEmail(employeeId);
		
	}

	
}
