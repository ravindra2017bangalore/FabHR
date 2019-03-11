package com.csipl.tms.model.tmsempshift;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.tms.model.shift.Shift;

import java.util.Date;


/**
 * The persistent class for the TMSEmpShift database table.
 * 
 */
@Entity
@Table(name = "TMSEmpShift")
@NamedQuery(name="TMSEmpShift.findAll", query="SELECT t FROM TMSEmpShift t")
public class TMSEmpShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empShiftId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long employeeId;

	@ManyToOne
	@JoinColumn(name = "shiftId")
	private Shift shift;

	private Long userId;

	private Long userIdUpdate;

	public TMSEmpShift() {
	}

	public Long getEmpShiftId() {
		return this.empShiftId;
	}

	public void setEmpShiftId(Long empShiftId) {
		this.empShiftId = empShiftId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	@Override
	public String toString() {
		return "TMSEmpShift [empShiftId=" + empShiftId + ", activeStatus=" + activeStatus + ", companyId=" + companyId
				+ ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate + ", employeeId=" + employeeId
				+ ", shift=" + shift + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate + "]";
	}

	

}