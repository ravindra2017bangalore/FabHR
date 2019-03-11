package com.csipl.hrms.service.payroll.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payrollprocess.PayrollControl;

public interface PayrollControlRepository extends CrudRepository<PayrollControl, Long> {
	
	
/*	String deparmentListForSalaryReconcilition ="SELECT   dp.departmentId,dp.departmentName, MIN(pc.processMonth) as processMonth  FROM  Department AS dp\r\n" + 
			"	   LEFT JOIN   PayRollLock AS prl ON prl.departmentId != dp.departmentId and prl.companyId=?1 \r\n" + 
			"	   LEFT JOIN   PayrollControl AS pc ON pc.processMonth = prl.processMonth and pc.activeStatus='OP' and prl.companyId=?1 \r\n" + 
			"	   WHERE	  dp.departmentId NOT IN( SELECT   pr.departmentId  FROM   PayRollLock pr  WHERE pr.processMonth = processMonth	) and   dp.companyId=?1	GROUP BY dp.departmentId";
 	*/
	String deparmentListForSalaryReconcilition ="select DISTINCT a.departmentId, d.departmentName from PayRollLock a left join Department d on a.departmentId=d.departmentId where a.isPayRollLocked='true' and a.processMonth=?2 and a.companyId=?1";
	
	/*String deparmentListForPayRollProcess ="SELECT   dp.departmentId,dp.departmentName, MIN(pc.processMonth) as processMonth  FROM  Department AS dp\r\n" + 
			"  LEFT JOIN   ReportPayOut AS rp ON rp.departmentId = dp.departmentId and rp.companyId=?1 and rp.processMonth=processMonth\r\n" + 
			"  LEFT JOIN   PayrollControl AS pc ON pc.processMonth = rp.processMonth and pc.activeStatus='OP'\r\n" + 
			"  WHERE	  dp.departmentId NOT IN( SELECT  rp.departmentId FROM   ReportPayOut rp  WHERE rp.processMonth = processMonth	) and   dp.companyId=?1	GROUP BY dp.departmentId \r\n" ;*/
	
	String deparmentListForPayRollProcess="select DISTINCT a.departmentId , dept.departmentName from Attendance a join Department dept on dept.departmentId=a.departmentId where a.processMonth=?2 and a.companyId=?1";	
	
	
	
		
	String findAllDepartmentForPayRoll ="SELECT   dp.departmentId,dp.departmentName, MIN(pc.processMonth) as processMonth  FROM  Department AS dp\r\n" + 
			"  LEFT JOIN   ReportPayOut AS rp ON rp.departmentId = dp.departmentId and rp.companyId=?1 and rp.processMonth=?2 \r\n" + 
			"  LEFT JOIN   PayrollControl AS pc ON pc.processMonth = rp.processMonth and pc.activeStatus='OP'\r\n" + 
			"  WHERE	  dp.departmentId NOT IN( SELECT  rp.departmentId FROM   ReportPayOut rp  WHERE rp.processMonth = ?2	) and   dp.companyId=?1	GROUP BY dp.departmentId \r\n" ;

	//select  a.mobile from Users u   join Employee e on e.userId=u.userId join Address a on e.userId=u.userId  where nameOfUser='Administrator' and a.addressId=e.presentAddressId

	@Query(" from PayrollControl pc  where pc.financialYear.company.companyId=?1 and pc.activeStatus='OP'") 
 	public List<PayrollControl>  findPayrollControl( long companyId);
	 
	@Query("select a.id.processMonth from Attendance a join PayrollControl pc on a.id.processMonth=pc.processMonth where pc.financialYear.company.companyId=?1 and pc.activeStatus='OP' Group By a.id.processMonth ") 
 	public List<String>  findPayrollProcessControl( long companyId);
	
	@Query("select DISTINCT a.id.processMonth from PayRollLock a  where a.company.companyId=?1") 
 	public List<String>  findPayrollProcessControl1( long companyId);
	
	
	@Query("select pc.processMonth from PayrollControl pc  where pc.financialYear.company.companyId=?1 and pc.activeStatus='OP' ") 
 	public List<String>  getPayrollOpenProMon( long companyId);
 
	@Query(" from PayrollControl pc where pc.financialYear.company.companyId=?1 and processMonth=?2 and pc.activeStatus='OP' ") 
 	public PayrollControl  findPayrollControlByMonth( long companyId, String processMonth );
    	
 	@Query(value=deparmentListForSalaryReconcilition,nativeQuery = true)
 	public List<Object[]> findAllDepartmentNotINPayrollLock(long companyId, String processMonth );
 	
 	@Query(value=deparmentListForPayRollProcess,nativeQuery = true)
 	public List<Object[]> findAllDepartmentNotINReportPayOut(long companyId, String processMonth);
 	
 	
 	@Query(value=findAllDepartmentForPayRoll,nativeQuery = true)
 	public List<Object[]> findAllDepartmentForPayRoll(long companyId, String processMonth  );
 	
 	@Query("SELECT pc.processMonth FROM PayrollControl pc  JOIN PayOut po ON  po.id.processMonth=pc.processMonth  WHERE pc.financialYear.financialYearId=?1 \r\n" + 
 			"GROUP BY pc.processMonth\r\n" + 
 			"\r\n" + 
 			"having COUNT(pc.processMonth)>0") 
 	public List<String> findPayrollProcessControlById(Long financialYearId);

 	}
