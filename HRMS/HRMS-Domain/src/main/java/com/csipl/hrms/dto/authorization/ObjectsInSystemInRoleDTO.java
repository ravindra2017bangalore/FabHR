package com.csipl.hrms.dto.authorization;

import java.util.Date;

public class ObjectsInSystemInRoleDTO {

	private Long objectsInSystemInRoleId;
	private Long roleId;
	private String roleDescription;
	private Long objectId;
	private String objectDescription;
	private String addRecord;
	private String modRecord;
	private String delRecord;
	private String viewRecord;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	public Long getObjectsInSystemInRoleId() {
		return objectsInSystemInRoleId;
	}
	public void setObjectsInSystemInRoleId(Long objectsInSystemInRoleId) {
		this.objectsInSystemInRoleId = objectsInSystemInRoleId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public String getObjectDescription() {
		return objectDescription;
	}
	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}
	public String getAddRecord() {
		return addRecord;
	}
	public void setAddRecord(String addRecord) {
		this.addRecord = addRecord;
	}
	public String getModRecord() {
		return modRecord;
	}
	public void setModRecord(String modRecord) {
		this.modRecord = modRecord;
	}
	public String getDelRecord() {
		return delRecord;
	}
	public void setDelRecord(String delRecord) {
		this.delRecord = delRecord;
	}
	public String getViewRecord() {
		return viewRecord;
	}
	public void setViewRecord(String viewRecord) {
		this.viewRecord = viewRecord;
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
	
	
}
