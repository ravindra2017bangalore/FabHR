package com.csipl.hrms.service.candidate;

import com.csipl.hrms.model.candidate.CandidatePersonal;

public interface CandidatePersonalService {

	CandidatePersonal savePersonal(CandidatePersonal candidatePersonal);
	CandidatePersonal findCandidatePersonal(Long candidatePersonalId);
}
