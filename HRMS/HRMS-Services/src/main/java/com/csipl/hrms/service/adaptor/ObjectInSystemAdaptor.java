package com.csipl.hrms.service.adaptor;


import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.authorization.ObjectInSystemDTO;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;


public class ObjectInSystemAdaptor implements Adaptor<ObjectInSystemDTO, ObjectsInSystem> {

	@Override
	public List<ObjectsInSystem> uiDtoToDatabaseModelList(List<ObjectInSystemDTO> objectInSystemDtoList) {
		List<ObjectsInSystem> objectsInSystem=new ArrayList<ObjectsInSystem>();
		for(ObjectInSystemDTO objectInSystemDto:objectInSystemDtoList) {
		
			objectsInSystem.add(uiDtoToDatabaseModel(objectInSystemDto));
		}
		return objectsInSystem;
	}

	@Override
	public List<ObjectInSystemDTO> databaseModelToUiDtoList(List<ObjectsInSystem> objectInSystemList) {
		List<ObjectInSystemDTO> objectInSystemDtoList=new ArrayList<ObjectInSystemDTO>();
		for(ObjectsInSystem objectInSystem:objectInSystemList) {
		
			objectInSystemDtoList.add(databaseModelToUiDto(objectInSystem));
		}
		return objectInSystemDtoList;	}

	@Override
	public ObjectsInSystem uiDtoToDatabaseModel(ObjectInSystemDTO objectInSystemDTO) {
		
		ObjectsInSystem objectsInSystem=new ObjectsInSystem();
		
		objectsInSystem.setObjectId(objectInSystemDTO.getObjectId());
		objectsInSystem.setObjectDescription(objectInSystemDTO.getObjectDescription());
		objectsInSystem.setObjectTechnicalName(objectInSystemDTO.getObjectTechnicalName());
		
		return objectsInSystem;
	}

	@Override
	public ObjectInSystemDTO databaseModelToUiDto(ObjectsInSystem objectsInSystem) {
		ObjectInSystemDTO objectInSystemDto=new ObjectInSystemDTO();
		objectInSystemDto.setObjectId(objectsInSystem.getObjectId());
		objectInSystemDto.setObjectDescription(objectsInSystem.getObjectDescription());
		objectInSystemDto.setObjectTechnicalName(objectsInSystem.getObjectTechnicalName());
		
		return objectInSystemDto;
	}

}
