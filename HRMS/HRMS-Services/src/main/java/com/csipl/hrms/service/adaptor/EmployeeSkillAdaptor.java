package com.csipl.hrms.service.adaptor;

 import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.employee.EmployeeSkillDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.Skill;
 
public class EmployeeSkillAdaptor {
  	public List<EmployeeSkill> uiDtoToDatabaseModelListUTIL(List<EmployeeSkillDTO> employeeSkillDtoList, EmployeeDTO employeeDto) {
		List<EmployeeSkill> employeeSkillList=new ArrayList<EmployeeSkill>();
		for (EmployeeSkillDTO employeeSkillDto : employeeSkillDtoList) {
			employeeSkillList.add(uiDtoToDatabaseModelUTIL(employeeSkillDto,employeeDto));
		}
  		return employeeSkillList;
	}
  	public List<EmployeeSkillDTO> databaseModelToUiDtoListUTIL(List<EmployeeSkill> employeeSkillList, Employee employee) {
		List<EmployeeSkillDTO> employeeSkillDtoList=new ArrayList<EmployeeSkillDTO>();
		for (EmployeeSkill employeeSkill : employeeSkillList) {
			employeeSkillDtoList.add(databaseModelToUiDtoUTIL(employeeSkill,employee));
		}
 		return employeeSkillDtoList;
	}
  	public EmployeeSkill uiDtoToDatabaseModelUTIL(EmployeeSkillDTO employeeSkillDto, EmployeeDTO employeeDto) {
		EmployeeSkill employeeSkill=new EmployeeSkill();
		Skill skill=new Skill();
		Employee employee=new Employee();
  		employeeSkill.setEmployeeSkillsId(employeeSkillDto.getEmployeeSkillsId());
		skill.setSkillId(employeeSkillDto.getSkillId());
		employeeSkill.setSkill(skill);
 		employee.setEmployeeId(employeeSkillDto.getEmployeeId());
		employeeSkill.setEmployee(employee);
		employeeSkill.setActiveStatus(employeeDto.getActiveStatus());
		
   		return employeeSkill;
	}
 	public EmployeeSkillDTO databaseModelToUiDtoUTIL(EmployeeSkill employeeSkill, Employee employee) {
		EmployeeSkillDTO employeeSkillDto=new EmployeeSkillDTO();
		employeeSkillDto.setEmployeeSkillsId(employeeSkill.getEmployeeSkillsId());
		employeeSkillDto.setSkillId(employeeSkill.getSkill().getSkillId());
		employeeSkillDto.setEmployeeId(employee.getEmployeeId());
 		return employeeSkillDto;
	}
  }
