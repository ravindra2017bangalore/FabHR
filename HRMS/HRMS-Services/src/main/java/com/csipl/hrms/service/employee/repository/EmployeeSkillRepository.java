package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.employee.EmployeeSkill;

public interface EmployeeSkillRepository extends CrudRepository<EmployeeSkill, Long> {
	@Modifying
	@Query("delete from EmployeeSkill es WHERE es.employee.employeeId = ?1")
	public int deleteEmployeeSkill(long employeeId);

	String employeeSkill = "SELECT s.skillName ,es.employeeSkillsId,es.skillId, es.employeeId ,es.userId,es.userIdUpdate,es.dateCreated,es.dateUpdate FROM EmployeeSkills es JOIN Skills s on s.skillId=es.skillId where es.employeeId=?1";

	@Query(value = employeeSkill, nativeQuery = true)
	public List<Object[]> getEmployeeSkill(Long employeeId);

}
