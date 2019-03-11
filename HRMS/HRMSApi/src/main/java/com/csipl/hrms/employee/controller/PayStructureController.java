package com.csipl.hrms.employee.controller;

 import java.util.ArrayList;
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

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.employee.PayStructureHdDTO;
import com.csipl.hrms.dto.payrollprocess.PayOutListDTO;
 import com.csipl.hrms.model.common.User;
 import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;
 import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.GradesPayDefinitionAdaptor;
import com.csipl.hrms.service.adaptor.PayOutAdaptor;
import com.csipl.hrms.service.adaptor.PayStructureHdAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.PayStructureService;
import com.csipl.hrms.service.payroll.FinancialYearService;
import com.csipl.hrms.service.payroll.InvestmentService;
import com.csipl.hrms.service.payroll.OtherIncomeService;
import com.csipl.hrms.service.payroll.ReportPayOutService;
import com.csipl.hrms.service.payroll.TdsApprovalService;
import com.csipl.hrms.service.payroll.TdsPayrollService;
import com.csipl.hrms.service.payroll.TdsStandardExemptionService;
import com.csipl.hrms.service.payroll.TdsTransactionFileService;
import com.csipl.hrms.service.payroll.TdsTransactionService;

@RestController
@RequestMapping("/payStructure")
public class PayStructureController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(PayStructureController.class);

	PayStructureHdAdaptor payStructureHdAdaptor = new PayStructureHdAdaptor();
	GradesPayDefinitionAdaptor gradesPayDefinitionAdaptor = new GradesPayDefinitionAdaptor();

	@Autowired
	PayStructureService payStructureService;

	@Autowired
	InvestmentService investmentService;

	@Autowired
	FinancialYearService financialYearService;

	@Autowired
	TdsPayrollService tdsPayrollService;

	@Autowired
	TdsApprovalService tdsApprovalService;

	
	
	
	
	@Autowired
	TdsTransactionService tdsTransactionService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	TdsTransactionFileService tdsTransactionFileService;

	@Autowired
	OtherIncomeService otherIncomeService;

	@Autowired
	TdsStandardExemptionService tdsStandardExemptionService;

	@Autowired
	ReportPayOutService reportPayOutService;

	PayOutAdaptor payOutAdaptor = new PayOutAdaptor();

	/**
	 * @param payStructureHdDto
	 *            This is the first parameter for getting payStructure Object from
	 *            UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping( method = RequestMethod.POST)
	public void savePayStructureDetails(@RequestBody PayStructureHdDTO payStructureHdDto, HttpServletRequest req) {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		logger.info("user : " + user);
		Long companyId = user.getCompany().getCompanyId();

		PayStructureHd payStructureHd = payStructureHdAdaptor.uiDtoToDatabaseModel(payStructureHdDto);
 		payStructureService.save(payStructureHd, companyId);
	 
	}

	/**
	 * to get PayStructureHd object from database based on employeeId
	 */
	@RequestMapping(value = "/{empid}", method = RequestMethod.GET)
	public @ResponseBody PayStructureHdDTO getPayStructure(@PathVariable("empid") Long empid)
			throws ErrorHandling {
		logger.info("getPayStructure empId id : " + empid);
 		PayStructureHd payStructureHd = payStructureService.findPayStructure(empid);
		if (payStructureHd != null)
			return payStructureHdAdaptor.databaseModelToUiDto(payStructureHd);
		else {
			logger.info("Pay Structure data not present");
			throw new ErrorHandling("Pay Structure data not present");
		}
	}

	/**
	 * to get deduction of employee from database based on employeeId and companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/deduction/{empid}/{companyId}", method = RequestMethod.GET)
	public @ResponseBody PayOutListDTO getDeduction(@PathVariable("empid") String empid,@PathVariable("companyId") Long companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {

		logger.info("getDeduction empid is :" + empid+"companyId>>>"+companyId);
		Long longEmployeeId = Long.parseLong(empid);
		List<PayOut> payOutList = payStructureService.processPayroll(companyId, longEmployeeId);

		if (payOutList != null && payOutList.size() > 0) {
			logger.info("payOutList is coverter : " + payOutList.size());
			return payOutAdaptor.databaseModelToUiDtoList(payOutList);
		} else {
			logger.info("Pay Structure data not present ");
			throw new ErrorHandling("Pay Structure data not present");
		}

	}

	/**
	 * Method PayRevision Performed Pay Revision Operation
	 * 
	 * @param payStructureHdDto
	 *            This is the first parameter for getting payStructureHd Object from
	 *            UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws ErrorHandling
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/payRevision", method = RequestMethod.POST)
	public void savePayRevision(@RequestBody PayStructureHdDTO payStructureHdDto, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {

		Long count = reportPayOutService.checkPayrollOfEmployee(payStructureHdDto.getEmployeeId(),
				DateUtils.getDateStringWithYYYYMMDD(payStructureHdDto.getEffectiveDate()));
		if (count > 0) {
			throw new ErrorHandling("Entry denied, payroll has been created already.");

		} else {
			PayStructureHd payStructureHd = payStructureService.findPayStructure(payStructureHdDto.getEmployeeId());
			PayStructureHd payStructureHdRevision = payStructureHdAdaptor
					.uiDtoToDatabaseModelRevision(payStructureHdDto);
			payStructureService.getPayRevision(payStructureHdDto.getEmployeeId());
			PayStructureHd payStructureHdupdate = payStructureService
					.getPayStructureHd(payStructureHdDto.getPayStructureHdId());
			 

			 
			if (DateUtils.dateFormate(payStructureHdDto.getEffectiveDate())
					.equals(DateUtils.dateFormate(payStructureHd.getEffectiveDate()))) {
				throw new ErrorHandling("Previous effective date and appraisal effective date must not be same");
			} else {
				payStructureHdupdate.setDateEnd(DateUtils.subtractDays(payStructureHdDto.getEffectiveDate(), 1));//
				List<PayStructureHd> payStructureHdList = new ArrayList<PayStructureHd>();
				payStructureHdList.add(payStructureHdupdate);
				payStructureHdList.add(payStructureHdRevision);
				payStructureService.saveAll(payStructureHdList, payStructureHdDto.getEmployeeId(), payStructureHdDto.getCompanyId(),
						payStructureHdRevision);

			}

		}
	}

	/**
	 * to get List of Employee Pay from database based on employeeId
	 */
	@RequestMapping(value = "/payRevision/{empid}", method = RequestMethod.GET)
	public @ResponseBody List<PayStructureHdDTO> getEmployeePayRevisionList(@PathVariable("empid") String empid,
			HttpServletRequest req) throws ErrorHandling {
		logger.info("getEmployeePayRevisionList empid is : " + empid);
		Long longEmployeeId = Long.parseLong(empid);
		List<PayStructureHd> payStructureHdList = payStructureService.getEmployeePayRevisionList(longEmployeeId);
		if (payStructureHdList != null)
			return payStructureHdAdaptor.databaseModelToUiDtoList(payStructureHdList);
		else
			throw new ErrorHandling("Pay Structure data not present");
	}

	/**
	 * to get PayStructureHd from database based on payStructureHdId (Primary Key)
	 */
	@RequestMapping(value = "/payStructureHd/{payStructureHdId}", method = RequestMethod.GET)
	public @ResponseBody PayStructureHdDTO getEmployeePayStructure(
			@PathVariable("payStructureHdId") String payStructureHdId, HttpServletRequest req) throws ErrorHandling {
		logger.info("getEmployeePayStructure payStructureHdId is : " + payStructureHdId);
		Long longPayStructureHdId = Long.parseLong(payStructureHdId);
		PayStructureHd payStructureHd = payStructureService.getPayStructureHd(longPayStructureHdId);
		if (payStructureHd != null)
			return payStructureHdAdaptor.databaseModelToUiDto(payStructureHd);
		else {
			logger.info("pay structre Data not Available");
			throw new ErrorHandling("Data not Available");
		}
	}

	@RequestMapping(value = "/employeePayrollValidate", method = RequestMethod.POST)
	public PayStructureHdDTO employeePayrollValidate(@RequestBody PayStructureHdDTO payStructureHdDto, HttpServletRequest req)
			throws Exception {
		System.out.println("payStructureHdDto.getEmployeeId()"+payStructureHdDto.getEmployeeId());
		System.out.println("payStructureHdDto.getEffectiveDate()"+payStructureHdDto.getEffectiveDate());

		Long count = reportPayOutService.checkPayrollOfEmployee(payStructureHdDto.getEmployeeId(),
				DateUtils.getDateStringWithYYYYMMDD(payStructureHdDto.getEffectiveDate()));
		System.out.println("count"+count);
		if(count>0) {
			logger.info("Entry denied, payroll has been created already.");
			throw new ErrorHandling("Entry denied, payroll has been created already.");
 		}else {
			PayStructureHd payStructureHd = payStructureService.getPayStructure(payStructureHdDto.getPayStructureHdId());
			return payStructureHdAdaptor.databaseModelToUiDto(payStructureHd);

 		}
 	}
	@RequestMapping(value = "/updatePayRevision/{payStructureHdId}", method = RequestMethod.GET)
	public @ResponseBody PayStructureHdDTO updatePayRevision(@PathVariable("payStructureHdId") String payStructureHdId, HttpServletRequest req)
			throws ErrorHandling {
		logger.info("updatePayRevision payStructureHdId id : " + payStructureHdId);
		Long longPayStructureHdId = Long.parseLong(payStructureHdId);
		PayStructureHd payStructureHd = payStructureService.getPayStructure(longPayStructureHdId);
		if (payStructureHd != null)
			return payStructureHdAdaptor.databaseModelToUiDto(payStructureHd);
		else {
			logger.info("Pay Structure data not present");
			throw new ErrorHandling("Pay Structure data not present");
		}
	}

}
