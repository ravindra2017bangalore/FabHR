package com.csipl.hrms.mobile.controller;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.organisation.GradeDTO;
import com.csipl.hrms.dto.payroll.LoanEMIDTO;
import com.csipl.hrms.dto.payroll.LoanIssueDTO;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.LoanIssueAdaptor;
import com.csipl.hrms.service.adaptor.ReportPayOutAdaptor;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.payroll.LoanIssueService;
import com.csipl.hrms.service.util.LoanEmiPdf;
import com.csipl.hrms.service.util.SalaryPdfReport;

@RestController
public class LoanIssueMobileController extends BaseController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoanIssueMobileController.class);
	LoanIssueAdaptor loanIssueAdaptor = new LoanIssueAdaptor();
	@Autowired
	LoanIssueService loanIssueService;
	@Autowired
	CompanyService companyService;

	@Autowired
	JavaMailSender mailSender;


	
	
 
	/**
	 * to get List of  LoanIssue   from database based on empolyeeId 
	 */
	@RequestMapping(path = "/myLoanIssueApp", method = RequestMethod.GET)
	public @ResponseBody List<LoanIssueDTO> getMyLoanInfoApp(@RequestParam("empolyeeId") String empolyeeId,HttpServletRequest req) {
	logger.info("getMyLoanInfo is :"+empolyeeId);
		Long empId=Long.parseLong(empolyeeId);
 		return loanIssueAdaptor.databaseModelToUiDtoList(loanIssueService.getMyLoanInfo(empId));
	}
	
	
}
