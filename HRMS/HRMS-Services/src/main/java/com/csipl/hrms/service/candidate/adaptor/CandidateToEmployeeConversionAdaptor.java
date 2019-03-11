package com.csipl.hrms.service.candidate.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.candidate.CandidateLanguageDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateAddress;
import com.csipl.hrms.model.candidate.CandidateEducation;
import com.csipl.hrms.model.candidate.CandidateFamily;
import com.csipl.hrms.model.candidate.CandidateIdProof;
import com.csipl.hrms.model.candidate.CandidateLanguage;
import com.csipl.hrms.model.candidate.CandidateNominee;
import com.csipl.hrms.model.candidate.CandidateOfficialInformation;
import com.csipl.hrms.model.candidate.CandidatePersonal;
import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.model.candidate.CandidateStatuary;
import com.csipl.hrms.model.common.Address;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.EmployeeLanguage;
import com.csipl.hrms.model.employee.EmployeeNominee;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.model.organisation.Project;
import com.csipl.hrms.service.adaptor.AddressAdaptor;
import com.csipl.hrms.service.adaptor.BankDetailsAdaptor;
import com.csipl.hrms.service.adaptor.EmployeeIdProofAdaptor;
import com.csipl.hrms.service.adaptor.EmployeeSkillAdaptor;
import com.csipl.hrms.service.adaptor.EmployeeStatuaryAdaptor;
import com.csipl.hrms.service.adaptor.MandatoryInfoCheckAdaptor;
import com.csipl.hrms.service.adaptor.PayStructureHdAdaptor;

public class CandidateToEmployeeConversionAdaptor {

	AddressAdaptor addressAdaptor = new AddressAdaptor();
	EmployeeSkillAdaptor employeeSkillAdaptor = new EmployeeSkillAdaptor();
	BankDetailsAdaptor bankDetailsAdaptor = new BankDetailsAdaptor();
	PayStructureHdAdaptor payStructureHdAdaptor = new PayStructureHdAdaptor();
	EmployeeIdProofAdaptor employeeIdProofAdaptor = new EmployeeIdProofAdaptor();
	EmployeeStatuaryAdaptor employeeStatuaryAdaptor = new EmployeeStatuaryAdaptor();
	MandatoryInfoCheckAdaptor mandatoryInfoCheckAdaptor = new MandatoryInfoCheckAdaptor();

	public  Address getAddress(CandidateAddress candidateAddress, Long userId) {
		Address address = new Address();
		Country country = new Country();
		City city = new City();
		State state = new State();
		System.out.println(
				"candidateAddress.getCountry().getCountryId()= " + candidateAddress.getCountry().getCountryId());
		System.out.println("candidateAddress.getCity().getCityId()= " + candidateAddress.getCity().getCityId());
		System.out.println("candidateAddress.getState().getStateId()= " + candidateAddress.getState().getStateId());
		country.setCountryId(candidateAddress.getCountry().getCountryId());
		city.setCityId(candidateAddress.getCity().getCityId());
		state.setStateId(candidateAddress.getState().getStateId());
		// address.setAddressId(candidateAddress.getAddressId());
		address.setAddressText(candidateAddress.getAddressText());
		address.setPincode(candidateAddress.getPincode());
		address.setCity(city);
		address.setCountry(country);
		address.setState(state);
		address.setUserId(userId);
		if(candidateAddress.getEmailId()!=null)
		address.setEmailId(candidateAddress.getEmailId());
		if (candidateAddress.getMobile()!=null)
		address.setMobile(candidateAddress.getMobile());
		System.out.println("address = " + address.getAddressText()+"pinCode.."+address.getPincode());
		return address;

	}
	
