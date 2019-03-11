package com.csipl.hrms.dto.payroll;

public class EmployeeCodeDTO {

	private String employeeCode;
	private Long departmentId;
	private Long employeeId;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Long getDepartmentId() {
		return departmentId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}
