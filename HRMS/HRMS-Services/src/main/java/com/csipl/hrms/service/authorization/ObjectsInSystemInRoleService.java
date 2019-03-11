package com.csipl.hrms.service.authorization;

import java.util.List;

import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;

public interface ObjectsInSystemInRoleService {

	public void saveAllObjectsInSystemInRole(List<ObjectsInSystemInRole> objectsInSystemInRole);
	
	public List<ObjectsInSystemInRole> findAllObjectsInSystemInRole();
}
