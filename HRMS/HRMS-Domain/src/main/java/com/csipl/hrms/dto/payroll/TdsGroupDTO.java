package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TdsGroupDTO {
	
	private Long tdsGroupId;
	private String tdsGroupName;                  
	private BigDecimal maxLimit;
	private String tdsDescription;
	private Long ageForExtra;
	private BigDecimal addLimitOnAge; 
	private String financialYear;
	private String isSubGroupLimit;
	private String isSubGroupReq;
	private Long userId;
	private Date dateCreated;
	private String activeStatus;
	private String effectiveStartDate;
	private Date effectiveEndDate;
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
	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}
	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
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
	private List<TdsSectionDTO> tdsSections = new ArrayList<TdsSectionDTO>();
	
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
	public String getIsSubGroupLimit() {
		return isSubGroupLimit;
	}
	public void setIsSubGroupLimit(String isSubGroupLimit) {
		this.isSubGroupLimit = isSubGroupLimit;
	}
	public String getIsSubGroupReq() {
		return isSubGroupReq;
	}
	public void setIsSubGroupReq(String isSubGroupReq) {
		this.isSubGroupReq = isSubGroupReq;
	}
	public List<TdsSectionDTO> getTdsSections() {
		return tdsSections;
	}
	public void setTdsSections(List<TdsSectionDTO> tdsSections) {
		this.tdsSections = tdsSections;
	}
	
	
}
