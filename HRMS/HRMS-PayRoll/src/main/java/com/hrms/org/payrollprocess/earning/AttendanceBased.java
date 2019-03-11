package com.hrms.org.payrollprocess.earning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttendanceBased  implements EarningType {
	
	 private final Logger logger = LoggerFactory.getLogger(AttendanceBased.class);

	@Override
	public PayOut calculateEarning( PayStructure payStructure , ReportPayOut reportPayOut , PayrollControl payrollControl ) {
		
		PayOut payOut = new PayOut();
		BigDecimal amount = payStructure.getAmount();
		BigDecimal payDays = new BigDecimal (payrollControl.getPayrollDays());
		int daysWorkedStep1 = calculateDaysWorked( reportPayOut, payrollControl );
		
		
		BigDecimal dayWorked = new BigDecimal( daysWorkedStep1 );
		BigDecimal earningStep1 = amount.divide(payDays, 3, RoundingMode.HALF_UP );
	
		BigDecimal earning = earningStep1.multiply( dayWorked );
		
		BigDecimal finalAmount  = earning.setScale(1, RoundingMode.HALF_UP );
		Employee employee = new Employee();
		employee.setEmployeeId( reportPayOut.getId().getEmployeeId() );
		payOut.setEmployee (employee );
		payOut.setAmount( finalAmount );
		
		PayOutPK pk = new PayOutPK();
		
		pk.setEmployeeId( reportPayOut.getId().getEmployeeId() );
		pk.setProcessMonth( payrollControl.getProcessMonth() );
		pk.setPayHeadId( payStructure.getPayHead().getPayHeadId() );
		payOut.setId( pk );
		payOut.setEmployee(employee);
		return payOut;
	}

	private int calculateDaysWorked( ReportPayOut reportPayOut, PayrollControl payrollControl ) {
		String processMonth = payrollControl.getProcessMonth() ;
		Date doj = reportPayOut.getDateOfJoining();
		String dojMonth = DateUtils.getMonthOfProcess( doj );
		String dojYear = DateUtils.getYearOfProcess( doj );
		String month = processMonth.substring( 0, processMonth.indexOf("-") );
		String year = processMonth.substring( processMonth.indexOf("-")+1, processMonth.length() );
		int daysWorked = 0;
		
		
		
		if ( dojMonth.equalsIgnoreCase( month )  && dojYear.equalsIgnoreCase(year)  ) {
			
			BigDecimal payDays = new BigDecimal( payrollControl.getPayrollDays() );
			
			
			DateUtils dateUtil  = new  DateUtils( );
			int date = dateUtil.getDate( doj );
			BigDecimal dojDay = new BigDecimal( date  );
			
			
			BigDecimal beforeDOJ = dojDay.add( reportPayOut.getAbsense() );
			
			daysWorked = payDays.subtract(   beforeDOJ  ).intValueExact();
			daysWorked = daysWorked +1;
			
			
		} else {
		
			BigDecimal payDays = new BigDecimal( payrollControl.getPayrollDays() );
			daysWorked = payDays.subtract( reportPayOut.getAbsense() ).intValueExact();
		}
		
		
		return daysWorked;
	}


}
