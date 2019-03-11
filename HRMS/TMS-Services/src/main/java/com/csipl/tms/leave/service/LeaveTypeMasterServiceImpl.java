package com.csipl.tms.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.leave.repository.LeaveTypeMasterRepository;
import com.csipl.tms.model.leave.TMSLeaveTypeMaster;
@Service("leaveTypeMasterService")
public class LeaveTypeMasterServiceImpl implements LeaveTypeMasterService{

	@Autowired
	private LeaveTypeMasterRepository leavePeriodRepository;
	
	@Override
	public TMSLeaveTypeMaster save(TMSLeaveTypeMaster leavePeriod) {
		
		return leavePeriodRepository.save(leavePeriod);
	}

	@Override
	public List<TMSLeaveTypeMaster> findAllLeaveTypeMaster(Long companyId) {
	
		return leavePeriodRepository.findAllLeaveTypeMaster(companyId);
	}

}
