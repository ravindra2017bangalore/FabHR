package com.csipl.tms.rules.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.tms.dto.halfdayrule.HalfDayRuleDTO;
import com.csipl.tms.dto.rules.LeaveRuleDTO;
import com.csipl.tms.dto.rules.SandWichRuleDTO;
import com.csipl.tms.halfdayrule.adaptor.HalfDayRuleAdaptor;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.rules.LeaveRule;
import com.csipl.tms.model.rules.SandWichRule;
import com.csipl.tms.rules.adaptor.LeaveRulesAdaptor;
import com.csipl.tms.rules.adaptor.SandWichRuleAdaptor;
import com.csipl.tms.rules.service.RulesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description = "Operations pertaining to Rules in Time Management")
@RequestMapping("/rules")
public class RulesController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(RulesController.class);
	@Autowired
	RulesService rulesService;

	SandWichRuleAdaptor sandWichRuleAdaptor = new SandWichRuleAdaptor();
	HalfDayRuleAdaptor halfDayRuleAdaptor = new HalfDayRuleAdaptor();
	LeaveRulesAdaptor leaveRulesAdaptor = new LeaveRulesAdaptor();
 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a sandwich rule based on companyId ")
	@RequestMapping(value = "/sandwich/{companyId}", method = RequestMethod.GET)
	public @ResponseBody SandWichRuleDTO getSandwich(@PathVariable("companyId") Long companyId) {
		logger.info("getSandwich is end  companyId>>:" + companyId);
		return sandWichRuleAdaptor.databaseModelToUiDto(rulesService.getSandwich(companyId));
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "Save or update sandwich rule")
	@RequestMapping(value = "/sandwich", method = RequestMethod.POST)
	public void saveSandwich(@RequestBody SandWichRuleDTO sandWichRuleDTO) {
		logger.info("saveSandwich is calling :  sandWichRuleDTO>>" + sandWichRuleDTO.toString());
		SandWichRule sandWichRule = sandWichRuleAdaptor.uiDtoToDatabaseModel(sandWichRuleDTO);
		rulesService.save(sandWichRule);
		logger.info("saveSandwich is end  :" + sandWichRule);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "Save or update halfdayrule")
	@RequestMapping(value = "/halfday", method = RequestMethod.POST)
	public void save(@RequestBody HalfDayRuleDTO halfDayRuleDto) {
		logger.info("savehalfDayRuleDto is calling : " + " : halfDayRuleDto " + halfDayRuleDto);
		HalfDayRule halfDayRule = halfDayRuleAdaptor.uiDtoToDatabaseModel(halfDayRuleDto);
		logger.info("HalfDayRule  : " + halfDayRule);
		rulesService.save(halfDayRule);
		logger.info("saveHalfDayRule is end  :" + halfDayRule);
	}

	/**
	 * to get HalfDayRule List from database based on companyId
	 * 
	 * @param companyId
	 * @throws ErrorHandling
	 */

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a halfdayrule based on companyId ")
	@RequestMapping(value = "/halfday/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HalfDayRuleDTO getHalfDayRule(@PathVariable("companyId") Long companyId) throws ErrorHandling {
		logger.info("getHalfDayRule is calling : ");
		HalfDayRule halfDayRule = rulesService.getHalfDayRule(companyId);
		logger.info("getHalfDayRule is end  :" + halfDayRule);
		if (halfDayRule != null)
			return halfDayRuleAdaptor.databaseModelToUiDto(halfDayRule);
		else
			throw new ErrorHandling("halfdayrule not found");
	}

	/**
	 * to get leaveRule from database based on leaveRuleId
	 */

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a leaveRule based on leaveRuleId ")
	@RequestMapping(value = "/leave/{leaveRuleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LeaveRuleDTO getLeaveRule(@PathVariable("leaveRuleId") Long leaveRuleId) {
		logger.info("getLeaveRule is calling : ");
		LeaveRule leaveRule = rulesService.getLeaveRule(leaveRuleId);
		logger.info("getHalfDayRule is end  :" + leaveRule.toString());
		return leaveRulesAdaptor.databaseModelToUiDto(leaveRule);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a leaveRule based on companyId ")
	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	public List<LeaveRuleDTO> shiftList(@RequestParam("companyId") Long companyId) {
		logger.info("shiftList is calling : " + " : companyId " + companyId);
		List<LeaveRule> shiftList = rulesService.getLeaveRuleList(companyId);
		List<LeaveRuleDTO> shiftDtoList = leaveRulesAdaptor.databaseModelToUiDtoList(shiftList);
		logger.info("shiftList is end  : shiftDtoList" + shiftDtoList);
		return shiftDtoList;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "Save or update leaveRule")
	@RequestMapping(value = "/leave", method = RequestMethod.POST)
	public void saveLeaveRule(@RequestBody LeaveRuleDTO leaveRuleDto) {
		logger.info("saveLeaveRule is calling : " + " : leaveRuleDTO " + leaveRuleDto);
		LeaveRule leaveRule = leaveRulesAdaptor.uiDtoToDatabaseModel(leaveRuleDto);
		logger.info("saveLeaveRule is end  : leaveRule" + leaveRule);
		rulesService.save(leaveRule);
	}

}
