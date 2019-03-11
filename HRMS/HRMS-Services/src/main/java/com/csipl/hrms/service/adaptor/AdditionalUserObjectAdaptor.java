package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.authorization.AdditionalUserObjectDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.EmployeeIdProof;

public class AdditionalUserObjectAdaptor  implements Adaptor<AdditionalUserObjectDTO, AdditionalUserObject>{

	/*@Override
	public List<AdditionalUserObject> uiDtoToDatabaseModelList(List<AdditionalUserObjectDTO> additionalUserObjectDtoList) {
		List<AdditionalUserObject> additionalUserObjectList=new ArrayList<AdditionalUserObject>();
		for (AdditionalUserObjectDTO additionalUserObjectDto : additionalUserObjectDtoList) {
			employeeIdProofList.add(uiDtoToDatabaseModel(employeeIdProofDto, empId));
		}
		return additionalUserObjectList;
		
	}*/

	@Override
	public List<AdditionalUserObjectDTO> databaseModelToUiDtoList(List<AdditionalUserObject> additionalUserObjectList) {
		List<AdditionalUserObjectDTO> additionalUserObjectDtoList=new ArrayList<AdditionalUserObjectDTO>();
		for(AdditionalUserObject additionalUserObject:additionalUserObjectList) {
		
			additionalUserObjectDtoList.add(databaseModelToUiDto(additionalUserObject));
		}
		return additionalUserObjectDtoList;
	
	}

	@Override
	public AdditionalUserObject uiDtoToDatabaseModel(AdditionalUserObjectDTO additionalUserObjectDto) {
		AdditionalUserObject additionalUserObj= new AdditionalUserObject();
		additionalUserObj.setAdditionalUserObjectsId(additionalUserObjectDto.getAdditionalUserObjectsId());
		additionalUserObj.setAddRecord(additionalUserObjectDto.getAddRecord());
		additionalUserObj.setDelRecord(additionalUserObjectDto.getDelRecord());
		additionalUserObj.setModRecord(additionalUserObjectDto.getModRecord());
		additionalUserObj.setViewRecord(additionalUserObjectDto.getViewRecord());
		
		User user=new User();
		user.setUserId(additionalUserObjectDto.getUserId());
		user.setNameOfUser(additionalUserObjectDto.getUsername());
		additionalUserObj.setUser(user);
		
		ObjectsInSystem objInSystem=new ObjectsInSystem();
		System.out.println(additionalUserObjectDto.getObjectId());
		objInSystem.setObjectId(additionalUserObjectDto.getObjectId());
		System.out.println("objectId"+objInSystem.getObjectId());
		objInSystem.setObjectDescription(additionalUserObjectDto.getObjectDescription());
		additionalUserObj.setObjectsInSystem(objInSystem);
		//additionalUserObj.setSUserId(1l);
		System.out.println(additionalUserObj.getObjectsInSystem().getObjectId());
		return additionalUserObj;
	}
	
	

	@Override
	public AdditionalUserObjectDTO databaseModelToUiDto(AdditionalUserObject additionalUserObject ) {
		AdditionalUserObjectDTO additionalUserObjectDto = new AdditionalUserObjectDTO();
		additionalUserObjectDto.setAdditionalUserObjectsId(additionalUserObject.getAdditionalUserObjectsId());
		//additionalUserObjectDto.setObjectsInSystem(additionalUserObject.getObjectsInSystem());
		additionalUserObjectDto.setAddRecord(additionalUserObject.getAddRecord());
		additionalUserObjectDto.setDelRecord(additionalUserObject.getDelRecord());
		additionalUserObjectDto.setModRecord(additionalUserObject.getModRecord());
		additionalUserObjectDto.setViewRecord(additionalUserObject.getViewRecord());
		additionalUserObjectDto.setObjectId(additionalUserObject.getObjectsInSystem().getObjectId());
		additionalUserObjectDto.setObjectDescription(additionalUserObject.getObjectsInSystem().getObjectDescription());
		additionalUserObjectDto.setUserId(additionalUserObject.getUser().getUserId());
		additionalUserObjectDto.setUsername(additionalUserObject.getUser().getNameOfUser());
		return additionalUserObjectDto; 
	}

	@Override
	public List<AdditionalUserObject> uiDtoToDatabaseModelList(List<AdditionalUserObjectDTO> additionalUserObjDtoList) {
		List<AdditionalUserObject> additionalUserObjectList=new ArrayList<AdditionalUserObject>();
		for (AdditionalUserObjectDTO additionalUserObjectDto : additionalUserObjDtoList) {
			additionalUserObjectList.add(uiDtoToDatabaseModel(additionalUserObjectDto));
		}
		return additionalUserObjectList;
	}

	
}
