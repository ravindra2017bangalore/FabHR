package com.csipl.hrms.service.authorization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.csipl.hrms.model.common.GuestUser;
 import com.csipl.hrms.service.authorization.repository.GuestUserRepository;
 
@Service("guestUserService")
public class GuestUserServiceImpl implements GuestUserService {
 	@Autowired
	  private GuestUserRepository guestUserRepository;
	
/*	@Override
	public List<GuestUser> getAllGuestUsers() {
 		return guestUserRepository.findAllGuestUsers();
 	}*/

	@Override
	public GuestUser save(GuestUser guestUser) {
  		return guestUserRepository.save(guestUser);
	}
 	
}
