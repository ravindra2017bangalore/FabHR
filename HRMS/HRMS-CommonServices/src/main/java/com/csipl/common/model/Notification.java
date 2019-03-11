package com.csipl.common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long isMail;

	private String notificationText;

	private String notificationType;

	private Long sms;

	private Long ui;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Mail
	@ManyToOne
	@JoinColumn(name="mailId")
	private Mail mail;

	
	public Notification() {
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

	
	public String getNotificationText() {
		return this.notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public String getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	

	public Mail getMail() {
		return this.mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}


	public Long getNotificationId() {
		return notificationId;
	}


	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public Long getIsMail() {
		return isMail;
	}


	public void setIsMail(Long isMail) {
		this.isMail = isMail;
	}


	public Long getSms() {
		return sms;
	}


	public void setSms(Long sms) {
		this.sms = sms;
	}


	public Long getUi() {
		return ui;
	}


	public void setUi(Long ui) {
		this.ui = ui;
	}


	public Long getUserId() {
		return userId;
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