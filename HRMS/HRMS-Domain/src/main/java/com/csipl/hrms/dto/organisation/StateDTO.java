package com.csipl.hrms.dto.organisation;

import java.util.ArrayList;
import java.util.List;

public class StateDTO {
	private Long stateId;
	private String stateName;
	private List<CityDTO> cities = new ArrayList<CityDTO>();
	
	public Long getStateId() {
		return stateId;
	}
	public List<CityDTO> getCities() {
		return cities;
	}
	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "StateDTO [stateId=" + stateId + ", stateName=" + stateName + ", cities=" + cities + "]";
	}
	
}
