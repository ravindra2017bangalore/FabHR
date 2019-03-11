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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.candidate.CandidateStatuaryDTO;
import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.service.adaptor.BankDetailsAdaptor;
import com.csipl.hrms.service.employee.BankDetailsService;
import com.csipl.hrms.service.employee.EmployeeStatuaryService;
import com.csipl.hrms.service.adaptor.EmpStatutoryBankAdaptor;
@RestController
@RequestMapping("/employeeBank")
public class EmpStatutoryBankController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpStatutoryBankController.class);
	
	@Autowired
	BankDetailsService bankDetailsService;
	
	@Autowired
	EmployeeStatuaryService employeeStatuaryService;
	
	EmpStatutoryBankAdaptor empStatutoryBankAdaptor = new EmpStatutoryBankAdaptor();
	

	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param bankDetailsDtoList
	 *            This is the second parameter for getting EmployeeBank Object from
	 *            UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value="/{employeeId}",method = RequestMethod.POST)
	public CandidateStatuaryDTO saveAll(@PathVariable("employeeId") String employeeId,
			@RequestBody CandidateStatuaryDTO candidateStatuaryDto, HttpServletRequest req) {
		Long empId = Long.parseLong(employeeId);
		logger.info("BankDetailsController save empId is :" + empId + "bankDetailsDtoList" + candidateStatuaryDto);
		EmployeeBank employeeBank = empStatutoryBankAdaptor.UiDtoToDatabaseModel(candidateStatuaryDto,
				empId);
		// employeeBankList.forEach(employeeBank -> {
		// boolean newFlag =employeeBank!=null && employeeBank.getEmployeeBankId() !=
		// null ? false : true;
		// editLogInfoWithoutCG(employeeBank, newFlag, req);
		// });
		List<EmployeeStatuary> employeeStatuaryList  = employeeStatuaryService.findAllEmployeeStatuary(empId);
		EmployeeBank bankDetails = bankDetailsService.save(employeeBank);
		//return empStatutoryBankAdaptor.databaseModelToUiDtoList(bankDetailsService.saveAll(employeeBankList),employeeStatuaryList);
		return empStatutoryBankAdaptor.databaseModelToUiDtoList(bankDetails,employeeStatuaryList);
	}
	
	
	/**
	 * to get List of Banks from database based on employeeId
	 */
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody CandidateStatuaryDTO findAllBankDetails(@PathVariable("employeeId") String employeeId,
			HttpServletRequest req) {
		logger.info("findAllBankDetails is calling :" + "employeeId" + employeeId);
		Long empId = Long.parseLong(employeeId);
		EmployeeBank bankDetails = bankDetailsService.findBankDetails(empId);
		System.out.println("bank...."+bankDetails);
		List<EmployeeStatuary> employeeStatuaryList  = employeeStatuaryService.findAllEmployeeStatuary(empId);
	 return empStatutoryBankAdaptor.databaseModelToUiDtoList(bankDetails,employeeStatuaryList);
	}

}
