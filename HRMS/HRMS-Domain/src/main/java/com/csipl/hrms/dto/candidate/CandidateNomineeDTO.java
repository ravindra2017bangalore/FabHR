package com.csipl.hrms.dto.candidate;

import java.util.Date;

public class CandidateNomineeDTO {
	
	private Long candidateNomineeid;

	private String activeStatus;
	
	private Date dateCreated;
	
	private Date dateUpdate;
	
	private String staturyHeadId;

	private String staturyHeadName;

	private Long userId;
	private Long familyId;

	private Long userIdUpdate;

	public Long getCandidateNomineeid() {
		return candidateNomineeid;
	}

	public void setCandidateNomineeid(Long candidateNomineeid) {
		this.candidateNomineeid = candidateNomineeid;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getStaturyHeadId() {
		return staturyHeadId;
	}

	public void setStaturyHeadId(String staturyHeadId) {
		this.staturyHeadId = staturyHeadId;
	}

	public String getStaturyHeadName() {
		return staturyHeadName;
	}

	public void setStaturyHeadName(String staturyHeadName) {
		this.staturyHeadName = staturyHeadName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	
	
	

}
