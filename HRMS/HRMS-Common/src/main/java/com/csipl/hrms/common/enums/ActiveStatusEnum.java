package com.csipl.hrms.common.enums;

public enum ActiveStatusEnum {
	ActiveStatus("AC");
 	public String activeStatus;
	
 	ActiveStatusEnum ( String activeStatus ) {
		this.activeStatus = activeStatus;
	}

	public String getActiveStatus() {
		return activeStatus;
	}
 	}
