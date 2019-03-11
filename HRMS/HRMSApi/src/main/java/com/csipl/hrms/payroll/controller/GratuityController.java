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
import com.csipl.hrms.dto.payroll.GratuityDTO;
import com.csipl.hrms.model.payroll.Gratuaty;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.org.controller.WelcomeController;
import com.csipl.hrms.service.adaptor.GratuityAdaptor;
import com.csipl.hrms.service.payroll.GratuityService;

@RequestMapping("/gratuity")
@RestController
public class GratuityController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GratuityController.class);
	GratuityAdaptor gratuityAdaptor = new GratuityAdaptor();
	@Autowired
	GratuityService gratuityService;

	/**
	 * @param gratuityDto
	 *            This is the first parameter for getting epf Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveGratuaty(@RequestBody GratuityDTO gratuityDto, HttpServletRequest req) {
		logger.info("saveGratuaty is calling"+gratuityDto);
		Gratuaty gratuity = gratuityAdaptor.uiDtoToDatabaseModel(gratuityDto);
		gratuityService.save(gratuity);
	}
	/**
	 * to get List of gratuity Objects from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<GratuityDTO> findAllGratuity(@PathVariable("companyId") Long companyId,HttpServletRequest req) throws PayRollProcessException {
		logger.info("findAllGratuity is calling");
		return gratuityAdaptor.databaseModelToUiDtoList(gratuityService.getAllGratuity(companyId));
	}
}
