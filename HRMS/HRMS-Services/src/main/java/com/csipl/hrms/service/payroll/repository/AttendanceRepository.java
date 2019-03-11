package com.csipl.hrms.service.payroll.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.payrollprocess.Attendance;



public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

	
	String attendanceQuery ="   select "
			+ "attendance.presense , " // index = 0
			+ "attendance.weekoff ,"	// index = 1
			+ "attendance.seekleave , "	// index = 2
			+ " attendance.paidleave ,"	// index = 3
			+ " attendance.payDays , "	// index = 4
			+ " attendance.publicholidays,"	// index = 5
			+ " attendance.absense,"		// index = 6
			+ " emp.employeeId,"			// index = 7
			+ " emp.departmentId, "	// index = 8
			+ " emp.cityId, "					// index = 9
			+ " emp.firstName , "		// index = 10
			+ " emp.lastName , "		// index = 11
			+ " emp.employeeCode , "	// index = 12
			+ " COALESCE(empBank.accountNumber, ''),   "	// index = 13
			+ " emp.dateOfJoining,   "			// index = 14
			//+" COALESCE(dropDownList.listValue, ''),  "	// index = 15
			+ " COALESCE(empBank.bankId, ''),   "	// index = 15
			+ " emp.companyId,  "				// index = 16
			+" COALESCE(empFamily.relation, ''),"	// index = 17
			+ " empFamily.name, "				// index = 18
			+" emp.maritalStatus,"				// index = 19
			+ " address.emailId,"				// index = 20
			+ " address.mobile,  "				// index = 21
			+ " empBank.ifscCode,  "				// index = 22
			+ " emp.gender,  "				// index = 23
			+ " emp.dateOfBirth,  "				// index = 24
			+ " emp.stateId,  "				// index = 25
			+ " emp.adharNumber,  "				// index = 26
			+ " phd.isNoPFDeduction "  		// index = 27
			+" from Attendance attendance JOIN Employee emp ON attendance.employeeCode = emp.employeeCode and attendance.processMonth=?3 and emp.departmentId=?2 and attendance.companyId = ?1 "
			+" LEFT JOIN EmployeeBank empBank ON emp.employeeId =  empBank.employeeId "
			+ " LEFT JOIN EmployeeFamily empFamily ON emp.employeeId = empFamily.employeeId " 
			+ " LEFT JOIN Address address ON emp.permanentAddressId = address.addressId "
			
			+ " LEFT JOIN PayStructureHd phd  ON emp.employeeId = phd.employeeId "
			+ " and  ( phd.dateEnd is null  and phd.effectiveDate is NOT null and phd.effectiveDate> NOW() ) "
			
			
			+" and ( ( accountType='SA' or accountType='SL') and empBank.activeStatus='AC'  )   group by emp.employeeId order by emp.departmentId, emp.employeeId";		
	
	/* String employDepartmentQuery ="select emp.employeeCode , emp.employeeId   "
	+ "from Department department JOIN Employee emp ON department.departmentId = emp.departmentId and department.companyId =?1 and emp.departmentId=?2 order by emp.departmentId, emp.employeeId " ; */
	
	
	@Query(value=attendanceQuery,nativeQuery = true)
	public List<Object[]> fetchEmployeeForSalary( Long companyId, long departmentId,  String payMonth  );
	
	//@Query(value=employDepartmentQuery,nativeQuery = true)
	@Query( " from Employee employee INNER JOIN employee.department department where  department.departmentId=?1 " )
	public List<Employee> fetchEmployeeOfDepartment(  long departmentId );
	
	
	@Query( " from PayStructure payStructure INNER JOIN payStructure.payStructureHd payStructureHd where payStructureHd.employee.employeeId=?1 and payStructureHd.effectiveDate <= ?2  " )
	public List<PayStructure> fetchPayStructureByEmployee(  long employeeId, Date today );
	
	
	
	String attendanceValidationQuery="SELECT emp.employeeId,emp.employeeCode ,dept.departmentId ,empBank.bankId ,"
			+ "payHd.payStructureHdId, emp.adharNumber as aadhar FROM Employee as emp "
			+ "left join Department as dept ON dept.departmentId= emp.departmentId "
			+ "left join EmployeeBank empBank on empBank.employeeId=emp.employeeId and "
			+ " ( empBank.accountType='SA' or  empBank.accountType='SL' ) left join PayStructureHd payHd on payHd.employeeId=emp.employeeId "
		//	+ "  left join EmployeeIdProofs et1 on et1.employeeId=emp.employeeId and et1.idTypeId='AA' "
			+ " and ( emp.adharNumber is NOT NULL or  emp.adharNumber <> '' )"
			+ "   where emp.companyId=?1 and emp.departmentId=?2 and emp.dateOfJoining <= ?3 and emp.activeStatus ='AC'";
			
			
	
	
	String attendanceValidationQueryforCompany="SELECT emp.employeeId,emp.employeeCode ,dept.departmentId ,empBank.bankId, "
			+" payHd.payStructureHdId, emp.adharNumber as aadhar FROM Employee as emp left join Department as dept ON dept.departmentId= emp.departmentId  "
			+" left join EmployeeBank empBank on empBank.employeeId=emp.employeeId and "
			+ " ( empBank.accountType='SA' or  empBank.accountType='SL' ) left join PayStructureHd payHd on payHd.employeeId=emp.employeeId  "
			+ " and  ( emp.adharNumber is NOT NULL or  emp.adharNumber <> '' ) "
			+  " where emp.companyId= ?1 and emp.dateOfJoining <= ?2 and emp.activeStatus ='AC' ";
	
	
	@Query(value=attendanceValidationQuery,nativeQuery = true)
	public List<Object[]> fetchEmployeeForValidation(long companyId, long departmentId, Date processMonth );
	
	@Query(value=attendanceValidationQueryforCompany,nativeQuery = true)
	public List<Object[]> fetchEmployeeForValidation(long companyId, Date processMonth );
	

	//@Query( "select count( attendance ) from Attendance  attendance  where attendance.department.departmentId=?1 and attendance.id.processMonth=?2" )
	@Query( "select DISTINCT dept.departmentName from Attendance attendance  JOIN Department dept on attendance.department.departmentId=dept.departmentId "
			+ "where attendance.department.departmentId=?1 and attendance.id.processMonth=?2" )
	public List<String> isAttendanceUploadedForMonthAndDepartment(  long departmentId,  String processMonth  );
	
	//@Query( "select count( attendance ) from Attendance  attendance  where attendance.company.companyId=?1 and attendance.id.processMonth=?2" )
	@Query( "select DISTINCT dept.departmentName from Attendance attendance  JOIN Department dept on attendance.department.departmentId=dept.departmentId where attendance.company.companyId=?1 and attendance.id.processMonth=?2" )
	public List<String> isAttendanceUploadedForMonthAndCompany(  long companyId,  String processMonth  );
	
	@Query( "SELECT distinct dept.departmentName  FROM Attendance att join Department dept  on att.department.departmentId = dept.departmentId \r\n" + 
			" where processMonth = ?2 and att.company.companyId=?1" )
	public List<String> findDepartmentForProcessing(  long companyId,  String processMonth  );
	
	
}
