package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;

public interface PreviousEmployerIncomeRepository extends CrudRepository<PreviousEmployerIncomeTds, Long> {

	String findPreviousEmployerIncome = "SELECT pi.previousEmployerIncomeId,pi.particular, pit.previousEmployerIncomeTdsId, pit.amount,pit.financialYear, \r\n"
			+ "pit.employeeId, pit.userId, pit.dateCreated FROM PreviousEmployerIncome pi LEFT JOIN PreviousEmployerIncomeTds pit ON \r\n"
			+ "pi.previousEmployerIncomeId=pit.previousEmployerIncomeId and employeeId=?1 and financialYear=?2";
	
	@Query(value = findPreviousEmployerIncome ,nativeQuery = true)
	public List<Object[]> findAllPreviousEmployerIncome(Long employeeId, String financialYear);
	
	@Query("from PreviousEmployerIncomeTds where employeeId=?1 and financialYear=?2")
	public List<PreviousEmployerIncomeTds> getAllPreviousEmployerIncome(Long employeeId, String financialYear);
}
