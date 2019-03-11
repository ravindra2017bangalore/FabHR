package com.csipl.tms.rules.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.csipl.hrms.common.model.Company;
import com.csipl.tms.dto.rules.SandWichRuleDTO;
import com.csipl.tms.model.rules.SandWichRule;
import com.csipl.tms.service.Adaptor;

public class SandWichRuleAdaptor implements Adaptor<SandWichRuleDTO, SandWichRule> {

	@Override
	public List<SandWichRule> uiDtoToDatabaseModelList(List<SandWichRuleDTO> sandWichRuleDtoList) {
		List<SandWichRule> sandWichRuleList = new ArrayList<SandWichRule>();
		for (SandWichRuleDTO sandWichRuleDto : sandWichRuleDtoList) {
			sandWichRuleList.add(uiDtoToDatabaseModel(sandWichRuleDto));
		}
		return sandWichRuleList;
	}

	@Override
	public List<SandWichRuleDTO> databaseModelToUiDtoList(List<SandWichRule> sandWichRuleList) {
		List<SandWichRuleDTO> sandWichRuleDtoList = new ArrayList<SandWichRuleDTO>();
		for (SandWichRule sandWichRule : sandWichRuleList) {
			sandWichRuleDtoList.add(databaseModelToUiDto(sandWichRule));
		}
		return sandWichRuleDtoList;
	}

	@Override
	public SandWichRule uiDtoToDatabaseModel(SandWichRuleDTO sandWichRuleDto) {
		//Company company=new Company();
		SandWichRule sandWichRule = new SandWichRule();
		sandWichRule.setHolidayBeforeAfterWeekOffs(sandWichRuleDto.getHolidayBeforeAfterWeekOffs());
		sandWichRule.setHolidayBetweenTwoAbsent(sandWichRuleDto.getHolidayBetweenTwoAbsent());
		sandWichRule.setWeekOffBeforeAfterWeekOffs(sandWichRuleDto.getWeekOffBeforeAfterWeekOffs());
		sandWichRule.setWeekOffBetweenTwoAbsent(sandWichRuleDto.getWeekOffBetweenTwoAbsent());
 		if(sandWichRuleDto.getSandWichId() !=null) {
			sandWichRule.setSandWichId(sandWichRuleDto.getSandWichId());
 			sandWichRule.setDateCreated(sandWichRuleDto.getDateCreated());
 		}
		else {
 			sandWichRule.setDateCreated(new Date());
 		}
		//company.setCompanyId(sandWichRuleDto.getCompanyId());
		//sandWichRule.setCompany(company);
 		sandWichRule.setCompanyId(sandWichRuleDto.getCompanyId());
		sandWichRule.setUserId(sandWichRuleDto.getUserId());
		sandWichRule.setDateUpdate(new Date());
		sandWichRule.setUserIdUpdate(sandWichRuleDto.getUserIdUpdate());
		return sandWichRule;
	}

	@Override
	public SandWichRuleDTO databaseModelToUiDto(SandWichRule sandWichRule) {
		SandWichRuleDTO sandWichRuleDto = new SandWichRuleDTO();
		sandWichRuleDto.setSandWichId(sandWichRule.getSandWichId());
		sandWichRuleDto.setHolidayBeforeAfterWeekOffs(sandWichRule.getHolidayBeforeAfterWeekOffs());
		sandWichRuleDto.setHolidayBetweenTwoAbsent(sandWichRule.getHolidayBetweenTwoAbsent());
		sandWichRuleDto.setWeekOffBeforeAfterWeekOffs(sandWichRule.getWeekOffBeforeAfterWeekOffs());
		sandWichRuleDto.setWeekOffBetweenTwoAbsent(sandWichRule.getWeekOffBetweenTwoAbsent());
 		sandWichRuleDto.setDateCreated(sandWichRule.getDateCreated());
		sandWichRuleDto.setUserId(sandWichRule.getUserId());
		sandWichRuleDto.setCompanyId(sandWichRule.getCompanyId());
  		return sandWichRuleDto;
	}

}
