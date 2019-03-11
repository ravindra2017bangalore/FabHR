package com.csipl.hrms.service.payroll;

import com.csipl.hrms.model.payroll.TdsPayrollHd;

public interface TdsPayrollService {

	public TdsPayrollHd getTdsPayrollHd(Long employeeId, String financialYear);
	
}
