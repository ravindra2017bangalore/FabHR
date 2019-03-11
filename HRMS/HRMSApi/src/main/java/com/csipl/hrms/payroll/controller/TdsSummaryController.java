package com.csipl.hrms.payroll.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.TdsPayrollHdDTO;
import com.csipl.hrms.dto.payroll.TdsSummaryChangeDTO;
import com.csipl.hrms.dto.payroll.TdsTransactionDTO;
import com.csipl.hrms.model.payrollprocess.FinancialYear; 
import com.csipl.hrms.service.adaptor.TdsPayrollHdAdaptor;
import com.csipl.hrms.service.adaptor.TdsSummaryChangeAdaptor;
import com.csipl.hrms.service.adaptor.TdsTransactionAdaptor;
import com.csipl.hrms.service.payroll.FinancialYearService;
import com.csipl.hrms.service.payroll.TdsPayrollService;
import com.csipl.hrms.service.payroll.TdsSummaryService;
import com.csipl.hrms.service.payroll.TdsTransactionService;

@RestController
public class TdsSummaryController {

	@Autowired
	TdsSummaryService tdsSummaryService;

	@Autowired
	TdsTransactionService tdsTransactionService;

	@Autowired
	TdsPayrollService tdsPayrollService;

	@Autowired
	FinancialYearService financialYearService;

	TdsTransactionAdaptor tdsTransactionAdaptor = new TdsTransactionAdaptor();
	TdsSummaryChangeAdaptor tdsSummaryChangeAdaptor = new TdsSummaryChangeAdaptor();
	TdsPayrollHdAdaptor tdsPayrollHdAdaptor = new TdsPayrollHdAdaptor();

	@RequestMapping(path = "/tdsSummary", method = RequestMethod.GET)
	public @ResponseBody TdsSummaryChangeDTO getTdsSummary(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		FinancialYear financialYear = financialYearService.findCurrentFinancialYear(currentDate, companyId);
		return tdsSummaryChangeAdaptor
				.databaseModelToUiDto(tdsSummaryService.getTdsSummary(empId, financialYear.getFinancialYear()));
	}

	@RequestMapping(path = "/tdsPayrollSummary", method = RequestMethod.GET)
	public @ResponseBody TdsPayrollHdDTO getTdsPayrollSummary(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		FinancialYear financialYear = financialYearService.findCurrentFinancialYear(currentDate, companyId);
		return tdsPayrollHdAdaptor
				.databaseModelToUiDto(tdsPayrollService.getTdsPayrollHd(empId, financialYear.getFinancialYear()));
	}

	@RequestMapping(path = "/tdsInvestmentSummary", method = RequestMethod.GET)
	public @ResponseBody List<TdsTransactionDTO> getTdsInvestmentSummary(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		return tdsTransactionAdaptor
				.databaseModelToTdsInvestmentArray(tdsTransactionService.getTdsSummaryObjectList(empId, companyId));
	}
}
