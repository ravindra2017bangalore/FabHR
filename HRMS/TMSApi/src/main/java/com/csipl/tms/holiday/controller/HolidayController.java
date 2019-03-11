package com.csipl.tms.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.holiday.adaptor.HolidayAdaptor;
import com.csipl.tms.holiday.service.HolidayService;
import com.csipl.tms.model.holiday.TMSHolidays;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/holidays")
@RestController
@Api(description = "Operations pertaining to Holiday in Time Management")
public class HolidayController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(HolidayController.class);
	@Autowired
	HolidayService holidayService;
	HolidayAdaptor holidayAdaptor = new HolidayAdaptor();

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Holiday"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update Holiday"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param holidayDto
	 *            This is the first parameter for getting holiday Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	
	@ApiOperation(value = "Save or Update Holiday")
	@RequestMapping(value = "/{leavePeriodId}",method = RequestMethod.POST)
	public void save(@RequestBody HolidayDTO holidayDto,@PathVariable("leavePeriodId") Long leavePeriodId, HttpServletRequest req) {
		logger.info("saveHoliday is calling : " + " : HolidayDTO " + holidayDto);
		TMSHolidays holiday = holidayAdaptor.holidayuiDtoToDatabaseModel(holidayDto,leavePeriodId);
		logger.info("saveHoliday is end  :" + "Holiday" + holiday);
		holidayService.save(holiday);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Holiday Object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param holidayId
	 *            This is the first parameter for getting holidayId from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */

	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@ApiOperation(value = "View List of holiday based on company ID")
	@RequestMapping(value = "/findAll/{companyId}", method = RequestMethod.GET)
	public List<HolidayDTO> holidayList(@PathVariable("companyId") String companyId, HttpServletRequest req) {
		logger.info("holidayList is calling : " + " : companyId " + companyId);
		Long companyID = Long.parseLong(companyId);
		List<TMSHolidays> holidayList = holidayService.findAllHoliday(companyID);
		System.out.println("================holidayList===============" + holidayList);
		List<HolidayDTO> holidayDtoList = holidayAdaptor.databaseModelToUiDtoList(holidayList);
		logger.info("holidayList is end  :" + "holidayList" + holidayDtoList);
		return holidayDtoList;
	}

	@ApiOperation(value = "View a holiday Based on holiday ID")
	@RequestMapping(value = "/hloiday/{holidayId}", method = RequestMethod.GET)
	public HolidayDTO findHoliday(@PathVariable("holidayId") String holidayId, HttpServletRequest req) {
		logger.info("findHoliday is calling : " + " :" + "....holidayId.." + holidayId);
		Long holidayID = Long.parseLong(holidayId);
		TMSHolidays holiday = holidayService.findHoliday(holidayID);
		HolidayDTO holidayDto = holidayAdaptor.databaseModelToUiDto(holiday);
		logger.info("findHoliday is end  :" + "holidayDto.." + holidayDto);
		return holidayDto;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 * @param req
	 *            This is the second parameter for getting current year
	 */
	@ApiOperation(value = "get count  of holiday based on company ID and current year")
	@RequestMapping(value = "/count/{companyId}", method = RequestMethod.GET)
	public HolidayDTO holidayCount(@PathVariable("companyId") String companyId, HttpServletRequest req) {
		logger.info("holidaycount is calling : " + " : companyId " + companyId);
		Long companyID = Long.parseLong(companyId);
		HolidayDTO holidayCount = holidayService.holidayCount(companyID);
		return holidayCount;
	}
	
	@ApiOperation(value = "get List  of holiday based on company ID and current month")
	@RequestMapping(value = "/monthlyHoliday/{companyId}", method = RequestMethod.GET)
	public List<HolidayDTO> monthlyHolidayList(@PathVariable("companyId") String companyId, HttpServletRequest req) {
		logger.info("MonthlyholidayList is calling : " + " : companyId " + companyId);
		Long companyID = Long.parseLong(companyId);
		List<TMSHolidays> TMSHolidaysList = holidayService.monthlyHolidayList(companyID);
		List<HolidayDTO> monthHolidayList=holidayAdaptor.holidayModelToholidayDtoList(TMSHolidaysList);
		System.out.println(monthHolidayList);
		return monthHolidayList;
	}
	
	
	@ApiOperation(value = "View List of holiday based on company ID")
	@RequestMapping(value = "findAllHolydays/{leavePeriodId}", method = RequestMethod.GET)
	public List<HolidayDTO> findAllHolydays(@PathVariable("leavePeriodId") Long leavePeriodId, HttpServletRequest req) {
		logger.info("leavePeroidList is calling : " + " : leavePeriodId " + leavePeriodId);
	//	Long companyID = Long.parseLong(leavePeriodId);
		List<TMSHolidays> holidayList = holidayService.findAllLeavePeriod(leavePeriodId);
		System.out.println("================holidayList===============" + holidayList);
		List<HolidayDTO> holidayDtoList = holidayAdaptor.databaseModelToUiDtoList(holidayList);
		logger.info("holidayList is end  :" + "holidayList" + holidayDtoList);
		return holidayDtoList;
	}

}