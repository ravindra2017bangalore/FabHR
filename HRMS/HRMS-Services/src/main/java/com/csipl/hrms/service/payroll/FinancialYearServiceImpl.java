package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;

@Service("financialYearService")
public class FinancialYearServiceImpl implements FinancialYearService {

	
	@Autowired
	FinancialYearRepository  financialYearRepository;
	/**
	 * to get List of  FinancialYear objects from database based on companyId
	 */
	@Override
	public List<FinancialYear> findAllFinancialYear(Long companyId) {
 		return financialYearRepository.findAllFinancialYear(companyId);
	}
	
	
	@Override
	public FinancialYear findCurrentFinancialYear(Date date ,Long companyId) {
		// TODO Auto-generated method stub
		return financialYearRepository.getFinancialYear(date,companyId);
	}

	

}
