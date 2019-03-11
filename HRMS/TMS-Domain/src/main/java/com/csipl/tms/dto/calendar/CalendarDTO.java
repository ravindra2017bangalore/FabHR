package com.csipl.tms.dto.calendar;

import java.util.List;

import com.csipl.tms.dto.daysattendancelog.DaysAttendanceLogDTO;

public class CalendarDTO {

	private List<DaysAttendanceLogDTO> events;

	public List<DaysAttendanceLogDTO> getEvents() {
		return events;
	}

	public void setEvents(List<DaysAttendanceLogDTO> events) {
		this.events = events;
	}

	

}
