package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.Skill;

     public interface SkillService {
 	public Skill  save( Skill skill);
 	  public List<Skill> findAllSkill(Long companyId);
	 public void delete(Long skillId);
  }
