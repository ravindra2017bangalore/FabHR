package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.tms.model.leave.TMSLeaveTypeMaster;



public interface LeaveTypeMasterService {
	public TMSLeaveTypeMaster save(TMSLeaveTypeMaster leavePeriod);
	public List<TMSLeaveTypeMaster> findAllLeaveTypeMaster(Long companyId);
}
