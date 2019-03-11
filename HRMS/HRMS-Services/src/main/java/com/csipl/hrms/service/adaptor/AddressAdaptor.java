package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.organisation.AddressDTO;
import com.csipl.hrms.dto.organisation.CityDTO;
import com.csipl.hrms.dto.organisation.CountryDTO;
import com.csipl.hrms.dto.organisation.StateDTO;
import com.csipl.hrms.model.candidate.CandidateAddress;
import com.csipl.hrms.model.common.Address;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.model.employee.Employee;

public class AddressAdaptor implements Adaptor<AddressDTO, Address> {

	@Override
	public List<Address> uiDtoToDatabaseModelList(List<AddressDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDTO> databaseModelToUiDtoList(List<Address> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address uiDtoToDatabaseModel(AddressDTO addressDto) {
		Address address = new Address();
		if(addressDto != null) {
		if(addressDto.getAddressId()!=null)
		address.setAddressId(addressDto.getAddressId());
		address.setEmailId(addressDto.getEmailId());
		address.setFax(addressDto.getFax());
		address.setPincode(addressDto.getPincode());
		address.setTelephone(addressDto.getTelephone());
		address.setAddressText(addressDto.getAddressText());
		address.setWebsite(addressDto.getWebsite());
		address.setMobile(addressDto.getMobile());
		address.setLandmark(addressDto.getLandmark());
		address.setUserId(addressDto.getUserId());
		Country country = new Country();
		country.setCountryId(addressDto.getCountryId());
		address.setCountry(country);
		
		if(addressDto.getAddressId()==null) {
			address.setDateCreated(new Date());
 		}
		else
			address.setDateCreated(addressDto.getDateCreated());
 		address.setDateUpdate(new Date());
		address.setUserIdUpdate(addressDto.getUserIdUpdate());
 
		State state = new State();
		state.setStateId(addressDto.getStateId());
		address.setState(state);
		
		City city = new City();
		city.setCityId(addressDto.getCityId());
		address.setCity(city);
			
		
  		address.setUserId(1l);//addressDto.getUserId()
  		address.setUserIdUpdate(addressDto.getUserIdUpdate());
	}
 		return address;
	}
	
	public CandidateAddress uiDtoToDatabaseModels(AddressDTO addressDto) {
		CandidateAddress address = new CandidateAddress();
		if(addressDto != null) {
		if(addressDto.getAddressId()!=null)
		address.setAddressId(addressDto.getAddressId());
		address.setEmailId(addressDto.getEmailId());
		address.setFax(addressDto.getFax());
		address.setPincode(addressDto.getPincode());
		address.setTelephone(addressDto.getTelephone());
		address.setAddressText(addressDto.getAddressText());
		address.setWebsite(addressDto.getWebsite());
		address.setMobile(addressDto.getMobile());
		address.setLandmark(addressDto.getLandmark());
		address.setUserId(addressDto.getUserId());
		Country country = new Country();
		country.setCountryId(addressDto.getCountryId());
		address.setCountry(country);
		
		if(addressDto.getAddressId()==null) {
			address.setDateCreated(new Date());
 		}
		else
			address.setDateCreated(addressDto.getDateCreated());
 		address.setDateUpdate(new Date());
		address.setUserIdUpdate(addressDto.getUserIdUpdate());
 
		State state = new State();
		state.setStateId(addressDto.getStateId());
		address.setState(state);
		
		City city = new City();
		city.setCityId(addressDto.getCityId());
		address.setCity(city);
			
		
  		address.setUserId(1l);//addressDto.getUserId()
  		address.setUserIdUpdate(addressDto.getUserIdUpdate());
	}
 		return address;
	}

	@Override
	public AddressDTO databaseModelToUiDto(Address address) {
		// TODO Auto-generated method stub

		AddressDTO addressDto = new AddressDTO();
		if (address != null) {
			addressDto.setAddressId(address.getAddressId());
			addressDto.setAddressText(address.getAddressText());
			addressDto.setMobile(address.getMobile());
			addressDto.setEmailId(address.getEmailId());
			addressDto.setFax(address.getFax());
			addressDto.setLandmark(address.getLandmark());
			addressDto.setTelephone(address.getTelephone());
			addressDto.setPincode(address.getPincode());
			addressDto.setWebsite(address.getWebsite());
		 
			addressDto.setUserId(address.getUserId());
			addressDto.setDateCreated(address.getDateCreated());
			CityDTO city = new CityDTO();
			city.setCityId(address.getCity().getCityId());
			city.setCityName(address.getCity().getCityName());
			addressDto.setCity(city);

			addressDto.setCityId(address.getCity().getCityId());
			addressDto.setCityName(address.getCity().getCityName());

			StateDTO state = new StateDTO();
			state.setStateId(address.getState().getStateId());
			state.setStateName(address.getState().getStateName());
			addressDto.setState(state);

			addressDto.setStateId(address.getState().getStateId());
			addressDto.setStateName(address.getState().getStateName());

			CountryDTO country = new CountryDTO();
			country.setCountryId(address.getCountry().getCountryId());
			country.setCountryName(address.getCountry().getCountryName());
			addressDto.setCountry(country);

			addressDto.setCountryId(address.getCountry().getCountryId());
			addressDto.setCountryName(address.getCountry().getCountryName());
		}
		return addressDto;
	}
	
	
	public AddressDTO databaseModelToUiDto(CandidateAddress address) {
		// TODO Auto-generated method stub

		AddressDTO addressDto = new AddressDTO();
		if (address != null) {
			addressDto.setAddressId(address.getAddressId());
			addressDto.setAddressText(address.getAddressText());
			addressDto.setMobile(address.getMobile());
			addressDto.setEmailId(address.getEmailId());
			addressDto.setFax(address.getFax());
			addressDto.setLandmark(address.getLandmark());
			addressDto.setTelephone(address.getTelephone());
			addressDto.setPincode(address.getPincode());
			addressDto.setWebsite(address.getWebsite());
		 
			addressDto.setUserId(address.getUserId());
			addressDto.setDateCreated(address.getDateCreated());
			CityDTO city = new CityDTO();
			city.setCityId(address.getCity().getCityId());
			city.setCityName(address.getCity().getCityName());
			addressDto.setCity(city);

			addressDto.setCityId(address.getCity().getCityId());
			addressDto.setCityName(address.getCity().getCityName());

			StateDTO state = new StateDTO();
			state.setStateId(address.getState().getStateId());
			state.setStateName(address.getState().getStateName());
			addressDto.setState(state);

			addressDto.setStateId(address.getState().getStateId());
			addressDto.setStateName(address.getState().getStateName());

			CountryDTO country = new CountryDTO();
			country.setCountryId(address.getCountry().getCountryId());
			country.setCountryName(address.getCountry().getCountryName());
			addressDto.setCountry(country);

			addressDto.setCountryId(address.getCountry().getCountryId());
			addressDto.setCountryName(address.getCountry().getCountryName());
		}
		return addressDto;
	}

	public List<StateDTO> databaseModelToUiDto(List<State> stateList) {
		List<StateDTO> stateDtoList = new ArrayList<StateDTO>();
		for (State state : stateList) {
			stateDtoList.add(databaseModelToUiDto(state));
		}
		return stateDtoList;
	}

	public StateDTO databaseModelToUiDto(State state) {
		StateDTO stateDto = new StateDTO();
		stateDto.setStateId(state.getStateId());
		stateDto.setStateName(state.getStateName());
		return stateDto;

	}

	public List<CityDTO> databaseModelToUiDtoCity(List<City> cityList) {
		List<CityDTO> ctyDtoList = new ArrayList<CityDTO>();
		for (City city : cityList) {
			ctyDtoList.add(databaseModelToUiDto(city));
		}
		return ctyDtoList;
	}

	public CityDTO databaseModelToUiDto(City city) {
		CityDTO cityDto = new CityDTO();
		cityDto.setCityId(city.getCityId());
		cityDto.setCityName(city.getCityName());
		cityDto.setCityStateValue(city.getCityName() +" ("+city.getState().getStateName()+")");
		return cityDto;

	}
 	public Address uiDtoToDatabaseModel(AddressDTO addressDto,Employee employee) {
		Address address = new Address();
		address.setAddressId(addressDto.getAddressId());
		address.setEmailId(addressDto.getEmailId());
		address.setFax(addressDto.getFax());
		address.setPincode(addressDto.getPincode());
		address.setTelephone(addressDto.getTelephone());
		address.setAddressText(addressDto.getAddressText());
		address.setWebsite(addressDto.getWebsite());
		address.setMobile(addressDto.getMobile());
		address.setLandmark(addressDto.getLandmark());
		address.setUserId(addressDto.getUserId());

		Country country = new Country();
		country.setCountryId(addressDto.getCountryId());
		address.setCountry(country);

		State state = new State();
		state.setStateId(addressDto.getStateId());
		address.setState(state);
		
		City city = new City();
		city.setCityId(addressDto.getCityId());
		address.setCity(city);
    		address.setUserId(employee.getUserId());
 		return address;
	}
}