	public synchronized EmployeeLanguage getLanguage(CandidateLanguage candidateLanguage, Employee employee) {
		EmployeeLanguage employeeLanguage = new EmployeeLanguage();
		
		System.out.println(
				"candidateLanguage.getLangRead()= " + candidateLanguage.getLangRead());
		System.out.println("candidateLanguage.getLangSpeak()= " + candidateLanguage.getLangSpeak());
		System.out.println("candidateLanguage.getLangWrite()= " + candidateLanguage.getLangWrite());
		
		employeeLanguage.setEmployee(employee);
		employeeLanguage.setLanguage(candidateLanguage.getLanguage());
		employeeLanguage.setLangRead(candidateLanguage.getLangRead());
		employeeLanguage.setLangSpeak(candidateLanguage.getLangSpeak());
		employeeLanguage.setLangWrite(candidateLanguage.getLangWrite());
		
		//employeeLanguage.setUserId(userId);
		//System.out.println("address = " + address.getAddressText()+"pinCode.."+address.getPincode());
		return employeeLanguage;

	}

	public Employee candidateInfoToEmployeeInfoConversion(Candidate candidate,
			CandidateOfficialInformation candidateOfficialInfo, CandidatePersonal candidatePersonal) {
		Employee employee = new Employee();
		Department department = new Department();
		Designation designation = new Designation();
		Project project = new Project();
		Client client = new Client();
		City city = new City();
		State state = new State();
		Groupg groupg = new Groupg();
		Company company = new Company();
		Long userId = candidateOfficialInfo.getUserId();
		groupg.setGroupId(1l);
		employee.setUserId(candidate.getUserId());
		employee.setGroupg(groupg);
		company.setCompanyId(candidate.getCompanyId());
		employee.setCompany(company);
		// employee.setEmployeeCode(employeeDto.getEmployeeCode());
		// employee.setNewSkillValues(employeeDto.isNewSkillValues());
		employee.setReportingToEmployee(Long.parseLong(candidate.getReportingToEmployee()));
		// employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setFirstName(candidate.getFirstName());
		employee.setMiddleName(candidate.getMiddleName());
		employee.setLastName(candidate.getLastName());
		if (candidatePersonal.getDateOfBirth() != null) {
			employee.setDateOfBirth(candidatePersonal.getDateOfBirth());
		}

		// employee.setAdharNumber(employeeDto.getAadharNumber());
		employee.setGender(candidatePersonal.getGender());
		employee.setEmployeeLogoPath(candidate.getCandidateLogoPath());
		employee.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		employee.setMaritalStatus(candidatePersonal.getMaritalStatus());
		employee.setContractStartDate(candidate.getContractStartDate());
		employee.setGradesId(candidateOfficialInfo.getGrade().getGradesId());
		employee.setAlternateNumber(candidatePersonal.getAlternateNumber());
		employee.setTimeContract(candidate.getTimeContract());
		employee.setShiftId(candidate.getShiftId());
		employee.setPatternId(candidate.getPatternId());
		if (candidate.getCandidateLogoPath() != null) {
			employee.setEmployeeLogoPath(candidate.getCandidateLogoPath());
		}
		CandidateAddress candidatePermanentAddress = candidatePersonal.getCandidateAddress1();

		if (candidatePermanentAddress != null && candidatePermanentAddress.getCity() != null
				&& candidatePermanentAddress.getCity().getCityId() != null) {
			System.out.println("candidatePresentAddress " + candidatePermanentAddress.toString());
			Address address = getAddress(candidatePermanentAddress, userId);
			address.setMobile(candidate.getMobile());
			address.setEmailId(candidate.getEmailId());
			employee.setAddress1(address);
		}

		CandidateAddress candidatePresentAddress = candidatePersonal.getCandidateAddress2();
		if (candidatePresentAddress != null && candidatePresentAddress.getCity() != null
				&& candidatePresentAddress.getCity().getCityId() != null) {
			System.out.println("candidatePresentAddress " + candidatePresentAddress.toString());
			Address address = getAddress(candidatePresentAddress, userId);
			address.setMobile(candidatePersonal.getAlternateNumber());
			//address.setEmailId(candidate.getEmailId());
			employee.setAddress2(address);
		}

		CandidateAddress candidateReferenceAddress = candidatePersonal.getCandidateAddress3();
		if (candidateReferenceAddress != null && candidateReferenceAddress.getCity().getCityId() != null
				&& candidateReferenceAddress.getCity().getCityId() != null) {
			System.out.println("candidateReferenceAddress " + candidateReferenceAddress.toString());
			employee.setAddress3(getAddress(candidateReferenceAddress, userId));
		}
		// if (employeeDto.getEmployeeSkillArray() != null &&
		// employeeDto.getEmployeeSkillArray().size() > 0)
		// employee.setEmployeeSkills(employeeSkillAdaptor
		// .uiDtoToDatabaseModelListUTIL(employeeDto.getEmployeeSkillArray(),
		// employeeDto));
	
		employee.setAnniversaryDate(candidatePersonal.getAnniversaryDate());
		employee.setBloodGroup(candidatePersonal.getBloodGroup());
		employee.setProbationDays(candidateOfficialInfo.getProbationDays());
		employee.setEmpType("OB");
		department.setDepartmentName(candidate.getDepartment().getDepartmentName());
		department.setDepartmentId(candidate.getDepartment().getDepartmentId());
		employee.setDepartment(department);
		designation.setDesignationId(candidate.getDesignation().getDesignationId());
		designation.setDesignationName(candidate.getDesignation().getDesignationName());
		employee.setDesignation(designation);
		if (candidate.getProject() != null) {
			project.setProjectId(candidate.getProject().getProjectId());
			project.setProjectName(candidate.getProject().getProjectName());
			employee.setProject(project);
		}

		if (candidate.getClient() != null) {
			client.setClientId(candidate.getClient().getClientId());
			client.setClientName(candidate.getClient().getClientName());
			employee.setClient(client);
		}

		// System.out.println("employeeDto.getCityId()>>> " + employeeDto.getCityId());
		if (candidate.getCityId() != null) {
			city.setCityId(candidate.getCityId());
			// city.setCityName(employeeDto.getCityName());
			employee.setCity(city);
		}
		if (candidate.getStateId() != null) {
			state.setStateId(candidate.getStateId());
			// state.setStateName(candidate.getStateName());
			employee.setState(state);
		}
		employee.setReportingToEmployee(Long.parseLong(candidate.getReportingToEmployee()));
		employee.setContractOverDate(candidate.getContractOverDate());
		employee.setReferenceName(candidatePersonal.getReferenceName());
		employee.setDateOfJoining(candidate.getDateOfJoining());
		// if (employeeDto.getActiveStatus() != null)
		// employee.setActiveStatus(employeeDto.getActiveStatus());
		employee.setNoticePeriodDays(candidateOfficialInfo.getNoticePeriod());

		
		employee.setDateCreated(candidateOfficialInfo.getDateCreated());
		if(candidatePersonal.getCandidateLanguages()!=null)
	    {
			employee.setEmployeeLanguages(languageDtoListToDatabaseModelList(candidatePersonal.getCandidateLanguages(),employee));
		}
		System.out.println(
				"-------" + candidateOfficialInfo.getUserIdUpdate() + "------" + candidateOfficialInfo.getUserId());
		employee.setUserIdUpdate(candidateOfficialInfo.getUserIdUpdate());

		employee.setUserId(candidateOfficialInfo.getUserId());
		employee.setDateUpdate(new Date());
		// employee.setEmployeeSkills(employeeSkillList);
		return employee;
	}
	
public List<EmployeeLanguage> languageDtoListToDatabaseModelList(List<CandidateLanguage> candidateLanguageList,Employee employee) {
		
		List<EmployeeLanguage> employeeLanguageList=new ArrayList<EmployeeLanguage>();
		for(CandidateLanguage candidateLanguage:candidateLanguageList)
		{
			employeeLanguageList.add(getLanguage(candidateLanguage,employee));
		}
		return employeeLanguageList;
	}

