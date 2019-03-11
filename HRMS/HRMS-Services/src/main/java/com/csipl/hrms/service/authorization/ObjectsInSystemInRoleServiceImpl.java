package com.csipl.hrms.service.authorization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;
import com.csipl.hrms.service.authorization.repository.ObjectsInSystemInRoleRepository;

@Service("objectsInSystemInRoleService")
public class ObjectsInSystemInRoleServiceImpl implements ObjectsInSystemInRoleService {
	
	/* @Autowired 
	private ObjectsInSystemInRoleRepository objectsInSystemInRoleRepository; */
	
	@Override
	public void saveAllObjectsInSystemInRole(List<ObjectsInSystemInRole> objectsInSystemInRoleList) {
	//	objectsInSystemInRoleRepository.save(objectsInSystemInRoleList);
		
	}

	@Override
	public List<ObjectsInSystemInRole> findAllObjectsInSystemInRole() {
		//return objectsInSystemInRoleRepository.findAllObjectsInSystemInRole();
		return null;
	}

}
