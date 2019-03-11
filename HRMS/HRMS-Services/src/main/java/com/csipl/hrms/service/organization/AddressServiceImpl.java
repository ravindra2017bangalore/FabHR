package com.csipl.hrms.service.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.dto.organisation.CityDTO;
import com.csipl.hrms.dto.organisation.StateDTO;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.service.adaptor.AddressAdaptor;
import com.csipl.hrms.service.organization.repository.CityRepository;
import com.csipl.hrms.service.organization.repository.CountryRepository;
import com.csipl.hrms.service.organization.repository.StateRepository;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

	/**
	 * to get all countries List from database  
	 */
	public List<Country> getAddressList() {
		return countryRepository.findAllCountry();
	}


	/**
	 * to get all states List from database  
	 */
	@Override
	public List<StateDTO> findAllStates() {
		List<State> stateList = stateRepository.findAllState();
		AddressAdaptor addressAdaptor = new AddressAdaptor();
		return addressAdaptor.databaseModelToUiDto(stateList);
	}


	/**
	 * to get all cities List from database  
	 */
	@Override
	public List<CityDTO> findAllCities() {
		List<City> cityList = cityRepository.findAllCities();
		AddressAdaptor addressAdaptor = new AddressAdaptor();
		return addressAdaptor.databaseModelToUiDtoCity(cityList);
	}
	@Override
	public List<CityDTO> findCities(Long countryId) {
		logger.info(" service findCities is calling : countryId ="+ countryId );

		List<City> cityList = cityRepository.findCities(countryId);
		AddressAdaptor addressAdaptor = new AddressAdaptor();
		return addressAdaptor.databaseModelToUiDtoCity(cityList);
	}


	@Override
	public CityDTO findcity(Long cityId) {
		City city = cityRepository.findOne(cityId);
		AddressAdaptor addressAdaptor = new AddressAdaptor();
		return addressAdaptor.databaseModelToUiDto(city);
	}
}