	public List<EmployeeIdProof> candidateIdProofToEmployeeIdProofConversion(
			List<CandidateIdProof> candidateIdProofList, CandidateOfficialInformation candidateOfficialInfo,
			Long employeeId, Long userId) {
		List<EmployeeIdProof> employeeIdProofList = new ArrayList<EmployeeIdProof>();
		for (CandidateIdProof candidateIdProof : candidateIdProofList) {
			// DateUtils dateUtils = new DateUtils();
			EmployeeIdProof employeeIdProof = new EmployeeIdProof();
			// employeeIdProof.setEmployeeIdProofsId(employeeIdProofDto.getEmployeeIdProofsId());
			// employeeIdProof.setActiveStatus(employeeIdProofDto.getActiveStatus());
			employeeIdProof.setUserId(candidateIdProof.getUserId());
			if (candidateIdProof.getDateFrom() != null) {
				// employeeIdProof.setDateFrom(dateUtils.getDateWirhYYYYMMDD(candidateIdProof.getDateFrom()));
				employeeIdProof.setDateFrom(candidateIdProof.getDateFrom());
			}
			if (candidateIdProof.getDateTo() != null) {
				// employeeIdProof.setDateTo(dateUtils.getDateWirhYYYYMMDD(candidateIdProof.getDateTo()));
				employeeIdProof.setDateTo(candidateIdProof.getDateTo());
			}
			employeeIdProof.setIdTypeId(candidateIdProof.getIdTypeId());
			employeeIdProof.setIdNumber(candidateIdProof.getIdNumber());
			Employee employee = new Employee();
			employee.setEmployeeId(employeeId);
			employeeIdProof.setEmployee(employee);
			employeeIdProof.setDocumentName(candidateIdProof.getDocumentName());
			employeeIdProof.setUserIdUpdate(userId);
			employeeIdProof.setUserId(userId);
			if (candidateIdProof.getDateCreated() != null)
				employeeIdProof.setDateCreated(candidateOfficialInfo.getDateCreated());
			else
				employeeIdProof.setDateCreated(candidateIdProof.getDateCreated());
			employeeIdProof.setDateUpdate(new Date());
			employeeIdProofList.add(employeeIdProof);
		}

		return employeeIdProofList;
	}

