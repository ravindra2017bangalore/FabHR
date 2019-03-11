package com.csipl.hrms.employee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.DropDownHdService;
import com.csipl.common.util.EnumUtil;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.EmpUploadUtil;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.employee.EmployeeStatuaryDTO;
import com.csipl.hrms.dto.employee.PayStructureDTO;
import com.csipl.hrms.dto.employee.PayStructureHdDTO;
import com.csipl.hrms.dto.organisation.AddressDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.service.adaptor.EmployeePersonalInformationAdaptor;
import com.csipl.hrms.service.authorization.repository.RoleMasterRepository;
import com.csipl.hrms.service.common.CityService;
import com.csipl.hrms.service.common.StateService;
import com.csipl.hrms.service.employee.BankDetailsService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.EmployeeUploadService;
import com.csipl.hrms.service.organization.DepartmentService;
import com.csipl.hrms.service.organization.DesignationService;
import com.csipl.hrms.service.organization.GradeService;

@RestController
public class EmployeeInfoUploadController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeInfoUploadController.class);

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	StateService stateService;

	@Autowired
	EmployeeUploadService employeeUploadService;

	@Autowired
	CityService cityService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	DesignationService designationService;

	@Autowired
	DropDownHdService dropDownHdService;

	@Autowired
	BankDetailsService bankDetailsService;

	@Autowired
	GradeService gradeService;

	@Autowired
	RoleMasterRepository roleMasterRepository;

	EmployeePersonalInformationAdaptor employeePersonalInformationAdaptor = new EmployeePersonalInformationAdaptor();

	@RequestMapping(value = "/empInfoUpload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public @ResponseBody ErrorHandling employeeUpload(@RequestPart("uploadFile") MultipartFile file,
			@RequestPart("info") EmployeeDTO employeeDto, HttpServletRequest req)
			throws IOException, PayRollProcessException, EncryptedDocumentException, InvalidFormatException {
		logger.info("request inside empInfoUpload controller employeeUpload employeeDto is : " + employeeDto + "file is"
				+ file);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		Workbook workbook = WorkbookFactory.create(AppUtils.createEmpFile(file));
		logger.info("workbook is : " + workbook);
		ErrorHandling error = new ErrorHandling();
		try {
			String empCodePrefix = "";
			Sheet sheet = workbook.getSheetAt(0);
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

			int lastRow = sheet.getLastRowNum();
			Map<Integer, StringBuilder> errorMap = new HashMap<Integer, StringBuilder>();
			int errorIndex = 3;
			logger.info("============1");
			Map<Long, City> cityMap = loadCitiesInMap();
			Map<Long, Designation> designationMap = loadDesignationsInMap(user.getCompany().getCompanyId());
			DrowpdownHd bankList = dropDownHdService.findDropDownById(DropDownEnum.BankName.drowpdownId);
			DrowpdownHd employmentTypes = dropDownHdService.findDropDownById(DropDownEnum.EmploymentType.drowpdownId);
			DrowpdownHd maritalStatus = dropDownHdService.findDropDownById(DropDownEnum.MaritalStatus.drowpdownId);
			DrowpdownHd accountTypes = dropDownHdService.findDropDownById(DropDownEnum.AccountType.drowpdownId);
			DrowpdownHd Statuaries = dropDownHdService.findDropDownById(DropDownEnum.Statuary.drowpdownId);
			DrowpdownHd genders = dropDownHdService.findDropDownById(DropDownEnum.Gender.drowpdownId);
			Grade grade = gradeService.findGradeByName("G0", user.getCompany().getCompanyId());

			List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
			List<Integer> employeeCodes = new ArrayList<Integer>();
			EmpUploadUtil infoUtill = new EmpUploadUtil();
			logger.info("============2");
			for (int index = 2; index < lastRow; index++) {

				Row rowData = sheet.getRow(index);
				boolean flag = checkIfRowIsLast(rowData, infoUtill);
				StringBuilder stringBuilder = new StringBuilder();

				if (flag)
					break;

				EmployeeDTO employee = new EmployeeDTO();
				BankDetailsDTO bankDetailsDto = new BankDetailsDTO();

				List<PayStructureHdDTO> payStructureHds = new ArrayList<PayStructureHdDTO>();
				PayStructureHdDTO payStructureHdDTO = new PayStructureHdDTO();
				List<PayStructureDTO> payStructureDtoList = new ArrayList<PayStructureDTO>();
				payStructureHdDTO.setPayStructureDtoList(payStructureDtoList);

				List<BankDetailsDTO> employeeBanks = new ArrayList<BankDetailsDTO>();
				List<EmployeeIdProofDTO> employeeIdProofs = new ArrayList<EmployeeIdProofDTO>();
				List<EmployeeStatuaryDTO> employeeStatuaries = new ArrayList<EmployeeStatuaryDTO>();

				AddressDTO presentAddress = new AddressDTO();
				AddressDTO permanentAddress = new AddressDTO();

				employee.setUserId(user.getUserId());

				employee.setGroupId(user.getGroupg().getGroupId());
				employee.setCompanyId(user.getCompany().getCompanyId());
				BigDecimal grossPay = new BigDecimal(0);
				logger.info("============3");
				for (int colIx = infoUtill.Employee_Code; colIx < infoUtill.UniformAllowance; colIx++) {

					Cell cell = rowData.getCell(colIx);

					if (colIx == infoUtill.Employee_Code || colIx == infoUtill.First_Name
							|| colIx == infoUtill.Middle_Name || colIx == infoUtill.Last_Name || colIx == infoUtill.DOB
							|| colIx == infoUtill.Gender || colIx == infoUtill.Marital_ID

							|| colIx == infoUtill.JobStateID || colIx == infoUtill.JobLocationID
							|| colIx == infoUtill.BloodGroup_ID

							|| colIx == infoUtill.ProbationDays || colIx == infoUtill.EmployeeType
							|| colIx == infoUtill.DepartmentName_ID || colIx == infoUtill.DesignationName_ID
							|| colIx == infoUtill.ReferenceName || colIx == infoUtill.DateOfJoining
							|| colIx == infoUtill.AadharCardNo) {

						if (colIx == infoUtill.Employee_Code) {
							String value = cell.getStringCellValue();
							if (value != null && value.indexOf("-") > 0) {
								String code = value.substring(value.lastIndexOf("-") + 1, value.length());

								employeeCodes.add(Integer.parseInt(code));
							}
							String[] parts = value.split("-");
							empCodePrefix = parts[0] + "-";// COM
						}
						if (colIx == infoUtill.Permanent_Address_Country) {
							permanentAddress.setCountryId(1l);
						}

						if (colIx == infoUtill.Gender) {
							String gender = EnumUtil.getEnumKey(genders, cell.getStringCellValue());
							employee.setGender(gender);

						} /*
							 * else if (colIx == infoUtill.Marital_ID) { String marital =
							 * EnumUtil.getEnumKey(maritalStatus, cell.getStringCellValue()); logger.info(
							 * "marital status "+marital); employee.setMaritalStatus(marital);
							 * 
							 * }
							 */ else if (colIx == infoUtill.EmployeeType) {

							String empType = EnumUtil.getEnumKey(employmentTypes, cell.getStringCellValue());
							employee.setEmpType(empType);

						}

						infoUtill.buildEmployee(employee, cell, colIx, evaluator, stringBuilder, cityMap,
								designationMap);
					}

					if (colIx == infoUtill.Present_Address_AddressText || colIx == infoUtill.Present_Address_City_ID
							|| colIx == infoUtill.Present_Address_Country || colIx == infoUtill.Present_Address_State_ID
							|| colIx == infoUtill.Present_Address_Email || colIx == infoUtill.Present_Address_Mobile_No
							|| colIx == infoUtill.Present_Address_Pin_Code
							|| colIx == infoUtill.Present_Address_Telephone
							|| colIx == infoUtill.Present_Address_Landmark) {

						infoUtill.buildPresentAddress(presentAddress, cell, colIx, evaluator, stringBuilder, cityMap,
								index);
						presentAddress.setCountryId(1L);
					}

					if (colIx == infoUtill.Permanent_Address_AddressText || colIx == infoUtill.Permanent_Address_City_ID
							|| colIx == infoUtill.Permanent_Address_Country
							|| colIx == infoUtill.Permanent_Address_State_ID
							|| colIx == infoUtill.Permanent_Address_Email
							|| colIx == infoUtill.Permanent_Address_Mobile_No
							|| colIx == infoUtill.Permanent_Address_Pin_Code
							|| colIx == infoUtill.Permanent_Address_Telephone
							|| colIx == infoUtill.Permanent_Address_Landmark) {

						infoUtill.builPermanentdAddress(permanentAddress, cell, colIx, evaluator, stringBuilder,
								cityMap);
						permanentAddress.setCountryId(1L);
					}

					if (colIx == infoUtill.BasicSalary || colIx == infoUtill.DearnessAllowance
							|| colIx == infoUtill.HouseRentAllowance || colIx == infoUtill.ConveyanceAllowance
							|| colIx == infoUtill.SpecialAllowance || colIx == infoUtill.MedicalAllowance
							|| colIx == infoUtill.AdvanceBonus || colIx == infoUtill.PerformanceLinkedIncome
							|| colIx == infoUtill.CompanyBenefits || colIx == infoUtill.LeaveTravelAllowance
							|| colIx == infoUtill.UniformAllowance) {

						BigDecimal amount = infoUtill.payheads(payStructureHdDTO, cell, colIx, evaluator,
								stringBuilder);
						grossPay = grossPay.add(amount);

					}

					if (colIx == infoUtill.AccountType_ID || colIx == infoUtill.BankName || colIx == infoUtill.BankId
							|| colIx == infoUtill.AccountNumber || colIx == infoUtill.IfscCode
							|| colIx == infoUtill.EffectiveDate) {

						/*
						 * if (colIx == infoUtill.BankName) { DataFormatter dataFormatter = new
						 * DataFormatter(); String cellStringValue =
						 * dataFormatter.formatCellValue(cell); if (!cellStringValue.equals("")) {
						 * String bankId = EnumUtil.getEnumKey(bankList, cellStringValue);
						 * bankDetailsDto.setBankId(bankId); }
						 * 
						 * } else
						 */ if (colIx == infoUtill.AccountType_ID) {

							DataFormatter dataFormatter = new DataFormatter();
							String cellStringValue = dataFormatter.formatCellValue(cell);

							if (!cellStringValue.equals("")) {

								String accountType = EnumUtil.getEnumKey(accountTypes, cellStringValue);

								bankDetailsDto.setAccountType(cellStringValue);
							}

						}

						infoUtill.buildBankDetails(bankDetailsDto, cell, colIx, evaluator, stringBuilder);
					}

					if (colIx == infoUtill.AadharCardNo || colIx == infoUtill.PanCardNo) {

						infoUtill.buildIdAndAddressProof(employeeIdProofs, cell, colIx, evaluator, stringBuilder);
					}

					if (colIx == infoUtill.PfNo || colIx == infoUtill.Uan || colIx == infoUtill.EsiNo) {
						infoUtill.buildStatoryInfo(employeeStatuaries, cell, colIx, evaluator, stringBuilder);
					}

				}
				logger.info("============4");
				if (stringBuilder.length() > 0) {
					errorMap.put(errorIndex, stringBuilder);
				}
				logger.info("============5");
				logger.info("============");
				logger.info("grade Id>>>>>>" + grade.getGradesId());
				payStructureHdDTO.setGradesId(grade.getGradesId());

				payStructureHdDTO.setGrossPay(grossPay);
				payStructureHdDTO.setEffectiveDate(new Date());

				employee.setAddress1(presentAddress);
				employee.setAddress2(permanentAddress);
				payStructureHds.add(payStructureHdDTO);
				employeeBanks.add(bankDetailsDto);
				employee.setEmployeeBanks(employeeBanks);
				employee.setPayStructureHds(payStructureHds);
				employee.setEmployeeIdProofs(employeeIdProofs);
				employee.setEmployeeStatuaries(employeeStatuaries);

				employees.add(employee);
				errorIndex++;
			}
			logger.info("============6");
			if (errorMap.size() > 0) {
				StringBuilder builder = new StringBuilder();

				String mesage, value = null;
				for (Map.Entry<Integer, StringBuilder> entry : errorMap.entrySet()) {
					mesage = entry.getValue().substring(0, entry.getValue().lastIndexOf(","));
					builder.append("For row - " + entry.getKey() + " " + mesage + " is missing,  ");
				}
				logger.info("============7");
				throw new PayRollProcessException(builder.toString());

			} else {

				UserRole userRole = new UserRole();
				// List<RoleMaster> roleMasterList=new ArrayList<RoleMaster>();
				RoleMaster roleMaster = roleMasterRepository.getRoleMasterId();
				userRole.setUser(user);
				userRole.setRoleMaster(roleMaster);
				userRole.setSUserId(HrmsGlobalConstantUtil.SUPER_USER_ID);
				Object[] empArray = employeePersonalInformationAdaptor.uiDtoToDatabaseModelList(employees, roleMaster);
				List<Employee> employeeList = (List<Employee>) empArray[0];
				List<User> userList = (List<User>) empArray[1];
				List<UserRole> userRoleList = (List<UserRole>) empArray[2];
				Collections.sort(employeeCodes);
				int maxEmpCode = employeeCodes.get(employeeCodes.size() - 1);
				BigDecimal deciLastNo = new BigDecimal(maxEmpCode);
				Company company = new Company();
				company.setCompanyId(user.getCompany().getCompanyId());

				MasterBook masterBook = employeeUploadService.findMasterBook(HrmsGlobalConstantUtil.bookCode,
						company.getCompanyId(), HrmsGlobalConstantUtil.bookType);

				if (masterBook != null && masterBook.getLastNo() != null)
					masterBook.setLastNo(deciLastNo);
				else {
					masterBook.setLastNo(deciLastNo);
					masterBook.setCompany(company);
					masterBook.setPrefixBook(empCodePrefix);
					masterBook.setBookCode(HrmsGlobalConstantUtil.bookCode);
					masterBook.setBookName(HrmsGlobalConstantUtil.bookName);
					masterBook.setUserId(user.getUserId());
					masterBook.setGroupId(user.getGroupg().getGroupId());
					masterBook.setDateCreated(new Date());
				}

				employeeUploadService.saveAll(employeeList, userList, masterBook, userRoleList);
				logger.info("Really Done this.............");
				error.setMessage("Employee FIle Uploaded Successfully");
			}

			// Closing the workbook
			workbook.close();

		}

		/*
		 * EmployeeInfoUploadUtil util = new EmployeeInfoUploadUtil(); List<String>
		 * listCsv = util.csvReaderFile(AppUtils.createCsvFile(file));
		 */
		catch (IOException ex) {

			workbook.close();
			ex.printStackTrace();
			throw new PayRollProcessException("Internal Server error");
		} catch (ParseException e) {
			workbook.close();
			e.printStackTrace();
			throw new PayRollProcessException("Internal Server error");
		}
		return error;
	}

	private boolean checkIfRowIsLast(Row row, EmpUploadUtil infoUtill) {
		boolean flag = false;

		for (int colIx = infoUtill.Employee_Code; colIx < infoUtill.UniformAllowance; colIx++) {
			Cell cell = row.getCell(colIx);

			if (colIx == infoUtill.Employee_Code) {
				if (cell == null) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	private Map<Long, City> loadCitiesInMap() {
		List<City> cities = cityService.findAllCities();
		Map<Long, City> cityMap = new HashMap<Long, City>();
		Long stateId = null;
		String key = null;
		for (City city : cities) {
			stateId = city.getState().getStateId();
			// key = city.getCityName()+"#"+stateId;
			cityMap.put(city.getCityId(), city);
		}
		return cityMap;
	}

	private Map<Long, Designation> loadDesignationsInMap(Long companyId) {
		List<Designation> designations = designationService.findAllDesignation(companyId);
		Map<Long, Designation> designationMap = new HashMap<Long, Designation>();

		for (Designation designation : designations) {

			designationMap.put(designation.getDesignationId(), designation);
		}
		return designationMap;
	}
}
