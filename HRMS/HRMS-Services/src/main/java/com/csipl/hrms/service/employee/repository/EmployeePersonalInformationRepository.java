package com.csipl.hrms.service.employee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.Employee;

public interface EmployeePersonalInformationRepository extends CrudRepository<Employee, Long> {
	String employeeLovSearch="SELECT emp.employeeId,emp.firstName,emp.lastName,emp.employeeCode,emp.employeeLogoPath  FROM Employee emp where companyId=?1 and activeStatus=?2 ORDER BY  employeeId  DESC ";
 	@Query(value = employeeLovSearch, nativeQuery = true)
	public List<Object[]> findAllEmployees(long companyId,String status);

	@Query(" from Employee where employeeCode=?1 and companyId=?2")
	public Employee findEmployees(String employeeCode, Long companyId);

	@Query("from Employee where companyId=?1 and activeStatus='AC' and departmentId=?2 ORDER BY  employeeId  DESC ")
	public List<Employee> findAllEmpByDeptId(Long companyId, Long departmentId);

	@Query("from Employee where companyId=?1 and activeStatus='DE' ORDER BY  employeeId  DESC ")
	public List<Employee> findAllDeactivateEmployees(Long companyId);

	String employeeLOV = "SELECT emp.employeeId,emp.employeeCode, emp.firstName,emp.lastName  "
			+ " from Employee emp where" + " emp.companyId=?1 and emp.activeStatus ='AC'";

	@Query(value = employeeLOV, nativeQuery = true)
	public List<Object[]> fetchEmployee(long companyId);

	String employeeSearch = "SELECT emp.employeeId, emp.employeeCode, emp.firstName, emp.lastName, "
			+ "gd.gradesName, dept.departmentName,  design.designationName, emp.dateOfJoining  emp.endDate"
			+ " FROM  Employee emp LEFT JOIN PayStructureHd ph ON  ph.employeeId = emp.employeeId AND ( "
			+ " ph.dateEnd IS NULL OR ph.dateEnd >= CURRENT_DATE ) AND ( ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE "
			+ ") AND ph.activeStatus = 'AC' LEFT JOIN Grades gd ON gd.gradesId = ph.gradesId LEFT JOIN Department dept ON   emp.departmentId = dept.departmentId "
			+ " LEFT JOIN Designation design ON   emp.designationId = design.designationId   WHERE emp.companyId =?1 AND emp.activeStatus = 'AC' order by emp.employeeId desc ";

	@Query(value = employeeSearch, nativeQuery = true)
	public List<Object[]> searchEmployee(long companyId);

	@Query("SELECT COUNT(1) from Employee where adharNumber=?1 AND activeStatus=?2 AND employeeId NOT IN (?3)")
	public Long aadharCheck(String adharNumber, String activeStatus, Long employeeId);

	@Query(" SELECT count(*) from Employee  where companyId=?1 AND endDate IS NULL AND activeStatus = 'AC'")
	public int employeeSearch(Long companyId);

	@Query(" SELECT count(*) from Employee where companyId=?1 AND activeStatus = 'DE'")
	public int employeeSearchDE(Long companyId);

	@Query(" SELECT count(*) from Employee where companyId=?1 AND endDate!='' AND activeStatus = 'AC'")
	public int getEmployeeSeparatingCount(Long companyId);

	String filterEmployee = "SELECT emp.employeeId, emp.employeeCode, emp.firstName, emp.lastName, "
			+ "gd.gradesName, dept.departmentName,  design.designationName, emp.dateOfJoining  emp.endDate"
			+ " FROM  Employee emp LEFT JOIN PayStructureHd ph ON  ph.employeeId = emp.employeeId AND ( "
			+ " ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE ) AND ( ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE "
			+ ") AND ph.activeStatus = 'AC' LEFT JOIN Grades gd ON gd.gradesId = ph.gradesId LEFT JOIN Department dept ON   emp.departmentId = dept.departmentId "
			+ " LEFT JOIN Designation design ON   emp.designationId = design.designationId   WHERE emp.firstName=?1 AND emp.companyId =?2 AND emp.activeStatus = 'AC' order by emp.employeeId desc ";

