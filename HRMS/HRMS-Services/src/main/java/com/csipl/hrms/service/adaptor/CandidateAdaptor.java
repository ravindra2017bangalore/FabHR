package com.csipl.hrms.service.adaptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateDTO;
import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.hrms.dto.candidate.ProgressBarDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;

public class CandidateAdaptor implements Adaptor<CandidateDTO, Candidate> {
	AddressAdaptor addressAdaptor = new AddressAdaptor();

	@Override
	public List<Candidate> uiDtoToDatabaseModelList(List<CandidateDTO> uiobj) {
		return null;
	}

	@Override
	public List<CandidateDTO> databaseModelToUiDtoList(List<Candidate> dbobj) {
		return null;
	}

	@Override
	public Candidate uiDtoToDatabaseModel(CandidateDTO candidateDto) {
		Candidate candidate = new Candidate();
		Designation designation = new Designation();
		Department department = new Department();

		candidate.setFirstName(candidateDto.getFirstName());
		candidate.setMiddleName(candidateDto.getMiddleName());
		candidate.setLastName(candidateDto.getLastName());
		candidate.setMobile(candidateDto.getMobile());
		candidate.setEmailId(candidateDto.getEmailId());
		candidate.setCityId(candidateDto.getCityId());
		candidate.setShiftId(candidateDto.getShiftId());
		candidate.setPatternId(candidateDto.getPatternId());
		department.setDepartmentId(candidateDto.getDepartmentId());
		candidate.setDepartment(department);
		designation.setDesignationId(candidateDto.getDesignationId());
		candidate.setDesignation(designation);
		candidate.setReportingToEmployee(candidateDto.getReportingToEmployee());
		candidate.setDateOfJoining(candidateDto.getDateOfJoining());
		candidate.setContractStartDate(candidateDto.getContractStartDate());
		candidate.setContractOverDate(candidateDto.getContractOverDate());
		candidate.setTimeContract(candidateDto.getTimeContract());
   		candidate.setCompanyId(candidateDto.getCompanyId());
		candidate.setUserId(1l);
		candidate.setCheckApproach(candidateDto.getCheckApproach());
		
		if(candidateDto.getCandidateId() != null){
			candidate.setCandidateId(candidateDto.getCandidateId());
 			candidate.setCandidateStatus(candidateDto.getCandidateStatus());
			candidate.setCandidateCode(candidateDto.getCandidateCode());
			candidate.setCandidateLogoPath(candidateDto.getCandidateLogoPath());
 		}
		else{
			if (candidateDto.getCheckApproach() == 1) {
				candidate.setCandidateStatus("IN");
				System.out.println(candidate.getCandidateStatus());
			} else
				candidate.setCandidateStatus("PN");
		}
 		return candidate;
	}
	public Candidate uiDtoToCandidateModel1(CandidateDTO candidateDto, Candidate newJoinee) {
		Candidate candidate = new Candidate();
		Department department = new Department();

		candidate.setCandidateId(candidateDto.getCandidateId());
		candidate.setFirstName(candidateDto.getFirstName());
		candidate.setMiddleName(candidateDto.getMiddleName());
		candidate.setLastName(candidateDto.getLastName());
		candidate.setMobile(candidateDto.getMobile());
		candidate.setEmailId(candidateDto.getEmailId());
		candidate.setCityId(candidateDto.getCityId());
		candidate.setShiftId(candidateDto.getShiftId());
		candidate.setPatternId(candidateDto.getPatternId());
		department.setDepartmentId(candidateDto.getDepartmentId());
		candidate.setDepartment(department);
		Designation designation = new Designation();
		designation.setDesignationId(candidateDto.getDesignationId());
		candidate.setDesignation(designation);
		candidate.setReportingToEmployee(candidateDto.getReportingToEmployee());
		candidate.setDateOfJoining(candidateDto.getDateOfJoining());
		candidate.setContractStartDate(candidateDto.getContractStartDate());
		candidate.setContractOverDate(candidateDto.getContractOverDate());
		candidate.setTimeContract(candidateDto.getTimeContract());
		// candidate.setDateOfBirth(candidateDto.getDateOfBirth());
		// candidate.setGender(candidateDto.getGender());
		// candidate.setBloodGroup(candidateDto.getBloodGroup());
		// candidate.setMaritalStatus(candidateDto.getMaritalStatus());
		//
		// candidate.setAnniversaryDate(candidateDto.getAnniversaryDate());
		System.out.println("=========================" + candidateDto.getCheckApproach());
		if (candidateDto.getCheckApproach() == 1) {
			candidate.setCandidateStatus("IN");
			System.out.println(candidate.getCandidateStatus());
		} else
			candidate.setCandidateStatus("PN");

		System.out.println(candidate.getCandidateStatus());

		candidate.setCompanyId(candidateDto.getCompanyId());
		candidate.setUserId(1l);
		candidate.setCheckApproach(candidateDto.getCheckApproach());
		return candidate;
	}
 
		
 	public Candidate uiDtoToCandidateModel(CandidateDTO candidateDto, Candidate newJoinee) {
		Candidate candidate = new Candidate();

		if (candidateDto.getCandidateId() != null && candidateDto.getFirstName() != null) {
			System.out.println("if block...");
			candidate.setCandidateId(candidateDto.getCandidateId());
			candidate.setFirstName(candidateDto.getFirstName());
			candidate.setMiddleName(candidateDto.getMiddleName());
			candidate.setLastName(candidateDto.getLastName());
			candidate.setEmailId(candidateDto.getEmailId());
			candidate.setCityId(candidateDto.getCityId());
			candidate.setShiftId(candidateDto.getShiftId());
			candidate.setPatternId(candidateDto.getPatternId());
			Department department = new Department();
			department.setDepartmentId(candidateDto.getDepartmentId());
			candidate.setDepartment(department);
			Designation designation = new Designation();
			designation.setDesignationId(candidateDto.getDesignationId());
			candidate.setDesignation(designation);
			candidate.setReportingToEmployee(candidateDto.getReportingToEmployee());
			candidate.setDateOfJoining(candidateDto.getDateOfJoining());
			candidate.setContractStartDate(candidateDto.getContractStartDate());
			candidate.setContractOverDate(candidateDto.getContractOverDate());
			candidate.setTimeContract(candidateDto.getTimeContract());
			candidate.setCandidateCode(candidateDto.getCandidateCode());

		} else {

			if (candidateDto.getCandidateId() != null && candidateDto.getFirstName() != null) {
				System.out.println("adaptor in if block");
				candidate.setCandidateId(candidateDto.getCandidateId());
				candidate.setFirstName(candidateDto.getFirstName());
				candidate.setMiddleName(candidateDto.getMiddleName());
				candidate.setLastName(candidateDto.getLastName());
				candidate.setEmailId(candidateDto.getEmailId());
				candidate.setCityId(candidateDto.getCityId());
				candidate.setShiftId(candidateDto.getShiftId());
				candidate.setPatternId(candidateDto.getPatternId());
				Designation designation = new Designation();
				designation.setDesignationId(candidateDto.getDesignationId());
				candidate.setDesignation(designation);
				Department department = new Department();
				department.setDepartmentId(candidateDto.getDepartmentId());
				candidate.setDepartment(department);
				candidate.setReportingToEmployee(candidateDto.getReportingToEmployee());
				candidate.setDateOfJoining(candidateDto.getDateOfJoining());
				candidate.setContractStartDate(candidateDto.getContractStartDate());
				candidate.setContractOverDate(candidateDto.getContractOverDate());
				candidate.setTimeContract(candidateDto.getTimeContract());
				candidate.setCandidateStatus(candidateDto.getCandidateStatus());
			} else {
				System.out.println("adaptor in else block candidateID.." + newJoinee.getCandidateId()
						+ "newJoinee.getFirstName()).." + newJoinee.getFirstName() + "newJoinee.getLastName()."
						+ newJoinee.getLastName());

				candidate.setCandidateId(newJoinee.getCandidateId());
				candidate.setFirstName(newJoinee.getFirstName());
				candidate.setMiddleName(newJoinee.getMiddleName());
				candidate.setLastName(newJoinee.getLastName());
				candidate.setEmailId(newJoinee.getEmailId());
				candidate.setCityId(newJoinee.getCityId());
				candidate.setShiftId(newJoinee.getShiftId());
				candidate.setPatternId(newJoinee.getPatternId());
				Designation designation = new Designation();
				designation.setDesignationId(newJoinee.getDesignation().getDesignationId());
				candidate.setDesignation(designation);
				Department department = new Department();
				department.setDepartmentId(newJoinee.getDepartment().getDepartmentId());
				candidate.setDepartment(department);
				candidate.setReportingToEmployee(newJoinee.getReportingToEmployee());
				candidate.setDateOfJoining(newJoinee.getDateOfJoining());
				candidate.setContractStartDate(newJoinee.getContractStartDate());
				candidate.setContractOverDate(newJoinee.getContractOverDate());
				candidate.setTimeContract(newJoinee.getTimeContract());
				candidate.setCompanyId(newJoinee.getCompanyId());
				candidate.setCandidateStatus(newJoinee.getCandidateStatus());
				candidate.setUserId(newJoinee.getUserId());
			}
			System.out.println("candidateDto.getGender().." + candidateDto.getGender()
					+ "candidateDto.getBloodGroup().." + candidateDto.getBloodGroup()
					+ "candidateDto.getMaritalStatus().." + candidateDto.getMaritalStatus() + "");
			candidate.setDateOfBirth(candidateDto.getDateOfBirth());
			candidate.setGender(candidateDto.getGender());
			candidate.setBloodGroup(candidateDto.getBloodGroup());
			candidate.setMaritalStatus(candidateDto.getMaritalStatus());
			candidate.setMobile(candidateDto.getMobile());
			if (candidateDto.getPermanentAddressDto() != null
					&& candidateDto.getPermanentAddressDto().getCityId() != null) {
				candidate.setAddress1(addressAdaptor.uiDtoToDatabaseModel(candidateDto.getPermanentAddressDto()));
			}

			if (candidateDto.getPresentAddressDto() != null
					&& candidateDto.getPresentAddressDto().getCityId() != null) {
				candidate.setAddress2(addressAdaptor.uiDtoToDatabaseModel(candidateDto.getPresentAddressDto()));
			}

			if (candidateDto.getReferenceAddressDto() != null
					&& candidateDto.getReferenceAddressDto().getCityId() != null
					&& candidateDto.getReferenceAddressDto().getEmailId() != null) {
				candidate.setAddress3(addressAdaptor.uiDtoToDatabaseModel(candidateDto.getReferenceAddressDto()));
			}
			candidate.setAnniversaryDate(candidateDto.getAnniversaryDate());
			candidate.setReferenceName(candidateDto.getReferenceName());
			// candidate.setCompanyId(candidateDto.getCompanyId());
			candidate.setUserIdUpdate(candidateDto.getUserId());
		}
		candidate.setCompanyId(candidateDto.getCompanyId());
		candidate.setCandidateStatus(candidateDto.getCandidateStatus());
		candidate.setCandidateCode(candidateDto.getCandidateCode());
		candidate.setCandidateLogoPath(candidateDto.getCandidateLogoPath());
		
		return candidate;
	}

