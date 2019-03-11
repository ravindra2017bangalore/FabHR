
package com.csipl.hrms.service.payroll;


import java.util.List;

import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.PayrollControl;

public interface PayrollControlService {
public List<PayrollControl> findPayrollControl( long companyId );
public List<String> findPayrollProcessControl(long companyId);
public List<String> findPayrollProcessControl1(long companyId);
public List<String> findPayrollProcessControlById(long companyId,Long financialYearId);
public void save(List<PayrollControl> payrollControl);
public PayrollControl  findPayrollControlByMonth( long companyId, String processMonth );
public List<Department> findAllDepartmentNotINPayrollLock(long companyId, String processMonth );
public List<Department> findAllDepartmentNotINReportPayOut(long companyId, String  processMonth);
public List<Department> findAllDepartmentForPayRoll(long companyId, String  processMonth );
public List<String> getPayrollOpenProMon(long companyId);


}
