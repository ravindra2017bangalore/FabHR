package com.csipl.tms.weekoffpattern.controller;

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
import com.csipl.tms.dto.weekofpattern.WeekOffPatternDTO;
import com.csipl.tms.model.weekofpattern.WeekOffPattern;
import com.csipl.tms.weekoffpattern.adaptor.WeekOffPatternAdaptor;
import com.csipl.tms.weekoffpattern.service.WeekOffPatternService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/weekoffpattern")
@RestController
@Api(description = "Operations pertaining to Week_Off_Pattern in Time Management")
public class WeekOffPatternController {

	@Autowired
	WeekOffPatternService week_Off_PatternService;
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeekOffPatternController.class);

	WeekOffPatternAdaptor week_Off_PatternAdaptor = new WeekOffPatternAdaptor();

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "Save or update weekoffpattern")
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody WeekOffPatternDTO week_Off_PatternDto) {
		logger.info("saveWeekoffpattern is calling : " + " : Week_Off_Pattern " + week_Off_PatternDto);

		WeekOffPattern week_Off_Pattern = week_Off_PatternAdaptor.uiDtoToDatabaseModel(week_Off_PatternDto);
		logger.info("Week_Off_Pattern  : " + week_Off_Pattern);
		week_Off_PatternService.save(week_Off_Pattern);		
		logger.info("saveWeek_Off_Pattern is end  :" + week_Off_Pattern);
	}

	/**
	 * to get all weekoffpatterns List from database based on companyId
	 * 
	 * @param companyId
	 * @throws ErrorHandling
	 */

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a weekoffpattern based on companyId ")
	@RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<WeekOffPatternDTO> getAllWeekOffPattern(@PathVariable("companyId") Long companyId)throws ErrorHandling {
		logger.info("getAllWeekOffPattern is calling : ");
		List<WeekOffPattern> week_Off_PatternList = week_Off_PatternService.getAllWeekOffPattern(companyId);
		logger.info("getAllWeekOffPattern is end  :" + week_Off_PatternList);
		if (week_Off_PatternList != null)
			return week_Off_PatternAdaptor.databaseModelToUiDtoList(week_Off_PatternList);
		else
			throw new ErrorHandling("weekoffpattern not found");
	}


//	//**
//	 * to get weekoffpattern object from database based on patternId
//	 * 
//	 * @param patternId
//	 *//

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a weekoffpattern based on patternId ")
	@RequestMapping(value = "/weekoffId/{patternId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody WeekOffPatternDTO getWeekOffPattern(@PathVariable("patternId") Long patternId) {
		logger.info("getWeekOffPattern is calling : patternId =" + patternId);
		return week_Off_PatternAdaptor.databaseModelToUiDto(week_Off_PatternService.findOne(patternId));
	}

}
