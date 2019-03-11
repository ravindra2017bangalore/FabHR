package com.csipl.tms.halfdayrule.adaptor;

import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.halfdayrule.HalfDayRuleDTO;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.service.Adaptor;

public class HalfDayRuleAdaptor implements Adaptor<HalfDayRuleDTO, HalfDayRule> {

	@Override
	public List<HalfDayRule> uiDtoToDatabaseModelList(List<HalfDayRuleDTO> uiobj) {

		return null;
	}

	@Override
	public List<HalfDayRuleDTO> databaseModelToUiDtoList(List<HalfDayRule> halfDayRuleList) {

		return null;
	}

	@Override
	public HalfDayRule uiDtoToDatabaseModel(HalfDayRuleDTO halfDayRuleDto) {
		HalfDayRule halfDayRule = new HalfDayRule();

		if (halfDayRuleDto.getHalfDayRuleId() != null) {
			halfDayRule.setHalfDayRuleId(halfDayRuleDto.getHalfDayRuleId());
			halfDayRule.setCreatedDate(halfDayRuleDto.getCreatedDate());
		} else {
			halfDayRule.setCreatedDate(new Date());
		}
		/*Company company = new Company();
		company.setCompanyId(halfDayRuleDto.getCompanyId());
		halfDayRule.setCompany(company);*/
		halfDayRule.setCompanyId(halfDayRuleDto.getCompanyId());
		halfDayRule.setMinimumRequireHour(halfDayRuleDto.getMinimumRequireHour());
		halfDayRule.setMaximumRequireHour(halfDayRuleDto.getMaximumRequireHour());
		halfDayRule.setUserId(halfDayRuleDto.getUserId());
		halfDayRule.setUpdatedId(halfDayRuleDto.getUpdateUserId());
		halfDayRule.setUpdatedDate(new Date());

		return halfDayRule;
	}

	@Override
	public HalfDayRuleDTO databaseModelToUiDto(HalfDayRule halfDayRule) {
		HalfDayRuleDTO halfDayRuleDto = new HalfDayRuleDTO();
		halfDayRuleDto.setHalfDayRuleId(halfDayRule.getHalfDayRuleId());
		halfDayRuleDto.setMinimumRequireHour(halfDayRule.getMinimumRequireHour());
		halfDayRuleDto.setMaximumRequireHour(halfDayRule.getMaximumRequireHour());
		halfDayRuleDto.setCompanyId(halfDayRule.getCompanyId());
		halfDayRuleDto.setUserId(halfDayRule.getUserId());
		halfDayRuleDto.setCreatedDate(halfDayRule.getCreatedDate());
		return halfDayRuleDto;
	}

}
