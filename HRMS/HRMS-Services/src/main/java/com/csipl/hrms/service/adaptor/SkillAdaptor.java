package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.SkillDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.model.organisation.Department;

public class SkillAdaptor implements Adaptor<SkillDTO, Skill> {
 	DepartmentAdaptor departmentAdaptor = new DepartmentAdaptor();
 	@Override
	public List<Skill> uiDtoToDatabaseModelList(List<SkillDTO> skillDtoList) {
 		List<Skill> skillList = new ArrayList<Skill>();
 		for (SkillDTO skillDto : skillDtoList) {
 			skillList.add(uiDtoToDatabaseModel(skillDto));
		}
 		return skillList;
	}
 	@Override
	public List<SkillDTO> databaseModelToUiDtoList(List<Skill> skilllist) {

		List<SkillDTO> skillDtoList = new ArrayList<SkillDTO>();
 		for (Skill skill : skilllist) {
 			skillDtoList.add(databaseModelToUiDto(skill));
		}
 		return skillDtoList;
	}

	@Override
	public Skill uiDtoToDatabaseModel(SkillDTO skillDto) {
		Skill skill = new Skill();
		skill.setSkillName(skillDto.getSkillName());
		skill.setSkillId(skillDto.getSkillId());
		Department department = new Department();
		department.setDepartmentId(skillDto.getDepartmentId());
		department.setDepartmentName(skillDto.getDepartmentName());
		skill.setDepartment(department);
		skill.setUserId(skillDto.getUserId());
		skill.setDateCreated(skillDto.getDateCreated());
		Company company=new Company();
		company.setCompanyId(skillDto.getCompanyId());
		skill.setCompany(company);
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		skill.setGroupg(groupg);
		if(skillDto.getDateCreated()==null)	
			skill.setDateCreated(new Date());
		else
		skill.setDateCreated(skillDto.getDateCreated());
		skill.setDateUpdate(new Date());
		skill.setUserIdUpdate(skillDto.getUserIdUpdate());
		return skill;
 	}

	@Override
	public SkillDTO databaseModelToUiDto(Skill skill) {
		SkillDTO skillDTO = new SkillDTO();
		skillDTO.setSkillName(skill.getSkillName());
		skillDTO.setSkillId(skill.getSkillId());
		skillDTO.setDepartmentId(skill.getDepartment().getDepartmentId());
		skillDTO.setDepartmentName(skill.getDepartment().getDepartmentName());
		skillDTO.setUserId(skill.getUserId());
		skillDTO.setDateCreated(skill.getDateCreated());
		return skillDTO;
	}

}
