package com.csipl.hrms.service.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.authoriztion.RoleMaster;

public interface RoleMasterRepository extends CrudRepository<RoleMaster, Long> {
	
	@Query(" from RoleMaster ")
    public List<RoleMaster> findAllRoleMasters();
	
	@Query("  from RoleMaster where roleDescription = 'ESSUser'")
    public RoleMaster getRoleMasterId();
	
  }