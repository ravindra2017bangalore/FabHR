package com.csipl.hrms.service.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.common.Branch;
import com.csipl.hrms.service.organization.repository.BranchRepository;

@Service("branchService")
public class BranchServiceImpl implements BranchService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);
	
 	@Autowired
	private BranchRepository branchRepository;

	/**
	 * Save OR update branch object into Database
	 */
	@Override
	public Branch save(Branch branch) {
 		branch = branchRepository.save(branch);
		return branch;
	}
 	/**
	 * To get List of branches from Database based on companyId
	 */
	@Override
	public List<Branch> findAllBranches(Long companyId) {
  		return branchRepository.findAllBranches(companyId);
 	}
 	/**
	 * To get  branch data from Database based on branchId (Primary key)
	 */
	@Override
	public Branch findBranch(Long branchId) {
 		return branchRepository.findOne(branchId);
	}
}
