package com.csipl.tms.dto.attendancelog;

import java.util.Date;

import com.csipl.tms.dto.common.SearchDTO;


public class AttendanceLogSearchDTO extends SearchDTO {

	private String employeeName;
	private Long departmentId;
	private Long designationId;
	private String employeeCode;
	private String status;
	private Long companyId;
	private String attendanceTitle;
	
	public String getAttendanceTitle() {
		return attendanceTitle;
	}
	public void setAttendanceTitle(String attendanceTitle) {
		this.attendanceTitle = attendanceTitle;
	}
	private Date attendanceDate;
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
