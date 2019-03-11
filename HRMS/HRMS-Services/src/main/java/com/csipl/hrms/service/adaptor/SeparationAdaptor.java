package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.util.DateUtils;
 import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.Separation;

public class SeparationAdaptor implements Adaptor<SeparationDTO, Separation> {
 	@Override
	public List<Separation> uiDtoToDatabaseModelList(List<SeparationDTO> uiobj) {
 		return null;
	}
 	@Override
	public List<SeparationDTO> databaseModelToUiDtoList(List<Separation> separationList) {
		List<SeparationDTO> separationDtoList = new ArrayList<SeparationDTO>();
 		for (Separation separation : separationList) {
			separationDtoList.add(databaseModelToUiDto(separation));
		}
 		return separationDtoList;
	}

	@Override
	public Separation uiDtoToDatabaseModel(SeparationDTO separationDto) {
		Separation separation = new Separation();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Company company = new Company();
		separation.setReplacementEmployeeId(separationDto.getReplacementEmployeeId());
		separation.setRemark(separationDto.getRemark());
		employee1.setEmployeeId(separationDto.getEmployeeId());
 		separation.setSeparationId(separationDto.getSeparationId());
		separation.setResoan(separationDto.getResoan());
		separation.setEndDate(separationDto.getEndDate());
		separation.setDescription(separationDto.getDescription());
 		if(separationDto.getStatus()!=null)
		separation.setStatus(separationDto.getStatus()); 
		else if(separationDto.getStatus()==null && separationDto.getApprovalId()!=null)
		separation.setStatus(StatusMessage.APPROVED_CODE);
		else
			separation.setStatus(StatusMessage.PENDING_CODE);

		separation.setUserId(separationDto.getUserId());
		separation.setUserIdUpdate(separationDto.getUserIdUpdate());
		if(separationDto.getSeparationId()==null) 
			separation.setDateCreated(currentDate);
		else
		separation.setDateCreated(separationDto.getDateCreated());
		
		company.setCompanyId(separationDto.getCompanyId());
		separation.setCompany(company);
		
		separation.setDateUpdate(currentDate);
		separation.setEmployee1(employee1);
		if(separationDto.getApprovalId()!=null){
		employee2.setEmployeeId(separationDto.getApprovalId());
		separation.setEmployee2(employee2);
		}
		return separation;
	}

