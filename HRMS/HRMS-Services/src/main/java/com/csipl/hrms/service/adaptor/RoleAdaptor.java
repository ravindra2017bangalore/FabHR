package com.csipl.hrms.service.adaptor;

 

import com.csipl.hrms.dto.organisation.RoleMasterDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;

import java.util.ArrayList;
import java.util.List;

 

public class RoleAdaptor implements Adaptor<RoleMasterDTO, RoleMaster> {

	@Override
	public List<RoleMaster> uiDtoToDatabaseModelList(List<RoleMasterDTO> uiobj) {
 		return null;
	}
 	@Override
	public List<RoleMasterDTO> databaseModelToUiDtoList(List<RoleMaster> roleMasterList) {
		List<RoleMasterDTO> roleMasterDtoList=new ArrayList<RoleMasterDTO>();
		for (RoleMaster roleMaster : roleMasterList) {
			roleMasterDtoList.add(databaseModelToUiDto(roleMaster));
		}
		return roleMasterDtoList;
	}
 	@Override
	public RoleMaster uiDtoToDatabaseModel(RoleMasterDTO uiobj) {
 		return null;
	}

	@Override
	public RoleMasterDTO databaseModelToUiDto(RoleMaster roleMaster) {
		RoleMasterDTO roleMasterDto=new RoleMasterDTO();
		roleMasterDto.setRoleId(roleMaster.getRoleId());
		 roleMasterDto.setRoleDescription(roleMaster.getRoleDescription());
		return roleMasterDto;
	}
}
