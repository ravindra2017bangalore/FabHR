package com.csipl.hrms.employee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.employee.KraDTO;
import com.csipl.hrms.model.employee.Kra;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.KraAdaptor;
import com.csipl.hrms.service.employee.KraService;

@RestController
public class KraController extends BaseController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(KraController.class);
	@Autowired
	KraService kraService;

	KraAdaptor kraAdaptor = new KraAdaptor();

	/**
 	 * @param kraDto
	 *            This is the first parameter for getting Kra Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(path = "/kras", method = RequestMethod.POST)
	public void saveKra(@RequestBody KraDTO kraDto, HttpServletRequest req) {
		Kra kra = kraAdaptor.uiDtoToDatabaseModel(kraDto);
		setUserProfile(kra, req);
		kraService.save(kra);
	}
	/**
	 * to get List of Kra from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/kras", method = RequestMethod.GET)
	public @ResponseBody List<KraDTO> getAllKras(HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		List<Kra> KraList = kraService.findAllKra(getCompanyId(req));
		if (KraList != null && KraList.size() > 0)
			return kraAdaptor.databaseModelToUiDtoList(KraList);
		else
			throw new ErrorHandling("KRA data not present");
	}
	/**
	 * to get  Kra Object from database based on KraId (Primary Key)
	 */
	@RequestMapping(path = "/getKra", method = RequestMethod.GET)
	public @ResponseBody KraDTO getKra(@RequestParam("kraId") String kraId) {
		Long longKraId = Long.parseLong(kraId);
		return kraAdaptor.databaseModelToUiDto(kraService.findKra(longKraId));
	}
}
