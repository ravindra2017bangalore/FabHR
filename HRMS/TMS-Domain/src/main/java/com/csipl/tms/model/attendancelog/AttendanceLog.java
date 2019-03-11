package com.csipl.tms.model.attendancelog;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the AttendanceLogs database table.
 * 
 */
@Entity
@Table(name = "AttendanceLogs")
@NamedQuery(name = "AttendanceLog.findAll", query = "SELECT a FROM AttendanceLog a")
public class AttendanceLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceLogId;

	@Temporal(TemporalType.DATE)
	private Date attendanceDate;

	private Long createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private Long inDeviceId;

	private String inTime;

	private Long outDeviceId;

	private String outTime;
	
	private String location;
	
	private String mode;

	private String delayedTime;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Long updatedBy;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	// bi-directional many-to-one association to Company
/*	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;*/
	private Long companyId;
	
	private Long employeeId;

	private String employeeCode;

	public AttendanceLog() {
	}

	public Long getAttendanceLogId() {
		return this.attendanceLogId;
	}

	public void setAttendanceLogId(Long attendanceLogId) {
		this.attendanceLogId = attendanceLogId;
	}

	public Date getAttendanceDate() {
		return this.attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getInDeviceId() {
		return this.inDeviceId;
	}

	public void setInDeviceId(Long inDeviceId) {
		this.inDeviceId = inDeviceId;
	}

	public String getInTime() {
		return this.inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public Long getOutDeviceId() {
		return this.outDeviceId;
	}

	public void setOutDeviceId(Long outDeviceId) {
		this.outDeviceId = outDeviceId;
	}

	public String getOutTime() {
		return this.outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public String getDelayedTime() {
		return delayedTime;
	}

	public void setDelayedTime(String delayedTime) {
		this.delayedTime = delayedTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}