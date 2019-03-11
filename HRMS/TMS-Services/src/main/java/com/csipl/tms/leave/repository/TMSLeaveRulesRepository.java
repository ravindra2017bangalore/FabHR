package com.csipl.tms.leave.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.leave.TMSLeaveRules;

public interface TMSLeaveRulesRepository extends CrudRepository<TMSLeaveRules, Long>{
	  
	
	@Query(" from TMSLeaveRules where leaveRulehdId =?1 ")
    public List<TMSLeaveRules> findAllLeaveRule(Long LeaveRulehdId);
}
