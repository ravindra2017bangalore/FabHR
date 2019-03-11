package com.csipl.hrms.service.candidate.adaptor;

import com.csipl.hrms.model.employee.EmpCommonDetail;
import com.csipl.hrms.model.employee.Employee;

public class EmpCommonDetailsAdaptor {

	public EmpCommonDetail employeeToEmpCommonDetail(Employee employeeObj) {

		EmpCommonDetail empCommonDetail = new EmpCommonDetail();

		empCommonDetail.setEmployeeId(employeeObj.getEmployeeId());
		empCommonDetail.setEmployeeCode(employeeObj.getEmployeeCode());
		empCommonDetail.setFirstName(employeeObj.getFirstName());
		empCommonDetail.setLastName(employeeObj.getLastName());
		empCommonDetail.setMobile(employeeObj.getAddress1().getMobile());
		empCommonDetail.setEmailId(employeeObj.getAddress1().getEmailId());
		empCommonDetail.setJoiningDate(employeeObj.getDateOfJoining());
		empCommonDetail.setDepartmentId(employeeObj.getDepartment().getDepartmentId());
		empCommonDetail.setDepartmentName(employeeObj.getDepartment().getDepartmentName());
		empCommonDetail.setDesignationId(employeeObj.getDesignation().getDesignationId());
		empCommonDetail.setDesignationName(employeeObj.getDesignation().getDesignationName());
		empCommonDetail.setCompanyId(employeeObj.getCompany().getCompanyId());
		empCommonDetail.setCompanyName(employeeObj.getCompany().getCompanyName());

		return empCommonDetail;
	}

}