package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeStatuary;

public interface EmpOfficialService {
	public void saveOfficialInfo (Employee employee, List<EmployeeStatuary> statutoryList);
}
