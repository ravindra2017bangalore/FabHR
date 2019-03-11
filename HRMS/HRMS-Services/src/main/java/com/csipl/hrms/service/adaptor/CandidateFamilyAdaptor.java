package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateFamilyDTO;
import com.csipl.hrms.dto.candidate.CandidateNomineeDTO;
import com.csipl.hrms.model.candidate.CandidateFamily;
import com.csipl.hrms.model.candidate.CandidateNominee;

public class CandidateFamilyAdaptor implements Adaptor<CandidateFamilyDTO, CandidateFamily> {

	@Override
	public List<CandidateFamily> uiDtoToDatabaseModelList(List<CandidateFamilyDTO> candidateFamilyDTOList) {

		List<CandidateFamily> candidateFamilyList = new ArrayList<CandidateFamily>();
		for (CandidateFamilyDTO candidateFamilyDTO : candidateFamilyDTOList) {
			candidateFamilyList.add(uiDtoToDatabaseModel(candidateFamilyDTO));
		}
		return candidateFamilyList;
	}

	@Override
	public List<CandidateFamilyDTO> databaseModelToUiDtoList(List<CandidateFamily> candidateFamilyList) {

		List<CandidateFamilyDTO> candidateFamilyDTOList = new ArrayList<CandidateFamilyDTO>();
		for (CandidateFamily candidateFamily : candidateFamilyList) {
			candidateFamilyDTOList.add(databaseModelToUiDto(candidateFamily));
		}
		return candidateFamilyDTOList;
	}

	@Override
	public CandidateFamily uiDtoToDatabaseModel(CandidateFamilyDTO candidateFamilyDTO) {

		CandidateFamily candidateFamily = new CandidateFamily();
		candidateFamily.setCandidateId(candidateFamilyDTO.getCandidateId());
		candidateFamily.setCompanyId(candidateFamilyDTO.getCompanyId());
		if (candidateFamilyDTO.getDateCreated() == null)
			candidateFamily.setDateCreated(new Date());
		else
			candidateFamily.setDateCreated(candidateFamilyDTO.getDateCreated());
		candidateFamily.setCaptions(candidateFamilyDTO.getCaptions());
		candidateFamily.setContactMobile(candidateFamilyDTO.getContactMobile());
		candidateFamily.setContactPhone(candidateFamilyDTO.getContactPhone());
		candidateFamily.setDateOfBirth(candidateFamilyDTO.getDateOfBirth());
		candidateFamily.setDateUpdate(candidateFamilyDTO.getDateUpdate());
		candidateFamily.setFamilyId(candidateFamilyDTO.getFamilyId());
		candidateFamily.setQualificationId(candidateFamilyDTO.getQualificationId());
		candidateFamily.setOccupations(candidateFamilyDTO.getOccupations());
		candidateFamily.setRelation(candidateFamilyDTO.getRelation());
		candidateFamily.setName(candidateFamilyDTO.getName());
		candidateFamily.setUserId(candidateFamilyDTO.getUserId());
		if (candidateFamilyDTO.getCandidateNomineeDto() != null)
			candidateFamily.setCandidateNominees(uiCandidateNomineeDtoToDatabaseModelList(
					candidateFamilyDTO.getCandidateNomineeDto(), candidateFamily));
		return candidateFamily;
	}

