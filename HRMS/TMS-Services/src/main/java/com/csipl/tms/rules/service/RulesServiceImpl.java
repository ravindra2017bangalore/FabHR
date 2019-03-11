package com.csipl.tms.rules.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.halfdayrule.repository.HalfDayRuleRepository;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.rules.LeaveRule;
import com.csipl.tms.model.rules.SandWichRule;
import com.csipl.tms.rules.repository.LeaveRulesRepository;
import com.csipl.tms.rules.repository.SandWichRuleRepository;

@Transactional
@Service("rulesService")
public class RulesServiceImpl implements RulesService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(RulesServiceImpl.class);

	@Autowired
	SandWichRuleRepository sandWichRuleRepository;
	
	@Autowired
	LeaveRulesRepository leaveRulesRepository;

	@Autowired
	HalfDayRuleRepository halfDayRuleRepository;
 
	@Override
	public SandWichRule getSandwich(Long companyId) {
		logger.info("getSandwich  in service companyId ->> :" + companyId);
  		return sandWichRuleRepository.getSandwichRules(companyId);
	}

	@Override
	public void save(SandWichRule sandWichRule) {
		logger.info("save  in service   :" + sandWichRule.toString());
		sandWichRuleRepository.save(sandWichRule);
	}

	@Override
	public HalfDayRule getHalfDayRule(Long companyId) {
		return halfDayRuleRepository.getHalfDayRule(companyId);
	}

	@Override
	public void save(HalfDayRule halfDayRule) {
		halfDayRuleRepository.save(halfDayRule);
	}

	@Override
	public LeaveRule getLeaveRule(Long leaveRuleId) {
		return leaveRulesRepository.findOne(leaveRuleId);
	}

	@Override
	public List<LeaveRule> getLeaveRuleList(Long companyId) {
 		return leaveRulesRepository.getLeaveRuleList(companyId);
	}

	@Override
	public void save(LeaveRule leaveRule) {
		leaveRulesRepository.save(leaveRule);		
	}
}
