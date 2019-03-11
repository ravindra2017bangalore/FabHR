package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;

public interface EmployeePagingAndFilterService {
	public List<Object[]> getEmployeeByPagingAndFilter( long companyId, EmployeeSearchDTO employeeSearchDto );// , SearchDTO searchDto, );

	public void getEmployeeCount(long companyId, EmployeeCountDTO employeeCountDto);

	public void getEmployeeCountDE(long companyId, EmployeeCountDTO employeeCountDto);
	
	public void getEmployeeSeparatingCount(long companyId, EmployeeCountDTO employeeCountDto);
	
}
