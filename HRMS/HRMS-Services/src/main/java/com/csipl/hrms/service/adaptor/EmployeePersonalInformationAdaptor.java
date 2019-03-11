package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.employee.EmployeeDeptDTO;
import com.csipl.hrms.dto.employee.EmployeeSkillDTO;
import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.dto.payroll.EmployeeCodeDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.model.organisation.Project;
import com.csipl.hrms.service.util.ConverterUtil;

public class EmployeePersonalInformationAdaptor {
	AddressAdaptor addressAdaptor = new AddressAdaptor();
	EmployeeSkillAdaptor employeeSkillAdaptor = new EmployeeSkillAdaptor();
	BankDetailsAdaptor bankDetailsAdaptor = new BankDetailsAdaptor();
	PayStructureHdAdaptor payStructureHdAdaptor = new PayStructureHdAdaptor();
	EmployeeIdProofAdaptor employeeIdProofAdaptor = new EmployeeIdProofAdaptor();
	EmployeeStatuaryAdaptor employeeStatuaryAdaptor = new EmployeeStatuaryAdaptor();
	MandatoryInfoCheckAdaptor mandatoryInfoCheckAdaptor = new MandatoryInfoCheckAdaptor();

	public Employee uiDtoToDatabaseModel(EmployeeDTO employeeDto) {

		Employee employee = new Employee();
		Department department = new Department();
		Designation designation = new Designation();
		Project project = new Project();
		Client client = new Client();
		City city = new City();
		State state = new State();
		Groupg groupg = new Groupg();
		Company company = new Company();
		groupg.setGroupId(1l);
		employee.setUserId(employeeDto.getUserId());
		employee.setGroupg(groupg);
		company.setCompanyId(employeeDto.getCompanyId());
		employee.setCompany(company);
		employee.setEmployeeCode(employeeDto.getEmployeeCode());
		employee.setNewSkillValues(employeeDto.isNewSkillValues());
		employee.setReportingToEmployee(employeeDto.getReportingToEmployee());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setMiddleName(employeeDto.getMiddleName());
		employee.setLastName(employeeDto.getLastName());
		employee.setDateOfBirth(employeeDto.getDateOfBirth());
		employee.setAdharNumber(employeeDto.getAadharNumber());
		employee.setGender(employeeDto.getGender());
		employee.setEmployeeLogoPath(employeeDto.getEmployeeLogoPath());
		employee.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setContractStartDate(employeeDto.getContractStartDate());
		if (employeeDto.getAadharNumber() != null) {
			employee.setAdharNumber(employeeDto.getAadharNumber());
		}

		if (employeeDto.getAddress1() != null && employeeDto.getAddress1().getCityId() != null
				&& employeeDto.getAddress1().getEmailId() != null) {
			employee.setAddress1(addressAdaptor.uiDtoToDatabaseModel(employeeDto.getAddress1()));
		}

		if (employeeDto.getAddress2() != null && employeeDto.getAddress2().getCityId() != null
				&& employeeDto.getAddress2().getEmailId() != null) {
			employee.setAddress2(addressAdaptor.uiDtoToDatabaseModel(employeeDto.getAddress2()));
		}

		if (employeeDto.getAddress3() != null && employeeDto.getAddress3().getCityId() != null
				&& employeeDto.getAddress3().getEmailId() != null) {
			employee.setAddress3(addressAdaptor.uiDtoToDatabaseModel(employeeDto.getAddress3()));
		}
		
		if (employeeDto.getEmployeeSkillArray() != null && employeeDto.getEmployeeSkillArray().size() > 0)
			employee.setEmployeeSkills(employeeSkillAdaptor
					.uiDtoToDatabaseModelListUTIL(employeeDto.getEmployeeSkillArray(), employeeDto));

		employee.setAnniversaryDate(employeeDto.getAnniversaryDate());
		employee.setBloodGroup(employeeDto.getBloodGroup());
		employee.setProbationDays(employeeDto.getProbationDays());
		employee.setEmpType(employeeDto.getEmpType());
		department.setDepartmentName(employeeDto.getDepartmentName());
		department.setDepartmentId(employeeDto.getDepartmentId());
		employee.setDepartment(department);
		designation.setDesignationId(employeeDto.getDesignationId());
		designation.setDesignationName(employeeDto.getDesignationName());
		employee.setDesignation(designation);

		if (employeeDto.getProjectId() != null) {
			project.setProjectId(employeeDto.getProjectId());
			project.setProjectName(employeeDto.getProjectName());
			employee.setProject(project);
		}

		if (employeeDto.getClientId() != null) {
			client.setClientId(employeeDto.getClientId());
			client.setClientName(employeeDto.getClientName());
			employee.setClient(client);
		}

		// System.out.println("employeeDto.getCityId()>>> " + employeeDto.getCityId());
		if (employeeDto.getCityId() != null) {
			city.setCityId(employeeDto.getCityId());
			city.setCityName(employeeDto.getCityName());
			employee.setCity(city);
		}
		if (employeeDto.getStateId() != null) {
			state.setStateId(employeeDto.getStateId());
			state.setStateName(employeeDto.getStateName());
			employee.setState(state);
		}
		employee.setReportingToEmployee(employeeDto.getReportingToEmployee());
		employee.setContractOverDate(employeeDto.getContractOverDate());
		employee.setReferenceName(employeeDto.getReferenceName());
		employee.setDateOfJoining(employeeDto.getDateOfJoining());
		if (employeeDto.getActiveStatus() != null)
			employee.setActiveStatus(employeeDto.getActiveStatus());
		employee.setNoticePeriodDays(employeeDto.getNoticePeriodDays());
		List<EmployeeSkill> employeeSkillList = new ArrayList<EmployeeSkill>();
		if (employeeDto.getEmployeeId() == null || employeeDto.isNewSkillValues() == true) {
			if (employeeDto.getEmployeeSkills() != null) {
				for (Long skillslist : employeeDto.getEmployeeSkills()) {
					Skill skill = new Skill();
					EmployeeSkill employeeSkill = new EmployeeSkill();
					skill.setSkillId(skillslist);
					employeeSkill.setSkill(skill);
					employeeSkillList.add(employeeSkill);
					employeeSkill.setEmployee(employee);
					employeeSkill.setUserId(employeeDto.getUserId());
					employeeSkill.setActiveStatus(employee.getActiveStatus());
					for (EmployeeSkillDTO employeeSkillDto : employeeDto.getEmployeeSkillArray()) {
						employeeSkill.setEmployeeSkillsId(employeeSkillDto.getEmployeeSkillsId());
					}
					employeeSkillList.add(employeeSkill);
				}
			}
		}
		if (employeeDto.getEmployeeId() != null)
			employee.setDateCreated(employeeDto.getDateCreated());
		else
			employee.setDateCreated(new Date());
		employee.setUserIdUpdate(employeeDto.getUserIdUpdate());
		employee.setDateUpdate(new Date());
		employee.setEmployeeSkills(employeeSkillList);
		return employee;
	}

