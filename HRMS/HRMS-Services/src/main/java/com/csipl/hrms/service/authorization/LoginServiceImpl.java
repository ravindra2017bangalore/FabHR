package com.csipl.hrms.service.authorization;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.User;
import com.csipl.hrms.service.authorization.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public void create(User user) {
		System.out.println("service is calling");
		loginRepository.save(user);
		System.out.println("service is completed");
	}

	@Override
	public List<User> getAllUsers() {
		System.out.println("getAllUsers() in userServiceImpl");
		return loginRepository.findAllUsers();
	}

	@Override
	public User findUser(String userId, String password) {
		System.out.println("login service is calling");
		User user = loginRepository.findUser(userId, password);

		return user;
	}

	@Override
	public Set<String> findPermissions(String userName) {
		
		return null;
	}

	@Override
	public void setChangePassword(String userId, String userPassword) {
		
		loginRepository.setChangePassword(userId, userPassword);
	}

	@Override
	public User findUserByUserName(String userName, String userPass) {
		
		return loginRepository.findUserByChangePassword(userName, userPass);
	}

	@Override
	public Long updatePassword(String newPass, String changePass) {
		
		return loginRepository.updatePassword(newPass, changePass);
	}
	@Override
	public User findUserByUserName(String userName) {
		
		return loginRepository.findUserByUserName(userName);
	}

}
