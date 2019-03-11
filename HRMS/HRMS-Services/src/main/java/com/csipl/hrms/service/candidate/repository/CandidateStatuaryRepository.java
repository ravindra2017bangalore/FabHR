package com.csipl.hrms.service.candidate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.model.candidate.CandidateStatuary;

@Repository
public interface CandidateStatuaryRepository extends CrudRepository<CandidateStatuary, Long>{

	
	@Query("from CandidateStatuary where candidateId=?1")
	public CandidateStatuary findCandidateStatuary(Long candidateId);
	
	

}