	public List<ProfessionalInformation> candidateProfessionalInfoToEmployeeProfessionalInfoConversion(
			List<CandidateProfessionalInformation> candidateProfessionalInformationList,
			CandidateOfficialInformation candidateOfficialInfo, Long employeeId, Long userId) {
		List<ProfessionalInformation> professionalInformationList = new ArrayList<ProfessionalInformation>();
		for (CandidateProfessionalInformation candidateProfessionalInformation : candidateProfessionalInformationList) {
			ProfessionalInformation professionalInformation = new ProfessionalInformation();
			// Long employeeId = Long.parseLong(empId);
			// professionalInformation.setHistoryId(professionalInformationDto.getHistoryId());
			professionalInformation.setOrganizationName(candidateProfessionalInformation.getOrganizationName());
			if (candidateProfessionalInformation.getDateFrom() != null) {
				// professionalInformation.setDateFrom(dateUtils.getDateWirhYYYYMMDD(professionalInformationDto.getDateFrom()));
				professionalInformation.setDateFrom(candidateProfessionalInformation.getDateFrom());
			}
			if (candidateProfessionalInformation.getDateTo() != null) {
				// professionalInformation.setDateTo(dateUtils.getDateWirhYYYYMMDD(professionalInformationDto.getDateTo()));
				professionalInformation.setDateTo(candidateProfessionalInformation.getDateTo());
			}
			professionalInformation.setDesignation(candidateProfessionalInformation.getDesignation());
			professionalInformation.setReportingTo(candidateProfessionalInformation.getReportingTo());
			professionalInformation.setReportingContact(candidateProfessionalInformation.getReportingContact());
			professionalInformation.setAnnualSalary(candidateProfessionalInformation.getAnnualSalary());
			professionalInformation.setReasonForChange(candidateProfessionalInformation.getReasonForChange());
			professionalInformation.setEmployeeId(employeeId);
			professionalInformation.setUserId(userId);
			if (candidateProfessionalInformation.getDateCreated() != null)
				professionalInformation.setDateCreated(candidateOfficialInfo.getDateCreated());
			professionalInformation.setUserIdUpdate(userId);
			professionalInformation.setDateUpdate(new Date());
			professionalInformationList.add(professionalInformation);
		}
		return professionalInformationList;
	}

