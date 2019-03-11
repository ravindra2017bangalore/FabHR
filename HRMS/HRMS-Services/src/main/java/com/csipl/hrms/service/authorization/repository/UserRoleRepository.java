package com.csipl.hrms.service.authorization.repository;


 import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.authoriztion.UserRole;
  

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	@Query("from UserRole ") 
	public List<UserRole> findAllUserRoles();
	
	@Query("from UserRole where userId=?1") 
	public List<UserRole> findUserRoles(Long userId);
  	
	/*@Query("delete from UserRole where userId=?1") 
	public List<UserRole> deleteUserRoles(Long userId);*/
	
}