	@Override
	public SeparationDTO databaseModelToUiDto(Separation separation) {
		SeparationDTO separationDto = new SeparationDTO();
		separationDto.setSeparationId(separation.getSeparationId());
		separationDto.setDescription(separation.getDescription());
		separationDto.setEmployeeId(separation.getEmployee1().getEmployeeId());
		separationDto.setFirstName(separation.getEmployee1().getFirstName());
		separationDto.setLastName(separation.getEmployee1().getLastName());
 		separationDto.setDepartmentName(separation.getEmployee1().getDepartment().getDepartmentName());
		separationDto.setDateOfJoining(separation.getEmployee1().getDateOfJoining());
		separationDto.setEmployeeCode(separation.getEmployee1().getEmployeeCode());
 		separationDto.setStatus(separation.getStatus());
		separationDto.setEndDate(separation.getEndDate());
		separationDto.setUserId(separation.getUserId());
		separationDto.setUserIdUpdate(separation.getUserIdUpdate());
		separationDto.setCompanyId(separation.getCompany().getCompanyId());
		separationDto.setDateCreated(separation.getDateCreated());
		separationDto.setResoan(separation.getResoan());
		if(separation.getEmployee2()!=null  && separation.getEmployee2().getEmployeeId()!=null) {
		separationDto.setApprovalId(separation.getEmployee2().getEmployeeId());
		separationDto.setApproverFirstName(separation.getEmployee2().getFirstName());
		separationDto.setApproverLastName(separation.getEmployee2().getLastName());
		separationDto.setApproverDesignation(separation.getEmployee2().getDesignation().getDesignationName());
		separationDto.setApproverDepartment(separation.getEmployee2().getDepartment().getDepartmentName());
 		separationDto.setApproverEmployeeLogoPath(separation.getEmployee2().getEmployeeLogoPath());

		}
		separationDto.setRemark(separation.getRemark());

 		//separationDto.setReasonLabel(DropDownCache.getInstance()
	//			.getDropDownValue(DropDownEnum.ResignationReason.getDropDownName(), separation.getResoan()));
		System.out.println("ID "+separationDto.getApprovalId());
		
 		if(separation.getResoan().equals("CG"))
 		separationDto.setReasonLabel("Career Growth");
 		else if(separation.getResoan().equals("PI"))
 	 		separationDto.setReasonLabel("Personal Issue");
 		else if(separation.getResoan().equals("MI"))
 	 		separationDto.setReasonLabel("Medical Issue");
  		else if(separation.getResoan().equals("IC"))
 	 		separationDto.setReasonLabel("Issue with Company");
		else if(separation.getResoan().equals("OT"))
 	 		separationDto.setReasonLabel("Other");
		else if(separation.getResoan().equals("RE"))
 	 		separationDto.setReasonLabel("Resigned");
		else if(separation.getResoan().equals("TE"))
 	 		separationDto.setReasonLabel("Terminated");
		else if(separation.getResoan().equals("AB"))
 	 		separationDto.setReasonLabel("Absconded");
 		
 		
 		if (separation.getStatus().equals(StatusMessage.PENDING_CODE))
			separationDto.setStatusLabel(StatusMessage.PENDING_VALUE);
		else if (separation.getStatus().equals(StatusMessage.APPROVED_CODE))
 			separationDto.setStatusLabel(StatusMessage.APPROVED_VALUE);
		else if (separation.getStatus().equals(StatusMessage.REJECTED_CODE ))
 			separationDto.setStatusLabel(StatusMessage.REJECTED_VALUE);
		else if (separation.getStatus().equals( StatusMessage.CANCEL_CODE))
 			separationDto.setStatusLabel(StatusMessage.CANCEL_VALUE);
 		
 		 
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		separationDto.setDesignationName(separation.getEmployee1().getDesignation().getDesignationName());
 		separationDto.setInNoticePeriod(separation.getEmployee1().getNoticePeriodDays());
 		
 		
  		return separationDto;
	}
	public List<SeparationDTO> modelListToDtoList(List<Object[]> separationList, EmployeeSearchDTO employeeSearcDto) {

		List<SeparationDTO> separationDtoList = new ArrayList<SeparationDTO>();

		for (Object[] separationObj : separationList) {
			SeparationDTO separationDto = new SeparationDTO();
			if (separationObj[0] != null) {
				separationDto.setSeparationId(separationObj[0] != null ? Long.parseLong(separationObj[0].toString()) : null);
			}
			if (separationObj[1] != null) {
				separationDto.setDateCreated((Date)separationObj[1]);
 			}
			
			if (separationObj[2] != null) {
				separationDto.setResoan(separationObj[2].toString());
				
				
				if(separationDto.getResoan().equals("CG"))
			 		separationDto.setReasonLabel("Career Growth");
			 		else if(separationDto.getResoan().equals("PI"))
			 	 		separationDto.setReasonLabel("Personal Issue");
			 		else if(separationDto.getResoan().equals("MI"))
			 	 		separationDto.setReasonLabel("Medical Issue");
			  		else if(separationDto.getResoan().equals("IC"))
			 	 		separationDto.setReasonLabel("Issue with Company");
					else if(separationDto.getResoan().equals("OT"))
			 	 		separationDto.setReasonLabel("Other");
					else if(separationDto.getResoan().equals("RE"))
			 	 		separationDto.setReasonLabel("Resigned");
					else if(separationDto.getResoan().equals("TE"))
			 	 		separationDto.setReasonLabel("Terminated");
					else if(separationDto.getResoan().equals("AB"))
			 	 		separationDto.setReasonLabel("Absconded");
				
				
				
			}
			if (separationObj[3] != null) {
				separationDto.setEndDate((Date)separationObj[3]);
 			}
			
			if (separationObj[4] != null) {
				separationDto.setStatus(separationObj[4].toString());
				if (separationDto.getStatus().equals(StatusMessage.PENDING_CODE))
					separationDto.setStatusLabel(StatusMessage.PENDING_VALUE);
				else if (separationDto.getStatus().equals(StatusMessage.APPROVED_CODE))
		 			separationDto.setStatusLabel(StatusMessage.APPROVED_VALUE);
				else if (separationDto.getStatus().equals(StatusMessage.REJECTED_CODE))
		 			separationDto.setStatusLabel(StatusMessage.REJECTED_VALUE);
				else if (separationDto.getStatus().equals(StatusMessage.CANCEL_CODE))
		 			separationDto.setStatusLabel(StatusMessage.CANCEL_VALUE);
			}
			
			if (separationObj[5] != null) {
				separationDto.setFirstName(separationObj[5].toString());
			}
			if (separationObj[6] != null) {
				separationDto.setLastName(separationObj[6].toString());
			}
			
			if (separationObj[7] != null) {
				separationDto.setInNoticePeriod((separationObj[7] != null ? Long.parseLong(separationObj[7].toString()) : null));
			}
			if (separationObj[8] != null) {
				separationDto.setEmployeeId((separationObj[8] != null ? Long.parseLong(separationObj[8].toString()) : null));
			}
			
			if (separationObj[9] != null) {
				separationDto.setDesignationName(separationObj[9].toString());
			}
			if (separationObj[10] != null) {
				separationDto.setDescription(separationObj[10].toString());
			}
			if (separationObj[11] != null) {
				separationDto.setRemark(separationObj[11].toString());
			}
 
			separationDtoList.add(separationDto);

		}
 		return separationDtoList;
 		
 	}

}
