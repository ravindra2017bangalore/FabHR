package com.csipl.hrms.service.payroll;

import com.csipl.hrms.model.payroll.TdsSummary;
import com.csipl.hrms.model.payroll.TdsSummaryChange;

public interface TdsSummaryService {
	
	public void saveTdsSummary(TdsSummary tdsSummary);
	public TdsSummaryChange getTdsSummary(Long employeeId, String financialYear);
}
