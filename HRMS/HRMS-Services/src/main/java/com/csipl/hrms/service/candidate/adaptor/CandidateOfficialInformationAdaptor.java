package com.csipl.hrms.service.candidate.adaptor;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.candidate.CandidateOfficialInformationDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateOfficialInformation;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.service.adaptor.Adaptor;

public class CandidateOfficialInformationAdaptor implements Adaptor<CandidateOfficialInformationDTO, CandidateOfficialInformation>{

	@Override
	public List<CandidateOfficialInformation> uiDtoToDatabaseModelList(List<CandidateOfficialInformationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateOfficialInformationDTO> databaseModelToUiDtoList(List<CandidateOfficialInformation> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateOfficialInformation uiDtoToDatabaseModel(CandidateOfficialInformationDTO candidateOfficialInformationDTO) {
		CandidateOfficialInformation candidateOfficialInformation=new CandidateOfficialInformation();
		Candidate candidate=new Candidate();
		Grade grade= new Grade();
		
		candidateOfficialInformation.setCandidateOfficialId(candidateOfficialInformationDTO.getCandidateOfficialId());
		candidateOfficialInformation.setUanNumber(candidateOfficialInformationDTO.getUanNumber());
		if(candidateOfficialInformationDTO.getDateCreated()==null)
		candidateOfficialInformation.setDateCreated(new Date());
		candidateOfficialInformation.setDateUpdate(new Date());
		candidateOfficialInformation.setEsiNumber(candidateOfficialInformationDTO.getEsiNumber());
		candidateOfficialInformation.setEsiEnrollDate(candidateOfficialInformationDTO.getEsiEnrollDate());
		candidateOfficialInformation.setIsEsicApplicable(candidateOfficialInformationDTO.getIsEsicApplicable());
		candidateOfficialInformation.setAccidentalInsurance(candidateOfficialInformationDTO.getAccidentalInsurance());
		candidateOfficialInformation.setAiFromDate(candidateOfficialInformationDTO.getAiFromDate());
		candidateOfficialInformation.setAiToDate(candidateOfficialInformationDTO.getAiToDate());
		candidateOfficialInformation.setIsAiApplicable(candidateOfficialInformationDTO.getIsAiApplicable());
		candidateOfficialInformation.setMedicalInsurance(candidateOfficialInformationDTO.getMedicalInsurance());
		candidateOfficialInformation.setMiFromDate(candidateOfficialInformationDTO.getMiFromDate());
		candidateOfficialInformation.setMiToDate(candidateOfficialInformationDTO.getMiToDate());
		candidateOfficialInformation.setIsMiApplicable(candidateOfficialInformationDTO.getIsMiApplicable());
		grade.setGradesId(candidateOfficialInformationDTO.getGrade());
		candidateOfficialInformation.setGrade(grade);
		candidateOfficialInformation.setDateUpdate(candidateOfficialInformationDTO.getDateUpdate());
		candidateOfficialInformation.setUserId(candidateOfficialInformationDTO.getUserId());
		candidateOfficialInformation.setNoticePeriod(candidateOfficialInformationDTO.getNoticePeriod());
		candidateOfficialInformation.setProbationDays(candidateOfficialInformationDTO.getProbationDays());
		candidate.setCandidateId(candidateOfficialInformationDTO.getCandidateId());
		candidateOfficialInformation.setCandidate(candidate);
		candidateOfficialInformation.setCompanyId(candidateOfficialInformationDTO.getCompanyId());
		candidateOfficialInformation.setUserIdUpdate(candidateOfficialInformationDTO.getUserIdUpdate());
		candidateOfficialInformation.setPfNumber(candidateOfficialInformationDTO.getPfNumber());
		candidateOfficialInformation.setPfEnrollDate(candidateOfficialInformationDTO.getPfEnrollDate());
		candidateOfficialInformation.setIsPfApplicable(candidateOfficialInformationDTO.getIsPfApplicable());
		
		return candidateOfficialInformation;
	}

	@Override
	public CandidateOfficialInformationDTO databaseModelToUiDto(CandidateOfficialInformation candidateOfficialInformation) {
		
		CandidateOfficialInformationDTO candidateOfficialInformationDTO=new CandidateOfficialInformationDTO();
		candidateOfficialInformationDTO.setAccidentalInsurance(candidateOfficialInformation.getAccidentalInsurance());
		candidateOfficialInformationDTO.setAiFromDate(candidateOfficialInformation.getAiFromDate());
		candidateOfficialInformationDTO.setAiToDate(candidateOfficialInformation.getAiToDate());
		candidateOfficialInformationDTO.setCandidateOfficialId(candidateOfficialInformation.getCandidateOfficialId());
		candidateOfficialInformationDTO.setCompanyId(candidateOfficialInformation.getCompanyId());
		candidateOfficialInformationDTO.setDateCreated(candidateOfficialInformation.getDateCreated());
		candidateOfficialInformationDTO.setEsiNumber(candidateOfficialInformation.getEsiNumber());
		candidateOfficialInformationDTO.setEsiEnrollDate(candidateOfficialInformation.getEsiEnrollDate());
		candidateOfficialInformationDTO.setGrade(candidateOfficialInformation.getGrade().getGradesId());
		candidateOfficialInformationDTO.setGradeName(candidateOfficialInformation.getGrade().getGradesName());
		candidateOfficialInformationDTO.setMedicalInsurance(candidateOfficialInformation.getMedicalInsurance());
		candidateOfficialInformationDTO.setMiFromDate(candidateOfficialInformation.getMiFromDate());
		candidateOfficialInformationDTO.setMiToDate(candidateOfficialInformation.getMiToDate());
		candidateOfficialInformationDTO.setMiToDate(candidateOfficialInformation.getMiToDate());
		candidateOfficialInformationDTO.setNoticePeriod(candidateOfficialInformation.getNoticePeriod());
		candidateOfficialInformationDTO.setProbationDays(candidateOfficialInformation.getProbationDays());
		candidateOfficialInformationDTO.setPfNumber(candidateOfficialInformation.getPfNumber());
		candidateOfficialInformationDTO.setPfEnrollDate(candidateOfficialInformation.getPfEnrollDate());
		candidateOfficialInformationDTO.setIsPfApplicable(candidateOfficialInformation.getIsPfApplicable());
		candidateOfficialInformationDTO.setUanNumber(candidateOfficialInformation.getUanNumber());
		candidateOfficialInformationDTO.setCandidateId(candidateOfficialInformation.getCandidate().getCandidateId());
		candidateOfficialInformationDTO.setUserId(candidateOfficialInformation.getUserId());
		candidateOfficialInformationDTO.setEmployeeId(candidateOfficialInformation.getEmployeeId());
		
		return candidateOfficialInformationDTO;
	}

}
