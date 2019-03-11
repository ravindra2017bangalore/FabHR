package com.hrms.org.payrollprocess;

import java.math.BigDecimal;
import java.util.List;



import com.csipl.hrms.common.exception.messages.error.ErrorCodes;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payrollprocess.Attendance;

public class PayRollValidation {
	
	public PayRollValidation() {
		
	}

	public BigDecimal calcualteAttendance( final Attendance attendance  ) {
	return	attendance.getPresense()
		.add( attendance.getPublicholidays() )
		.add( attendance.getPaidleave() )
		.add( attendance.getWeekoff() )
		.add( attendance.getCasualleave() );
	};
	
	public void validation( List<Attendance> attendanceList, List<Employee> employeeList ) {
		
		
		
	}

	public void attendanceValidation( final Attendance attendance ) {
		
	}
}
