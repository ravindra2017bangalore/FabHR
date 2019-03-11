package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.PayrollPeriodRepository;

@Service("payrollPeriodService")
public class PayrollPeriodServiceImpl  implements PayrollPeriodService  {
	@Autowired
	private PayrollPeriodRepository payrollPeriodRepository;
	@Override
	public FinancialYear save(FinancialYear financialYear) {
		// TODO Auto-generated method stub
		return payrollPeriodRepository.save(financialYear);
	}
	@Override
	public FinancialYear findFinancialYear(String financialYear, Long companyId) {
		
		
		return payrollPeriodRepository.findFinancialYear(financialYear,companyId);
	}
	
	public FinancialYear findLatestFinancialYear( Long companyId) {
		return payrollPeriodRepository.findLatestFinancialYear( companyId );
	}

}
