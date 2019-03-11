package com.csipl.hrms.service.adaptor;

import java.util.List;
import com.csipl.hrms.dto.organisation.GuestUserDTO;
import com.csipl.hrms.model.common.GuestUser;


public class GuestUserAdaptor  implements Adaptor<GuestUserDTO, GuestUser>{
	
	@Override
	public GuestUser uiDtoToDatabaseModel(GuestUserDTO guestUserDto) {
		
		GuestUser guestUser=new GuestUser();
		guestUser.setGuestId(guestUserDto.getGuestId());
		guestUser.setName(guestUserDto.getName());
		guestUser.setEmail(guestUserDto.getEmail());
		guestUser.setCompany(guestUserDto.getCompany());
		guestUser.setMobile(guestUserDto.getMobile());
		guestUser.setDescription(guestUserDto.getDescription());
		
		return guestUser;
	}

	@Override
	public List<GuestUser> uiDtoToDatabaseModelList(List<GuestUserDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestUserDTO> databaseModelToUiDtoList(List<GuestUser> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestUserDTO databaseModelToUiDto(GuestUser dbobj) {
		// TODO Auto-generated method stub
		return null;
	}


}
