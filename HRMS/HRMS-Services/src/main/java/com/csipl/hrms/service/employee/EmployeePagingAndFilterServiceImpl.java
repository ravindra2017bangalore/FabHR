package com.csipl.hrms.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.service.employee.repository.EmployeePagingAndFilterRepository;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;

@Service
public class EmployeePagingAndFilterServiceImpl implements EmployeePagingAndFilterService {

	@Autowired
	public EmployeePagingAndFilterRepository employeePagingAndFilterRepository;
	@Autowired
	public EmployeePersonalInformationRepository employeePersonalInformationRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getEmployeeByPagingAndFilter(long companyId, EmployeeSearchDTO employeeSearchDto) {

		return employeePagingAndFilterRepository.findEmployeePagedAndFilterResult(companyId, employeeSearchDto);
	}

	@Override
	public void getEmployeeCount(long companyId, EmployeeCountDTO searchDto) {
		searchDto.setCount(employeePersonalInformationRepository.employeeSearch(companyId));
	}

	@Override
	public void getEmployeeCountDE(long companyId, EmployeeCountDTO searchDto) {
		searchDto.setCount(employeePersonalInformationRepository.employeeSearchDE(companyId));
	}

	@Override
	public void getEmployeeSeparatingCount(long companyId, EmployeeCountDTO searchDto) {
		searchDto.setCount(employeePersonalInformationRepository.getEmployeeSeparatingCount(companyId));
	}

}