	@Override
	public CandidateDTO databaseModelToUiDto(Candidate candidate) {

		CandidateDTO candidateDto = new CandidateDTO();

		candidateDto.setCandidateId(candidate.getCandidateId());
		candidateDto.setFirstName(candidate.getFirstName());
		candidateDto.setMiddleName(candidate.getMiddleName());
		candidateDto.setLastName(candidate.getLastName());
		candidateDto.setMobile(candidate.getMobile());
		candidateDto.setCityId(candidate.getCityId());
		candidateDto.setShiftId(candidate.getShiftId());
		candidateDto.setPatternId(candidate.getPatternId());

		// candidateDto.setDesignationId(candidate.getDesignation().getDesignationId());
		// candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());
		System.out.println("candidate Status from DTO,,,,..." + candidate.getCandidateStatus());

		// candidateDto.setDesignationId(candidate.getDesignation().getDesignationId());
		// candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());

		candidateDto.setReportingToEmployee(candidate.getReportingToEmployee());
		candidateDto.setDateOfJoining(candidate.getDateOfJoining());
		candidateDto.setContractStartDate(candidate.getContractStartDate());
		candidateDto.setContractOverDate(candidate.getContractOverDate());
		candidateDto.setTimeContract(candidate.getTimeContract());
		candidateDto.setEmailId(candidate.getEmailId());
		// candidateDto.setDateOfBirth(candidate.getDateOfBirth());
		// candidateDto.setGender(candidate.getGender());
		// candidateDto.setGenderValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(),
		// candidate.getGender()));
		candidateDto.setActiveStatus(candidate.getActiveStatus());
		// candidateDto.setAdharNumber(candidate.getAdharNumber());
		// candidateDto.setAnniversaryDate(candidate.getAnniversaryDate());
		// candidateDto.setBloodGroup(candidate.getBloodGroup());
		candidateDto.setCandidateStatus(candidate.getCandidateStatus());
		candidateDto.setCandidateLogoPath(candidate.getCandidateLogoPath());

		/*
		 * if(candidate.getMaritalStatus()!=null) {
		 * candidateDto.setMaritalStatus(candidate.getMaritalStatus());
		 * candidateDto.setMaritalStatusValue(DropDownCache.getInstance().
		 * getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(),
		 * candidate.getMaritalStatus())); }
		 */

		// candidateDto.setNoticePeriodDays(candidate.getNoticePeriodDays());
		candidateDto.setCandidateCode(candidate.getCandidateCode());

		if (candidate.getDepartment() != null) {
			candidateDto.setDepartmentId(candidate.getDepartment().getDepartmentId());
			candidateDto.setDepartmentName(candidate.getDepartment().getDepartmentName());
		}
		candidateDto.setCheckApproach(candidate.getCheckApproach());

		System.out.println(candidateDto.getCheckApproach());
		if (candidate.getTimeContract() == "FT") {
			candidateDto.setTimeContractValue("Full Time");
		} else
			candidateDto.setTimeContractValue("Part Time");
		System.out.println("timecontract value.." + candidateDto.getTimeContractValue());
		if (candidate.getDesignation() != null) {
			candidateDto.setDesignationId((candidate.getDesignation().getDesignationId()));
			candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());
		}
		System.out.println("candidateDto.designation.." + candidateDto.getDesignationName());
		candidateDto.setCandidateId(candidate.getCandidateId());

