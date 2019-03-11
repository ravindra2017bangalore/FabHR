package com.csipl.hrms.dto.candidate;

import java.util.Date;
import java.util.List;

public class CandidateFamilyDTO {

	private Long familyId;
	private Long candidateId;
	private String captions;
	private Long companyId;
	private String contactMobile;
	private String contactPhone;
	private Date dateCreated;
	private Date dateOfBirth;
	private Date dateUpdate;
	private String name;
	private String occupations;
	private String qualificationId;
	private String relation;
	private Long userId;
	private Long userIdUpdate;
	private String occupationValue;
	private String relationValue;
	private String qualificationValue;
	private String captionsValue;
	
	public List<CandidateNomineeDTO> candidateNomineeDto;

	public Long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getCaptions() {
		return this.captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupations() {
		return this.occupations;
	}

	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}

	public String getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public List<CandidateNomineeDTO> getCandidateNomineeDto() {
		return candidateNomineeDto;
	}

	public void setCandidateNomineeDto(List<CandidateNomineeDTO> candidateNomineeDto) {
		this.candidateNomineeDto = candidateNomineeDto;
	}

	public String getOccupationValue() {
		return occupationValue;
	}

	public void setOccupationValue(String occupationValue) {
		this.occupationValue = occupationValue;
	}

	public String getRelationValue() {
		return relationValue;
	}

	public void setRelationValue(String relationValue) {
		this.relationValue = relationValue;
	}

	public String getQualificationValue() {
		return qualificationValue;
	}

	public void setQualificationValue(String qualificationValue) {
		this.qualificationValue = qualificationValue;
	}
	public String getCaptionsValue() {
		return captionsValue;
	}

	public void setCaptionsValue(String captionsValue) {
		this.captionsValue = captionsValue;
	}

	@Override
	public String toString() {
		return "CandidateFamilyDTO [familyId=" + familyId + ", candidateId=" + candidateId + ", captions=" + captions
				+ ", companyId=" + companyId + ", contactMobile=" + contactMobile + ", contactPhone=" + contactPhone
				+ ", dateCreated=" + dateCreated + ", dateOfBirth=" + dateOfBirth + ", dateUpdate=" + dateUpdate
				+ ", name=" + name + ", occupations=" + occupations + ", qualificationId=" + qualificationId
				+ ", relation=" + relation + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate
				+ ", occupationValue=" + occupationValue + ", relationValue=" + relationValue + ", qualificationValue="
				+ qualificationValue + ", candidateNomineeDto=" + candidateNomineeDto + "]";
	}

}
