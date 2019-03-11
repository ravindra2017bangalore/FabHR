package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class LoanEMIDTO {
	private Long emiNo;
	private Long transactionNo;
	private String emiStatus;
	private Long userId;
	private Date dateCreated;
	private String 	remarks;
	
	private Date emiStartDate;
	private String loanType;
	private String loanTypeLabel;
	private BigDecimal loanAmount;
	private BigDecimal emiAmount;
    private Date emiDate;
	private String naration;
	private BigDecimal remaining;
	private String emiStatusLabel;
	
	public BigDecimal getRemaining() {
		return remaining;
	}
	public void setRemaining(BigDecimal remaining) {
		this.remaining = remaining;
	}
	public Date getEmiStartDate() {
		return emiStartDate;
	}
	public void setEmiStartDate(Date emiStartDate) {
		this.emiStartDate = emiStartDate;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public BigDecimal getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}
	public Date getEmiDate() {
		return emiDate;
	}
	public void setEmiDate(Date emiDate) {
		this.emiDate = emiDate;
	}
	public String getNaration() {
		return naration;
	}
	public void setNaration(String naration) {
		this.naration = naration;
	}
	public String getLoanTypeLabel() {
		return loanTypeLabel;
	}
	public void setLoanTypeLabel(String loanTypeLabel) {
		this.loanTypeLabel = loanTypeLabel;
	}
	public Long getEmiNo() {
		return emiNo;
	}
	public Long getTransactionNo() {
		return transactionNo;
	}
	public String getEmiStatus() {
		return emiStatus;
	}
	public Long getUserId() {
		return userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setEmiNo(Long emiNo) {
		this.emiNo = emiNo;
	}
	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}
	public void setEmiStatus(String emiStatus) {
		this.emiStatus = emiStatus;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEmiStatusLabel() {
		return emiStatusLabel;
	}
	public void setEmiStatusLabel(String emiStatusLabel) {
		this.emiStatusLabel = emiStatusLabel;
	}
	
	
	
}
