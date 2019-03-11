package com.csipl.hrms.org;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.csipl.common.model.Mail;
import com.csipl.hrms.common.enums.MailEnum;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;

@Component
public class JoiningAnniversarySchedular {

	private static final Logger logger = LoggerFactory.getLogger(JoiningAnniversarySchedular.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	MailService mailService;

	@Autowired
	JavaMailSender mailSender;

	public void scheduleTaskWithFixedDelay() {
	}

	public void scheduleTaskWithInitialDelay() {
	}

	@Scheduled(cron = "0 0 10 * * ?")
	public void scheduleTaskWithCronExpression() {

		try {

			List<Mail> mails = mailService.getEmailDetailForSchedular(MailEnum.joiningAnniversery.name());

			for (Mail mail : mails) {
				List<Employee> employees = employeePersonalInformationService
						.findJoiningAnniversaryEmployees(mail.getCompanyId());

				/*
				 * Properties velocityProperties = new Properties();
				 * velocityProperties.setProperty("file.resource.loader.path","/templates");
				 * Template template =
				 * velocityEngine.getTemplate("/templates/joiningAnniversary.vm");
				 */

				for (Employee emp : employees) {

					MimeMessage mimeMessage = mailSender.createMimeMessage();

					MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
					if (mail.getCc() != null)
						mimeMessageHelper.setCc(mail.getCc());

					Map model = new HashMap();
					model.put("firstName", emp.getFirstName());
					model.put("lastName", emp.getLastName());

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
							"templates/joiningAnniversary.vm", "UTF-8", model);

					if (mail.getFromMail() != null && !mail.getFromMail().trim().equals("")) {
						mimeMessageHelper.setFrom(mail.getFromMail());
					} else {
						mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.GREETING_MAIL_ID);
					}

					if (mail.getSubject() != null && !mail.getSubject().trim().equals("")) {
						mimeMessageHelper.setSubject(mail.getSubject());
					} else {
						mimeMessageHelper.setSubject("Happy Joining Anniversary");
					}

					logger.info("emp.getAddress1().getEmailId() " + emp.getAddress1().getEmailId());

					mimeMessageHelper.setTo(emp.getAddress1().getEmailId());
					mimeMessageHelper.setText(text, true);
					mailSender.send(mimeMessageHelper.getMimeMessage());
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void scheduleTaskWithFixedRate() {
		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

}
