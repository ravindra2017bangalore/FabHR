package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.PayRollLock;
 

public interface PayRollLockService {
	
	public void  save(List<PayRollLock>  payRollLocks);
	
	public void  save( PayRollLock  payRollLock );
	
	int  isSalaryProcessStartedForCompany(Long companyId, String processMonth);
	
	int  isSalaryProcessStartedForDepartment(Long departmentId, String processMonth);
	
	public PayRollLock findpayRollLock(String processMonth,Long departmentId); 
	
	public List<PayRollLock> findpayRollLock(String processMonth); 
	
	public List<Department> findDepartmentForSalaryGenerate(long companyId, String processMonth );

	

}
