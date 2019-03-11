package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.EmployeeStatuary;

public interface EmployeeStatuaryService {
 	  public List<EmployeeStatuary> save(List<EmployeeStatuary> employeeStatuaryList,Long empId);
	  public List<EmployeeStatuary> findAllEmployeeStatuary(Long empId);
	  public void delete(Long statuaryId); 
 }
