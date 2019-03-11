package com.csipl.hrms.service.payroll.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.OtherIncome;

public interface OtherIncomeRepository extends CrudRepository<OtherIncome, Long> {
	
	String queryForStatusUPDATE = "UPDATE OtherIncome SET status='Declared' WHERE employeeId=?1 and financialYear=?2";
	
	@Query(" from OtherIncome where employeeId=?1 and financialYear=?2")
    public List<OtherIncome> findAllOtherIncome(Long employeeId, String financialYear);
	
	@Query("SELECT SUM(amount) from OtherIncome where employeeId=?1 and financialYear=?2")
	public BigDecimal findOtherIncomeSum(Long employeeId, String financialYear);
	
	 @Modifying
	    @Query(value=queryForStatusUPDATE, nativeQuery=true)
	    public void updateStatus( Long employeeId,String financialYear);
	
}
