package com.csipl.tms.rules.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.rules.LeaveRule;
  
public interface LeaveRulesRepository extends CrudRepository<LeaveRule, Long> {
 
	@Query("from LeaveRule where companyId=?1")
	public List<LeaveRule> getLeaveRuleList(Long companyId);
}
