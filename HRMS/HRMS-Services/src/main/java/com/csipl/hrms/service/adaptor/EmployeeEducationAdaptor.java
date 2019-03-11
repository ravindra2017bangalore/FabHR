package com.csipl.hrms.service.adaptor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.employee.EmployeeEducationDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.employee.EmployeeEducation;

public class EmployeeEducationAdaptor implements Adaptor<EmployeeEducationDTO,EmployeeEducation> {

	public List<EmployeeEducation> employeeEducationDtoToDatabaseModelList(List<EmployeeEducationDTO> eduInformationDTOList,String empId) {
		List<EmployeeEducation> employeeEducationList=new ArrayList<EmployeeEducation>();
		for(EmployeeEducationDTO eduInformationDTO: eduInformationDTOList) {
			employeeEducationList.add(employeeEduDtoToDatabaseModel(eduInformationDTO, empId));
		}
		return employeeEducationList;
	}

	@Override
	public List<EmployeeEducationDTO> databaseModelToUiDtoList(List<EmployeeEducation> employeeEducationList) {
		List<EmployeeEducationDTO> eduInformationDTOList=new ArrayList<EmployeeEducationDTO>();
		for(EmployeeEducation employeeEducation: employeeEducationList) {
			eduInformationDTOList.add(databaseModelToUiDto(employeeEducation));
		}
		return eduInformationDTOList;
	}
	

	public EmployeeEducation employeeEduDtoToDatabaseModel(EmployeeEducationDTO eduInformationDTO, String empId) {
		EmployeeEducation employeeEducation=new EmployeeEducation();
		Long employeeId=Long.parseLong(empId);
		employeeEducation.setQualificationId(eduInformationDTO.getQualificationId());
		employeeEducation.setDegreeName(eduInformationDTO.getDegreeName());
		employeeEducation.setMarksPer(eduInformationDTO.getMarksPer());
		employeeEducation.setNameOfBoard(eduInformationDTO.getNameOfBoard());
		employeeEducation.setNameOfInstitution(eduInformationDTO.getNameOfInstitution());
		employeeEducation.setPassingYear(eduInformationDTO.getPassingYear());
		employeeEducation.setRegularCorrespondance(eduInformationDTO.getRegularCorrespondance());
		employeeEducation.setEducationId(eduInformationDTO.getEducationId());
		employeeEducation.setEmployeeId(employeeId);
		employeeEducation.setUserId(eduInformationDTO.getUserId());
		employeeEducation.setDateCreated(eduInformationDTO.getDateCreated());
		Company company=new Company();
		company.setCompanyId(eduInformationDTO.getCompanyId());
		employeeEducation.setCompany(company);
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		employeeEducation.setGroupg(groupg);
		employeeEducation.setUserIdUpdate(eduInformationDTO.getUserIdUpdate());
		if(eduInformationDTO.getDateCreated()==null)
			employeeEducation.setDateCreated(new Date());
		else
			employeeEducation.setDateCreated(eduInformationDTO.getDateCreated());
			employeeEducation.setDateUpdate(new Date());
		return employeeEducation;
	}

	@Override
	public EmployeeEducationDTO databaseModelToUiDto(EmployeeEducation employeeEducation) {
		EmployeeEducationDTO eduInformationDTO=new EmployeeEducationDTO();
		eduInformationDTO.setQualificationId(employeeEducation.getQualificationId());
		eduInformationDTO.setDegreeName(employeeEducation.getDegreeName());
		eduInformationDTO.setMarksPer(employeeEducation.getMarksPer());
		eduInformationDTO.setNameOfBoard(employeeEducation.getNameOfBoard());
		eduInformationDTO.setNameOfInstitution(employeeEducation.getNameOfInstitution());
		eduInformationDTO.setPassingYear(employeeEducation.getPassingYear());
		eduInformationDTO.setRegularCorrespondance(employeeEducation.getRegularCorrespondance());
		eduInformationDTO.setEducationId(employeeEducation.getEducationId());
		eduInformationDTO.setUserId(employeeEducation.getUserId());
		eduInformationDTO.setDateCreated(employeeEducation.getDateCreated());
		//eduInformationDTO.setEmployeeId(1L);
		return eduInformationDTO;
	}

	@Override
	public List<EmployeeEducation> uiDtoToDatabaseModelList(List<EmployeeEducationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeEducation uiDtoToDatabaseModel(EmployeeEducationDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}
}