	public EmployeeDTO databaseModelToUiDto(Employee employee) {
		EmployeeDTO employeeDto = new EmployeeDTO();
		if (employee != null && employee.getDateOfJoining() != null)
			employeeDto
					.setTotalExperience(DateUtils.getDateDifferenceInDDMMYYYY(employee.getDateOfJoining(), new Date()));
		employeeDto.setUserId(employee.getUserId());
		employeeDto.setDateCreated(employee.getDateCreated());
		if (employee.getNoticePeriodDays() != null)
			employeeDto.setNoticeDate(DateUtils.getDateFormat(employee.getNoticePeriodDays()));
		employeeDto.setEmployeeCode(employee.getEmployeeCode());
		employeeDto.setReportingToEmployee(employee.getReportingToEmployee());
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setMiddleName(employee.getMiddleName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setDateOfBirth(employee.getDateOfBirth());
		employeeDto.setAadharNumber(employee.getAdharNumber());
		employeeDto.setGender(employee.getGender());
		employeeDto.setMaritalStatus(employee.getMaritalStatus());
		employeeDto.setEmployeeLogoPath(employee.getEmployeeLogoPath());
		employeeDto.setCompanyId(employee.getCompany().getCompanyId());
		if (employee.getAddress1() != null)
			employeeDto.setAddress1(addressAdaptor.databaseModelToUiDto(employee.getAddress1()));
		if (employee.getAddress1() != null)
			employeeDto.setAddress2(addressAdaptor.databaseModelToUiDto(employee.getAddress2()));
		if (employee.getAddress3() != null)
			employeeDto.setAddress3(addressAdaptor.databaseModelToUiDto(employee.getAddress3()));
		employeeDto.setAnniversaryDate(employee.getAnniversaryDate());
		employeeDto.setContractStartDate(employee.getContractStartDate());
		employeeDto.setEmployeeSkillArray(
				employeeSkillAdaptor.databaseModelToUiDtoListUTIL(employee.getEmployeeSkills(), employee));
		employeeDto.setBloodGroup(employee.getBloodGroup());
		employeeDto.setProbationDays(employee.getProbationDays());
		employeeDto.setEmpType(employee.getEmpType());
		employeeDto.setDepartmentId(employee.getDepartment().getDepartmentId());
		employeeDto.setDepartmentName(employee.getDepartment().getDepartmentName());
		employeeDto.setDesignationId((employee.getDesignation().getDesignationId()));
		employeeDto.setDesignationName(employee.getDesignation().getDesignationName());

		if (employee.getProject() != null) {
			employeeDto.setProjectId(employee.getProject().getProjectId());
			employeeDto.setProjectName(employee.getProject().getProjectName());
		}
		if (employee.getClient() != null) {
			employeeDto.setClientId(employee.getClient().getClientId());
			employeeDto.setClientName(employee.getClient().getClientName());
		}
		if (employee.getCity() != null) {
			employeeDto.setCityId(employee.getCity().getCityId());
			employeeDto.setCityName(employee.getCity().getCityName());
		}

		if (employee.getState() != null) {
			employeeDto.setStateId(employee.getState().getStateId());
			employeeDto.setStateName(employee.getState().getStateName());
		}

		if (employee.getPayStructureHds() != null) {
			employee.getPayStructureHds().forEach(payStrHead -> {
				if (payStrHead.getActiveStatus() != null && payStrHead.getActiveStatus().equals("AC")) {
					employeeDto.setGradeName(payStrHead.getGrade().getGradesName());
				}
			});
		}

		employeeDto.setReportingToEmployee(employee.getReportingToEmployee());
		employeeDto.setContractOverDate(employee.getContractOverDate());
		employeeDto.setReferenceName(employee.getReferenceName());
		employeeDto.setDateOfJoining(employee.getDateOfJoining());
		employeeDto.setActiveStatus(employee.getActiveStatus());
		employeeDto.setNoticePeriodDays(employee.getNoticePeriodDays());
		employeeDto.setFullNameCodeVaues(employee.getFirstName()+" "+employee.getLastName()+" ("+employee.getEmployeeCode()+")");
		
		
		List<Long> employeeSkills = new ArrayList<Long>();
		for (EmployeeSkill employeeSkill : employee.getEmployeeSkills()) {
			Long SkillId = employeeSkill.getSkill().getSkillId();
			employeeSkills.add(SkillId);
		}
		employeeDto.setEmployeeSkills(employeeSkills);
		return employeeDto;
	}

	public List<EmployeeDTO> databaseModelToUiDtoList(List<Employee> employeeList) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for (Employee employee : employeeList) {
			employeeDtoList.add(databaseModelToUiDto(employee));
		}
		return employeeDtoList;
	}

