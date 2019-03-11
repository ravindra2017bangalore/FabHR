package com.csipl.tms.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.leave.repository.EmployeeLeavePaginationRepository;
import com.csipl.tms.leave.repository.LeaveEntryRepository;
import com.csipl.tms.model.leave.LeaveSearchDTO;

@Service
public class EmployeeLeavePaginationServiceImpl  implements EmployeeLeavePaginationService{
	@Autowired
	LeaveEntryRepository leaveEntryRepository;
	@Autowired
	EmployeeLeavePaginationRepository employeeLeavePaginationRepository;
	@Override
	public void getEntityCount(long companyId, EntityCountDTO entityCountDto) {
	
		entityCountDto.setCount(leaveEntryRepository.entitySearch(companyId));
		
	}
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getPendingEmployeeLeavebyPagination(long companyId, LeaveSearchDTO leaveSearchDto) {
		// TODO Auto-generated method stub
		return employeeLeavePaginationRepository.getPendingEmployeeLeavebyPagination(companyId, leaveSearchDto);
	}
	@Override
	public void getPendingEntityCount(long companyId, EntityCountDTO entityCountDto) {
		entityCountDto.setCount(leaveEntryRepository.pendingEntitySearch(companyId));
		
	}

}
