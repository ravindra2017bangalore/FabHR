package com.csipl.tms.dto.leave;

import java.util.Date; 
public class TMSLeaveEarnDTO {
private Long employeeLeaveEarnId;
	
	private Date dateCreated;
	
	private String financialYear;

	private Long leaveTaken;

	private Long totalLeave;

	private Long userId;
	
	private Long employeeId;
	
	private String leaveType;
	
	private Long leaveTypeId;
	
	private Long leaveBalance;

	public Long getEmployeeLeaveEarnId() {
		return employeeLeaveEarnId;
	}

	public void setEmployeeLeaveEarnId(Long employeeLeaveEarnId) {
		this.employeeLeaveEarnId = employeeLeaveEarnId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public Long getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(Long leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public Long getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Long totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Long getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Long leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}




}
