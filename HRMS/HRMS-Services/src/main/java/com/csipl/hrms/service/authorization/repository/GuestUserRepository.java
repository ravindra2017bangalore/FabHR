package com.csipl.hrms.service.authorization.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.GuestUser;
import com.csipl.hrms.model.organisation.Department;




public interface GuestUserRepository extends CrudRepository<GuestUser, Long> {
	
 	@Query(" from GuestUser  ") 
 	public List<GuestUser> findAll();
}
