package com.csipl.common.message.utils;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.model.Notification;

public class Message {
	 private MessageType messageType;

	   public Message(MessageType messageType){
	      this.messageType = messageType;
	   }

	   public Notification executeMessage(Notification notification ,JavaMailSender mailSender){
	      return messageType.sendMessage(notification,mailSender);
	   }
	  
	   public NotificationMailSmsDto executeMessage(NotificationMailSmsDto notification ,JavaMailSender mailSender,VelocityEngine velocityEngine){
		      return messageType.sendMessage(notification,mailSender,velocityEngine);
		   }
}
