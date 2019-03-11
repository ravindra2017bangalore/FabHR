package com.csipl.hrms.report.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.ExcelWriter;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.report.EsiInfoDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.adaptor.PayrollReportAdaptor;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.organization.DepartmentService;
import com.csipl.hrms.service.payroll.EpfService;
import com.csipl.hrms.service.payroll.EsicService;
import com.csipl.hrms.service.payroll.ReportPayOutService;

@RestController
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	ReportPayOutService reportPayOutService;

	@Autowired
	CompanyService companyService;
	@Autowired
	EsicService esicService;
	@Autowired
	EpfService epfService;
	@Autowired
	DepartmentService departmentService;

	PayrollReportAdaptor payrollReportAdaptor = new PayrollReportAdaptor();

	@RequestMapping(path = "/getReportPayoutExcel", method = RequestMethod.GET)
	public void reportPayout(@RequestParam("companyId") Long companyId, @RequestParam("deptId") String deptId,
			@RequestParam("processMonth") String processMonth, HttpServletRequest req, HttpServletResponse response)
			throws PayRollProcessException {
		logger.info(
				"reportPayout  : " + " : deptId " + deptId + "processMonth" + processMonth + "..companyId" + companyId);
		List<ReportPayOut> reportPayOutList = null;
		String deptName = null;
		if (deptId == null || deptId.equals(HrmsGlobalConstantUtil.NULL)) {
			reportPayOutList = reportPayOutService.findAllEmployeesPaysheet(companyId, processMonth);
		} else {
			System.out.println("else condition");
			Long departmentId = Long.parseLong(deptId);
			Department department = departmentService.findDepartment(departmentId);
			deptName = department.getDepartmentName();
			reportPayOutList = reportPayOutService.findEmployeesPaysheetBydept(companyId, departmentId, processMonth);
		}
		logger.info("reportPayout  : " + " : reportPayOutList " + reportPayOutList);
		try {
			String[] columns = { "Particulars", "Employee Code", "Bank Name", "Account Number", "Date Of Joining",
					"Basic", "DA", "Conveyance Allowance", "Employee HRA", "Medical Allowance", "Advance Bonus",
					"Special Allowance", "Company Benefits", "Other Allowance", "Total Gross Salary", "Absent",
					"Casual Leave", "Sick Leave", "Paid Leave", "Present", "Public Holiday", "Weekly Off",
					"Payable Days", "Basic", "DA", "Conveyance Allowance", "Employee HRA", "Medical Allowance ",
					"Advance Bonus", "Special Allowance", "Company Benefits", "Other Allowance", "Total Gross Salary",
					"Loan & Advance ", "Other Deduction", "Provident Fund", "ESI 1.75%", "PT", "TDS",
					"Total Deductions", "Net Amount" };
			// response.setContentType("application/vnd.ms-excel");
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=PayrollReport.xlsx");

			Workbook workbook = ExcelWriter.payoutReport(reportPayOutList, columns, processMonth, deptName);
			ServletOutputStream fileOut = response.getOutputStream();

			workbook.write(fileOut);

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/esicExelReport", method = RequestMethod.GET)
	public void generate(@RequestParam("companyId") String companyId, @RequestParam("processMonth") String processMonth,
			HttpServletRequest req, HttpServletResponse response) throws ErrorHandling, PayRollProcessException {
		logger.info("generate  : " + " : processMonth " + processMonth + "companyId.." + companyId);
		Long longcompanyId = Long.parseLong(companyId);
		String[] columns = { "Sr No", "Employee Code", "ESIC Number", "Employee Name", "Father Name", "Nominee",
				"Relation with Nominee", "Date Of Birth", "Gender", "Date Of Joining", "Present Days", "Gross salary",
				" Earn Gross Salary", "ESIC DED" };
		List<Object[]> esicReportList = reportPayOutService.findEmployeesESIPayOutReport(longcompanyId, processMonth);
		List<ReportPayOutDTO> reportPayOutList = payrollReportAdaptor.objectListToESICReport(esicReportList);
		logger.info("generate  : " + " : reportPayOutList " + reportPayOutList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=esiReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);
				Esi esi = esicService.getESI(longcompanyId);
				if (company != null && esi != null && reportPayOutList != null && reportPayOutList.size() > 0) {
					Workbook workbook = ExcelWriter.esiReport(reportPayOutList, columns, processMonth, company, esi);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				} else {
					throw new ErrorHandling("Comapny and Esi data not available");
				}
			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/epfExelReport", method = RequestMethod.GET)
	public void epfReportPayout(@RequestParam("companyId") String companyId,
			@RequestParam("processMonth") String processMonth, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException {
		logger.info("epfReportPayout  : " + " : processMonth " + processMonth + "companyId.." + companyId);
		String[] columns = { "Sr No", "Employee Code", "UAN No", " Name OF Employee", "Father's Name", "Nominee",
				"Relation with Nominee", "Date Of Birth", "Gender", "EPF JOINING", "MARRIED/UNMARRIED", "Bank ac/no",
				"IFSC Code", "AADHAR No", "PAN NO", "MOBILE NO", "EMAIL ID", "GROSS SALARY RATE", "BASIC SALARY RATE",
				"ALLOWANCE RATE", "PRESENT DAYS", "ABSENT DAYS", " EARN GROSS SALARY", "EARN BASIC SALARY",
				" EARN ALLOWANCE", "PENSION SALARY", "12% PF DEDUCTION" };
		Long longcompanyId = Long.parseLong(companyId);
		System.out.println("processMonth : " + processMonth + "....");
		List<Object[]> epfReportList = reportPayOutService.findEsiEpfReport(processMonth, longcompanyId);
		List<ReportPayOutDTO> reportPayOutList = payrollReportAdaptor.objectListToEpfReport(epfReportList);
		logger.info("epfReportPayout  : " + " : reportPayOut List " + reportPayOutList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=epfReport.xlsx");
			Company company = companyService.getCompany(longcompanyId);
			Epf epf = epfService.getEPF(longcompanyId);
			if (company != null && epf != null && reportPayOutList != null && reportPayOutList.size() > 0) {

				Workbook workbook = ExcelWriter.epfReport(reportPayOutList, columns, processMonth, company, epf);
				ServletOutputStream fileOut = response.getOutputStream();
				workbook.write(fileOut);
			} else {
				throw new ErrorHandling(HrmsGlobalConstantUtil.NULL);
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(path = "/getTrfReportExcel", method = RequestMethod.GET)
	public void trfReport(@RequestParam("deptId") String deptId, @RequestParam("processMonth") String processMonth,
			@RequestParam("companyId") String companyId, HttpServletRequest req, HttpServletResponse response)
			throws PayRollProcessException {
		logger.info("trfReport  : " + " : processMonth " + processMonth);
		Long longcompanyId = Long.parseLong(companyId);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		Map<Long, Department> hashMapReport = loadDepartmentsInMap(user.getCompany().getCompanyId());
		List<ReportPayOut> reportPayOutList = null;
		String deptName = null;

		if (deptId == null || deptId.equals(HrmsGlobalConstantUtil.NULL)) {

			reportPayOutList = reportPayOutService.findAllEmployeesPayOutReport(longcompanyId, processMonth);
		} else {
			Long departmentId = Long.parseLong(deptId);
			Department department = departmentService.findDepartment(departmentId);
			deptName = department.getDepartmentName();
			reportPayOutList = reportPayOutService.findEmployeesPayOutReport(departmentId, processMonth);
		}

		try {
			String[] columns = { "Employee name", "Emp Code", "Bank Name", "Account No", "Net Amount", "Month",
					"Department" };
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

			// response.setHeader("Content-Desposition",
			// "attechment;filename=TrfReport.xlsx");
			response.setHeader("Content-Disposition", "attachment; filename=TrfReport.xls");

			Workbook workbook = ExcelWriter.trfReport(reportPayOutList, columns, processMonth, deptName, hashMapReport);
			ServletOutputStream fileOut = response.getOutputStream();
			workbook.write(fileOut);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/salaryReconAlert", method = RequestMethod.GET)
	public @ResponseBody EsiInfoDTO validatePayrollProcess(HttpServletRequest req) throws ErrorHandling {
		System.out.println("validatePayrollProcess controller");
		throw new ErrorHandling("message");

	}

	private Map<Long, Department> loadDepartmentsInMap(Long companyId) {
		List<Department> departments = departmentService.findAllDepartment(companyId);
		Map<Long, Department> departmentMap = new HashMap<Long, Department>();

		for (Department department : departments) {

			departmentMap.put(department.getDepartmentId(), department);
		}
		return departmentMap;
	}
}
