package com.csipl.hrms.dto.payroll;

import java.util.Date;

public class CorpBankDTO {
	private Long bankId;
	private String bankName;
	private String accountNo;
	private String ifscCode;
	private String bankBranch;
	private String accountHolder;
	private Long userId;
	private Long userIdUpdate;
	private Date dateCreated;
	private String bankNameValue;
	private Long companyId;
	
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
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getBankNameValue() {
		return bankNameValue;
	}
	public void setBankNameValue(String bankNameValue) {
		this.bankNameValue = bankNameValue;
	}
	@Override
	public String toString() {
		return "CorpBankDTO [bankName=" + bankName + ", accountNo=" + accountNo + ", ifscCode=" + ifscCode
				+ ", bankBranch=" + bankBranch + ", accountHolder=" + accountHolder + "]";
	}

	
}
