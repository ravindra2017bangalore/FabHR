package com.csipl.hrms.report.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.report.EsiInfoDTO;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

import com.csipl.hrms.service.adaptor.ReportPayOutAdaptor;
import com.csipl.hrms.service.payroll.ReportPayOutService;

@RestController
public class EsiInfoController {
	private static final Logger logger = LoggerFactory.getLogger(EsiInfoController.class);
	@Autowired 
	ReportPayOutService reportPayOutService;
	
	ReportPayOutAdaptor reportPayOutAdaptor = new ReportPayOutAdaptor();
	
	@RequestMapping(path = "/esiInfo", method = RequestMethod.GET)
	public @ResponseBody  EsiInfoDTO ESIInfo(@RequestParam("esicNo")String esicNo, HttpServletRequest req) throws ErrorHandling{
		logger.info("ESIInfo is calling : "+" : esicNo "+ esicNo );
   		List<ReportPayOut> reportPayOutList= reportPayOutService.findEsiReport(esicNo);
   		logger.info("ESIInfo  : "+" : reportPayOutList "+ reportPayOutList );
   		if(reportPayOutList!=null && reportPayOutList.size()>0 )
    		return  reportPayOutAdaptor.databaseModelToESIDtoList(reportPayOutList);
          else
   			throw new ErrorHandling("Invalid ESIC NUMBER entered");
 	
  
	}
}
