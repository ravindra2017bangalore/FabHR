package com.csipl.hrms.service.common;

import java.util.List;

import com.csipl.hrms.model.common.City;

public interface CityService {

	public City getCity(Long cityId);
	public List<City> findAllCities();
}
 