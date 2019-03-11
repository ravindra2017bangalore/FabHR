package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payrollprocess.FinancialYear;

public interface TdsStandardExemptionService {

	public List<TdsStandardExemption> getAllTdsStandardExemptionList(Long companyId);
 	public TdsStandardExemption save(TdsStandardExemption tdsStandardExemption);
 	public TdsStandardExemption getTdsStandardExemption(Long companyId);
}
