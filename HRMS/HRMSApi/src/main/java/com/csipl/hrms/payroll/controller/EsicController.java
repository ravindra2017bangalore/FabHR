package com.csipl.hrms.payroll.controller;

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
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.payroll.EsiDTO;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.org.controller.WelcomeController;
import com.csipl.hrms.service.adaptor.EsicAdaptor;
import com.csipl.hrms.service.payroll.EsicService;

@RequestMapping("/esic")
@RestController
public class EsicController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EsicController.class);
	EsicAdaptor esicAdaptor = new EsicAdaptor();
	boolean status = false;

	@Autowired
	EsicService esicService;

	/**
	 * @param esiDTO
	 *            This is the first parameter for getting epf Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void EsicSave(@RequestBody EsiDTO esiDTO, HttpServletRequest req) {
		logger.info("EsicSave is calling" + esiDTO);
		Esi esic = esicAdaptor.uiDtoToDatabaseModel(esiDTO);
		// boolean newFlag= esic == null || esic.getEsiId() == null;
		// editLogInfo(esic, newFlag, req);
		esicService.save(esic);
	}

	/**
	 * to get Esi Object from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody EsiDTO findESIC(@PathVariable("companyId") Long companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		logger.info("findESIC is calling");
		Esi esi = esicService.getESI(companyId);
		if (esi != null)
			return esicAdaptor.databaseModelToUiDto(esicService.getESI(companyId));
		else {
			logger.info("Esi data not present");
			throw new ErrorHandling("Esi data not present");
		}
	}

}
