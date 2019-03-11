package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;

public class TdsSummaryDTO {

	private BigDecimal yearlyGross;
	private BigDecimal otherIncome;
	private BigDecimal netYearlyIncome;
	private BigDecimal exempStandard;
	private BigDecimal exempPfAmount;
	private BigDecimal exempPtAmount;
	private BigDecimal exempEsicAmount;
	private BigDecimal exempAmountAsPerSlab;
	private BigDecimal exemptedTotalIncome;
	private BigDecimal yearlyTaxableIncome;
	private BigDecimal taxableIncomeFy ;
	private BigDecimal tdsYearlyBeforeDeclaration;
	private BigDecimal tdsMonthlyBeforeDeclaration;
	private BigDecimal incomeDeclared;
	private BigDecimal declaredIncomeApproved;
	private BigDecimal netTaxableIncome;
	private BigDecimal tdsYearlyAfterDeclaration;
	private BigDecimal tdsMonthlyAfterDeclaration;
	private String financialYear;
	private BigDecimal section84ARebateAmount;
	
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public BigDecimal getYearlyGross() {
		return yearlyGross;
	}
	public void setYearlyGross(BigDecimal yearlyGross) {
		this.yearlyGross = yearlyGross;
	}
	public BigDecimal getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}
	public BigDecimal getNetYearlyIncome() {
		return netYearlyIncome;
	}
	public void setNetYearlyIncome(BigDecimal netYearlyIncome) {
		this.netYearlyIncome = netYearlyIncome;
	}
	public BigDecimal getExempStandard() {
		return exempStandard;
	}
	public void setExempStandard(BigDecimal exempStandard) {
		this.exempStandard = exempStandard;
	}
	public BigDecimal getExempPfAmount() {
		return exempPfAmount;
	}
	public void setExempPfAmount(BigDecimal exempPfAmount) {
		this.exempPfAmount = exempPfAmount;
	}
	public BigDecimal getExempPtAmount() {
		return exempPtAmount;
	}
	public void setExempPtAmount(BigDecimal exempPtAmount) {
		this.exempPtAmount = exempPtAmount;
	}
	public BigDecimal getExempEsicAmount() {
		return exempEsicAmount;
	}
	public void setExempEsicAmount(BigDecimal exempEsicAmount) {
		this.exempEsicAmount = exempEsicAmount;
	}
	public BigDecimal getExempAmountAsPerSlab() {
		return exempAmountAsPerSlab;
	}
	public void setExempAmountAsPerSlab(BigDecimal exempAmountAsPerSlab) {
		this.exempAmountAsPerSlab = exempAmountAsPerSlab;
	}
	public BigDecimal getExemptedTotalIncome() {
		return exemptedTotalIncome;
	}
	public void setExemptedTotalIncome(BigDecimal exemptedTotalIncome) {
		this.exemptedTotalIncome = exemptedTotalIncome;
	}
	public BigDecimal getYearlyTaxableIncome() {
		return yearlyTaxableIncome;
	}
	public void setYearlyTaxableIncome(BigDecimal yearlyTaxableIncome) {
		this.yearlyTaxableIncome = yearlyTaxableIncome;
	}
	public BigDecimal getTaxableIncomeFy() {
		return taxableIncomeFy;
	}
	public void setTaxableIncomeFy(BigDecimal taxableIncomeFy) {
		this.taxableIncomeFy = taxableIncomeFy;
	}
	public BigDecimal getIncomeDeclared() {
		return incomeDeclared;
	}
	public BigDecimal getTdsYearlyBeforeDeclaration() {
		return tdsYearlyBeforeDeclaration;
	}
	public void setTdsYearlyBeforeDeclaration(BigDecimal tdsYearlyBeforeDeclaration) {
		this.tdsYearlyBeforeDeclaration = tdsYearlyBeforeDeclaration;
	}
	public BigDecimal getTdsMonthlyBeforeDeclaration() {
		return tdsMonthlyBeforeDeclaration;
	}
	public void setTdsMonthlyBeforeDeclaration(BigDecimal tdsMonthlyBeforeDeclaration) {
		this.tdsMonthlyBeforeDeclaration = tdsMonthlyBeforeDeclaration;
	}
	public void setIncomeDeclared(BigDecimal incomeDeclared) {
		this.incomeDeclared = incomeDeclared;
	}
	public BigDecimal getDeclaredIncomeApproved() {
		return declaredIncomeApproved;
	}
	public void setDeclaredIncomeApproved(BigDecimal declaredIncomeApproved) {
		this.declaredIncomeApproved = declaredIncomeApproved;
	}
	public BigDecimal getNetTaxableIncome() {
		return netTaxableIncome;
	}
	public void setNetTaxableIncome(BigDecimal netTaxableIncome) {
		this.netTaxableIncome = netTaxableIncome;
	}
	public BigDecimal getTdsYearlyAfterDeclaration() {
		return tdsYearlyAfterDeclaration;
	}
	public void setTdsYearlyAfterDeclaration(BigDecimal tdsYearlyAfterDeclaration) {
		this.tdsYearlyAfterDeclaration = tdsYearlyAfterDeclaration;
	}
	public BigDecimal getTdsMonthlyAfterDeclaration() {
		return tdsMonthlyAfterDeclaration;
	}
	public void setTdsMonthlyAfterDeclaration(BigDecimal tdsMonthlyAfterDeclaration) {
		this.tdsMonthlyAfterDeclaration = tdsMonthlyAfterDeclaration;
	}
	public BigDecimal getSection84ARebateAmount() {
		return section84ARebateAmount;
	}
	public void setSection84ARebateAmount(BigDecimal section84aRebateAmount) {
		section84ARebateAmount = section84aRebateAmount;
	}
	@Override
	public String toString() {
		return "TdsSummaryDTO [yearlyGross=" + yearlyGross + ", otherIncome=" + otherIncome + ", netYearlyIncome="
				+ netYearlyIncome + ", exempStandard=" + exempStandard + ", exempPfAmount=" + exempPfAmount
				+ ", exempPtAmount=" + exempPtAmount + ", exempEsicAmount=" + exempEsicAmount
				+ ", exempAmountAsPerSlab=" + exempAmountAsPerSlab + ", exemptedTotalIncome=" + exemptedTotalIncome
				+ ", yearlyTaxableIncome=" + yearlyTaxableIncome + ", taxableIncomeFy=" + taxableIncomeFy
				+ ", tdsYearlyBeforeDeclaration=" + tdsYearlyBeforeDeclaration + ", tdsMonthlyBeforeDeclaration="
				+ tdsMonthlyBeforeDeclaration + ", incomeDeclared=" + incomeDeclared + ", declaredIncomeApproved="
				+ declaredIncomeApproved + ", netTaxableIncome=" + netTaxableIncome + ", tdsYearlyAfterDeclaration="
				+ tdsYearlyAfterDeclaration + ", tdsMonthlyAfterDeclaration=" + tdsMonthlyAfterDeclaration + "]";
	}
	
}
