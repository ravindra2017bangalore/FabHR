package com.csipl.hrms.dto.report;

public class DepartmentReportDTO {
	
	String deptNAME;
	String empDegn;
	String empCtc;
	
	String deptCTC;
	
	String lastMonth;
	
	public String getDeptNAME() {
		return deptNAME;
	}
	public void setDeptNAME(String deptNAME) {
		this.deptNAME = deptNAME;
	}
	public String getDeptCTC() {
		return deptCTC;
	}
	public void setDeptCTC(String deptCTC) {
		this.deptCTC = deptCTC;
	}
	public String getLastMonth() {
		return lastMonth;
	}
	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}
	public String getEmpDegn() {
		return empDegn;
	}
	public void setEmpDegn(String empDegn) {
		this.empDegn = empDegn;
	}
	public String getEmpCtc() {
		return empCtc;
	}
	public void setEmpCtc(String empCtc) {
		this.empCtc = empCtc;
	}
	
	

}
