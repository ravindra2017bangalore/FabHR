package com.csipl.hrms.service.adaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.payroll.EmpProvisionInfoDTO;
import com.csipl.hrms.dto.payroll.FinancialYearDTO;
import com.csipl.hrms.dto.payroll.ProvisionDTO;
import com.csipl.hrms.dto.payrollprocess.HeaderReportPayOutDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payroll.Provision;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.util.ConverterUtil;



public class ProvisionAdaptor  implements Adaptor<ProvisionDTO, Provision> {

	@Override
	public List<Provision> uiDtoToDatabaseModelList(List<ProvisionDTO> provisionDto) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<ProvisionDTO> databaseModelToUiDtoList(List<Provision> provisionList) {
		 List<ProvisionDTO>  provisionDtoList= new  ArrayList<ProvisionDTO> ();
		 for (Provision provision : provisionList) {
			 provisionDtoList.add(databaseModelToUiDto(provision));
		}
		return provisionDtoList;
	}*/
	public List<ProvisionDTO> databaseObjectArrayToUiDtoList(List<Object[]> objectOfProvisionList) {
 		List<ProvisionDTO>  provisionDtoList=new ArrayList<ProvisionDTO>();				
		for (Object[] provisionObj : objectOfProvisionList) {
			ProvisionDTO provisionDto=new ProvisionDTO();
			Long provisionId=provisionObj[0]!=null?Long.parseLong(provisionObj[0].toString()):null;
			String activeStatus=provisionObj[1]!=null?(String)provisionObj[1]:null;
			Long employeeId=provisionObj[2]!=null?Long.parseLong(provisionObj[2].toString()):null;
			Long departmentId=provisionObj[3]!=null?Long.parseLong(provisionObj[3].toString()):null;
			String processMonth=provisionObj[4]!=null?(String)provisionObj[4]:null;
			String narration=provisionObj[5]!=null?(String)provisionObj[5]:null;
			Long userId=provisionObj[6]!=null?Long.parseLong(provisionObj[6].toString()):null;
			
			String employeeCode=provisionObj[7]!=null?(String)provisionObj[7]:null;
			String employeeName=provisionObj[8]!=null?(String)provisionObj[8]:null;
			String departmentName=provisionObj[12]!=null?(String)provisionObj[12]:null;
			String designationName=provisionObj[13]!=null?(String)provisionObj[13]:null;
			
			provisionDto.setProvisionId(provisionId);
			provisionDto.setActiveStatus(activeStatus);
			provisionDto.setEmployeeId(employeeId);
			provisionDto.setDepartmentId(departmentId);
			provisionDto.setProcessMonth(processMonth);
			provisionDto.setNarration(narration);
			provisionDto.setUserId(userId);
			provisionDto.setEmployeeCode(employeeCode);
			provisionDto.setEmployeeName(employeeName);
			provisionDto.setDepartmentName(departmentName);
            provisionDto.setDesignationName(designationName);
          /*  provisionDto.setBankName(bankName);
			provisionDto.setAccountNumber(accountNO);
			provisionDto.setProvisionSalary(totalEarning);*/
			provisionDtoList.add(provisionDto);
   		}
 			 return provisionDtoList;
	}
	public List<ProvisionDTO> databaseObjectArrayToProvisionList(List<Object[]> objectOfProvisionList) {
 		List<ProvisionDTO>  provisionDtoList=new ArrayList<ProvisionDTO>();				
		for (Object[] provisionObj : objectOfProvisionList) {
			ProvisionDTO provisionDto=new ProvisionDTO();
			
			Long provisionId=provisionObj[0] !=null ?  ConverterUtil.getLong( provisionObj[0]  ) :null;
			
			
			String employeeName=provisionObj[1]!=null?(String)provisionObj[1]:null;
			String employeeCode=provisionObj[2]!=null?(String)provisionObj[2]:null;
		
			String departmentName=provisionObj[3]!=null?(String)provisionObj[3]:null;
		
			String processMonth=provisionObj[4]!=null?(String)provisionObj[4]:null;
			BigDecimal totalEarning=provisionObj[5]!=null?(BigDecimal)provisionObj[5]:null;
			String bankName=provisionObj[6]!=null?(String)provisionObj[6]:null;
			String accountNO=provisionObj[7]!=null?(String)provisionObj[7]:null;
			String narration=provisionObj[8]!=null?(String)provisionObj[8]:null;
			Long employeeId=provisionObj[9]!=null?Long.parseLong(provisionObj[9].toString()):null;
			provisionDto.setProvisionId(provisionId);
			provisionDto.setEmployeeCode(employeeCode);
			provisionDto.setEmployeeName(employeeName);
			provisionDto.setProcessMonth(processMonth);
			provisionDto.setBankName(bankName);
			provisionDto.setAccountNumber(accountNO);
			provisionDto.setDepartmentName(departmentName);
			provisionDto.setNarration(narration);
			provisionDto.setEmployeeId(employeeId);
			provisionDto.setProvisionSalary(totalEarning);
			provisionDtoList.add(provisionDto);
   		}
 			 return provisionDtoList;
	}

