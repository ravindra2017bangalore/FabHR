package com.csipl.tms.calendar.service;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.calendar.CalendarDTO;
import com.csipl.tms.dto.halfdayrule.HalfDayRuleDTO;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.dto.leave.LeaveEntryDTO;
import com.csipl.tms.model.shift.Shift;

public interface CalendarService {

	public CalendarDTO calendarLogs(Date empJoiningDateObj, Date fromDate, Date toDate,
			List<AttendanceLogDTO> attendanceLogDtoList, List<AttendanceRegularizationRequestDTO> arRequestDtoList,
			String[] weekOffPatternArray, List<HolidayDTO> holidayDtoList, Shift shiftNameObj,
			List<LeaveEntryDTO> leaveEntryDtoList, HalfDayRuleDTO halfDayRuleDto);

	/* public DayLogsDTO getDayLog(String date); */
}
