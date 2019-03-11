 package com.csipl.hrms.service.adaptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.DesignationDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;

    
public class DesignationAdaptor implements Adaptor<DesignationDTO,Designation>{

	
 	public Designation uiDtoToDatabaseModel(DesignationDTO designationDto) {
  		Designation designation=new Designation();
  		Groupg groupg = new Groupg();
		Company company = new Company();
		company.setCompanyId(designationDto.getCompanyId());
		designation.setCompany(company);
		
		if (designationDto != null) {
			designation.setUserId(designationDto.getUserId());
			designation.setDesignationId(designationDto.getDesignationId());
			designation.setDesignationName(designationDto.getDesignationName());
		}
		if (designation.getDesignationId() == null)
			designation.setDateCreated(new Date());
		else
			designation.setDateCreated(designationDto.getDateCreated());

		
    	/*Department department =new Department();
    	department.setDepartmentName(designationDto.getDepartmentName());
    	department.setDepartmentId(designationDto.getDepartmentId());
      	designation.setDepartment(department);*/
      	
      	
      	designation.setDateUpdate(new Date());
      	designation.setUserIdUpdate(designationDto.getUserIdUpdate());
		groupg.setGroupId(1l);
		designation.setGroupg(groupg);

         return designation;
	} 
 	@Override
	public List<Designation> uiDtoToDatabaseModelList(List<DesignationDTO> DesignationDtoList) {
 		List<Designation> designationList=new ArrayList<Designation>();
 		for(DesignationDTO designationDto:DesignationDtoList) {
 			designationList.add(uiDtoToDatabaseModel(designationDto));
 		}
		return designationList;
	}
 	@Override
	public List<DesignationDTO> databaseModelToUiDtoList(List<Designation> designationList) {
		List<DesignationDTO> departmentDtoList =new ArrayList<DesignationDTO>();
		for (Designation designation : designationList) {
			departmentDtoList.add(databaseModelToUiDto(designation));
		}
  		return departmentDtoList;
	}
 	@Override
	public DesignationDTO databaseModelToUiDto(Designation designation) {
 		DesignationDTO designationDto=new DesignationDTO();
 		designationDto.setDesignationId(designation.getDesignationId());
 		designationDto.setDesignationName(designation.getDesignationName());
 		
 		if(designation.getDepartment()!=null) {
 		designationDto.setDepartmentId(designation.getDepartment().getDepartmentId());
 		designationDto.setDepartmentName(designation.getDepartment().getDepartmentName());
 		}
 		designationDto.setUserId(designation.getUserId());
 		designationDto.setDateCreated(designation.getDateCreated());
  		return designationDto;
	}
  	 
 }
