package com.csipl.hrms.service.authorization;



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

import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.service.authorization.repository.LoginRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;

	static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		
		User user = loginRepository.findUserByUserName(userName);

		if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", userName));
        }
		
		 List<GrantedAuthority> authorities = new ArrayList<>();
		 
		 List<UserRole> userRoles = user.getUserRoles();
		 
		 userRoles.forEach(userRole -> {
			String role =  userRole.getRoleMaster().getRoleDescription();
			authorities.add(new SimpleGrantedAuthority( role ));
			
		 });
		 
		
		 UserDetails userDetails = new org.springframework.security.core.userdetails.
	                User(user.getNameOfUser(), user.getUserPassword(), authorities);
		 
	
		 
		return userDetails;
	}
	
	

}
