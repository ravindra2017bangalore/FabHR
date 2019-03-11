package com.csipl.hrms.service.candidate;

import com.csipl.hrms.model.candidate.CandidateStatuary;

public interface CandidateStatuaryService {

	public CandidateStatuary save(CandidateStatuary candidateStatuary);
	
	public CandidateStatuary findCandidateStatuary(Long candidateId);
}
