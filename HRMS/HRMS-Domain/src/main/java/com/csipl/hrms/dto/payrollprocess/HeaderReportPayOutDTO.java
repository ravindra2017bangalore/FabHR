package com.csipl.hrms.dto.payrollprocess;

import java.math.BigDecimal;

public class HeaderReportPayOutDTO {
	
private Long departmentId;
private String departmentName;
private BigDecimal sumOfBasicEarning;
private BigDecimal sumOfGrossSalary;
private BigDecimal sumOfNetPayableAmount;
private BigDecimal sumOfProvidentFundEmployee;
private BigDecimal sumOfProvidentFundEmployer;
private BigDecimal sumOfEsi_Employee;
private BigDecimal sumOfEsi_Employer;
private BigDecimal sumOfPt;
private BigDecimal sumOfTds;
private BigDecimal sumOfloan;
private String processMonth;

public final Long getDepartmentId() {
	return departmentId;
}
public final void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public final String getDepartmentName() {
	return departmentName;
}
public final void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public final BigDecimal getSumOfBasicEarning() {
	return sumOfBasicEarning;
}
public final void setSumOfBasicEarning(BigDecimal sumOfBasicEarning) {
	this.sumOfBasicEarning = sumOfBasicEarning;
}
public final BigDecimal getSumOfGrossSalary() {
	return sumOfGrossSalary;
}
public final void setSumOfGrossSalary(BigDecimal sumOfGrossSalary) {
	this.sumOfGrossSalary = sumOfGrossSalary;
}
public final BigDecimal getSumOfNetPayableAmount() {
	return sumOfNetPayableAmount;
}
public final void setSumOfNetPayableAmount(BigDecimal sumOfNetPayableAmount) {
	this.sumOfNetPayableAmount = sumOfNetPayableAmount;
}
public final BigDecimal getSumOfProvidentFundEmployee() {
	return sumOfProvidentFundEmployee;
}
public final void setSumOfProvidentFundEmployee(BigDecimal sumOfProvidentFundEmployee) {
	this.sumOfProvidentFundEmployee = sumOfProvidentFundEmployee;
}
public final BigDecimal getSumOfProvidentFundEmployer() {
	return sumOfProvidentFundEmployer;
}
public final void setSumOfProvidentFundEmployer(BigDecimal sumOfProvidentFundEmployer) {
	this.sumOfProvidentFundEmployer = sumOfProvidentFundEmployer;
}
public final BigDecimal getSumOfEsi_Employee() {
	return sumOfEsi_Employee;
}
public final void setSumOfEsi_Employee(BigDecimal sumOfEsi_Employee) {
	this.sumOfEsi_Employee = sumOfEsi_Employee;
}
public final BigDecimal getSumOfEsi_Employer() {
	return sumOfEsi_Employer;
}
public final void setSumOfEsi_Employer(BigDecimal sumOfEsi_Employer) {
	this.sumOfEsi_Employer = sumOfEsi_Employer;
}
public final BigDecimal getSumOfPt() {
	return sumOfPt;
}
public final void setSumOfPt(BigDecimal sumOfPt) {
	this.sumOfPt = sumOfPt;
}
public final BigDecimal getSumOfTds() {
	return sumOfTds;
}
public final void setSumOfTds(BigDecimal sumOfTds) {
	this.sumOfTds = sumOfTds;
}
public final BigDecimal getSumOfloan() {
	return sumOfloan;
}
public final void setSumOfloan(BigDecimal sumOfloan) {
	this.sumOfloan = sumOfloan;
}
public String getProcessMonth() {
	return processMonth;
}
public void setProcessMonth(String processMonth) {
	this.processMonth = processMonth;
}
 
}
