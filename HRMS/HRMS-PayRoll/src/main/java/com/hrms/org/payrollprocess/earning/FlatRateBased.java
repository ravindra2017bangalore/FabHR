package com.hrms.org.payrollprocess.earning;

import java.math.BigDecimal;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public class FlatRateBased implements EarningType {

	@Override
	public PayOut calculateEarning( PayStructure payStructure , ReportPayOut reportPayOut  , PayrollControl payrollControl ) {
		PayOut payOut = new PayOut();
		
		BigDecimal amount = payStructure.getAmount();
		
		Employee employee = new Employee();
		employee.setEmployeeId( reportPayOut.getId().getEmployeeId() );
		payOut.setEmployee(employee);
		payOut.setAmount( payStructure.getAmount() );
		//payOut.setPayHeadId( payStructure.getPayHead().getPayHeadId() );
		PayOutPK pk = new PayOutPK();
		pk.setEmployeeId( reportPayOut.getId().getEmployeeId() );
		pk.setProcessMonth( payrollControl.getProcessMonth() );
		pk.setPayHeadId( payStructure.getPayHead().getPayHeadId() );
		payOut.setId( pk );
		
		return payOut;
	}

}
