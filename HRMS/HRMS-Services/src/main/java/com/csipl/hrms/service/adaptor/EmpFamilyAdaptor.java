package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateFamilyDTO;
import com.csipl.hrms.dto.candidate.CandidateNomineeDTO;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.model.employee.EmployeeNominee;

public class EmpFamilyAdaptor implements Adaptor<CandidateFamilyDTO, EmployeeFamily> {

	@Override
	public List<EmployeeFamily> uiDtoToDatabaseModelList(List<CandidateFamilyDTO> candidateFamilyDtoList) {
		List<EmployeeFamily> employeeFamilyList = new ArrayList<EmployeeFamily>();
		for (CandidateFamilyDTO candidateFamilyDto : candidateFamilyDtoList) {
			EmployeeFamily employeeFamily = new EmployeeFamily();
			Employee employee = new Employee();
			employee.setEmployeeId(candidateFamilyDto.getCandidateId());
			employeeFamily.setEmployee(employee);
			if (candidateFamilyDto.getDateCreated() == null)
				employeeFamily.setDateCreated(new Date());
			else
				employeeFamily.setDateCreated(candidateFamilyDto.getDateCreated());
			employeeFamily.setCaptions(candidateFamilyDto.getCaptions());
			employeeFamily.setContactMobile(candidateFamilyDto.getContactMobile());
			employeeFamily.setContactPhone(candidateFamilyDto.getContactPhone());
			employeeFamily.setDateOfBirth(candidateFamilyDto.getDateOfBirth());
			employeeFamily.setDateUpdate(candidateFamilyDto.getDateUpdate());
			employeeFamily.setFamilyId(candidateFamilyDto.getFamilyId());
			employeeFamily.setQualificationId(candidateFamilyDto.getQualificationId());
			employeeFamily.setOccupations(candidateFamilyDto.getOccupations());
			employeeFamily.setRelation(candidateFamilyDto.getRelation());
			employeeFamily.setName(candidateFamilyDto.getName());
			employeeFamily.setUserId(candidateFamilyDto.getUserId());
			if (candidateFamilyDto.getCandidateNomineeDto() != null)
				employeeFamily.setEmployeeNominees(uiCandidateNomineeDtoToDatabaseModelList(
						candidateFamilyDto.getCandidateNomineeDto(), employeeFamily));
		}
		return employeeFamilyList;
	}

	private List<EmployeeNominee> uiCandidateNomineeDtoToDatabaseModelList(
			List<CandidateNomineeDTO> candidateNomineeDtoList, EmployeeFamily employeeFamily) {
		List<EmployeeNominee> employeeNomineeList = new ArrayList<EmployeeNominee>();
		for (CandidateNomineeDTO candidateNomineeDto : candidateNomineeDtoList) {
			employeeNomineeList.add(uiCandidateNomineeDtoToDatabaseModel(candidateNomineeDto, employeeFamily));
		}

		return employeeNomineeList;
	}

	private EmployeeNominee uiCandidateNomineeDtoToDatabaseModel(CandidateNomineeDTO candidateNomineeDto,
			EmployeeFamily employeeFamily) {
		EmployeeNominee employeeNominee = new EmployeeNominee();
		employeeNominee.setActiveStatus(candidateNomineeDto.getActiveStatus());
		employeeNominee.setEmployeeNomineeid(candidateNomineeDto.getCandidateNomineeid());
		if (candidateNomineeDto.getDateCreated() == null)
			employeeNominee.setDateCreated(new Date());
		else
			employeeNominee.setDateCreated(candidateNomineeDto.getDateCreated());
		employeeNominee.setStaturyHeadId(candidateNomineeDto.getStaturyHeadId());
		employeeNominee.setStaturyHeadName(candidateNomineeDto.getStaturyHeadName());
		employeeNominee.setUserId(candidateNomineeDto.getUserId());
		employeeNominee.setUserIdUpdate(candidateNomineeDto.getUserIdUpdate());
		employeeNominee.setEmployeeFamily(employeeFamily);
		return employeeNominee;
	}

