package com.csipl.hrms.service.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.employee.EmployeeEducation;
 public interface EmployeeEducationService {
 	  public List<EmployeeEducation> save(List<EmployeeEducation> employeeEducationList,HttpServletRequest request);
	  public List<EmployeeEducation> findAllEduInformation(Long empId);
	  public void delete(Long eduId);
	public List<EmployeeEducation> saveEducation(List<EmployeeEducation> employeeEducationList); 
 }
