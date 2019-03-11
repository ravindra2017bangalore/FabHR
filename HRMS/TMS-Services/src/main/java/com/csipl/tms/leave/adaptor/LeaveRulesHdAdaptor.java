package com.csipl.tms.leave.adaptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.tms.dto.leave.TMSLeaveRulesDTO;
import com.csipl.tms.dto.leave.TMSLeaveRulesHdDTO;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;
import com.csipl.tms.service.Adaptor;

public class LeaveRulesHdAdaptor implements Adaptor<TMSLeaveRulesHdDTO, TMSLeaveRulesHd> {

	private static final Logger log = LoggerFactory.getLogger(LeaveRulesHdAdaptor.class);

	@Override
	public List<TMSLeaveRulesHd> uiDtoToDatabaseModelList(List<TMSLeaveRulesHdDTO> tMSLeaveRulesHdDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TMSLeaveRulesHdDTO> databaseModelToUiDtoList(List<TMSLeaveRulesHd> tmsLeaveRulesHdList) {
		log.info("LeaveRulesHdAdaptor.databaseModelToUiDtoList()");
		List<TMSLeaveRulesHdDTO> tMSLeaveRulesHdDtoList = new ArrayList<TMSLeaveRulesHdDTO>();
		for (TMSLeaveRulesHd tMSLeaveRulesHd : tmsLeaveRulesHdList) {
			TMSLeaveRules tmsLeaveRules = new TMSLeaveRules();
			TMSLeaveRulesDTO tmsLeaveRulesDto = new TMSLeaveRulesDTO();

			tmsLeaveRules.setActiveStatus(tmsLeaveRulesDto.getActiveStatus());
			tmsLeaveRules.setDescription(tmsLeaveRulesDto.getDescription());
			// tms.setRuleCode(dto.getRuleCode());
			// tms.setRuleName(dto.getRuleName());
			tmsLeaveRules.setUserId(tmsLeaveRulesDto.getUserId());
			tmsLeaveRules.setLeaveRuleId(tmsLeaveRulesDto.getLeaveRuleId());
			tmsLeaveRules.setDays(tmsLeaveRulesDto.getDays());
			tmsLeaveRules.setDateCreated(tmsLeaveRulesDto.getDateCreated());
			tmsLeaveRules.setDateUpdate(tmsLeaveRulesDto.getDateUpdate());
			tMSLeaveRulesHd.addTmsleaveRule(tmsLeaveRules);
			tMSLeaveRulesHdDtoList.add(databaseModelToUiDto(tMSLeaveRulesHd));
		}
		return tMSLeaveRulesHdDtoList;
	}

	@Override
	public TMSLeaveRulesHd uiDtoToDatabaseModel(TMSLeaveRulesHdDTO tMSLeaveRulesHdDTO) {
		log.info("LeaveRulesHdAdaptor.uiDtoToDatabaseModel()");
		TMSLeaveRulesHd tMSLeaveRulesHd = new TMSLeaveRulesHd();

		tMSLeaveRulesHd.setActiveStatus(tMSLeaveRulesHdDTO.getActiveStatus());
		tMSLeaveRulesHd.setCompanyId(tMSLeaveRulesHdDTO.getCompanyId());
		tMSLeaveRulesHd.setLeaveRulesHdId(tMSLeaveRulesHdDTO.getLeaveRulesHdId());
		tMSLeaveRulesHd.setUserId(tMSLeaveRulesHdDTO.getUserId());
		tMSLeaveRulesHd.setLeavePeriodId(tMSLeaveRulesHdDTO.getLeavePeriodId());
		tMSLeaveRulesHd.setDateCreated(tMSLeaveRulesHdDTO.getDateCreated());
		tMSLeaveRulesHd.setDateCreated(tMSLeaveRulesHdDTO.getDateCreated());
		tMSLeaveRulesHd.setDateUpdate(tMSLeaveRulesHdDTO.getDateUpdate());
		return tMSLeaveRulesHd;
	}

	@Override
	public TMSLeaveRulesHdDTO databaseModelToUiDto(TMSLeaveRulesHd tMSLeaveRulesHd) {
		log.info("LeaveRulesHdAdaptor.databaseModelToUiDto()");
		TMSLeaveRulesHdDTO tMSLeaveRulesHdDTO = new TMSLeaveRulesHdDTO();
		tMSLeaveRulesHdDTO.setCompanyId(tMSLeaveRulesHd.getCompanyId());
		tMSLeaveRulesHdDTO.setActiveStatus(tMSLeaveRulesHd.getActiveStatus());
		tMSLeaveRulesHdDTO.setLeaveId(tMSLeaveRulesHd.getLeavePeriodId());
		tMSLeaveRulesHdDTO.setLeaveRulesHdId(tMSLeaveRulesHd.getLeaveRulesHdId());
		tMSLeaveRulesHdDTO.setUserId(tMSLeaveRulesHd.getUserId());
		tMSLeaveRulesHdDTO.setUserIdUpdate(tMSLeaveRulesHd.getUserIdUpdate());
		TMSLeaveRules tMSLeaveRules = new TMSLeaveRules();
		TMSLeaveRulesDTO tMSLeaveRulesDTO = new TMSLeaveRulesDTO();
		tMSLeaveRules.setActiveStatus(tMSLeaveRulesDTO.getActiveStatus());
		tMSLeaveRules.setDescription(tMSLeaveRulesDTO.getDescription());
		tMSLeaveRules.setUserId(tMSLeaveRulesDTO.getUserId());
		tMSLeaveRules.setLeaveRuleId(tMSLeaveRulesDTO.getLeaveRuleId());
		tMSLeaveRules.setDays(tMSLeaveRulesDTO.getDays());
		tMSLeaveRules.setDateCreated(tMSLeaveRulesDTO.getDateCreated());
		tMSLeaveRules.setDateUpdate(tMSLeaveRulesDTO.getDateUpdate());
		tMSLeaveRulesHdDTO.setTmsleaveRules(tMSLeaveRules);
		return tMSLeaveRulesHdDTO;
	}

	public TMSLeaveRulesHd leaveuiDtoToDatabaseModel(TMSLeaveRulesHdDTO leaveRulesHdDTO, Long leavePeriodId) {

		return null;

	}

	public List<TMSLeaveRules> databaseModelToUiDto(List<TMSLeaveRules> tMSLeaveRulesList) {
		log.info("LeaveRulesHdAdaptor.databaseModelToUiDto()");
		List<TMSLeaveRules> tMSLeaveRuleList = new ArrayList<TMSLeaveRules>();
		for (TMSLeaveRules tMSLeaveRules : tMSLeaveRulesList) {
			tMSLeaveRuleList.addAll((Collection<? extends TMSLeaveRules>) databaseModelToUiDto(tMSLeaveRules));
		}
		return tMSLeaveRuleList;
	}

	public TMSLeaveRulesDTO databaseModelToUiDto(TMSLeaveRules tMSLeaveRules) {

		log.info("LeaveRulesHdAdaptor.databaseModelToUiDto()");
		TMSLeaveRulesDTO dto = new TMSLeaveRulesDTO();

		return dto;

	}
}
