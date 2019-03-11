package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class InvestmentDTO {

	private Long tdsGroupId;
	private String tdsGroupName;                  
	private BigDecimal maxLimit;
	private String tdsDescription;
	private Long ageForExtra;
	private BigDecimal addLimitOnAge; 
	private String financialYear;
	private Long tdsSectionId;
	private String tdsSectionName;
	private String effectiveStartDate;
	private String effectiveEndDate;
	
	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	public String getEffectiveEndDate() {
		return effectiveEndDate;
	}
	public void setEffectiveEndDate(String effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}
	public Long getTdsGroupId() {
		return tdsGroupId;
	}
	public void setTdsGroupId(Long tdsGroupId) {
		this.tdsGroupId = tdsGroupId;
	}
	public String getTdsGroupName() {
		return tdsGroupName;
	}
	public void setTdsGroupName(String tdsGroupName) {
		this.tdsGroupName = tdsGroupName;
	}
	public BigDecimal getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}
	public String getTdsDescription() {
		return tdsDescription;
	}
	public void setTdsDescription(String tdsDescription) {
		this.tdsDescription = tdsDescription;
	}
	public Long getAgeForExtra() {
		return ageForExtra;
	}
	public void setAgeForExtra(Long ageForExtra) {
		this.ageForExtra = ageForExtra;
	}
	public BigDecimal getAddLimitOnAge() {
		return addLimitOnAge;
	}
	public void setAddLimitOnAge(BigDecimal addLimitOnAge) {
		this.addLimitOnAge = addLimitOnAge;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public Long getTdsSectionId() {
		return tdsSectionId;
	}
	public void setTdsSectionId(Long tdsSectionId) {
		this.tdsSectionId = tdsSectionId;
	}
	public String getTdsSectionName() {
		return tdsSectionName;
	}
	public void setTdsSectionName(String tdsSectionName) {
		this.tdsSectionName = tdsSectionName;
	}
}
