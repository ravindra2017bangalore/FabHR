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
import com.csipl.hrms.dto.payroll.BonusDTO;
import com.csipl.hrms.dto.payroll.FinancialYearDTO;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.BonusAdaptor;
import com.csipl.hrms.service.payroll.BonusService;
import com.csipl.hrms.service.payroll.FinancialYearService;

@RequestMapping("/bonus")
@RestController
public class BonusController  {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(BonusController.class);

	BonusAdaptor bonusAdaptor = new BonusAdaptor();

	@Autowired
	BonusService bonusService;

	@Autowired
	FinancialYearService financialYearService;

	/**
	 * @param bonusDto
	 *            This is the first parameter for getting bonus Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveBonus(@RequestBody BonusDTO bonusDto, HttpServletRequest req) throws ErrorHandling {

		Bonus bonus = bonusAdaptor.uiDtoToDatabaseModel(bonusDto);
		/*boolean newFlag = bonus == null || bonus.getBonusId() == null;
		editLogInfo(bonus, newFlag, req);*/

		if (bonus.getBonusId() == null) {
			if (bonusService.getBonus(bonus.getFinancialYear(), bonus.getGrade(), bonus.getActiveStatus(),
					bonus.getCompany().getCompanyId()) == null) {

				bonusService.save(bonus);
			} else {
				logger.info(" saveBonus data already present");
				throw new ErrorHandling("Bonus data for this financial year and grade is already present");
			}
		} else {
			bonusService.save(bonus);

		}
	}

	/**
	 * to get List of bonus objects from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<BonusDTO> findAllBonus(@PathVariable("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		logger.info("findAllBonus  is calling:");
		Long longcompanyId = Long.parseLong(companyId);

		return bonusAdaptor.databaseModelToUiDtoList(bonusService.getAllBonus(longcompanyId));
	}

	/**
	 * to get List of FinancialYear objects from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/investmentFinancialYears/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<FinancialYearDTO> findAllFinancialYear(@PathVariable("companyId") String companyId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("findAllFinancialYear  is calling :");
		Long longcompanyId = Long.parseLong(companyId);
		List<FinancialYear> financialYearList = financialYearService.findAllFinancialYear(longcompanyId);
		return bonusAdaptor.financialYearToFinancialYearDtoList(financialYearList);
	}
}
