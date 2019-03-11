package com.csipl.hrms.service.organization;

import java.util.List;

import com.csipl.hrms.dto.organisation.CityDTO;
import com.csipl.hrms.dto.organisation.StateDTO;
import com.csipl.hrms.model.common.Country;


public interface AddressService {
	 public List<Country> getAddressList();
 	public List<StateDTO> findAllStates();
 	public List<CityDTO> findAllCities();
 	public CityDTO findcity(Long cityId);
	public List<CityDTO> findCities(Long countryId);

}

