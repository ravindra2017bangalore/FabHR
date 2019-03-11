package com.csipl.hrms.service.authorization;


import java.util.List;

import com.csipl.hrms.model.common.GuestUser;


public interface GuestUserService {
	
//	public List<GuestUser> getAllGuestUsers();
	public GuestUser  save( GuestUser guestUser);
	
}
