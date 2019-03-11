package com.csipl.hrms.org;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.csipl.common.model.Mail;
import com.csipl.hrms.common.enums.MailEnum;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@Component
public class BirthDaySchedular {
	private static final Logger logger = LoggerFactory.getLogger(BirthDaySchedular.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	MailService mailService;

	@Autowired
	JavaMailSender mailSender;

	// public void scheduleTaskWithFixedRate() {}

	public void scheduleTaskWithFixedDelay() {
	}

	public void scheduleTaskWithInitialDelay() {
	}

	@Scheduled(cron = "0 15 10 * * ?")
	public void scheduleTaskWithCronExpression() {

		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		String path = "";
		Date now = new Date();

		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		List<Mail> mails = mailService.getEmailDetailForSchedular(MailEnum.birthDay.name());

		try {
			for (Mail mail : mails) {

				String from = mail.getFromMail();
				String subject = mail.getSubject();

				logger.info(" mail.getFromMail() " + from);
				logger.info(" mail.getSubject() " + subject);

				List<Employee> employees = employeePersonalInformationService
						.findBirthDayEmployees(mail.getCompanyId());

				Properties velocityProperties = new Properties();
				velocityProperties.setProperty("file.resource.loader.path", "/templates");

				for (Employee emp : employees) {

					MimeMessage mimeMessage = mailSender.createMimeMessage();

					MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
					if (mail.getCc() != null)
						mimeMessageHelper.setCc(mail.getCc());

					Map model = new HashMap();
					model.put("firstName", emp.getFirstName());
					model.put("lastName", emp.getLastName());

					if (simpleDateformat.format(now).equals("Monday")) {
						// Template template =
						// velocityEngine.getTemplate("/templates/birthday/birthday_monday.vm");
						path = "/templates/birthday/birthday_monday.vm";
					}
					if (simpleDateformat.format(now).equals("Tuesday")) {
						path = "/templates/birthday/birthday_tuesday.vm";
					}
					if (simpleDateformat.format(now).equals("Wednesday")) {
						path = "/templates/birthday/birthday_wednesday.vm";
					}
					if (simpleDateformat.format(now).equals("Thursday")) {
						path = "/templates/birthday/birthday_thursday.vm";
					}
					if (simpleDateformat.format(now).equals("Friday")) {
						path = "/templates/birthday/birthday_friday.vm";
					}
					if (simpleDateformat.format(now).equals("Saturday")) {

						path = "/templates/birthday/birthday_saturday.vm";
					}
					if (simpleDateformat.format(now).equals("Sunday")) {
						path = "/templates/birthday/birthday_sunday.vm";
					}

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, path, "UTF-8", model);

					if (from != null && !from.trim().equals("")) {
						mimeMessageHelper.setFrom(from);
					} else {
						mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.GREETING_MAIL_ID);
					}

					if (subject != null && !subject.trim().equals("")) {
						mimeMessageHelper.setSubject(subject);
					} else {
						mimeMessageHelper.setSubject("Happy Birth Day");
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

	// @Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

}