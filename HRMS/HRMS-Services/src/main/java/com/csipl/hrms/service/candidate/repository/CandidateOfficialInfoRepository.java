package com.csipl.hrms.service.candidate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.candidate.CandidateOfficialInformation;


public interface CandidateOfficialInfoRepository extends CrudRepository<CandidateOfficialInformation, Long>{

	@Query("from CandidateOfficialInformation where candidateId=?1")
	public CandidateOfficialInformation findCandidateOfficialInformation(Long candidateId);
}
