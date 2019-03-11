package com.csipl.hrms.service.adaptor;

import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateStatuaryDTO;
import com.csipl.hrms.model.candidate.CandidateStatuary;

public class CandidateStatuaryAdaptor implements Adaptor<CandidateStatuaryDTO, CandidateStatuary> {

	@Override
	public List<CandidateStatuary> uiDtoToDatabaseModelList(List<CandidateStatuaryDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateStatuaryDTO> databaseModelToUiDtoList(List<CandidateStatuary> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateStatuary uiDtoToDatabaseModel(CandidateStatuaryDTO candidateStatuaryDTO) {

		CandidateStatuary candidateStatuary = new CandidateStatuary();

		candidateStatuary.setCandidateStatuaryId(candidateStatuaryDTO.getCandidateStatuaryId());
		candidateStatuary.setActiveStatus(candidateStatuaryDTO.getActiveStatus());
		if (candidateStatuaryDTO.getDateCreated() == null)
			candidateStatuary.setDateCreated(new Date());
		else
			candidateStatuary.setDateCreated(candidateStatuaryDTO.getDateCreated());
		candidateStatuary.setActiveStatus(candidateStatuaryDTO.getActiveStatus());
		candidateStatuary.setIfscCode(candidateStatuaryDTO.getIfscCode());
		candidateStatuary.setOldEsi(candidateStatuaryDTO.getOldEsi());
		candidateStatuary.setPanNumber(candidateStatuaryDTO.getPanNumber());
		candidateStatuary.setOldUan(candidateStatuaryDTO.getOldUan());
		candidateStatuary.setDateUpdated(candidateStatuaryDTO.getDateUpdated());
		candidateStatuary.setCandidateId(candidateStatuaryDTO.getCandidateId());
		candidateStatuary.setBranch(candidateStatuaryDTO.getBranch());
		candidateStatuary.setBankId(candidateStatuaryDTO.getBankId());
		candidateStatuary.setAccountNumber(candidateStatuaryDTO.getAccountNumber());
		if (candidateStatuaryDTO.getActiveStatus() == null)
			candidateStatuary.setActiveStatus("AC");
		return candidateStatuary;
	}

	@Override
	public CandidateStatuaryDTO databaseModelToUiDto(CandidateStatuary CandidateStatuary) {

		CandidateStatuaryDTO candidateStatuaryDTO = new CandidateStatuaryDTO();
		if (CandidateStatuary.getCandidateId() != null) {
			candidateStatuaryDTO.setCandidateId(CandidateStatuary.getCandidateId());
			candidateStatuaryDTO.setCandidateStatuaryId(CandidateStatuary.getCandidateStatuaryId());
			candidateStatuaryDTO.setDateCreated(CandidateStatuary.getDateCreated());
			candidateStatuaryDTO.setAccountNumber(CandidateStatuary.getAccountNumber());
			candidateStatuaryDTO.setActiveStatus(CandidateStatuary.getActiveStatus());
			candidateStatuaryDTO.setIfscCode(CandidateStatuary.getIfscCode());
			candidateStatuaryDTO.setOldEsi(CandidateStatuary.getOldEsi());
			candidateStatuaryDTO.setUserIdUpdate(CandidateStatuary.getUserIdUpdate());
			candidateStatuaryDTO.setUserId(CandidateStatuary.getUserId());
			candidateStatuaryDTO.setBranch(CandidateStatuary.getBranch());
			candidateStatuaryDTO.setBankId(CandidateStatuary.getBankId());
			candidateStatuaryDTO.setOldUan(CandidateStatuary.getOldUan());
			candidateStatuaryDTO.setPanNumber(CandidateStatuary.getPanNumber());
			candidateStatuaryDTO.setBankName(DropDownCache.getInstance().getDropDownValue(DropDownEnum.BankName.getDropDownName(),CandidateStatuary.getBankId()));
		}
		return candidateStatuaryDTO;
	}

}
