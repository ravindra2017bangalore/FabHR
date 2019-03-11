package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payrollprocess.PayRollLock;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public interface SalaryReconciliationService {
	
	public List<ReportPayOut> fetchEmpDetailsForSalaryReconciliation(String processMonth,Long departmentId);
	public List<ReportPayOut> fetchEmpDetailsForSalRecoAllDept(String processMonth,Long compnayId);
	
	public void save(List<ReportPayOut> reportForSave,List<PayRollLock> prl);
	public void save(List<ReportPayOut> reportForSave,PayRollLock prl);

}
