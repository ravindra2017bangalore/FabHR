package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.candidate.CandidateSkillDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.Skill;

public class EmpSkillAdaptor implements Adaptor<CandidateSkillDTO, EmployeeSkill> {

	@Override
	public List<EmployeeSkill> uiDtoToDatabaseModelList(List<CandidateSkillDTO> candidateSkillDTOList) {
		List<EmployeeSkill> employeeSkillList = new ArrayList<EmployeeSkill>();

		for (CandidateSkillDTO candidateSkillDto : candidateSkillDTOList) {
			EmployeeSkill employeeSkill = new EmployeeSkill();
			Skill skill = new Skill();
			Employee employee = new Employee();
			employeeSkill.setEmployeeSkillsId(candidateSkillDto.getCandidateSkillsId());
			skill.setSkillId(candidateSkillDto.getSkillId());
			employeeSkill.setSkill(skill);
			employee.setEmployeeId(candidateSkillDto.getCandidateId());
			employeeSkill.setUserId(candidateSkillDto.getUserId());
			employeeSkill.setUserIdUpdate(candidateSkillDto.getUserIdUpdate());
			employeeSkill.setDateCreated(new Date());
			employeeSkill.setDateUpdate(new Date());
			employeeSkill.setEmployee(employee);
			employeeSkill.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());

			employeeSkillList.add(employeeSkill);
		}

		return employeeSkillList;
	}

	public List<CandidateSkillDTO> databaseModelObjToUiDtoList(List<Object[]> employeeSkillList) {
		List<CandidateSkillDTO> candidateSkillDtoList = new ArrayList<CandidateSkillDTO>();
		for (Object[] employeeSkillObj : employeeSkillList) {
			CandidateSkillDTO candidateSkillDto = new CandidateSkillDTO();

			if (employeeSkillObj[0] != null) {
				candidateSkillDto.setSkillName(employeeSkillObj[0].toString());
			}
			if (employeeSkillObj[1] != null) {
				candidateSkillDto.setCandidateSkillsId(
						(employeeSkillObj[1] != null ? Long.parseLong(employeeSkillObj[1].toString()) : null));
			}
			if (employeeSkillObj[2] != null) {
				candidateSkillDto.setSkillId(
						(employeeSkillObj[2] != null ? Long.parseLong(employeeSkillObj[2].toString()) : null));
			}
			if (employeeSkillObj[3] != null) {
				candidateSkillDto.setCandidateId(
						(employeeSkillObj[3] != null ? Long.parseLong(employeeSkillObj[3].toString()) : null));
			}
			if (employeeSkillObj[4] != null) {
				candidateSkillDto.setUserId(
						(employeeSkillObj[4] != null ? Long.parseLong(employeeSkillObj[4].toString()) : null));
			}
			if (employeeSkillObj[5] != null) {
				candidateSkillDto.setUserIdUpdate(
						(employeeSkillObj[5] != null ? Long.parseLong(employeeSkillObj[5].toString()) : null));
			}
			if (employeeSkillObj[6] != null) {
				candidateSkillDto.setDateCreated((employeeSkillObj[6] != null ? (Date) (employeeSkillObj[6]) : null));
			}
			if (employeeSkillObj[7] != null) {
				candidateSkillDto.setDateUpdate((employeeSkillObj[7] != null ? (Date) (employeeSkillObj[7]) : null));
			}
			candidateSkillDtoList.add(candidateSkillDto);
		}
		return candidateSkillDtoList;

	}

	@Override
	public EmployeeSkill uiDtoToDatabaseModel(CandidateSkillDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateSkillDTO databaseModelToUiDto(EmployeeSkill dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateSkillDTO> databaseModelToUiDtoList(List<EmployeeSkill> dbobj) {

		return null;
	}

}
