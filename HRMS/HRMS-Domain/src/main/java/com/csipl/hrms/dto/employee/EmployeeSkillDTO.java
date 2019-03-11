package com.csipl.hrms.dto.employee;

public class EmployeeSkillDTO {
	private Long employeeSkillsId;
	private Long skillId;
	private Long employeeId;
 	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getEmployeeSkillsId() {
		return employeeSkillsId;
	}
	public Long getSkillId() {
		return skillId;
	}
	public void setEmployeeSkillsId(Long employeeSkillsId) {
		this.employeeSkillsId = employeeSkillsId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
 
}
