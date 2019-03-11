package com.csipl.hrms.dto.payrollprocess;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ReportSummaryDTO {

	private BigInteger epfExcludedEmpCount;
	private BigDecimal epfExcludedGrassSum;
	
	public BigInteger getEpfExcludedEmpCount() {
		return epfExcludedEmpCount;
	}
	public void setEpfExcludedEmpCount(BigInteger epfExcludedEmpCount) {
		this.epfExcludedEmpCount = epfExcludedEmpCount;
	}
	public BigDecimal getEpfExcludedGrassSum() {
		return epfExcludedGrassSum;
	}
	public void setEpfExcludedGrassSum(BigDecimal epfExcludedGrassSum) {
		this.epfExcludedGrassSum = epfExcludedGrassSum;
	}

}
