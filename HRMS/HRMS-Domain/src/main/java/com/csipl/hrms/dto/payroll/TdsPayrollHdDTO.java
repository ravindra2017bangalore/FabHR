package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.List;

import com.csipl.hrms.model.payroll.TdsPayroll;

public class TdsPayrollHdDTO {
	
	private Long transactionHdId;
	private String financialYear;
	private BigDecimal grossIncome;
	private BigDecimal taxableAmount;
	private BigDecimal tdsApproved;
	private List<TdsPayrollDTO> tdsDtoPayDtorolls;
	
	public List<TdsPayrollDTO> getTdsDtoPayDtorolls() {
		return tdsDtoPayDtorolls;
	}
	public void setTdsDtoPayDtorolls(List<TdsPayrollDTO> tdsDtoPayDtorolls) {
		this.tdsDtoPayDtorolls = tdsDtoPayDtorolls;
	}
	public Long getTransactionHdId() {
		return transactionHdId;
	}
	public void setTransactionHdId(Long transactionHdId) {
		this.transactionHdId = transactionHdId;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public BigDecimal getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(BigDecimal grossIncome) {
		this.grossIncome = grossIncome;
	}
	public BigDecimal getTaxableAmount() {
		return taxableAmount;
	}
	public void setTaxableAmount(BigDecimal taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	public BigDecimal getTdsApproved() {
		return tdsApproved;
	}
	public void setTdsApproved(BigDecimal tdsApproved) {
		this.tdsApproved = tdsApproved;
	}
	

}
