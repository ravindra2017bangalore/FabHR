package com.csipl.hrms.payroll.controller;

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
import com.csipl.hrms.dto.payroll.OvertimeDTO;
import com.csipl.hrms.model.payroll.Overtime;
import com.csipl.hrms.service.adaptor.OvertimeAdaptor;
import com.csipl.hrms.service.payroll.OvertimeService;

@RequestMapping("/overtime")
@RestController
public class OvertimeController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(OvertimeController.class);
	OvertimeAdaptor overtimeAdaptor = new OvertimeAdaptor();

	@Autowired
	OvertimeService overtimeService;

	/**
	 * @param overtimeDto
	 *            This is the first parameter for getting overtime object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void overtime(@RequestBody OvertimeDTO overtimeDto, HttpServletRequest req) {
		logger.info("overtime is calling : OvertimeDTO " + overtimeDto);
		Overtime overtime = overtimeAdaptor.uiDtoToDatabaseModel(overtimeDto);
		/*
		 * boolean newFlag = overtime.getOvertimeId() != null ? false : true;
		 * editLogInfo(overtime, newFlag, req);
		 */
		overtimeService.save(overtime);
	}

	/**
	 * to get List of overtime objects from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<OvertimeDTO> findAllOvertimeMethod(@PathVariable("companyId") Long companyId,
			HttpServletRequest req) throws PayRollProcessException {
		return overtimeAdaptor.databaseModelToUiDtoList(overtimeService.getAllOvertimeMethods(companyId));
	}
}
