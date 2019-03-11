package com.csipl.hrms.service.candidate;

import java.util.List;

import com.csipl.hrms.model.candidate.CandidateFamily;

public interface CandidateFamilyService {

	public List<CandidateFamily> saveAll(List<CandidateFamily> candidateFamilyList);
	public List<CandidateFamily> findAllFamilyList(Long candidateId);
}