	@Query(value = filterEmployee, nativeQuery = true)
	public List<Object[]> findPagedResultFilterEmployee(String firstName, long companyId);

	@Query("FROM Employee emp where companyId=?1 and MONTH( emp.dateOfBirth ) = MONTH(NOW()) and DAY(emp.dateOfBirth) = DAY(NOW()) and activeStatus='AC'")
	public List<Employee> findBirthDayEmployees(Long companyId);

	@Query("FROM Employee emp where companyId=?1 and MONTH( emp.anniversaryDate ) = MONTH(NOW()) and DAY(emp.anniversaryDate) = DAY(NOW()) and activeStatus='AC'")
	public List<Employee> findAnniversaryEmployees(Long companyId);

	@Query("FROM Employee emp where companyId=?1 and MONTH(emp.dateOfJoining) = MONTH(NOW()) and DAY(emp.dateOfJoining) = DAY(NOW()) and activeStatus='AC'")
	public List<Employee> findJoiningAnniversaryEmployees(Long companyId);

	@Query(value = orgTree, nativeQuery = true)
	public List<Object[]> orgHierarchyList(Long employeeId);

	String orgTree = "SELECT  employee.employeeId, employee.firstName,employee.lastName,employee.employeeCode,employee.employeeLogoPath,manager.employeeId as managerId,manager.firstName as managerFirstName,manager.lastName as managerLastName ,dept.departmentName FROM  Employee employee LEFT JOIN Employee manager ON  employee.ReportingToEmployee = manager.employeeId JOIN Department dept ON employee.departmentId=dept.departmentId WHERE manager.employeeId =?1";

	@Modifying
	@Query("UPDATE Employee SET employeeLogoPath=?1 WHERE employeeId=?2")
	void saveCandidateImage(String dbPath, Long candidateId);

 	
	String onBoardProgessBar = "SELECT  emp.employeeId AS empId, eIdProofs.employeeId AS eIdProofs, pInformation.employeeId pInformation, eEducation.employeeId AS eEducation, eFamily.employeeId AS eFamily, eStatuary.employeeId AS eStatutory,emp.employeeId AS employeeId,eBank.employeeId AS eBank FROM Employee emp LEFT JOIN EmployeeStatuary eStatuary ON eStatuary.employeeId = emp.employeeId LEFT JOIN EmployeeIdProofs eIdProofs ON eIdProofs.employeeId = emp.employeeId LEFT JOIN ProfessionalInformation pInformation ON  pInformation.employeeId = emp.employeeId LEFT JOIN EmployeeEducation eEducation ON  eEducation.employeeId = emp.employeeId  LEFT JOIN EmployeeFamily eFamily ON  eFamily.employeeId = emp.employeeId LEFT JOIN EmployeeBank eBank ON  eBank.employeeId = emp.employeeId WHERE emp.employeeId =?1";
	@Query(value = onBoardProgessBar, nativeQuery = true)
	List<Object[]> getOnBoardProgessBar(Long candidateId);
	
	
	String shiftName="SELECT ts.shiftId, ts.shiftFName FROM Employee e JOIN TMSShift ts ON e.shiftId=ts.shiftId WHERE e.employeeId=?1";
	@Query(value=shiftName,nativeQuery = true)
	public Object[] getEmpShiftName(Long employeeId);
	
	String reportingTo="SELECT b.employeeId,b.employeeCode,b.officialEmail,b.contactNo, UPPER(concat(concat(b.firstName,' '),b.lastName)) as empname FROM Employee a join Employee b on b.employeeId=a.ReportingToEmployee WHERE a.employeeId=?1";
	@Query(value=reportingTo,nativeQuery = true)
	public List<Object[]> getEmpReportingToEmail(Long employeeId);
	
	
}
