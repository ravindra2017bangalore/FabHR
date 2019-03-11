package com.csipl.hrms.service.candidate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.service.candidate.repository.CandidateSkillRepository;

@Transactional
@Service("candidateSkillService")

public class CandidateSkillServiceImpl implements CandidateSkillService {

	@Autowired
	CandidateSkillRepository candidateSkillRepository;

	@Override
	public List<CandidateSkill> save(List<CandidateSkill> candidateSkillList) {
		return (List<CandidateSkill>) candidateSkillRepository.save(candidateSkillList);
	}

	@Override
	public List<Object[]> getAllCandidateSkill(Long candidateId) {
		return candidateSkillRepository.getAllCandidateSkill(candidateId);
	}

	@Override
	public void deleteSkill(Long candidateSkillsId) {
		candidateSkillRepository.delete(candidateSkillsId);
	}

	@Override
	public List<CandidateSkill> getCandidateSkill(Long candidateId) {
		return candidateSkillRepository.getCandidateSkill(candidateId);
	}

}
