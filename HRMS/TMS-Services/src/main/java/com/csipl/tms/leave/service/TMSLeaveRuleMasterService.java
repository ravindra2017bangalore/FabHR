package com.csipl.tms.leave.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.csipl.tms.model.leave.TMSLeaveRuleMaster;


@Component
public interface TMSLeaveRuleMasterService {
	 
	public List<TMSLeaveRuleMaster> findAllLeaveTypeMaster(Long companyId);
}
