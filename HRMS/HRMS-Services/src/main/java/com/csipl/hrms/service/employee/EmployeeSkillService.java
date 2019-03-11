package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.EmployeeSkill;

public interface EmployeeSkillService {

	List<EmployeeSkill> save(List<EmployeeSkill> employeeSkillList);

	List<Object[]> getEmployeeSkills(Long employeeId);

	void deleteSkill(Long employeeSkillsId);
	
}
