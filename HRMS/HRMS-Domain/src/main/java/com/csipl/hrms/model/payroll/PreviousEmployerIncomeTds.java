package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PreviousEmployerIncomeTds database table.
 * 
 */
@Entity
@Table(name="PreviousEmployerIncomeTds")
@NamedQuery(name="PreviousEmployerIncomeTds.findAll", query="SELECT p FROM PreviousEmployerIncomeTds p")
public class PreviousEmployerIncomeTds extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long previousEmployerIncomeTdsId;

	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	private String financialYear;

	//bi-directional many-to-one association to PreviousEmployerIncome
	@ManyToOne
	@JoinColumn(name="previousEmployerIncomeId")
	private PreviousEmployerIncome previousEmployerIncome;

	public PreviousEmployerIncomeTds() {
	}

	public Long getPreviousEmployerIncomeTdsId() {
		return previousEmployerIncomeTdsId;
	}

	public void setPreviousEmployerIncomeTdsId(Long previousEmployerIncomeTdsId) {
		this.previousEmployerIncomeTdsId = previousEmployerIncomeTdsId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public PreviousEmployerIncome getPreviousEmployerIncome() {
		return this.previousEmployerIncome;
	}

	public void setPreviousEmployerIncome(PreviousEmployerIncome previousEmployerIncome) {
		this.previousEmployerIncome = previousEmployerIncome;
	}

}
