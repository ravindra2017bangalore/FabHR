package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.employee.MassCommunicationDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.employee.MassCommunication;

import com.csipl.hrms.model.organisation.Department;

public class MassCommunicationAdaptor implements Adaptor<MassCommunicationDTO,MassCommunication>{

	@Override
	public List<MassCommunication> uiDtoToDatabaseModelList(List<MassCommunicationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<MassCommunicationDTO> databaseModelToUiDtoList(List<MassCommunication> massCommunicationlist) {

		List<MassCommunicationDTO> massCommunicationDtoList = new ArrayList<MassCommunicationDTO>();
 		for (MassCommunication massCommunication : massCommunicationlist) {
 			massCommunicationDtoList.add(databaseModelToUiDto(massCommunication));
		}
 		return massCommunicationDtoList;
	}
	
	

	@Override
	public MassCommunication uiDtoToDatabaseModel(MassCommunicationDTO massCommunicationDto) {
		MassCommunication massCommunication=new MassCommunication();
		Department department = new Department();
		massCommunication.setMassCommunicationId(massCommunicationDto.getMassCommunicationId());
		massCommunication.setTitle(massCommunicationDto.getTitle());
		department.setDepartmentId(massCommunicationDto.getDepartmentId());
		massCommunication.setDepartment(department);
		massCommunication.setDateFrom(massCommunicationDto.getDateFrom());
		massCommunication.setDateTo(massCommunicationDto.getDateTo());
		massCommunication.setDescription(massCommunicationDto.getDescription());
		massCommunication.setUserId(massCommunicationDto.getUserId());
		massCommunication.setDateCreated(massCommunicationDto.getDateCreated());
		massCommunication.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		Company company=new Company();
		company.setCompanyId(massCommunicationDto.getCompanyId());
		massCommunication.setCompany(company);
		if(massCommunicationDto.getDateCreated()==null)
			massCommunication.setDateCreated(new Date());
		else
			massCommunication.setDateCreated(massCommunicationDto.getDateCreated());
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		massCommunication.setGroupg(groupg);
		massCommunication.setUserIdUpdate(massCommunicationDto.getUserIdUpdate());
		massCommunication.setDateUpdate(new Date());
		return massCommunication;
	}

	@Override
	public MassCommunicationDTO databaseModelToUiDto(MassCommunication massCommunication) {
		MassCommunicationDTO massCommunicationDto = new MassCommunicationDTO();
		massCommunicationDto.setMassCommunicationId(massCommunication.getMassCommunicationId());
		massCommunicationDto.setTitle(massCommunication.getTitle());
		massCommunicationDto.setDepartmentId(massCommunication.getDepartment().getDepartmentId());
		massCommunicationDto.setDepartmentName(massCommunication.getDepartment().getDepartmentName());
		massCommunicationDto.setDateFrom(massCommunication.getDateFrom());
		massCommunicationDto.setDateTo(massCommunication.getDateTo());
		massCommunicationDto.setDescription(massCommunication.getDescription());
		massCommunicationDto.setUserId(massCommunication.getUserId());
		massCommunicationDto.setDateCreated(massCommunication.getDateCreated());
		return massCommunicationDto;
	}
	

}
