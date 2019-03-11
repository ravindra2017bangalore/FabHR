package com.csipl.hrms.employee.controller;

import java.io.ByteArrayInputStream;
 import java.io.IOException;
 import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
 import com.csipl.hrms.dto.employee.TicketRaisingHdDTO;
import com.csipl.hrms.dto.employee.TicketTypeDTO;
 import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
 import com.csipl.hrms.model.employee.TicketDesc;
import com.csipl.hrms.model.employee.TicketRaisingHD;
import com.csipl.hrms.model.employee.TicketType;
 import com.csipl.hrms.org.BaseController;
  import com.csipl.hrms.service.adaptor.TicketManagementAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.TicketRaisingService;
import com.csipl.hrms.service.employee.TicketTypeService;

@RestController
@RequestMapping("/tms")
public class TicketManagementController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(TicketManagementController.class);
	@Autowired
	TicketTypeService ticketTypeService;

	@Autowired
	TicketRaisingService ticketRaisingService;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	TicketManagementAdaptor ticketManagementAdaptor = new TicketManagementAdaptor();

	/**
	 * @param ticketTypeDTO
	 *            This is the first parameter for getting Skill Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(value = "/ticketType", method = RequestMethod.POST)
	public void save(@RequestBody TicketTypeDTO ticketTypeDTO, HttpServletRequest req) {
		TicketType ticketType = ticketManagementAdaptor.uiDtoToDatabaseModel(ticketTypeDTO);
		ticketTypeService.save(ticketType);
	}

	/**
	 * to get List of TicketType from database based on companyId
	 * @throws PayRollProcessException 
	 *//*
	@RequestMapping(path = "/ticketType", method = RequestMethod.GET)
	public @ResponseBody List<TicketTypeDTO> getAllTicketType(HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		List<TicketType> ticketTypeList = ticketTypeService.findAllTicketType(getCompanyId(req));
		if (ticketTypeList != null && ticketTypeList.size() > 0)
			return ticketManagementAdaptor.databaseModelToUiDtoList(ticketTypeList);
		else
			throw new ErrorHandling(" ticketType Data not present");
	}
*/
	@RequestMapping(value = "/ticketType/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TicketTypeDTO> fetchAllTicket(@PathVariable("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<TicketType> ticketTypeList = ticketTypeService.findAllTicketType(companyIdValue);
		if (ticketTypeList != null && ticketTypeList.size() > 0)
			return ticketManagementAdaptor.databaseModelToUiDtoList(ticketTypeList);
		else
			throw new ErrorHandling(" ticketType Data not present");
	}

	
	/**
	 * to get TicketType Object from database based on ticketTypeId (Primary Key)
	 */
	@RequestMapping(value = "/ticketTypeById/{ticketTypeId}", method = RequestMethod.GET)
	public @ResponseBody TicketTypeDTO getTicketType(@PathVariable("ticketTypeId") String ticketTypeID,
			HttpServletRequest req) throws ErrorHandling {
		Long ticketTypeId = Long.parseLong(ticketTypeID);
		TicketType ticketType = ticketTypeService.findTicketType(ticketTypeId);
		if (ticketType != null)
			return ticketManagementAdaptor.databaseModelToUiDto(ticketType);
		else
			throw new ErrorHandling(" ticketType Data not present");
	}

	/**
	 * Method performed save operation with file
	 * 
	 * @param file
	 *            This is the first parameter for taking file Input
	 * @param ticketRaisingHdDto
	 *            This is the second parameter for getting ticketRaisingHd Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/ticketRaisingFile/{emailId}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void saveTicketRaisingHd(@PathVariable("emailId") String emailId,
			@RequestPart("uploadFile") MultipartFile file, @RequestPart("info") TicketRaisingHdDTO ticketRaisingHdDto,
			HttpServletRequest req) throws PayRollProcessException {
		
		logger.info("saveTicketRaisingHd..."+ emailId + "...file,..."+file+"...TicketRaisingHdDTO..." +ticketRaisingHdDto);
		
		TicketRaisingHD ticketRaisingHd = ticketManagementAdaptor.uiDtoToTicketRaisingHdModel(ticketRaisingHdDto);
		Employee employee = employeePersonalInformationService
				.findEmployeesById(ticketRaisingHd.getEmployee().getEmployeeId());

		if (ticketRaisingHd.getTicketRaisingHDId() != null)
			ticketRaisingHd.setCreatedBy(ticketRaisingHdDto.getUserId());
		TicketRaisingHD ticketRaisingHd1 = ticketRaisingService.save(ticketRaisingHd, file, true,  ticketRaisingHdDto.getCompanyId());
		TicketType ticketType = ticketTypeService.findTicketType(ticketRaisingHdDto.getTicketTypeId());
		byte[] byteArr;
		try {
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
		
			if (ticketRaisingHdDto.getTicketRaisingHDId()==null) {
				logger.info("New tickect :" );
				triggerEmailNew(inputStream, ticketRaisingHd1, emailId, employee.getAddress1().getEmailId(), ticketRaisingHdDto, extension, employee,ticketType);
			}else
				triggerEmail(inputStream, ticketRaisingHd1, emailId, employee.getAddress1().getEmailId(), ticketRaisingHdDto, extension,employee,ticketType);
			logger.info("email sent..." );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
 	 * @param emailId
	 *            This is the first parameter for taking emailId from UI
	 * @param ticketRaisingHdDto
	 *            This is the second parameter for getting ticketRaisingHd Object from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/ticketRaising/{emailId}", method = RequestMethod.POST)
	public void saveTicketRaisingHd(@PathVariable("emailId") String emailId,
			@RequestBody TicketRaisingHdDTO ticketRaisingHdDto, HttpServletRequest req) throws PayRollProcessException {
		logger.info("saveTicketRaisingHd..."+ emailId +"...TicketRaisingHdDTO..." +ticketRaisingHdDto);
		TicketRaisingHD ticketRaisingHd = ticketManagementAdaptor.uiDtoToTicketRaisingHdModel(ticketRaisingHdDto);
		Employee employee = employeePersonalInformationService
				.findEmployeesById(ticketRaisingHd.getEmployee().getEmployeeId());
		
		ticketRaisingHd.setDateUpdate(new Date());
	
		if (ticketRaisingHd.getTicketRaisingHDId() != null)
			ticketRaisingHd.setCreatedBy(ticketRaisingHdDto.getUserId());
		TicketRaisingHD ticketRaisingHd2 = ticketRaisingService.save(ticketRaisingHd, null, false, ticketRaisingHdDto.getCompanyId());
		TicketRaisingHD ticketRaisingHd1 =ticketRaisingService.findTicketRaising(ticketRaisingHd2.getTicketRaisingHDId());
		TicketType ticketType = ticketTypeService.findTicketType(ticketRaisingHdDto.getTicketTypeId());
		
		if (ticketRaisingHdDto.getTicketRaisingHDId()==null) {
			logger.info("New tickect :" );
			triggerEmailNew(null, ticketRaisingHd1, emailId, employee.getAddress1().getEmailId(), ticketRaisingHdDto, null, employee,ticketType);
		}else 
			triggerEmail(null, ticketRaisingHd1, emailId, employee.getAddress1().getEmailId(), ticketRaisingHdDto, null,employee,ticketType);
		
		logger.info("email sent..." );
	}
	/**
	 * to get List of TicketRaisingHds from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/ticketRaising/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TicketRaisingHdDTO> getAllTicketRaisng(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllTicketRaisng...companyId"+ companyId );
		Long companyID = Long.parseLong(companyId);
		List<TicketRaisingHD> ticketRaisingHDList = ticketRaisingService.findAllTicketRaising(companyID);
		if (ticketRaisingHDList != null && ticketRaisingHDList.size() > 0)
			return ticketManagementAdaptor.databaseModelTicketRaisingDtoList(ticketRaisingHDList);
		else
			throw new ErrorHandling(" ticketType Data not present");

	}
	/**
	 * to get List of TicketRaisingHds from database based on employeeId
	 */
	@RequestMapping(value = "/empTicketRaising/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<TicketRaisingHdDTO> getTicketRaisng(@PathVariable("employeeId") String employeeId,
			HttpServletRequest req) throws ErrorHandling {
		Long empId = Long.parseLong(employeeId);
		List<TicketRaisingHD> ticketRaisingHDList = ticketRaisingService.findAllEmpTicketRaising(empId);
		if (ticketRaisingHDList != null && ticketRaisingHDList.size() > 0)
			return ticketManagementAdaptor.databaseModelTicketRaisingDtoList(ticketRaisingHDList);
		else
			throw new ErrorHandling(" ticketType Data not present");

	}

	/**
	 * to get TicketRaisingHd Object from database based on ticketRaisingHdId (Primary Key)
	 */
	@RequestMapping(value = "/ticketRaisingById/{ticketRaisingHDId}", method = RequestMethod.GET)
	public @ResponseBody TicketRaisingHdDTO getTicketRaising(
			@PathVariable("ticketRaisingHDId") String ticketRaisingHDId, HttpServletRequest req) throws ErrorHandling {
		Long ticketRaisingHdId = Long.parseLong(ticketRaisingHDId);
		TicketRaisingHD ticketRaisingHD = ticketRaisingService.findTicketRaising(ticketRaisingHdId);
		if (ticketRaisingHD != null)
			return ticketManagementAdaptor.databaseModelToTicketRaisingDto(ticketRaisingHD);
		else
			throw new ErrorHandling(" ticketRaising Data not present");
	}

	/**
	 * Method Performed email sending logic
	 */
	public void triggerEmail(ByteArrayInputStream bis, TicketRaisingHD ticketRaising, String emailTo, String emailFrom,
			TicketRaisingHdDTO ticketRaisingHdDto, String extension,Employee employee,TicketType ticketType ) {
		
		System.out.println("mail from" + emailFrom);
		String desc = null;
		String msg =   "Ticket ID: "
				+ ticketRaising.getTicketNo()
				+ "\r\n" + "Subject: "
				+  ticketRaising.getTitle()
				+ "\r\n" + "Status: "
				+  ticketRaising.getStatus()
				+ "\r\n" + "Ticket Category : "
				+ ((ticketType != null) ?ticketType.getCategory() : " ") ;
		String msgemp =   "Employee Code : "
				+ ((employee != null) ? employee.getEmployeeCode() : " ")
				+ "\r\n" + "Employee Name : "
				+ ((employee != null) ? employee.getFirstName() + " "
						+employee.getLastName() : " ")
				+ "\r\n" + "Department : "
				+ ((employee != null)
						? ((employee.getDepartment() != null)
								? employee.getDepartment().getDepartmentName()
								: " "): "")
				+ "\r\n";
				/*+ "\r\nTAT:"
				+ ticketType.getTat() + " working days\r\n	";*/
       
		for (TicketDesc ticketdesc : ticketRaising.getTicketDescs()) {
			desc = ticketdesc.getDescription();
		}
		try {
			
			// mimeMessageHelper.setCc("");
			if (ticketRaisingHdDto.getUser().equals(HrmsGlobalConstantUtil.ESS)) {
				System.out.println("ESS USER");{
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
				logger.info("emailTo :" + emailFrom);

				mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
				logger.info("SEND MAIL TO ESS");
				mimeMessageHelper.setTo( emailFrom);
				
				mimeMessageHelper.setText("Hi Team, " + "\r\n" +"\r\n"+
						"Thanks for your cooperation. With reference to your logged ticket we are sharing the below information:\r\n"
						 + "\r\n" +msg
						 + "\r\n" + "Description of Ticket : " + desc + "\r\n" 
						  +msgemp
						 + "\r\n"
						+ String.format(HrmsGlobalConstantUtil.STRING_FORMAT) + "\r\n"
						+ "The Helpdesk Team");
				if (extension != null) {
					String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
					mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
				}
				mailSender.send(mimeMessageHelper.getMimeMessage());
			}
			
			{
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
				logger.info("emailTo :" + emailTo);

				mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
				logger.info("SEND MAIL TO FSS");
				mimeMessageHelper.setTo(emailTo);
				
				mimeMessageHelper.setText("Hi Team, " + "\r\n" +"\r\n"
						+"We have received ticket that needs to resolve at earliest. Following are the details of the ticket:\r\n"
						+ "\r\n" +msg
					    + "\r\n" + "Description of Ticket : " + desc + "\r\n" 
						+  msgemp
						+ "\r\n"
						+ "Thanks & Regards," + "\r\n"
						+ ((employee != null) ? employee.getFirstName() + " "
								+employee.getLastName() : " "));
				if (extension != null) {
					String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
					mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
				}
				mailSender.send(mimeMessageHelper.getMimeMessage());	
			}}
			if (ticketRaisingHdDto.getUser().equals(HrmsGlobalConstantUtil.FSS)) {
				System.out.println("FSS USER");
			{		
			logger.info("SEND MAIL TO ESS");
 			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
			logger.info("emailTo :" + emailFrom);

			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
		
			mimeMessageHelper.setTo(emailFrom);
				
				
				mimeMessageHelper.setText("Hi " + employee.getFirstName() + " "
						+ employee.getLastName() + "," + "\r\n" +"\r\n"
					 +"Thanks for your cooperation. With reference to your logged ticket we are sharing the below information:" + "\r\n"
                   + "\r\n" + msg
               	+ "\r\n" + "Description of Ticket : " + desc + "\r\n" 
			    +msgemp+ "\r\n"
				 + "Thanks & Regards," + "\r\n"
			     + "The Helpdesk Team");
				if (extension != null) {
					String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
					mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
				}
				mailSender.send(mimeMessageHelper.getMimeMessage());
				}
				{
					logger.info("SEND MAIL TO FSS");
		 			MimeMessage mimeMessage = mailSender.createMimeMessage();
					MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
					mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
					logger.info("emailTo :" + emailTo);

					mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
				
					mimeMessageHelper.setTo(emailTo);	
					mimeMessageHelper.setText("Hi " + "Team," + "\r\n" +
		                "Ticket has been responded, below is the required information:" + "\r\n"
		                + "\r\n" + msg
		               	+ "\r\n" + "Description of Ticket : " + desc + "\r\n" 
					    + msgemp+ "\r\n" 
						+ "Thanks & Regards," + "\r\n"
						+ "The Helpdesk Team");
						if (extension != null) {
							String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
							mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
						}
						mailSender.send(mimeMessageHelper.getMimeMessage());
				}
			}
  			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * Method Performed email sending logic
	 */
	public void triggerEmailNew(ByteArrayInputStream bis, TicketRaisingHD ticketRaising, String emailTo, String emailFrom,
			TicketRaisingHdDTO ticketRaisingHdDto, String extension,Employee employee,TicketType ticketType ) {
		
		System.out.println("mail from" + emailFrom);
		String desc = null;
		String msg =   "Ticket ID : "
				+ ticketRaising.getTicketNo()
				+ "\r\n" + "Subject : "
				+  ticketRaising.getTitle()
				+ "\r\n" + "Status : "
				+  ticketRaising.getStatus()
				+ "\r\n" + "Ticket Category : "
				+ ((ticketType != null) ?ticketType.getCategory() : " ") ;
	        	String msgemp =   "Employee Code : "
				+ ((employee != null) ? employee.getEmployeeCode() : " ")
				+ "\r\n" + "Employee Name : "
				+ ((employee != null) ? employee.getFirstName() + " "
						+employee.getLastName() : " ")
				+ "\r\n" + "Department : "
				+ ((employee != null)
						? ((employee.getDepartment() != null)
								? employee.getDepartment().getDepartmentName()
								: " "): "")
				+ "\r\n";
				
 
		for (TicketDesc ticketdesc : ticketRaising.getTicketDescs()) {
			desc = ticketdesc.getDescription();
		}
		try {
			 {
				logger.info("If ESS-  new ticket");
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
				logger.info("emailTo :" + emailTo);

				mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
				mimeMessageHelper.setTo(emailTo);
				
				mimeMessageHelper.setText("Hi Team, " + "\r\n" +"\r\n"+

						"We have received ticket that needs to be resolved at earliest. Following are the details of the ticket:\r\n" 
						+ "\r\n" +msg
						+ "\r\n" + "Description of Ticket : " + desc + "\r\n" 
						+msgemp
						+ "\r\n"
						+ "Thanks & Regards," + "\r\n"
						+ ((employee != null) ? employee.getFirstName() + " "
								+employee.getLastName() : " "));
				if (extension != null) {
					String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
					mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
				}
				mailSender.send(mimeMessageHelper.getMimeMessage());
			}
 			 {
 				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setSubject(ticketRaising.getTicketNo() + " :" + ticketRaising.getTitle());
				mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
				
				mimeMessageHelper.setTo(emailFrom);
				
				mimeMessageHelper.setText("Hi " + employee.getFirstName() + " "
						+ employee.getLastName() + "," + "\r\n" +"\r\n"+
                        "Thanks for getting in touch. Just letting you know that we have received"
                   + " your ticket and our support Team will get back to you as soon as possible.\r\n"+
						"\tFor your reference, here are the details of your ticket:\r\n" + "\r\n"
						+  msg
						+ "\r\n" + "Description of Ticket : " + desc + "\r\n" 
						+msgemp+ "\r\n" + "\r\n" + "Thanks & Regards," + "\r\n"
						+ "The Helpdesk Team");
				if (extension != null) {
					String fileName = HrmsGlobalConstantUtil.TICKET_ISSUE + "." + extension;
					mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(bis)));
				}
				mailSender.send(mimeMessageHelper.getMimeMessage());
			}
  			

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	
	/**
	 * to get List of TicketRaisingHds from database based on companyId and status=Open and current date
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/ticketRaisingOpen/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TicketRaisingHdDTO> getAllTicketRaisingOpen(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllTicketRaisingOpen is calling : ..companyId :"+companyId);
		Long companyID = Long.parseLong(companyId);
 		List<TicketRaisingHD> ticketRaisingHDList = ticketRaisingService.findAllTicketRaisingOpen(companyID);
		if (ticketRaisingHDList != null && ticketRaisingHDList.size() > 0)
			return ticketManagementAdaptor.databaseModelTicketRaisingDtoList(ticketRaisingHDList);
		else
			throw new ErrorHandling("No one open ticket ");

	}
}
