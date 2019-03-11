package com.csipl.common.message.utils;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.model.Notification;

public class SendSms implements MessageType {

	@Override
	public Notification sendMessage(Notification notification, JavaMailSender mailSender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationMailSmsDto sendMessage(NotificationMailSmsDto notification, JavaMailSender mailSender,
			VelocityEngine velocityEngine) {
		// TODO Auto-generated method stub
		return null;
	}

}
