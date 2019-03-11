package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.Bank;

public interface CorpBankRepository extends CrudRepository<Bank, Long>{
	
	@Query(" from Bank where companyId=?1 ORDER BY bankId  DESC ")
    public List<Bank> findAllBank(Long companyId);
}
