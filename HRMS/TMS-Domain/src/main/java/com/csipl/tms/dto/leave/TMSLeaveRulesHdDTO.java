package com.csipl.tms.dto.leave;

import java.util.Date;

import com.csipl.tms.model.leave.TMSLeaveRules;



public class TMSLeaveRulesHdDTO {
	private Long leaveId;
	private Long leaveRulesHdId;

	private String activeStatus;

	private Long companyId;

	private Date dateCreated;

	private Date dateUpdate;

	private Long leavePeriodId;

	private Long userId;

	private Long userIdUpdate;

	private TMSLeaveRules tmsleaveRules;
	
	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Long getLeaveRulesHdId() {
		return leaveRulesHdId;
	}

	public void setLeaveRulesHdId(Long leaveRulesHdId) {
		this.leaveRulesHdId = leaveRulesHdId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getLeavePeriodId() {
		return leavePeriodId;
	}

	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public TMSLeaveRules getTmsleaveRules() {
		return tmsleaveRules;
	}

	public void setTmsleaveRules(TMSLeaveRules tmsleaveRules) {
		this.tmsleaveRules = tmsleaveRules;
	}

	
	
}
