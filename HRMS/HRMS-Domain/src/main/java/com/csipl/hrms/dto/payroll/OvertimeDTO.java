package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class OvertimeDTO {
	private Long overtimeId;
	private String activeStatus;
	private Long noOfDays;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
	private Long ratio;
	private BigDecimal fixAmount;

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

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getOvertimeId() {
		return overtimeId;
	}

	public void setOvertimeId(Long overtimeId) {
		this.overtimeId = overtimeId;
	}

	public Long getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Long noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Long getRatio() {
		return ratio;
	}

	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}

	public BigDecimal getFixAmount() {
		return fixAmount;
	}

	public void setFixAmount(BigDecimal fixAmount) {
		this.fixAmount = fixAmount;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

}