	@Override
	public List<CandidateFamilyDTO> databaseModelToUiDtoList(List<EmployeeFamily> empFamilyList) {
		List<CandidateFamilyDTO> candidateFamilyDTOList = new ArrayList<CandidateFamilyDTO>();
		for (EmployeeFamily employeeFamily : empFamilyList) {
			candidateFamilyDTOList.add(databaseModelToUiDto(employeeFamily));
		}
		return candidateFamilyDTOList;
	}

	@Override
	public EmployeeFamily uiDtoToDatabaseModel(CandidateFamilyDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateFamilyDTO databaseModelToUiDto(EmployeeFamily empFamily) {
		CandidateFamilyDTO candidateFamilyDTO = new CandidateFamilyDTO();
		/// candidateFamilyDTO.setCompanyId(empFamily.getCandidateId());
		candidateFamilyDTO.setContactMobile(empFamily.getContactMobile());
		candidateFamilyDTO.setDateCreated(empFamily.getDateCreated());
		candidateFamilyDTO.setContactPhone(empFamily.getContactPhone());
		candidateFamilyDTO.setFamilyId(empFamily.getFamilyId());
		candidateFamilyDTO.setCandidateId(empFamily.getEmployee().getEmployeeId());
		candidateFamilyDTO.setDateOfBirth(empFamily.getDateOfBirth());
		candidateFamilyDTO.setCaptions(empFamily.getCaptions());
		candidateFamilyDTO.setCaptionsValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Captions.getDropDownName(),empFamily.getCaptions()));
		candidateFamilyDTO.setName(empFamily.getName());
		candidateFamilyDTO.setOccupations(empFamily.getOccupations());
		candidateFamilyDTO.setQualificationId(empFamily.getQualificationId());
		candidateFamilyDTO.setRelation(empFamily.getRelation());
		candidateFamilyDTO.setRelationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Relation.getDropDownName(), empFamily.getRelation()));
		candidateFamilyDTO.setQualificationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Qualification.getDropDownName(), empFamily.getQualificationId()));
		candidateFamilyDTO.setOccupationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Occupation.getDropDownName(), empFamily.getOccupations()));
		if (empFamily.getEmployeeNominees() != null)
			candidateFamilyDTO.setCandidateNomineeDto(
					employeeNomineeDatabaseModelToUiDtoList(empFamily.getEmployeeNominees(), empFamily.getFamilyId()));

		return candidateFamilyDTO;
	}

	private List<CandidateNomineeDTO> employeeNomineeDatabaseModelToUiDtoList(
			List<EmployeeNominee> employeeNomineesList, Long familyId) {
		List<CandidateNomineeDTO> candidateNomineeDTOList = new ArrayList<CandidateNomineeDTO>();
		for (EmployeeNominee employeeNominee : employeeNomineesList) {
			CandidateNomineeDTO candidateNomineeDto = employeeNomineeDatabaseModelToUiDto(employeeNominee);
			candidateNomineeDto.setFamilyId(familyId);
			candidateNomineeDTOList.add(candidateNomineeDto);
		}
		return candidateNomineeDTOList;
	}

	private CandidateNomineeDTO employeeNomineeDatabaseModelToUiDto(EmployeeNominee employeeNominee) {

		CandidateNomineeDTO candidateNomineeDTO = new CandidateNomineeDTO();

		candidateNomineeDTO.setCandidateNomineeid(employeeNominee.getEmployeeNomineeid());
		candidateNomineeDTO.setActiveStatus(employeeNominee.getActiveStatus());
		candidateNomineeDTO.setDateCreated(employeeNominee.getDateCreated());
		candidateNomineeDTO.setStaturyHeadId(employeeNominee.getStaturyHeadId());
		candidateNomineeDTO.setStaturyHeadName(employeeNominee.getStaturyHeadName());
		candidateNomineeDTO.setUserId(employeeNominee.getUserId());
		candidateNomineeDTO.setUserIdUpdate(employeeNominee.getUserIdUpdate());

		return candidateNomineeDTO;

	}
}