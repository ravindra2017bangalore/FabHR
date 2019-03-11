package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payrollprocess.PayRollLock;


public interface PayRollLockRepository extends CrudRepository<PayRollLock, Long>{
	
	@Query(" select count( prl ) from PayRollLock prl where  prl.id.processMonth=?2  and prl.company.companyId =?1 and prl.isPayRollLocked='true' ")
	int  isSalaryProcessStartedForCompany(Long companyId, String processMonth);
	
	@Query(" select count( prl ) from PayRollLock prl where  prl.id.processMonth=?2  and prl.id.departmentId =?1  and prl.isPayRollLocked='true' ")
	int  isSalaryProcessStartedForDepartment(Long departmentId, String processMonth);
	
	@Query(" from PayRollLock prl where  prl.id.processMonth=?1 and prl.id.departmentId =?2  ")
	public PayRollLock findpayRollLock(String processMonth,Long departmentId);
	
	@Query(" from PayRollLock prl where  prl.id.processMonth=?1 ")
	public List<PayRollLock> findpayRollLock(String processMonth);

	//a.isPayRollLocked='true' and
	String deparmentListForSalaryReconcilition ="select DISTINCT a.departmentId, d.departmentName from PayRollLock a left join Department d on a.departmentId=d.departmentId where  a.processMonth=?2 and a.companyId=?1";

	@Query(value=deparmentListForSalaryReconcilition,nativeQuery = true)
 	public List<Object[]> findDepartmentForSalaryGenerate(long companyId, String processMonth );

	
}
