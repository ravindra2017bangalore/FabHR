package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CandidateProfessionalInformation database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateProfessionalInformation.findAll", query="SELECT c FROM CandidateProfessionalInformation c")
public class CandidateProfessionalInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateProfessionalInformationId;

	private BigDecimal annualSalary;

	private Long candidateId;

	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String designation;

	private String organizationName;

	private String professionalDoc;

	private String reasonForChange;

	private String reportingContact;

	private String reportingTo;

	private Long userId;

	private Long userIdUpdate;
	
	@Transient
	private int docIndex;
	
	private String documentName;
	/*@Id
	
	private Long candidateProfessionalInformationId;

	private BigDecimal annualSalary;

	private Long candidateId;

	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String designation;

	private String organizationName;

	private String reasonForChange;

	private String reportingContact;

	private String reportingTo;

	private Long userId;

	private Long userIdUpdate;

	private String professionalDoc;*/
	
	public CandidateProfessionalInformation() {
	}

	public Long getCandidateProfessionalInformationId() {
		return this.candidateProfessionalInformationId;
	}

	public void setCandidateProfessionalInformationId(Long candidateProfessionalInformationId) {
		this.candidateProfessionalInformationId = candidateProfessionalInformationId;
	}

	public BigDecimal getAnnualSalary() {
		return this.annualSalary;
	}

	public void setAnnualSalary(BigDecimal annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getReasonForChange() {
		return this.reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
	}

	public String getReportingContact() {
		return this.reportingContact;
	}

	public void setReportingContact(String reportingContact) {
		this.reportingContact = reportingContact;
	}

	public String getReportingTo() {
		return this.reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
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

	public String getProfessionalDoc() {
		return professionalDoc;
	}

	public void setProfessionalDoc(String professionalDoc) {
		this.professionalDoc = professionalDoc;
	}

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


}