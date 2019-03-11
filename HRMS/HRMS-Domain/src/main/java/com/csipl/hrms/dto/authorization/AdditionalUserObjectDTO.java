package com.csipl.hrms.dto.authorization;

import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
import com.csipl.hrms.model.common.User;

public class AdditionalUserObjectDTO {
	private Long additionalUserObjectsId;

	private String addRecord;

	private String delRecord;

	private String modRecord;

	private Long userId;
	
	private String username;

	private Long objectId;
	
	private String objectDescription;

	private String viewRecord;

	
	public Long getAdditionalUserObjectsId() {
		return additionalUserObjectsId;
	}

	public void setAdditionalUserObjectsId(Long additionalUserObjectsId) {
		this.additionalUserObjectsId = additionalUserObjectsId;
	}

	public String getAddRecord() {
		return addRecord;
	}

	public void setAddRecord(String addRecord) {
		this.addRecord = addRecord;
	}

	public String getDelRecord() {
		return delRecord;
	}

	public void setDelRecord(String delRecord) {
		this.delRecord = delRecord;
	}

	public String getModRecord() {
		return modRecord;
	}

	public void setModRecord(String modRecord) {
		this.modRecord = modRecord;
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

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getObjectDescription() {
		return objectDescription;
	}

	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}

}
