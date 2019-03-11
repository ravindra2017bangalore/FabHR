package com.csipl.hrms.service.payroll;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AttendanceDTO {

	private String employeeCode;
	private String employeeName;

	private int presense;
	private int weekOff;
	private int publicholidays;
	private String processMonth;	
	private int paidLeave;
	private int casualLeave;
	private int seekleave;
	private int absense;
	private Long companyId;
	private Long userId;
	private Long employeeId;
	private Long departmentId;
	private Long payDays;
	public AttendanceDTO() {
	
	}
	
	public AttendanceDTO(String employeeCode, String employeeName, int presense, int weekOff, int publicholidays,
			int paidLeave, int casualLeave, int seekleave, int absense, Long companyId, 
			Long departmentId ,Long payDays) {
		
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.presense = presense;
		this.weekOff = weekOff;
		this.publicholidays = publicholidays;
		this.paidLeave = paidLeave;
		this.casualLeave = casualLeave;
		this.seekleave = seekleave;
		this.absense = absense;
		this.companyId = companyId;
	
		this.departmentId = departmentId;
		this.payDays=payDays;
	}
	
	public int getAbsense() {
		return absense;
	}
	public void setAbsense(int absense) {
		this.absense = absense;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public int getWeekOff() {
		return weekOff;
	}
	public void setWeekOff(int weekOff) {
		this.weekOff = weekOff;
	}
	
	public int getPaidLeave() {
		return paidLeave;
	}
	public void setPaidLeave(int paidLeave) {
		this.paidLeave = paidLeave;
	}
	public int getCasualLeave() {
		return casualLeave;
	}
	public void setCasualLeave(int casualLeave) {
		this.casualLeave = casualLeave;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getPresense() {
		return presense;
	}
	public void setPresense(int presense) {
		this.presense = presense;
	}
	public int getPublicholidays() {
		return publicholidays;
	}
	public void setPublicholidays(int publicholidays) {
		this.publicholidays = publicholidays;
	}
	public int getSeekleave() {
		return seekleave;
	}
	public void setSeekleave(int seekleave) {
		this.seekleave = seekleave;
	}

	
	
	 public Long getPayDays() {
		return payDays;
	}

	public void setPayDays(Long payDays) {
		this.payDays = payDays;
	}
	
	

	public String getProcessMonth() {
		return processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	@Override
     public String toString() {
        return new ToStringBuilder(this)
                .append("employeeCode", this.employeeCode)
                .append("employeeName", this.employeeName)
                .append("presense", this.presense)
                .append("weekOff", this.weekOff)
                .append("publicholidays", this.publicholidays)
                .append("paidLeave", this.paidLeave)
                .append("casualLeave", this.casualLeave)
                .append("seekleave", this.seekleave)
                .append("absense", this.absense)
                .append("seekleave", this.seekleave)
                .append("companyId", this.companyId)
                .append("employeeId", this.employeeId)
                .append("departmentId", this.departmentId)
                .toString();
    }
	
	
}
