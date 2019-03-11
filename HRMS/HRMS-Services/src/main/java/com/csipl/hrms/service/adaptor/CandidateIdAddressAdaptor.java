package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.candidate.CandidateIdProofDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateIdProof;

public class CandidateIdAddressAdaptor implements Adaptor<CandidateIdProofDTO, CandidateIdProof> {

	public CandidateIdProof candidateIdProofDtoToDatabaseModel(CandidateIdProofDTO candidateIdProofDTO,
			long candidateId) {
		System.out.println("candidateIdProofDtoToDatabaseModel");
		System.out.println("Candidate Id >>" + candidateId);
		DateUtils dateUtils = new DateUtils();
		CandidateIdProof candidateIdProof = new CandidateIdProof();
		candidateIdProof.setCandidateIdProofsId(candidateIdProofDTO.getCandidateIdProofsId());
		candidateIdProof.setActiveStatus(candidateIdProofDTO.getActiveStatus());
		candidateIdProof.setUserId(candidateIdProofDTO.getUserId());
		if (candidateIdProofDTO.getDateFrom() != null && !("").equals(candidateIdProofDTO.getDateFrom()))
			candidateIdProof.setDateFrom(candidateIdProofDTO.getDateFrom());
		if (candidateIdProofDTO.getDateTo() != null && !("").equals(candidateIdProofDTO.getDateTo()))
			candidateIdProof.setDateTo(candidateIdProofDTO.getDateTo());

		candidateIdProof.setIdTypeId(candidateIdProofDTO.getIdTypeId());
		candidateIdProof.setIdNumber(candidateIdProofDTO.getIdNumber());
		candidateIdProof.setDocumentName(candidateIdProofDTO.getDocumentName());
		Candidate candidate = new Candidate();
		candidate.setCandidateId(candidateId);
		candidateIdProof.setCandidate(candidate);
		if (candidateIdProofDTO.getDateCreated() == null)
			candidateIdProof.setDateCreated(new Date());
		else
			candidateIdProof.setDateCreated(candidateIdProofDTO.getDateCreated());
		candidateIdProof.setDateUpdate(new Date());
		System.out.println("candidateIdProof...." + candidateIdProof.toString());
		return candidateIdProof;
	}

	public CandidateIdProof candidateIdProofDtoToDatabaseModel(CandidateIdProofDTO candidateIdProofDto,
			Candidate candidate) {
		CandidateIdProof candidateIdProof = new CandidateIdProof();
		DateUtils dateUtils = new DateUtils();
		System.out.println("DTO" + candidateIdProofDto.getCandidateIdProofsId());
		candidateIdProof.setCandidateIdProofsId(candidateIdProofDto.getCandidateIdProofsId());
		candidateIdProof.setActiveStatus(candidateIdProofDto.getActiveStatus());

		if (candidateIdProofDto.getDateFrom() != null && !("").equals(candidateIdProofDto.getDateFrom()))
			candidateIdProof.setDateFrom(candidateIdProofDto.getDateFrom());

		if (candidateIdProofDto.getDateTo() != null && !("").equals(candidateIdProofDto.getDateTo()))
			candidateIdProof.setDateTo(candidateIdProofDto.getDateTo());
		candidateIdProof.setIdTypeId(candidateIdProofDto.getIdTypeId());
		candidateIdProof.setIdNumber(candidateIdProofDto.getIdNumber());
		candidateIdProof.setUserId(candidate.getUserId());
		candidateIdProof.setDateCreated(new Date());
		candidateIdProof.setCandidate(candidate);
		return candidateIdProof;
	}

	public List<CandidateIdProof> candidateIdProofDtoToDatabaseModelList(
			List<CandidateIdProofDTO> candidateIdProofDtoList, Long canId) {
		List<CandidateIdProof> candidateIdProofList = new ArrayList<CandidateIdProof>();
		for (CandidateIdProofDTO employeeIdProofDto : candidateIdProofDtoList) {
			candidateIdProofList.add(candidateIdProofDtoToDatabaseModel(employeeIdProofDto, canId));
		}
		return candidateIdProofList;
	}

	public List<CandidateIdProof> candidateIdProofDtoToDatabaseModelList(
			List<CandidateIdProofDTO> candidateIdProofDtoList, Candidate candidate) {
		List<CandidateIdProof> candidateIdProofList = new ArrayList<CandidateIdProof>();
		for (CandidateIdProofDTO candidateIdProofDTO : candidateIdProofDtoList) {
			candidateIdProofList.add(candidateIdProofDtoToDatabaseModel(candidateIdProofDTO, candidate));
		}
		return candidateIdProofList;
	}

	@Override
	public List<CandidateIdProof> uiDtoToDatabaseModelList(List<CandidateIdProofDTO> uiobj) {

		return null;
	}

	@Override
	public List<CandidateIdProofDTO> databaseModelToUiDtoList(List<CandidateIdProof> candidateIdProofList) {
		List<CandidateIdProofDTO> candidateIdProofDtoList = new ArrayList<CandidateIdProofDTO>();
		for (CandidateIdProof candidateIdProof : candidateIdProofList) {
			candidateIdProofDtoList.add(databaseModelToUiDto(candidateIdProof));
		}
		return candidateIdProofDtoList;

	}

	@Override
	public CandidateIdProof uiDtoToDatabaseModel(CandidateIdProofDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateIdProofDTO databaseModelToUiDto(CandidateIdProof candidateIdProof) {
		CandidateIdProofDTO candidateIdProofDto = new CandidateIdProofDTO();
		candidateIdProofDto.setCandidateIdProofsId(candidateIdProof.getCandidateIdProofsId());
		candidateIdProofDto.setActiveStatus(candidateIdProof.getActiveStatus());
		candidateIdProofDto.setIdNumber(candidateIdProof.getIdNumber());
		candidateIdProofDto.setUserId(candidateIdProof.getUserId());
		candidateIdProofDto.setDateCreated(candidateIdProof.getDateCreated());
		if (candidateIdProof.getDateFrom() != null) {
			// Date dateFrom = candidateIdProof.getDateFrom();
			candidateIdProofDto.setDateFrom(candidateIdProof.getDateFrom());
			System.out.println(candidateIdProof.getDateFrom());
		}
		if (candidateIdProof.getDateTo() != null) {
			// String dateTo = dateUtils.getDateStringWirhYYYYMMDD(
			// candidateIdProof.getDateTo() );
			candidateIdProofDto.setDateTo(candidateIdProof.getDateTo());
			System.out.println(candidateIdProof.getDateTo());
		}else {
			candidateIdProofDto.setDateTo(candidateIdProof.getDateTo());
		}
		System.out.println(candidateIdProofDto.getDateTo());
		candidateIdProofDto.setIdTypeId(candidateIdProof.getIdTypeId());
		candidateIdProofDto.setIdTypeIdValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.SelectIdType.getDropDownName(), candidateIdProof.getIdTypeId()));
		candidateIdProofDto.setDocumentName(candidateIdProof.getDocumentName());
		candidateIdProofDto.setIdProofDoc(candidateIdProof.getIdProofDoc());
		System.out.println(candidateIdProof.toString());
		return candidateIdProofDto;
	}

}
