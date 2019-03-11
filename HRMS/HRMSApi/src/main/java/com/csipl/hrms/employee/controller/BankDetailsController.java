package com.csipl.hrms.employee.controller;

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
import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.service.adaptor.BankDetailsAdaptor;
import com.csipl.hrms.service.adaptor.MandatoryInfoCheckAdaptor;
import com.csipl.hrms.service.employee.BankDetailsService;
import com.csipl.hrms.service.organization.MandatoryInfoCheckService;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;

@RestController
@RequestMapping("/bankDetails")
public class BankDetailsController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(BankDetailsController.class);

	BankDetailsAdaptor bankDetailsAdaptor = new BankDetailsAdaptor();
	MandatoryInfoCheckAdaptor mandatoryInfoCheckAdaptor = new MandatoryInfoCheckAdaptor();
	@Autowired
	BankDetailsService bankDetailsService;
	@Autowired
	MandatoryInfoCheckService mandatoryInfoCheckService;
	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;

	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param bankDetailsDtoList
	 *            This is the second parameter for getting EmployeeBank Object from
	 *            UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value="/{empId}",method = RequestMethod.POST)
	public List<BankDetailsDTO> saveAll(@PathVariable("empId") String empId,
			@RequestBody List<BankDetailsDTO> bankDetailsDtoList, HttpServletRequest req) {
		Long employeeId = Long.parseLong(empId);
		logger.info("BankDetailsController save empId is :" + empId + "bankDetailsDtoList" + bankDetailsDtoList);
		List<EmployeeBank> employeeBankList = bankDetailsAdaptor.empUiDtoToDatabaseModelList(bankDetailsDtoList,
				employeeId);
		// employeeBankList.forEach(employeeBank -> {
		// boolean newFlag =employeeBank!=null && employeeBank.getEmployeeBankId() !=
		// null ? false : true;
		// editLogInfoWithoutCG(employeeBank, newFlag, req);
		// });
		return bankDetailsAdaptor.databaseModelToUiDtoList(bankDetailsService.saveAll(employeeBankList));
	}

	/**
	 * to get List of Banks from database based on employeeId
	 */
	@RequestMapping(value="/{empId}", method = RequestMethod.GET)
	public @ResponseBody List<BankDetailsDTO> findAllBankDetails(@PathVariable("empId") String empId,
			HttpServletRequest req) {
		logger.info("findAllBankDetails is calling :" + "employeeId" + empId);
		return bankDetailsAdaptor.databaseModelToUiDtoList(bankDetailsService.findAllBankDetails(empId));
	}

	/**
	 * delete Employee bank from database based on bankId (primary key)
	 */
	@RequestMapping( method = RequestMethod.DELETE)
	public void deleteEmp(@RequestParam("employeeBankId") String employeeBankId, HttpServletRequest req) {
		logger.info("deleteEmp is calling :" + "employeeBankId" + employeeBankId);
		Long empBankId = Long.parseLong(employeeBankId);
		bankDetailsService.delete(empBankId);
	}

}