	public List<EmployeeEducation> candidateEducationToEmployeeEducationConversion(
			List<CandidateEducation> candidateEducationList, CandidateOfficialInformation candidateOfficialInfo,
			Long employeeId, Long userId) {
		List<EmployeeEducation> employeeEducationList = new ArrayList<EmployeeEducation>();
		for (CandidateEducation candidateEducation : candidateEducationList) {
			EmployeeEducation employeeEducation = new EmployeeEducation();

			// Long employeeId=Long.parseLong(empId);
			employeeEducation.setQualificationId(candidateEducation.getQualificationId());
			employeeEducation.setDegreeName(candidateEducation.getDegreeName());
			employeeEducation.setMarksPer(candidateEducation.getMarksPer());
			employeeEducation.setNameOfBoard(candidateEducation.getNameOfBoard());
			employeeEducation.setNameOfInstitution(candidateEducation.getNameOfInstitution());
			employeeEducation.setPassingYear(candidateEducation.getPassingYear());
			employeeEducation.setRegularCorrespondance(candidateEducation.getRegularCorrespondance());
			employeeEducation.setEducationId(candidateEducation.getEducationId());
			employeeEducation.setEmployeeId(employeeId);
			employeeEducation.setUserId(userId);
			Company company = new Company();
			company.setCompanyId(candidateEducation.getCompanyId());
			employeeEducation.setCompany(company);
			Groupg groupg = new Groupg();
			groupg.setGroupId(1l);
			employeeEducation.setGroupg(groupg);
			employeeEducation.setUserIdUpdate(userId);
			if (candidateEducation.getDateCreated() != null)
				employeeEducation.setDateCreated(candidateOfficialInfo.getDateCreated());
			employeeEducation.setDateUpdate(new Date());

			employeeEducationList.add(employeeEducation);
		}
		return employeeEducationList;
	}

	public List<EmployeeFamily> candidateFamilyToEmployeeFamilyConversion(List<CandidateFamily> candidateFamilyList,
			CandidateOfficialInformation candidateOfficialInfo, Long employeeId, Long userId) {
		List<EmployeeFamily> employeeFamilyList = new ArrayList<EmployeeFamily>();

		for (CandidateFamily candidateFamily : candidateFamilyList) {
			employeeFamilyList
					.add(candidateFamilyToDatabaseModel(candidateFamily, candidateOfficialInfo, employeeId, userId));
		}
		return employeeFamilyList;
	}

	public EmployeeFamily candidateFamilyToDatabaseModel(CandidateFamily candidateFamily,
			CandidateOfficialInformation candidateOfficialInfo, Long employeeId, Long userId) {
		EmployeeFamily employeeFamily = new EmployeeFamily();
		// Long employeeId =Long.parseLong(empId);
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeFamily.setEmployee(employee);
		// employeeFamily.setFamilyId(employeeFamilyDto.getFamilyId());
		employeeFamily.setRelation(candidateFamily.getRelation());
		employeeFamily.setCaptions(candidateFamily.getCaptions());
		employeeFamily.setName(candidateFamily.getName());
		employeeFamily.setQualificationId(candidateFamily.getQualificationId());
		employeeFamily.setOccupations(candidateFamily.getOccupations());
		if (candidateFamily.getDateOfBirth() != null)
			employeeFamily.setDateOfBirth(candidateFamily.getDateOfBirth());
		employeeFamily.setContactMobile(candidateFamily.getContactMobile());
		employeeFamily.setContactPhone(candidateFamily.getContactPhone());
		employeeFamily.setUserId(userId);
		if (candidateFamily.getDateCreated() != null)
			employeeFamily.setDateCreated(candidateOfficialInfo.getDateCreated());
		employeeFamily.setDateUpdate(new Date());
		employeeFamily.setUserIdUpdate(userId);
		if (candidateFamily.getCandidateNominees() != null) {
			employeeFamily.setEmployeeNominees(
					candidateNomineeToEmployeeNominee(candidateFamily.getCandidateNominees(), employeeFamily));
		}
		return employeeFamily;
	}

	private List<EmployeeNominee> candidateNomineeToEmployeeNominee(List<CandidateNominee> candidateNomineesList,
			EmployeeFamily employeeFamily) {
		List<EmployeeNominee> employeeNomineeList = new ArrayList<EmployeeNominee>();
		for (CandidateNominee candidateNominee : candidateNomineesList) {
			employeeNomineeList.add(candidateNomineeDtoToDatabaseModel(candidateNominee, employeeFamily));
		}
		return employeeNomineeList;
	}

