package com.csipl.hrms.service.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.ProfessionalInformation;

public interface ProfessionalInformationService {

	public List<ProfessionalInformation> findAllProfessionalInformation(String employeeId);

	public List<ProfessionalInformation> saveAll(List<ProfessionalInformation> professionalInformation);

	public void delete(Long historyId);

	public List<ProfessionalInformation> saveCandidateProfessionalInfo(
			List<ProfessionalInformation> professionalInformationList, List<EmployeeSkill> employeeSkillList);

	public List<ProfessionalInformation> save(List<ProfessionalInformation> professionalInformationList, HttpServletRequest req);
}
