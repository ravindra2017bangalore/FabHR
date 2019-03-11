package com.csipl.tms.dto.halfdayrule;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class HalfDayRuleDTO {

	@ApiModelProperty(notes = "The database generated halfDayRule Id")
	private Long halfDayRuleId;
	@ApiModelProperty(notes = "Maximum require hour field", required = true)
	private Long maximumRequireHour;
	@ApiModelProperty(notes = "Minimum require hour field", required = true)
	private Long minimumRequireHour;
	@ApiModelProperty(notes = "Date created field", required = true)
	private Date createdDate;
	@ApiModelProperty(notes = "Date update field", required = true)
	private Date updatedDate;
	@ApiModelProperty(notes = "User Id update field", required = true)
	private Long updateUserId;
	@ApiModelProperty(notes = "User Id field", required = true)
	private Long userId;
	@ApiModelProperty(notes = "Company Id field", required = true)
	private Long companyId;

	public Long getHalfDayRuleId() {
		return halfDayRuleId;
	}

	public void setHalfDayRuleId(Long halfDayRuleId) {
		this.halfDayRuleId = halfDayRuleId;
	}

	public Long getMaximumRequireHour() {
		return maximumRequireHour;
	}

	public void setMaximumRequireHour(Long maximumRequireHour) {
		this.maximumRequireHour = maximumRequireHour;
	}

	public Long getMinimumRequireHour() {
		return minimumRequireHour;
	}

	public void setMinimumRequireHour(Long minimumRequireHour) {
		this.minimumRequireHour = minimumRequireHour;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
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

}
