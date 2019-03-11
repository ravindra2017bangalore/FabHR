package com.csipl.hrms.model.payroll;


import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.employee.Employee;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TransactionApprovedHd database table.
 * 
 */
@Entity
@NamedQuery(name="TransactionApprovedHd.findAll", query="SELECT t FROM TransactionApprovedHd t")
public class TransactionApprovedHd extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionApprovedHdId;
    private String financialYear;
    private String status;
   

	private String active;

    

	//bi-directional many-to-one association to TdsApproved
	@OneToMany(mappedBy="transactionApprovedHd", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<TdsApproved> tdsApproveds;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="approveId")
	private Employee employee2;

	public TransactionApprovedHd() {
	}

	public Long getTransactionApprovedHdId() {
		return this.transactionApprovedHdId;
	}

	public void setTransactionApprovedHdId(Long transactionApprovedHdId) {
		this.transactionApprovedHdId = transactionApprovedHdId;
	}

	

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}
	public List<TdsApproved> getTdsApproveds() {
		return this.tdsApproveds;
	}

	public void setTdsApproveds(List<TdsApproved> tdsApproveds) {
		this.tdsApproveds = tdsApproveds;
	}

	public TdsApproved addTdsApproved(TdsApproved tdsApproved) {
		getTdsApproveds().add(tdsApproved);
		tdsApproved.setTransactionApprovedHd(this);

		return tdsApproved;
	}

	public TdsApproved removeTdsApproved(TdsApproved tdsApproved) {
		getTdsApproveds().remove(tdsApproved);
		tdsApproved.setTransactionApprovedHd(null);

		return tdsApproved;
	}

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

}
