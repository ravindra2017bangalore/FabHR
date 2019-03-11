package com.csipl.tms.model.rules;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.tms.model.leave.TMSLeaveType;

//import com.csipl.hrms.common.model.Company;

import java.util.Date;

/**
 * The persistent class for the LeaveRule database table.
 * 
 */
@Entity
@Table(name = "TMSLeaveRule")
@NamedQuery(name = "LeaveRule.findAll", query = "SELECT l FROM LeaveRule l")
public class LeaveRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveRuleId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private byte isWeekOffAsPL;

	private double leaveIndex;

	private Long leaveIndexDay;

	private Long userId;

	private Long userIdUpdate;

	private Long weekOffAsPLCount;

	// bi-directional many-to-one association to Company
	/* @ManyToOne
	@JoinColumn(name = "companyId")
	private Company company; */
	
	private Long companyId;

	// bi-directional many-to-one association to LeaveType
	@ManyToOne
	@JoinColumn(name = "leaveId")
	private TMSLeaveType tmsleaveType;

	public LeaveRule() {
	}

	public Long getLeaveRuleId() {
		return this.leaveRuleId;
	}

	public void setLeaveRuleId(Long leaveRuleId) {
		this.leaveRuleId = leaveRuleId;
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

	public byte getIsWeekOffAsPL() {
		return this.isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	public double getLeaveIndex() {
		return this.leaveIndex;
	}

	public void setLeaveIndex(double leaveIndex) {
		this.leaveIndex = leaveIndex;
	}

	public Long getLeaveIndexDay() {
		return this.leaveIndexDay;
	}

	public void setLeaveIndexDay(Long leaveIndexDay) {
		this.leaveIndexDay = leaveIndexDay;
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

	public Long getWeekOffAsPLCount() {
		return this.weekOffAsPLCount;
	}

	public void setWeekOffAsPLCount(Long weekOffAsPLCount) {
		this.weekOffAsPLCount = weekOffAsPLCount;
	}

	/*public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

	public Long getCompanyId() {
		return companyId;
	}

	public TMSLeaveType getTmsleaveType() {
		return tmsleaveType;
	}

	public void setTmsleaveType(TMSLeaveType tmsleaveType) {
		this.tmsleaveType = tmsleaveType;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}