package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.organisation.Department;

import java.util.Date;


/**
 * The persistent class for the Provision database table.
 * 
 */
@Entity
@NamedQuery(name="Provision.findAll", query="SELECT p FROM Provision p")
public class Provision extends BaseModelWithoutGroup  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long provisionId;

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String narration;

	private String processMonth;

	

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	public Provision() {
	}

	public Long getProvisionId() {
		return this.provisionId;
	}

	public void setProvisionId(Long provisionId) {
		this.provisionId = provisionId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getNarration() {
		return this.narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getProcessMonth() {
		return this.processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}


	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}