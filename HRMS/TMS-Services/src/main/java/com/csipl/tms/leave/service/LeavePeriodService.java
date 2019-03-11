package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.tms.model.leave.TMSLeavePeriod;


public interface LeavePeriodService {
	public TMSLeavePeriod save(TMSLeavePeriod leavePeriod);
	public List<TMSLeavePeriod> findAllLeavePeriod(Long companyId);
	public List<TMSLeavePeriod> findleavePeriodStatus(Long companyId);
}
