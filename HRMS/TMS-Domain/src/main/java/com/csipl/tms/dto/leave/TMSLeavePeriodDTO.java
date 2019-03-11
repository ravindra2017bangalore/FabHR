package com.csipl.tms.dto.leave;

import java.util.Date;



public class TMSLeavePeriodDTO {
	private Long leavePeriodId;

	private String activeStatus;

	private Date dateCreated;
	
	private Date dateUpdate;

	private Date endDate;

	private String leavePeriodName;

	private Date startDate;

	private Long userId;
	private Long companyId;

	private Long userIdUpdate;
	public Long getLeavePeriodId() {
		return leavePeriodId;
	}

	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeavePeriodName() {
		return leavePeriodName;
	}

	public void setLeavePeriodName(String leavePeriodName) {
		this.leavePeriodName = leavePeriodName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	
}
