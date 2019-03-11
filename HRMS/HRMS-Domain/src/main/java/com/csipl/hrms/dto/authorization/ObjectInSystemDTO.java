package com.csipl.hrms.dto.authorization;



public class ObjectInSystemDTO {

	private Long objectId;

	private String objectDescription;

	private String objectTechnicalName;

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

	public String getObjectTechnicalName() {
		return objectTechnicalName;
	}

	public void setObjectTechnicalName(String objectTechnicalName) {
		this.objectTechnicalName = objectTechnicalName;
	}

	
}
