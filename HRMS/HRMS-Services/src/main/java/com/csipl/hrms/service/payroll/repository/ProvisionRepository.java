package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.model.payroll.Provision;

//import scala.sys.process.processInternal;

public interface ProvisionRepository extends CrudRepository <Provision, Long> {


	String summarySelectQueryForProvision="select  pr.provisionId ,pr.activeStatus,pr.employeeId,pr.departmentId,pr.processMonth, pr.narration,pr.userId, emp.employeeCode,emp.firstName, pr.dateCreated,pr.userIdUpdate,pr.dateUpdate ,dept.departmentName ,design.designationName\r\n" + 
			"from  Employee emp join Designation design ON emp.designationId = design.designationId  \r\n" + 
			"join Department dept ON  emp.departmentId = dept.departmentId \r\n" + 
			"join Provision pr ON emp.employeeId = pr.employeeId \r\n" + 
			"left join PayRollLock pl on pr.processMonth = pl.processMonth \r\n" + 
			" and pr.departmentId = pl.departmentId  and  pl.isPayRollLocked = 'true' where pr.companyId=?1 and pr.activeStatus='AC'" ;
	
	
	@Query(value=summarySelectQueryForProvision,nativeQuery = true)
 
 
	List<Object[]>  findAllProvision(Long companyId);
	
	//public List<Provision> findAllProvision();
	
	@Query("from Provision where activeStatus='AC'and provisionId=?1 ORDER BY  employeeId  DESC ") 
 	public Provision findProvision(Long provisionId);
	
	String SelectQueryForProvisionFNF="SELECT p.provisionId,rp.Name,rp.employeeCode,dept.departmentName,p.processMonth,rp.TotalEarning,rp.bankName ,rp.accountNumber ,p.narration, p.employeeId  FROM Provision p LEFT JOIN ReportPayOut rp ON p.employeeId=rp.employeeId LEFT JOIN Department dept ON dept.departmentId =p.departmentId\r\n" + 
			"WHERE rp.processMonth= p.processMonth  AND p.employeeId =?1 AND p.processMonth =?2" ;
	
	@Query(value=SelectQueryForProvisionFNF,nativeQuery = true)
 
	List<Object[]>  findAllProvisionForFNF(Long employeeId,String processMonth );
}
