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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.EmployeeExcelWriter;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.EmployeeReportAdaptor;
import com.csipl.hrms.service.report.EmployeeReportService;

@RequestMapping("/employeesReport")
@RestController
public class EmployeeReportController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeReportController.class);
	@Autowired
	EmployeeReportService employeeReportService;

	EmployeeReportAdaptor employeeReportAdaptor = new EmployeeReportAdaptor();

	@RequestMapping(value = "/{companyId}/{status}", method = RequestMethod.GET)
	public void generate(@PathVariable("companyId") String companyId, @PathVariable("status") String status,
			HttpServletRequest req, HttpServletResponse response) throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		logger.info("generate     employees");
		String[] columns = { "Employee Code", "First Name", "Middle  Name", "Last Name", "Date Of Birth", "Gender",
				"Date Of Joining", "Marital Status", "Plot/Steet/Area", "Landmark", "Country", "State", "City",
				"Pin Code", "Mobile No", "Telephone", "Email", "Plot/Steet/Area", "Landmark", "Country", "State",
				"City", "Pin Code", "Mobile No", "Telephone", "Email", "Job Location", "Job State", "Blood Group",
				"Probation days", "Emp Type", "Department", "Designation", "Contract Over date", "Reference Name",
				"Aadhar Card No", "Pan Card No", "PF No", "UAN", "ESI No", "Account Type", "Bank name", "Account No",
				"IFSC Code", "Basic Salary", "Dearness Allowance", "House Rent Allowance", "Conveyance Allowance",
				"Special Allowance", "Medical Allowance", "Advance Bonus", "Performance Linked Income",
				"Company Benefits", "Leave Travel Allowance", "Uniform Allowance" };

		String[] columns1 = { "Employee Code", "First Name", "Middle  Name", "Last Name", "Date Of Birth", "Gender",
				"Date Of Joining", "Date Of Resignation", "Marital Status", "Plot/Steet/Area", "Landmark", "Country",
				"State", "City", "Pin Code", "Mobile No", "Telephone", "Email", "Plot/Steet/Area", "Landmark",
				"Country", "State", "City", "Pin Code", "Mobile No", "Telephone", "Email", "Job Location", "Job State",
				"Blood Group", "Probation days", "Emp Type", "Department", "Designation", "Contract Over date",
				"Reference Name", "Aadhar Card No", "Pan Card No", "PF No", "UAN", "ESI No", "Account Type",
				"Bank name", "Account No", "IFSC Code", "Basic Salary", "Dearness Allowance", "House Rent Allowance",
				"Conveyance Allowance", "Special Allowance", "Medical Allowance", "Advance Bonus",
				"Performance Linked Income", "Company Benefits", "Leave Travel Allowance", "Uniform Allowance" };

		response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment;filename=employeesReport.xlsx");
		Workbook workbook;

		List<Employee> employeeList = employeeReportService.findEmployeesReportStatusBased(status, longcompanyId);
		for (Employee employee2 : employeeList) {
			employee2.setGenderValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(),
					employee2.getGender()));
			employee2.setMaritalStatusValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(), employee2.getMaritalStatus()));
			employee2.setBloodGroupValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.BloodGroup.getDropDownName(), employee2.getBloodGroup()));
			employee2.setEmpTypeValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.EmploymentType.getDropDownName(), employee2.getEmpType()));

			for (EmployeeBank employeeBank : employee2.getEmployeeBanks()) {
				if (employeeBank.getAccountType().equals("SA")) {
					employee2.setAccountTypeValue(DropDownCache.getInstance().getDropDownValue(
							DropDownEnum.AccountType.getDropDownName(), employeeBank.getAccountType()));
					employee2.setBankNameValue(DropDownCache.getInstance()
							.getDropDownValue(DropDownEnum.BankName.getDropDownName(), employeeBank.getBankId()));
				}

			}
		}

		try {
			if (status.equals("AC"))
				workbook = EmployeeExcelWriter.employeeReport(columns, employeeList, status);
			else
				workbook = EmployeeExcelWriter.employeeReport(columns1, employeeList, status);
			ServletOutputStream fileOut = response.getOutputStream();
			workbook.write(fileOut);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/dept/{companyId}/{fromDate}/{toDate}/{deptId}/{status}", method = RequestMethod.GET)
	public void employeeReportDeptBased(@PathVariable("companyId") String companyId,
			@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate,
			@PathVariable("deptId") String deptId, @PathVariable("status") String status, HttpServletRequest req,
			HttpServletResponse response) throws ErrorHandling, PayRollProcessException, ParseException {
		Long longcompanyId = Long.parseLong(companyId);
		logger.info("employeeReportDeptBased      employees");

		String[] columns = { "Employee Code", "First Name", "Middle  Name", "Last Name", "Date Of Birth", "Gender",
				"Date Of Joining", "Marital Status", "Plot/Steet/Area", "Landmark", "Country", "State", "City",
				"Pin Code", "Mobile No", "Telephone", "Email", "Plot/Steet/Area", "Landmark", "Country", "State",
				"City", "Pin Code", "Mobile No", "Telephone", "Email", "Job Location", "Job State", "Blood Group",
				"Probation days", "Emp Type", "Department", "Designation", "Contract Over date", "Reference Name",
				"Aadhar Card No", "Pan Card No", "PF No", "UAN", "ESI No", "Account Type", "Bank name", "Account No",
				"IFSC Code", "Basic Salary", "Dearness Allowance", "House Rent Allowance", "Conveyance Allowance",
				"Special Allowance", "Medical Allowance", "Advance Bonus", "Performance Linked Income",
				"Company Benefits", "Leave Travel Allowance", "Uniform Allowance" };

		String[] columns1 = { "Employee Code", "First Name", "Middle  Name", "Last Name", "Date Of Birth", "Gender",
				"Date Of Joining", "Date Of Resignation", "Marital Status", "Plot/Steet/Area", "Landmark", "Country",
				"State", "City", "Pin Code", "Mobile No", "Telephone", "Email", "Plot/Steet/Area", "Landmark",
				"Country", "State", "City", "Pin Code", "Mobile No", "Telephone", "Email", "Job Location", "Job State",
				"Blood Group", "Probation days", "Emp Type", "Department", "Designation", "Contract Over date",
				"Reference Name", "Aadhar Card No", "Pan Card No", "PF No", "UAN", "ESI No", "Account Type",
				"Bank name", "Account No", "IFSC Code", "Basic Salary", "Dearness Allowance", "House Rent Allowance",
				"Conveyance Allowance", "Special Allowance", "Medical Allowance", "Advance Bonus",
				"Performance Linked Income", "Company Benefits", "Leave Travel Allowance", "Uniform Allowance" };

		response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment;filename=employeesReport.xlsx");
		Workbook workbook;

		DateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy ");
		Date fromDate1 = inputFormat.parse(fromDate);
		Date toDate1 = inputFormat.parse(toDate);
		Long departmentId = Long.parseLong(deptId);

		List<Employee> employeeList = employeeReportService.findEmployeesReportDeptAndStatusBased(longcompanyId,
				fromDate1, toDate1, departmentId, status);

		for (Employee employee2 : employeeList) {
			employee2.setGenderValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(),
					employee2.getGender()));
			employee2.setMaritalStatusValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(), employee2.getMaritalStatus()));
			employee2.setBloodGroupValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.BloodGroup.getDropDownName(), employee2.getBloodGroup()));
			employee2.setEmpTypeValue(DropDownCache.getInstance()
					.getDropDownValue(DropDownEnum.EmploymentType.getDropDownName(), employee2.getEmpType()));

			for (EmployeeBank employeeBank : employee2.getEmployeeBanks()) {
				if (employeeBank.getAccountType().equals("SA")) {
					employee2.setAccountTypeValue(DropDownCache.getInstance().getDropDownValue(
							DropDownEnum.AccountType.getDropDownName(), employeeBank.getAccountType()));
					employee2.setBankNameValue(DropDownCache.getInstance()
							.getDropDownValue(DropDownEnum.BankName.getDropDownName(), employeeBank.getBankId()));
				}

			}
		}

		try {
			if (status.equals("AC"))
				workbook = EmployeeExcelWriter.employeeReport(columns, employeeList, status);
			else
				workbook = EmployeeExcelWriter.employeeReport(columns1, employeeList, status);
			ServletOutputStream fileOut = response.getOutputStream();
			workbook.write(fileOut);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}