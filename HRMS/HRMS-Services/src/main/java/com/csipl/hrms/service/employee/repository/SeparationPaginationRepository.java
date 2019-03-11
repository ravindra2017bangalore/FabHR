package com.csipl.hrms.service.employee.repository;

import java.util.List;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;

public interface SeparationPaginationRepository{
	List<Object[]> getSeparationPaginationList(long companyId, EmployeeSearchDTO employeeSearchDto, boolean status );

 }
