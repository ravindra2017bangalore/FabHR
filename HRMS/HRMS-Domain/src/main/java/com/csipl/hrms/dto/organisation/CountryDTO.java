package com.csipl.hrms.dto.organisation;

import java.util.List;

public class CountryDTO {
	
	private Long countryId;
	private String countryName;
	private List<StateDTO> states;
	
	public List<StateDTO> getStates() {
		return states;
	}
	public void setStates(List<StateDTO> states) {
		this.states = states;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "CountryDTO [countryId=" + countryId + ", countryName=" + countryName + ", states=" + states + "]";
	}
	
	
}
