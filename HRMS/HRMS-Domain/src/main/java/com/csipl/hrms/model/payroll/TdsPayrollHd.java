package com.csipl.hrms.model.payroll;


import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;






/**
 * The persistent class for the TdsPayrollHd database table.
 * 
 */
@Entity
@NamedQuery(name="TdsPayrollHd.findAll", query="SELECT t FROM TdsPayrollHd t")
public class TdsPayrollHd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionHdId;

	private Long companyId;	

	private String financialYear;

	private BigDecimal grossIncome;
	
	private BigDecimal grossIncomeFy;

	private BigDecimal taxableAmount;

	private BigDecimal tdsApproved;
	
	private String active;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	//bi-directional many-to-one association to TdsPayroll
	
	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@OneToMany(mappedBy="tdsPayrollHd",cascade = CascadeType.ALL)
	private List<TdsPayroll> tdsPayrolls;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public TdsPayrollHd() {
	}

	public Long getTransactionHdId() {
		return this.transactionHdId;
	}

	public void setTransactionHdId(Long transactionHdId) {
		this.transactionHdId = transactionHdId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getGrossIncome() {
		return this.grossIncome;
	}

	public void setGrossIncome(BigDecimal grossIncome) {
		this.grossIncome = grossIncome;
	}

	
	public BigDecimal getGrossIncomeFy() {
		return grossIncomeFy;
	}

	public void setGrossIncomeFy(BigDecimal grossIncomeFy) {
		this.grossIncomeFy = grossIncomeFy;
	}

	public BigDecimal getTaxableAmount() {
		return this.taxableAmount;
	}

	public void setTaxableAmount(BigDecimal taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public BigDecimal getTdsApproved() {
		return this.tdsApproved;
	}

	public void setTdsApproved(BigDecimal tdsApproved) {
		this.tdsApproved = tdsApproved;
	}

	public List<TdsPayroll> getTdsPayrolls() {
		return this.tdsPayrolls;
	}

	public void setTdsPayrolls(List<TdsPayroll> tdsPayrolls) {
		this.tdsPayrolls = tdsPayrolls;
	}

	public TdsPayroll addTdsPayroll(TdsPayroll tdsPayroll) {
		getTdsPayrolls().add(tdsPayroll);
		tdsPayroll.setTdsPayrollHd(this);

		return tdsPayroll;
	}

	public TdsPayroll removeTdsPayroll(TdsPayroll tdsPayroll) {
		getTdsPayrolls().remove(tdsPayroll);
		tdsPayroll.setTdsPayrollHd(null);

		return tdsPayroll;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}