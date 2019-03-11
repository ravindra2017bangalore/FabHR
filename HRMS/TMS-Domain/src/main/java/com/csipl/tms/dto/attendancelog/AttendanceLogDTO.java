package com.csipl.tms.dto.attendancelog;

import java.util.Date;

import com.csipl.tms.dto.common.SearchDTO;

public class AttendanceLogDTO extends SearchDTO implements Comparable<AttendanceLogDTO> {

	private Long attendanceLogId;
	private Date attendanceDate;
	private Long createdBy;
	private Date createdDate;
	private Long inDeviceId;

	private String inTime;
	private Long outDeviceId;
	private String outTime;
	private Long updatedBy;
	private Date updatedDate;
	private Long companyId;
	private Long employeeId;
	private String employeeCode;
	private String location;
	private String mode;

	private Long maxSno;
	private Long minSno;
	private String firstName;
	private String lastName;
	private String status;
	private String delayedTime;
	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	private String statusValue;


	public Long getAttendanceLogId() {
		return attendanceLogId;
	}

	public void setAttendanceLogId(Long attendanceLogId) {
		this.attendanceLogId = attendanceLogId;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getInDeviceId() {
		return inDeviceId;
	}

	public void setInDeviceId(Long inDeviceId) {
		this.inDeviceId = inDeviceId;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public Long getOutDeviceId() {
		return outDeviceId;
	}

	public void setOutDeviceId(Long outDeviceId) {
		this.outDeviceId = outDeviceId;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getMaxSno() {
		return maxSno;
	}

	public void setMaxSno(Long maxSno) {
		this.maxSno = maxSno;
	}

	public Long getMinSno() {
		return minSno;
	}

	public void setMinSno(Long minSno) {
		this.minSno = minSno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeCode == null) ? 0 : employeeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendanceLogDTO other = (AttendanceLogDTO) obj;
		if (employeeCode == null) {
			if (other.employeeCode != null)
				return false;
		} else if (!employeeCode.equals(other.employeeCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(AttendanceLogDTO attendanceLogDto) {
		// TODO Auto-generated method stub
		return this.employeeCode.compareTo(attendanceLogDto.employeeCode);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AttendanceLogDTO [attendanceLogId=" + attendanceLogId + ", attendanceDate=" + attendanceDate
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", inDeviceId=" + inDeviceId
				+ ", inTime=" + inTime + ", outDeviceId=" + outDeviceId + ", outTime=" + outTime + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", companyId=" + companyId + ", employeeId=" + employeeId
				+ ", employeeCode=" + employeeCode + ", location=" + location + ", mode=" + mode + ", maxSno=" + maxSno
				+ ", minSno=" + minSno + ", firstName=" + firstName + ", lastName=" + lastName + ", status=" + status
				+ "]";
	}

	public String getDelayedTime() {
		return delayedTime;
	}

	public void setDelayedTime(String delayedTime) {
		this.delayedTime = delayedTime;
	}
 

 
}