	public List<EmpProvisionInfoDTO> databaseModelToEmpProvisionInfoDTOList(Employee employee) {
		 List<EmpProvisionInfoDTO> empProvisionInfoDtoList= new  ArrayList<EmpProvisionInfoDTO> ();
		 EmpProvisionInfoDTO empProvisionInfoDto = new EmpProvisionInfoDTO();
		 empProvisionInfoDto.setDepartmentName(employee.getDepartment().getDepartmentName());
		 empProvisionInfoDto.setDesignationName(employee.getDesignation().getDesignationName());
		 empProvisionInfoDto.setEmployeeCode(employee.getEmployeeCode());
		 empProvisionInfoDto.setEmployeeId(employee.getEmployeeId());
		 empProvisionInfoDto.setEmployeeName(employee.getFirstName()+" "+employee.getLastName());
		 empProvisionInfoDtoList.add(empProvisionInfoDto);
		
		return empProvisionInfoDtoList;
	}

	
	@Override
	public Provision uiDtoToDatabaseModel(ProvisionDTO provisionDto) {
		Provision provision =new Provision();
		Company company= new Company();
		provision.setProvisionId(provisionDto.getProvisionId());
		provision.setNarration(provisionDto.getNarration());
		provision.setProcessMonth(provisionDto.getProcessMonth());
		Department department=new Department();
		department.setDepartmentId(provisionDto.getDepartmentId());
		provision.setDepartment(department);
		Employee employee= new Employee();
		employee.setEmployeeId(provisionDto.getEmployeeId());
		provision.setEmployee(employee);
		provision.setUserId(provisionDto.getUserId());
		provision.setDateCreated(provisionDto.getDateCreated());
		company.setCompanyId(provisionDto.getCompanyId());
		provision.setCompany(company);
		provision.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		return provision;
	}

	@Override
	public ProvisionDTO databaseModelToUiDto(Provision provision) {
		ProvisionDTO provisionDto= new ProvisionDTO();
		provisionDto.setDepartmentId(provision.getDepartment().getDepartmentId());
		provisionDto.setDepartmentName(provision.getDepartment().getDepartmentName());
		provisionDto.setEmployeeId(provision.getEmployee().getEmployeeId());
		provisionDto.setEmployeeName(provision.getEmployee().getFirstName()+ " "+provision.getEmployee().getLastName());
		provisionDto.setNarration(provision.getNarration());
		provisionDto.setProcessMonth(provision.getProcessMonth());
		provisionDto.setProvisionId(provision.getProvisionId());
		provisionDto.setDesignationId(provision.getEmployee().getDesignation().getDesignationId());
		provisionDto.setDesignationName(provision.getEmployee().getDesignation().getDesignationName());
		provisionDto.setEmployeeCode(provision.getEmployee().getEmployeeCode());
		provisionDto.setUserId(provision.getUserId());
		provisionDto.setDateCreated(provision.getDateCreated());
		provisionDto.setActiveStatus(provision.getActiveStatus());
	System.out.println(provisionDto);
		return provisionDto;
	}

	@Override
	public List<ProvisionDTO> databaseModelToUiDtoList(List<Provision> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
