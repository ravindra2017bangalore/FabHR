package com.csipl.tms.attendancelog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.tms.attendancelog.repository.AttendanceLogPagingAndFilterRepository;
import com.csipl.tms.dto.attendancelog.AttendanceLogSearchDTO;
import com.csipl.tms.dto.common.EntityCountDTO;

@Service
public class AttendanceLogPagingAndFilterServiceImpl implements AttendanceLogPagingAndFilterService {

	@Autowired
	AttendanceLogPagingAndFilterRepository attendanceLogPagingAndFilterRepository;
	
	@Override
	public void getAttendanceLogCount(EntityCountDTO entityCountDto,
			AttendanceLogSearchDTO attendanceLogSearchDto,String attendanceDate) {
		entityCountDto.setCount(attendanceLogPagingAndFilterRepository.getAttendanceLogCount(attendanceLogSearchDto,attendanceDate));
	}

	@Override
	public List<Object[]> getAttendanceLogByPagingAndFilter(AttendanceLogSearchDTO attendanceLogSearchDto, String attendanceDate) {
		return attendanceLogPagingAndFilterRepository.getAttendanceLogByPagingAndFilter(attendanceLogSearchDto,attendanceDate);
	}

	@Override
	public List<Object[]> attendanceReport(Long companyId, Date attendanceDate) {
 		return attendanceLogPagingAndFilterRepository.attendanceReport(companyId, attendanceDate);
	}

 
}
