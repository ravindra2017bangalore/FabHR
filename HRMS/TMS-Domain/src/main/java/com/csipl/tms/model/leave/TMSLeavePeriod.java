package com.csipl.tms.model.leave;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TMSLeavePeriod database table.
 * 
 */
@Entity
@NamedQuery(name="TMSLeavePeriod.findAll", query="SELECT t FROM TMSLeavePeriod t")
public class TMSLeavePeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leavePeriodId;

	private String activeStatus;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String leavePeriodName;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private Long userId;

	private Long userIdUpdate;

	private Long companyId;
	//bi-directional many-to-one association to TMSLeaveCarryForward
	@OneToMany(mappedBy="tmsleavePeriod")
	private List<TMSLeaveCarryForward> tmsleaveCarryForwards;

	//bi-directional many-to-one association to TMSLeaveType
	@OneToMany(mappedBy="tmsleavePeriod")
	private List<TMSLeaveType> tmsleaveTypes;

	public TMSLeavePeriod() {
	}

	public Long getLeavePeriodId() {
		return this.leavePeriodId;
	}

	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeavePeriodName() {
		return this.leavePeriodName;
	}

	public void setLeavePeriodName(String leavePeriodName) {
		this.leavePeriodName = leavePeriodName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	public List<TMSLeaveCarryForward> getTmsleaveCarryForwards() {
		return this.tmsleaveCarryForwards;
	}

	public void setTmsleaveCarryForwards(List<TMSLeaveCarryForward> tmsleaveCarryForwards) {
		this.tmsleaveCarryForwards = tmsleaveCarryForwards;
	}

	public TMSLeaveCarryForward addTmsleaveCarryForward(TMSLeaveCarryForward tmsleaveCarryForward) {
		getTmsleaveCarryForwards().add(tmsleaveCarryForward);
		tmsleaveCarryForward.setTmsleavePeriod(this);

		return tmsleaveCarryForward;
	}

	public TMSLeaveCarryForward removeTmsleaveCarryForward(TMSLeaveCarryForward tmsleaveCarryForward) {
		getTmsleaveCarryForwards().remove(tmsleaveCarryForward);
		tmsleaveCarryForward.setTmsleavePeriod(null);

		return tmsleaveCarryForward;
	}

	public List<TMSLeaveType> getTmsleaveTypes() {
		return this.tmsleaveTypes;
	}

	public void setTmsleaveTypes(List<TMSLeaveType> tmsleaveTypes) {
		this.tmsleaveTypes = tmsleaveTypes;
	}

	public TMSLeaveType addTmsleaveType(TMSLeaveType tmsleaveType) {
		getTmsleaveTypes().add(tmsleaveType);
		tmsleaveType.setTmsleavePeriod(this);

		return tmsleaveType;
	}

	public TMSLeaveType removeTmsleaveType(TMSLeaveType tmsleaveType) {
		getTmsleaveTypes().remove(tmsleaveType);
		tmsleaveType.setTmsleavePeriod(null);

		return tmsleaveType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}