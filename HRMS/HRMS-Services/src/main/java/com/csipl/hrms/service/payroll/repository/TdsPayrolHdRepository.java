package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsPayrollHd;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;

public interface TdsPayrolHdRepository  extends CrudRepository<TdsPayrollHd, Long>{
	//@Query(" from TdsSection ORDER BY  tdsSectionId  DESC")
  //  public  List<TdsPayrollHd> findAllTdsSections() ;
	
	
	@Query("from TdsPayrollHd tp  where tp.employee.employeeId=?1 and tp.financialYear=?2 and tp.active='AC'")
	public TdsPayrollHd getTdsPayrollHd(long empId,String financialYear);	
}