package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.OneTimeDeduction;

public interface OneTimeDeductionRepository extends CrudRepository<OneTimeDeduction, Long> {

	String findAllOneTimeDeduction = "SELECT emp.firstname,emp.lastname,otd.deductionMonth,otd.deductionId,otd.deductionAmount,emp.employeeId,dept.departmentName, desig.designationName,emp.employeeCode,otd.remarks,otd.userId,otd.dateCreated\r\n" + 
			"FROM OneTimeDeduction otd, Employee emp,Department dept,Designation desig\r\n" + 
			"WHERE otd.companyId =?1 AND emp.employeeId = otd.employeeId AND emp.companyId = otd.companyId AND emp.departmentId = dept.departmentId AND emp.designationId = desig.designationId";
	@Query(value = findAllOneTimeDeduction ,nativeQuery = true)
	public List<Object[]>  findAllOneTimeDeductionList(Long companyId);
	
	
	String findOneTimeDeductionForEmployee =" from  OneTimeDeduction otd where otd.employee.employeeId=?1 and otd.deductionMonth=?2 ";
	@Query( findOneTimeDeductionForEmployee )
	public List<OneTimeDeduction>  findOneTimeDeductionForEmployee(Long employeeId, String deductionMonth);
}
