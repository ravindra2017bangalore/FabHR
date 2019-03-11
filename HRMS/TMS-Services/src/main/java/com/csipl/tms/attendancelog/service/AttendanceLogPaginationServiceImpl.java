package com.csipl.tms.attendancelog.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.attendancelog.repository.AttendanceLogPaginationRepository;
import com.csipl.tms.dto.common.EntityCountDTO;

@Transactional
@Service("attendanceLogPaginationService")
public class AttendanceLogPaginationServiceImpl implements AttendanceLogPaginationService {
	@Autowired
	private AttendanceLogPaginationRepository attendanceLogPaginationRepository;

//	@Autowired
//	private EmployeePersonalInformationService employeePersonalInformationService;

	@Override
	public List<Object[]> getAttendanceLogForMarkAttendance(EmployeeSearchDTO employeeSearcDto,  String strAttendanceDate) {
		String status = "AC";
		return attendanceLogPaginationRepository.getAttendanceLogPaginationList(employeeSearcDto.getCompanyId(),
				employeeSearcDto, strAttendanceDate, status);
	}

	 
}
