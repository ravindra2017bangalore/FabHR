package com.csipl.hrms.dto.employee;

import java.util.Date;

public class MassCommunicationDTO {

	private Long massCommunicationId;
	private String title;
	private Long departmentId;
	private String departmentName;
	private String description;
	private Date dateFrom;
	private Date dateTo;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "MassCommunicationDTO [massCommunicationId=" + massCommunicationId + ", title=" + title
				+ ", departmentId=" + departmentId + ", description=" + description + ", dateFrom=" + dateFrom
				+ ", dateTo=" + dateTo + ", userId=" + userId + ", dateCreated=" + dateCreated + "]";
	}

	public Long getMassCommunicationId() {
		return massCommunicationId;
	}

	public void setMassCommunicationId(Long massCommunicationId) {
		this.massCommunicationId = massCommunicationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
