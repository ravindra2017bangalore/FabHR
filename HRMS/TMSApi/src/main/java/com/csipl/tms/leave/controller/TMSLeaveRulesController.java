package com.csipl.tms.leave.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.tms.dto.leave.TMSLeaveRulesDTO;
import com.csipl.tms.leave.adaptor.TMSLeaveRulesAdaptor;
import com.csipl.tms.leave.service.TMSLeaveRulesService;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;

/**
 *
 */
@RestController
@RequestMapping("/leaveRules")
public class TMSLeaveRulesController {

	private static final Logger log = LoggerFactory.getLogger(TMSLeaveRulesController.class);

	@Autowired
  	TMSLeaveRulesService tMSLeaveRulesService;
 
	TMSLeaveRulesAdaptor tmsLeaveAdaptor = new TMSLeaveRulesAdaptor();

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody TMSLeaveRulesDTO saveTMSLeave(@RequestBody TMSLeaveRulesDTO tMSLeaveRulesDTO,
			HttpServletRequest req) {
		return tmsLeaveAdaptor.databaseModelToUiDto(
				tMSLeaveRulesService.save(tmsLeaveAdaptor.leaveuiDtoToDatabaseModel(tMSLeaveRulesDTO)));
	}
	@RequestMapping(value = "/{leavePeriodId}", method = RequestMethod.GET)
	public List<TMSLeaveRulesDTO> leaveRulesList(@PathVariable("leavePeriodId") Long leavePeriodId) {
		log.info("leaveRulesList is calling : " + " : leaveRulesId " + leavePeriodId);
		List<Object[]> leaveRuleList = tMSLeaveRulesService.findAllRulesByPeriodId(leavePeriodId);
		return tmsLeaveAdaptor.databaseModelToUiRuleDtoList(leaveRuleList);

	}

}
