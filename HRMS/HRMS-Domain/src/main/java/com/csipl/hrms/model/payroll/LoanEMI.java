package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.csipl.hrms.model.payroll.LoanIssue;

import java.util.Date;


/**
 * The persistent class for the LoanEMI database table.
 * 
 */
@Entity
@NamedQuery(name="LoanEMI.findAll", query="SELECT l FROM LoanEMI l")
public class LoanEMI implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long emiNo;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date emiDate;
	
	private BigDecimal emiAmount;

	private String emiStatus;

	private Long userId;
	
	private String remarks;

	//bi-directional many-to-one association to LoanIssue
	@ManyToOne
	@JoinColumn(name="transactionNo")	
	private LoanIssue loanIssue;

	public LoanEMI() {
	}

	public Long getEmiNo() {
		return this.emiNo;
	}

	public void setEmiNo(Long emiNo) {
		this.emiNo = emiNo;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getEmiDate() {
		return this.emiDate;
	}

	public void setEmiDate(Date emiDate) {
		this.emiDate = emiDate;
	}

	public String getEmiStatus() {
		return this.emiStatus;
	}

	public void setEmiStatus(String emiStatus) {
		this.emiStatus = emiStatus;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LoanIssue getLoanIssue() {
		return this.loanIssue;
	}

	public void setLoanIssue(LoanIssue loanIssue) {
		this.loanIssue = loanIssue;
	}

	public BigDecimal getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}