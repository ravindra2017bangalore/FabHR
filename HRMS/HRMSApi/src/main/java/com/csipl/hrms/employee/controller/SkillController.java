package com.csipl.hrms.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.SkillDTO;
import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.SkillAdaptor;
import com.csipl.hrms.service.employee.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(SkillController.class);
	@Autowired
	SkillService skillService;
	SkillAdaptor skillAdaptor = new SkillAdaptor();

	/**
	 * @param skillDto
	 *            This is the first parameter for getting Skill Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveSkill(@RequestBody SkillDTO skillDto, HttpServletRequest req) {
		logger.info("saveSkill is calling : " + " :SkillDTO  " + skillDto);
		Skill skill = skillAdaptor.uiDtoToDatabaseModel(skillDto);
		// boolean newFlag = skill != null && skill.getSkillId() != null ? false : true;
		// editLogInfo(skill, newFlag, req);
		logger.info("saveSkill is end  :" + "skill" + skill);
		skillService.save(skill);
	}

	/**
	 * to get List of Skill from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<SkillDTO> getAllSkills(@PathVariable("companyId") Long companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		logger.info("getAllSkills is calling :");
		List<Skill> skillList = skillService.findAllSkill(companyId);
		if (skillList != null && skillList.size() > 0)
			return skillAdaptor.databaseModelToUiDtoList(skillList);
		else
			throw new ErrorHandling(" SkillSet Data not present");
	}

	/**
	 * delete skill object from database based on skillId (Primary Key)
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteEmp(@RequestParam("skillId") String skillId, HttpServletRequest req) {
		logger.info("deleteEmp is calling :");
		Long skillsId = Long.parseLong(skillId);
		skillService.delete(skillsId);
	}

}
