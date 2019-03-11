package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.employee.EmployeeDocumentDTO;
import com.csipl.hrms.model.employee.EmployeeDocument;

public class EmployeeDocumentAdaptor implements Adaptor<EmployeeDocumentDTO, EmployeeDocument> {

	@Override
	public List<EmployeeDocument> uiDtoToDatabaseModelList(List<EmployeeDocumentDTO> employeeDocumentDtoList) {
		List<EmployeeDocument> employeeDocumentList=new ArrayList<EmployeeDocument>();
		for (EmployeeDocumentDTO employeeDocumentDto : employeeDocumentDtoList) {
			employeeDocumentList.add(uiDtoToDatabaseModel(employeeDocumentDto));
		}
		return employeeDocumentList;
	}

	@Override
	public List<EmployeeDocumentDTO> databaseModelToUiDtoList(List<EmployeeDocument> employeeDocumentList) {
		List<EmployeeDocumentDTO> employeeDocumentDtoList=new ArrayList<EmployeeDocumentDTO>();
		for (EmployeeDocument employeeDocument : employeeDocumentList) {
			employeeDocumentDtoList.add(databaseModelToUiDto(employeeDocument));
		}
		return employeeDocumentDtoList;
	}

	
	public EmployeeDocument empDocDtoToDatabaseModel(EmployeeDocumentDTO employeeDocumentDto,String empId) {
		EmployeeDocument employeeDocument=new EmployeeDocument();
		Long employeeId = Long.parseLong(empId);
		employeeDocument.setEmployeeDocumentsId(employeeDocumentDto.getEmployeeDocumentsId());
		employeeDocument.setDocumentsId(employeeDocumentDto.getDocumentsId());
		employeeDocument.setDescription(employeeDocumentDto.getDescription());
		employeeDocument.setFileLocation(employeeDocumentDto.getFileLocation());
		employeeDocument.setActiveStatus(employeeDocumentDto.getActiveStatus());
		employeeDocument.setEmployeeId(employeeId);
		employeeDocument.setUserId(employeeDocumentDto.getUserId());
		if(employeeDocumentDto.getDateCreated()==null)
			employeeDocument.setDateCreated(new Date());
		else
		employeeDocument.setDateCreated(employeeDocumentDto.getDateCreated());
		employeeDocument.setDateUpdate(new Date());
		employeeDocument.setUserIdUpdate(employeeDocumentDto.getUserIdUpdate());
		return employeeDocument;
	}

	@Override
	public EmployeeDocumentDTO databaseModelToUiDto(EmployeeDocument employeeDocument) {
		EmployeeDocumentDTO employeeDocumentDto=new EmployeeDocumentDTO();
		employeeDocumentDto.setEmployeeDocumentsId(employeeDocument.getEmployeeDocumentsId());
		employeeDocumentDto.setDocumentsId(employeeDocument.getDocumentsId());
		employeeDocumentDto.setDescription(employeeDocument.getDescription());
		employeeDocumentDto.setFileLocation(employeeDocument.getFileLocation());
		employeeDocumentDto.setActiveStatus(employeeDocument.getActiveStatus());
		employeeDocumentDto.setUserId(employeeDocument.getUserId());
		employeeDocumentDto.setDateCreated(employeeDocument.getDateCreated());
		employeeDocumentDto.setDocumentNameValue(DropDownCache.getInstance().getDropDownValue( DropDownEnum.SelectIdType.getDropDownName() , employeeDocument.getDocumentsId()));
		employeeDocumentDto.setActiveStatusValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Status.getDropDownName(), employeeDocument.getActiveStatus()));
		return employeeDocumentDto;
	}

	@Override
	public EmployeeDocument uiDtoToDatabaseModel(EmployeeDocumentDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
