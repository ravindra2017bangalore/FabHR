package com.csipl.hrms.dto.payrollprocess;

import com.csipl.hrms.dto.search.SearchDTO;

public class ReportPayoutSearchDTO extends SearchDTO {

	/*
	 * private String name; private String employeeCode; private String bankName;
	 * private String accountNumber; private Date dateOfJoining; private BigDecimal
	 * basic; private BigDecimal grossSalary; private BigDecimal otherAllowance;
	 * private BigDecimal absense; private BigDecimal casualleave; private
	 * BigDecimal seekleave; private BigDecimal paidleave;
	 */
	private Long departmentId;
	private String departmentName;
	private String processMonth;
	private Long companyId;
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
