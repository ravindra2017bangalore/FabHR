package com.csipl.tms.model.leave;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;

/**
 * The persistent class for the EmployeeLeaveEarn database table.
 * 
 */
@Entity
@Table(name = "TMSLeaveEarn")
@NamedQuery(name = "EmployeeLeaveEarn.findAll", query = "SELECT e FROM EmployeeLeaveEarn e")
public class EmployeeLeaveEarn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeLeaveEarnId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private float earnLeave;

	private Long leaveBalance;

	private Long leaveTaken;

	private float loadFactor;

	private Long totalLeave;

	private Long userId;

	private Long userIdUpdate;
	
	private Long employeeId;


	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	
	// bi-directional many-to-one association to LeaveType
	@ManyToOne
	@JoinColumn(name = "leaveTypeId")
	private TMSLeaveType tmsleaveType;

	public EmployeeLeaveEarn() {
	}

	public Long getEmployeeLeaveEarnId() {
		return this.employeeLeaveEarnId;
	}

	public void setEmployeeLeaveEarnId(Long employeeLeaveEarnId) {
		this.employeeLeaveEarnId = employeeLeaveEarnId;
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

	public Long getLeaveTaken() {
		return this.leaveTaken;
	}

	public void setLeaveTaken(Long leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public Long getTotalLeave() {
		return this.totalLeave;
	}

	public void setTotalLeave(Long totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}


	

	public TMSLeaveType getTmsleaveType() {
		return tmsleaveType;
	}

	public void setTmsleaveType(TMSLeaveType tmsleaveType) {
		this.tmsleaveType = tmsleaveType;
	}

	public float getEarnLeave() {
		return earnLeave;
	}

	public void setEarnLeave(float earnLeave) {
		this.earnLeave = earnLeave;
	}

	public Long getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Long leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public float getLoadFactor() {
		return loadFactor;
	}

	public void setLoadFactor(float loadFactor) {
		this.loadFactor = loadFactor;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}