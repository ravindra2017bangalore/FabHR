package com.csipl.hrms.dto.candidate;

import java.util.Date;

public class CandidateIdProofDTO {
	private Long candidateIdProofsId;
	private String activeStatus;
	private Date dateCreated;
	private Date dateFrom;
	private Date dateIssue;
	private Date dateTo;
	private Date dateUpdate;
	private String idNumber;
	private String idTypeId;
	private String idTypeIdValue;
	private Long userId;
	private Long userIdUpdate;
	private Long candidateId;
	private int docIndex;
	private String documentName;
	private Long companyId;
	private String idProofDoc;
	public int getDocIndex() {
		return docIndex;
	}
	public void setDocIndex(int docIndex) {
		this.docIndex = docIndex;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public Long getCandidateIdProofsId() {
		return candidateIdProofsId;
	}
	public void setCandidateIdProofsId(Long candidateIdProofsId) {
		this.candidateIdProofsId = candidateIdProofsId;
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
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateIssue() {
		return dateIssue;
	}
	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdTypeId() {
		return idTypeId;
	}
	public void setIdTypeId(String idTypeId) {
		this.idTypeId = idTypeId;
	}
	public String getIdTypeIdValue() {
		return idTypeIdValue;
	}
	public void setIdTypeIdValue(String idTypeIdValue) {
		this.idTypeIdValue = idTypeIdValue;
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
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getCandidateId() {
		return candidateId;
	}
	public String getIdProofDoc() {
		return idProofDoc;
	}
	public void setIdProofDoc(String idProofDoc) {
		this.idProofDoc = idProofDoc;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

}
