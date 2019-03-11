package com.csipl.hrms.common.enums;

public enum EmployeeStatusEnum {
	ActiveStatus("AC");
	public String employeeStatus;

	EmployeeStatusEnum(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}
}
