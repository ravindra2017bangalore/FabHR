package com.csipl.tms.leave.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.tms.dto.leave.TMSLeavePeriodDTO;
import com.csipl.tms.leave.adaptor.LeavePeriodAdaptor;
import com.csipl.tms.leave.service.LeavePeriodService;
import com.csipl.tms.model.leave.TMSLeavePeriod;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/leavePeriod")
@Api(description = "Operations pertaining to leave period in Time Management")
public class LeavePeriodController {
	
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LeavePeriodController.class);
	
	@Autowired
	LeavePeriodService leavePeriodService;
	
	LeavePeriodAdaptor leavePeriodAdaptor=new LeavePeriodAdaptor();
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Shift"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update shift"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param shiftDto
	 *            This is the first parameter for getting shift Object from UI
	 */
	@ApiOperation(value = "Save or Update leavePeriod")
	@RequestMapping(method = RequestMethod.POST)
	public TMSLeavePeriodDTO saveLeavePeriod(@RequestBody TMSLeavePeriodDTO leavePeriodDTO) {
		logger.info("saveLeavePeriod is calling : " + " : leavePeriodDTO " + leavePeriodDTO);
		TMSLeavePeriod leavePeriod = leavePeriodAdaptor.uiDtoToDatabaseModel(leavePeriodDTO);
		logger.info("saveLeavePeriod is end  :" + "leavePeriod" + leavePeriod);
		return leavePeriodAdaptor.databaseModelToUiDto(leavePeriodService.save(leavePeriod));
	}

	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Shift List"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 */
	@ApiOperation(value = "View List of leavePeriod based on company ID")
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public List<TMSLeavePeriodDTO> leavePeriodList(@PathVariable("companyId") Long companyId) {
		logger.info("leavePeriodList is calling : " + " : companyId " + companyId);
		//Long companyID = Long.parseLong(companyId);
		List<TMSLeavePeriod> leavePeriodList = leavePeriodService.findAllLeavePeriod(companyId);
		List<TMSLeavePeriodDTO> leavePeriodDtoList = leavePeriodAdaptor.databaseModelToUiDtoList(leavePeriodList);
		logger.info("leavePeriodList is end  :" + "shiftDtoList" + leavePeriodDtoList);
		return leavePeriodDtoList;
	}
	
	@ApiOperation(value = "View List avtive status of leave status based on company ID")
	@RequestMapping(value="status/{companyId}",method = RequestMethod.GET)
	public List<TMSLeavePeriodDTO> leavePeriodStatusList(@PathVariable("companyId") Long companyId) {
		logger.info("leavePeriodList is calling : " + " : companyId " + companyId);
		//Long companyID = Long.parseLong(companyId);
		List<TMSLeavePeriod> leavePeriodList = leavePeriodService.findleavePeriodStatus(companyId);
		List<TMSLeavePeriodDTO> leavePeriodDtoList = leavePeriodAdaptor.databaseModelToUiDtoList(leavePeriodList);
		logger.info("leavePeriodList is end  :" + "shiftDtoList" + leavePeriodDtoList);
		return leavePeriodDtoList;
	}
	
}
