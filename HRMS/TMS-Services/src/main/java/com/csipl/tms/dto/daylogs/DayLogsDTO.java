package com.csipl.tms.dto.daylogs;

public class DayLogsDTO {

	private String firstIn;
	private String lastOut;
	private String attendanceSource;
	private String attendance;
	private String shift;
	private String lateIn;

	public String getFirstIn() {
		return firstIn;
	}

	public void setFirstIn(String firstIn) {
		this.firstIn = firstIn;
	}

	public String getLastOut() {
		return lastOut;
	}

	public void setLastOut(String lastOut) {
		this.lastOut = lastOut;
	}

	public String getAttendanceSource() {
		return attendanceSource;
	}

	public void setAttendanceSource(String attendanceSource) {
		this.attendanceSource = attendanceSource;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getLateIn() {
		return lateIn;
	}

	public void setLateIn(String lateIn) {
		this.lateIn = lateIn;
	}

}
