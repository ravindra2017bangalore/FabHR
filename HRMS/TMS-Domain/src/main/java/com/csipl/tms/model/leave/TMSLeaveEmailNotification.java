package com.csipl.tms.model.leave;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TMSLeaveEmailNotification database table.
 * 
 */
@Entity
@NamedQuery(name="TMSLeaveEmailNotification.findAll", query="SELECT t FROM TMSLeaveEmailNotification t")
public class TMSLeaveEmailNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tmsLeaveEmailNotificationId;

	private String emailId;

	private Long employeeId;

	private Long mobileNo;

	//bi-directional many-to-one association to TMSLeaveEntry
	@ManyToOne
	@JoinColumn(name="leaveEntryId")
	private TMSLeaveEntry tmsleaveEntry;

	public TMSLeaveEmailNotification() {
	}

	public Long getTmsLeaveEmailNotificationId() {
		return this.tmsLeaveEmailNotificationId;
	}

	public void setTmsLeaveEmailNotificationId(Long tmsLeaveEmailNotificationId) {
		this.tmsLeaveEmailNotificationId = tmsLeaveEmailNotificationId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public TMSLeaveEntry getTmsleaveEntry() {
		return this.tmsleaveEntry;
	}

	public void setTmsleaveEntry(TMSLeaveEntry tmsleaveEntry) {
		this.tmsleaveEntry = tmsleaveEntry;
	}

}