package com.csipl.tms.dto.attendanceregularizationrequest;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceRegularizationRequestDTO {

	@ApiModelProperty(notes = "The database generated Attendance regularization Id")
	private Long arID;
	@ApiModelProperty(notes = "Approval Id field")
	private Long approvalId;
	@ApiModelProperty(notes = "Approval Remark field")
	private String approvalRemark;
	@ApiModelProperty(notes = " Attendance regularization Category field", required = true)
	private String arCategory;
	@ApiModelProperty(notes = "UI generated Day field", required = true)
	private String arCategoryValue;
	private Long days;
	@ApiModelProperty(notes = "Company Id field", required = true)
	private Long companyId;
	@ApiModelProperty(notes = "Employee Id field", required = true)
	private Long employeeId;
	@ApiModelProperty(notes = "Employee Remark field", required = true)
	private String employeeRemark;
	@ApiModelProperty(notes = "From Date field", required = true)
	private Date fromDate;
	@ApiModelProperty(notes = "Status field", required = true)
	private String status;
	private String statusValue;
	@ApiModelProperty(notes = "To Date field", required = true)
	private Date toDate;
	@ApiModelProperty(notes = "User Id field", required = true)
	private Long userId;
	@ApiModelProperty(notes = "User Id update field", required = true)
	private Long userIdUpdate;
	@ApiModelProperty(notes = "Date created field", required = true)
	private Date dateCreated;
	@ApiModelProperty(notes = "Date update field", required = true)
	private Date updatedDate;
	@ApiModelProperty(notes = "Actionable Date field", required = true)
	private Date actionableDate;
	
	private String cancelRemark;

	/*
	 * these parameter only for views details start here
	 */
	private String employeeName;
	private String approvalByEmpName;
	private String employeeCode;
	private String approvalByEmpCode;
	private String employeeDepartment;
	private String approvalByEmpDepartment;
	private String employeeDesignation;
	private String approvalByEmpDesignation;
    private String charFirstName;
    private String charLastName;
    
	private int arCount;
	public int getArCount() {
		return arCount;
	}

	public void setArCount(int arCount) {
		this.arCount = arCount;
	}

	/*
	 * end here
	 */
	public AttendanceRegularizationRequestDTO() {
	}

	public Long getArID() {
		return arID;

	}

	public void setArID(Long arID) {
		this.arID = arID;
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

	public String getArCategory() {
		return arCategory;
	}

	public void setArCategory(String arCategory) {
		this.arCategory = arCategory;
	}

	public String getArCategoryValue() {
		return arCategoryValue;
	}

	public void setArCategoryValue(String arCategoryValue) {
		this.arCategoryValue = arCategoryValue;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getActionableDate() {
		return actionableDate;
	}

	public void setActionableDate(Date actionableDate) {
		this.actionableDate = actionableDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getApprovalByEmpName() {
		return approvalByEmpName;
	}

	public void setApprovalByEmpName(String approvalByEmpName) {
		this.approvalByEmpName = approvalByEmpName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getApprovalByEmpCode() {
		return approvalByEmpCode;
	}

	public void setApprovalByEmpCode(String approvalByEmpCode) {
		this.approvalByEmpCode = approvalByEmpCode;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getApprovalByEmpDepartment() {
		return approvalByEmpDepartment;
	}

	public void setApprovalByEmpDepartment(String approvalByEmpDepartment) {
		this.approvalByEmpDepartment = approvalByEmpDepartment;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getApprovalByEmpDesignation() {
		return approvalByEmpDesignation;
	}

	public void setApprovalByEmpDesignation(String approvalByEmpDesignation) {
		this.approvalByEmpDesignation = approvalByEmpDesignation;
	}

	@Override
	public String toString() {
		return "AttendanceRegularizationRequestDTO [arID=" + arID + ", approvalId=" + approvalId + ", approvalRemark="
				+ approvalRemark + ", arCategory=" + arCategory + ", arCategoryValue=" + arCategoryValue + ", days="
				+ days + ", companyId=" + companyId + ", employeeId=" + employeeId + ", employeeRemark="
				+ employeeRemark + ", fromDate=" + fromDate + ", status=" + status + ", statusValue=" + statusValue
				+ ", toDate=" + toDate + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate + ", dateCreated="
				+ dateCreated + ", updatedDate=" + updatedDate + ", actionableDate=" + actionableDate
				+ ", employeeName=" + employeeName + ", approvalByEmpName=" + approvalByEmpName + ", employeeCode="
				+ employeeCode + ", approvalByEmpCode=" + approvalByEmpCode + ", employeeDepartment="
				+ employeeDepartment + ", approvalByEmpDepartment=" + approvalByEmpDepartment + ", employeeDesignation="
				+ employeeDesignation + ", approvalByEmpDesignation=" + approvalByEmpDesignation + "]";
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

	public String getCharFirstName() {
		return charFirstName;
	}

	public void setCharFirstName(String charFirstName) {
		this.charFirstName = charFirstName;
	}

	public String getCharLastName() {
		return charLastName;
	}

	public void setCharLastName(String charLastName) {
		this.charLastName = charLastName;
	}

}
