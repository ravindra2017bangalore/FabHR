package com.csipl.tms.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.leave.repository.TMSLeaveRuleMasterRepository;
import com.csipl.tms.model.leave.TMSLeaveRuleMaster;

@Service
public class TMSLeaveRuleMasterServiceImpl implements TMSLeaveRuleMasterService{

	@Autowired
	TMSLeaveRuleMasterRepository tMSLeaveRuleMasterRepository;
	
	@Override
	public List<TMSLeaveRuleMaster> findAllLeaveTypeMaster(Long companyId) {
		 
		return tMSLeaveRuleMasterRepository.findAllLeaveRule(companyId);
	}

}
