package com.csipl.tms.model.holiday;

import java.io.Serializable;
import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;



/**
 * The persistent class for the Holidays database table.
 * 
 */
@Entity
@Table(name="TMSHolidays")
@NamedQuery(name="TMSHolidays.findAll", query="SELECT h FROM TMSHolidays h")
public class TMSHolidays implements Serializable {
	@Override
	public String toString() {
		return "TMSHolidays [holidayId=" + holidayId + ", createdDate=" + createdDate + ", day=" + day + ", fromDate="
				+ fromDate + ", holidayName=" + holidayName + ", isMandatory=" + isMandatory + ", toDate=" + toDate
				+ ", updateUserId=" + updateUserId + ", updatedDate=" + updatedDate + ", userId=" + userId + ", year="
				+ year + ", companyId=" + companyId + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
    @ApiModelProperty(notes = "The database generated holiday ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long holidayId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@ApiModelProperty(notes = "holiday day" ,required = true)
	private Long day;

	@ApiModelProperty(notes = "holiday start from date" ,required = true)
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@ApiModelProperty(notes = "holiday name" ,required = true)
	private String holidayName;

	private byte isMandatory;
	
	@ApiModelProperty(notes = "holiday end date" ,required = true)
	@Temporal(TemporalType.DATE)
	private Date toDate;

	private Long updateUserId;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private Long userId;

	private String year;
    private Long leavePeriodId;
	//bi-directional many-to-one association to Company
	/*@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;*/
    private String activeStatus;
	private Long companyId;
	
	public TMSHolidays() {
	}

	public Long getHolidayId() {
		return this.holidayId;
	}

	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getDay() {
		return this.day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public String getHolidayName() {
		return this.holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public byte getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(byte isMandatory) {
		this.isMandatory = isMandatory;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	/*public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

}