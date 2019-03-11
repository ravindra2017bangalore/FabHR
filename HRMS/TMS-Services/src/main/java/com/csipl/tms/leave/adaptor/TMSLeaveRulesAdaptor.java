package com.csipl.tms.leave.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.tms.dto.leave.TMSLeaveRulesDTO;
import com.csipl.tms.model.leave.TMSLeaveRuleMaster;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;
import com.csipl.tms.service.Adaptor;

public class TMSLeaveRulesAdaptor implements Adaptor<TMSLeaveRulesDTO, TMSLeaveRules> {

	public TMSLeaveRules leaveuiDtoToDatabaseModel(TMSLeaveRulesDTO tmsLeaveDTO) {

		TMSLeaveRules tmsLeaveRules = new TMSLeaveRules();
		tmsLeaveRules.setDays(tmsLeaveDTO.getDays());
		TMSLeaveRulesHd tMSLeaveRulesHd = new TMSLeaveRulesHd();
		if (tmsLeaveDTO.getLeaveRuleId() != null) {
			tmsLeaveRules.setLeaveRuleId(tmsLeaveDTO.getLeaveRuleId());
		}
		tmsLeaveRules.setActiveStatus(tmsLeaveDTO.getActiveStatus());
		tMSLeaveRulesHd.setLeaveRulesHdId(tmsLeaveDTO.getLeaveRuleHdId());
		// tmsLeaveRules.setRuleName(tmsLeaveDTO.getRuleName());
		tmsLeaveRules.setTmsleaveRulesHd(tMSLeaveRulesHd);
		tmsLeaveRules.setDateCreated(tmsLeaveDTO.getDateCreated());
		tmsLeaveRules.setDateUpdate(tmsLeaveDTO.getDateUpdate());
		// tmsLeaveRules.setRuleCode(tmsLeaveDTO.getRuleCode());
		tmsLeaveRules.setUserId(tmsLeaveDTO.getUserId());
		tmsLeaveRules.setDescription(tmsLeaveDTO.getDescription());
		TMSLeaveRuleMaster tMSLeaveRulesMaster = new TMSLeaveRuleMaster();
		tMSLeaveRulesMaster.setLeaveRuleMasterId(tmsLeaveDTO.getLeaveRuleMasterId());
		tmsLeaveRules.setTmsleaveRuleMaster(tMSLeaveRulesMaster);
		return tmsLeaveRules;
	}

	@Override
	public List<TMSLeaveRules> uiDtoToDatabaseModelList(List<TMSLeaveRulesDTO> tMSLeaveRulesDTO) {
		// List<TMSLeaveRules> leaveRulesDtoList = new ArrayList<TMSLeaveRules>();
		// for (TMSLeaveRules leaveRulesDTO : uiobj) {
		// leaveRulesDtoList.add(databaseModelToUiDto(leaveRulesDTO));
		// }
		return null;
	}

	@Override
	public List<TMSLeaveRulesDTO> databaseModelToUiDtoList(List<TMSLeaveRules> tMSLeaveRulesList) {

		List<TMSLeaveRulesDTO> tMSLeaveRulesDtoList = new ArrayList<TMSLeaveRulesDTO>();
		for (TMSLeaveRules tMSLeaveRules : tMSLeaveRulesList) {
			tMSLeaveRulesDtoList.add(databaseModelToUiDto(tMSLeaveRules));
		}
		return tMSLeaveRulesDtoList;
	}

