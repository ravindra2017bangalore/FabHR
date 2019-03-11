package com.csipl.hrms.common.enums;

public enum RelationEnum {

	Father("FA"),Mother("MO"),Spouse("SP"),Child("CH"),Sister("SI"),Brother("BR"),Husband("HB");
	
	String relation;
	
	RelationEnum( String relation ) {
		this.relation = relation;
	}

	public String getRelation() {
		return relation;
	}
}
