package com.csipl.hrms.landing;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.model.landing.ContactLanding;
import com.csipl.hrms.model.landing.ContactUs;

import org.apache.commons.lang3.StringUtils;

@RestController
public class LendingController {

	@Autowired
	JavaMailSender mailSender;
	
	/*@Autowired
	RecaptchaService captchaService;*/

	@RequestMapping(value = "/scheduleDemo", method = RequestMethod.POST)
	public  /*ResponseEntity<?>*/void  scheduleDemoRegistration(
			@RequestParam(name = "g-recaptcha-response") String recaptchaResponse, HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute("scheduleDemoForm") ContactLanding contact,
			Map<String, Object> model) throws IOException {
		System.out.println("Inside Landing controller");
		/*String ip = request.getRemoteAddr();
		System.out.println("Ip Address ===== : "+ip);
		System.out.println("---------------captchaService.verifyRecaptcha("+ip+","+recaptchaResponse);
		String captchaVerifyMessage = captchaService.verifyRecaptcha(ip, recaptchaResponse);
			System.out.println("captchaVerifyMessage-------"+captchaVerifyMessage);
		if (StringUtils.isNotEmpty(captchaVerifyMessage)) {
			Map<String, Object> response1 = new HashMap<>();
			response1.put("message", captchaVerifyMessage);
			 return ResponseEntity.badRequest()
			 .body(response);
		}
		System.out.println(contact.toString());*/
		System.out.println("----send Email-----");
		scheduleDemoTriggerEmail("pragya@computronics.in", contact);
		// return ResponseEntity.ok().build();

		/*
		 * scheduleDemoTriggerEmail("parihar.ravindrasingh@gmail.com",contact);
		 * response.sendRedirect("fabHR/fabHR/index.html");
		 */
		// return "RegistrationSuccess";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public void contactUsRegistration(HttpServletResponse response,
			@ModelAttribute("contactUsForm") ContactUs ContactUs, Map<String, Object> model) throws IOException {
		System.out.println(ContactUs.toString());
		System.out.println("Inside Landing controller");
		contactUsTriggerEmail("ravindra.singh@computronics.in", ContactUs);
		response.sendRedirect("fabHR/fabHR/contactUs.html");
		// return "RegistrationSuccess";
	}

	public void scheduleDemoTriggerEmail(String email, ContactLanding contact) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		System.out.println("Inside triggerEmail(===" + email);

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject("Landing information==");

			mimeMessageHelper.setTo(email);

			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);// HrmsGlobalConstantUtil.FROM_MAIL);
			System.out.println("==========1");
			// mimeMessageHelper.setCc(HrmsGlobalConstantUtil.MAIL_CC);

			mimeMessageHelper.setText("Hi  " + contact.getName() + "\r\n" +

					"\t\tYour FAB HR Schedule Demo is:\r\n" + "\r\n" + contact.getCompanyName()

			);
			System.out.println("==========6");
			mailSender.send(mimeMessageHelper.getMimeMessage());
			System.out.println("mail send succesfully :" + email);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contactUsTriggerEmail(String email, ContactUs contactUs) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		System.out.println("Inside triggerEmail(===" + email);

		try {
			System.out.println("==========1");
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			
			mimeMessageHelper.setSubject("Landing information==");
			
			mimeMessageHelper.setTo(email);
			
			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);// HrmsGlobalConstantUtil.FROM_MAIL);
			
			// mimeMessageHelper.setCc(HrmsGlobalConstantUtil.MAIL_CC);

			mimeMessageHelper.setText("Hi  " + contactUs.getName() + "\r\n" +

					"\t\tYour FAB HR Contact Us is:\r\n" + "\r\n" + contactUs.getMessage()

			);
			System.out.println("==========6");
			mailSender.send(mimeMessageHelper.getMimeMessage());
			System.out.println("mail send succesfully :" + email);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
