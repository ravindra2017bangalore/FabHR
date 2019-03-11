package com.csipl.hrms.service.payroll;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.service.payroll.repository.EpfRepository;

@Service("epfService")
public class EpfServiceImpl implements EpfService {
	
	@Autowired
	private EpfRepository epfRepository;
	
	/**
	 * Save OR update epf object  into Database 
	 */
	@Override
	public Epf save(Epf epf) {
		epf = epfRepository.save(epf);
   		return epf;
	}
	/**
	 * to get EPF Object from database based on companyId
	 */
 	@Override
	public Epf getEPF( Long companyId ) {
 		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
 		return epfRepository.getEPF( companyId, currentDate );
	}

	

}
