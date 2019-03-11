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
import com.csipl.hrms.dto.payroll.EpfDTO;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.org.controller.WelcomeController;
import com.csipl.hrms.service.adaptor.EpfAdaptor;
import com.csipl.hrms.service.payroll.EpfService;

@RequestMapping("/epf")
@RestController
public class EpfController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EpfController.class);
	EpfAdaptor epfAdaptor=new EpfAdaptor();

	@Autowired
	EpfService epfService;
	/**
	 * @param epfDTO
	 *            This is the first parameter for getting epf Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void  save(@RequestBody EpfDTO epfDTO, HttpServletRequest req) {
		logger.info("save epfDTO is "+epfDTO);
   			Epf epf=epfAdaptor.uiDtoToDatabaseModel(epfDTO);
   			
			epfService.save(epf);
  	}
	/**
	 * to get EPF Object from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value = "/{companyId}",method = RequestMethod.GET)
	public @ResponseBody EpfDTO findEpf(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findEpf  is calling : companyId.."+companyId);
		Long companyID = Long.parseLong(companyId);
		Epf epf=epfService.getEPF(companyID );
		if(epf!=null) 
	 		return epfAdaptor.databaseModelToUiDto(epfService.getEPF(companyID ));
		else {
			logger.info("findEpf  Epf data not present : ");
			throw new ErrorHandling("Epf data not present");
		}
 	}
}
