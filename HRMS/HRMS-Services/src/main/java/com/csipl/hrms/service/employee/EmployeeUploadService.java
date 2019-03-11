package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.MasterBook;

public interface EmployeeUploadService {
  	public void saveAll(List<Employee> employeeList,List<User> userList,MasterBook masterBook,List<UserRole> userRoleList);
   	public MasterBook findMasterBook(String bookCode,Long companyId,String bookType);

 
 }
 