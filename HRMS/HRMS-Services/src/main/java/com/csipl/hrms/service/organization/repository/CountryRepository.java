package com.csipl.hrms.service.organization.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.Country;



public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query("from Country ")
    public List<Country> findAllCountry();
	
}