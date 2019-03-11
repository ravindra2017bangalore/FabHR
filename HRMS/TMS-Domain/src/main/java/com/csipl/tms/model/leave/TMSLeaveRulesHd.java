package com.csipl.tms.model.leave;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TMSLeaveRulesHd database table.
 * 
 */
@Entity
@NamedQuery(name="TMSLeaveRulesHd.findAll", query="SELECT t FROM TMSLeaveRulesHd t")
public class TMSLeaveRulesHd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveRulesHdId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long leavePeriodId;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TMSLeaveRule
	@OneToMany(mappedBy="tmsleaveRulesHd", cascade=CascadeType.ALL)
	private List<TMSLeaveRules> tmsleaveRules;

	public TMSLeaveRulesHd() {
	}

	public Long getLeaveRulesHdId() {
		return this.leaveRulesHdId;
	}

	public void setLeaveRulesHdId(Long leaveRulesHdId) {
		this.leaveRulesHdId = leaveRulesHdId;
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

	public Long getLeavePeriodId() {
		return this.leavePeriodId;
	}

	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
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

	public List<TMSLeaveRules> getTmsleaveRules() {
		return this.tmsleaveRules;
	}

	public void setTmsleaveRules(List<TMSLeaveRules> tmsleaveRules) {
		this.tmsleaveRules = tmsleaveRules;
	}

	public TMSLeaveRules addTmsleaveRule(TMSLeaveRules tmsleaveRules) {
		getTmsleaveRules().add(tmsleaveRules);
		tmsleaveRules.setTmsleaveRulesHd(this);

		return tmsleaveRules;
	}

	public TMSLeaveRules removeTmsleaveRule(TMSLeaveRules tmsleaveRules) {
		getTmsleaveRules().remove(tmsleaveRules);
		tmsleaveRules.setTmsleaveRulesHd(null);

		return tmsleaveRules;
	}

}