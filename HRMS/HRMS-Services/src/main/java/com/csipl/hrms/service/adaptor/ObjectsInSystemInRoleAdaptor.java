package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.authorization.ObjectsInSystemInRoleDTO;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;
import com.csipl.hrms.model.authoriztion.RoleMaster;

public class ObjectsInSystemInRoleAdaptor implements Adaptor<ObjectsInSystemInRoleDTO, ObjectsInSystemInRole> {

	@Override
	public List<ObjectsInSystemInRole> uiDtoToDatabaseModelList(List<ObjectsInSystemInRoleDTO> objectsInSystemInRoleDtoList) {
		
		List<ObjectsInSystemInRole> objectsInSystemInRoleList = new ArrayList<ObjectsInSystemInRole>();
		for (ObjectsInSystemInRoleDTO objectsInSystemInRoleDto : objectsInSystemInRoleDtoList) {
			objectsInSystemInRoleList.add(uiDtoToDatabaseModel(objectsInSystemInRoleDto));
		}
		return objectsInSystemInRoleList;
	}

	@Override
	public List<ObjectsInSystemInRoleDTO> databaseModelToUiDtoList(List<ObjectsInSystemInRole> objectsInSystemInRoleList) {
		
		List<ObjectsInSystemInRoleDTO> objectsInSystemInRoleDtoList = new ArrayList<ObjectsInSystemInRoleDTO>();
		for (ObjectsInSystemInRole objectsInSystemInRole : objectsInSystemInRoleList) {
			objectsInSystemInRoleDtoList.add(databaseModelToUiDto(objectsInSystemInRole));
		}
		return objectsInSystemInRoleDtoList;
	}

	@Override
	public ObjectsInSystemInRole uiDtoToDatabaseModel(ObjectsInSystemInRoleDTO objectsInSystemInRoleDto) {
		
		ObjectsInSystemInRole objectsInSystemInRole = new ObjectsInSystemInRole();
		
		objectsInSystemInRole.setObjectsInSystemInRoleId(objectsInSystemInRoleDto.getObjectsInSystemInRoleId());
		RoleMaster roleMaster = new RoleMaster();
		roleMaster.setRoleId(objectsInSystemInRoleDto.getRoleId());
		roleMaster.setRoleDescription(objectsInSystemInRoleDto.getRoleDescription());
		objectsInSystemInRole.setRoleMaster(roleMaster);
		
		ObjectsInSystem objectsInSystem = new ObjectsInSystem();
		objectsInSystem.setObjectId(objectsInSystemInRoleDto.getObjectId());
		objectsInSystem.setObjectDescription(objectsInSystemInRoleDto.getObjectDescription());
		objectsInSystemInRole.setObjectsInSystem(objectsInSystem);
		
		objectsInSystemInRole.setAddRecord(objectsInSystemInRoleDto.getAddRecord());
		objectsInSystemInRole.setModRecord(objectsInSystemInRoleDto.getModRecord());
		objectsInSystemInRole.setDelRecord(objectsInSystemInRoleDto.getDelRecord());
		objectsInSystemInRole.setViewRecord(objectsInSystemInRoleDto.getViewRecord());
		objectsInSystemInRole.setUserId(objectsInSystemInRoleDto.getUserId());
		if(objectsInSystemInRoleDto.getObjectsInSystemInRoleId()==null)
			objectsInSystemInRole.setDateCreated(new Date());
		else
		objectsInSystemInRole.setUserIdUpdate(objectsInSystemInRoleDto.getUserIdUpdate());
		objectsInSystemInRole.setDateUpdate(new Date());
		objectsInSystemInRole.setDateCreated(objectsInSystemInRoleDto.getDateCreated());
		return objectsInSystemInRole;
	}

	@Override
	public ObjectsInSystemInRoleDTO databaseModelToUiDto(ObjectsInSystemInRole objectsInSystemInRole) {
		
		ObjectsInSystemInRoleDTO objectsInSystemInRoleDto = new ObjectsInSystemInRoleDTO();
		objectsInSystemInRoleDto.setObjectsInSystemInRoleId(objectsInSystemInRole.getObjectsInSystemInRoleId());
		objectsInSystemInRoleDto.setRoleId(objectsInSystemInRole.getRoleMaster().getRoleId());
		objectsInSystemInRoleDto.setRoleDescription(objectsInSystemInRole.getRoleMaster().getRoleDescription());
		objectsInSystemInRoleDto.setObjectId(objectsInSystemInRole.getObjectsInSystem().getObjectId());
		objectsInSystemInRoleDto.setObjectDescription(objectsInSystemInRole.getObjectsInSystem().getObjectDescription());
		objectsInSystemInRoleDto.setAddRecord(objectsInSystemInRole.getAddRecord());
		objectsInSystemInRoleDto.setDelRecord(objectsInSystemInRole.getDelRecord());
		objectsInSystemInRoleDto.setModRecord(objectsInSystemInRole.getModRecord());
		objectsInSystemInRoleDto.setViewRecord(objectsInSystemInRole.getViewRecord());
		objectsInSystemInRoleDto.setUserId(objectsInSystemInRole.getUserId());
		objectsInSystemInRoleDto.setDateCreated(objectsInSystemInRole.getDateCreated());
		return objectsInSystemInRoleDto;
	}

}
