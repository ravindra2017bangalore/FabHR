package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the TdsSummaryChange database table.
 * 
 */
@Entity
@NamedQuery(name = "TdsSummaryChange.findAll", query = "SELECT t FROM TdsSummaryChange t")
public class TdsSummaryChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tdsSummaryChangeId;

	private String active;

	private BigDecimal chapter6a;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal educationCess;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	private BigDecimal exempEsicAmount;

	private BigDecimal exempPfAmount;

	private BigDecimal exempPtAmount;

	private BigDecimal exempStandard;

	private BigDecimal exemptedTotalIncome;

	private String financialYear;

	private BigDecimal incomeAfterExemptions;

	private BigDecimal netTaxMonthly;

	private BigDecimal netTaxYearly;

	private BigDecimal netYearlyIncome;

	private BigDecimal otherIncome;

	private BigDecimal potalTax;

	private BigDecimal preEmpIncome;

	private BigDecimal previousEducationCess;

	private BigDecimal previousSurcharge;

	private BigDecimal professionalTax;

	private BigDecimal providentFund;

	private BigDecimal section10;

	private BigDecimal section24;

	private BigDecimal surcharge;
	
	private BigDecimal surchargePer;

	private BigDecimal educationCessPer;

	private BigDecimal section84ARebateTax;
	
	private BigDecimal total80cAmount;

	private BigDecimal tax;

	private BigDecimal taxableIncome;

	private BigDecimal taxOnIncome;

	private BigDecimal totalDeductionIncome;

	private BigDecimal totalIncomeProfessionalTax;

	private BigDecimal totalTax;

	private int userId;

	private int userIdUpdate;

	private BigDecimal yearlyGross;

	private BigDecimal yearlyGrossFy;
	
	private BigDecimal section84ARebateAmount;

	public BigDecimal getSection84ARebateAmount() {
		return section84ARebateAmount;
	}

	public void setSection84ARebateAmount(BigDecimal section84aRebateAmount) {
		section84ARebateAmount = section84aRebateAmount;
	}

	public TdsSummaryChange() {
	}

	public int getTdsSummaryChangeId() {
		return this.tdsSummaryChangeId;
	}

	public void setTdsSummaryChangeId(int tdsSummaryChangeId) {
		this.tdsSummaryChangeId = tdsSummaryChangeId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public BigDecimal getChapter6a() {
		return this.chapter6a;
	}

	public void setChapter6a(BigDecimal chapter6a) {
		this.chapter6a = chapter6a;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public BigDecimal getEducationCess() {
		return this.educationCess;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEducationCess(BigDecimal educationCess) {
		this.educationCess = educationCess;
	}

	public BigDecimal getExempEsicAmount() {
		return this.exempEsicAmount;
	}

	public void setExempEsicAmount(BigDecimal exempEsicAmount) {
		this.exempEsicAmount = exempEsicAmount;
	}

	public BigDecimal getExempPfAmount() {
		return this.exempPfAmount;
	}

	public void setExempPfAmount(BigDecimal exempPfAmount) {
		this.exempPfAmount = exempPfAmount;
	}

	public BigDecimal getExempPtAmount() {
		return this.exempPtAmount;
	}

	public void setExempPtAmount(BigDecimal exempPtAmount) {
		this.exempPtAmount = exempPtAmount;
	}

	public BigDecimal getExempStandard() {
		return this.exempStandard;
	}

	public void setExempStandard(BigDecimal exempStandard) {
		this.exempStandard = exempStandard;
	}

	public BigDecimal getExemptedTotalIncome() {
		return this.exemptedTotalIncome;
	}

	public void setExemptedTotalIncome(BigDecimal exemptedTotalIncome) {
		this.exemptedTotalIncome = exemptedTotalIncome;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getIncomeAfterExemptions() {
		return this.incomeAfterExemptions;
	}

	public void setIncomeAfterExemptions(BigDecimal incomeAfterExemptions) {
		this.incomeAfterExemptions = incomeAfterExemptions;
	}

	public BigDecimal getNetTaxMonthly() {
		return this.netTaxMonthly;
	}

	public void setNetTaxMonthly(BigDecimal netTaxMonthly) {
		this.netTaxMonthly = netTaxMonthly;
	}

	public BigDecimal getSurchargePer() {
		return surchargePer;
	}

	public void setSurchargePer(BigDecimal surchargePer) {
		this.surchargePer = surchargePer;
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
	
	public BigDecimal getTotal80cAmount() {
		return total80cAmount;
	}

	public void setTotal80cAmount(BigDecimal total80cAmount) {
		this.total80cAmount = total80cAmount;
	}

	public BigDecimal getNetTaxYearly() {
		return this.netTaxYearly;
	}

	public void setNetTaxYearly(BigDecimal netTaxYearly) {
		this.netTaxYearly = netTaxYearly;
	}

	public BigDecimal getNetYearlyIncome() {
		return this.netYearlyIncome;
	}

	public void setNetYearlyIncome(BigDecimal netYearlyIncome) {
		this.netYearlyIncome = netYearlyIncome;
	}

	public BigDecimal getOtherIncome() {
		return this.otherIncome;
	}

	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}

	public BigDecimal getPotalTax() {
		return this.potalTax;
	}

	public void setPotalTax(BigDecimal potalTax) {
		this.potalTax = potalTax;
	}

	public BigDecimal getPreEmpIncome() {
		return this.preEmpIncome;
	}

	public void setPreEmpIncome(BigDecimal preEmpIncome) {
		this.preEmpIncome = preEmpIncome;
	}

	public BigDecimal getPreviousEducationCess() {
		return previousEducationCess;
	}

	public void setPreviousEducationCess(BigDecimal previousEducationCess) {
		this.previousEducationCess = previousEducationCess;
	}

	public BigDecimal getPreviousSurcharge() {
		return previousSurcharge;
	}

	public void setPreviousSurcharge(BigDecimal previousSurcharge) {
		this.previousSurcharge = previousSurcharge;
	}

	public BigDecimal getProfessionalTax() {
		return this.professionalTax;
	}

	public void setProfessionalTax(BigDecimal professionalTax) {
		this.professionalTax = professionalTax;
	}

	public BigDecimal getProvidentFund() {
		return this.providentFund;
	}

	public void setProvidentFund(BigDecimal providentFund) {
		this.providentFund = providentFund;
	}

	public BigDecimal getSection10() {
		return this.section10;
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

	public BigDecimal getSurcharge() {
		return this.surcharge;
	}

	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTaxableIncome() {
		return this.taxableIncome;
	}

	public void setTaxableIncome(BigDecimal taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public BigDecimal getTaxOnIncome() {
		return this.taxOnIncome;
	}

	public void setTaxOnIncome(BigDecimal taxOnIncome) {
		this.taxOnIncome = taxOnIncome;
	}

	public BigDecimal getTotalDeductionIncome() {
		return this.totalDeductionIncome;
	}

	public void setTotalDeductionIncome(BigDecimal totalDeductionIncome) {
		this.totalDeductionIncome = totalDeductionIncome;
	}

	public BigDecimal getTotalIncomeProfessionalTax() {
		return this.totalIncomeProfessionalTax;
	}

	public void setTotalIncomeProfessionalTax(BigDecimal totalIncomeProfessionalTax) {
		this.totalIncomeProfessionalTax = totalIncomeProfessionalTax;
	}

	public BigDecimal getTotalTax() {
		return this.totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(int userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public BigDecimal getYearlyGross() {
		return this.yearlyGross;
	}

	public void setYearlyGross(BigDecimal yearlyGross) {
		this.yearlyGross = yearlyGross;
	}

	public BigDecimal getYearlyGrossFy() {
		return this.yearlyGrossFy;
	}

	public void setYearlyGrossFy(BigDecimal yearlyGrossFy) {
		this.yearlyGrossFy = yearlyGrossFy;
	}

}
