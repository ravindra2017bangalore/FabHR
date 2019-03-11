package com.csipl.tms.model.leave;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TMSLeaveCarryForward database table.
 * 
 */
@Entity
@NamedQuery(name="TMSLeaveCarryForward.findAll", query="SELECT t FROM TMSLeaveCarryForward t")
public class TMSLeaveCarryForward implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveCarryForwardId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long employeeId;

	private String leaveType;

	private Long tmsLeaveCarryForwardId;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TMSLeavePeriod
	@ManyToOne
	@JoinColumn(name="leavePeriodId")
	private TMSLeavePeriod tmsleavePeriod;

	public TMSLeaveCarryForward() {
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Long getTmsLeaveCarryForwardId() {
		return this.tmsLeaveCarryForwardId;
	}

	public void setTmsLeaveCarryForwardId(Long tmsLeaveCarryForwardId) {
		this.tmsLeaveCarryForwardId = tmsLeaveCarryForwardId;
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

	public TMSLeavePeriod getTmsleavePeriod() {
		return this.tmsleavePeriod;
	}

	public void setTmsleavePeriod(TMSLeavePeriod tmsleavePeriod) {
		this.tmsleavePeriod = tmsleavePeriod;
	}

}
