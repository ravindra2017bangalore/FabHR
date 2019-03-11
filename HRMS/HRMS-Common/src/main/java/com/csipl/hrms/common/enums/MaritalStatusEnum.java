package com.csipl.hrms.common.enums;

public enum MaritalStatusEnum {

	Married("MA"),Unmarried("UN");
	
	String maritalStatus;
	MaritalStatusEnum( String maritalStatus ) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	
}
