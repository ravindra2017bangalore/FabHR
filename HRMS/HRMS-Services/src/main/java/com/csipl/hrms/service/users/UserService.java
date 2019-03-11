package com.csipl.hrms.service.users;

import java.util.List;

import com.csipl.hrms.model.common.User;



public interface UserService{
	
    public List<User> findAllUsers();
	
    public User findUser(String userId, String password);

    public User findUser(String nameOfUser);
	
	public Long findUserRoles(Long employeeId);
	
  	public void userAttemptsUpdate(Long userAttempts, String nameOfUser);

	public User save(User userBean);
	
	
}
