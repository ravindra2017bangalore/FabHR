package com.csipl.hrms.dto.employee;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BankDetailsDTO {

	private String bankId;
	private String accountNumber;
	private String ifscCode;
	private String accountType;
	private String accountTypeLabel;
	private Long employeeBankId;
	private String bankIdLabel;
	private Long employeeId;
	private Date effectiveDate;
	private String bankBranch;
	private Long userId;
	private Date dateCreated;
	private String status;
	private Long userIdUpdate;
	  
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountTypeLabel() {
		return accountTypeLabel;
	}
	public void setAccountTypeLabel(String accountTypeLabel) {
		this.accountTypeLabel = accountTypeLabel;
	}
	public Long getEmployeeBankId() {
		return employeeBankId;
	}
	public void setEmployeeBankId(Long employeeBankId) {
		this.employeeBankId = employeeBankId;
	}
	@Override
	public String toString() {
		return "BankDetailsDTO [bankId=" + bankId + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", accountType=" + accountType + ", bankBranch=" + bankBranch + ", effectiveDate=" + effectiveDate + "]";
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getBankIdLabel() {
		return bankIdLabel;
	}
	public void setBankIdLabel(String bankIdLabel) {
		this.bankIdLabel = bankIdLabel;
	}
}

