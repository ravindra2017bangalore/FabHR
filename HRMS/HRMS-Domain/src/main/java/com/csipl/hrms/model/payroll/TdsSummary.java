package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TdsSummary database table.
 * 
 */
@Entity
@NamedQuery(name="TdsSummary.findAll", query="SELECT t FROM TdsSummary t")
public class TdsSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int tdsSummaryId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal declaredIncomeApproved;

	private BigDecimal exempAmountAsPerSlab;

	private BigDecimal exempEsicAmount;
	
	private String active;
	

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	private BigDecimal exempPfAmount;

	private BigDecimal exempPtAmount;

	private BigDecimal exempStandard;

	private BigDecimal exemptedTotalIncome;

	private String financialYear;

	private BigDecimal incomeDeclared;

	private BigDecimal netTaxableIncome;

	private BigDecimal netYearlyIncome;

	private BigDecimal otherIncome;

	private BigDecimal taxableIncomeFy;

	private BigDecimal tdsMonthlyAfterDeclaration;

	private BigDecimal tdsMonthlyBeforeDeclaration;

	private BigDecimal tdsYearlyAfterDeclaration;

	private BigDecimal tdsYearlyBeforeDeclaration;

	private int userId;

	private int userIdUpdate;

	private BigDecimal yearlyGross;

	private BigDecimal yearlyTaxableIncome;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public TdsSummary() {
	}

	public int getTdsSummaryId() {
		return this.tdsSummaryId;
	}

	public void setTdsSummaryId(int tdsSummaryId) {
		this.tdsSummaryId = tdsSummaryId;
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

	public BigDecimal getDeclaredIncomeApproved() {
		return this.declaredIncomeApproved;
	}

	public void setDeclaredIncomeApproved(BigDecimal declaredIncomeApproved) {
		this.declaredIncomeApproved = declaredIncomeApproved;
	}

	public BigDecimal getExempAmountAsPerSlab() {
		return this.exempAmountAsPerSlab;
	}

	public void setExempAmountAsPerSlab(BigDecimal exempAmountAsPerSlab) {
		this.exempAmountAsPerSlab = exempAmountAsPerSlab;
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

	public BigDecimal getIncomeDeclared() {
		return this.incomeDeclared;
	}

	public void setIncomeDeclared(BigDecimal incomeDeclared) {
		this.incomeDeclared = incomeDeclared;
	}

	public BigDecimal getNetTaxableIncome() {
		return this.netTaxableIncome;
	}

	public void setNetTaxableIncome(BigDecimal netTaxableIncome) {
		this.netTaxableIncome = netTaxableIncome;
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

	public BigDecimal getTaxableIncomeFy() {
		return this.taxableIncomeFy;
	}

	public void setTaxableIncomeFy(BigDecimal taxableIncomeFy) {
		this.taxableIncomeFy = taxableIncomeFy;
	}

	public BigDecimal getTdsMonthlyAfterDeclaration() {
		return this.tdsMonthlyAfterDeclaration;
	}

	public void setTdsMonthlyAfterDeclaration(BigDecimal tdsMonthlyAfterDeclaration) {
		this.tdsMonthlyAfterDeclaration = tdsMonthlyAfterDeclaration;
	}

	public BigDecimal getTdsMonthlyBeforeDeclaration() {
		return this.tdsMonthlyBeforeDeclaration;
	}

	public void setTdsMonthlyBeforeDeclaration(BigDecimal tdsMonthlyBeforeDeclaration) {
		this.tdsMonthlyBeforeDeclaration = tdsMonthlyBeforeDeclaration;
	}

	public BigDecimal getTdsYearlyAfterDeclaration() {
		return this.tdsYearlyAfterDeclaration;
	}

	public void setTdsYearlyAfterDeclaration(BigDecimal tdsYearlyAfterDeclaration) {
		this.tdsYearlyAfterDeclaration = tdsYearlyAfterDeclaration;
	}

	public BigDecimal getTdsYearlyBeforeDeclaration() {
		return this.tdsYearlyBeforeDeclaration;
	}

	public void setTdsYearlyBeforeDeclaration(BigDecimal tdsYearlyBeforeDeclaration) {
		this.tdsYearlyBeforeDeclaration = tdsYearlyBeforeDeclaration;
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

	public BigDecimal getYearlyTaxableIncome() {
		return this.yearlyTaxableIncome;
	}

	public void setYearlyTaxableIncome(BigDecimal yearlyTaxableIncome) {
		this.yearlyTaxableIncome = yearlyTaxableIncome;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}