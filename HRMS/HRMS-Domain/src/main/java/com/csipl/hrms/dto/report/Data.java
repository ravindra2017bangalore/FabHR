package com.csipl.hrms.dto.report;

public class Data {
	
     String label;
     String value;
     String color;
     
     
     public Data(String value) {
    	 super();
 		this.value = value;
 	}
	public Data(String label, String value,String color) {
		super();
		this.label = label;
		this.value = value;
		this.color=color;
	}
	
	public Data(String label, String value) {
		super();
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
     
     
     
}
