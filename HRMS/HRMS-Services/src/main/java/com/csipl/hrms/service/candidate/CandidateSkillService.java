package com.csipl.hrms.service.candidate;

import java.util.List;

import com.csipl.hrms.model.candidate.CandidateSkill;

public interface CandidateSkillService {

	public List<CandidateSkill> save(List<CandidateSkill> CandidateSkillList);

	public List<Object[]> getAllCandidateSkill(Long candidateId);

	public void deleteSkill(Long candidateSkillsId);
	
	public List<CandidateSkill> getCandidateSkill(Long candidateId);
}
