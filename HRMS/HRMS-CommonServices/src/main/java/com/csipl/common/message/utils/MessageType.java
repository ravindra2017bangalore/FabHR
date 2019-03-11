package com.csipl.common.message.utils;


import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.model.Notification;

public interface MessageType {
	
	public Notification sendMessage(Notification notification ,JavaMailSender mailSender);
	public NotificationMailSmsDto sendMessage(NotificationMailSmsDto notification ,JavaMailSender mailSender ,VelocityEngine velocityEngine);
}
