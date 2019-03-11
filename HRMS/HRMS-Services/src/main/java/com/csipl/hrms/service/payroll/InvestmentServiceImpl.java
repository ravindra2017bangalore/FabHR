package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.service.payroll.repository.InvestmentRepository;

@Service("investmentService")
public class InvestmentServiceImpl implements InvestmentService {
 	@Autowired
	  private InvestmentRepository investmentRepository;

 	
	/**
	 * to get List of TdsGroup Objects from database based on currentDate
	 */
	@Override
	public List<TdsGroup> getInvestmentList(Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
 		return investmentRepository.findAllInvestment(currentDate,companyId);
  	}
	/**
	 * Save OR update tdsGroup object  into Database 
	 */
	@Override
	public void save(TdsGroup tdsGroup) {
		investmentRepository.save(tdsGroup);
	}
	/**
	 * to get TdsGroup Object from database based on tdsGroupId (Primary Key)
	 */
	@Override
	public TdsGroup getInvestment(long tdsGroupId) {
		TdsGroup tdsGroup = investmentRepository.findInvestment(tdsGroupId);
		return tdsGroup;
	}
}
