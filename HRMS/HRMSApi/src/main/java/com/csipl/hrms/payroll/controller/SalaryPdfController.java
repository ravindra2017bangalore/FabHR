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
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.csipl.common.model.Mail;
import com.csipl.common.util.EmailUtils;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.dto.payroll.InvestmentFinancialYearDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutSalaryDTO;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.DepartmentAdaptor;
import com.csipl.hrms.service.adaptor.ReportPayOutAdaptor;
import com.csipl.hrms.service.common.CityService;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.payroll.PayRollLockService;
import com.csipl.hrms.service.payroll.ReportPayOutService;
import com.csipl.hrms.service.util.PayrollDateCalculation;
import com.csipl.hrms.service.util.SalaryPdfReport;

@RequestMapping("/salaryReport")
@RestController
public class SalaryPdfController  {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(SalaryPdfController.class);
	@Autowired
	ReportPayOutService reportPayOutService;

	@Autowired
	CompanyService companyService;

	@Autowired
	CityService cityService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	PayRollLockService payRollLockService;

	@Autowired
	MailService mailService;
	ReportPayOutAdaptor reportPayOutAdaptor = new ReportPayOutAdaptor();
	DepartmentAdaptor departmentAdaptor = new DepartmentAdaptor();

	/**
	 * Method performed save operation with attendance attachment file
	 * 
	 * @param reportPayOutSalaryDtoList
	 *            This is the first parameter for getting List if reportPayOutSalary
	 *            Objects from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(value = "/pdf", method = RequestMethod.POST)
	public void salaryPdfReport(@RequestBody List<ReportPayOutSalaryDTO> reportPayOutSalaryDtoList,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws Exception {
		ByteArrayInputStream bis = null;
		EmailUtils emailUtils= new EmailUtils();
		
		
		System.out.println("salaryPdfReport controller");
     Mail mail=mailService.getEmailDetail("salarySlip", companyId );
    System.out.println(mail);

	System.out.println(mail.getFunctionName());
	System.out.println((mail.getFromMail()));

		if (reportPayOutSalaryDtoList != null && reportPayOutSalaryDtoList.size() > 0) {

			for (ReportPayOutSalaryDTO reportPayOutSalaryDto : reportPayOutSalaryDtoList) {

				ReportPayOut reportPayOut = reportPayOutService.findEmployeePayOutPdf(
						reportPayOutSalaryDto.getEmployeeCode(), reportPayOutSalaryDto.getProcessMonth(),
						companyId);
				Company company = companyService.getCompany(reportPayOut.getCompanyId());
				Employee employee = employeePersonalInformationService
						.findEmployeesById(reportPayOut.getEmployee().getEmployeeId());

				City city = cityService.getCity(reportPayOut.getCityId());
				if (company != null && city != null && employee != null) {
					logger.info("generating pdf for enployee"+employee.getEmployeeCode()+"name is :"+employee.getFirstName());
					bis = new SalaryPdfReport().salaryPdfReport(reportPayOut, company, city, employee);
					
					logger.info("sending selary  slip pdf "+bis);
					emailUtils.triggerEmail(bis,  reportPayOutSalaryDto.getEmail(), mail, mailSender);
					//triggerEmail1(bis, reportPayOutSalaryDto.getEmail(),null);
				} else {
					logger.info("Some data are not avalable to generate pdf  "+company+"city"+city+"employee"+employee);
					throw new ErrorHandling("Some data are not avalable to generate pdf ");
				}
			}
		} else {
			logger.info("No Employee available to generate salary slip  pdf  report");
			throw new ErrorHandling("No Employee available to generate salary slip  pdf  report");
		}
	}

	/**
	 * Method Performed email sending logic
	 */
	public void triggerEmail1(ByteArrayInputStream bis, String email, ReportPayOutAdaptor company) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		logger.info("To email1 is :"+ email);
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(HrmsGlobalConstantUtil.MAIL_SUBJECT);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
			mimeMessageHelper.setCc(HrmsGlobalConstantUtil.MAIL_CC);
			mimeMessageHelper.addAttachment(HrmsGlobalConstantUtil.QUATION_NAME,
					new ByteArrayResource(IOUtils.toByteArray(bis)));
			mailSender.send(mimeMessageHelper.getMimeMessage());
			logger.info("mail send succesfully :"+ email);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method Performed employee salary slip generation logic based on employeeCode
	 * and processMonth 
	 */
	@RequestMapping(path = "/payoutPdf/{empCode}/{processMonth}/{companyId}", method = RequestMethod.GET)
	public StreamingResponseBody reportPayout(@PathVariable("empCode") String empCode,
			@PathVariable("processMonth") String processMonth,@PathVariable("companyId") String companyId, HttpServletRequest req, HttpServletResponse response)
			throws Exception {
		Long companyID = Long.parseLong(companyId);
 		Company company = null;
		ReportPayOut reportPayOut = null;
		Employee employee = null;
		City city = null;
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"employeeSalarySlip.pdf\"");
		if (empCode != null && !empCode.equals("") && processMonth != null && !processMonth.equals(""))
			reportPayOut = reportPayOutService.findEmployeePayOutPdf(empCode, processMonth, companyID);
		if (reportPayOut != null) {
			company = companyService.getCompany(reportPayOut.getCompanyId());
			employee = employeePersonalInformationService.findEmployeesById(reportPayOut.getEmployee().getEmployeeId());
			city = cityService.getCity(reportPayOut.getCityId());
		}
		logger.info("Generating Pdf for Employee code :"+employee.getEmployeeCode()+"name :"+employee.getFirstName());
		ByteArrayInputStream bis = new SalaryPdfReport().salaryPdfReport(reportPayOut, company, city, employee);
		return outputStream -> {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = bis.read(data, 0, data.length)) != -1) {
				outputStream.write(data, 0, nRead);
			}
		};
	}
	/**
	 * to get last 6 process months for employee salary slip 
	 */
	@RequestMapping(path = "/employeeSalarySlipMonth", method = RequestMethod.GET)
	public @ResponseBody List<InvestmentFinancialYearDTO> getEmployeeSalarySlipMonth(HttpServletRequest req) {
 		PayrollDateCalculation payrollDateCalculation = new PayrollDateCalculation();
		List<InvestmentFinancialYearDTO> investmentFinancialYearDtoList = payrollDateCalculation
				.employeeSalarySlipProcessMonth();
		return investmentFinancialYearDtoList;
	}
	/**
	 * to get List of departments based on processMonth  
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/departmentForSalary", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getAllDepartmentsForSalaryReconcilition(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		Long companyID = Long.parseLong(companyId);
		List<Department> departmentList = payRollLockService.findDepartmentForSalaryGenerate(companyID,
				processMonth);
		if (departmentList != null)
			return departmentAdaptor.databaseModelToUiDtoList(departmentList);
		else
			throw new ErrorHandling("Departments Are Not Available In Company");
	}

	@RequestMapping(path = "/reportPayoutPdfApp", method = RequestMethod.GET)
	public 		ResponseEntity<ByteArrayResource> reportPayoutApp(@RequestParam("empCode") String empCode,
			@RequestParam("processMonth") String processMonth, @RequestParam("companyId") String companyId, HttpServletResponse response)
			throws Exception {
 		Company company = null;
		ReportPayOut reportPayOut = null;
		Employee employee = null;
		City city = null;
		Long companyID = Long.parseLong(companyId);
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"employeeSalarySlip.pdf\"");
		if (empCode != null && !empCode.equals("") && processMonth != null && !processMonth.equals(""))
			reportPayOut = reportPayOutService.findEmployeePayOutPdf(empCode, processMonth, companyID);
		if (reportPayOut != null) {
			company = companyService.getCompany(reportPayOut.getCompanyId());
			employee = employeePersonalInformationService.findEmployeesById(reportPayOut.getEmployee().getEmployeeId());
			city = cityService.getCity(reportPayOut.getCityId());
		}
		logger.info("Generating Pdf for Employee code :"+employee.getEmployeeCode()+"name :"+employee.getFirstName());
		ByteArrayInputStream bis = new SalaryPdfReport().salaryPdfReport(reportPayOut, company, city, employee);
		 byte[] array = new byte[bis.available()];
		 bis.read(array);
		
		return ResponseEntity
		        .ok()
		        .contentLength(array.length)
		        .body(new ByteArrayResource(array));
	}
	
}
