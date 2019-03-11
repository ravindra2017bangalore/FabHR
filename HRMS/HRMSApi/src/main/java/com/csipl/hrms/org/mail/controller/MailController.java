package com.csipl.hrms.org.mail.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.model.Mail;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.common.MailDTO;
import com.csipl.hrms.model.common.Company;

import com.csipl.hrms.model.common.User;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.MailConfigAdaptor;
import com.csipl.hrms.service.common.MailService;

@RequestMapping("/mailconfig")
@RestController
public class MailController  {
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	MailService mailService;

	MailConfigAdaptor mailConfigAdaptor = new MailConfigAdaptor();

	
	/**
	 * to save MailConfiguration
	  
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveDepartment(@RequestBody MailDTO mailDTO, HttpServletRequest req) {
		logger.info("saveMailConfig is calling : MailDTO "+ mailDTO);
		Mail mail = mailConfigAdaptor.uiDtoToDatabaseModel(mailDTO);
		//boolean newFlag = (mail != null) && (mail.getMailId() != null ? false : true);
		//userUpdateInfo(mail, req);
		mailService.save(mail);
		logger.info("saveMailConfig is end  :"  + mail);
	}
	/**
	 * to get User Information/Session
	 */
	
	public void userUpdateInfo(Mail mail, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		System.out.println("User is set" + user);
		Company company = new Company();
		mail.setCompanyId(user.getCompany().getCompanyId());
		mail.setDateCreated(new Date());
		//mail.setUpdateDate(new Date());
		mail.setUserId(user.getUserId());

	}
	
	/**
	 * to get all Mail Configuration List from database based on companyId
	  
	 */
	@RequestMapping(path = "/mailConfigList/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<MailDTO> getMailConfigList(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDepartments is calling :  companyId.."+companyId );
		
		Long companyID = Long.parseLong(companyId);
		List<Mail> mailList = mailService.findAllMailConfigList(companyID);
		logger.info("getAllMailConfigList is end :MailConfigList" + mailList );
		if (mailList != null)
			return mailConfigAdaptor.databaseModelToUiDtoList(mailList);
		else
			throw new ErrorHandling("Mail Config List  are not available in company");
	}
	
	/**
	 * delete MailConfiguaration object from database based on mailId (Primary Key)
	 */
	@RequestMapping(path = "/deleteMailConfig/{ID}", method = RequestMethod.DELETE)
	public void deleteEmployeeDocument(@PathVariable("ID") Long mailId, HttpServletRequest req) {
		logger.info("deleteMailConfig is calling :" +"documentId"+mailId);
		//Long mailId=Long.parseLong(mailId);
		mailService.delete(mailId);		
	}
		
}

