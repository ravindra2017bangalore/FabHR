package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.model.candidate.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends CrudRepository<CandidateSkill, Long> {

	// @Query("from CandidateSkill where candidateId=?1")
	// List<CandidateSkill> getAllCandidateSkill(Long candidateId);

	String candidateSkill = "SELECT s.skillName ,cs.candidateSkillsId,cs.skillId, cs.candidateId FROM CandidateSkills cs JOIN Skills s on s.skillId=cs.skillId where cs.candidateId=?1";

	@Query(value = candidateSkill, nativeQuery = true)
	List<Object[]> getAllCandidateSkill(Long candidateId);
	
	@Query("from CandidateSkill where candidateId=?1")
	List <CandidateSkill> getCandidateSkill(Long candidateId);
}
