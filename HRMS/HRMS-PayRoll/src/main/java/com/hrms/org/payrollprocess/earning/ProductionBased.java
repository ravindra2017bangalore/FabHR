package com.hrms.org.payrollprocess.earning;

import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public class ProductionBased  implements EarningType {

	@Override
	public PayOut calculateEarning( PayStructure payStructure , ReportPayOut reportPayOut , PayrollControl payrollControl  ) {
		PayOut payOut = new PayOut();
		
		return payOut;
	}

}