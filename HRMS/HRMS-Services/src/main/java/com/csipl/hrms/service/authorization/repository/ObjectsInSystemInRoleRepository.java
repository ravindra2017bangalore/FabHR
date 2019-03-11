package com.csipl.hrms.service.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;
public interface ObjectsInSystemInRoleRepository extends CrudRepository<ObjectsInSystemInRole, Long> {

	@Query(" from ObjectsInSystemInRole ")
    public List<ObjectsInSystemInRole> findAllObjectsInSystemInRole();
}
