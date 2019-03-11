package com.csipl.hrms.service.candidate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.candidate.CandidateSkill;

public interface CandidateProfessionalInformationService {

	public List<CandidateProfessionalInformation> saveCandidateProfessionalInfo(List<CandidateProfessionalInformation> candidateProfessionalInformationList,List<CandidateSkill> candidateSkillList);

	public List<CandidateProfessionalInformation> getAllCandidateProfessionalInformation(Long candidateId);

	public List<CandidateProfessionalInformation> save(List<CandidateProfessionalInformation> candidateProfessionalInfoList, HttpServletRequest req);

}
