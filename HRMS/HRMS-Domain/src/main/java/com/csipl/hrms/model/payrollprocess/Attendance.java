package com.csipl.hrms.model.payrollprocess;


import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.organisation.Department;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Attendance database table.
 * 
 */
@Entity
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AttendancePK id;

	private BigDecimal absense;

	private BigDecimal casualleave;

	//private Long companyId;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	private String employeeName;

	private BigDecimal paidleave;

	private BigDecimal payDays;

	private BigDecimal presense;

	private BigDecimal publicholidays;

	private BigDecimal seekleave;

	private int srno;

	private Long userId;

	private BigDecimal weekoff;

	public Attendance() {
	}

	public AttendancePK getId() {
		return this.id;
	}

	public void setId(AttendancePK id) {
		this.id = id;
	}

	public BigDecimal getAbsense() {
		return this.absense;
	}

	public void setAbsense(BigDecimal absense) {
		this.absense = absense;
	}

	public BigDecimal getCasualleave() {
		return this.casualleave;
	}

	public void setCasualleave(BigDecimal casualleave) {
		this.casualleave = casualleave;
	}

/*	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}*/

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public BigDecimal getPaidleave() {
		return this.paidleave;
	}

	public void setPaidleave(BigDecimal paidleave) {
		this.paidleave = paidleave;
	}

	public BigDecimal getPayDays() {
		return this.payDays;
	}

	public void setPayDays(BigDecimal payDays) {
		this.payDays = payDays;
	}

	public BigDecimal getPresense() {
		return this.presense;
	}

	public void setPresense(BigDecimal presense) {
		this.presense = presense;
	}

	public BigDecimal getPublicholidays() {
		return this.publicholidays;
	}

	public void setPublicholidays(BigDecimal publicholidays) {
		this.publicholidays = publicholidays;
	}

	public BigDecimal getSeekleave() {
		return this.seekleave;
	}

	public void setSeekleave(BigDecimal seekleave) {
		this.seekleave = seekleave;
	}

	public int getSrno() {
		return this.srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getWeekoff() {
		return this.weekoff;
	}

	public void setWeekoff(BigDecimal weekoff) {
		this.weekoff = weekoff;
	}
	
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}