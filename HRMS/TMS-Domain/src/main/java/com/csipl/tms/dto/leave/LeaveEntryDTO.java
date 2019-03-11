package com.csipl.tms.dto.leave;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeDTO;

import io.swagger.annotations.ApiModelProperty;

public class LeaveEntryDTO {

	@ApiModelProperty(notes = "The database generated leaveId ID")
	private Long leaveId;

	@ApiModelProperty(notes = "ApprovalId ID ")
	private Long approvalId;

	@ApiModelProperty(notes = "Leave Type ID")
	private Long leaveTypeId;

	@ApiModelProperty(notes = "Notification ID")
	private Long notificationId;

	@ApiModelProperty(notes = "Approval Remark")
	private String approvalRemark;

	@ApiModelProperty(notes = "Number of leave days")
	private BigDecimal days;

	@ApiModelProperty(notes = "Employee ID")
	private Long employeeId;

	@ApiModelProperty(notes = "Company ID")
	private Long companyId;

	@ApiModelProperty(notes = "Employee Remark")
	private String employeeRemark;

	@ApiModelProperty(notes = "Leave start date")
	private Date fromDate;

	@ApiModelProperty(notes = "Half day OR full day field")
	private String half_fullDay;

	@ApiModelProperty(notes = "Half day for first hslf OR second half ")
	private String halfDayFor;

	@ApiModelProperty(notes = "Start date")
	private Date startDate;

	@ApiModelProperty(notes = "End Date")
	private Date endDate;

	@ApiModelProperty(notes = "Leave type field")
	private String leaveType;

	@ApiModelProperty(notes = "Check for approval field")
	private byte isApproved;

	@ApiModelProperty(notes = "Check for approval read field")
	private byte isRead;

	@ApiModelProperty(notes = "leave status field")
	private String status;

	@ApiModelProperty(notes = "half Day For Value field for view")
	private String halfDayForValue;

	@ApiModelProperty(notes = "to date field")
	private Date toDate;

	@ApiModelProperty(notes = "User id field")
	private Long userId;

	@ApiModelProperty(notes = "User id update field")
	private Long userIdUpdate;

	@ApiModelProperty(notes = "Date created field")
	private Date dateCreated;

	@ApiModelProperty(notes = "Date update field")
	private Date dateUpdate;

	@ApiModelProperty(notes = "Actinable fate for view")
	private Date actionableDate;

	@ApiModelProperty(notes = "Status value for view")
	private String statusValue;

	@ApiModelProperty(notes = "Employee code field for view")
	private String employeeCode;

	@ApiModelProperty(notes = "Employee name field for view")
	private String employeeName;

	@ApiModelProperty(notes = "Employee department field for view")
	private String department;

	@ApiModelProperty(notes = "Employee designation field for view")
	private String designation;

	@ApiModelProperty(notes = "Approval employee code field for view")
	private String approvalEmployeeCode;

	@ApiModelProperty(notes = "Approval employee name field for view")
	private String approvalEmployeeName;

	@ApiModelProperty(notes = "Approval employee department field for view")
	private String approvalEmployeeDepartment;

	@ApiModelProperty(notes = "Approval employee designation field for view")
	private String approvalEmployeeDesignation;
	
	private int leaveCount;
	private String cancleRemark;
	private String notifyEmployee;
	private List<EmployeeDTO> notifyEmployeeList;

	public String getCancleRemark() {
		return cancleRemark;
	}

	public void setCancleRemark(String cancleRemark) {
		this.cancleRemark = cancleRemark;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeRemark() {
		return employeeRemark;
	}

	public void setEmployeeRemark(String employeeRemark) {
		this.employeeRemark = employeeRemark;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public String getHalf_fullDay() {
		return half_fullDay;
	}

	public void setHalf_fullDay(String half_fullDay) {
		this.half_fullDay = half_fullDay;
	}

	public String getHalfDayFor() {
		return halfDayFor;
	}

	public void setHalfDayFor(String halfDayFor) {
		this.halfDayFor = halfDayFor;
	}

	public byte getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(byte isApproved) {
		this.isApproved = isApproved;
	}

	public byte getIsRead() {
		return isRead;
	}

	public void setIsRead(byte isRead) {
		this.isRead = isRead;
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

	public String getNotifyEmployee() {
		return notifyEmployee;
	}

	public void setNotifyEmployee(String notifyEmployee) {
		this.notifyEmployee = notifyEmployee;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
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

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getActionableDate() {
		return actionableDate;
	}

	public void setActionableDate(Date actionableDate) {
		this.actionableDate = actionableDate;
	}

	public String getHalfDayForValue() {
		return halfDayForValue;
	}

	public void setHalfDayForValue(String halfDayForValue) {
		this.halfDayForValue = halfDayForValue;
	}

	@Override
	public String toString() {
		return "LeaveEntryDTO [leaveId=" + leaveId + ", approvalId=" + approvalId + ", leaveTypeId=" + leaveTypeId
				+ ", notificationId=" + notificationId + ", approvalRemark=" + approvalRemark + ", days=" + days
				+ ", employeeId=" + employeeId + ", companyId=" + companyId + ", employeeRemark=" + employeeRemark
				+ ", fromDate=" + fromDate + ", half_fullDay=" + half_fullDay + ", halfDayFor=" + halfDayFor
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", leaveType=" + leaveType + ", isApproved="
				+ isApproved + ", isRead=" + isRead + ", status=" + status + ", halfDayForValue=" + halfDayForValue
				+ ", toDate=" + toDate + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate + ", dateCreated="
				+ dateCreated + ", dateUpdate=" + dateUpdate + ", actionableDate=" + actionableDate + ", statusValue="
				+ statusValue + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", department="
				+ department + ", designation=" + designation + ", approvalEmployeeCode=" + approvalEmployeeCode
				+ ", approvalEmployeeName=" + approvalEmployeeName + ", approvalEmployeeDepartment="
				+ approvalEmployeeDepartment + ", approvalEmployeeDesignation=" + approvalEmployeeDesignation + "]";
	}

	public BigDecimal getDays() {
		return days;
	}

	public void setDays(BigDecimal days) {
		this.days = days;
	}

	public List<EmployeeDTO> getNotifyEmployeeList() {
		return notifyEmployeeList;
	}

	public void setNotifyEmployeeList(List<EmployeeDTO> notifyEmployeeList) {
		this.notifyEmployeeList = notifyEmployeeList;
	}

}