	@Override
	public CandidateFamilyDTO databaseModelToUiDto(CandidateFamily candidateFamily) {

		CandidateFamilyDTO candidateFamilyDTO = new CandidateFamilyDTO();
		candidateFamilyDTO.setCompanyId(candidateFamily.getCandidateId());
		candidateFamilyDTO.setContactMobile(candidateFamily.getContactMobile());
		candidateFamilyDTO.setDateCreated(candidateFamily.getDateCreated());
		candidateFamilyDTO.setContactPhone(candidateFamily.getContactPhone());
		candidateFamilyDTO.setFamilyId(candidateFamily.getFamilyId());
		candidateFamilyDTO.setCandidateId(candidateFamily.getCandidateId());
		candidateFamilyDTO.setDateOfBirth(candidateFamily.getDateOfBirth());
		candidateFamilyDTO.setCaptions(candidateFamily.getCaptions());
		candidateFamilyDTO.setCaptionsValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Captions.getDropDownName(),candidateFamily.getCaptions()));
		candidateFamilyDTO.setName(candidateFamily.getName());
		candidateFamilyDTO.setOccupations(candidateFamily.getOccupations());
		candidateFamilyDTO.setQualificationId(candidateFamily.getQualificationId());
		candidateFamilyDTO.setRelation(candidateFamily.getRelation());
		candidateFamilyDTO.setRelationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Relation.getDropDownName(), candidateFamily.getRelation()));
		candidateFamilyDTO.setQualificationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Qualification.getDropDownName(), candidateFamily.getQualificationId()));
		candidateFamilyDTO.setOccupationValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Occupation.getDropDownName(), candidateFamily.getOccupations()));
		if (candidateFamily.getCandidateNominees() != null)
			candidateFamilyDTO.setCandidateNomineeDto(candidateNomineeDatabaseModelToUiDtoList(
					candidateFamily.getCandidateNominees(), candidateFamily.getFamilyId()));

		return candidateFamilyDTO;
	}

	public CandidateNominee uiCandidateNomineeDtoToDatabaseModel(CandidateNomineeDTO candidateNomineeDTO,
			CandidateFamily candidateFamily) {
		CandidateNominee candidateNominee = new CandidateNominee();

		candidateNominee.setActiveStatus(candidateNomineeDTO.getActiveStatus());
		candidateNominee.setCandidateNomineeid(candidateNomineeDTO.getCandidateNomineeid());
		if (candidateNomineeDTO.getDateCreated() == null)
			candidateNominee.setDateCreated(new Date());
		else
			candidateNominee.setDateCreated(candidateNomineeDTO.getDateCreated());
		candidateNominee.setStaturyHeadId(candidateNomineeDTO.getStaturyHeadId());
		candidateNominee.setStaturyHeadName(candidateNomineeDTO.getStaturyHeadName());
		candidateNominee.setUserId(candidateNomineeDTO.getUserId());
		candidateNominee.setUserIdUpdate(candidateNomineeDTO.getUserIdUpdate());
		candidateNominee.setCandidateFamily(candidateFamily);
		return candidateNominee;

	}

	public List<CandidateNominee> uiCandidateNomineeDtoToDatabaseModelList(List<CandidateNomineeDTO> candidateNomineeDTOList, CandidateFamily candidateFamily) {

		List<CandidateNominee> candidateNomineeList = new ArrayList<CandidateNominee>();
		for (CandidateNomineeDTO candidateNomineeDTO : candidateNomineeDTOList) {
			candidateNomineeList.add(uiCandidateNomineeDtoToDatabaseModel(candidateNomineeDTO, candidateFamily));
		}
		return candidateNomineeList;
	}

	public CandidateNomineeDTO candidateNomineeDatabaseModelToUiDto(CandidateNominee candidateNominee) {
		CandidateNomineeDTO candidateNomineeDTO = new CandidateNomineeDTO();

		candidateNomineeDTO.setCandidateNomineeid(candidateNominee.getCandidateNomineeid());
		candidateNomineeDTO.setActiveStatus(candidateNominee.getActiveStatus());
		candidateNomineeDTO.setCandidateNomineeid(candidateNominee.getCandidateNomineeid());
		candidateNomineeDTO.setDateCreated(candidateNominee.getDateCreated());
		candidateNomineeDTO.setStaturyHeadId(candidateNominee.getStaturyHeadId());
		candidateNomineeDTO.setStaturyHeadName(candidateNominee.getStaturyHeadName());
		candidateNomineeDTO.setUserId(candidateNominee.getUserId());
		candidateNomineeDTO.setUserIdUpdate(candidateNominee.getUserIdUpdate());

		return candidateNomineeDTO;

	}

	public List<CandidateNomineeDTO> candidateNomineeDatabaseModelToUiDtoList(
			List<CandidateNominee> candidateNomineeList, Long familyId) {

		List<CandidateNomineeDTO> candidateNomineeDTOList = new ArrayList<CandidateNomineeDTO>();
		for (CandidateNominee candidateNominee : candidateNomineeList) {
			CandidateNomineeDTO dto = candidateNomineeDatabaseModelToUiDto(candidateNominee);
			dto.setFamilyId(familyId);
			candidateNomineeDTOList.add(dto);
		}
		return candidateNomineeDTOList;
	}

}
