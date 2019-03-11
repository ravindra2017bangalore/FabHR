package com.csipl.hrms.dto.report;

import java.math.BigDecimal;

public class EsiReportTableDTO {
	private String processMonth;
	private BigDecimal esi_Employee;

	private BigDecimal esi_Employer;

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public BigDecimal getEsi_Employee() {
		return esi_Employee;
	}

	public void setEsi_Employee(BigDecimal esi_Employee) {
		this.esi_Employee = esi_Employee;
	}

	public BigDecimal getEsi_Employer() {
		return esi_Employer;
	}

	public void setEsi_Employer(BigDecimal esi_Employer) {
		this.esi_Employer = esi_Employer;
	}

}
