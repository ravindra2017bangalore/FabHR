package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.candidate.CandidateEducation;


public interface CandidateEducationRepository extends CrudRepository<CandidateEducation, Long>{
	
	@Query(" from CandidateEducation where candidateId=?1 ")
    public List<CandidateEducation> findAllCanEdu(Long candidateId);
}
