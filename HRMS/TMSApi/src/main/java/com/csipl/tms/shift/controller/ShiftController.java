package com.csipl.tms.shift.controller;

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

import com.csipl.tms.dto.shift.ShiftDTO;
import com.csipl.tms.model.shift.Shift;
import com.csipl.tms.shift.adaptor.ShiftAdaptor;
import com.csipl.tms.shift.service.ShiftService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/shift")
@Api(description = "Operations pertaining to Shift Schedule in Time Management")
public class ShiftController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ShiftController.class);
	@Autowired
	ShiftService shiftService;

	ShiftAdaptor shiftAdaptor = new ShiftAdaptor();
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Shift"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update shift"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param shiftDto
	 *            This is the first parameter for getting shift Object from UI
	 */
	@ApiOperation(value = "Save or Update Shift")
	@RequestMapping(method = RequestMethod.POST)
	public void saveShift(@RequestBody ShiftDTO shiftDto) {
		logger.info("saveShift is calling : " + " : ShiftDTO " + shiftDto);
		Shift shift = shiftAdaptor.uiDtoToDatabaseModel(shiftDto);
		logger.info("saveShift is end  :" + "Shift" + shift);
		shiftService.save(shift);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Shift List"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 */
	@ApiOperation(value = "View List of shift based on company ID")
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public List<ShiftDTO> shiftList(@PathVariable("companyId") Long companyId) {
		logger.info("shiftList is calling : " + " : companyId " + companyId);
		//Long companyID = Long.parseLong(companyId);
		List<Shift> shiftList = shiftService.findAllShift(companyId);
		List<ShiftDTO> shiftDtoList = shiftAdaptor.databaseModelToUiDtoList(shiftList);
		logger.info("shiftList is end  :" + "shiftDtoList" + shiftDtoList);
		return shiftDtoList;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved shift object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param shiftId
	 *            This is the first parameter for getting shiftId from UI
	 */
	@ApiOperation(value = "View a leave Based on shift ID")
	@RequestMapping(path = "/shiftId/{shiftId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ShiftDTO findshift(@PathVariable(value = "shiftId") String shiftId) {
		logger.info("shiftList is calling : " + " :" + "....shiftId.." + shiftId);

		Long shiftID = Long.parseLong(shiftId);
		Shift shift = shiftService.findShift(shiftID);
		ShiftDTO shiftDto = shiftAdaptor.databaseModelToUiDto(shift);
		logger.info("shiftList is end  :" + "shiftDto.." + shiftDto);
		return shiftDto;
	}
}
