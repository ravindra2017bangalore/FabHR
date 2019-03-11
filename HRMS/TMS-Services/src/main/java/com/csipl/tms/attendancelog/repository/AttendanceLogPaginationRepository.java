package com.csipl.tms.attendancelog.repository;

 import java.util.List;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;

public interface AttendanceLogPaginationRepository {
 
	List<Object[]> getAttendanceLogPaginationList(Long companyId, EmployeeSearchDTO employeeSearcDto,
			String strAttendanceDate, String activeStatus);

}
