package com.csipl.hrms.service.employee.repository;

import java.util.List;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;

public interface EmployeePagingAndFilterRepository{
	List<Object[]> findEmployeePagedAndFilterResult(long companyId, EmployeeSearchDTO employeeSearchDto );
}
