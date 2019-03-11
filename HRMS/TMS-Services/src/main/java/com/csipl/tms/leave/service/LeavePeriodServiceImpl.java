package com.csipl.tms.leave.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.leave.adaptor.LeavePeriodAdaptor;
import com.csipl.tms.leave.repository.LeavePeriodRepository;
import com.csipl.tms.leave.repository.LeaveRulesHdRepository;
import com.csipl.tms.leave.repository.TMSLeaveRuleMasterRepository;
import com.csipl.tms.model.leave.TMSLeavePeriod;
import com.csipl.tms.model.leave.TMSLeaveRuleMaster;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;

@Service("leavePeriodService")
public class LeavePeriodServiceImpl implements LeavePeriodService {

	@Autowired
	private LeavePeriodRepository leavePeriodRepository;

	@Autowired
	private LeaveRulesHdRepository leaveRulesHdRepository;

	@Autowired
	private TMSLeaveRuleMasterRepository tMSLeaveRuleMasterRepository;

	 
	LeavePeriodAdaptor leavePeriodAdaptor= new LeavePeriodAdaptor();
	
	@Transactional
	@Override
	public TMSLeavePeriod save(TMSLeavePeriod leavePeriod) {
		TMSLeavePeriod tMSLeavePeriod = null;

		if (leavePeriod.getActiveStatus().equals(StatusMessage.DEACTIVE_CODE)) {
			TMSLeaveRulesHd tMSLeaveRulesHd = leaveRulesHdRepository
					.findLeaveRulesHdByPeriodId(leavePeriod.getLeavePeriodId());
			tMSLeaveRulesHd.setActiveStatus(leavePeriod.getActiveStatus());
			leaveRulesHdRepository.save(tMSLeaveRulesHd);
			return leavePeriodRepository.save(leavePeriod);

		}
		if (leavePeriod.getLeavePeriodId() == null) {

			tMSLeavePeriod = leavePeriodRepository.save(leavePeriod);
			List<TMSLeaveRuleMaster> tMSLeaveRuleMasterList = tMSLeaveRuleMasterRepository.findAllLeaveRule(tMSLeavePeriod.getCompanyId());
			
			TMSLeaveRulesHd tMSLeaveRulesHd = new TMSLeaveRulesHd();
			tMSLeaveRulesHd.setCompanyId(tMSLeavePeriod.getCompanyId());
			tMSLeaveRulesHd.setLeavePeriodId(tMSLeavePeriod.getLeavePeriodId());
			tMSLeaveRulesHd.setUserId(tMSLeavePeriod.getUserId());
			tMSLeaveRulesHd.setDateCreated(new Date());
			tMSLeaveRulesHd.setDateUpdate(new Date());
			tMSLeaveRulesHd.setUserIdUpdate(tMSLeavePeriod.getUserId());
			tMSLeaveRulesHd.setActiveStatus(tMSLeavePeriod.getActiveStatus());

			List<TMSLeaveRules> tMSLeaveRulesList = new ArrayList<TMSLeaveRules>();
			
			
			for(TMSLeaveRuleMaster rule:tMSLeaveRuleMasterList) {
			
				tMSLeaveRulesList.add(leavePeriodAdaptor.tMSLeaveRuleMasterToTMSLeaveRule(rule, tMSLeaveRulesHd));
			}
			tMSLeaveRulesHd.setTmsleaveRules(tMSLeaveRulesList);
			
			leaveRulesHdRepository.save(tMSLeaveRulesHd);
			return tMSLeavePeriod;
		}

		return leavePeriodRepository.save(leavePeriod);
	}

	@Override
	public List<TMSLeavePeriod> findAllLeavePeriod(Long companyId) {
		return leavePeriodRepository.findAllLeavePeriod(companyId);
	}

	@Override
	public List<TMSLeavePeriod> findleavePeriodStatus(Long companyId) {
		return leavePeriodRepository.findleavePeriodStatus(companyId);
	}

}
