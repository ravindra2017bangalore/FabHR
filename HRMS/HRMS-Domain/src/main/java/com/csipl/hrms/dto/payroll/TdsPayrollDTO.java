package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;

public class TdsPayrollDTO {

	private Long transactionId;
	private BigDecimal actualAmount;
	private BigDecimal limitFrom;
	private BigDecimal limitTo;
	private BigDecimal taxAmouunt;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public BigDecimal getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}
	public BigDecimal getLimitFrom() {
		return limitFrom;
	}
	public void setLimitFrom(BigDecimal limitFrom) {
		this.limitFrom = limitFrom;
	}
	public BigDecimal getLimitTo() {
		return limitTo;
	}
	public void setLimitTo(BigDecimal limitTo) {
		this.limitTo = limitTo;
	}
	public BigDecimal getTaxAmouunt() {
		return taxAmouunt;
	}
	public void setTaxAmouunt(BigDecimal taxAmouunt) {
		this.taxAmouunt = taxAmouunt;
	}
	public BigDecimal getTdsPercentage() {
		return tdsPercentage;
	}
	public void setTdsPercentage(BigDecimal tdsPercentage) {
		this.tdsPercentage = tdsPercentage;
	}
	private BigDecimal tdsPercentage;
}
