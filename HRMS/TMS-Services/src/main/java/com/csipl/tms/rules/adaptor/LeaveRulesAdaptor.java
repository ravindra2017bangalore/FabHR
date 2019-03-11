package com.csipl.tms.rules.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.leave.TMSLeaveRulesDTO;
//import com.csipl.hrms.common.model.Company;
import com.csipl.tms.dto.rules.LeaveRuleDTO;
import com.csipl.tms.model.leave.TMSLeaveType;
import com.csipl.tms.model.rules.LeaveRule;
import com.csipl.tms.service.Adaptor;

public class LeaveRulesAdaptor implements Adaptor<LeaveRuleDTO, LeaveRule> {

	@Override
	public List<LeaveRule> uiDtoToDatabaseModelList(List<LeaveRuleDTO> leaveRuleDtoList) {
		List<LeaveRule> leaveRuleList = new ArrayList<LeaveRule>();

		for (LeaveRuleDTO leaveRuleDto : leaveRuleDtoList) {
		
			leaveRuleList.add(uiDtoToDatabaseModel(leaveRuleDto));
		}
		return leaveRuleList;
	}

	@Override
	public List<LeaveRuleDTO> databaseModelToUiDtoList(List<LeaveRule> leaveRuleList) {
		List<LeaveRuleDTO>  leaveRuleDtoList=new ArrayList<LeaveRuleDTO>() ;
		for (LeaveRule leaveRule : leaveRuleList) {
			leaveRuleDtoList.add(databaseModelToUiDto(leaveRule));
		}
 		return leaveRuleDtoList;
	}

	@Override
	public LeaveRule uiDtoToDatabaseModel(LeaveRuleDTO leaveRuleDto) {
		LeaveRule leaveRule = new LeaveRule();
		//Company company=new Company();
		TMSLeaveType leaveType=new TMSLeaveType();

		if (leaveRuleDto.getLeaveRuleId() != null) {
			leaveRule.setLeaveRuleId(leaveRuleDto.getLeaveRuleId());
			leaveRule.setDateCreated(leaveRuleDto.getDateCreated());
		}else {
			leaveRule.setDateCreated( new Date());
		}
 		leaveRule.setIsWeekOffAsPL(leaveRuleDto.getIsWeekOffAsPL());
 		leaveType.setLeaveTypeId(leaveRuleDto.getLeaveTypeId());
 		leaveRule.setTmsleaveType(leaveType);
		leaveRule.setLeaveIndex(leaveRuleDto.getLeaveIndex());
		leaveRule.setLeaveIndexDay(leaveRuleDto.getLeaveIndexDay());
		leaveRule.setUserId(leaveRuleDto.getUserId());
		leaveRule.setUserIdUpdate(leaveRuleDto.getUserIdUpdate());
		leaveRule.setWeekOffAsPLCount(leaveRuleDto.getWeekOffAsPLCount());
		//company.setCompanyId(leaveRuleDto.getCompanyId());
 		//leaveRule.setCompany(company);
 		leaveRule.setDateUpdate(new Date());
 		return leaveRule;
	}

	@Override
	public LeaveRuleDTO databaseModelToUiDto(LeaveRule leaveRule) {
 		LeaveRuleDTO leaveRuleDto=new LeaveRuleDTO();
 		leaveRuleDto.setLeaveRuleId(leaveRule.getLeaveRuleId());
 		leaveRuleDto.setIsWeekOffAsPL(leaveRule.getIsWeekOffAsPL());
 		leaveRuleDto.setLeaveTypeId(leaveRule.getTmsleaveType().getLeaveTypeId());
 		//leaveRuleDto.setLeaveType(leaveRule.getTmsleaveType().getLeaveType());
 		leaveRuleDto.setLeaveTypeId(leaveRule.getTmsleaveType().getLeaveTypeId());
 		leaveRuleDto.setLeaveIndex(leaveRule.getLeaveIndex());
		leaveRuleDto.setLeaveIndexDay(leaveRule.getLeaveIndexDay());
  		leaveRuleDto.setWeekOffAsPLCount(leaveRule.getWeekOffAsPLCount());
		leaveRuleDto.setUserId(leaveRule.getUserId());
		leaveRuleDto.setDateCreated(leaveRule.getDateCreated());
		
 		return leaveRuleDto;
	}

	
	
	
	/*public List<LeaveRuleDTO> databaseModelToUiRuleDto(List<Object[]> leaveRule) {
 		LeaveRuleDTO leaveRuleDto=new LeaveRuleDTO();
 		leaveRuleDto.setLeaveRuleId(leaveRule.getLeaveRuleId());
 		leaveRuleDto.setIsWeekOffAsPL(leaveRule.getIsWeekOffAsPL());
 		leaveRuleDto.setLeaveTypeId(leaveRule.getTmsleaveType().getLeaveTypeId());
 		//leaveRuleDto.setLeaveType(leaveRule.getTmsleaveType().getLeaveType());
 		leaveRuleDto.setLeaveTypeId(leaveRule.getTmsleaveType().getLeaveTypeId());
 		leaveRuleDto.setLeaveIndex(leaveRule.getLeaveIndex());
		leaveRuleDto.setLeaveIndexDay(leaveRule.getLeaveIndexDay());
  		leaveRuleDto.setWeekOffAsPLCount(leaveRule.getWeekOffAsPLCount());
		leaveRuleDto.setUserId(leaveRule.getUserId());
		leaveRuleDto.setDateCreated(leaveRule.getDateCreated());
		
 		return leaveRuleDto;
	}*/
}
