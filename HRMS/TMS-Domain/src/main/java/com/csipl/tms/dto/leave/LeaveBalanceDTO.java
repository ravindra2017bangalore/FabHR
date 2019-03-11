package com.csipl.tms.dto.leave;

import java.math.BigDecimal;
import java.util.Date;

 
public class LeaveBalanceDTO {

	private String leaveType;
	private String leaveRuleType;
	private Long yearlyLimit;
	private BigDecimal leaveTaken;
	private BigDecimal leaveBalance;
	private Long employeeId;
	private Long leaveTypeId;
	private Long leaveTypeHdId;

	private Long maxLeaveInMonth;
	private Long leaveFrequencyInMonth;
	private Date effectiveStartDate;
	private Date effectiveEndDate;
	private Long weekOffPatternId ;
	private String patternDays;
 	private Long probationDays ;
	private Date dateOfJoining;

 	private String isLeaveInProbation;
	
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveRuleType() {
		return leaveRuleType;
	}

	public void setLeaveRuleType(String leaveRuleType) {
		this.leaveRuleType = leaveRuleType;
	}

	public Long getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(Long yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

   	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getMaxLeaveInMonth() {
		return maxLeaveInMonth;
	}

	public void setMaxLeaveInMonth(Long maxLeaveInMonth) {
		this.maxLeaveInMonth = maxLeaveInMonth;
	}

	public Long getLeaveFrequencyInMonth() {
		return leaveFrequencyInMonth;
	}

	public void setLeaveFrequencyInMonth(Long leaveFrequencyInMonth) {
		this.leaveFrequencyInMonth = leaveFrequencyInMonth;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Long getWeekOffPatternId() {
		return weekOffPatternId;
	}

	public void setWeekOffPatternId(Long weekOffPatternId) {
		this.weekOffPatternId = weekOffPatternId;
	}

	public String getPatternDays() {
		return patternDays;
	}

	public void setPatternDays(String patternDays) {
		this.patternDays = patternDays;
	}
 

	public Long getProbationDays() {
		return probationDays;
	}

	public void setProbationDays(Long probationDays) {
		this.probationDays = probationDays;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

 
	 

	public Long getLeaveTypeHdId() {
		return leaveTypeHdId;
	}

	public void setLeaveTypeHdId(Long leaveTypeHdId) {
		this.leaveTypeHdId = leaveTypeHdId;
	}

	public String getIsLeaveInProbation() {
		return isLeaveInProbation;
	}

	public void setIsLeaveInProbation(String isLeaveInProbation) {
		this.isLeaveInProbation = isLeaveInProbation;
	}

	public BigDecimal getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(BigDecimal leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public BigDecimal getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(BigDecimal leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

}
