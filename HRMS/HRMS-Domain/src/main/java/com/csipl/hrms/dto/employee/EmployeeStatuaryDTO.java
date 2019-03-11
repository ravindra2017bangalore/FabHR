package com.csipl.hrms.dto.employee;

import java.util.Date;


public class EmployeeStatuaryDTO {
	
	private Long statuaryId;
	private String dateFrom;
	private String dateTo;
	private String statuaryNumber;
	private String statuaryType;
	private Long employeeId;
	private Long familyId;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
	
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
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
	public Long getStatuaryId() {
		return statuaryId;
	}
	public void setStatuaryId(Long statuaryId) {
		this.statuaryId = statuaryId;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getStatuaryNumber() {
		return statuaryNumber;
	}
	public void setStatuaryNumber(String statuaryNumber) {
		this.statuaryNumber = statuaryNumber;
	}
	public String getStatuaryType() {
		return statuaryType;
	}
	public void setStatuaryType(String statuaryType) {
		this.statuaryType = statuaryType;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

}

