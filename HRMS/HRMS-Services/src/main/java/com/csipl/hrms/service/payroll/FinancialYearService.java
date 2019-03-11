package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.model.payrollprocess.FinancialYear;

public interface FinancialYearService {
	List<FinancialYear> findAllFinancialYear(Long complay);
	FinancialYear findCurrentFinancialYear(Date date,Long complay);
	
}
