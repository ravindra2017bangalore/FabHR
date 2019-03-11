package com.csipl.tms.model.shift;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TMSShift database table.
 * 
 */
@Entity
@Table(name = "TMSShift")
@NamedQuery(name="Shift.findAll", query="SELECT t FROM Shift t")
public class Shift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shiftId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private String endPeriod;

	private String endTime;

	private String fromTime;

	private Long graceFrqInMonth;

	private String graceTime;

	private String shiftDuration;

	private String shiftFName;

	private String startPeriod;

	private String startTime;

	private String toTime;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private Long updateUserId;

	private Long userId;

	public Shift() {
	}

	public Long getShiftId() {
		return this.shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
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

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndPeriod() {
		return this.endPeriod;
	}

	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFromTime() {
		return this.fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public Long getGraceFrqInMonth() {
		return this.graceFrqInMonth;
	}

	public void setGraceFrqInMonth(Long graceFrqInMonth) {
		this.graceFrqInMonth = graceFrqInMonth;
	}

	public String getGraceTime() {
		return this.graceTime;
	}

	public void setGraceTime(String graceTime) {
		this.graceTime = graceTime;
	}

	public String getShiftDuration() {
		return this.shiftDuration;
	}

	public void setShiftDuration(String shiftDuration) {
		this.shiftDuration = shiftDuration;
	}

	public String getShiftFName() {
		return this.shiftFName;
	}

	public void setShiftFName(String shiftFName) {
		this.shiftFName = shiftFName;
	}

	public String getStartPeriod() {
		return this.startPeriod;
	}

	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getToTime() {
		return this.toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}