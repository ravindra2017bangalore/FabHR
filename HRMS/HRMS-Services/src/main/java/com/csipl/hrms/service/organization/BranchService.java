package com.csipl.hrms.service.organization;

import java.util.List;
import com.csipl.hrms.model.common.Branch;

 public interface BranchService {
	public Branch save(Branch branch );
 	public List<Branch> findAllBranches(Long companyId);
 	public Branch findBranch(Long branchId);
  }
