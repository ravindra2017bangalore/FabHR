
package com.csipl.tms.dto.leave;

import java.util.Date;

/**
 * @author admin
 *
 */
public class TMSLeaveRulesDTO {
	
	private Long leaveRuleId;
	private String activeStatus;
	private Date dateCreated;
	private Long leaveRuleHdId;	 
	private Date dateUpdate;
	private String description;
	private String ruleCode;
	private String ruleName;
	private Long userId;
	private Long userIdUpdate;
	private Long days;
	private Long leaveRuleMasterId;
	public Long getLeaveRuleMasterId() {
		return leaveRuleMasterId;
	}

	public void setLeaveRuleMasterId(Long leaveRuleMasterId) {
		this.leaveRuleMasterId = leaveRuleMasterId;
	}

	public Long getLeaveRuleHdId() {
		return leaveRuleHdId;
	}

	public void setLeaveRuleHdId(Long leaveRuleHdId) {
		this.leaveRuleHdId = leaveRuleHdId;
	}
	
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

}
