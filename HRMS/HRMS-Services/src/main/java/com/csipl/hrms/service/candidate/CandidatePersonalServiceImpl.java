package com.csipl.hrms.service.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import com.csipl.hrms.model.candidate.CandidatePersonal;
import com.csipl.hrms.service.candidate.repository.CandidatePersonalRepository;

@Service("candidatePersonalService")
public class CandidatePersonalServiceImpl implements CandidatePersonalService {
	
	@Autowired
	CandidatePersonalRepository candidatePersonalRepository;

	@Override
	public CandidatePersonal savePersonal(CandidatePersonal candidatePersonal) {
//		System.out.println("candidatePersonal==============================="+candidatePersonal.getCandidateAddress1()+" -- "+candidatePersonal.getCandidateAddress2()+" --"+candidatePersonal.getCandidateAddress3());
// 		System.out.println("candidatePersonal==============================="+candidatePersonal.getCandidateAddress1().getAddressId()+""+candidatePersonal.getCandidateAddress2().getAddressId()+""+candidatePersonal.getCandidateAddress3().getAddressId());
		return candidatePersonalRepository.save(candidatePersonal);
	}

	@Override
	public CandidatePersonal findCandidatePersonal(Long candidatePersonalId) {
	System.out.println("in candidate personal service impl..."+candidatePersonalId);
	
		return candidatePersonalRepository.findCandidatePersonal(candidatePersonalId);
	}
	 

}
