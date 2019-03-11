package com.csipl.hrms.payroll.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.csipl.hrms.dto.payroll.LoanEMIDTO;
import com.csipl.hrms.dto.payroll.LoanIssueDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.LoanIssueAdaptor;
import com.csipl.hrms.service.adaptor.ReportPayOutAdaptor;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.payroll.LoanIssueService;
import com.csipl.hrms.service.util.LoanEmiPdf;

@RestController
public class LoanIssueController  {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoanIssueController.class);
	LoanIssueAdaptor loanIssueAdaptor = new LoanIssueAdaptor();
	@Autowired
	LoanIssueService loanIssueService;
	@Autowired
	CompanyService companyService;

	@Autowired
	JavaMailSender mailSender;

	/**
	 * @param loanIssueDto
	 *            This is the first parameter for getting loanIssue Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/loanIssue", method = RequestMethod.POST)
	public void loanIssue(@RequestBody LoanIssueDTO loanIssueDTO, HttpServletRequest req) {
		logger.info("loanIssueDto :" + loanIssueDTO.toString());
		LoanIssue loanIssue = loanIssueAdaptor.uiDtoToDatabaseModel(loanIssueDTO);
		//boolean newFlag = loanIssue != null && loanIssue.getTransactionNo() != null ? false : true;
		//editLogInfoWithoutGroup(loanIssue, newFlag, req);
		loanIssueService.save(loanIssue);
	}

	/**
	 * to get List of loanIssue objects from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/loanIssue", method = RequestMethod.GET)
	public @ResponseBody List<LoanIssueDTO> findAllLoanIssue(@RequestParam("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		logger.info("findAllLoanIssue controller companyId is :" + companyId);
		Long companyID = Long.parseLong(companyId);
		return loanIssueAdaptor.databaseObjModelToUiDtoList(loanIssueService.getAllLoanIssue(companyID));
	}

	/**
	 * to get LoanIssue from database based on loanIssueId(Primary Key)
	 */
	@RequestMapping(path = "/loanIssueId", method = RequestMethod.GET)
	public @ResponseBody LoanIssueDTO findLoanIssue(@RequestParam("loanIssueId") String loanIssueId,
			HttpServletRequest req) {

		logger.info("findLoanIssue controller loanIssueId is :" + loanIssueId);
 		Long loanId = Long.parseLong(loanIssueId);
		LoanIssue loanIssue = loanIssueService.getLoanIssue(loanId);
		LoanIssueDTO loanIssueDto = loanIssueAdaptor.databaseModelToUiDto(loanIssue);
 		if (loanIssue.getLoanEmis() != null && loanIssue.getLoanEmis().size() > 0) {
			loanIssueDto.setFlag(true);
			return loanIssueDto;
		} else
			loanIssueDto.setFlag(false);
		return loanIssueDto;
	}

	/**
	 * to get List of LoanEMI from database based on transactionNo(Primary Key)
	 */
	@RequestMapping(path = "/myloanEmiDetails", method = RequestMethod.GET)
	public @ResponseBody List<LoanEMIDTO> findLoanEmiDetails(@RequestParam("transactionNo") Long transactionNo,
			HttpServletRequest req) {
		logger.info("findLoanEmiDetails is transactionNo :" + transactionNo);
		return loanIssueAdaptor.databaseModelToLoanEmiDtoList(loanIssueService.getLoanEmiDetailsList(transactionNo));
	}

	/**
	 * to get List of LoanIssue from database based on empolyeeId
	 */
	@RequestMapping(path = "/myLoanIssue", method = RequestMethod.GET)
	public @ResponseBody List<LoanIssueDTO> getMyLoanInfo(@RequestParam("empolyeeId") String empolyeeId,
			HttpServletRequest req) {

		logger.info("getMyLoanInfo is :" + empolyeeId);
		Long empId = Long.parseLong(empolyeeId);

		List<LoanIssue> loanIssueList = loanIssueService.getMyLoanInfo(empId);
		
		return loanIssueAdaptor.databaseModelToUiDtoList( loanIssueList );
	}

	/**
	 * to get loanEmi statement as a PDF file based on transactionNo
	 */
	@RequestMapping(path = "/loanIssuePdf", method = RequestMethod.GET)
	public StreamingResponseBody reportPayout(@RequestParam("transactionNo") String transactionNo,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("reportPayout is :" + transactionNo);
		Company company = null;
		Long longTransactionNo = Long.parseLong(transactionNo);
 		List<LoanEMIDTO> LoanEMIDTOList = loanIssueAdaptor
				.databaseModelToLoanEmiDtoList(loanIssueService.getLoanEmiDetailsList(longTransactionNo));
  		LoanIssue loanIssue = loanIssueService.getLoanIssue(longTransactionNo);
 		LoanIssueDTO loanIssueDto = loanIssueAdaptor.databaseModelToUiDto(loanIssue);
 		company = companyService.getCompany(loanIssue.getCompany().getCompanyId());
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"loanEmi.pdf\"");
		ByteArrayInputStream bis = new LoanEmiPdf().loanPdfReport(loanIssueDto, company, LoanEMIDTOList);
		return outputStream -> {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = bis.read(data, 0, data.length)) != -1) {
				outputStream.write(data, 0, nRead);
			}
		};
	}

	/**
	 * Method Performed email sending logic
	 */
	public void triggerEmail(ByteArrayInputStream bis, String email, ReportPayOutAdaptor company) {
		logger.info("triggerEmail");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject("Employee Loan Details");
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
			mimeMessageHelper.setCc(HrmsGlobalConstantUtil.MAIL_CC);
			String quationName = "loan" + ".pdf";
			mimeMessageHelper.addAttachment(quationName, new ByteArrayResource(IOUtils.toByteArray(bis)));
			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param loanIssueDto
	 *            This is the first parameter for getting loanIssue Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/loanSettled", method = RequestMethod.POST)
	public void loanSettled(@RequestBody LoanIssueDTO loanIssueDto, HttpServletRequest req) {
		logger.info("loanSettled method loanIssueDto :" + loanIssueDto.toString());
		LoanIssue loanIssue = loanIssueAdaptor.uiDtoToDatabaseModelSettlement(loanIssueDto);
 		logger.info("loanIssue:" + loanIssue.toString());
 	
		loanIssueService.save(loanIssue);
	}
	/**
	 * to get LoanIssue from database based on loanIssueId(Primary Key)
	 */
	@RequestMapping(path = "/loanSettled", method = RequestMethod.GET)
	public @ResponseBody LoanIssueDTO findloanSettled(@RequestParam("loanIssueId") String loanIssueId,
			HttpServletRequest req) {

		logger.info("findloanSettled controller loanIssueId is :" + loanIssueId);
 		Long loanId = Long.parseLong(loanIssueId);
		LoanIssue loanIssue = loanIssueService.getLoanIssue(loanId);
		LoanIssueDTO loanIssueDto = loanIssueAdaptor.databaseModelToUiDtoSettement(loanIssue);
	 
		
 		return loanIssueDto;
	}
	
}
