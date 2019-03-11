package com.csipl.hrms.service.candidate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.candidate.CandidateIdProof;


public interface CandidateIdAddressService {
	
	public List<CandidateIdProof> save(List<CandidateIdProof> candidateIdProof,HttpServletRequest request);
	public List<CandidateIdProof> findAllCandidateIdProofs(Long candidateId);
//	public CandidateIdProof update(CandidateIdProof employeeIdProof);
//	public void delete(Long empIdProofId);

}
