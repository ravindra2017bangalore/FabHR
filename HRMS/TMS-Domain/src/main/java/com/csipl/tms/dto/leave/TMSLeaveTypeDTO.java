package com.csipl.tms.dto.leave;

import java.util.Date;
import java.util.List;


public class TMSLeaveTypeDTO {
	private Long leaveTypeId;

	private String activeStatus;

	private Long carryForwardLimit;

	private Long companyId;

	private Date dateCreated;


	private Date dateUpdate;

	private Long indexDays;

	private String isLeaveInProbation;

	private byte isWeekOffAsPL;

	private Long leaveFrequencyInMonth;

	private String leaveMode;
	
	private Long maxLeaveInMonth;

	private String nature;

	private Long notice;

	private Long userId;

	private Long userIdUpdate;

	private Long weekOffAsPLCount;

	private Long yearlyLimit;
	
 
	public Long leavePeriodId;
	
	public Long leaveTypeMasterId;
	
	public Long getLeaveTypeMasterId() {
		return leaveTypeMasterId;
	}

	public void setLeaveTypeMasterId(Long leaveTypeMasterId) {
		this.leaveTypeMasterId = leaveTypeMasterId;
	}

	public Long getLeavePeriodId() {
		return leavePeriodId;
	}

	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
	}


	

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCarryForwardLimit() {
		return carryForwardLimit;
	}

	public void setCarryForwardLimit(Long carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public Long getIndexDays() {
		return indexDays;
	}

	public void setIndexDays(Long indexDays) {
		this.indexDays = indexDays;
	}

	public String getIsLeaveInProbation() {
		return isLeaveInProbation;
	}

	public void setIsLeaveInProbation(String isLeaveInProbation) {
		this.isLeaveInProbation = isLeaveInProbation;
	}

	public byte getIsWeekOffAsPL() {
		return isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	public Long getLeaveFrequencyInMonth() {
		return leaveFrequencyInMonth;
	}

	public void setLeaveFrequencyInMonth(Long leaveFrequencyInMonth) {
		this.leaveFrequencyInMonth = leaveFrequencyInMonth;
	}

	public String getLeaveMode() {
		return leaveMode;
	}

	public void setLeaveMode(String leaveMode) {
		this.leaveMode = leaveMode;
	}

	public Long getMaxLeaveInMonth() {
		return maxLeaveInMonth;
	}

	public void setMaxLeaveInMonth(Long maxLeaveInMonth) {
		this.maxLeaveInMonth = maxLeaveInMonth;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Long getNotice() {
		return notice;
	}

	public void setNotice(Long notice) {
		this.notice = notice;
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

	public Long getWeekOffAsPLCount() {
		return weekOffAsPLCount;
	}

	public void setWeekOffAsPLCount(Long weekOffAsPLCount) {
		this.weekOffAsPLCount = weekOffAsPLCount;
	}

	public Long getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(Long yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	
}
