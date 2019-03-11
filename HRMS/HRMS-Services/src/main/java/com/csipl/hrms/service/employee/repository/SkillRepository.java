package com.csipl.hrms.service.employee.repository;

 
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.employee.Skill;

    
public interface SkillRepository extends CrudRepository<Skill, Long>{
  	@Query(" from Skill where companyId=?1 ORDER BY  skillId  DESC ") 
 	public List<Skill> findAllSkills(Long companyId);
 }

