package com.csipl.hrms.dto.organisation;

import java.util.List;

public class DropDownHdDTO {
	private Long drowpdownId;
	private String drowpdownName;
	private List<DropDownListDTO> drowpdownLists;
	
	public Long getDrowpdownId() {
		return drowpdownId;
	}
	public void setDrowpdownId(Long drowpdownId) {
		this.drowpdownId = drowpdownId;
	}
	public String getDrowpdownName() {
		return drowpdownName;
	}
	public void setDrowpdownName(String drowpdownName) {
		this.drowpdownName = drowpdownName;
	}
	
	public List<DropDownListDTO> getDrowpdownLists() {
		return drowpdownLists;
	}
	public void setDrowpdownLists(List<DropDownListDTO> drowpdownLists) {
		this.drowpdownLists = drowpdownLists;
	}
	@Override
	public String toString() {
		return "DropDownHdDTO [drowpdownId=" + drowpdownId + ", drowpdownName=" + drowpdownName + ", drowpdownLists="
				+ drowpdownLists + "]";
	}
	
}
