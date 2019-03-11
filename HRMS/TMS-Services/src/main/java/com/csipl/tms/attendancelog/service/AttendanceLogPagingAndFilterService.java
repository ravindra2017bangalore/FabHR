package com.csipl.tms.attendancelog.service;

import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.attendancelog.AttendanceLogSearchDTO;
import com.csipl.tms.dto.common.EntityCountDTO;

public interface AttendanceLogPagingAndFilterService {

	void getAttendanceLogCount(EntityCountDTO entityCountDto,
			AttendanceLogSearchDTO attendanceLogSearchDto,String attendanceDate);

	List<Object[]> getAttendanceLogByPagingAndFilter(AttendanceLogSearchDTO attendanceLogSearchDto, String attendanceDate);

	List<Object[]> attendanceReport(Long companyId, Date attendanceDate);

}