		return candidateDto;
	}

	public CandidateDTO databaseModelToCandidateDto(Candidate candidate, Employee employee, String shiftName,
			String patternName) {

		CandidateDTO candidateDto = new CandidateDTO();
		candidateDto.setShiftName(shiftName);
		candidateDto.setPatternName(patternName);
		candidateDto.setCandidateId(candidate.getCandidateId());
		candidateDto.setFirstName(candidate.getFirstName());
		candidateDto.setMiddleName(candidate.getMiddleName());
		candidateDto.setLastName(candidate.getLastName());
		candidateDto.setMobile(candidate.getMobile());
		candidateDto.setCityId(candidate.getCityId());
		candidateDto.setShiftId(candidate.getShiftId());
		candidateDto.setPatternId(candidate.getPatternId());
		// candidateDto.setDesignationId(candidate.getDesignation().getDesignationId());
		// candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());
		System.out.println("candidate Status from DTO,,,,..." + candidate.getCandidateStatus());
		candidateDto.setReportingToEmployee(candidate.getReportingToEmployee());
		candidateDto.setDateOfJoining(candidate.getDateOfJoining());
		candidateDto.setContractStartDate(candidate.getContractStartDate());
		candidateDto.setContractOverDate(candidate.getContractOverDate());
		candidateDto.setTimeContract(candidate.getTimeContract());
		candidateDto.setEmailId(candidate.getEmailId());
		// candidateDto.setDateOfBirth(candidate.getDateOfBirth());
		// candidateDto.setGender(candidate.getGender());
		// candidateDto.setGenderValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(),
		// candidate.getGender()));
		candidateDto.setActiveStatus(candidate.getActiveStatus());
		// candidateDto.setAdharNumber(candidate.getAdharNumber());
		// candidateDto.setAnniversaryDate(candidate.getAnniversaryDate());
		// candidateDto.setBloodGroup(candidate.getBloodGroup());
		candidateDto.setCandidateStatus(candidate.getCandidateStatus());
		candidateDto.setCandidateLogoPath(candidate.getCandidateLogoPath());
		/*
		 * if(candidate.getMaritalStatus()!=null) {
		 * candidateDto.setMaritalStatus(candidate.getMaritalStatus());
		 * candidateDto.setMaritalStatusValue(DropDownCache.getInstance().
		 * getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(),
		 * candidate.getMaritalStatus())); }
		 */

		// candidateDto.setNoticePeriodDays(candidate.getNoticePeriodDays());
		candidateDto.setCandidateCode(candidate.getCandidateCode());

		if (candidate.getDepartment() != null) {
			candidateDto.setDepartmentId(candidate.getDepartment().getDepartmentId());
			candidateDto.setDepartmentName(candidate.getDepartment().getDepartmentName());
		}
		candidateDto.setCheckApproach(candidate.getCheckApproach());
		System.out.println("candidate.getTimeContract()>>>.." + candidate.getTimeContract());

		System.out.println(candidateDto.getCheckApproach());
		if (candidate.getTimeContract().equals("PT")) {
			candidateDto.setTimeContractValue("Part Time");
 		} else  
			candidateDto.setTimeContractValue("Full Time");
		System.out.println("timecontract value.." + candidateDto.getTimeContractValue());
		if (candidate.getDesignation() != null) {
			candidateDto.setDesignationId((candidate.getDesignation().getDesignationId()));
			candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());
		}
		System.out.println("candidateDto.designation.." + candidateDto.getDesignationName());
		candidateDto.setCandidateId(candidate.getCandidateId());
		candidateDto.setReportingToemployeeName(employee.getFirstName() + " " + employee.getLastName());
		candidateDto.setReportingToemployeeDesignation(employee.getDesignation().getDesignationName());
		System.out.println("candidateDto.neme" + candidateDto.getReportingToemployeeName());

		/*
		 * if(candidate.getMaritalStatus()!=null) {
		 * candidateDto.setMaritalStatus(candidate.getMaritalStatus());
		 * candidateDto.setMaritalStatusValue(DropDownCache.getInstance().
		 * getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(),
		 * candidate.getMaritalStatus())); }
		 */

		// candidateDto.setNoticePeriodDays(candidate.getNoticePeriodDays());
		candidateDto.setCandidateCode(candidate.getCandidateCode());
		/*
		 * if (candidate.getAddress1() != null) {
		 * candidateDto.setPermanentAddress(addressAdaptor.databaseModelToUiDto(
		 * candidate.getAddress1()));
		 * candidateDto.setPermanentAddressValue(candidate.getAddress1().getAddressText(
		 * )+","+candidate.getAddress1().getCity().getCityName()+","+candidate.
		 * getAddress1().getState().getStateName());
		 * 
		 * } if (candidate.getAddress1() != null) {
		 * candidateDto.setPresentAddress(addressAdaptor.databaseModelToUiDto(candidate.
		 * getAddress2()));
		 * candidateDto.setPermanentAddressValue(candidate.getAddress2().getAddressText(
		 * )+","+candidate.getAddress2().getCity().getCityName()+","+candidate.
		 * getAddress2().getState().getStateName());
		 * 
		 * } if (candidate.getAddress3() != null) {
		 * candidateDto.setReferenceAddress(addressAdaptor.databaseModelToUiDto(
		 * candidate.getAddress3()));
		 * candidateDto.setPermanentAddressValue(candidate.getAddress3().getAddressText(
		 * )+","+candidate.getAddress3().getCity().getCityName()+","+candidate.
		 * getAddress3().getState().getStateName()); }
		 */
		if (candidate.getDepartment() != null) {
			candidateDto.setDepartmentId(candidate.getDepartment().getDepartmentId());
			candidateDto.setDepartmentName(candidate.getDepartment().getDepartmentName());
		}
		candidateDto.setCheckApproach(candidate.getCheckApproach());

		System.out.println(candidateDto.getCheckApproach());
		if (candidate.getDesignation() != null) {
			candidateDto.setDesignationId((candidate.getDesignation().getDesignationId()));
			candidateDto.setDesignationName(candidate.getDesignation().getDesignationName());
		}
		System.out.println("candidateDto.designation.." + candidateDto.getDesignationName());
		candidateDto.setCandidateId(candidate.getCandidateId());
		return candidateDto;

	}

	public List<CandidateDTO> modeltoDTOList(List<Object[]> candidateList, CandidateSearchDTO candidateSearcDto) {
		List<CandidateDTO> candidateDtoList = new ArrayList<CandidateDTO>();

		for (Object[] candidateObj : candidateList) {
			CandidateDTO candidate = new CandidateDTO();

			if (candidateObj[0] != null) {
				candidate.setFirstName(candidateObj[0].toString());
			}

			if (candidateObj[1] != null) {
				candidate.setLastName(candidateObj[1].toString());
				candidate.setCharFirstName(Character.toString(candidate.getFirstName().charAt(0)).toUpperCase());
				candidate.setCharLastName(Character.toString(candidate.getLastName().charAt(0)).toUpperCase());
			}
			if (candidateObj[2] != null) {
				candidate.setMobile(candidateObj[2].toString());
			}

			if (candidateObj[3] != null) {
				candidate.setEmailId(candidateObj[3].toString());
			}

			if (candidateObj[4] != null) {
				candidate.setCandidateLogoPath(candidateObj[4].toString());
			}

			if (candidateObj[5] != null) {
				candidate.setCandidateReson(candidateObj[5].toString());
			}

			if (candidateObj[6] != null) {
				candidate.setCandidateId((candidateObj[6] != null ? Long.parseLong(candidateObj[6].toString()) : null));
			}
			
			if (candidateObj[7] != null) {
				candidate.setDesignationName(candidateObj[7].toString());
			}

			candidateDtoList.add(candidate);

		}

		return candidateDtoList;
	}

	public List<Long> validationConvert(List<Object[]> tabValidtionList) {
		List<Long> tabValidation = new ArrayList<Long>();
		for(Object[] tabObj :tabValidtionList) {
			if (tabObj[0] != null) {
				Long candidateProfessionalID=tabObj[0] != null ? Long.parseLong(tabObj[0].toString()) : null;
				tabValidation.add(candidateProfessionalID);
			}
			if (tabObj[1] != null) {
				Long candidateIdProofsID=tabObj[1] != null ? Long.parseLong(tabObj[1].toString()) : null;
				tabValidation.add(candidateIdProofsID);
			}
			if (tabObj[2] != null) {
				Long candidateFamilyID=tabObj[2] != null ? Long.parseLong(tabObj[2].toString()) : null;
				tabValidation.add(candidateFamilyID);
			}
			if (tabObj[3] != null) {
				Long candidateStatuaryID=tabObj[3] != null ? Long.parseLong(tabObj[3].toString()) : null;
				tabValidation.add(candidateStatuaryID);
			}
		}
		return tabValidation;
	}

	public ProgressBarDTO databaseModelToUiDtoProgressBar(List<Object[]> progressBarObj) {
		ProgressBarDTO	progressBarDto=new ProgressBarDTO();
		Long professionalBar = 0l, idAddressProof = 0l, personalBar = 0l, educationBar = 0l, familyBar = 0l,
				statutoryBar = 0l, candidateBar = 0l;

		for (Object[] objects : progressBarObj) {
			personalBar = objects[0] != null ? Long.parseLong(objects[0].toString()) : 0;
			idAddressProof = objects[1] != null ? Long.parseLong(objects[1].toString()) : 0;
			professionalBar = objects[2] != null ? Long.parseLong(objects[2].toString()) : 0;
			educationBar = objects[3] != null ? Long.parseLong(objects[3].toString()) : 0;
			familyBar = objects[4] != null ? Long.parseLong(objects[4].toString()) : 0;
			statutoryBar = objects[5] != null ? Long.parseLong(objects[5].toString()) : 0;
			candidateBar = objects[6] != null ? Long.parseLong(objects[6].toString()) : 0;
		}

		progressBarDto.setCandidateBar(candidateBar);
		progressBarDto.setPersonalBar(personalBar);
		progressBarDto.setIdAddressProof(idAddressProof);
		progressBarDto.setProfessionalBar(professionalBar);
		progressBarDto.setEducationBar(educationBar);
		progressBarDto.setFamilyBar(familyBar);
		progressBarDto.setStatutoryBar(statutoryBar);		
		return progressBarDto;
	}

}