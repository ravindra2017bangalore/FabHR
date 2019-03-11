package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.ProfessionalInformationDTO;
import com.csipl.hrms.model.employee.ProfessionalInformation;

public class ProfessionalInformationAdaptor implements Adaptor<ProfessionalInformationDTO, ProfessionalInformation>
{
	DateUtils dateUtils = new DateUtils();

	public List<ProfessionalInformation> ProfessionalInformationDtoToDatabaseModelList(List<ProfessionalInformationDTO> professionalInformationDtoList,String employeeId) {
		List<ProfessionalInformation> professionalInformationList=new ArrayList<ProfessionalInformation>();
		for (ProfessionalInformationDTO professionalInformationDto : professionalInformationDtoList) {
			professionalInformationList.add(uiDtoToDatabaseModel(professionalInformationDto,employeeId));
		}
		return professionalInformationList;
	}

	@Override
	public List<ProfessionalInformationDTO> databaseModelToUiDtoList(List<ProfessionalInformation> professionalInformationList) {
		List<ProfessionalInformationDTO> professionalInformationDtoList=new ArrayList<ProfessionalInformationDTO>();
		for (ProfessionalInformation professionalInformation : professionalInformationList) {
			professionalInformationDtoList.add(databaseModelToUiDto(professionalInformation));
		}
		return professionalInformationDtoList;
	}

	
public ProfessionalInformation uiDtoToDatabaseModel(ProfessionalInformationDTO professionalInformationDto,String empId) {
		
		ProfessionalInformation professionalInformation=new ProfessionalInformation();
		Long employeeId=Long.parseLong(empId);
		professionalInformation.setHistoryId(professionalInformationDto.getHistoryId());
		professionalInformation.setOrganizationName(professionalInformationDto.getOrganizationName());
		if(professionalInformationDto.getDateFrom()!=null && !("").equals(professionalInformationDto.getDateFrom()))
		professionalInformation.setDateFrom(dateUtils.getDateWirhYYYYMMDD( professionalInformationDto.getDateFrom()));
		if( professionalInformationDto.getDateTo()!=null && !("").equals( professionalInformationDto.getDateTo()))
		professionalInformation.setDateTo(dateUtils.getDateWirhYYYYMMDD( professionalInformationDto.getDateTo()));
		professionalInformation.setDesignation(professionalInformationDto.getDesignation());
		professionalInformation.setReportingTo(professionalInformationDto.getReportingTo());
		professionalInformation.setReportingContact(professionalInformationDto.getReportingContact());
		professionalInformation.setAnnualSalary(professionalInformationDto.getAnnualSalary());
		professionalInformation.setReasonForChange(professionalInformationDto.getReasonForChange());
		professionalInformation.setEmployeeId(employeeId);
		professionalInformation.setUserId(professionalInformationDto.getUserId());
		if(professionalInformationDto.getDateCreated()==null)
			professionalInformation.setDateCreated(new Date());
		else
			professionalInformation.setDateCreated(professionalInformationDto.getDateCreated());
		professionalInformation.setUserIdUpdate(professionalInformationDto.getUserIdUpdate());
		professionalInformation.setDateUpdate(new Date());
		
		
		return professionalInformation;
	}

	@Override
	public ProfessionalInformationDTO databaseModelToUiDto(ProfessionalInformation professionalInformation) {

		ProfessionalInformationDTO professionalInformationDto=new ProfessionalInformationDTO();
		
		professionalInformationDto.setHistoryId(professionalInformation.getHistoryId());
		professionalInformationDto.setOrganizationName(professionalInformation.getOrganizationName());
		if(professionalInformation.getDateFrom()!=null) {
		String dateFrom = dateUtils.getDateStringWirhYYYYMMDD(  professionalInformation.getDateFrom() );
		professionalInformationDto.setDateFrom( dateFrom );
		}
		if(professionalInformation.getDateTo()!=null) {
		String dateTo = dateUtils.getDateStringWirhYYYYMMDD(  professionalInformation.getDateTo() );
		professionalInformationDto.setDateTo( dateTo );
		}
		professionalInformationDto.setDesignation(professionalInformation.getDesignation());
		professionalInformationDto.setReportingTo(professionalInformation.getReportingTo());
		professionalInformationDto.setAnnualSalary(professionalInformation.getAnnualSalary());
		professionalInformationDto.setReportingContact(professionalInformation.getReportingContact());
		professionalInformationDto.setReasonForChange(professionalInformation.getReasonForChange());
		professionalInformationDto.setUserId(professionalInformation.getUserId());
		professionalInformationDto.setDateCreated(professionalInformation.getDateCreated());
		return professionalInformationDto;
	}
	@Override
	public List<ProfessionalInformation> uiDtoToDatabaseModelList(List<ProfessionalInformationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessionalInformation uiDtoToDatabaseModel(ProfessionalInformationDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
