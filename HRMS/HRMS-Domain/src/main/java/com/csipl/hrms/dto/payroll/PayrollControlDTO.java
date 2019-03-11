package com.csipl.hrms.dto.payroll;

import java.util.Date;

public class PayrollControlDTO {

	private String processMonth;
	private String departmentName;
	private Long departmentId;
	private int payrollDays;
	private Long controlId;
	private String activeStatus;
	private Long financialYearId;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
	private Long companyId;

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

	public Long getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getPayrollDays() {
		return payrollDays;
	}

	public void setPayrollDays(int payrollDays) {
		this.payrollDays = payrollDays;
	}

	public Long getControlId() {
		return controlId;
	}

	public void setControlId(Long controlId) {
		this.controlId = controlId;
	}

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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

}
