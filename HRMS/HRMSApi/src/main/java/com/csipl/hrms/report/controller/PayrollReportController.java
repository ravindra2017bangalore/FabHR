package com.csipl.hrms.report.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;

import com.csipl.hrms.common.util.PayrollExelWriter;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.payrollprocess.ReportSummaryDTO;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.model.common.Company;

import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.PayrollReportAdaptor;
import com.csipl.hrms.service.organization.CompanyService;

import com.csipl.hrms.service.report.EmployeeReportService;
import com.csipl.hrms.service.report.PayrollReportService;

@RequestMapping("/report")
@RestController
public class PayrollReportController {
	@Autowired
	PayrollReportService payrollReportService;
	@Autowired
	CompanyService companyService;
	@Autowired
	EmployeeReportService employeeReportService;

	PayrollReportAdaptor payrollReportAdaptor = new PayrollReportAdaptor();

	@RequestMapping(path = "/proTaxReport/{companyId}/{fromProcessMonth}/{toProcessMonth}/{deptId}/{employeeId}/{stateId}", method = RequestMethod.GET)
	public void generatePTReport(@PathVariable("companyId") String companyId,
			@PathVariable("fromProcessMonth") String fromProcessMonth,
			@PathVariable("toProcessMonth") String toProcessMonth, @PathVariable("deptId") String deptId,
			@PathVariable("employeeId") String employeeId, @PathVariable("stateId") String stateId,
			HttpServletRequest req, HttpServletResponse response) throws ErrorHandling, PayRollProcessException {
		// logger.info("generate : "+" : processMonth "+ processMonth );
		System.out.println("PayrollReportController");
		Long empId = Long.parseLong(employeeId);
		Long departmentId = Long.parseLong(deptId);
		Long stateID = Long.parseLong(stateId);
		Long longcompanyId = Long.parseLong(companyId);
		String[] columns = { "Employee Code", "Employee Name", "Department", "Designation", "Amount", "Process Month",
				"State" };
		List<Object[]> PTReportList = payrollReportService.findPTReport(longcompanyId, fromProcessMonth, toProcessMonth,
				departmentId, empId, stateID);
		// List<Object[]>
		// PTReportList=payrollReportService.findPTReport(getCompanyId(req), "JAN-2018",
		// "JUN-2018" ,4l ,"" ,13l);
		// System.out.println(PTReportList);
		List<ReportPayOutDTO> reportPayoutList = payrollReportAdaptor.objectListToReportPayoutList(PTReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=professionalTaxReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null) {
					Workbook workbook = PayrollExelWriter.PTReport(reportPayoutList, columns, company, fromProcessMonth,
							toProcessMonth);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}
				/*
				 * else { throw new ErrorHandling("Comapny and Esi data not available"); }
				 */
			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/provisionReport/{companyId}/{fromDate}/{toDate}/{deptId}", method = RequestMethod.GET)
	public void generateProvisionReport(@PathVariable("companyId") String companyId,
			@PathVariable("fromDate") String fromdate, @PathVariable("toDate") String todate,
			@PathVariable("deptId") String deptId, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, ParseException {
		// logger.info("generate : "+" : processMonth "+ processMonth );
		System.out.println("generateProvisionReport" + "fromdate.." + fromdate + "..toDate..." + todate);
		String[] columns = { "Employee name", "Employee Code", "Bank Name", "Account No", "Net Amount", "Salary hold",
				"Department" };

		DateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy ");
		Date fromDate = inputFormat.parse(fromdate);
		Date toDate = inputFormat.parse(todate);
		System.out.println(fromDate);
		System.out.println(toDate);
		Long departmentId = Long.parseLong(deptId);
		Long longcompanyId = Long.parseLong(companyId);
		List<Object[]> provisionReportList = payrollReportService.findProvisionReport(longcompanyId, fromDate, toDate,
				departmentId);

		List<ReportPayOutDTO> reportPayoutDtoList = payrollReportAdaptor
				.objectListToProvisionReportList(provisionReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=provisionReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null && reportPayoutDtoList.size() > 0) {
					System.out.println("fromDate" + fromDate + "TDate" + toDate);
					Workbook workbook = PayrollExelWriter.provisionReport(reportPayoutDtoList, columns, fromDate,
							toDate, company, departmentId);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}

			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/payrollRegReport/{companyId}/{deptId}/{processMonth}", method = RequestMethod.GET)
	public void generatePayrollMonthlyReport(@PathVariable("companyId") String companyId,
			@PathVariable("deptId") String deptId, @PathVariable("processMonth") String processMonth,
			HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, ParseException {

		String[] columns = { "Particulars", "Employee Number", "Bank Name", "Account Number", "Date Of Joining",
				"Basic", "DA", "Conveyance Allowance", "Employee HRA", "Medical Allowance", "AdvanceBonus",
				"Special Allowance", "CompanyBenefits", "Other Allowance", "Total Gross Salary", "Absent",
				"Casual Leave", "Sick Leave", "Paid Leave", "Present", "Public Holiday", "Weekely Off",
				/* "OVERTIME", */"Payable Days", "Basic", "DA", "Conveyance Allowance", "Employee HRA",
				"Medical Allowance", "Advance Bonus", "Special Allowance", "Company Benefits", "Other Allowance",
				"Total Earnings", "Employee Loans & Advance A/C", "Provident Fund", "ESIC 1.75%", "PT", "TDS",
				"Total Deductions", "Net Amount" };

		// Department department =null;

		Long departmentId = Long.parseLong(deptId);
		Long longcompanyId = Long.parseLong(companyId);

		List<Object[]> monthlyReportList = payrollReportService.findPayrollReportByMonth(longcompanyId, departmentId,
				processMonth);

		List<ReportPayOutDTO> reportPayoutDtoList = payrollReportAdaptor
				.objectListToMonthlyReportList(monthlyReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=payrollReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null /* && reportPayoutDtoList.size()>0 */) {
					Workbook workbook = PayrollExelWriter.payrollMonthlyReport(reportPayoutDtoList, columns,
							processMonth, company, departmentId);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}

			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/payrollEmpReport/{companyId}/{fromProcessMonth}/{toProcessMonth}/{empId}", method = RequestMethod.GET)
	public void generatePayrollEmployeeReport(@PathVariable("companyId") String companyId,
			@PathVariable("fromProcessMonth") String fromProcessMonth,
			@PathVariable("toProcessMonth") String toProcessMonth, @PathVariable("empId") String empId,
			HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, ParseException {
		Long longcompanyId = Long.parseLong(companyId);
		System.out.println(("empploye based payroll Report controller"));
		String[] columns = { "Process Month", "Particulars", "Employee Number", "Bank Name", "Account Number",
				"Date Of Joining", "Basic", "DA", "Conveyance Allowance", "Employee HRA", "Medical Allowance",
				"AdvanceBonus", "Special Allowance", "CompanyBenefits", "Other Allowance", "Total Gross Salary",
				"Absent", "Casual Leave", "Sick Leave", "Paid Leave", "Present", "Public Holiday", "Weekely Off",
				/* "OVERTIME", */"Payable Days", "Basic", "DA", "Conveyance Allowance", "Employee HRA",
				"Medical Allowance", "Advance Bonus", "Special Allowance", "Company Benefits", "Other Allowance",
				"Total Earnings", "Employee Loans & Advance A/C", "Provident Fund", "ESIC 1.75%", "PT", "TDS",
				"Total Deductions", "Net Amount" };

		Long employeeId = Long.parseLong(empId);

		List<Object[]> monthlyReportList = payrollReportService.findPayrollReportByempId(longcompanyId, employeeId,
				fromProcessMonth, toProcessMonth);

		List<ReportPayOutDTO> reportPayoutDtoList = payrollReportAdaptor
				.objectListToEmpMonthlyReportList(monthlyReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=payrollEmployeeReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null && reportPayoutDtoList.size() > 0) {
					Workbook workbook = PayrollExelWriter.payrollMonthlyReportByEmpId(reportPayoutDtoList, columns,
							fromProcessMonth, toProcessMonth, company);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}

			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/bankReport/{companyId}/{processMonth}/{bankName}", method = RequestMethod.GET)
	public void generateBankReport(@PathVariable("companyId") String companyId,
			@PathVariable("processMonth") String processMonth, @PathVariable("bankName") String bankName,
			HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, InvalidFormatException, IOException {
		System.out.println("generateBankReport processMonth" + processMonth + "bankName>>" + bankName);
		Long longcompanyId = Long.parseLong(companyId);
		String[] columns = { "Employee Name", "Employee Code", "Bank Name", "Account No", "Net Amount", "Department" };
		List<Object[]> bankTRFReportList = payrollReportService.findPayRollBankTRF(longcompanyId, processMonth,
				bankName);
		List<ReportPayOutDTO> reportPayOutDtoList = payrollReportAdaptor.objectListToBankReportList(bankTRFReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=bankReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);
				if (company != null /* && esi!=null && reportPayOutList!=null && reportPayOutList.size()>0 */) {
					Workbook workbook = PayrollExelWriter.bankReport(reportPayOutDtoList, columns, company,
							processMonth);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}
			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/reconciliationReport/{companyId}/{departmentId}/{processMonth}/{isReco}", method = RequestMethod.GET)
	public void generateRecoSummryReport(@PathVariable("companyId") String companyId,
			@PathVariable("departmentId") String departmentId, @PathVariable("processMonth") String processMonth,
			@PathVariable("isReco") String isReco, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, InvalidFormatException, IOException {
		System.out.println("generateRecoSummryReport processMonth" + processMonth + "departmentId>>" + departmentId);
		String[] columns = { "Employee Code", "Employee Name", "Bank Name", "Account No", "Net Amount",
				"Reconciliation Date", "Transaction No" };

		String[] columns1 = { "Employee Code", "Employee Name", "Department Name", "Bank Name", "Account No",
				"Net Amount", "Reconciliation Date", "Transaction No" };

		Long longDeptId = Long.parseLong(departmentId);
		Long longcompanyId = Long.parseLong(companyId);

		List<Object[]> recoReportList = null;
		String checkReco = null;
		String status = null;
		if (isReco.equals("RC")) {
			checkReco = "false";

		} else {
			checkReco = "true";

		}

		// Long count=
		// payrollReportService.checkForRecoReprotAvailability(longDeptId,processMonth,checkReco);
		// if(count>0) {
		recoReportList = payrollReportService.findReconciliationReport(longcompanyId, longDeptId, processMonth,
				checkReco);
		// }

		List<ReportPayOutDTO> reportPayOutDtoList = payrollReportAdaptor.objectListToRecoReportList(recoReportList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

			if (checkReco.equals("true"))
				response.setHeader("Content-Disposition", "attachment;filename=non-recoReport.xlsx");
			else
				response.setHeader("Content-Disposition", "attachment;filename=recoReport.xlsx");

			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);
				if (company != null) {
					Workbook workbook;
					if (longDeptId == 0)
						workbook = PayrollExelWriter.reconciliationReport(reportPayOutDtoList, columns, company,
								processMonth, checkReco, longDeptId);
					else
						workbook = PayrollExelWriter.reconciliationReport(reportPayOutDtoList, columns1, company,
								processMonth, checkReco, longDeptId);

					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}
			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/epfEcrReport/{companyId}/{processMonth}", method = RequestMethod.GET)
	public void generateEPF_ECRReport(@PathVariable("companyId") String companyId,
			@PathVariable("processMonth") String processMonth, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, ParseException {

		String[] columns = { "UAN", "Member Name", "Gross_Wages", "EPF_Wages", "EPS_Wages", "EDLI_Wages",
				"EPF_CONTRI_REMITTED", "EPS_CONTRI_REMITTED", "EPF_EPS_Diff_Remitted", "NCP_Days",
				"Refund_Of_Advances" };

		// Department department =null;

		// Long departmentId =Long.parseLong(deptId);
		Long longcompanyId = Long.parseLong(companyId);
		List<Object[]> EpfEcrList = payrollReportService.findEpfEcrReport(longcompanyId, processMonth);
		List<Object[]> EpfList = payrollReportService.findEpfReport(longcompanyId, processMonth);
		EmployeeReportDTO empDto = employeeReportService.countEMPIMPTODAYDATE(longcompanyId, " ");
		List<ReportPayOutDTO> reportPayoutDtoList = payrollReportAdaptor.objectListToEpfEcrReportList(EpfEcrList);
		ReportSummaryDTO reportSummary = payrollReportAdaptor.objectListToReportSummary(EpfList);
		System.out.println(reportSummary.getEpfExcludedEmpCount() + "...." + reportSummary.getEpfExcludedGrassSum());
		System.out.println("employeeReportDTO.getEmpCount" + empDto.getEmpCount());
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=epfEcrReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null /* && reportPayoutDtoList.size()>0 */) {
					Workbook workbook = PayrollExelWriter.payrollEpfEcrReport(reportPayoutDtoList, columns,
							processMonth, company, empDto.getEmpCount(), reportSummary);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}

			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/esicEcrReport/{companyId}/{processMonth}", method = RequestMethod.GET)
	public void generateECI_ECRReport(@PathVariable("companyId") String companyId,
			@PathVariable("processMonth") String processMonth, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, PayRollProcessException, ParseException {
		Long longcompanyId = Long.parseLong(companyId);
		String[] columns = { "IP Number", "IP Name", "No of days", "Total Monthly Wages",
				"Reason Code for Zero workings days(numeric only; provide 0 for all other reasons)",
				"Last Working Day ( Format DD/MM/YYYY  or DD-MM-YYYY)" };

		List<Object[]> EsiEcrList = payrollReportService.findEsicEcrReport(longcompanyId, processMonth);
		List<Object[]> EsiList = payrollReportService.findEsicReport(longcompanyId, processMonth);
		EmployeeReportDTO empDto = employeeReportService.countEMPIMPTODAYDATE(longcompanyId, " ");
		ReportSummaryDTO reportSummary = payrollReportAdaptor.objectListToReportSummary(EsiList);
		List<ReportPayOutDTO> reportPayoutDtoList = payrollReportAdaptor.objectListToEsiEcrReportList(EsiEcrList);
		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=esicEcrReport.xlsx");
			if (longcompanyId != null) {
				Company company = companyService.getCompany(longcompanyId);

				if (company != null && reportPayoutDtoList.size() > 0) {
					Workbook workbook = PayrollExelWriter.payrollEsicEcrReport(reportPayoutDtoList, columns,
							processMonth, company, empDto.getEmpCount(), reportSummary);
					ServletOutputStream fileOut = response.getOutputStream();
					workbook.write(fileOut);
				}

			} else
				throw new ErrorHandling("Invalid session .Please login again");
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
