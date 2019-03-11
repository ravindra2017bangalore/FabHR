package com.csipl.hrms.service.adaptor;


import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.authorization.RoleMasterDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;


public class RoleMasterAdaptor implements Adaptor<RoleMasterDTO, RoleMaster> {

	@Override
	public List<RoleMaster> uiDtoToDatabaseModelList(List<RoleMasterDTO> roleMasterDtoList) {
		List<RoleMaster> roleMaster=new ArrayList<RoleMaster>();
		for(RoleMasterDTO roleMasterDto:roleMasterDtoList) {
		
			roleMaster.add(uiDtoToDatabaseModel(roleMasterDto));
		}
		return roleMaster;
	}

	@Override
	public List<RoleMasterDTO> databaseModelToUiDtoList(List<RoleMaster> roleMasterList) {
		List<RoleMasterDTO> roleMasterDtoList=new ArrayList<RoleMasterDTO>();
		for(RoleMaster roleMaster:roleMasterList) {
		
			roleMasterDtoList.add(databaseModelToUiDto(roleMaster));
		}
		return roleMasterDtoList;	}

	@Override
	public RoleMaster uiDtoToDatabaseModel(RoleMasterDTO roleMasterDTO) {
		
		RoleMaster roleMaster=new RoleMaster();
		
		roleMaster.setRoleId(roleMasterDTO.getRoleId());
		roleMaster.setRoleDescription(roleMasterDTO.getRoleDescription());
		
		return roleMaster;
	}

	@Override
	public RoleMasterDTO databaseModelToUiDto(RoleMaster roleMaster) {
		RoleMasterDTO roleMasterDto=new RoleMasterDTO();
		roleMasterDto.setRoleId(roleMaster.getRoleId());
		roleMasterDto.setRoleDescription(roleMaster.getRoleDescription());
		
		return roleMasterDto;
	}

}
