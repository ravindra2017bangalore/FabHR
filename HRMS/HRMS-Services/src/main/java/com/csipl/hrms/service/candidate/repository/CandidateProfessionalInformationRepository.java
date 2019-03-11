package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;

@Repository
public interface CandidateProfessionalInformationRepository
		extends CrudRepository<CandidateProfessionalInformation, Long> {

	@Query("from CandidateProfessionalInformation where candidateId=?1")
	List<CandidateProfessionalInformation> getAllCandidateProfessionalInformation(Long candidateId);

}
