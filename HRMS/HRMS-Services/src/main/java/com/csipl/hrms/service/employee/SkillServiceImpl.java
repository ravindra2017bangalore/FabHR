 package com.csipl.hrms.service.employee;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.service.employee.repository.SkillRepository;
 
@Service("SkillService")
public class SkillServiceImpl implements SkillService {
	private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);

	@Autowired
	SkillRepository skillRepository;
	/**
	 * Method performed save OR update operation
	 */
	@Override
	public Skill save(Skill skill) {
		return skillRepository.save(skill);
 	}
	/**
	 * to get List of Skill from database based on companyId
	 */
 	@Override
	public List<Skill> findAllSkill(Long companyId) {
  		return skillRepository.findAllSkills(companyId);
 	}
 	
  
  	/**
	 * delete skill object from database based on skillId (Primary Key)
	 */
 	@Override
	public void delete(Long skillId ) {
		skillRepository.delete(skillId);
	}
  }
  
   
 