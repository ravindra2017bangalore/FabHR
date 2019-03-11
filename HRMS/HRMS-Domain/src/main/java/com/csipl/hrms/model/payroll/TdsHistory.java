package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.util.Date;


/**
 * The persistent class for the TdsHistory database table.
 * 
 */
@Entity
@NamedQuery(name="TdsHistory.findAll", query="SELECT t FROM TdsHistory t")
public class TdsHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsHistoryId;

	private Long approveId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	private String financialYear;

	private String status;

	public TdsHistory() {
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getTdsHistoryId() {
		return tdsHistoryId;
	}

	public void setTdsHistoryId(Long tdsHistoryId) {
		this.tdsHistoryId = tdsHistoryId;
	}

	public Long getApproveId() {
		return approveId;
	}

	public void setApproveId(Long approveId) {
		this.approveId = approveId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}