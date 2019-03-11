package com.csipl.hrms.service.authorization;

import java.util.List;
import java.util.Set;

import com.csipl.hrms.model.common.User;

public interface LoginService {

	public void create(User user);

	public List<User> getAllUsers();

	public User findUser(String userId, String password);

	public Set<String> findPermissions(String userName);

	public void setChangePassword(String userId,String userPassword);
	
	public User findUserByUserName(String usrName ,String userPassword);
	
	public Long updatePassword(String newPass ,String changePass);
	
	public User findUserByUserName(String userName);
}
