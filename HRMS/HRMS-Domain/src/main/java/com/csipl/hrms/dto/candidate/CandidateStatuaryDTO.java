package com.csipl.hrms.dto.candidate;

import java.util.Date;


public class CandidateStatuaryDTO {
	private Long candidateStatuaryId;
	
	private Long candidateId;

	private String activeStatus;

	private String bankId;

	private String branch;

	private Date dateCreated;
	
	private Date dateUpdated;

	private String ifscCode;

	private String oldEsi;

	private String oldUan;

	private String panNumber;

	private Long userId;

	private Long userIdUpdate;
	
	private String accountNumber;
	
	private String bankName;
	
	private String accountType;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCandidateStatuaryId() {
		return candidateStatuaryId;
	}

	public void setCandidateStatuaryId(Long candidateStatuaryId) {
		this.candidateStatuaryId = candidateStatuaryId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getOldEsi() {
		return oldEsi;
	}

	public void setOldEsi(String oldEsi) {
		this.oldEsi = oldEsi;
	}

	public String getOldUan() {
		return oldUan;
	}

	public void setOldUan(String oldUan) {
		this.oldUan = oldUan;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
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
	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
