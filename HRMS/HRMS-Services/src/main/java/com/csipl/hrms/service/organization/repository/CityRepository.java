package com.csipl.hrms.service.organization.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.State;
public interface CityRepository extends CrudRepository<City, Long> {
	@Query("from City order by cityName asc")
    public List<City> findAllCities();
	
	@Query(" from City where cityId=?1 order by cityName asc")
    public City findCityById( long cityId);

	@Query("from City  where countryId=?1 order by cityName asc")
	public List<City> findCities(Long countryId);
}