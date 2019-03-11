package com.csipl.tms.model.leave;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@NamedQuery(name="TMSLeaveType.findAll", query="SELECT t FROM TMSLeaveType t")
public class TMSLeaveType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveTypeId;

	private String activeStatus;

	private Long carryForwardLimit;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long indexDays;

	private String isLeaveInProbation;

	private byte isWeekOffAsPL;

	private Long leaveFrequencyInMonth;

	private String leaveMode;
	
	private Long maxLeaveInMonth;

	private String nature;

	private Long notice;

	private Long userId;

	private Long userIdUpdate;

	private Long weekOffAsPLCount;

	private Long yearlyLimit;

	//bi-directional many-to-one association to TMSLeaveEntry
	@OneToMany(mappedBy="tmsleaveType", cascade = CascadeType.ALL)
	private List<TMSLeaveEntry> tmsleaveEntries;

	//bi-directional many-to-one association to TMSLeavePeriod
	@ManyToOne
	@JoinColumn(name="leavePeriodId")
	private TMSLeavePeriod tmsleavePeriod;

	//bi-directional many-to-one association to TMSLeaveTypeMaster
	@ManyToOne
	@JoinColumn(name="leaveTypeMasterId")
	private TMSLeaveTypeMaster tmsleaveTypeMaster;

	public TMSLeaveType() {
	}

	public Long getLeaveTypeId() {
		return this.leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCarryForwardLimit() {
		return this.carryForwardLimit;
	}

	public void setCarryForwardLimit(Long carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
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

	public Long getIndexDays() {
		return this.indexDays;
	}

	public void setIndexDays(Long indexDays) {
		this.indexDays = indexDays;
	}

	public String getIsLeaveInProbation() {
		return this.isLeaveInProbation;
	}

	public void setIsLeaveInProbation(String isLeaveInProbation) {
		this.isLeaveInProbation = isLeaveInProbation;
	}

	public byte getIsWeekOffAsPL() {
		return this.isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	public Long getLeaveFrequencyInMonth() {
		return this.leaveFrequencyInMonth;
	}

	public void setLeaveFrequencyInMonth(Long leaveFrequencyInMonth) {
		this.leaveFrequencyInMonth = leaveFrequencyInMonth;
	}

	public String getLeaveMode() {
		return this.leaveMode;
	}

	public void setLeaveMode(String leaveMode) {
		this.leaveMode = leaveMode;
	}

	public Long getMaxLeaveInMonth() {
		return this.maxLeaveInMonth;
	}

	public void setMaxLeaveInMonth(Long maxLeaveInMonth) {
		this.maxLeaveInMonth = maxLeaveInMonth;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Long getNotice() {
		return this.notice;
	}

	public void setNotice(Long notice) {
		this.notice = notice;
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

	public Long getYearlyLimit() {
		return this.yearlyLimit;
	}

	public void setYearlyLimit(Long yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public List<TMSLeaveEntry> getTmsleaveEntries() {
		return this.tmsleaveEntries;
	}

	public void setTmsleaveEntries(List<TMSLeaveEntry> tmsleaveEntries) {
		this.tmsleaveEntries = tmsleaveEntries;
	}

	public TMSLeaveEntry addTmsleaveEntry(TMSLeaveEntry tmsleaveEntry) {
		getTmsleaveEntries().add(tmsleaveEntry);
		tmsleaveEntry.setTmsleaveType(this);

		return tmsleaveEntry;
	}

	public TMSLeaveEntry removeTmsleaveEntry(TMSLeaveEntry tmsleaveEntry) {
		getTmsleaveEntries().remove(tmsleaveEntry);
		tmsleaveEntry.setTmsleaveType(null);

		return tmsleaveEntry;
	}

	public TMSLeavePeriod getTmsleavePeriod() {
		return this.tmsleavePeriod;
	}

	public void setTmsleavePeriod(TMSLeavePeriod tmsleavePeriod) {
		this.tmsleavePeriod = tmsleavePeriod;
	}

	public TMSLeaveTypeMaster getTmsleaveTypeMaster() {
		return this.tmsleaveTypeMaster;
	}

	public void setTmsleaveTypeMaster(TMSLeaveTypeMaster tmsleaveTypeMaster) {
		this.tmsleaveTypeMaster = tmsleaveTypeMaster;
	}

}