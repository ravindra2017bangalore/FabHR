package com.csipl.tms.dto.tmsempshift;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csipl.tms.model.shift.Shift;

public class TMSEmpShiftDTO {

	private Long empShiftId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long employeeId;

	private Shift shiftId;

	private Long userId;

	private Long userIdUpdate;

	public Long getEmpShiftId() {
		return empShiftId;
	}

	public void setEmpShiftId(Long empShiftId) {
		this.empShiftId = empShiftId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	

	public Long getUserId() {
		return userId;
	}

	public Shift getShiftId() {
		return shiftId;
	}

	public void setShiftId(Shift shiftId) {
		this.shiftId = shiftId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
}