	private EmployeeNominee candidateNomineeDtoToDatabaseModel(CandidateNominee candidateNominee,
			EmployeeFamily employeeFamily) {
		EmployeeNominee employeeNominee = new EmployeeNominee();

		employeeNominee.setActiveStatus(candidateNominee.getActiveStatus());
		employeeNominee.setEmployeeNomineeid(candidateNominee.getCandidateNomineeid());
		if (candidateNominee.getDateCreated() == null)
			employeeNominee.setDateCreated(new Date());
		else
			employeeNominee.setDateCreated(candidateNominee.getDateCreated());
		employeeNominee.setStaturyHeadId(candidateNominee.getStaturyHeadId());
		employeeNominee.setStaturyHeadName(candidateNominee.getStaturyHeadName());
		employeeNominee.setUserId(candidateNominee.getUserId());
		employeeNominee.setUserIdUpdate(candidateNominee.getUserIdUpdate());
		employeeNominee.setEmployeeFamily(employeeFamily);
		return employeeNominee;
	}

	/*
	 * for (CandidateFamily candidateFamily : candidateFamilyList) { EmployeeFamily
	 * employeeFamily = new EmployeeFamily(); // Long employeeId
	 * =Long.parseLong(empId); Employee employee = new Employee();
	 * employee.setEmployeeId(employeeId); employeeFamily.setEmployee(employee); //
	 * employeeFamily.setFamilyId(employeeFamilyDto.getFamilyId());
	 * employeeFamily.setRelation(candidateFamily.getRelation());
	 * employeeFamily.setCaptions(candidateFamily.getCaptions());
	 * employeeFamily.setName(candidateFamily.getName());
	 * employeeFamily.setQualificationId(candidateFamily.getQualificationId());
	 * employeeFamily.setOccupations(candidateFamily.getOccupations()); if
	 * (candidateFamily.getDateOfBirth() != null &&
	 * !("").equals(candidateFamily.getDateOfBirth()))
	 * employeeFamily.setDateOfBirth(candidateFamily.getDateOfBirth());
	 * employeeFamily.setContactMobile(candidateFamily.getContactMobile());
	 * employeeFamily.setContactPhone(candidateFamily.getContactPhone());
	 * employeeFamily.setUserId(userId); if (candidateFamily.getDateCreated() !=
	 * null) employeeFamily.setDateCreated(candidateOfficialInfo.getDateCreated());
	 * employeeFamily.setDateUpdate(new Date());
	 * employeeFamily.setUserIdUpdate(userId);
	 * employeeFamilyList.add(employeeFamily); } return employeeFamilyList; }
	 */
	public List<EmployeeSkill> candidateSkillToEmployeeSkillconversion(List<CandidateSkill> candidateSkillList,
			CandidateOfficialInformation candidateOfficialInfo, Long employeeId, Long userId) {
		List<EmployeeSkill> employeeSkillList = new ArrayList<EmployeeSkill>();

		for (CandidateSkill candidateSkill : candidateSkillList) {
			EmployeeSkill employeeSkill = new EmployeeSkill();
			Skill skill = new Skill();
			Employee employee = new Employee();
			// employeeSkill.setEmployeeSkillsId(employeeSkillDto.getEmployeeSkillsId());
			skill.setSkillId(candidateSkill.getSkill().getSkillId());
			employeeSkill.setSkill(skill);
			employee.setEmployeeId(employeeId);
			employeeSkill.setUserId(userId);
			employeeSkill.setUserIdUpdate(userId);
			employeeSkill.setEmployee(employee);
			employeeSkill.setActiveStatus(candidateSkill.getActiveStatus());

			employeeSkillList.add(employeeSkill);
		}

		return employeeSkillList;
	}

