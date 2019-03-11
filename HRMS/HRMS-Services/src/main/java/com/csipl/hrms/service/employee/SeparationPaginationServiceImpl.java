package com.csipl.hrms.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.service.employee.repository.SeparationPaginationRepository;
import com.csipl.hrms.service.employee.repository.SeparationRepository;
 
@Service
public class SeparationPaginationServiceImpl implements SeparationPaginationService {

	@Autowired
	public SeparationPaginationRepository separationPaginationRepository;
	
	@Autowired
	private SeparationRepository separationRepository;
 
 	@Override
	public List<Object[]> getSeparationPaginationList(Long companyId, EmployeeSearchDTO employeeSearcDto,boolean status) {
 		return separationPaginationRepository.getSeparationPaginationList(companyId, employeeSearcDto,status);
 	}

	@Override
	public void getSeparationCount(Long companyId, boolean status, EmployeeCountDTO searchDto) {
		String strStatus="P";
		if(status)
	 		searchDto.setCount(separationRepository.getExcludedPendingSeparationCount(companyId,strStatus));
 		else
 	 		searchDto.setCount(separationRepository.getPendingSeparationCount(companyId,strStatus));

	}
 

}
