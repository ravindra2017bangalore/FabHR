package com.csipl.hrms.service.payroll.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payrollprocess.FinancialYear;


public interface PayrollPeriodRepository  extends CrudRepository<FinancialYear, Long>{
	@Query(" from FinancialYear where financialYear=?1 and companyId=?2") 
 	public FinancialYear  findFinancialYear(String financialYear,Long companyId);

	@Query(" from FinancialYear where  companyId=?1 order by financialYearId desc ") 
	public FinancialYear findLatestFinancialYear( Long companyId);
}
