package com.csipl.hrms.dto.employee;

import java.util.Date;

public class SeparationDTO {

	private Long separationId;
	private Long approvalId;
	private Date dateCreated;
	private Date dateUpdate;
	private String description;
	private Date endDate;
	private String resoan;
	private String status;
	private Long userId;
 	private Long employeeId;
	private String reasonLabel;
	private String statusLabel;
	private String firstName;
	private String lastName;
	private String departmentName;
	private String employeeCode;
	private Date dateOfJoining;
	private String approverFirstName;
	private String approverLastName;
	private String remark;
	private boolean checkFlag;
	private Long companyId;
	private Long userIdUpdate;
	private Long inNoticePeriod;
 	private String designationName;
   	private String approverDepartment;
	private String approverDesignation;
	private String approverEmployeeLogoPath;
	private Long replacementEmployeeId;
	
	
	public Long getInNoticePeriod() {
		return inNoticePeriod;
	}

	public void setInNoticePeriod(Long inNoticePeriod) {
		this.inNoticePeriod = inNoticePeriod;
	}

	public int getSeparationCount() {
		return separationCount;
	}

	public void setSeparationCount(int separationCount) {
		this.separationCount = separationCount;
	}

	private int separationCount;
	public Long getSeparationId() {
		return separationId;
	}

	public void setSeparationId(Long separationId) {
		this.separationId = separationId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getResoan() {
		return resoan;
	}

	public void setResoan(String resoan) {
		this.resoan = resoan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getReasonLabel() {
		return reasonLabel;
	}

	public void setReasonLabel(String reasonLabel) {
		this.reasonLabel = reasonLabel;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getApproverFirstName() {
		return approverFirstName;
	}

	public String getApproverLastName() {
		return approverLastName;
	}

	public void setApproverFirstName(String approverFirstName) {
		this.approverFirstName = approverFirstName;
	}

	public void setApproverLastName(String approverLastName) {
		this.approverLastName = approverLastName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(boolean checkFlag) {
		this.checkFlag = checkFlag;
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

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getApproverDepartment() {
		return approverDepartment;
	}

	public void setApproverDepartment(String approverDepartment) {
		this.approverDepartment = approverDepartment;
	}

	public String getApproverDesignation() {
		return approverDesignation;
	}

	public void setApproverDesignation(String approverDesignation) {
		this.approverDesignation = approverDesignation;
	}

	public String getApproverEmployeeLogoPath() {
		return approverEmployeeLogoPath;
	}

	public void setApproverEmployeeLogoPath(String approverEmployeeLogoPath) {
		this.approverEmployeeLogoPath = approverEmployeeLogoPath;
	}

	public Long getReplacementEmployeeId() {
		return replacementEmployeeId;
	}

	public void setReplacementEmployeeId(Long replacementEmployeeId) {
		this.replacementEmployeeId = replacementEmployeeId;
	}

	@Override
	public String toString() {
		return "SeparationDTO [separationId=" + separationId + ", approvalId=" + approvalId + ", dateCreated="
				+ dateCreated + ", dateUpdate=" + dateUpdate + ", description=" + description + ", endDate=" + endDate
				+ ", resoan=" + resoan + ", status=" + status + ", userId=" + userId + ", employeeId=" + employeeId
				+ ", reasonLabel=" + reasonLabel + ", statusLabel=" + statusLabel + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", departmentName=" + departmentName + ", employeeCode=" + employeeCode
				+ ", dateOfJoining=" + dateOfJoining + ", approverFirstName=" + approverFirstName
				+ ", approverLastName=" + approverLastName + ", remark=" + remark + ", checkFlag=" + checkFlag
				+ ", companyId=" + companyId + ", userIdUpdate=" + userIdUpdate + ", inNoticePeriod=" + inNoticePeriod
				+ ", designationName=" + designationName + ", approverDepartment=" + approverDepartment
				+ ", approverDesignation=" + approverDesignation + ", approverEmployeeLogoPath="
				+ approverEmployeeLogoPath + ", separationCount=" + separationCount + "]";
	}

	 
}
