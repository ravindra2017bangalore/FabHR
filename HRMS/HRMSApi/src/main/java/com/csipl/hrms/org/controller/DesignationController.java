package com.csipl.hrms.org.controller;

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
import com.csipl.hrms.dto.organisation.DesignationDTO;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.DesignationAdaptor;
import com.csipl.hrms.service.organization.DesignationService;

@RestController
@RequestMapping("designation")
public class DesignationController  {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DesignationController.class);
	@Autowired
	DesignationService designationService;

	DesignationAdaptor designationAdaptor = new DesignationAdaptor();

	/**
	 * @param designationDto
	 *            This is the first parameter for getting designation Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveDesignation(@RequestBody DesignationDTO designationDto, HttpServletRequest req) {
		logger.info("saveDesignation is calling : "+" : DesignationDTO "+designationDto);
		Designation designation = designationAdaptor.uiDtoToDatabaseModel(designationDto);
		/*boolean newFlag = designation != null && designation.getDesignationId() != null ? false : true;
		editLogInfo(designation, newFlag, req);*/
		logger.info("saveDesignation is end  :" + "Designation" + designation);
		designationService.save(designation);
	}
	/**
	 * to get all designations List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<DesignationDTO> getAllDesignations(@RequestParam("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDesignations is calling : companyId"+companyId);
		Long longcompanyId = Long.parseLong(companyId);
		List<Designation> designationList = designationService.findAllDesignation( longcompanyId );
		if (designationList != null && designationList.size() > 0) {
			logger.info("getAllDesignations is end  :" + "designationList" + designationList);
			return designationAdaptor.databaseModelToUiDtoList(designationList);}
		throw new ErrorHandling("Designation data not present");
	}
	/**
	 * to get all designations List from database based on companyId and departmentId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/{departmentId}/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<DesignationDTO> designationList(@PathVariable("departmentId") String departmentId,@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDesignations is calling : "+":departmentId"+departmentId +"...companyId.."+companyId);
		Long deptId = Long.parseLong(departmentId);
		Long longcompanyId = Long.parseLong(companyId);
		List<Designation> designationList = designationService.designationListBasedOnDepartmnt(longcompanyId,deptId);
		if (designationList != null && designationList.size() > 0)
			return designationAdaptor.databaseModelToUiDtoList(designationList);
		throw new ErrorHandling("Designation data not present");
	}
}
