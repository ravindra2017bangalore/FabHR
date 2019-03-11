package com.csipl.common.dto.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csipl.hrms.common.util.AppUtils;

public class NotificationMailSmsDto {
	

	 private String notificationType;
	 private String from;
	 private Map mapAttribute = new HashMap();
	 private String tempLateName;
	 
	 private String MobileNo;
	 private List<String> to;
	 
	 private List<String> cc;
	 
	 private String subject;
	 
	 private String message;
	 
	 private boolean isHtml;
	 
	 private boolean isHtmlText;
	 
	 private boolean isSms;
	 
	 private boolean isUi;
	 
	 public NotificationMailSmsDto() {
	 this.to = new ArrayList<String>();
	 this.cc = new ArrayList<String>();
	 this.mapAttribute= new HashMap();
	 }
	 
	 public NotificationMailSmsDto(String from, String toList, String subject, String message) {
	 this();
	 this.from = from;
	 this.subject = subject;
	 this.message = message;
	 this.to.addAll(Arrays.asList(splitByComma(toList)));
	 }
	 
	 public NotificationMailSmsDto(String from, String toList, String ccList, String subject, String message) {
	 this();
	 this.from = from;
	 this.subject = subject;
	 this.message = message;
	 this.to.addAll(Arrays.asList(splitByComma(toList)));
	 this.cc.addAll(Arrays.asList(splitByComma(ccList)));
	 }
	 
	 
	        //getters and setters not mentioned for brevity
	 
	 private String[] splitByComma(String toMultiple) {
	 String[] toSplit = toMultiple.split(",");
	 return toSplit;
	 }
	 
	 public String getToAsList() {
	 return AppUtils.concatenate(this.to, ",");
	 }
	
	
	 public String getNotificationType() {
			return notificationType;
	}

	public void setNotificationType(String notificationType) {
			this.notificationType = notificationType;
	}

	public Map getMapAttribute() {
		return mapAttribute;
	}

	public void setMapAttribute(Map mapAttribute) {
		this.mapAttribute = mapAttribute;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}
	
	

	public boolean isHtmlText() {
		return isHtmlText;
	}

	public void setHtmlText(boolean isHtmlText) {
		this.isHtmlText = isHtmlText;
	}

	public boolean isSms() {
		return isSms;
	}

	public void setSms(boolean isSms) {
		this.isSms = isSms;
	}

	public boolean isUi() {
		return isUi;
	}

	public void setUi(boolean isUi) {
		this.isUi = isUi;
	}

	public String getTempLateName() {
		return tempLateName;
	}

	public void setTempLateName(String tempLateName) {
		this.tempLateName = tempLateName;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
