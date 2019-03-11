package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payrollprocess.FinancialYear;

public interface PayrollPeriodService {
	public FinancialYear save(FinancialYear financialYear);
	public FinancialYear findFinancialYear(String financialYear, Long companyId);
	public FinancialYear findLatestFinancialYear( Long companyId);

}
