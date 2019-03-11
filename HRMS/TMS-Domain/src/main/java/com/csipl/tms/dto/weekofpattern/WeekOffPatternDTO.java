package com.csipl.tms.dto.weekofpattern;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class WeekOffPatternDTO {

	@ApiModelProperty(notes = "The database generated pattern Id")
	private Long patternId;
	@ApiModelProperty(notes = "Date created field", required = true)
	private Date createdDate;
	@ApiModelProperty(notes = "Day field", required = true)
	private String[] days;
	@ApiModelProperty(notes = "Pattern Name field", required = true)
	private String patternName;
	@ApiModelProperty(notes = "Date update field", required = true)
	private Date updatedDate;
	@ApiModelProperty(notes = "User Id update field", required = true)
	private Long updateUserId;
	@ApiModelProperty(notes = "User Id field", required = true)
	private Long userId;
	@ApiModelProperty(notes = "Company Id field", required = true)
	private Long companyId;
	private String activeStatus;
	public Long getPatternId() {
		return patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
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

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
