package com.csipl.tms.attendancelog.repository;

import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.attendancelog.AttendanceLogSearchDTO;

public interface AttendanceLogPagingAndFilterRepository {

	int getAttendanceLogCount(AttendanceLogSearchDTO attendanceLogSearchDto,String attendanceDate);

	List<Object[]> getAttendanceLogByPagingAndFilter(AttendanceLogSearchDTO attendanceLogSearchDto,String attendanceDate);

 
	List<Object[]> attendanceReport(Long companyId, Date attendanceDate);

 
}
