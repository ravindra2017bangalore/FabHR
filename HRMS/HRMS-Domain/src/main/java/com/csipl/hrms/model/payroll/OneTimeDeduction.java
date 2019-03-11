package com.csipl.hrms.model.payroll;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OneTimeDeduction database table.
 * 
 */
@Entity
@NamedQuery(name="OneTimeDeduction.findAll", query="SELECT o FROM OneTimeDeduction o")
public class OneTimeDeduction  implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deductionId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	private BigDecimal deductionAmount;

	private String deductionMonth;

	@Temporal(TemporalType.DATE)
	private Date updateDate;

	private Long updateId;

	private Long userId;
	
	private String remarks;
	
	private String isDeduction;


	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public OneTimeDeduction() {
	}

	public Long getDeductionId() {
		return this.deductionId;
	}

	public void setDeductionId(Long deductionId) {
		this.deductionId = deductionId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getDeductionAmount() {
		return this.deductionAmount;
	}

	public void setDeductionAmount(BigDecimal deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDeductionMonth() {
		return this.deductionMonth;
	}

	public void setDeductionMonth(String deductionMonth) {
		this.deductionMonth = deductionMonth;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getIsDeduction() {
		return isDeduction;
	}

	public void setIsDeduction(String isDeduction) {
		this.isDeduction = isDeduction;
	}

}