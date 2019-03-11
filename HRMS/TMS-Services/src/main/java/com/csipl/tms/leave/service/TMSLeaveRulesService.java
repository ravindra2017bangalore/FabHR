package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;



public interface TMSLeaveRulesService {
	
	public TMSLeaveRules save(TMSLeaveRules leaveRules);
	public TMSLeaveRulesHd findLeaveRulesHd(Long leavePeriodId );
	public List<Object[]> findAllRulesByPeriodId(Long leavePeriodId);
}
