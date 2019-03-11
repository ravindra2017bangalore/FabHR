package com.csipl.hrms.dto.report;

import java.math.BigDecimal;

import javax.persistence.Column;

public class PfReportTableDTO {

	private String processMonth;
	private BigDecimal providentFundEmployerPension;
	private BigDecimal providentFundEmployee;
	private BigDecimal providentFundEmployer;

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}


	public BigDecimal getProvidentFundEmployee() {
		return providentFundEmployee;
	}

	public void setProvidentFundEmployee(BigDecimal providentFundEmployee) {
		this.providentFundEmployee = providentFundEmployee;
	}

	public BigDecimal getProvidentFundEmployer() {
		return providentFundEmployer;
	}

	public void setProvidentFundEmployer(BigDecimal providentFundEmployer) {
		this.providentFundEmployer = providentFundEmployer;
	}

	public BigDecimal getProvidentFundEmployerPension() {
		return providentFundEmployerPension;
	}

	public void setProvidentFundEmployerPension(BigDecimal providentFundEmployerPension) {
		this.providentFundEmployerPension = providentFundEmployerPension;
	}

	
}
