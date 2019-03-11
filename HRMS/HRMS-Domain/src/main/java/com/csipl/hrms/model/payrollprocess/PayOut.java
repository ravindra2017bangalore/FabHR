package com.csipl.hrms.model.payrollprocess;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;

/**
 * The persistent class for the PayOut database table.
 * 
 */
@Entity
@NamedQuery(name = "PayOut.findAll", query = "SELECT p FROM PayOut p")
public class PayOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PayOutPK id;

	private BigDecimal amount;

	//private Long payHeadId;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "employeeId", insertable = false, updatable = false)
	private Employee employee;
	
	@Transient
	private String payHeadName;
	
	@Transient
	private String earningDeduction;

	public String getEarningDeduction() {
		return earningDeduction;
	}

	public void setEarningDeduction(String earningDeduction) {
		this.earningDeduction = earningDeduction;
	}

	public PayOut() {
	}

	public PayOutPK getId() {
		return this.id;
	}

	public void setId(PayOutPK id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/*public Long getPayHeadId() {
		return this.payHeadId;
	}

	public void setPayHeadId(Long payHeadId) {
		this.payHeadId = payHeadId;
	}
*/
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPayHeadName() {
		return payHeadName;
	}

	public void setPayHeadName(String payHeadName) {
		this.payHeadName = payHeadName;
	}

}