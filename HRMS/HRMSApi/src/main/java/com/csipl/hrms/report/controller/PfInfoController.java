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
import com.csipl.hrms.dto.report.PfReportDTO;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.adaptor.ReportPayOutAdaptor;
import com.csipl.hrms.service.payroll.ReportPayOutService;

@RestController
public class PfInfoController {
	private static final Logger logger = LoggerFactory.getLogger(PfInfoController.class);
	@Autowired 
	ReportPayOutService reportPayOutService;
	
	ReportPayOutAdaptor reportPayOutAdaptor = new ReportPayOutAdaptor();
	
	@RequestMapping(path = "/getReportPf", method = RequestMethod.GET)
	public @ResponseBody  PfReportDTO pfInfoReport(@RequestParam("uanno")String uanno, HttpServletRequest req) throws ErrorHandling
	{
		logger.info("pfInfoReport is calling : "+" : uanno "+ uanno );

   		List<ReportPayOut> reportPayOutList= reportPayOutService.findPfReport(uanno);
   		logger.info("pfInfoReport  : "+" : reportPayOutList "+ reportPayOutList );
   		if(reportPayOutList!=null && reportPayOutList.size()>0 )
    		return  reportPayOutAdaptor.databaseModelToPfUiDto(reportPayOutList);
   		else
   
   			throw new ErrorHandling("Invalid UAN entered");
   			
 	}
}
	

