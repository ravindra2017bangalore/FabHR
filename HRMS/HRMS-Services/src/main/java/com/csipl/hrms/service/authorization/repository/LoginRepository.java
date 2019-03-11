package com.csipl.hrms.service.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.common.User;

public interface LoginRepository extends CrudRepository<User, Long> {

	public User save(User user);

	@Query(" from User ")
	public List<User> findAllUsers();

	@Query(" from User where nameOfUser=?1")
	public User findUser(String userId, String password);

	@Query(" from User where nameOfUser=?1 and changePassword=?2 ")
	public User findUserByChangePassword(String nameOfUser, String password);

	@Query(" from User where loginName=?1 ")
	public User findUserByUserName(String loginName);

	String setChangePwd = "Update Users set changePassword=?2 where userId=?1  ";

	@Query(value = setChangePwd, nativeQuery = true)
	public void setChangePassword(String userId, String userPassword);

	String setUpdatPwd = "update User u set u.userPassword = ?1,u.changePassword=?2 where u.changePassword = ?2 ";

	@Query(value = setUpdatPwd, nativeQuery = true)
	public Long updatePassword(String userPassword, String changePassword);

}
