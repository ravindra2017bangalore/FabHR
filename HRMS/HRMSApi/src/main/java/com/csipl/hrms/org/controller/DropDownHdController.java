package com.csipl.hrms.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.DropDownHdService;
import com.csipl.hrms.dto.organisation.DropDownHdDTO;
import com.csipl.hrms.service.adaptor.DropDownHdAdaptor;

@RestController
public class DropDownHdController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DropDownHdController.class);
	boolean status = false;

	DropDownHdAdaptor dropDownHdAdaptor = new DropDownHdAdaptor();

	@Autowired
	DropDownHdService dropDownHdService;

	/**
	 * Method performed fetch operation , fetch data from Enum table
	 */
	@RequestMapping(path = "/dropdown", method = RequestMethod.GET)
	public @ResponseBody List<DropDownHdDTO> findAllDropdowns(HttpServletRequest req) {
		List<DropDownHdDTO> dropdownHdDtoList = null;
		try {
			List<DrowpdownHd> dropdownHdDto = dropDownHdService.getAllDropDowns();
			dropdownHdDtoList = dropDownHdAdaptor.databaseModelToUiDtoList(dropdownHdDto);

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}
		return dropdownHdDtoList;
	}
	
	
	@RequestMapping(path = "/dropdownID", method = RequestMethod.GET)
	public @ResponseBody DropDownHdDTO findDropDownById(@RequestParam("dropdownID") String dropdownID,HttpServletRequest req) {
		DropDownHdDTO dropdownHdDto = null;
		Long dropdownId=Long.parseLong(dropdownID);
		try {
			DrowpdownHd  dropdownHd = dropDownHdService.findDropDownById(dropdownId);
			dropdownHdDto= dropDownHdAdaptor.databaseModelToUiDto(dropdownHd);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}
		return dropdownHdDto;
	}

}
