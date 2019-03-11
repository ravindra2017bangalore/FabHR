package com.csipl.hrms.org.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.dto.organisation.CityDTO;
import com.csipl.hrms.dto.organisation.CountryDTO;
import com.csipl.hrms.dto.organisation.StateDTO;
import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.service.organization.AddressService;

@RestController
public class AddressController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	AddressService addressService;

	/**
	 * Method performed address logic based on country state will get and based on
	 * state city will get
	 * 
	 * @param req
	 *            This is the first parameter to maintain user session
	 */
	@RequestMapping(path = "/addresses", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CountryDTO> getAddress(HttpServletRequest req) {
		List<Country> countries = new ArrayList<Country>();

		List<CountryDTO> dtos = new ArrayList<CountryDTO>();
		try {
			countries = addressService.getAddressList();
			addressService.getAddressList().forEach(country -> {
				CountryDTO dto = new CountryDTO();
				List<StateDTO> states = new ArrayList<StateDTO>();
				country.getStates().forEach(state -> {

					StateDTO stateDTO = new StateDTO();
					List<CityDTO> cities = new ArrayList<CityDTO>();
					state.getCities().forEach(city -> {
						CityDTO cityDTO = new CityDTO();
						cityDTO.setCityId(city.getCityId());
						cityDTO.setCityName(city.getCityName());
						cities.add(cityDTO);
					});

					Collections.sort(cities, new Comparator<CityDTO>() {
						@Override
						public int compare(CityDTO cityA, CityDTO cityB) {
							String name1 = cityA.getCityName();
							String name2 = cityB.getCityName();
							int diff = name1.compareTo(name2);
							return diff;
						}

					});

					stateDTO.setStateId(state.getStateId());
					stateDTO.setStateName(state.getStateName());
					stateDTO.setCities(cities);
					states.add(stateDTO);

				});

				Collections.sort(states, new Comparator<StateDTO>() {
					@Override
					public int compare(StateDTO stateA, StateDTO stateB) {
						String name1 = stateA.getStateName();
						String name2 = stateB.getStateName();
						int diff = name1.compareTo(name2);
						return diff;
					}

				});

				dto.setCountryName(country.getCountryName());
				dto.setCountryId(country.getCountryId());
				dto.setStates(states);
				dtos.add(dto);
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dtos;
	}

	/**
	 * to get all states List from database
	 */
	@RequestMapping(path = "/state", method = RequestMethod.GET)
	public @ResponseBody List<StateDTO> getAllStates(HttpServletRequest req) {
		return addressService.findAllStates();

	}

	/**
	 * to get all cities List from database
	 */
	@RequestMapping(path = "/city", method = RequestMethod.GET)
	public @ResponseBody List<CityDTO> getAllCities(@RequestParam("cityId") Long cityId,HttpServletRequest req) {
		return addressService.findAllCities();
	}

	/**
	 * to get cityName List from database
	 */
	@RequestMapping(path = "/cityValue", method = RequestMethod.GET)
	public @ResponseBody CityDTO getAllCity(@RequestParam("cityId") Long cityId,HttpServletRequest req) {
		System.out.println("address Controller");
		return addressService.findcity(cityId);
	}

	/**
	 * to get all cities List from database based on companyId 
	 */
	@RequestMapping(path = "/cities", method = RequestMethod.GET)
	public @ResponseBody List<CityDTO> getCities(@RequestParam("countryId") Long countryId,HttpServletRequest req) {
		logger.info("getCities is calling : countryId ="+ countryId );
 		return addressService.findCities(countryId);
	}
	
}
