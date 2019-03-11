package com.csipl.hrms.service.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.service.employee.repository.EmployeeSkillRepository;

@Transactional
@Service("employeeSkillService")
public class EmployeeSkillServiceImpl implements EmployeeSkillService{

	@Autowired
	EmployeeSkillRepository employeeSkillRepository;
	
	@Override
	public List<EmployeeSkill> save(List<EmployeeSkill> employeeSkillList) {
		return (List<EmployeeSkill>) employeeSkillRepository.save(employeeSkillList);
		
	}

	@Override
	public List<Object[]> getEmployeeSkills(Long employeeId) {
		return employeeSkillRepository.getEmployeeSkill(employeeId);
	}

	@Override
	public void deleteSkill(Long employeeSkillsId) {
		employeeSkillRepository.delete(employeeSkillsId);
	}

}
