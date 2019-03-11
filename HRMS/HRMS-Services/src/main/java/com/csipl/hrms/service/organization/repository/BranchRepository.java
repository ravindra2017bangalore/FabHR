package com.csipl.hrms.service.organization.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.Branch;

public interface BranchRepository extends CrudRepository<Branch, Long> {

	@Query(" from Branch where companyId=?1  ORDER BY  branchId  DESC ")
	public List<Branch> findAllBranches(Long companyId);
	
	
}
