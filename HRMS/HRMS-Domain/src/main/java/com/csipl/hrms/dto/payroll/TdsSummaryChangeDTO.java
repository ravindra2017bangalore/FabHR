package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;

public class TdsSummaryChangeDTO {
	
	private String financialYear;
	private Long employeeId;
	
	private BigDecimal yearlyGross;
	private BigDecimal yearlyGrossFy;
	private BigDecimal otherIncome;
	private BigDecimal preEmpIncome;
	private BigDecimal netYearlyIncome;
	
	private BigDecimal exempStandard;
	private BigDecimal exempPfAmount;
	private BigDecimal exempPtAmount;
    private BigDecimal exemptedTotalIncome;
    private BigDecimal totalIncomeProfessionalTax;
    
    private BigDecimal chapter6a;
    private BigDecimal section10;
    private BigDecimal section24;
    private BigDecimal totalDeductionIncome;
    
	private BigDecimal TaxableIncome;
	private BigDecimal  section84ARebateAmount;

	private BigDecimal tax;
	private BigDecimal surcharge;
	private BigDecimal surchargePer;
	private BigDecimal educationCess;
	
	private BigDecimal section84ARebateTax;
	private BigDecimal total80cAmount;
	
	private BigDecimal month;

	private boolean tdsFullYearFlag; 

	public BigDecimal getMonth() {
		return month;
	}
	public void setMonth(BigDecimal month) {
		this.month = month;
	}
	public boolean isTdsFullYearFlag() {
		return tdsFullYearFlag;
	}
	public void setTdsFullYearFlag(boolean tdsFullYearFlag) {
		this.tdsFullYearFlag = tdsFullYearFlag;
	}
	public BigDecimal getTotal80cAmount() {
		return total80cAmount;
	}
	public void setTotal80cAmount(BigDecimal total80cAmount) {
		this.total80cAmount = total80cAmount;
	}
	public BigDecimal getSurchargePer() {
		return surchargePer;
	}
	public void setSurchargePer(BigDecimal surchargePer) {
		this.surchargePer = surchargePer;
	}
	private BigDecimal educationCessPer;
	private BigDecimal totalTax;
	
	private BigDecimal netTaxYearly;
	private BigDecimal netTaxMonthly;
	
	

