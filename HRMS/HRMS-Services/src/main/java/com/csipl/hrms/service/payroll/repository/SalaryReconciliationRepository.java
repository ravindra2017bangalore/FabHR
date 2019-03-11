package com.csipl.hrms.service.payroll.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public interface SalaryReconciliationRepository extends CrudRepository<ReportPayOut, Long>{
	 String fetchEmpDetailsForSalaryReconciliation="SELECT processMonth,employeeId, accountNumber,NetPayableAmount,employeeCode,transactionNo FROM `ReportPayOut` WHERE departmentId=?1 and processMonth=?2";  
	// String fetchEmpDetailsForSalaryReconciliation="SELECT  * FROM `ReportPayOut`  WHERE departmentId=?1 and processMonth=?2";  
		
	//@Query(value=fetchEmpDetailsForSalaryReconciliation,nativeQuery = true)
	//List<Object[]>  fetchEmpDetailsForSalaryReconciliation(Long departmentId,String processMonth);
	
	@Query(" from ReportPayOut rp  where rp.id.processMonth=?1 and rp.departmentId=?2 and rp.employee.employeeId not in (select p.employee.employeeId from Provision p where p.processMonth=?1 and p.department.departmentId=?2)  ") 
	List<ReportPayOut> fetchEmpDetailsForSalaryReconciliation(String processMonth,Long departmentId);
	
	
	@Query(" from ReportPayOut rp  where rp.id.processMonth=?1 and rp.companyId=?2 and rp.employee.employeeId not in (select p.employee.employeeId from Provision p where p.processMonth=?1 )  ") 
	List<ReportPayOut> fetchEmpDetailsForSalRecoAllDept(String processMonth,Long departmentId);
	
}
 