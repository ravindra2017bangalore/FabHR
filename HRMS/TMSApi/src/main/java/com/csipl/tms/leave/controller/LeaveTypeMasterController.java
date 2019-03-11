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

import com.csipl.tms.dto.leave.TMSLeaveTypeMasterDTO;
import com.csipl.tms.leave.adaptor.LeaveTypeMasterAdaptor;
import com.csipl.tms.leave.service.LeaveTypeMasterService;
import com.csipl.tms.model.leave.TMSLeaveTypeMaster;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/leaveTypeMaster")
@Api(description = "Operations pertaining to leave Type master in Time Management")

public class LeaveTypeMasterController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeMasterController.class);
	
	@Autowired
	LeaveTypeMasterService leaveTypeMasterService;
	
	LeaveTypeMasterAdaptor  leaveTypeMasterAdaptor=new LeaveTypeMasterAdaptor();
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Shift"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update shift"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param shiftDto
	 *            This is the first parameter for getting shift Object from UI
	 */
	@ApiOperation(value = "Save or Update TMSLeaveTypeMaster")
	@RequestMapping(method = RequestMethod.POST)
	public void saveLeaveTypeMaster(@RequestBody TMSLeaveTypeMasterDTO leaveTypeMasterDTO) {
		logger.info("saveLeaveTypeMaster is calling : " + " : leavePeriodDTO " + leaveTypeMasterDTO);
		TMSLeaveTypeMaster leaveTypeMaster = leaveTypeMasterAdaptor.uiDtoToDatabaseModel(leaveTypeMasterDTO);
		logger.info("saveLeaveTypeMaster is end  :" + "leaveTypeMaster" + leaveTypeMaster);
		leaveTypeMasterService.save(leaveTypeMaster);
	}
	
	

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Shift List"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 */
	@ApiOperation(value = "View List of TMSLeaveTypeMaster based on company ID")
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public List<TMSLeaveTypeMasterDTO> leaveTypeMasterList(@PathVariable("companyId") Long companyId) {
		logger.info("leaveTypeMasterList is calling : " + " : companyId " + companyId);
		//Long companyID = Long.parseLong(companyId);
		List<TMSLeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterService.findAllLeaveTypeMaster(companyId);
		List<TMSLeaveTypeMasterDTO> leaveTypeMasterDtoList = leaveTypeMasterAdaptor.databaseModelToUiDtoList(leaveTypeMasterList);
		logger.info("leaveTypeMasterList is end  :" + "leaveTypeMasterDtoList" + leaveTypeMasterDtoList);
		return leaveTypeMasterDtoList;
	}
}
