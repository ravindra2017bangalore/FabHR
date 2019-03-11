package com.csipl.hrms.service.employee;

import java.util.List;

 import com.csipl.hrms.model.employee.EmployeeFamily;
 
public interface FamilyService {
	public List<EmployeeFamily>  saveAll(List<EmployeeFamily> employeeFamilyList);
 	public List<EmployeeFamily> findAllEmployeeDetails(String empId);
 	  public EmployeeFamily  findFamily(Long familyId);
	  public void delete(Long familyId);

}
