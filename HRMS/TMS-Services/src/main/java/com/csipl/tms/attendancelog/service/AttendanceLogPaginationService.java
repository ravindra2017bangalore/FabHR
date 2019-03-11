package com.csipl.tms.attendancelog.service;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.tms.dto.common.EntityCountDTO;

public interface AttendanceLogPaginationService {

	public List<Object[]> getAttendanceLogForMarkAttendance(EmployeeSearchDTO employeeSearcDto, String strAttendanceDate);

 
}
