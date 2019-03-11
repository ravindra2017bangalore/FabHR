package com.csipl.hrms.service.common;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.City;
import com.csipl.hrms.service.organization.repository.CityRepository;


@Service("cityService")
@CacheConfig(cacheNames = "hrmsDBCache")
public class CityServiceImpl implements CityService {
	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City getCity(Long cityId) {
		return	cityRepository.findOne(cityId);
		
	}

	@Override
	public List<City> findAllCities() {
		return cityRepository.findAllCities();
	}
	

}
