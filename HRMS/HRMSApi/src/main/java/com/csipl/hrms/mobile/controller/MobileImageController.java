package com.csipl.hrms.mobile.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormatSymbols;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.payroll.controller.SalaryPdfController;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.organization.CompanyService;


@RestController
public class MobileImageController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(MobileImageController.class);
	@Autowired
	CompanyService companyService;
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	
	@RequestMapping(path = "/mobileImage", method = RequestMethod.GET)
	public 		ResponseEntity<ByteArrayResource> mobileImageApp(@RequestParam("employeeId") String employeeId,
			 @RequestParam("companyId") String companyId, HttpServletResponse response)
			throws Exception {
		  System.out.println("======employeeId======"+employeeId+"====companyId==="+companyId);
		Employee employee = null;
		//City city = null;
		Long companyID = Long.parseLong(companyId);
		Long empID = Long.parseLong(employeeId);
		//response.setContentType("application/pdf");
		//response.setHeader("Content-Disposition", "attachment; filename=\"employeeSalarySlip.pdf\"");
		
			//company = companyService.getCompany(companyID);
			employee = employeePersonalInformationService.findEmployeesById(empID);
			System.out.println("employee..."+employee.getEmployeeLogoPath());
			String path =employee.getEmployeeLogoPath();
			String rootPath = System.getProperty("catalina.home");
			rootPath = rootPath + File.separator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.separator + path;
		logger.info("rootPath :"+rootPath);
	//	ByteArrayOutputStream out = new ByteArrayOutputStream();
		File imagefile = new File(rootPath);
		
		  byte[] bytesArray = new byte[(int) imagefile.length()]; 
          System.out.println("======bytesArray.size...======"+bytesArray.length);
		  FileInputStream fis = new FileInputStream(imagefile);
		  fis.read(bytesArray); //read file into bytes[]
		  fis.close();
					
		 
		return ResponseEntity
		        .ok()
		        .contentLength(bytesArray.length)
		        .body(new ByteArrayResource(bytesArray));
	}
	


	
}
