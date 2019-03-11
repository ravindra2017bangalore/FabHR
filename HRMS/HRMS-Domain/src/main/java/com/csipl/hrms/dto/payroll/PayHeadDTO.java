package com.csipl.hrms.dto.payroll;

import java.util.Date;

public class PayHeadDTO {
	
	private Long payHeadId;
	private String payHeadName;
	private String earningDeduction;
	private String expenseType;
	private String incomeType;
	private String earningDeductionValue;
	private String expenseTypeValue;
	private String incomeTypeValue;
	private String isApplicableOnGratuaty;
	private String isApplicableOnEsi;
	private String isApplicableOnPf;
	private String isApplicableOnPt;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
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
	public String getIsApplicableOnEsi() {
		return isApplicableOnEsi;
	}
	public void setIsApplicableOnEsi(String isApplicableOnEsi) {
		this.isApplicableOnEsi = isApplicableOnEsi;
	}
	public String getIsApplicableOnPf() {
		return isApplicableOnPf;
	}
	public void setIsApplicableOnPf(String isApplicableOnPf) {
		this.isApplicableOnPf = isApplicableOnPf;
	}
	public String getIsApplicableOnPt() {
		return isApplicableOnPt;
	}
	public void setIsApplicableOnPt(String isApplicableOnPt) {
		this.isApplicableOnPt = isApplicableOnPt;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getEarningDeductionValue() {
		return earningDeductionValue;
	}
	public void setEarningDeductionValue(String earningDeductionValue) {
		this.earningDeductionValue = earningDeductionValue;
	}
	public String getExpenseTypeValue() {
		return expenseTypeValue;
	}
	public void setExpenseTypeValue(String expenseTypeValue) {
		this.expenseTypeValue = expenseTypeValue;
	}
	public String getIncomeTypeValue() {
		return incomeTypeValue;
	}
	public void setIncomeTypeValue(String incomeTypeValue) {
		this.incomeTypeValue = incomeTypeValue;
	}
	public String getIsApplicableOnGratuaty() {
		return isApplicableOnGratuaty;
	}
	public void setIsApplicableOnGratuaty(String isApplicableOnGratuaty) {
		this.isApplicableOnGratuaty = isApplicableOnGratuaty;
	}
	public Long getPayHeadId() {
		return payHeadId;
	}
	public void setPayHeadId(Long payHeadId) {
		this.payHeadId = payHeadId;
	}
	public String getPayHeadName() {
		return payHeadName;
	}
	public void setPayHeadName(String payHeadName) {
		this.payHeadName = payHeadName;
	}
	public String getEarningDeduction() {
		return earningDeduction;
	}
	public void setEarningDeduction(String earningDeduction) {
		this.earningDeduction = earningDeduction;
	}
	
}
