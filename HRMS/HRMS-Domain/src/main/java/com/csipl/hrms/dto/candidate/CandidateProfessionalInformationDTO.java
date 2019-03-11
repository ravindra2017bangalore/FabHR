package com.csipl.hrms.dto.candidate;

import java.math.BigDecimal;
import java.util.Date;

public class CandidateProfessionalInformationDTO {

	private Long candidateProfessionalInfoId;
	private Long candidateId;
	private Long companyId;
	private String organizationName;
	private Date dateFrom;
	private Date dateTo;
	private String designation;
	private String reportingTo;
	private String reportingContact;
	private String annualSalary;
	private String reasonForChange;
	private Long userId;
	private Long userIdUpdate;
	private Date dateCreated;
	private Date dateUpdate;
	private String reasonForChangeValue;
	private String documentFileLocation;
	private int docIndex;
	private String documentName;

	// private String professionalDoc;
	public Long getCandidateId() {
		return candidateId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getReportingContact() {
		return reportingContact;
	}

	public void setReportingContact(String reportingContact) {
		this.reportingContact = reportingContact;
	}

	public String getReasonForChange() {
		return reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
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

	public Long getCandidateProfessionalInfoId() {
		return candidateProfessionalInfoId;
	}

	public void setCandidateProfessionalInfoId(Long candidateProfessionalInfoId) {
		this.candidateProfessionalInfoId = candidateProfessionalInfoId;
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

	public String getReasonForChangeValue() {
		return reasonForChangeValue;
	}

	public void setReasonForChangeValue(String reasonForChangeValue) {
		this.reasonForChangeValue = reasonForChangeValue;
	}

	public int getDocIndex() {
		return docIndex;
	}

	public void setDocIndex(int docIndex) {
		this.docIndex = docIndex;
	}

	
	public String getDocumentFileLocation() {
		return documentFileLocation;
	}

	public void setDocumentFileLocation(String documentFileLocation) {
		this.documentFileLocation = documentFileLocation;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}


	/*
	 * public String getProfessionalDoc() { return professionalDoc; }
	 * 
	 * public void setProfessionalDoc(String professionalDoc) { this.professionalDoc
	 * = professionalDoc; }
	 */

}
