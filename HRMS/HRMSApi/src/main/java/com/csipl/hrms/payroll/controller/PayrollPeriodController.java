package com.csipl.hrms.payroll.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.dto.payroll.FinancialYearDTO;
import com.csipl.hrms.dto.payroll.PayrollControlDTO;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.DepartmentAdaptor;
import com.csipl.hrms.service.adaptor.PayrollControlAdaptor;
import com.csipl.hrms.service.adaptor.PayrollPeriodAdaptor;
import com.csipl.hrms.service.payroll.PayrollControlService;
import com.csipl.hrms.service.payroll.PayrollPeriodService;
import com.csipl.hrms.service.util.PayrollDateCalculation;

@RequestMapping("/payroll")
@RestController
public class PayrollPeriodController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(PayrollPeriodController.class);
	@Autowired
	PayrollPeriodService payrollPeriodService;
	@Autowired
	PayrollControlService payrollControlService;

	PayrollPeriodAdaptor payrollAdaptor = new PayrollPeriodAdaptor();
	PayrollControlAdaptor payrollControlAdaptor = new PayrollControlAdaptor();
	DepartmentAdaptor departmentAdaptor = new DepartmentAdaptor();

	/**
	 * @param financialYearDto
	 *            This is the first parameter for getting FinancialYear object from
	 *            UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/payrollPeriod",method = RequestMethod.POST)
	public @ResponseBody ErrorHandling save(@RequestBody FinancialYearDTO financialYearDto, HttpServletRequest req)
			throws PayRollProcessException {
		ErrorHandling errorHandling = new ErrorHandling();

		PayrollDateCalculation payrollDateCal = new PayrollDateCalculation();
		String checkFinancialYear = payrollDateCal.getFinancialYear(financialYearDto.getDateFrom());
		FinancialYear financialYear1 = payrollPeriodService.findFinancialYear(checkFinancialYear, getCompanyId(req));
		if (financialYear1 == null) {

			FinancialYear financialYear = payrollAdaptor.uiDtoToDatabaseModel(financialYearDto);
			boolean newFlag = financialYear != null && financialYear.getFinancialYearId() != null ? false : true;
			editLogInfo(financialYear, newFlag, req);

			for (PayrollControl payrollControl : financialYear.getPayrollControls()) {
				boolean newFlag1 = financialYear != null && financialYear.getFinancialYearId() != null ? false : true;
				editLogInfoWithoutCG(payrollControl, newFlag1, req);
			}

			payrollPeriodService.save(financialYear);
			errorHandling.setErrorMessage("sdb");
		} else {
			errorHandling.setErrorMessage("pdb");
		}
		return errorHandling;
	}

	/**
	 * Method performed save operation and returned List of {@link PayrollControl}
	 * Objects
	 * 
	 * @param financialYearDto
	 *            This is the first parameter for getting FinancialYear object from
	 *            UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/payrollControl/{companyId}/{financialYearStr}", method = RequestMethod.GET)
	public @ResponseBody List<PayrollControlDTO> getPayrollControl(@PathVariable("companyId") String companyId,
			@PathVariable("financialYearStr") String financialYearStr, HttpServletRequest req)
			throws PayRollProcessException {
		logger.info("getPayrollControl : companyId" +companyId);
		Long longCompanyId = Long.parseLong(companyId);
		FinancialYear financialYear = null;
		if (financialYearStr != null) {
			if (payrollPeriodService.findFinancialYear(financialYearStr, longCompanyId) == null)
				throw new PayRollProcessException("No Financial Year available in system");
			else
				financialYear = payrollPeriodService.findFinancialYear(financialYearStr, longCompanyId);

		} else {
			financialYear = payrollPeriodService.findLatestFinancialYear(longCompanyId);
			if (financialYear == null) {
				throw new PayRollProcessException("No Financial Year available in system");
			}
		}

		return payrollAdaptor.databaseModelToPayControlDto(financialYear);
	}

	/**
	 * Method performed save operation
	 * 
	 * @param payrollControlDtoList
	 *            This is the first parameter for getting List of PayrollControl
	 *            objects from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/payrollControl", method = RequestMethod.POST)
	public void save(@RequestBody List<PayrollControlDTO> payrollControlDtoList, HttpServletRequest req) {
		List<PayrollControl> payrollControlList = new ArrayList<PayrollControl>();
		payrollControlList = payrollControlAdaptor.uiDtoToDatabaseModelList(payrollControlDtoList);
		/*
		 * for (PayrollControl payrollControl : payrollControlList) { boolean newFlag1 =
		 * payrollControl != null && payrollControl.getControlId() != null ? false :
		 * true; editLogInfoWithoutCG(payrollControl, newFlag1, req); }
		 */
		payrollControlService.save(payrollControlList);
	}

	/**
	 * to get List of Department objects from database based on companyId and
	 * processMonth and method also check departments are within payroll lock
	 * criteria OR not
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/salaryReconcilitionDepartmentList", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getAllDepartmentsForSalaryReconcilition(
			@RequestParam("companyId") String companyId, @RequestParam("processMonth") String processMonth,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDepartmentsForSalaryReconcilition : companyId" +companyId);
		Long longCompanyId = Long.parseLong(companyId);
		List<Department> departmentList = payrollControlService.findAllDepartmentNotINPayrollLock(longCompanyId,
				processMonth);
		if (departmentList != null)
			return departmentAdaptor.databaseModelToUiDtoList(departmentList);
		else
			throw new ErrorHandling("Departments are not available in company");
	}

	/**
	 * to get List of Department objects from database based on companyId and
	 * processMonth and method also check departments are within ReportPayOut
	 * criteria OR not
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/payrollProcessDepartmentList", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getAllDepartments(@RequestParam("companyId") String companyId,
			@RequestParam("processMonth") String processMonth, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDepartments : companyId" +companyId +"processMonth.."+processMonth);
		Long longCompanyId = Long.parseLong(companyId);
		List<Department> departmentList = payrollControlService.findAllDepartmentNotINReportPayOut(longCompanyId,
				processMonth);
		if (departmentList != null)
			return departmentAdaptor.databaseModelToUiDtoList(departmentList);
		else
			throw new ErrorHandling("Departments are not available in company");
	}

}
