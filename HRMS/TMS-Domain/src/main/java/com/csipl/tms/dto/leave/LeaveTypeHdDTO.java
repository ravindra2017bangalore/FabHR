package com.csipl.tms.dto.leave;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class LeaveTypeHdDTO {
	
	@ApiModelProperty(notes = "The database generated LeaveTypeHd ID")
	private Long leaveTypeHdId;
	
	@ApiModelProperty(notes = "The Active Status field")
	private String activestatus;
	
	@ApiModelProperty(notes = "The dateCreated field")
	private Date dateCreated;

	@ApiModelProperty(notes = "The effectiveEndDate field", required = true)
	private Date effectiveEndDate;

	@ApiModelProperty(notes = "The effectiveStartDate field ", required = true)
	private Date effectiveStartDate;
	
	@ApiModelProperty(notes = "The database generated LeaveTypeHd ID")
	private String leaveRuleType;
	
	private String leaveRuleTypeValue;
	
	private String leaveRuleChange;
	
	private List<LeaveTypeDTO> tmsleaveTypes;
	
	@ApiModelProperty(notes = "User ID field", required = true)
	private Long userId;
	
	@ApiModelProperty(notes = "Company ID field", required = true)
	private Long companyId;
	
	@ApiModelProperty(notes = "User ID update field")
	private Long userIdUpdate;
	

	public Long getLeaveTypeHdId() {
		return leaveTypeHdId;
	}

	public void setLeaveTypeHdId(Long leaveTypeHdId) {
		this.leaveTypeHdId = leaveTypeHdId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getLeaveRuleType() {
		return leaveRuleType;
	}

	public void setLeaveRuleType(String leaveRuleType) {
		this.leaveRuleType = leaveRuleType;
	}

	public List<LeaveTypeDTO> getTmsleaveTypes() {
		return tmsleaveTypes;
	}

	public void setTmsleaveTypes(List<LeaveTypeDTO> tmsleaveTypes) {
		this.tmsleaveTypes = tmsleaveTypes;
	}

	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public String getLeaveRuleTypeValue() {
		return leaveRuleTypeValue;
	}

	public void setLeaveRuleTypeValue(String leaveRuleTypeValue) {
		this.leaveRuleTypeValue = leaveRuleTypeValue;
	}

	public String getLeaveRuleChange() {
		return leaveRuleChange;
	}

	public void setLeaveRuleChange(String leaveRuleChange) {
		this.leaveRuleChange = leaveRuleChange;
	}



}
