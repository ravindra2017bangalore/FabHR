package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.payroll.OtherIncomeDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.OtherIncome;

public class OtherIncomeAdaptor implements Adaptor<OtherIncomeDTO, OtherIncome> {

	@Override
	public List<OtherIncome> uiDtoToDatabaseModelList(List<OtherIncomeDTO> otherIncomeDtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OtherIncomeDTO> databaseModelToUiDtoList(List<OtherIncome> otherIncomeList) {
		List<OtherIncomeDTO> otherIncomeDtoList=new ArrayList<>();
		for(OtherIncome otherIncome:otherIncomeList) {
			otherIncomeDtoList.add(databaseModelToUiDto(otherIncome));
		}
		return otherIncomeDtoList;
	}

	@Override
	public OtherIncome uiDtoToDatabaseModel(OtherIncomeDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OtherIncomeDTO databaseModelToUiDto(OtherIncome otherIncome) {
		OtherIncomeDTO otherIncomeDto=new OtherIncomeDTO();
		otherIncomeDto.setOtherIncomeId(otherIncome.getOtherIncomeId());
		otherIncomeDto.setDescription(otherIncome.getDescription());
		otherIncomeDto.setEmployeeId(otherIncome.getEmployee().getEmployeeId());
		otherIncomeDto.setAmount(otherIncome.getAmount());
		otherIncomeDto.setUserId(otherIncome.getUserId());
		otherIncomeDto.setDateCreated(otherIncome.getDateCreated());
		otherIncomeDto.setApproveStatus(otherIncome.getApproveStatus());
		otherIncomeDto.setStatus(otherIncome.getStatus());
		return otherIncomeDto;
	}
	
	
	public List<OtherIncome> uiDtoToOtherIncomeList(List<OtherIncomeDTO> otherIncomeDtoList, Long employeeId) {
		List<OtherIncome> otherIncomeList=new ArrayList<>();
		for(OtherIncomeDTO otherIncomeDto:otherIncomeDtoList) {
			otherIncomeList.add(uiDtoToOtherIncomeModel(otherIncomeDto, employeeId));
		}
		return otherIncomeList;
	}
	
	public OtherIncome uiDtoToOtherIncomeModel(OtherIncomeDTO otherIncomeDto, Long employeeId) {
		OtherIncome otherIncome=new OtherIncome();
		otherIncome.setOtherIncomeId(otherIncomeDto.getOtherIncomeId());
		otherIncome.setAmount(otherIncomeDto.getAmount());
		otherIncome.setDescription(otherIncomeDto.getDescription());
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		Company company=new Company();
		company.setCompanyId(otherIncomeDto.getCompanyId());
		otherIncome.setCompany(company);
		otherIncome.setEmployee(employee);
		otherIncome.setUserId(otherIncomeDto.getUserId());
		otherIncome.setUserIdUpdate(otherIncomeDto.getUserIdUpdate());
		otherIncome.setDateUpdate(new Date());
		if(otherIncomeDto.getDateCreated()!=null)
		otherIncome.setDateCreated(otherIncomeDto.getDateCreated());
		else
			otherIncome.setDateCreated(new Date());
		otherIncome.setApproveStatus(otherIncomeDto.getApproveStatus());
		return otherIncome;
	}

}
