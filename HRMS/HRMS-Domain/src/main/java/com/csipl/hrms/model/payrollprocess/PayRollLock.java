package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.organisation.Department;

import java.util.Date;


/**
 * The persistent class for the PayRollLock database table.
 * 
 */
@Entity
@NamedQuery(name="PayRollLock.findAll", query="SELECT p FROM PayRollLock p")
public class PayRollLock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PayRollLockPK id;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	private String isPayRollLocked;

	private String screenName;

	private Long userId;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId",  insertable=false, updatable=false )
	private Department department;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public PayRollLock() {
	}

	public PayRollLockPK getId() {
		return this.id;
	}

	public void setId(PayRollLockPK id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getIsPayRollLocked() {
		return this.isPayRollLocked;
	}

	public void setIsPayRollLocked(String isPayRollLocked) {
		this.isPayRollLocked = isPayRollLocked;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}