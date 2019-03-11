package com.csipl.hrms.dto.candidate;

import java.util.List;

public class CandidateProfInformationDTO {

	private List<CandidateProfessionalInformationDTO> candidateProfInfoDtoList;
	private List<CandidateSkillDTO> candidateSkillDto;

	public List<CandidateProfessionalInformationDTO> getCandidateProfInfoDtoList() {
		return candidateProfInfoDtoList;
	}

	public void setCandidateProfInfoDtoList(List<CandidateProfessionalInformationDTO> candidateProfInfoDtoList) {
		this.candidateProfInfoDtoList = candidateProfInfoDtoList;
	}

	public List<CandidateSkillDTO> getCandidateSkillDto() {
		return candidateSkillDto;
	}

	public void setCandidateSkillDto(List<CandidateSkillDTO> candidateSkillDto) {
		this.candidateSkillDto = candidateSkillDto;
	}

}
