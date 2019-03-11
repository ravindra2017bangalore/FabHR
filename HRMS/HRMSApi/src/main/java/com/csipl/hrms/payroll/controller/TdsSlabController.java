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
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.payroll.TdsSlabHdDTO;
import com.csipl.hrms.model.payroll.TdsSlabHd;
import com.csipl.hrms.service.adaptor.TdsSlabAdaptor;
import com.csipl.hrms.service.payroll.TdsSlabService;

@RequestMapping("/tdsSlab")
@RestController
public class TdsSlabController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(TdsSlabController.class);
	@Autowired
	TdsSlabService tdsSlabService;

	TdsSlabAdaptor tdsSlabAdaptor = new TdsSlabAdaptor();

	/**
	 * @param tdsSlabHdDto
	 *            This is the first parameter for getting TdsSlabHd Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping( method = RequestMethod.POST)
	public void saveTdsSlabHd(@RequestBody TdsSlabHdDTO tdsSlabHdDto, HttpServletRequest req) {
		logger.info("saveTdsSlabHd is calling" + tdsSlabHdDto);
		TdsSlabHd tdsSlabHd = tdsSlabAdaptor.uiDtoToDatabaseModel(tdsSlabHdDto);
		// boolean newFlag= tdsSlabHd == null || tdsSlabHd.getTdsSLabHdId() == null;
		// editLogInfo(tdsSlabHd, newFlag, req);
		// for (TdsSlab tdsSlab : tdsSlabHd.getTdsSlabs()) {
		// //tdsSlab.setTdsSLabId(null);
		// //boolean newFlag1= tdsSlab == null || tdsSlab.getTdsSLabId() == null;
		// //editLogInfoWithoutCG(tdsSlab, newFlag1, req);
		// }
		logger.info("saveTdsSlabHd is end" + tdsSlabHd);
		tdsSlabHd = tdsSlabService.save(tdsSlabHd);
	}

	/**
	 * to get List of TdsSlabHd objects from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TdsSlabHdDTO> findAllTdsSlabList(@PathVariable("companyId") Long companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllTdsSlabList : companyId " + companyId);
		List<TdsSlabHd> tdsSlabHdList = tdsSlabService.getAllTdsSlabHd(companyId);
		if (tdsSlabHdList != null && tdsSlabHdList.size() > 0) {
			return tdsSlabAdaptor.databaseModelToUiDtoList(tdsSlabHdList);
		} else {
			throw new ErrorHandling("Tds List Not Available");
		}
	}

}
