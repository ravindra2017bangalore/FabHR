package com.csipl.tms.model.leave;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TMSLeaveRules database table.
 * 
 */
@Entity
@Table(name="TMSLeaveRules")
@NamedQuery(name="TMSLeaveRules.findAll", query="SELECT t FROM TMSLeaveRules t")
public class TMSLeaveRules implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveRuleId;


	
	private String activeStatus;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long days;

	private String description;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TMSLeaveRulesHd
	@ManyToOne
	@JoinColumn(name="leaveRuleHdId")
	private TMSLeaveRulesHd tmsleaveRulesHd;

	//bi-directional many-to-one association to TMSLeaveRuleMaster
	@ManyToOne
	@JoinColumn(name="leaveRuleMasterId")
	private TMSLeaveRuleMaster tmsleaveRuleMaster;

	

	public Long getLeaveRuleId() {
		return this.leaveRuleId;
	}

	public void setLeaveRuleId(Long leaveRuleId) {
		this.leaveRuleId = leaveRuleId;
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

	public Long getDays() {
		return this.days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public TMSLeaveRulesHd getTmsleaveRulesHd() {
		return this.tmsleaveRulesHd;
	}

	public void setTmsleaveRulesHd(TMSLeaveRulesHd tmsleaveRulesHd) {
		this.tmsleaveRulesHd = tmsleaveRulesHd;
	}

	public TMSLeaveRuleMaster getTmsleaveRuleMaster() {
		return this.tmsleaveRuleMaster;
	}

	public void setTmsleaveRuleMaster(TMSLeaveRuleMaster tmsleaveRuleMaster) {
		this.tmsleaveRuleMaster = tmsleaveRuleMaster;
	}


	
	

}