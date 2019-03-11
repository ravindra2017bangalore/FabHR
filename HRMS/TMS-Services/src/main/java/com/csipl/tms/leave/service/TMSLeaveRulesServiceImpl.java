package com.csipl.tms.leave.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.leave.repository.LeaveRulesHdRepository;
import com.csipl.tms.leave.repository.TMSLeaveRulesRepository;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;
@Service("TMSleaveRulesService")
public class TMSLeaveRulesServiceImpl implements TMSLeaveRulesService{
   
private static final Logger log = LoggerFactory.getLogger(TMSLeaveRulesServiceImpl.class);

	@Autowired
	private TMSLeaveRulesRepository leaveRulesRepository;

	@Autowired
	private LeaveRulesHdRepository leaveRulesHdRepository;
	
	@Override
	public TMSLeaveRules save(TMSLeaveRules leaveRules) {
		log.info("TMSLeaveRulesServiceImpl.save()");		
		return leaveRulesRepository.save(leaveRules);
	}

	@Override
	public TMSLeaveRulesHd findLeaveRulesHd(Long leavePeriodId) {
		 
		
		log.info("TMSLeaveRulesServiceImpl.findAllLeaveType()");		
		return   leaveRulesHdRepository.findLeaveRulesHdByPeriodId(leavePeriodId) ;
	}

	@Override
	public List<Object[]> findAllRulesByPeriodId(Long leavePeriodId) {
		return leaveRulesHdRepository.findAllRulesByPeriodId(leavePeriodId);
	}
	
	
}