	private BigDecimal  incomeAfterExemptions;
	private BigDecimal  professionalTax;
	private BigDecimal  providentFund;
	private BigDecimal  potalTax;
	private BigDecimal  previous;
	private BigDecimal  taxOnIncome;
	private BigDecimal  previousSurcharge;
	private BigDecimal  previousEducationCess;
	
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public BigDecimal getYearlyGross() {
		return yearlyGross;
	}
	public void setYearlyGross(BigDecimal yearlyGross) {
		this.yearlyGross = yearlyGross;
	}
	public BigDecimal getYearlyGrossFy() {
		return yearlyGrossFy;
	}
	public void setYearlyGrossFy(BigDecimal yearlyGrossFy) {
		this.yearlyGrossFy = yearlyGrossFy;
	}
	public BigDecimal getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}
	public BigDecimal getPreEmpIncome() {
		return preEmpIncome;
	}
	public void setPreEmpIncome(BigDecimal preEmpIncome) {
		this.preEmpIncome = preEmpIncome;
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
	public BigDecimal getExemptedTotalIncome() {
		return exemptedTotalIncome;
	}
	public void setExemptedTotalIncome(BigDecimal exemptedTotalIncome) {
		this.exemptedTotalIncome = exemptedTotalIncome;
	}
	public BigDecimal getChapter6a() {
		return chapter6a;
	}
	public void setChapter6a(BigDecimal chapter6a) {
		this.chapter6a = chapter6a;
	}
	public BigDecimal getSection10() {
		return section10;
	}
	public void setSection10(BigDecimal section10) {
		this.section10 = section10;
	}
	public BigDecimal getSection24() {
		return section24;
	}
	public void setSection24(BigDecimal section24) {
		this.section24 = section24;
	}
	public BigDecimal getTotalDeductionIncome() {
		return totalDeductionIncome;
	}
	public void setTotalDeductionIncome(BigDecimal totalDeductionIncome) {
		this.totalDeductionIncome = totalDeductionIncome;
	}
	public BigDecimal getTaxableIncome() {
		return TaxableIncome;
	}
	public void setTaxableIncome(BigDecimal taxableIncome) {
		TaxableIncome = taxableIncome;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public BigDecimal getSurcharge() {
		return surcharge;
	}
	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}
	public BigDecimal getEducationCess() {
		return educationCess;
	}
	public void setEducationCess(BigDecimal educationCess) {
		this.educationCess = educationCess;
	}
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	public BigDecimal getNetTaxYearly() {
		return netTaxYearly;
	}
	public void setNetTaxYearly(BigDecimal netTaxYearly) {
		this.netTaxYearly = netTaxYearly;
	}
	public BigDecimal getNetTaxMonthly() {
		return netTaxMonthly;
	}
	public void setNetTaxMonthly(BigDecimal netTaxMonthly) {
		this.netTaxMonthly = netTaxMonthly;
	}
	public BigDecimal getIncomeAfterExemptions() {
		return incomeAfterExemptions;
	}
	public void setIncomeAfterExemptions(BigDecimal incomeAfterExemptions) {
		this.incomeAfterExemptions = incomeAfterExemptions;
	}
	public BigDecimal getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(BigDecimal professionalTax) {
		this.professionalTax = professionalTax;
	}
	public BigDecimal getProvidentFund() {
		return providentFund;
	}
	public void setProvidentFund(BigDecimal providentFund) {
		this.providentFund = providentFund;
	}
	public BigDecimal getPotalTax() {
		return potalTax;
	}
	public void setPotalTax(BigDecimal potalTax) {
		this.potalTax = potalTax;
	}
	public BigDecimal getTaxOnIncome() {
		return taxOnIncome;
	}
	public void setTaxOnIncome(BigDecimal taxOnIncome) {
		this.taxOnIncome = taxOnIncome;
	}
	
	public BigDecimal getPreviousSurcharge() {
		return previousSurcharge;
	}
	public void setPreviousSurcharge(BigDecimal previousSurcharge) {
		this.previousSurcharge = previousSurcharge;
	}
	public BigDecimal getPreviousEducationCess() {
		return previousEducationCess;
	}
	public void setPreviousEducationCess(BigDecimal previousEducationCess) {
		this.previousEducationCess = previousEducationCess;
	}
	public BigDecimal getTotalIncomeProfessionalTax() {
		return totalIncomeProfessionalTax;
	}
	public void setTotalIncomeProfessionalTax(BigDecimal totalIncomeProfessionalTax) {
		this.totalIncomeProfessionalTax = totalIncomeProfessionalTax;
	}
	public BigDecimal getEducationCessPer() {
		return educationCessPer;
	}
	public void setEducationCessPer(BigDecimal educationCessPer) {
		this.educationCessPer = educationCessPer;
	}
	public BigDecimal getSection84ARebateTax() {
		return section84ARebateTax;
	}
	public void setSection84ARebateTax(BigDecimal section84aRebateTax) {
		section84ARebateTax = section84aRebateTax;
	}
	public BigDecimal getSection84ARebateAmount() {
		return section84ARebateAmount;
	}
	public void setSection84ARebateAmount(BigDecimal section84aRebateAmount) {
		section84ARebateAmount = section84aRebateAmount;
	}
	@Override
	public String toString() {
		return "TdsSummaryChangeDTO [financialYear=" + financialYear + ", employeeId=" + employeeId + ", yearlyGross="
				+ yearlyGross + ", yearlyGrossFy=" + yearlyGrossFy + ", otherIncome=" + otherIncome + ", preEmpIncome="
				+ preEmpIncome + ", netYearlyIncome=" + netYearlyIncome + ", exempStandard=" + exempStandard
				+ ", exempPfAmount=" + exempPfAmount + ", exempPtAmount=" + exempPtAmount + ", exemptedTotalIncome=" + exemptedTotalIncome + ", totalIncomeProfessionalTax="
				+ totalIncomeProfessionalTax + ", chapter6a=" + chapter6a + ", section10=" + section10 + ", section25="
				+ section24 + ", totalDeductionIncome=" + totalDeductionIncome + ", TaxableIncome=" + TaxableIncome
				+ ", tax=" + tax + ", surcharge=" + surcharge + ", educationCess=" + educationCess + ", totalTax="
				+ totalTax + ", netTaxYearly=" + netTaxYearly + ", netTaxMonthly=" + netTaxMonthly
				+ ", incomeAfterExemptions=" + incomeAfterExemptions + ", professionalTax=" + professionalTax
				+ ", providentFund=" + providentFund + ", potalTax=" + potalTax + ", taxOnIncome=" + taxOnIncome
				+ ", previoussurcharge=" + previousSurcharge + ", previouseducationCess=" + previousEducationCess + "]";
	}
}
