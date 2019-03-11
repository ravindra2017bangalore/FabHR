package com.csipl.hrms.dto.organisation;

public class DropDownListDTO {
	private short drowpdownListId;
	private String activeStatus;
	private String listCode;
	private String listValue;
	
	public short getDrowpdownListId() {
		return drowpdownListId;
	}
	public void setDrowpdownListId(short drowpdownListId) {
		this.drowpdownListId = drowpdownListId;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getListCode() {
		return listCode;
	}
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	public String getListValue() {
		return listValue;
	}
	public void setListValue(String listValue) {
		this.listValue = listValue;
	}
	@Override
	public String toString() {
		return "DropDownListDTO [drowpdownListId=" + drowpdownListId + ", activeStatus=" + activeStatus + ", listCode="
				+ listCode + ", listValue=" + listValue + "]";
	}
	
	
}
