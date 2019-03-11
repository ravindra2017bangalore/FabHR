package com.csipl.hrms.service.organization.repository;
  import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.model.common.State;
  public interface StateRepository extends CrudRepository<State, Long> {
	@Query("from State ")
    public List<State> findAllState();
	
}