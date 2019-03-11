package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;

public interface SeparationPaginationService {
 	public List<Object[]> getSeparationPaginationList(Long companyId, EmployeeSearchDTO employeeSearcDto, boolean status);
 	public void getSeparationCount(Long companyId, boolean status, EmployeeCountDTO employeeCountDto);
	
}
