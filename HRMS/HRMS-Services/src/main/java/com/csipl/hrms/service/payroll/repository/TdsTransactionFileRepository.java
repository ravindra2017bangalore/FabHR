package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsTransactionFile;

public interface TdsTransactionFileRepository extends CrudRepository<TdsTransactionFile, Long> {
	@Query("from TdsTransactionFile where employeeId=?1")
	public List<TdsTransactionFile> findAllTdsTransactionFile(Long employeeId);
}
