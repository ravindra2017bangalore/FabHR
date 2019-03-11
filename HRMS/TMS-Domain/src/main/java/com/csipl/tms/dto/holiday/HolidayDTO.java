package com.csipl.tms.dto.holiday;

import java.math.BigDecimal;
import java.util.Date;

public class HolidayDTO {
	private Long holidayId;
	private Date createdDate;
	private Long day;
	private Date fromDate;
	private Date toDate;
	private String holidayName;
	private byte isMandatory;
	private Long userId;
	private Long companyId;
	private String year;
	private String daysName;
	private String isMandatoryValue;
	private Long updateUserId;
	private BigDecimal count;
    private Long leavePeriodId;
    private String activeStatus;

	public BigDecimal getCount() {
		return count;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Long getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getDay() {
		return day;
	}
	public void setDay(Long day) {
		this.day = day;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public byte getIsMandatory() {
		return isMandatory;
	}
	public void setIsMandatory(byte isMandatory) {
		this.isMandatory = isMandatory;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsMandatoryValue() {
		return isMandatoryValue;
	}
	public void setIsMandatoryValue(String isMandatoryValue) {
		this.isMandatoryValue = isMandatoryValue;
	}
	public String getDaysName() {
		return daysName;
	}
	public void setDaysName(String daysName) {
		this.daysName = daysName;
	}
	public Long getLeavePeriodId() {
		return leavePeriodId;
	}
	public void setLeavePeriodId(Long leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
