package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class TdsSectionDTO {

	private Long tdsSectionId;
	private String tdsSectionName;
	private String tdsDescription;
	private BigDecimal maxLimit;
	private Long ageForExtra;
	private BigDecimal addLimitOnAge;
	private String isParrentRecord;
	private Long userId;
	private Long userIdUpdate;
	private Date dateCreated;
	
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
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
	public String getTdsDescription() {
		return tdsDescription;
	}
	public void setTdsDescription(String tdsDescription) {
		this.tdsDescription = tdsDescription;
	}
	public BigDecimal getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
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
	public String getIsParrentRecord() {
		return isParrentRecord;
	}
	public void setIsParrentRecord(String isParrentRecord) {
		this.isParrentRecord = isParrentRecord;
	}

	
}
