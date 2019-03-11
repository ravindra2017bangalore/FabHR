package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModelWithoutCG;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the ProfessionalInformation database table.
 * 
 */

@Entity
@NamedQuery(name="ProfessionalInformation.findAll", query="SELECT p FROM ProfessionalInformation p")
public class ProfessionalInformation extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long historyId;
    private String allowModi;
    private BigDecimal annualSalary;
	@Temporal(TemporalType.DATE)
	private Date dateFrom;
	@Temporal(TemporalType.DATE)
	private Date dateTo;
	private String designation;
	private String organizationName;
	private String reasonForChange;
	private String reportingContact;
	private String reportingTo;
	private Long employeeId;
	private String professionalDoc;
	@Transient
	private int docIndex;
	private String documentName;
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public ProfessionalInformation() {
	}

	public Long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public BigDecimal getAnnualSalary() {
		return this.annualSalary;
	}

	public void setAnnualSalary(BigDecimal annualSalary) {
		this.annualSalary = annualSalary;
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
