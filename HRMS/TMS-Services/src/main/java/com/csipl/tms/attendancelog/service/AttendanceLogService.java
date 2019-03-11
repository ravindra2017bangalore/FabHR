package com.csipl.tms.attendancelog.service;

import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.attendancelog.AttendanceLogDetailsDTO;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.model.attendancelog.AttendanceLog;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.leave.TMSLeaveEntry;

public interface AttendanceLogService {

	void savePunchTimeLog(List<AttendanceLog> attendanceLogList);

	public List<Object[]> getAttendance(Long companyId, Long employeeId, String fromDate, String toDate);

	public List<AttendanceLog> getAttendanceLogDetails(Long companyId, String date);

	public List<AttendanceLogDetailsDTO> getAttendanceLogDetailsDTOList(List<AttendanceLog> attendanceLogDetailsList,
			List<EmpCommonDetail> empCommonDetailList, HalfDayRule halfDayRule, List<TMSLeaveEntry> leaveList,
			List<HolidayDTO> holidayDtoList, Date date);

	List<AttendanceLog> markBulkAttendance(List<AttendanceLog> attendanceLogList);
}
