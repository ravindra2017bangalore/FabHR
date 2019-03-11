package com.csipl.common.dto.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.csipl.common.model.Mail;

public class NotificationDTO {

	private Long notificationId;

	private String communicationType;

	private Long companyId;

	private Long createdBy;

	private Date createdDate;

	private String notificationText;

	private String notificationType;

	private Long mail;

	private Long ui;

	private Long sms;

	private Long updatedBy;

	private Mail mailObj;

	private Long userId;

	private String mailValue;

	private String uiValue;

	private String smsValue;

	private Date updatedDate;
	private String[] messageValues;

	private String notificationTypeValue;

	private String notificationValue1;
	private String notificationValue2;
	
	private String mobileNo;

	ArrayList<HashMap<String, String>> arrayMap;
	
 	

	public NotificationDTO() {
	}

	public Long getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getCommunicationType() {
		return this.communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getMail() {
		return mail;
	}

	public void setMail(Long mail) {
		this.mail = mail;
	}

	public Long getUi() {
		return ui;
	}

	public void setUi(Long ui) {
		this.ui = ui;
	}

	public Long getSms() {
		return sms;
	}

	public void setSms(Long sms) {
		this.sms = sms;
	}

	public ArrayList<HashMap<String, String>> getArrayMap() {
		return arrayMap;
	}

	public void setArrayMap(ArrayList<HashMap<String, String>> arrayMap) {
		this.arrayMap = arrayMap;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Mail getMailObj() {
		return mailObj;
	}

	public void setMailObj(Mail mailObj) {
		this.mailObj = mailObj;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMailValue() {
		return mailValue;
	}

	public void setMailValue(String mailValue) {
		this.mailValue = mailValue;
	}

	public String getUiValue() {
		return uiValue;
	}

	public void setUiValue(String uiValue) {
		this.uiValue = uiValue;
	}

	public String getSmsValue() {
		return smsValue;
	}

	public void setSmsValue(String smsValue) {
		this.smsValue = smsValue;
	}

	public String getNotificationTypeValue() {
		return notificationTypeValue;
	}

	public void setNotificationTypeValue(String notificationTypeValue) {
		this.notificationTypeValue = notificationTypeValue;
	}

	public String[] getMessageValues() {
		return messageValues;
	}

	public void setMessageValues(String[] messageValues) {
		this.messageValues = messageValues;
	}

	public String getNotificationValue1() {
		return notificationValue1;
	}

	public void setNotificationValue1(String notificationValue1) {
		this.notificationValue1 = notificationValue1;
	}

	public String getNotificationValue2() {
		return notificationValue2;
	}

	public void setNotificationValue2(String notificationValue2) {
		this.notificationValue2 = notificationValue2;
	}

}
