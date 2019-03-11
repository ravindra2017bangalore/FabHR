package com.csipl.hrms.service.candidate.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.candidate.CandidateIdProof;


public interface CandidateIdAddressRepository extends CrudRepository<CandidateIdProof, Long>{
	@Query(" from CandidateIdProof where candidateId=?1  ORDER BY  candidateIdProofsId  DESC")
    public List<CandidateIdProof> findAllCanIDProof(Long candidateId);
	
}
