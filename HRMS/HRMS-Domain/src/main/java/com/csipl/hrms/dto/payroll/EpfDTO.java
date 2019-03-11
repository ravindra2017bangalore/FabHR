package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class EpfDTO {
	private Long epfId;
	private BigDecimal employeePer;
	private BigDecimal employerPer;
	private BigDecimal employerPensionPer;
	private BigDecimal adminPer;
	private BigDecimal edliPer;
	private BigDecimal edliExpPer;
	private BigDecimal maxBasicLimit;
	private Date effectiveDate;
	private String activeStatus;
	private Long userId;
	private Date dateCreated;
	private BigDecimal maxPensionLimit;
	private String isActual;
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
	public String getIsActual() {
		return isActual;
	}
	public void setIsActual(String isActual) {
		this.isActual = isActual;
	}
	public BigDecimal getMaxPensionLimit() {
		return maxPensionLimit;
	}
	public void setMaxPensionLimit(BigDecimal maxPensionLimit) {
		this.maxPensionLimit = maxPensionLimit;
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
	public Long getEpfId() {
		return epfId;
	}
	public void setEpfId(Long epfId) {
		this.epfId = epfId;
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
	public BigDecimal getEmployerPensionPer() {
		return employerPensionPer;
	}
	public void setEmployerPensionPer(BigDecimal employerPensionPer) {
		this.employerPensionPer = employerPensionPer;
	}
	public BigDecimal getAdminPer() {
		return adminPer;
	}
	public void setAdminPer(BigDecimal adminPer) {
		this.adminPer = adminPer;
	}
	public BigDecimal getEdliPer() {
		return edliPer;
	}
	public void setEdliPer(BigDecimal edliPer) {
		this.edliPer = edliPer;
	}
	public BigDecimal getEdliExpPer() {
		return edliExpPer;
	}
	public void setEdliExpPer(BigDecimal edliExpPer) {
		this.edliExpPer = edliExpPer;
	}
	public BigDecimal getMaxBasicLimit() {
		return maxBasicLimit;
	}
	public void setMaxBasicLimit(BigDecimal maxBasicLimit) {
		this.maxBasicLimit = maxBasicLimit;
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
	
	
	
}
