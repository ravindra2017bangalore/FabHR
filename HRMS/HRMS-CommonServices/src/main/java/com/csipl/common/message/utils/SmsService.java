package com.csipl.common.message.utils;

import com.csipl.common.model.Notification;

public interface SmsService {

	public String sendNotificationBySms(Notification notification, String mobileNumber);
	
}
