package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsApproved;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;

public interface TdsApprovalRepository extends CrudRepository<TransactionApprovedHd, Long>{
	
	
	/*	@Query(" from TdsGroup where  (effectiveEndDate is null or effectiveEndDate>?1) and (effectiveStartDate is NOT null and effectiveStartDate<=?1)")
    public List<TdsGroup> findAllInvestment(Date today);
	
	@Query(" from TdsGroup where tdsGroupId=?1")
	public TdsGroup findInvestment(long tdsGroupId);*/	
	
	
	@Query("from TransactionApprovedHd ta  where ta.employee1.employeeId=?1 and financialYear=?2 and active='AC'")
	public TransactionApprovedHd getTransactionApprovedHd(long empId,String financialYear);	
	
	
	@Query("from TdsTransaction tt  where tt.employee.employeeId=?1 and tt.financialYear=?2")
    public List<TdsTransaction> getTdsTrasactionList(long empId,String financialYear);	
	
}
