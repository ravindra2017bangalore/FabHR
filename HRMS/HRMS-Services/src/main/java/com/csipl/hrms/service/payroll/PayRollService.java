package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayrollControl;

public interface PayRollService {
	public void processPayRoll( long companyId, String processMonth, long userId  );
	
	public void processPayRollByDepartment( Long companyId, Long departmentId, Epf epf, Esi esi, Long userId , PayrollControl payrollControl, DrowpdownHd bankList );
	public List<PayOut> processPayRoll(long companyId, long employeeId) ;
	public List<PayOut> processPayRollForTds(long companyId, long employeeId,PayStructureHd payStructureHd ) ;
	

}
 