package com.csipl.hrms.service.candidate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.candidate.CandidateEducation;


public interface CandidateEducationService {
	public List<CandidateEducation> save(List<CandidateEducation> candidateEducation,HttpServletRequest request);
	 public List<CandidateEducation> findAllEduInformation(Long candidateId);

}