	@Override
	public TMSLeaveRules uiDtoToDatabaseModel(TMSLeaveRulesDTO tMSLeaveRulesDTO) {
		TMSLeaveRules tMSLeaveRules = new TMSLeaveRules();
		TMSLeaveRulesHd tMSLeaveRulesHd = new TMSLeaveRulesHd();

		tMSLeaveRules.setLeaveRuleId(tMSLeaveRulesDTO.getLeaveRuleId());

		tMSLeaveRules.setActiveStatus(tMSLeaveRulesDTO.getActiveStatus());
		tMSLeaveRules.setLeaveRuleId(tMSLeaveRulesDTO.getLeaveRuleId());
		tMSLeaveRulesHd.setLeaveRulesHdId(tMSLeaveRulesDTO.getLeaveRuleHdId());
		tMSLeaveRules.setDays(tMSLeaveRulesDTO.getDays());
		tMSLeaveRules.setDescription(tMSLeaveRulesDTO.getDescription());
		tMSLeaveRules.setUserId(tMSLeaveRulesDTO.getUserId());
		return tMSLeaveRules;
	}

	@Override
	public TMSLeaveRulesDTO databaseModelToUiDto(TMSLeaveRules tMSLeaveRules) {
		TMSLeaveRulesDTO tMSLeaveRulesDTO = new TMSLeaveRulesDTO();
		TMSLeaveRulesHd tMSLeaveRulesHd = new TMSLeaveRulesHd();
		tMSLeaveRulesDTO.setLeaveRuleId(tMSLeaveRulesDTO.getLeaveRuleId());

		tMSLeaveRulesDTO.setActiveStatus(tMSLeaveRules.getActiveStatus());

		tMSLeaveRulesDTO.setLeaveRuleId(tMSLeaveRules.getLeaveRuleId());
		tMSLeaveRulesDTO.setDays(tMSLeaveRules.getDays());
		tMSLeaveRulesDTO.setLeaveRuleHdId(tMSLeaveRulesHd.getLeaveRulesHdId());
		tMSLeaveRulesDTO.setDescription(tMSLeaveRules.getDescription());
		tMSLeaveRulesDTO.setUserId(tMSLeaveRules.getUserId());
		tMSLeaveRulesDTO.setLeaveRuleMasterId(tMSLeaveRules.getTmsleaveRuleMaster().getLeaveRuleMasterId());
		return tMSLeaveRulesDTO;
	}

	public List<TMSLeaveRulesDTO> databaseModelToUiRuleDtoList(List<Object[]> leaveRuleList) {
		List<TMSLeaveRulesDTO> leaveRuleDtoList = new ArrayList<TMSLeaveRulesDTO>();
		for (Object[] leaveRule : leaveRuleList) {
			TMSLeaveRulesDTO leaveRuleDTO = new TMSLeaveRulesDTO();

			if (leaveRule[0] != null) {

				leaveRuleDTO.setLeaveRuleId(Long.valueOf(leaveRule[0].toString()));
			}

			if (leaveRule[1] != null) {
				leaveRuleDTO.setLeaveRuleHdId(Long.valueOf(leaveRule[1].toString()));

				if (leaveRule[2] != null) {
					leaveRuleDTO.setLeaveRuleMasterId(Long.valueOf(leaveRule[2].toString()));
				}
				if (leaveRule[3] != null) {
					leaveRuleDTO.setDays(Long.valueOf(leaveRule[3].toString()));
				}
				if (leaveRule[4] != null) {
					leaveRuleDTO.setDescription(leaveRule[4].toString());
				}
				if (leaveRule[5] != null) {
					leaveRuleDTO.setActiveStatus(leaveRule[5].toString());
				}
				if (leaveRule[6] != null) {
					leaveRuleDTO.setUserId(Long.valueOf(leaveRule[6].toString()));
				}
				if (leaveRule[7] != null) {
					leaveRuleDTO.setDateCreated(new Date());
				}
				if (leaveRule[8] != null) {
					leaveRuleDTO.setUserIdUpdate(Long.valueOf(leaveRule[8].toString()));
				}
				if (leaveRule[9] != null) {
					leaveRuleDTO.setDateUpdate(new Date());
				}
				if (leaveRule[10] != null) {
					leaveRuleDTO.setRuleName(leaveRule[10].toString());
				}
				leaveRuleDtoList.add(leaveRuleDTO);
			}

		}
		return leaveRuleDtoList;
	}

}
