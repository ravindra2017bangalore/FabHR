package com.csipl.tms.dto.leave;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class LeaveTypeDTO {

	@ApiModelProperty(notes = "The database generated leaveType ID")
	private Long leaveTypeId;

	@ApiModelProperty(notes = "Number of leaves carry forword limit")
	private Long carryForwardLimit;

	@ApiModelProperty(notes = "Number of leaves Frequency In Month")
	private Long leaveFrequencyInMonth;

	@ApiModelProperty(notes = "Type of leave", required = true)
	private String leaveType;

	@ApiModelProperty(notes = "Max leaves in a month")
	private Long maxLeaveInMonth;

	@ApiModelProperty(notes = "Leaves Nature")
	private String nature;

	@ApiModelProperty(notes = "Leaves Nature Value")
	private String natureValue;

	@ApiModelProperty(notes = "leave notice days")
	private Long notice;

	@ApiModelProperty(notes = "Number of leaves yearly", required = true)
	private Long yearlyLimit;

	@ApiModelProperty(notes = "Leave allowed for probation or not")
	private String isLeaveInProbation;

	@ApiModelProperty(notes = "Leave  probation values")
	private String isLeaveInProbationValue;
	
	@ApiModelProperty(notes = "Leave  index values")
	private BigDecimal indexCol;

	@ApiModelProperty(notes = "Leave  index days")
	private Long indexDays;
	
	@ApiModelProperty(notes = "Leave  isWeekOffAsPL is must be 0 or 1")
	private byte isWeekOffAsPL;
	
	private Long weekOffAsPLCount;

	@ApiModelProperty(notes = "Company ID field", required = true)
 	private Long companyId;

	@ApiModelProperty(notes = "User ID field", required = true)
	private Long userId;
	
	@ApiModelProperty(notes = "Date update field", required = true)
 	private Date dateUpdate;

	@ApiModelProperty(notes = "Date created field", required = true)
	private Date dateCreated;
	
	@ApiModelProperty(notes = "User ID update field")
	private Long userIdUpdate;
 
	private String ruleName;
 	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Long getCarryForwardLimit() {
		return carryForwardLimit;
	}

	public void setCarryForwardLimit(Long carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
	}

	public Long getLeaveFrequencyInMonth() {
		return leaveFrequencyInMonth;
	}

	public void setLeaveFrequencyInMonth(Long leaveFrequencyInMonth) {
		this.leaveFrequencyInMonth = leaveFrequencyInMonth;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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

	public Long getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(Long yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public byte getIsWeekOffAsPL() {
		return isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	public BigDecimal getIndexCol() {
		return indexCol;
	}

	public void setIndexCol(BigDecimal indexCol) {
		this.indexCol = indexCol;
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

	public String getNatureValue() {
		return natureValue;
	}

	public void setNatureValue(String natureValue) {
		this.natureValue = natureValue;
	}

	public String getIsLeaveInProbationValue() {
		return isLeaveInProbationValue;
	}

	public void setIsLeaveInProbationValue(String isLeaveInProbationValue) {
		this.isLeaveInProbationValue = isLeaveInProbationValue;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}


	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}



	 
}
