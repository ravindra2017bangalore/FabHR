/*package com.csipl.hrms.org;

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

import com.csipl.hrms.common.enums.MailEnum;
import com.csipl.hrms.model.common.Mail;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;

@Component
public class AnniversarySchedular {
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

	public void scheduleTaskWithFixedDelay() {
	}

	public void scheduleTaskWithInitialDelay() {
	}

	@Scheduled(cron = "0 19 17 * * ?")
	public void scheduleTaskWithCronExpression() {

		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<Employee> employees = employeePersonalInformationService.findAnniversaryEmployees(1l);

		Properties velocityProperties = new Properties();
		velocityProperties.setProperty("file.resource.loader.path", "/templates");
		Template template = velocityEngine.getTemplate("/templates/anniversary.vm");
		Mail mail = mailService.getEmailDetailForSchedular(MailEnum.Anniversery.name());
		try {
			for (Employee emp : employees) {
				System.out.println(" Send mail to Anniversary Candidate === " + emp.getFirstName());
				
				 * VelocityContext vc = new VelocityContext(); vc.put("firstName",
				 * emp.getFirstName() ); vc.put("lastName", emp.getLastName() ); StringWriter sw
				 * = new StringWriter(); template.merge(vc, sw);
				 

				MimeMessage mimeMessage = mailSender.createMimeMessage();

				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

				
				 * if(mail.getCc()!=null) { System.out.println( "  mail.getCc()  " +
				 * mail.getCc() ); //mimeMessageHelper.setFrom( mail.getCc() );
				 * mimeMessageHelper.setCc( mail.getCc() ); }
				 
				Map model = new HashMap();
				model.put("firstName", emp.getFirstName());
				model.put("lastName", emp.getLastName());

				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/anniversary.vm",
						"UTF-8", model);
				mimeMessageHelper.setFrom("ravindra.singh@computronics.in");
				mimeMessageHelper.setTo(emp.getAddress1().getEmailId());
				mimeMessageHelper.setText(text, true);
				mailSender.send(mimeMessageHelper.getMimeMessage());
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
*/