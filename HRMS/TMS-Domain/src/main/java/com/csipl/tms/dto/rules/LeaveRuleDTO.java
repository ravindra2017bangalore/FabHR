package com.csipl.tms.dto.rules;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class LeaveRuleDTO {

	@ApiModelProperty(notes = "The database generated leave rule ID")
	private Long leaveRuleId;
	@ApiModelProperty(notes = "Week of as PL field")
	private byte isWeekOffAsPL;
	@ApiModelProperty(notes = "Leave ID field", required = true)
	private Long leaveTypeId;
	@ApiModelProperty(notes = "Leave index field", required = true)
	private double leaveIndex;
	@ApiModelProperty(notes = "Leave index day field", required = true)
	private Long leaveIndexDay;
 	@ApiModelProperty(notes = "User ID field", required = true)
 	private Long userId;
	@ApiModelProperty(notes = "Week of as PL count field")
	private Long weekOffAsPLCount;
	@ApiModelProperty(notes = "Company ID field", required = true)
 	private Long companyId;

	private String leaveType;
	private Date dateUpdate;
	private Long userIdUpdate;
	private Date dateCreated;
 	public Long getLeaveRuleId() {
		return leaveRuleId;
	}

	public void setLeaveRuleId(Long leaveRuleId) {
		this.leaveRuleId = leaveRuleId;
	}

	public byte getIsWeekOffAsPL() {
		return isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	 

	public double getLeaveIndex() {
		return leaveIndex;
	}

	public void setLeaveIndex(double leaveIndex) {
		this.leaveIndex = leaveIndex;
	}

	public Long getLeaveIndexDay() {
		return leaveIndexDay;
	}

	public void setLeaveIndexDay(Long leaveIndexDay) {
		this.leaveIndexDay = leaveIndexDay;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWeekOffAsPLCount() {
		return weekOffAsPLCount;
	}

	public void setWeekOffAsPLCount(Long weekOffAsPLCount) {
		this.weekOffAsPLCount = weekOffAsPLCount;
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

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

 

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

}