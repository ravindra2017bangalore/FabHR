package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.tms.model.leave.TMSLeaveType;



public interface LeaveTypeService {
	public TMSLeaveType getLeaveTypeById(Long leaveTypeId);
	public TMSLeaveType save(TMSLeaveType leavePeriod);
	public List<TMSLeaveType> findAllLeaveType(Long companyId);
	
	public List<TMSLeaveType> findAllLeavePeriod(Long leavePeriodId);
  }
