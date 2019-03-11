package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateEducationDTO;
import com.csipl.hrms.model.candidate.CandidateEducation;
import com.csipl.hrms.model.common.Company;

public class CandidateEdcationAdaptor implements Adaptor<CandidateEducationDTO, CandidateEducation> {

	public List<CandidateEducation> candidateEducationDtoToDatabaseModelList(
			List<CandidateEducationDTO> candidateEducationDtoList, String candidateId) {
		List<CandidateEducation> candidateEducationList = new ArrayList<CandidateEducation>();
		for (CandidateEducationDTO candidateEducationDto : candidateEducationDtoList) {
			candidateEducationList.add(candidateEduDtoToDatabaseModel(candidateEducationDto, candidateId));
		}

		return candidateEducationList;
	}

	public CandidateEducation candidateEduDtoToDatabaseModel(CandidateEducationDTO candidateEducationDTO,
			String candidateId) {

		CandidateEducation candidateEducation = new CandidateEducation();
		Long canId = Long.parseLong(candidateId);
		candidateEducation.setQualificationId(candidateEducationDTO.getQualificationId());
		candidateEducation.setDegreeName(candidateEducationDTO.getDegreeName());
		candidateEducation.setMarksPer(candidateEducationDTO.getMarksPer());
		candidateEducation.setNameOfInstitution(candidateEducationDTO.getNameOfInstitution());
		candidateEducation.setNameOfBoard(candidateEducationDTO.getNameOfBoard());
		candidateEducation.setPassingYear(candidateEducationDTO.getPassingYear());
		candidateEducation.setRegularCorrespondance(candidateEducationDTO.getRegularCorrespondance());
		candidateEducation.setDocumentName(candidateEducationDTO.getDocumentName());
		candidateEducation.setCandidateEducationDoc(candidateEducationDTO.getCandidateEducationDoc());
		candidateEducation.setEducationId(candidateEducationDTO.getEducationId());
		candidateEducation.setCandidateId(canId);
		candidateEducation.setUserId(candidateEducationDTO.getUserId());
		candidateEducation.setDateCreated(candidateEducationDTO.getDateCreated());
		Company company = new Company();
		candidateEducation.setCompanyId(candidateEducationDTO.getCompanyId());
		if (candidateEducationDTO.getDateCreated() == null)
			candidateEducation.setDateCreated(new Date());
		else
			candidateEducation.setDateCreated(candidateEducationDTO.getDateCreated());
		candidateEducation.setDateUpdate(new Date());

		return candidateEducation;
	}

	@Override
	public List<CandidateEducation> uiDtoToDatabaseModelList(List<CandidateEducationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateEducationDTO> databaseModelToUiDtoList(List<CandidateEducation> candidateEducationList) {
		List<CandidateEducationDTO> candidateEducationDTOList = new ArrayList<CandidateEducationDTO>();
		for (CandidateEducation candidateEducation : candidateEducationList) {
			candidateEducationDTOList.add(databaseModelToUiDto(candidateEducation));
		}
		return candidateEducationDTOList;
	}

	@Override
	public CandidateEducation uiDtoToDatabaseModel(CandidateEducationDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateEducationDTO databaseModelToUiDto(CandidateEducation candidateEducation) {
		CandidateEducationDTO candidateEducationDTO = new CandidateEducationDTO();
		candidateEducationDTO.setQualificationId(candidateEducation.getQualificationId());
		candidateEducationDTO.setDegreeName(candidateEducation.getDegreeName());
		candidateEducationDTO.setMarksPer(candidateEducation.getMarksPer());
		candidateEducationDTO.setNameOfBoard(candidateEducation.getNameOfBoard());
		candidateEducationDTO.setNameOfInstitution(candidateEducation.getNameOfInstitution());
		candidateEducationDTO.setPassingYear(candidateEducation.getPassingYear());
		candidateEducationDTO.setRegularCorrespondance(candidateEducation.getRegularCorrespondance());
		candidateEducationDTO.setEducationId(candidateEducation.getEducationId());
		candidateEducationDTO.setQualificationIdValue(DropDownCache.getInstance().getDropDownValue(
				DropDownEnum.Qualification.getDropDownName(), candidateEducation.getQualificationId()));
		candidateEducationDTO.setUserId(candidateEducation.getUserId());
		candidateEducationDTO.setDateCreated(candidateEducation.getDateCreated());
		
		candidateEducationDTO.setDocumentName(candidateEducation.getDocumentName());

		candidateEducationDTO.setCandidateEducationDoc(candidateEducation.getCandidateEducationDoc());

		return candidateEducationDTO;
	}

}
