package com.csipl.hrms.org.controller;

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
import com.csipl.hrms.dto.organisation.BranchDTO;
import com.csipl.hrms.model.common.Branch;
import com.csipl.hrms.service.adaptor.BranchAdaptor;
import com.csipl.hrms.service.organization.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController   {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	@Autowired
	BranchService branchService;

	BranchAdaptor branchAdaptor = new BranchAdaptor();
	/**
	 * @param branchDto
	 *            This is the first parameter for getting branch Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveBranch(@RequestBody BranchDTO branchDto, HttpServletRequest req) {
		logger.info("saveBranch is calling :  BranchDTO>>s "+ branchDto );
  		Branch branch = branchAdaptor.uiDtoToDatabaseModel(branchDto);
   		branchService.save(branch);
		logger.info("saveBranch is end  :"  + branch);
	}
	/**
	 * to get all branches List from database based on companyId
	 * @throws PayRollProcessException 
	 */
 	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<BranchDTO> findAllBranches(@RequestParam("companyId") Long companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
 		logger.info("findAllBranches is calling : " );
 		List<Branch> branchList = branchService.findAllBranches(companyId);
		logger.info("Branch List  :"  + branchList);
		if (branchList != null && branchList.size() > 0)
			return branchAdaptor.databaseModelToUiDtoList(branchList);
		else
			throw new ErrorHandling("Branch data not present");
	}
 	
 	@RequestMapping(value="/{branchId}",method = RequestMethod.GET)
	public @ResponseBody BranchDTO findBranch(@PathVariable("branchId") Long branchId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
 		logger.info("findBranch is calling : "+branchId);
 		Branch branch = branchService.findBranch(branchId);
			return branchAdaptor.databaseModelToUiDto(branch);
	}
}
