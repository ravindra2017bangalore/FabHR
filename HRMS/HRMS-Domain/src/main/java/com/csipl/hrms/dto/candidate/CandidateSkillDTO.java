package com.csipl.hrms.dto.candidate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class CandidateSkillDTO {

	@ApiModelProperty(notes = "The database generated candidateSkillsId")
	private Long candidateSkillsId;
	@ApiModelProperty(notes = "Skill Name field", required = true)
	private String skillName;
	@ApiModelProperty(notes = "CandidateId field", required = true)
	private Long candidateId;
	@ApiModelProperty(notes = "SkillId field", required = true)
	private Long skillId;
	@ApiModelProperty(notes = "departmentId field", required = true)
	private Long departmentId;
	@ApiModelProperty(notes = "departmentName field", required = true)
	private String departmentName;
	@ApiModelProperty(notes = "userId field", required = true)
	private Long userId;
	@ApiModelProperty(notes = "dateCreated field", required = true)
	private Date dateCreated;
	@ApiModelProperty(notes = "companyId field", required = true)
	private Long companyId;
	@ApiModelProperty(notes = "userIdUpdate field", required = true)
	private Long userIdUpdate;
	private Date dateUpdate;
	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public Long getCandidateSkillsId() {
		return candidateSkillsId;
	}

	public void setCandidateSkillsId(Long candidateSkillsId) {
		this.candidateSkillsId = candidateSkillsId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	@Override
	public String toString() {
		return "CandidateSkillDTO [candidateSkillsId=" + candidateSkillsId + ", skillName=" + skillName
				+ ", candidateId=" + candidateId + ", skillId=" + skillId + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", userId=" + userId + ", dateCreated=" + dateCreated
				+ ", companyId=" + companyId + ", userIdUpdate=" + userIdUpdate + "]";
	}

}
