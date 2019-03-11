package com.csipl.hrms.service.adaptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.EmployeeFamilyDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeFamily;
public class FamilyAdaptor implements Adaptor<EmployeeFamilyDTO, EmployeeFamily> {
 	
	DateUtils dateUtils = new DateUtils();
	
	public List<EmployeeFamily>empFamilyDtoToDatabaseModelList(List<EmployeeFamilyDTO> employeeFamilyDtoList,String empId) {
		List<EmployeeFamily> employeeFamilyList=new ArrayList<EmployeeFamily>();
		for (EmployeeFamilyDTO employeeFamilyDto : employeeFamilyDtoList) {
			employeeFamilyList.add(empFamilyDtoToDatabaseModel(employeeFamilyDto,empId));
 		}		 
 		return employeeFamilyList;
	}
 	@Override
	public List<EmployeeFamilyDTO> databaseModelToUiDtoList(List<EmployeeFamily> employeeFamilyList) {
 		List<EmployeeFamilyDTO> employeeFamilyDtoList=new ArrayList<EmployeeFamilyDTO>();
 		for (EmployeeFamily employeeFamily : employeeFamilyList) {
 			employeeFamilyDtoList.add(databaseModelToUiDto(employeeFamily));
		}
  		return employeeFamilyDtoList;
	}
 	
	public EmployeeFamily empFamilyDtoToDatabaseModel(EmployeeFamilyDTO employeeFamilyDto,String empId) {
		
 		EmployeeFamily employeeFamily=new EmployeeFamily();
 		Long employeeId =Long.parseLong(empId);
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		employeeFamily.setEmployee(employee);
 		employeeFamily.setFamilyId(employeeFamilyDto.getFamilyId());
		employeeFamily.setRelation(employeeFamilyDto.getRelation());
		employeeFamily.setCaptions(employeeFamilyDto.getCaptions());
		employeeFamily.setName(employeeFamilyDto.getName());
		employeeFamily.setQualificationId(employeeFamilyDto.getQualificationId());
		employeeFamily.setOccupations(employeeFamilyDto.getOccupations());
		if(employeeFamilyDto.getDateOfBirth()!=null && !("").equals(employeeFamilyDto.getDateOfBirth()))
		employeeFamily.setDateOfBirth(dateUtils.getDateWirhYYYYMMDD(employeeFamilyDto.getDateOfBirth()));
		employeeFamily.setContactMobile(employeeFamilyDto.getContactMobile());
		employeeFamily.setContactPhone(employeeFamilyDto.getContactPhone());
		employeeFamily.setUserId(employeeFamilyDto.getUserId());
		if(employeeFamilyDto.getDateCreated()==null)
			employeeFamily.setDateCreated(new Date());
		else
		employeeFamily.setDateCreated(employeeFamilyDto.getDateCreated());
		employeeFamily.setDateUpdate(new Date());
		employeeFamily.setUserIdUpdate(employeeFamilyDto.getUserIdUpdate());
 		return employeeFamily;
	}
 	@Override
	public EmployeeFamilyDTO databaseModelToUiDto(EmployeeFamily employeeFamily) {
 		EmployeeFamilyDTO employeeFamilyDto=new EmployeeFamilyDTO();
 		employeeFamilyDto.setFamilyId(employeeFamily.getFamilyId());
 		employeeFamilyDto.setRelation(employeeFamily.getRelation());
 		employeeFamilyDto.setCaptions(employeeFamily.getCaptions());
 		employeeFamilyDto.setName(employeeFamily.getName());
 		employeeFamilyDto.setQualificationId(employeeFamily.getQualificationId());
 		employeeFamilyDto.setOccupations(employeeFamily.getOccupations());
 		if(employeeFamily.getDateOfBirth()!=null) {
 			String dateOfBirth = dateUtils.getDateStringWirhYYYYMMDD(employeeFamily.getDateOfBirth());
 	 		employeeFamilyDto.setDateOfBirth(dateOfBirth);
 		}
 		employeeFamilyDto.setContactMobile(employeeFamily.getContactMobile());
 		employeeFamilyDto.setContactPhone(employeeFamily.getContactPhone()); 	
 		employeeFamilyDto.setUserId(employeeFamily.getUserId());
 		employeeFamilyDto.setDateCreated(employeeFamily.getDateCreated());
 		return employeeFamilyDto;
	}
	@Override
	public List<EmployeeFamily> uiDtoToDatabaseModelList(List<EmployeeFamilyDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EmployeeFamily uiDtoToDatabaseModel(EmployeeFamilyDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}
  }
