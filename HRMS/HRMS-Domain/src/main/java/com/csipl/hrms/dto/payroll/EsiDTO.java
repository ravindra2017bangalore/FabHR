package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class EsiDTO {
	private Long esiId;
	private BigDecimal employeePer;

	private BigDecimal employerPer;
	private BigDecimal maxGrossLimit;
	private Date effectiveDate;
	private String activeStatus;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
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
	public Long getEsiId() {
		return esiId;
	}
	public void setEsiId(Long esiId) {
		this.esiId = esiId;
	}
	public BigDecimal getEmployeePer() {
		return employeePer;
	}
	public void setEmployeePer(BigDecimal employeePer) {
		this.employeePer = employeePer;
	}
	public BigDecimal getEmployerPer() {
		return employerPer;
	}
	public void setEmployerPer(BigDecimal employerPer) {
		this.employerPer = employerPer;
	}
	public BigDecimal getMaxGrossLimit() {
		return maxGrossLimit;
	}
	public void setMaxGrossLimit(BigDecimal maxGrossLimit) {
		this.maxGrossLimit = maxGrossLimit;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

}
