package com.csipl.hrms.service.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.employee.Employee;


public interface AdditionalUserObjectRepository extends CrudRepository<AdditionalUserObject, Long> {
	
  	@Query("from AdditionalUserObject  ") 
 	public List<AdditionalUserObject> findAdditionaluserObject();
  	
}
