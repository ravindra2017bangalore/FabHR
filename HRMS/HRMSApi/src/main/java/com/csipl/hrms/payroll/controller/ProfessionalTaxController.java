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
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.organisation.GradeDTO;
import com.csipl.hrms.dto.payroll.ProfessionalTaxDTO;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.organisation.GradesPayDefinition;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.model.payroll.ProfessionalTaxInfo;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.ProfessionalTaxAdaptor;
import com.csipl.hrms.service.payroll.ProfessionalTaxService;

@RequestMapping("/professionalTax")
@RestController
public class ProfessionalTaxController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProfessionalTaxController.class);
	@Autowired
	ProfessionalTaxService professionalTaxService;
	ProfessionalTaxAdaptor professionalTaxAdaptor = new ProfessionalTaxAdaptor();
	/**
	 * @param professionalTaxDto
	 *            This is the first parameter for getting professionalTax Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody ProfessionalTaxDTO professionalTaxDto, HttpServletRequest req) throws PayRollProcessException {
		DateUtils dateUtils = new DateUtils();
		ProfessionalTax professionalTax=new ProfessionalTax();
		if(professionalTaxDto.getProfessionalHeadId()==null) {
	    professionalTax = professionalTaxAdaptor.uiDtoToDatabaseModel(professionalTaxDto);
		}
		else {
			Long proTaxID = professionalTaxDto.getProfessionalHeadId();
			
			ProfessionalTax professionalTaxNew=professionalTaxService.findProfessionalTax(proTaxID,professionalTaxDto.getCompanyId());
			 professionalTax = professionalTaxAdaptor.uiDtoToDatabaseModel(professionalTaxDto);
			 professionalTax.setProfessionalHeadId(null);
			 for (ProfessionalTaxInfo professionalTaxInfo : professionalTax.getProfessionalTaxInfos()) {
				 professionalTaxInfo.setProfessionalTaxInfoId(null); 
			 }
			 professionalTaxNew.setEffectiveEndDate(dateUtils.getDateWirhYYYYMMDD(professionalTaxDto.getEffectiveStartDate()));
			 professionalTaxService.save(professionalTaxNew);
		}
	
		professionalTaxService.save(professionalTax);
	}
	
	/**
	 * to get List of ProfessionalTax objects from database    
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<ProfessionalTaxDTO> findAllProfessionalTax(@PathVariable("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		Long companyID = Long.parseLong(companyId);
		return professionalTaxAdaptor.databaseModelToUiDtoList(professionalTaxService.getAllProfessionalTax(companyID));
	}
	
	/**
	 * to get ProfessionalTax object from database    proTaxId (Primary Key)
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/{proTaxId}/{companyId}", method = RequestMethod.GET)
	public @ResponseBody ProfessionalTaxDTO findProfessionalTax(@RequestParam("proTaxId") String proTaxId,@RequestParam("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		System.out.println("professionalTax/proTaxId"+proTaxId);
		Long proTaxID = Long.parseLong(proTaxId);		
		Long companyID = Long.parseLong(companyId);
		 return  professionalTaxAdaptor.databaseModelToUiDto(professionalTaxService.findProfessionalTax(proTaxID,companyID));
	}

}
