package com.csipl.hrms.service.candidate;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.candidate.CandidateOfficialInformation;


public interface CandidateOfficialInfoService {
	
	public CandidateOfficialInformation save(CandidateOfficialInformation candidateOfficialInformation,HttpServletRequest request) throws ErrorHandling;
	public CandidateOfficialInformation findCandidateOfficialInformation(Long candidateId);

}