	public List<EmployeeDTO> databaseModelToUiDtoListNativeSearch(List<Employee> employeeList) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for (Employee employee : employeeList) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmployeeId(employee.getEmployeeId());
			dto.setEmployeeCode(employee.getEmployeeCode());
			dto.setFirstName(employee.getFirstName());
			dto.setLastName(employee.getLastName());
			employeeDtoList.add(dto);
		}
		return employeeDtoList;
	}

	public List<EmployeeDeptDTO> employeeListToEmployeeDeptDto(List<Employee> employeeList) {
		List<EmployeeDeptDTO> employeeCodeDeptList = new ArrayList<EmployeeDeptDTO>();
		for (Employee employee : employeeList) {
			employeeCodeDeptList.add(employeeToEmployeeDeptDto(employee));
		}
		return employeeCodeDeptList;
	}

	public EmployeeDeptDTO employeeToEmployeeDeptDto(Employee employee) {
		EmployeeDeptDTO employeeDeptDto = new EmployeeDeptDTO();
		employeeDeptDto.setEmployeeCode(employee.getEmployeeCode());
		employeeDeptDto.setFirstName(employee.getFirstName());
		employeeDeptDto.setLastName(employee.getLastName());
		employeeDeptDto.setEmployeeId(employee.getEmployeeId());
		return employeeDeptDto;
	}

	public Object[] uiDtoToDatabaseModelList(List<EmployeeDTO> employeeDtoList, RoleMaster roleMaster) {
		List<Employee> employeeList = new ArrayList<Employee>();
		List<User> usersList = new ArrayList<User>();
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		String userPassword = "@1234";
		Object[] empArray = new Object[4];
		System.out.println("============8");
		employeeDtoList.forEach(employeeDTO -> {
			Employee employee = uiDtoToDatabaseModel(employeeDTO);
			User user = new User();
			user.setCompany(employee.getCompany());
			user.setCompany(employee.getCompany());
			user.setGroupg(employee.getGroupg());
			user.setUserPassword(AppUtils.SHA1(employee.getEmployeeCode() + userPassword));
			user.setNameOfUser(employee.getEmployeeCode());
			user.setSuserId(employee.getUserId());
			user.setAddress(employee.getAddress1());
			user.setEmailOfUser(employee.getAddress1().getEmailId());

			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRoleMaster(roleMaster);
			userRole.setSUserId(HrmsGlobalConstantUtil.SUPER_USER_ID);

			employee.setAddress1(addressAdaptor.uiDtoToDatabaseModel(employeeDTO.getAddress1(), employee));
			employee.setAddress2(addressAdaptor.uiDtoToDatabaseModel(employeeDTO.getAddress2(), employee));

			List<EmployeeBank> empBankss = bankDetailsAdaptor.uiDtoToDatabaseModelList(employeeDTO.getEmployeeBanks(),
					employee);
			employee.setEmployeeBanks(empBankss);

			List<PayStructureHd> payStructureHds = payStructureHdAdaptor
					.uiDtoToDatabaseModelList(employeeDTO.getPayStructureHds(), employee);
			employee.setPayStructureHds(payStructureHds);

			List<EmployeeIdProof> employeeIdProofs = employeeIdProofAdaptor
					.employeeIdProofDtoToDatabaseModelList(employeeDTO.getEmployeeIdProofs(), employee);
			employee.setEmployeeIdProofs(employeeIdProofs);

			List<EmployeeStatuary> employeeStatuaries = employeeStatuaryAdaptor
					.empStaturyDtoToDatabaseModelList(employeeDTO.getEmployeeStatuaries(), employee);
			employee.setEmployeeStatuaries(employeeStatuaries);

			List<MandatoryInfoCheck> mandatoryInfoCheckList = mandatoryInfoCheckAdaptor
					.uiDtoToDatabaseModelListExcel(employeeDTO.getEmployeeBanks(), employee);
			employee.setMandatoryInfoChecks(mandatoryInfoCheckList);

			employeeList.add(employee);
			usersList.add(user);
			userRoleList.add(userRole);
			empArray[0] = employeeList;
			empArray[1] = usersList;
			empArray[2] = userRoleList;

		});
		return empArray;
	}

	public List<EmployeeDTO> modeltoDTOList(List<Object[]> employeeList, EmployeeSearchDTO employeeSearchDto) {
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();

		int index = 1;
		for (Object[] empObj : employeeList) {
			EmployeeDTO emp = new EmployeeDTO();

			emp.setIndex(index);
			long empId = ConverterUtil.getLong(empObj[0]);
			emp.setEmployeeId(empId);
			emp.setEmployeeCode(empObj[1].toString());
			emp.setFirstName(empObj[2].toString());
			emp.setCharFirstName(Character.toString(emp.getFirstName().charAt(0)).toUpperCase());
			if (empObj[3] != null) {
				emp.setLastName(empObj[3].toString());
				emp.setCharFirstName(Character.toString(emp.getFirstName().charAt(0)).toUpperCase());
				emp.setCharLastName(Character.toString(emp.getLastName().charAt(0)).toUpperCase());
			}
			if (empObj[4] != null) {
				emp.setGradeName(empObj[4].toString());
			}

			if (empObj[5] != null) {
				emp.setDepartmentName(empObj[5].toString());
			}

			if (empObj[6] != null) {
				emp.setDesignationName(empObj[6].toString());
			}

			if (empObj[7] != null) {
				Date doj = (Date) (empObj[7]);
				emp.setDateOfJoining(doj);
			}

			if (empObj[8] != null) {
				Date endDate = (Date) (empObj[8]);
				emp.setEndDate(endDate);
			}

			if (empObj[9] != null) {
				emp.setEmployeeLogoPath(empObj[9].toString());
			}

			if (empObj[10] != null) {
				Date dob = (Date) (empObj[10]);
				emp.setDateOfBirth(dob);
			}

			if (empObj[11] != null) {
				emp.setReportingEmployeeFirstName(empObj[11].toString());
			}

			if (empObj[12] != null) {
				emp.setReportingEmployeeLastName(empObj[12].toString());
			}

			employeeDTOList.add(emp);
			index++;
		}

		if (employeeSearchDto.getActive() != null && (employeeSearchDto.getActive().trim().equals("index"))) {

			if (employeeSearchDto.getSortDirection().equals("asc")) {
				Collections.sort(employeeDTOList);
			} else {

				Collections.sort(employeeDTOList, Collections.reverseOrder());
			}

		}
		if (employeeSearchDto.getActive() != null && (employeeSearchDto.getActive().trim().equals("employeeCode"))) {
			if (employeeSearchDto.getSortDirection().equals("asc")) {

				Collections.sort(employeeDTOList, new Comparator<EmployeeDTO>() {

					@Override
					public int compare(EmployeeDTO employeeDTOo1, EmployeeDTO employeeDTOo2) {
						// TODO Auto-generated method stub
						String employeeCode1 = employeeDTOo1.getEmployeeCode();
						String employeeCode2 = employeeDTOo2.getEmployeeCode();
						int index1 = employeeCode1.indexOf("-");
						Integer num1 = Integer.valueOf(employeeCode1.substring(index1 + 1));

						int index2 = employeeCode2.indexOf("-");
						Integer num2 = Integer.valueOf(employeeCode2.substring(index2 + 1));

						int diff = num1.compareTo(num2);
						return diff;

					}

				});

			} else {

				Collections.sort(employeeDTOList, new Comparator<EmployeeDTO>() {

					@Override
					public int compare(EmployeeDTO employeeDTOo1, EmployeeDTO employeeDTOo2) {
						// TODO Auto-generated method stub
						String employeeCode1 = employeeDTOo1.getEmployeeCode();
						String employeeCode2 = employeeDTOo2.getEmployeeCode();
						int index1 = employeeCode1.indexOf("-");
						Integer num1 = Integer.valueOf(employeeCode1.substring(index1 + 1));

						int index2 = employeeCode2.indexOf("-");
						Integer num2 = Integer.valueOf(employeeCode2.substring(index2 + 1));
						int diff = num2.compareTo(num1);
						return diff;

					}

				});
			}

		}

		return employeeDTOList;
	}

	public List<EmployeeCodeDTO> employeeListToEmployeeCodeDto(List<Employee> employeeList) {
		List<EmployeeCodeDTO> employeeCodeDtoList = new ArrayList<EmployeeCodeDTO>();
		for (Employee employee : employeeList) {
			employeeCodeDtoList.add(employeeToEmployeeCodeDto(employee));
		}
		return employeeCodeDtoList;
	}

	public EmployeeCodeDTO employeeToEmployeeCodeDto(Employee employee) {
		EmployeeCodeDTO employeeCodeDto = new EmployeeCodeDTO();
		employeeCodeDto.setEmployeeCode(employee.getEmployeeCode());
		employeeCodeDto.setDepartmentId(employee.getDepartment().getDepartmentId());
		employeeCodeDto.setEmployeeId(employee.getEmployeeId());
		return employeeCodeDto;
	}

	public List<EmployeeDTO> databaseObjModelToUiDtoList(List<Object[]> employeeObjList) {
		
		
		


		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();

		for (Object[] employeeObj : employeeObjList) {
			EmployeeDTO employeeDto = new EmployeeDTO();
			if (employeeObj[0] != null) {
				employeeDto.setEmployeeId(employeeObj[0] != null ? Long.parseLong(employeeObj[0].toString()) : null);
			}
 
 			if (employeeObj[1] != null) {
				employeeDto.setFirstName(employeeObj[1].toString());
   			}
			if (employeeObj[2] != null) {
				employeeDto.setLastName(employeeObj[2].toString());
   			}
			if (employeeObj[3] != null) {
				employeeDto.setEmployeeCode(employeeObj[3].toString());
   			}
			
			if (employeeObj[4] != null) {
				employeeDto.setEmployeeLogoPath(employeeObj[4].toString());
   			}
			employeeDto.setFullNameCodeVaues(employeeDto.getFirstName()+" "+employeeDto.getLastName()+" ("+employeeDto.getEmployeeCode()+")");

			employeeDtoList.add(employeeDto);

		}
 		return employeeDtoList;
 		
  
	}
}
