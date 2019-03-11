package com.csipl.hrms.dto.employee;

import java.util.Date;

public class EmployeeDocumentDTO {
	private Long employeeDocumentsId;
	private String documentsId;
	private String description;
	private String activeStatus;
	private Long employeeId;
	private Long userId;
	private  String fileLocation;
	private Date dateCreated;
	private String documentNameValue;
	private String activeStatusValue;
	private Long userIdUpdate;
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public String getActiveStatusValue() {
		return activeStatusValue;
	}
	public void setActiveStatusValue(String activeStatusValue) {
		this.activeStatusValue = activeStatusValue;
	}
	public String getDocumentNameValue() {
		return documentNameValue;
	}
	public void setDocumentNameValue(String documentNameValue) {
		this.documentNameValue = documentNameValue;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getEmployeeDocumentsId() {
		return employeeDocumentsId;
	}
	public void setEmployeeDocumentsId(Long employeeDocumentsId) {
		this.employeeDocumentsId = employeeDocumentsId;
	}
	public String getDocumentsId() {
		return documentsId;
	}
	public void setDocumentsId(String documentsId) {
		this.documentsId = documentsId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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
}
