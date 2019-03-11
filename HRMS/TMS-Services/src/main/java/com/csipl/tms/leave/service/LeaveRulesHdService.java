package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.tms.model.leave.TMSLeaveRulesHd;



public interface LeaveRulesHdService {

	public TMSLeaveRulesHd save(TMSLeaveRulesHd leavePeriod);
	public List<TMSLeaveRulesHd> findAllLeaveRulesHd(Long companyId);
	public TMSLeaveRulesHd findLeaveRulesHd(Long companyId);
	
	public List<TMSLeaveRulesHd> findAllLeavePeriodId(Long leavePeriodId);
}
