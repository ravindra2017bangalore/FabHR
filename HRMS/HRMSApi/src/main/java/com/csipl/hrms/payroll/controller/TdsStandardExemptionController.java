package com.csipl.hrms.payroll.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.csipl.hrms.dto.payroll.TdsStandardExemptionDTO;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.BonusAdaptor;
import com.csipl.hrms.service.adaptor.TdsStandardExemptionAdaptor;
import com.csipl.hrms.service.payroll.FinancialYearService;
import com.csipl.hrms.service.payroll.TdsStandardExemptionService;

@RequestMapping("/tdsStandardExemption")
@RestController
public class TdsStandardExemptionController {

	@Autowired
	FinancialYearService financialYearService;

	@Autowired
	TdsStandardExemptionService tdsStandardExemptionService;

	TdsStandardExemptionAdaptor tdsStandardExemptionAdaptor = new TdsStandardExemptionAdaptor();
	BonusAdaptor bonusAdaptor = new BonusAdaptor();

	@RequestMapping(method = RequestMethod.POST)
	public void saveTdsStandardExemption(@RequestBody TdsStandardExemptionDTO tdsStandardExemptionDto,
			HttpServletRequest req) throws ErrorHandling {
		TdsStandardExemption tdsStandardExemption = tdsStandardExemptionAdaptor
				.uiDtoToDatabaseModel(tdsStandardExemptionDto);
		// boolean newFlag = tdsStandardExemption == null ||
		// tdsStandardExemption.getTdsStandardExemptionId() == null;
		// editLogInfoWithoutGroup(tdsStandardExemption, newFlag, req);
		tdsStandardExemptionService.save(tdsStandardExemption);
	}

	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TdsStandardExemptionDTO> findAllTdsStandardExemption(@PathVariable("companyId") Long companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		List<TdsStandardExemption> tdsStandardExemptionList = tdsStandardExemptionService
				.getAllTdsStandardExemptionList(companyId);
		if (tdsStandardExemptionList != null)
			return tdsStandardExemptionAdaptor.databaseModelToUiDtoList(
					tdsStandardExemptionService.getAllTdsStandardExemptionList(companyId));
		else
			throw new ErrorHandling("Tds standard exemptions not present");
	}
}
