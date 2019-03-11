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
import com.csipl.hrms.dto.payroll.CorpBankDTO;
import com.csipl.hrms.model.payroll.Bank;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.org.controller.WelcomeController;
import com.csipl.hrms.service.adaptor.CorpBankAdaptor;
import com.csipl.hrms.service.payroll.CorpBankService;

@RequestMapping("/bank")
@RestController
public class CorpBankController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CorpBankController.class);
	CorpBankAdaptor corpBankAdaptor = new CorpBankAdaptor();

	@Autowired
	CorpBankService corpBankService;
	/**
	 * @param corpBankDto
	 *            This is the first parameter for getting corpBank Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void corpBank(@RequestBody CorpBankDTO corpBankDto, HttpServletRequest req) {
		logger.info("corpBank is is calling :"+corpBankDto);
		Bank bank = corpBankAdaptor.uiDtoToDatabaseModel(corpBankDto);
		corpBankService.save(bank);
	}
	/**
	 * to get all banks List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<CorpBankDTO> findAllBanks(@PathVariable("companyId") Long companyId,HttpServletRequest req) throws PayRollProcessException {
		logger.info("findAllBanks is is calling :");
		return corpBankAdaptor.databaseModelToUiDtoList(corpBankService.getAllBanks(companyId));
	}
}
