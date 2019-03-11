
package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.common.User;

public class UserAdaptor implements Adaptor<UserDTO, User> {

	@Override
	public List<User> uiDtoToDatabaseModelList(List<UserDTO> uiobj) {
		List<User> user=new ArrayList<User>();
		for(UserDTO bonusDto:uiobj) {
		
			user.add(uiDtoToDatabaseModel(bonusDto));
		}
		return user;
	}

	@Override
	public List<UserDTO> databaseModelToUiDtoList(List<User> userList) {
		List<UserDTO> userDtoList=new ArrayList<UserDTO>();
		for (User user : userList) {
			userDtoList.add(databaseModelToUiDto(user));
		}
	 	return userDtoList;
	}

	@Override
	public User uiDtoToDatabaseModel(UserDTO uiobj) {
		
		User user=new User();
		user.setNameOfUser(uiobj.getUsername());
		user.setEmailOfUser(uiobj.getNameOfUser());
		user.setUserPassword(uiobj.getUserPassword());
		
		return user;
	}

	@Override
	public UserDTO databaseModelToUiDto(User user) {
		UserDTO userDto=new UserDTO();
		userDto.setUsername(user.getNameOfUser());
		userDto.setUserId(user.getUserId());
		return userDto;
	}

}
