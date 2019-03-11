package com.csipl.tms.leave.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.leave.repository.LeaveRulesHdRepository;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;

@Transactional
@Service("leaveRulesHdService")
public class LeaveRulesHdServiceImpl implements LeaveRulesHdService{
   
private static final Logger log = LoggerFactory.getLogger(LeaveRulesHdServiceImpl.class);

	@Autowired
	LeaveRulesHdRepository leaveRulesHdRepository;
	
	@Override
	public TMSLeaveRulesHd save(TMSLeaveRulesHd leavePeriod) {
		// TODO Auto-generated method stub
		return leaveRulesHdRepository.save(leavePeriod);
	}

	@Override
	public List<TMSLeaveRulesHd> findAllLeaveRulesHd(Long companyId) {
		// TODO Auto-generated method stub
		return leaveRulesHdRepository.findAllLeaveRulesHd(companyId);
	}

	@Override
	public TMSLeaveRulesHd findLeaveRulesHd(Long companyId) {
		// TODO Auto-generated method stub
		return leaveRulesHdRepository.findLeaveRulesHd(companyId);
	}

       
	@Override
	public List<TMSLeaveRulesHd> findAllLeavePeriodId(Long leavePeriodId) {
		log.info("LeaveRulesHdServiceImpl.findAllLeavePeriodId()");
		return leaveRulesHdRepository.findAllLeaveRulesHd(leavePeriodId);
	}

}
