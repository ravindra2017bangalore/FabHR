package com.csipl.tms.rules.service;

import java.util.List;

import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.rules.LeaveRule;
import com.csipl.tms.model.rules.SandWichRule;

public interface RulesService {

 
	public SandWichRule getSandwich(Long companyId);

	public void save(SandWichRule sandWichRule);

	public HalfDayRule getHalfDayRule(Long companyId);

	public void save(HalfDayRule halfDayRule);

	public LeaveRule getLeaveRule(Long leaveRuleId);

	public List<LeaveRule> getLeaveRuleList(Long companyId);

	public void save(LeaveRule leaveRule);

}
