package com.csipl.hrms.dto.report;

public class DesignationData {
	
	 String label;
     String value;
   
     
   
	public DesignationData(String label, String value) {
	
		this.label = label;
		this.value = value;
		
	}
	

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
     
     

}