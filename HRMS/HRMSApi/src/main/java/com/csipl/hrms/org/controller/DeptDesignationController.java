package com.csipl.hrms.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.dto.organisation.DeptDesignationDTO;
import com.csipl.hrms.dto.organisation.DesignationDTO;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.DeptDesignation;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.service.adaptor.DepartmentAdaptor;
import com.csipl.hrms.service.adaptor.DeptDesignationAdaptor;
import com.csipl.hrms.service.adaptor.DesignationAdaptor;
import com.csipl.hrms.service.organization.DepartmentService;
import com.csipl.hrms.service.organization.DeptDesignationService;
import com.csipl.hrms.service.organization.DesignationService;

@RestController
public class DeptDesignationController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DeptDesignationController.class);
	
	@Autowired
	DeptDesignationService deptDesignationService;
	

	@Autowired
	DesignationService designationService;
	
	DeptDesignationAdaptor deptDesignationAdaptor = new DeptDesignationAdaptor();
	DesignationAdaptor designationAdaptor = new DesignationAdaptor();
	
	/**
	 * @param designationDto
	 *            This is the first parameter for getting designation Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/deptdesignation", method = RequestMethod.POST)
	public void saveDesignation(@RequestBody List<DeptDesignationDTO> deptDesignationDTO, HttpServletRequest req) {
		logger.info("saveDesignation is calling : "+" : deptDesignationDTO "+deptDesignationDTO);
		Long companyId  = null;
		Long departmentId =null;
		for (DeptDesignationDTO deptDesignationDto : deptDesignationDTO) {
			 departmentId = deptDesignationDto.getDepartmentId();
			companyId  = deptDesignationDto.getCompanyId();
		}
		List<DeptDesignation> deptbasedDesignationList= deptDesignationService.findAllDeptbasedDesignation( companyId , departmentId);
	    List<DeptDesignation> deptDesignationList = deptDesignationAdaptor.deptDesgDtoToDatabaseModelList(deptDesignationDTO,deptbasedDesignationList);
	    deptDesignationService.saveAll(deptDesignationList);
		
	}
	
	/**
	 * to get all departments List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/deptdesignation", method = RequestMethod.GET)
	public @ResponseBody List<DeptDesignationDTO> getAllDeptDesignation(@RequestParam("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDeptDesignation is calling :  " );
		Long longcompanyId = Long.parseLong(companyId);
		List<Object[]> deptDesignationList = deptDesignationService.findAllDeptDesignation( longcompanyId );
		logger.info("getAllDeptDesignation is end : Department Designation List " + deptDesignationList );
		if (deptDesignationList != null)
			return deptDesignationAdaptor.databaseObjectArrayToUiDtoList(deptDesignationList);
		else
			throw new ErrorHandling("Departments are not available in company");
	}
	
	/**
	 * to get all departments List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/deptdesignationList", method = RequestMethod.GET)
	public @ResponseBody List<DesignationDTO> getAllDeptBasedDesignation(@RequestParam("companyId") String companyId,@RequestParam("departmentId") String departmentId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDeptBasedDesignation is calling :  " );
		Long longcompanyId = Long.parseLong(companyId);
		Long departmentID = Long.parseLong(departmentId);
		 List<DeptDesignation> deptDesignationList= deptDesignationService.findAllDeptbasedDesignation( longcompanyId , departmentID);
		 List<Designation> designationList= designationService.findAllDesignation(longcompanyId);
		 List<DesignationDTO> designationDtoList= designationAdaptor.databaseModelToUiDtoList(designationList);
		logger.info("getAllDeptBasedDesignation is end : Department Designation List " + deptDesignationList );
		if (deptDesignationList != null)
			return deptDesignationAdaptor.deptDesignationToDesignationDtoList(deptDesignationList, designationDtoList);
		else
			throw new ErrorHandling("Departments are not available in company");
	}
}
