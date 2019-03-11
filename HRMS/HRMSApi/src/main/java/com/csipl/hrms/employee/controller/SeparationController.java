package com.csipl.hrms.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.employee.PageIndex;
import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.model.employee.Separation;
import com.csipl.hrms.service.adaptor.SeparationAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.SeparationPaginationService;
import com.csipl.hrms.service.employee.SeparationService;

@RestController
@RequestMapping("/separation")
public class SeparationController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(SeparationController.class);

	@Autowired
	SeparationService separationService;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	private SeparationPaginationService separationPaginationService;

	@Autowired
	private NotificationServices notificationServices;
	SeparationAdaptor separationAdaptor = new SeparationAdaptor();

	/**
	 * @param separationDto
	 *            This is the first parameter for getting Separation Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/resignation", method = RequestMethod.POST)
	public void saveSeparation(@RequestBody SeparationDTO separationDto, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		logger.info("saveSeparation is calling : " + " SeparationDTO  " + separationDto.toString());
		Long separationCount = 0l;
		NotificationMailSmsDto notificationMailSmsDto = new NotificationMailSmsDto();
		Separation separation = separationAdaptor.uiDtoToDatabaseModel(separationDto);
		 
		if (separation.getStatus().equals(StatusMessage.PENDING_CODE))
			separationCount = separationService.checkSeparationForRequest(separation.getEmployee1().getEmployeeId());
		if (separation.getStatus().equals(StatusMessage.APPROVED_CODE) && separation.getSeparationId() == null)
			separationCount = separationService.checkSeparationForRequest(separation.getEmployee1().getEmployeeId());

		System.out.println("separationCount>>>>>>>>>> " + separationCount);
		if (separationCount == 0l) {
			logger.info("saveSeparation is end  :" + separation.toString());
			Separation separation1 = separationService.save(separation);
			notificationMailSmsDto.setNotificationType("SP");
			List<Object[]> reportingTo = employeePersonalInformationService
					.getEmpReportingToEmail(separation1.getEmployee1().getEmployeeId());
			List<String> to = new ArrayList<String>();
			if (reportingTo.size() > 0) {
				for (Object obj[] : reportingTo) {
					System.out.println("reporting to email id" + obj[2].toString());
					to.add(obj[2].toString());
				}
			}
			notificationMailSmsDto.setMobileNo("9826156514");
			notificationMailSmsDto.setTo(to);
			List<String> cc = new ArrayList<String>();
			cc.add("amit.jaiswal@computronics.in");
			notificationMailSmsDto.setCc(cc);
			notificationMailSmsDto.setHtml(true);
			Map<String, String> model = new HashMap<String, String>();
			model.put("firstName", "Amit");
			model.put("lastName", "Jaiwal");
			notificationMailSmsDto.setMapAttribute(model);
			notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");
			notificationServices.sendNotification(notificationMailSmsDto);
		} else {
			logger.info("Separation action already in progress :" + separation.toString());
			throw new ErrorHandling("Separation action already in progress");
		}
	}

	/**
	 * to get List of Separation from database based on employeeId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/{employeeId}/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> getSeparationListByEmpId(@PathVariable("employeeId") String employeeId,
			@PathVariable("companyId") String companyId, HttpServletRequest req) throws PayRollProcessException {
		logger.info("getSeparationListByEmpId is calling : " + " employeeId  " + employeeId);
		Long empId = Long.parseLong(employeeId);
		Long comId = Long.parseLong(companyId);
		return separationAdaptor.databaseModelToUiDtoList(separationService.getSeparationList(empId, comId));// 333
	}

	/**
	 * to get List of Separation from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/separationList/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> getAllseparationList(@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("getAllseparationList is calling : ");
		Long companyID = Long.parseLong(companyId);
		return separationAdaptor.databaseModelToUiDtoList(separationService.getAllseparationList(companyID));
	}

	/**
	 * to get Separation Object from database based on separtionId(Primary Key)
	 */
	@RequestMapping(value = "/separationData/{separtionId}", method = RequestMethod.GET)
	public @ResponseBody SeparationDTO separation(@PathVariable("separtionId") String separtionId,
			HttpServletRequest req) {
		logger.info("separation is calling : " + "separtionId :" + separtionId);
		Long longSepartionId = Long.parseLong(separtionId);
		return separationAdaptor.databaseModelToUiDto(separationService.getSeparation(longSepartionId));// 111
	}

	/**
	 * Method Performed email sending logic
	 */
	public void triggerEmail(Separation separation, String emailTo) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		logger.info("emailTo is : " + emailTo);
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject("Resignation Letter");

			mimeMessageHelper.setTo(emailTo);
			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
			mimeMessageHelper.setText("Hi Team, " + "\r\n" + separation.getDescription() + "\r\n"
					+ String.format(HrmsGlobalConstantUtil.STRING_FORMAT) + "\r\n"
					+ separation.getEmployee1().getFirstName() + " " + separation.getEmployee1().getLastName());
			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * to get List of Separation from database based on companyId and status=pending
	 * and current date
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/separationPending/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> separationPending(@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("separationPending is calling : " + companyId);
		Long companyID = Long.parseLong(companyId);
		List<Separation> separationList = separationService.getAllseparationPendingList(companyID);
		if (separationList != null)
			return separationAdaptor.databaseModelToUiDtoList(separationList);
		else
			throw new ErrorHandling("No one separation pending notification today");

	}

	/**
	 * 
	 * to get List of Separation from database based on companyId and status=pending
	 * and current date
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/noticePeriodCount/{companyId}", method = RequestMethod.GET)
	public @ResponseBody SeparationDTO noticePeriodCount(@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("separationPending is calling : ");
		Long companyID = Long.parseLong(companyId);
		SeparationDTO SeparationDTO = separationService.getNoticePeriodCount(companyID);
		return SeparationDTO;

	}

	/**
	 * to get List of Separation from database based on employeeId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/count/{companyId}", method = RequestMethod.GET)
	public @ResponseBody SeparationDTO getSeparationCount(@PathVariable("companyId") Long companyId,
			HttpServletRequest req) throws PayRollProcessException {

		return separationService.seperationCount(companyId);
	}

	/**
	 * to get List of Separation from database based on employeeId
	 * 
	 */
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> employeeCancelledResignReqList(@PathVariable("employeeId") Long employeeId)
			throws PayRollProcessException {
		logger.info("separationListOfEmployee is calling : " + " employeeId  " + employeeId);
		return separationAdaptor.databaseModelToUiDtoList(separationService.employeeCancelledResignReqList(employeeId));
	}

	/**
	 * to get List of Separation from database based on employeeId
	 * 
	 */
	@RequestMapping(value = "/pendingApproved/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody SeparationDTO employeePendingResignReq(@PathVariable("employeeId") Long employeeId)
			throws PayRollProcessException {
		SeparationDTO SeparationDto = new SeparationDTO();
		logger.info("separationListOfEmployee is calling : " + " employeeId  " + employeeId);
		Separation separation = separationService.employeePendingResignReq(employeeId);

		if (separation != null) {
			return separationAdaptor.databaseModelToUiDto(separation);
		} else {
			return SeparationDto;

		}
	}

	/**
	 * @param separationDto
	 *            This is the first parameter for getting Separation Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/upadateStatus", method = RequestMethod.POST)
	public void updateRequestStatus(@RequestBody SeparationDTO separationDto) {
		logger.info("updateRequestStatus is calling : " + " SeparationDTO  " + separationDto.toString());
		separationService.updateRequestStatus(separationDto.getSeparationId(), separationDto.getStatus(),
				separationDto.getDescription());

	}

	/**
	 * to get List of Separation from database based on companyId and status=pending
	 * and current date
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/pending/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> findAllSeparationPendingReqList(@PathVariable("companyId") Long companyId)
			throws ErrorHandling, PayRollProcessException {
		logger.info("findAllSeparationPendingReqList is calling : " + companyId);
		List<Separation> separationPendingList = separationService.findAllSeparationPendingReqList(companyId);
		if (separationPendingList != null)
			return separationAdaptor.databaseModelToUiDtoList(separationPendingList);
		else
			throw new ErrorHandling("No one separation pending request");

	}

	/**
	 * to get List of Separation from database based on companyId and status=pending
	 * and current date
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/excludedPending/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<SeparationDTO> findAllSeparationExcludedPendingReqList(
			@PathVariable("companyId") Long companyId) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllSeparationPendingReqList is calling : " + companyId);
		List<Separation> separationExcludedPendingList = separationService
				.findAllSeparationExcludedPendingReqList(companyId);
		if (separationExcludedPendingList != null)
			return separationAdaptor.databaseModelToUiDtoList(separationExcludedPendingList);
		else
			throw new ErrorHandling("No one separation completed request");

	}

	@RequestMapping(value = "/{status}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SeparationDTO> getSeparationPaginationList(@RequestBody EmployeeSearchDTO employeeSearcDto,
			@PathVariable("status") boolean status) {
		logger.info(" active employees is calling :" + status);
		List<Object[]> separationList = separationPaginationService
				.getSeparationPaginationList(employeeSearcDto.getCompanyId(), employeeSearcDto, status);
		List<SeparationDTO> separationDtoList = separationAdaptor.modelListToDtoList(separationList, employeeSearcDto);
		return separationDtoList;
	}

	@GetMapping(value = "/separationCount/{companyId}/{pageSize}/{status}")
	public @ResponseBody EmployeeCountDTO getSeparationCount(@PathVariable("companyId") Long companyId,
			@PathVariable("pageSize") String pageSize, @PathVariable("status") boolean status, HttpServletRequest req) {

		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();

		int parPageRecord = Integer.parseInt(pageSize);
		EmployeeCountDTO employeeCountDto = new EmployeeCountDTO();
		separationPaginationService.getSeparationCount(companyId, status, employeeCountDto);
		int count = employeeCountDto.getCount();
		System.out.println("Count :" + count);
		int pages = (count + parPageRecord - 1) / parPageRecord;
		System.out.println("Pages : -" + pages);
		for (int i = 1; i <= pages; i++) {
			PageIndex pageIndex = new PageIndex();
			pageIndex.setPageIndex(i);
			pageIndexList.add(pageIndex);
		}
		employeeCountDto.setPageIndexs(pageIndexList);
		employeeCountDto.setCount(count);
		return employeeCountDto;
	}
}
