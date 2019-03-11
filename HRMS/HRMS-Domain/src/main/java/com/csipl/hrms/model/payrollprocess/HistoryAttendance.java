package com.csipl.hrms.model.payrollprocess;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HistoryAttendance database table.
 * 
 */
@Entity
@NamedQuery(name="HistoryAttendance.findAll", query="SELECT h FROM HistoryAttendance h")
public class HistoryAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoryAttendancePK id;

	private BigDecimal absense;

	private BigDecimal casualleave;

	private int companyId;

	private String employeeCode;

	private String employeeName;

	private BigDecimal paidleave;

	private BigDecimal payDays;

	private BigDecimal presense;

	private BigDecimal publicholidays;

	private BigDecimal seekleave;

	private int srno;

	private BigDecimal weekoff;

	public HistoryAttendance() {
	}

	public HistoryAttendancePK getId() {
		return this.id;
	}

	public void setId(HistoryAttendancePK id) {
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

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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

	public BigDecimal getWeekoff() {
		return this.weekoff;
	}

	public void setWeekoff(BigDecimal weekoff) {
		this.weekoff = weekoff;
	}

}