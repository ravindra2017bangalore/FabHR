package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.candidate.CandidateSkillDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.model.employee.Skill;

public class CandidateSkillAdaptor implements Adaptor<CandidateSkillDTO, CandidateSkill> {

	@Override
	public List<CandidateSkill> uiDtoToDatabaseModelList(List<CandidateSkillDTO> candidateSkillDtoList) {
		List<CandidateSkill> candidateSkillList = new ArrayList<CandidateSkill>();
		for (CandidateSkillDTO candidateSkillDto : candidateSkillDtoList) {
			CandidateSkill candidateSkill = new CandidateSkill();
			Candidate candidate = new Candidate();
			Skill skill = new Skill();
			if (candidateSkillDto.getCandidateId() != null) {
				candidate.setCandidateId(candidateSkillDto.getCandidateId());
				candidateSkill.setCandidate(candidate);
			}
			if (candidateSkillDto.getCandidateSkillsId() != null)
				candidateSkill.setCandidateSkillsId(candidateSkillDto.getCandidateSkillsId());

			if (candidateSkillDto.getSkillId() != null) {
				skill.setSkillId(candidateSkillDto.getSkillId());
				candidateSkill.setSkill(skill);
			}
			candidateSkill.setUserId(candidateSkillDto.getCandidateId());
			candidateSkill.setUserIdUpdate(candidateSkillDto.getCandidateId());
			if (candidateSkillDto.getCandidateSkillsId() == null)
				candidateSkill.setDateCreated(new Date());
			else
				candidateSkill.setDateCreated(candidateSkillDto.getDateCreated());

			candidateSkill.setDateUpdate(new Date());
			candidateSkillList.add(candidateSkill);
		}

		return candidateSkillList;
	}

	public List<CandidateSkillDTO> databaseModelObjToUiDtoList(List<Object[]> candidateSkillList) {
		List<CandidateSkillDTO> candidateSkillDtoList = new ArrayList<CandidateSkillDTO>();
		for (Object[] candidateSkill : candidateSkillList) {
			CandidateSkillDTO candidateSkillDto = new CandidateSkillDTO();
			// candidateSkillDto.setCandidateSkillsId(candidateSkill.getCandidateSkillsId());
			// candidateSkillDto.setCandidateId(candidateSkill.getCandidate().getCandidateId());
			// candidateSkillDto.setSkillId(candidateSkill.getSkill().getSkillId());
			// candidateSkillDtoList.add(candidateSkillDto);
			if (candidateSkill[0] != null) {
				candidateSkillDto.setSkillName(candidateSkill[0].toString());
			}
			if (candidateSkill[1] != null) {
				candidateSkillDto.setCandidateSkillsId(
						(candidateSkill[1] != null ? Long.parseLong(candidateSkill[1].toString()) : null));
			}
			if (candidateSkill[2] != null) {
				candidateSkillDto
						.setSkillId((candidateSkill[2] != null ? Long.parseLong(candidateSkill[2].toString()) : null));
			}
			if (candidateSkill[3] != null) {
				candidateSkillDto.setCandidateId(
						(candidateSkill[3] != null ? Long.parseLong(candidateSkill[3].toString()) : null));
			}
			candidateSkillDtoList.add(candidateSkillDto);
		}
		return candidateSkillDtoList;
	}

	@Override
	public CandidateSkill uiDtoToDatabaseModel(CandidateSkillDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateSkillDTO databaseModelToUiDto(CandidateSkill dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateSkillDTO> databaseModelToUiDtoList(List<CandidateSkill> dbobj) {

		return null;
	}

}
