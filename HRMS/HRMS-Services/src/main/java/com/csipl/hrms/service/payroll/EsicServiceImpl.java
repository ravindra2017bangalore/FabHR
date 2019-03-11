package com.csipl.hrms.service.payroll;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.service.adaptor.EsicAdaptor;

import com.csipl.hrms.service.payroll.repository.EsicRepository;


@Service("esicService")
public class EsicServiceImpl implements EsicService {

	@Autowired
	  private EsicRepository esicRepository;
	EsicAdaptor esicAdaptor=new EsicAdaptor();
 
	/**
	 * Save OR update esi object  into Database 
	 */
	@Override
	public Esi save(Esi esic) {
		esic= esicRepository.save(esic);
		return esic;
	}
 
	/**
	 * to get Esi Object from database based on companyId
	 */
	@Override
	public Esi getESI(Long companyId) {	
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();	
		return esicRepository.getESI( companyId, currentDate );
	}
}
