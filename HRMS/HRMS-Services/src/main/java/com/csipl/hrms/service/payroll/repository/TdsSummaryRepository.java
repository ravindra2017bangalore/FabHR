package com.csipl.hrms.service.payroll.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.csipl.hrms.model.payroll.TdsSummary;

public interface TdsSummaryRepository extends CrudRepository<TdsSummary, Long> {
	
	@Query("from TdsSummary ts  where ts.employee.employeeId=?1 and ts.financialYear=?2 and ts.active='AC' ")  //
	public TdsSummary findTdsSummary(long empId,String financialYear);	


}
