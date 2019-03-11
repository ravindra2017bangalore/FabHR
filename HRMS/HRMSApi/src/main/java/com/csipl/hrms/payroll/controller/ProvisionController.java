package com.csipl.hrms.payroll.controller;

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
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.dto.payroll.EmpProvisionInfoDTO;
import com.csipl.hrms.dto.payroll.EmployeeCodeDTO;
import com.csipl.hrms.dto.payroll.ProvisionDTO;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payroll.Provision;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.DepartmentAdaptor;
import com.csipl.hrms.service.adaptor.EmployeePersonalInformationAdaptor;
import com.csipl.hrms.service.adaptor.ProvisionAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.organization.DepartmentService;
import com.csipl.hrms.service.payroll.ProvisionService;
import com.csipl.hrms.service.payroll.ReportPayOutService;

@RequestMapping("/provision")
@RestController
public class ProvisionController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProvisionController.class);
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	@Autowired
	ProvisionService provisionService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	ReportPayOutService reportPayOutService;
	EmployeePersonalInformationAdaptor employeePersonalInformationAdaptor = new EmployeePersonalInformationAdaptor();

	ProvisionAdaptor provisionAdaptor = new ProvisionAdaptor();

	DepartmentAdaptor deaprtmentAdaptor = new DepartmentAdaptor();
	/**
	 * to get List of EmployeeCode objects from database    
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/employeeCode/{companyId}/{departmentId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeCodeDTO> getAllEmployeeDetails(@PathVariable("companyId") String companyId,@PathVariable("departmentId") String departmentId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("departmntId--"+departmentId +"companyId--"+companyId);
 		Long DepartmentId = Long.parseLong(departmentId);
 		Long longCompanyId = Long.parseLong(companyId);
 		List<Employee> employeeList = employeePersonalInformationService.findAllEmpByDeptId(longCompanyId,
				DepartmentId);
        logger.info("employeeList--"+employeeList );
		return employeePersonalInformationAdaptor.employeeListToEmployeeCodeDto(employeeList);
	}
	/**
	 * @param provisionDto
	 *            This is the first parameter for getting provision Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody ProvisionDTO provisionDto, HttpServletRequest req) {
		 logger.info("provisionDto--"+provisionDto );
 		Provision provision = provisionAdaptor.uiDtoToDatabaseModel(provisionDto);
 		provisionService.save(provision);
 	}
	/**
	 * to get List of Provision objects from database    
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ProvisionDTO> getAllProvision(@RequestParam("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		 logger.info("getAllProvision is calling : companyId--"+companyId );
		Long companyID = Long.parseLong(companyId);
		List<Object[]> provisionList = provisionService.findAllProvision(companyID);
		 logger.info("getAllProvision is end calling : provisionList--"+provisionList );
		return provisionAdaptor.databaseObjectArrayToUiDtoList(provisionList);
	}
	/**
	 * to get List of Provision objects from database based on employeeId  
	 */
	@RequestMapping(path = "/employeeInfo/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<EmpProvisionInfoDTO> getEmployeeInfo(@PathVariable("employeeId") String empId,
			HttpServletRequest req) {
		logger.info("getEmployeeInfo is calling : employeeId--"+empId );
		Long employeeId = Long.parseLong(empId);
 		Employee employee = employeePersonalInformationService.findEmployeesById(employeeId);
		logger.info("getEmployeeInfo is calling : employee--"+employee );
 		return provisionAdaptor.databaseModelToEmpProvisionInfoDTOList(employee);
	}
	/**
	 * to get List of Provision objects from database    
	 */
	@RequestMapping(path = "/{provisionId}", method = RequestMethod.GET)
	public @ResponseBody ProvisionDTO getProvision(@PathVariable("provisionId") String provisionID,
			HttpServletRequest req) {
		logger.info("getProvision is calling : provisionId--"+provisionID );
		Long provisionId = Long.parseLong(provisionID);
		Provision provision = provisionService.findProvision(provisionId);
		return provisionAdaptor.databaseModelToUiDto(provision);
	}
	/**
	 * to get List of Department objects from database processMonth And companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/provisionDept/{companyId}/{processMonth}", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getDepartment(@PathVariable("processMonth") String processMonth,@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("getDepartment is calling : processMonth--"+processMonth +"companyId.."+companyId);
		Long longCompanyId = Long.parseLong(companyId);
 		List<Department> departmentList = departmentService.findDepartmentByProcessMonth(processMonth,
 				longCompanyId);
 		return deaprtmentAdaptor.databaseModelToUiDtoList(departmentList);
	}
	
/*	*//**
	 * to get List of Provision objects from database    
	 * @throws PayRollProcessException 
	 *//*
	@RequestMapping(path = "/provisionFNF", method = RequestMethod.POST)
	public @ResponseBody List<ProvisionDTO> getAllProvisionForFNF(@RequestBody List<ProvisionDTO> provisionDtoList,HttpServletRequest req) throws PayRollProcessException {
 		
		List<Object[]> provisionList = provisionService.findAllProvisionforFNF(getCompanyId(req),provisionDtoList);
		System.out.println(provisionList);
		return provisionAdaptor.databaseObjectArrayToProvisionList(provisionList);
	}*/
	
	/**
	 * to get List of Provision objects from database    
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/provisionForSettlement/{companyId}/{transactionNo}/{remarks}", method = RequestMethod.POST)
	public void  saveProvisionForSettlement(@PathVariable("transactionNo") String transactionNo,@PathVariable("remarks") String remarks,@PathVariable("companyId") String companyId,@RequestBody List<ProvisionDTO> provisionDtoList ,HttpServletRequest req) throws PayRollProcessException {
 		System.out.println("transactionNo"+transactionNo+"-------"+"remarks"+remarks+"--------"+"provisionDtoList"+provisionDtoList);
 		Long companyID = Long.parseLong(companyId);
 		for (ProvisionDTO provisionDto : provisionDtoList) {
 			Long provisionId = provisionDto.getProvisionId();
 			Provision provision = provisionService.findProvision(provisionId);
 			provision.setActiveStatus("DE");
 			provisionService.save(provision);
 			ReportPayOut reportPayout =reportPayOutService.findReportPayout(provisionDto.getEmployeeId(), provisionDto.getProcessMonth(), companyID);
		    reportPayout.setTransactionNo(transactionNo);
		    reportPayout.setRemarks(remarks);
		  reportPayOutService.saveReportPayout(reportPayout);
 		}
		
		
		
	}

}
