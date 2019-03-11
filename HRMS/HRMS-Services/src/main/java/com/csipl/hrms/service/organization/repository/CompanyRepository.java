package com.csipl.hrms.service.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	
	
	@Query(" from Company ORDER BY  companyId  DESC")
    public List<Company> findAllCompany();
	
	@Query(" from Company where companyId=?1 ORDER BY  companyId  DESC")
    public List<Company> findAllCompany(Long compnyeeId);
	


}