	public List<EmployeeStatuary> candidateStatouryToEmployeeStatuory(
			CandidateOfficialInformation candidateOfficialInfo, Long employeeId) {
		List<EmployeeStatuary> employeeStatuaryList = new ArrayList<EmployeeStatuary>();
		if (candidateOfficialInfo.getUanNumber() != null && !candidateOfficialInfo.getUanNumber().equals("")) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryNumber(candidateOfficialInfo.getUanNumber());
			employeeStatuary.setStatuaryType("UA");
			employeeStatuary.setDateFrom(candidateOfficialInfo.getPfEnrollDate());
			// employeeStatuary.setDateTo(dateTo);
			employeeStatuaryList.add(employeeStatuary);
		}

		if (candidateOfficialInfo.getPfNumber() != null && !candidateOfficialInfo.getPfNumber().equals("")) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryNumber(candidateOfficialInfo.getPfNumber());
			employeeStatuary.setStatuaryType("PF");
			employeeStatuary.setDateFrom(candidateOfficialInfo.getPfEnrollDate());
			// employeeStatuary.setDateTo(dateTo);
			employeeStatuaryList.add(employeeStatuary);
		}

		if (candidateOfficialInfo.getAccidentalInsurance() != null
				&& !candidateOfficialInfo.getAccidentalInsurance().equals("")) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryNumber(candidateOfficialInfo.getAccidentalInsurance());
			employeeStatuary.setStatuaryType("AC");
			employeeStatuary.setDateFrom(candidateOfficialInfo.getAiFromDate());
			employeeStatuary.setDateTo(candidateOfficialInfo.getAiToDate());
			employeeStatuaryList.add(employeeStatuary);
		}

		if (candidateOfficialInfo.getEsiNumber() != null && !candidateOfficialInfo.getEsiNumber().equals("")) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryNumber(candidateOfficialInfo.getEsiNumber());
			employeeStatuary.setStatuaryType("ES");
			employeeStatuary.setDateFrom(candidateOfficialInfo.getEsiEnrollDate());
			// employeeStatuary.setDateTo(dateTo);
			employeeStatuaryList.add(employeeStatuary);
		}

		if (candidateOfficialInfo.getMedicalInsurance() != null
				&& !candidateOfficialInfo.getMedicalInsurance().equals("")) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryNumber(candidateOfficialInfo.getMedicalInsurance());
			employeeStatuary.setStatuaryType("ME");
			employeeStatuary.setDateFrom(candidateOfficialInfo.getMiFromDate());
			employeeStatuary.setDateTo(candidateOfficialInfo.getMiToDate());
			employeeStatuaryList.add(employeeStatuary);
		}

		for (EmployeeStatuary employeeStatuary : employeeStatuaryList) {
			Employee employee = new Employee();
			employee.setEmployeeId(employeeId);
			employeeStatuary.setUserId(candidateOfficialInfo.getUserId());
			employeeStatuary.setUserIdUpdate(candidateOfficialInfo.getUserId());
			employeeStatuary.setDateCreated(candidateOfficialInfo.getDateCreated());
			employeeStatuary.setDateUpdate(new Date());
			employeeStatuary.setEmployee(employee);
		}

		return employeeStatuaryList;
	}

	public EmployeeBank candidateBankToEmployeeBankConversion(CandidateStatuary candidateStatuary, Long employeeId,
			Long userId) {

		EmployeeBank employeeBank = new EmployeeBank();
		Employee employee = new Employee();
		// employeeBank.setEmployeeBankId(bankDetailsDto.getEmployeeBankId());
		employeeBank.setBankId(candidateStatuary.getBankId());
		employeeBank.setAccountType("SA");
		employeeBank.setAccountNumber(candidateStatuary.getAccountNumber());
		employeeBank.setIfscCode(candidateStatuary.getIfscCode());
		employeeBank.setEmployee(employee);
		employeeBank.setBankBranch(candidateStatuary.getBranch());
		// employeeBank.setEffectiveDate(bankDetailsDto.getEffectiveDate());
		employeeBank.setUserId(userId);
		employee.setEmployeeId(employeeId);
		employeeBank.setEmployee(employee);
		employeeBank.setActiveStatus(candidateStatuary.getActiveStatus());
		// if(bankDetailsDto.getDateCreated()==null)
		employeeBank.setDateCreated(candidateStatuary.getDateCreated());
		employeeBank.setDateUpdate(new Date());
		employeeBank.setUserIdUpdate(userId);
		return employeeBank;

	}

}
