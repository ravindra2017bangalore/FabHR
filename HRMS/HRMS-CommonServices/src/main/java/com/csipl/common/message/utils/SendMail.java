package com.csipl.common.message.utils;




import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;

import com.csipl.common.dto.notification.NotificationDTO;
import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.model.Notification;

public class SendMail implements MessageType{

	private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

	@Override
	public Notification sendMessage(Notification notification,JavaMailSender mailSender) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		//	logger.info("To email is :" + notification.getNotificationText());
			try {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setSubject(notification.getMail().getSubject());
				mimeMessageHelper.setTo(notification.getMail().getToMail());
				mimeMessageHelper.setFrom(notification.getMail().getFromMail());
				
				if(notification.getMail().getCc()!=null)
				mimeMessageHelper.setCc(notification.getMail().getCc());
				if(notification.getNotificationText()!=null){
 				mimeMessageHelper.setText(notification.getNotificationText());
 				}
				mailSender.send(mimeMessageHelper.getMimeMessage());
			//	logger.info("mail send succesfully :" + notification.getNotificationText());
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return notification;
	}

	@Override
	public NotificationMailSmsDto sendMessage(NotificationMailSmsDto notification, JavaMailSender mailSender,VelocityEngine velocityEngine) {
		// TODO Auto-generated method stub
		
		logger.info("in sendMessage Method ");
		if (notification.isHtml()) {
			 try {
			 sendHtmlMail(notification,mailSender,velocityEngine);
			 } catch (Exception e) {
				 logger.error("Could not send email to : {} Error = {}", notification.getToAsList(), e.getMessage());
			 }
			 } else {
			 try {		 
			 sendPlainTextMail(notification,mailSender,velocityEngine);
		 } catch (Exception e) {
			 	logger.error("Could not send email to : {} Error = {}", notification.getToAsList(), e.getMessage());
				 }
			 }
		  
			return notification;
	}

	private void sendPlainTextMail(NotificationMailSmsDto notification, JavaMailSender mailSender,VelocityEngine velocityEngine) {
		// TODO Auto-generated method stub
		logger.info("====================in sendPlainTextMail Method ===========================");
		
		System.out.println("notification.getTo()=========="+notification.getTo().size());
		System.out.println("notification.getTo().toArra"+notification.getTo().toArray(new String[notification.getTo().size()]));
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		notification.getTo().toArray(new String[notification.getTo().size()]);
		mailMessage.setTo(notification.getTo().toArray(new String[notification.getTo().size()]));
		mailMessage.setReplyTo(notification.getFrom());
		mailMessage.setFrom(notification.getFrom());
		mailMessage.setSubject(notification.getSubject());
		mailMessage.setText(notification.getMessage());

		if (notification.getCc().size() > 0) {
			mailMessage.setCc(notification.getCc().toArray(new String[notification.getCc().size()]));
		}

		mailSender.send(mailMessage); 
	}

	private void sendHtmlMail(NotificationMailSmsDto notification, JavaMailSender mailSender,VelocityEngine velocityEngine) {
		// TODO Auto-generated method stub
		logger.info("====================in sendHtmlMail Method ===========================");
		 boolean isHtml = true;
		 MimeMessage message = mailSender.createMimeMessage();
		 try {
		 MimeMessageHelper helper = new MimeMessageHelper(message);
		 helper.setTo(notification.getTo().toArray(new String[notification.getTo().size()]));
		 helper.setReplyTo(notification.getFrom());
		 helper.setFrom(notification.getFrom());
		 helper.setSubject(notification.getSubject());
		 String textMessage = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				 notification.getTempLateName(), "UTF-8", notification.getMapAttribute());
		 helper.setText(textMessage, isHtml);
		 if (notification.getCc().size() > 0) {
		 helper.setCc(notification.getCc().toArray(new String[notification.getCc().size()]));
		 }
		 mailSender.send(message);
		 } catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	
}

