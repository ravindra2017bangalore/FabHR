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
import com.csipl.hrms.dto.payroll.PayHeadDTO;
import com.csipl.hrms.dto.payroll.PayHeadListDTO;

import com.csipl.hrms.model.payroll.PayHead;
import com.csipl.hrms.org.BaseController;

import com.csipl.hrms.service.adaptor.PayHeadAdaptor;
import com.csipl.hrms.service.payroll.PayHeadService;

@RequestMapping("/payhead")
@RestController
public class PayHeadController  {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(PayHeadController.class);
	boolean status = false;
	PayHeadAdaptor payheadAdaptor = new PayHeadAdaptor();

	@Autowired
	PayHeadService payHeadService;

	/**
	 * @param payHeadDto
	 *            This is the first parameter for getting payHead object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void payhead(@RequestBody PayHeadDTO payHeadDto, HttpServletRequest req) {
		PayHead payHead = payheadAdaptor.uiDtoToDatabaseModel(payHeadDto);
		payHeadService.save(payHead);
	}

	/**
	 * to get PayHeadList object from database based on companyId and earning OR
	 * deduction
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody PayHeadListDTO findAllPayHeads(@PathVariable("companyId") Long companyId,HttpServletRequest req) throws PayRollProcessException {
		
		PayHeadListDTO listDTO = new PayHeadListDTO();
		List<PayHeadDTO> earningDtoList = payheadAdaptor
				.databaseModelToUiDtoList(payHeadService.getAllPayHeads("EA", companyId));
		List<PayHeadDTO> deductionDtoList = payheadAdaptor
				.databaseModelToUiDtoList(payHeadService.getAllPayHeads("DE", companyId));
		listDTO.setEarningPayHead(earningDtoList);
		listDTO.setDeductionPayHead(deductionDtoList);
		return listDTO;
	}

	/**
	 * to get List PayHead objects from database based on companyId and earning
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(path = "/earning/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<PayHeadDTO> findAllEarningPayHeads(@PathVariable("companyId") String companyId,HttpServletRequest req) throws PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<PayHeadDTO> earningDtoList = payheadAdaptor
				.databaseModelToUiDtoList(payHeadService.getAllPayHeads("EA", longcompanyId));
		System.out.println(earningDtoList);
		return earningDtoList;
	}

	/**
	 * to get List PayHead objects from database based on companyId and earning OR
	 * deduction
	 * @throws PayRollProcessException 
	 *//*
	@RequestMapping(path = "/payHeadList", method = RequestMethod.GET)
	public @ResponseBody List<PayHeadDTO> findAllPayHeadList(@RequestParam("earningDeduction") String earningDeduction,
			HttpServletRequest req) throws PayRollProcessException {
		List<PayHeadDTO> payHeadDtoList = payheadAdaptor
				.databaseModelToUiDtoList(payHeadService.getAllPayHeads(earningDeduction, getCompanyId(req)));
		return payHeadDtoList;
	}*/

}
