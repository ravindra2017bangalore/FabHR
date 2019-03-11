package com.csipl.hrms.service.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.candidate.CandidateFamily;
import com.csipl.hrms.service.candidate.repository.CandidateFamilyRepository;
@Service("candidateFamilyService")
public class CandidateFamilyServiceImpl implements CandidateFamilyService {

	@Autowired
	CandidateFamilyRepository candidateFamilyRepository;
	
	/**
	 * Method performed save OR update operation  
 	 */
	@Override
	public List<CandidateFamily> saveAll(List<CandidateFamily> candidateFamilyList) {
		List<CandidateFamily> candidateFamilyInfo=(List<CandidateFamily>) candidateFamilyRepository.save(candidateFamilyList);
		return candidateFamilyInfo;
	}

	

	@Override
	public List<CandidateFamily> findAllFamilyList(Long candidateId) {
		// TODO Auto-generated method stub
		return candidateFamilyRepository.findAllFamilyList(candidateId);
	}

}
