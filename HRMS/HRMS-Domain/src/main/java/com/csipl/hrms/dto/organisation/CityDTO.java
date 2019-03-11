package com.csipl.hrms.dto.organisation;

public class CityDTO {
	private Long cityId;
	private String cityName;
	private String cityStateValue;

	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "CityDTO [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	public String getCityStateValue() {
		return cityStateValue;
	}
	public void setCityStateValue(String cityStateValue) {
		this.cityStateValue = cityStateValue;
	}
	 
}
