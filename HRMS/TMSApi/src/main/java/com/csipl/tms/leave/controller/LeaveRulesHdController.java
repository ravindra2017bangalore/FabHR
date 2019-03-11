package com.csipl.tms.leave.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.tms.dto.leave.TMSLeaveRulesHdDTO;
import com.csipl.tms.leave.adaptor.LeaveRulesHdAdaptor;
import com.csipl.tms.leave.service.LeaveRulesHdService;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/leaveRulesHd")
@RestController
@Api(description = "Operations pertaining to Leave RulesHd in Time Management")
public class LeaveRulesHdController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LeaveRulesHdController.class);
	
	@Autowired
	LeaveRulesHdService leaveRulesHdService;
	
	LeaveRulesHdAdaptor leaveRulesHdAdaptor=new LeaveRulesHdAdaptor();
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved or update"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update the resource"),
			@ApiResponse(code = 403, message = "You were trying to save resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param leaveRulesHdDTO
	 *            This is the first parameter for getting leaveRulesHd Object from UI
	 */
	@ApiOperation(value = "Save or Update LeaveRulesHd")
	@RequestMapping(path = "/{leavePeriodId}",method = RequestMethod.POST)
	public TMSLeaveRulesHdDTO saveLeaveRulesHd(@RequestBody TMSLeaveRulesHdDTO leaveRulesHdDTO,@PathVariable("leavePeriodId") Long leavePeriodId) {
		
		logger.info("saveLeaveRulesHd is calling : leaveRulesHdDTO " + leaveRulesHdDTO);
		TMSLeaveRulesHd leaveRulesHd = leaveRulesHdAdaptor.leaveuiDtoToDatabaseModel(leaveRulesHdDTO,leavePeriodId);
		return leaveRulesHdAdaptor.databaseModelToUiDto(leaveRulesHdService.save(leaveRulesHd));
}
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	

	@ApiOperation(value = "View List of leaveTypes based on company ID")
	@RequestMapping(path = "/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<TMSLeaveRulesHdDTO> getleaveRulesHdList(@PathVariable("companyId") Long companyId)
			throws PayRollProcessException, ErrorHandling {
		logger.info(" getleaveTypeList is calling companyId >>:" + companyId);
		List<TMSLeaveRulesHd> leaveRulesHd = leaveRulesHdService.findAllLeaveRulesHd(companyId);
		if (leaveRulesHd != null)
		{    
			List<TMSLeaveRulesHdDTO> leaveTypeHdDTO =leaveRulesHdAdaptor.databaseModelToUiDtoList(leaveRulesHd);
			 return leaveTypeHdDTO;
		}
			
		else
			throw new ErrorHandling("Leave List not");
	}
	
	

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	

	@ApiOperation(value = "View List of getleavePeriodAll based on company ID")
	@RequestMapping(path = "leavePeriod/{leavePeriodId}",method = RequestMethod.GET)
	public @ResponseBody List<TMSLeaveRulesHdDTO> getleavePeriodAll(@PathVariable("leavePeriodId") Long leavePeriodId)
			throws PayRollProcessException, ErrorHandling {
		logger.info(" getleavePeriodAll LeavePeriod is calling companyId >>:" + leavePeriodId);
		//List<TMSLeaveRulesHd> leaveRulesHd = leaveRulesHdService.findAllLeaveRulesHd(leavePeriodId);
			List<TMSLeaveRulesHdDTO> leaveTypeHdDTO =leaveRulesHdAdaptor.databaseModelToUiDtoList(leaveRulesHdService.findAllLeaveRulesHd(leavePeriodId));
			 return leaveTypeHdDTO;
	
	}
}