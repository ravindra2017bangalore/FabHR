package com.csipl.hrms.model.candidate;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CandidateStatuary database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateStatuary.findAll", query="SELECT c FROM CandidateStatuary c")
public class CandidateStatuary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateStatuaryId;

	private String accountNumber;

	private String activeStatus;

	private String bankId;

	private String branch;

	private Long candidateId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	private String ifscCode;

	private String oldEsi;

	private String oldUan;

	private String panNumber;

	private Long userId;

	private Long userIdUpdate;

	public CandidateStatuary() {
	}

	public Long getCandidateStatuaryId() {
		return this.candidateStatuaryId;
	}

	public void setCandidateStatuaryId(Long candidateStatuaryId) {
		this.candidateStatuaryId = candidateStatuaryId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getOldEsi() {
		return this.oldEsi;
	}

	public void setOldEsi(String oldEsi) {
		this.oldEsi = oldEsi;
	}

	public String getOldUan() {
		return this.oldUan;
	}

	public void setOldUan(String oldUan) {
		this.oldUan = oldUan;
	}

	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
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

}