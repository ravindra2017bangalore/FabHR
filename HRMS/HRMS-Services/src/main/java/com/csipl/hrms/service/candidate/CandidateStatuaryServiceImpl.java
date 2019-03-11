package com.csipl.hrms.service.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.candidate.CandidateStatuary;
import com.csipl.hrms.service.candidate.repository.CandidateFamilyRepository;
import com.csipl.hrms.service.candidate.repository.CandidateStatuaryRepository;

@Service("candidateStatuaryService")
public class CandidateStatuaryServiceImpl implements CandidateStatuaryService{
	
	@Autowired
	CandidateStatuaryRepository candidateStatuaryRepository;

	@Override
	public CandidateStatuary save(CandidateStatuary candidateStatuary) {
		
		return candidateStatuaryRepository.save(candidateStatuary);
	}

	@Override
	public CandidateStatuary findCandidateStatuary(Long candidateId) {
		
		return candidateStatuaryRepository.findCandidateStatuary(candidateId);
	};

}
