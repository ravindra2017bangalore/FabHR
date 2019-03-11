package com.csipl.hrms.service.employee.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.User;
     
public interface UserRepository extends CrudRepository<User, Long>{
	
	String Query="select u.userId from  Users u JOIN Employee emp on emp.employeeCode=u.nameOfUser where emp.employeeId=?1";

	
  	@Query("from User ") 
 	public List<User> findAllUsers();
  	
  	@Query("from User where nameOfUser=?1") 
 	public  User  findUser(String nameOfUser);
  	
  	@Query(" from User where nameOfUser=?1 and userPassword=?2 ")
    public User findUser(String userId, String password);
  	
  	@Query(value=Query,nativeQuery=true)
	public Long findUserRoles(Long employeeId);
	
	@Modifying
  	@Query("update User u set u.userAttempts = ?1 where u.nameOfUser = ?2")
  	public void userAttemptsUpdate(Long userAttempts, String nameOfUser);
  	
  	
  }

