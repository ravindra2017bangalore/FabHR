package com.csipl.hrms.dto.payrollprocess;

import java.math.BigDecimal;

public class PayOutDTO {
	private BigDecimal amount;
	private String payHeadName;
	private String processMonth;
	private Long payHeadId;
	private Long employeeId;
	private Long departmentId;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	private Long companyId;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPayHeadName() {
		return payHeadName;
	}

	public void setPayHeadName(String payHeadName) {
		this.payHeadName = payHeadName;
	}

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public Long getPayHeadId() {
		return payHeadId;
	}

	public void setPayHeadId(Long payHeadId) {
		this.payHeadId = payHeadId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
