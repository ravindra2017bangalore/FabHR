package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateEducationDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.employee.EmployeeEducation;

public class EmpEducationAdapor implements Adaptor<CandidateEducationDTO, EmployeeEducation> {

	@Override
	public List<EmployeeEducation> uiDtoToDatabaseModelList(List<CandidateEducationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateEducationDTO> databaseModelToUiDtoList(List<EmployeeEducation> employeeEducationList) {
		List<CandidateEducationDTO> candidateEducationDTOList = new ArrayList<CandidateEducationDTO>();
		for (EmployeeEducation employeeEducation : employeeEducationList) {
			candidateEducationDTOList.add(databaseModelToUiDto(employeeEducation));
		}
		return candidateEducationDTOList;
	}

	@Override
	public EmployeeEducation uiDtoToDatabaseModel(CandidateEducationDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateEducationDTO databaseModelToUiDto(EmployeeEducation employeeEducation) {
		CandidateEducationDTO candidateEducationDTO = new CandidateEducationDTO();
		candidateEducationDTO.setQualificationId(employeeEducation.getQualificationId());
		candidateEducationDTO.setDegreeName(employeeEducation.getDegreeName());
		candidateEducationDTO.setMarksPer(employeeEducation.getMarksPer());
		candidateEducationDTO.setNameOfBoard(employeeEducation.getNameOfBoard());
		candidateEducationDTO.setNameOfInstitution(employeeEducation.getNameOfInstitution());
		candidateEducationDTO.setPassingYear(employeeEducation.getPassingYear());
		candidateEducationDTO.setRegularCorrespondance(employeeEducation.getRegularCorrespondance());
		candidateEducationDTO.setQualificationIdValue(DropDownCache.getInstance().getDropDownValue(
				DropDownEnum.Qualification.getDropDownName(), employeeEducation.getQualificationId()));
		candidateEducationDTO.setEducationId(employeeEducation.getEducationId());
		candidateEducationDTO.setUserId(employeeEducation.getUserId());
		candidateEducationDTO.setDateCreated(employeeEducation.getDateCreated());
		candidateEducationDTO.setCandidateId(employeeEducation.getEmployeeId());
		candidateEducationDTO.setDocumentName(employeeEducation.getDocumentName());
		candidateEducationDTO.setCandidateEducationDoc(employeeEducation.getEmployeeEducationDoc());
		
		
		
		return candidateEducationDTO;
	}

	public List<EmployeeEducation> employeeEducationDtoToDatabaseModelList(
			List<CandidateEducationDTO> eduInformationDTOList, String empId) {
		List<EmployeeEducation> employeeEducationList = new ArrayList<EmployeeEducation>();
		for (CandidateEducationDTO eduInformationDTO : eduInformationDTOList) {
			employeeEducationList.add(employeeEduDtoToDatabaseModel(eduInformationDTO, empId));
		}
		return employeeEducationList;
	}

	public EmployeeEducation employeeEduDtoToDatabaseModel(CandidateEducationDTO eduInformationDTO, String empId) {
		EmployeeEducation employeeEducation = new EmployeeEducation();
		Long employeeId = Long.parseLong(empId);
		employeeEducation.setQualificationId(eduInformationDTO.getQualificationId());
		employeeEducation.setDegreeName(eduInformationDTO.getDegreeName());
		employeeEducation.setMarksPer(eduInformationDTO.getMarksPer());
		employeeEducation.setNameOfBoard(eduInformationDTO.getNameOfBoard());
		employeeEducation.setNameOfInstitution(eduInformationDTO.getNameOfInstitution());
		employeeEducation.setPassingYear(eduInformationDTO.getPassingYear());
		employeeEducation.setRegularCorrespondance(eduInformationDTO.getRegularCorrespondance());
		employeeEducation.setEducationId(eduInformationDTO.getEducationId());
		employeeEducation.setEmployeeId(employeeId);
		employeeEducation.setUserId(eduInformationDTO.getUserId());
		employeeEducation.setDateCreated(eduInformationDTO.getDateCreated());
		employeeEducation.setDocumentName(eduInformationDTO.getDocumentName());
		
		employeeEducation.setEmployeeEducationDoc(eduInformationDTO.getCandidateEducationDoc());		
		Company company = new Company();
		company.setCompanyId(eduInformationDTO.getCompanyId());
		employeeEducation.setCompany(company);
		Groupg groupg = new Groupg();
		groupg.setGroupId(1l);
		employeeEducation.setGroupg(groupg);
		employeeEducation.setUserIdUpdate(eduInformationDTO.getUserIdUpdate());
		if (eduInformationDTO.getDateCreated() == null)
			employeeEducation.setDateCreated(new Date());
		else
			employeeEducation.setDateCreated(eduInformationDTO.getDateCreated());
		employeeEducation.setDateUpdate(new Date());
		return employeeEducation;
	}

}
