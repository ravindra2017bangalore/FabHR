package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.authorization.UserRoleDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.User;

public class UserRoleAdaptor implements Adaptor<UserRoleDTO, UserRole> {

	@Override
	public List<UserRole> uiDtoToDatabaseModelList(List<UserRoleDTO> userRoleDtoList) {
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		for (UserRoleDTO userRoleDto : userRoleDtoList) {
			userRoleList.add(uiDtoToDatabaseModel(userRoleDto));
		}
		return userRoleList;
	}

	@Override
	public List<UserRoleDTO> databaseModelToUiDtoList(List<UserRole> userRoleList) {
		List<UserRoleDTO> userRoleListDto = new ArrayList<UserRoleDTO>();
		for (UserRole userRole : userRoleList) {
			userRoleListDto.add(databaseModelToUiDto(userRole));
		}
		return userRoleListDto;
	}

	@Override
	public UserRole uiDtoToDatabaseModel(UserRoleDTO userRoleDto) {
		UserRole userRole = new UserRole();
		RoleMaster roleMaster = new RoleMaster();
		User user = new User();
		user.setUserId(userRoleDto.getUserId());
		userRole.setUser(user);
		roleMaster.setRoleId(userRoleDto.getRoleId());
		userRole.setRoleMaster(roleMaster);
		userRole.setUserRolesSrNo(userRoleDto.getUserRolesSrNo());
		userRole.setSUserId(1l);// userRoleDto.getsUserId()
 		return userRole;
	}

	@Override
	public UserRoleDTO databaseModelToUiDto(UserRole userRole) {
		UserRoleDTO userRoleDto = new UserRoleDTO();
		userRoleDto.setRoleId(userRole.getRoleMaster().getRoleId());
		userRoleDto.setUserId(userRole.getUser().getUserId());
		userRoleDto.setUsername(userRole.getUser().getNameOfUser());
		userRoleDto.setRoleDescription(userRole.getRoleMaster().getRoleDescription());
		userRoleDto.setUserRolesSrNo(userRole.getUserRolesSrNo());
		userRoleDto.setsUserId(userRole.getSUserId());
		return userRoleDto;
	}
}
