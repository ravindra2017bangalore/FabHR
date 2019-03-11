package com.csipl.common.util;

import java.io.ByteArrayInputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.csipl.common.model.Mail;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;






public class EmailUtils {

	
	 public void triggerEmail(ByteArrayInputStream bis, String email,Mail mail,JavaMailSender mailSender) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		System.out.println("To email is :"+ email);
		System.out.println("mail.getCc() "+mail.getCc()+"mail.getFromMail() : "+mail.getFromMail());
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getSubject());
			mimeMessageHelper.setTo(email);
			//mimeMessageHelper.setFrom("brajesh.dev.comp@gmail.com");
			mimeMessageHelper.setFrom(mail.getFromMail());
			mimeMessageHelper.setCc(mail.getCc());
		
			mimeMessageHelper.addAttachment(HrmsGlobalConstantUtil.QUATION_NAME,
					new ByteArrayResource(IOUtils.toByteArray(bis)));
			mailSender.send(mimeMessageHelper.getMimeMessage());
			System.out.println("mail send succesfully :"+ email);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	 
		

	 
	 
}
