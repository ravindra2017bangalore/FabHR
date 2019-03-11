package com.csipl.hrms.service.adaptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.payroll.OneTimeDeductionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.OneTimeDeduction;

public class OneTimeDeductionAdaptor implements Adaptor<OneTimeDeductionDTO , OneTimeDeduction>{

	@Override
	public List<OneTimeDeduction> uiDtoToDatabaseModelList(List<OneTimeDeductionDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OneTimeDeductionDTO> databaseModelToUiDtoList(List<OneTimeDeduction> oneTimeDeductionList) {
		// TODO Auto-generated method stub
		List<OneTimeDeductionDTO> oneTimeDeductionDTOList = new ArrayList<OneTimeDeductionDTO>();
		for (OneTimeDeduction oneTimeDeduction : oneTimeDeductionList) {
			oneTimeDeductionDTOList.add(databaseModelToUiDto(oneTimeDeduction));
		}
		return oneTimeDeductionDTOList;
		
	}

	@Override
	public OneTimeDeduction uiDtoToDatabaseModel(OneTimeDeductionDTO oneTimeDeductionDTO) {
		// TODO Auto-generated method stub
		OneTimeDeduction oneTimeDeduction=new OneTimeDeduction();
		if(oneTimeDeductionDTO!=null)
		{
			
			System.out.println(oneTimeDeductionDTO.getEmployeeId());
			oneTimeDeduction.setDeductionMonth(oneTimeDeductionDTO.getDeductionMonth());
			oneTimeDeduction.setDeductionAmount(oneTimeDeductionDTO.getDeductionAmount());
			oneTimeDeduction.setRemarks(oneTimeDeductionDTO.getRemarks());
			oneTimeDeduction.setDeductionId(oneTimeDeductionDTO.getDeductionId());
			//oneTimeDeductionDTO.setUserId(oneTimeDeductionDTO.getUserId());
			Company company = new Company();
			company.setCompanyId(oneTimeDeductionDTO.getCompanyId());
			oneTimeDeduction.setCompany(company);
			if(oneTimeDeductionDTO.getDateCreated()==null)
			{
				oneTimeDeduction.setDateCreated(new Date());
			}
			else
			{
				oneTimeDeduction.setDateCreated(oneTimeDeductionDTO.getDateCreated());
			}
			oneTimeDeduction.setDateCreated(new Date());
			oneTimeDeduction.setUpdateDate(new Date());
			oneTimeDeduction.setUpdateId(oneTimeDeductionDTO.getUpdateId());
			oneTimeDeduction.setUserId(oneTimeDeductionDTO.getUserId());
			Employee emp=new Employee();
			emp.setEmployeeId(oneTimeDeductionDTO.getEmployeeId());
			oneTimeDeduction.setEmployee(emp);
			
		}
			
			
			return oneTimeDeduction;
	}

	@Override
	public OneTimeDeductionDTO databaseModelToUiDto(OneTimeDeduction oneTimeDeduction) {
		// TODO Auto-generated method stub
		OneTimeDeductionDTO oneTimeDeductionDTO=new OneTimeDeductionDTO();
		oneTimeDeduction.setDeductionId(oneTimeDeduction.getDeductionId());
		oneTimeDeductionDTO.setEmployeeId(oneTimeDeduction.getEmployee().getEmployeeId());
		oneTimeDeductionDTO.setemployeeName(oneTimeDeduction.getEmployee().getFirstName()+" "+oneTimeDeduction.getEmployee().getLastName());
		oneTimeDeductionDTO.setDepartmentName(oneTimeDeduction.getEmployee().getDepartment().getDepartmentName());
		oneTimeDeductionDTO.setDesignationName(oneTimeDeduction.getEmployee().getDesignation().getDesignationName());
		oneTimeDeductionDTO.setDeductionMonth(oneTimeDeduction.getDeductionMonth());
		oneTimeDeductionDTO.setDeductionAmount(oneTimeDeduction.getDeductionAmount());
		oneTimeDeductionDTO.setEmployeeCode(oneTimeDeduction.getEmployee().getEmployeeCode());
		oneTimeDeductionDTO.setDeductionId(oneTimeDeduction.getDeductionId());
		oneTimeDeductionDTO.setUserId(oneTimeDeduction.getUserId());
		System.out.println("=================user id from database=========="+oneTimeDeduction.getUserId());
		oneTimeDeductionDTO.setRemarks(oneTimeDeduction.getRemarks());
		oneTimeDeductionDTO.setDateCreated(oneTimeDeduction.getDateCreated());
		
		return oneTimeDeductionDTO;
	}

	
}
