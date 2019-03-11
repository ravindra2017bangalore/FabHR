package com.csipl.tms.security;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.csipl.hrms.common.model.User;



@Service("tmsUserDetailServiceImpl")
public class TMSUserDetailServiceImpl implements UserDetailsService {
	
	

	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		
		
		/* User user = new User();
		user.setNameOfUser(userName); */
		
		 UserDetails userDetails = new org.springframework.security.core.userdetails.
	                User("admin", "12345", null);
		 
	
		 
		return userDetails;
	}
	
	

}
