package com.csipl.hrms.service.payroll.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.TdsPayrollHd;

public interface TdsPayrollRepository extends CrudRepository<TdsPayrollHd, Long> {

	@Query(" from TdsPayrollHd where employeeId=?1 and financialYear=?2 and active='AC' ")
	 public TdsPayrollHd findTdsPayroll(Long employeeId, String financialYear);
}
