package com.csipl.tms.dto.leave;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

public class CompensatoryOffDTO {

	private Long tmsCompensantoryOffId;

	private Long approvalId;

	private String approvalRemark;

	private Date dateCreated;

	private Date dateUpdate;

	private Long employeeId;

	private Date fromDate;

	private Long leaveTypeId;

	private String remark;

	private String status;

	private Date toDate;
  
	private String statusValue;

    private Long days;
	
    private Long userId;
    
    private String cancelRemark;

    private String employeeCode;

	private String employeeName;

	private String department;

	private String designation;
	
	private String approvalEmployeeCode;

	private String approvalEmployeeName;

	private String approvalEmployeeDepartment;

	private String approvalEmployeeDesignation;
	
	
	private Long userIdUpdate;
	private Long companyId;
	public Long getTmsCompensantoryOffId() {
		return tmsCompensantoryOffId;
	}

	public void setTmsCompensantoryOffId(Long tmsCompensantoryOffId) {
		this.tmsCompensantoryOffId = tmsCompensantoryOffId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getApprovalEmployeeCode() {
		return approvalEmployeeCode;
	}

	public void setApprovalEmployeeCode(String approvalEmployeeCode) {
		this.approvalEmployeeCode = approvalEmployeeCode;
	}

	public String getApprovalEmployeeName() {
		return approvalEmployeeName;
	}

	public void setApprovalEmployeeName(String approvalEmployeeName) {
		this.approvalEmployeeName = approvalEmployeeName;
	}

	public String getApprovalEmployeeDepartment() {
		return approvalEmployeeDepartment;
	}

	public void setApprovalEmployeeDepartment(String approvalEmployeeDepartment) {
		this.approvalEmployeeDepartment = approvalEmployeeDepartment;
	}

	public String getApprovalEmployeeDesignation() {
		return approvalEmployeeDesignation;
	}

	public void setApprovalEmployeeDesignation(String approvalEmployeeDesignation) {
		this.approvalEmployeeDesignation = approvalEmployeeDesignation;
	}

//	@Override
//	public String toString() {
//		return "CompensatoryOffDTO [tmsCompensantoryOffId=" + tmsCompensantoryOffId + ", approvalId=" + approvalId
//				+ ", approvalRemark=" + approvalRemark + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate
//				+ ", employeeId=" + employeeId + ", fromDate=" + fromDate + ", leaveTypeId=" + leaveTypeId + ", remark="
//				+ remark + ", status=" + status + ", toDate=" + toDate + ", userId=" + userId + ", userIdUpdate="
//				+ userIdUpdate + "]";
//	}
	
	
}
