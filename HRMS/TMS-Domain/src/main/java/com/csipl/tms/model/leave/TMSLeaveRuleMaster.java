package com.csipl.tms.model.leave;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the TMSLeaveRuleMaster database table.
 * 
 */
@Entity
@NamedQuery(name = "TMSLeaveRuleMaster.findAll", query = "SELECT t FROM TMSLeaveRuleMaster t")
public class TMSLeaveRuleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveRuleMasterId;

	private String activeStatus;

	private Long companyId;

	private String ruleCode;

	private String ruleName;



	public Long getLeaveRuleMasterId() {
		return this.leaveRuleMasterId;
	}

	public void setLeaveRuleMasterId(Long leaveRuleMasterId) {
		this.leaveRuleMasterId = leaveRuleMasterId;
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

	public String getRuleCode() {
		return this.ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

}