package com.csipl.hrms.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.model.common.User;
import com.csipl.hrms.service.employee.repository.UserRepository;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {

		return userRepository.findAllUsers();
	}

	@Override
	public User findUser(String userId, String password) {

		return userRepository.findUser(userId, password);
	}

	@Override
	public User findUser(String nameOfUser) {

		return userRepository.findUser(nameOfUser);
	}

	@Override
	public Long findUserRoles(Long employeeId) {

		return userRepository.findUserRoles(employeeId);
	}

	@Override
	public void userAttemptsUpdate(Long userAttempts, String nameOfUser) {

		 userRepository.userAttemptsUpdate(userAttempts, nameOfUser);
	}

	@Override
	public User save(User userBean) {
 		return userRepository.save(userBean);
	}

}
