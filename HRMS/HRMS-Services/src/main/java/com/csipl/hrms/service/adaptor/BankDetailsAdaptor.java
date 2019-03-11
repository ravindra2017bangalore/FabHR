package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;

public class BankDetailsAdaptor implements Adaptor<BankDetailsDTO, EmployeeBank> {

	@Override
	public List<EmployeeBank> uiDtoToDatabaseModelList(List<BankDetailsDTO> bankDetailsDtoList) {
		List<EmployeeBank> employeeBankList = new ArrayList<EmployeeBank>();
		for (BankDetailsDTO bankDetailsDto : bankDetailsDtoList) {

			employeeBankList.add(uiDtoToDatabaseModel(bankDetailsDto));
		}
		return employeeBankList;
	}

	@Override
	public List<BankDetailsDTO> databaseModelToUiDtoList(List<EmployeeBank> employeeBankList) {
		List<BankDetailsDTO> employeeBankDtoList = new ArrayList<BankDetailsDTO>();
		for (EmployeeBank employeeBank : employeeBankList) {

			employeeBankDtoList.add(databaseModelToUiDto(employeeBank));
		}
		return employeeBankDtoList;
	}

	public EmployeeBank bankDetailsDtoToDatabaseModel(BankDetailsDTO bankDetailsDTO, String empId) {
		EmployeeBank employeeBank = new EmployeeBank();
		Employee employee = new Employee();

		Long employeeId = Long.parseLong(empId);
		employee.setEmployeeId(employeeId);
		employeeBank.setEmployeeBankId(bankDetailsDTO.getEmployeeBankId());
		employeeBank.setBankId(bankDetailsDTO.getBankId());
		employeeBank.setAccountType(bankDetailsDTO.getAccountType());
		employeeBank.setAccountNumber(bankDetailsDTO.getAccountNumber());
		employeeBank.setIfscCode(bankDetailsDTO.getIfscCode());
		employeeBank.setBankBranch(bankDetailsDTO.getBankBranch());
		employeeBank.setEffectiveDate(bankDetailsDTO.getEffectiveDate());
		employeeBank.setUserId(bankDetailsDTO.getUserId());
		employeeBank.setDateCreated(bankDetailsDTO.getDateCreated());
		employeeBank.setActiveStatus("AC");
		employeeBank.setEmployee(employee);

		return employeeBank;
	}

	@Override
	public BankDetailsDTO databaseModelToUiDto(EmployeeBank employeeBank) {
		BankDetailsDTO bankDetailsDTO = new BankDetailsDTO();
		bankDetailsDTO.setEmployeeBankId(employeeBank.getEmployeeBankId());
		bankDetailsDTO.setBankIdLabel(DropDownCache.getInstance().getDropDownValue(DropDownEnum.BankName.getDropDownName(), employeeBank.getBankId()));
		bankDetailsDTO.setBankId(employeeBank.getBankId());
		bankDetailsDTO.setAccountType(employeeBank.getAccountType());
		bankDetailsDTO.setAccountTypeLabel(DropDownCache.getInstance().getDropDownValue(DropDownEnum.AccountType.getDropDownName(), employeeBank.getAccountType()));
		bankDetailsDTO.setAccountNumber(employeeBank.getAccountNumber());
		bankDetailsDTO.setIfscCode(employeeBank.getIfscCode());
		bankDetailsDTO.setBankBranch(employeeBank.getBankBranch());
		bankDetailsDTO.setEffectiveDate(employeeBank.getEffectiveDate());
		// bankDetailsDTO.setEmployeeId(employeeBank.getEmployeeId());
		// employeeBank.setEmployeeId(1L);
		bankDetailsDTO.setUserId(employeeBank.getUserId());
		bankDetailsDTO.setDateCreated(employeeBank.getDateCreated());
		bankDetailsDTO.setStatus(employeeBank.getActiveStatus());

		return bankDetailsDTO;
	}

	@Override
	public EmployeeBank uiDtoToDatabaseModel(BankDetailsDTO bankDetailsDto) {
		EmployeeBank employeeBank = new EmployeeBank();
		Employee employee = new Employee();
		employee.setEmployeeId(bankDetailsDto.getEmployeeId());
		employeeBank.setBankId(bankDetailsDto.getBankId());
		employeeBank.setAccountType(bankDetailsDto.getAccountType());
		employeeBank.setAccountNumber(bankDetailsDto.getAccountNumber());
		employeeBank.setIfscCode(bankDetailsDto.getIfscCode());
		employeeBank.setEmployee(employee);
		employeeBank.setBankBranch(bankDetailsDto.getBankBranch());
		employeeBank.setEffectiveDate(bankDetailsDto.getEffectiveDate());
		employeeBank.setUserId(bankDetailsDto.getUserId());
		employeeBank.setDateCreated(bankDetailsDto.getDateCreated());
		return employeeBank;
	}

	public List<EmployeeBank> uiDtoToDatabaseModelList(List<BankDetailsDTO> bankDetailsDtoList, Employee employee) {
		List<EmployeeBank> employeeBankList = new ArrayList<EmployeeBank>();

		for (BankDetailsDTO bankDetailsDto : bankDetailsDtoList) {

			employeeBankList.add(uiDtoToDatabaseModel(bankDetailsDto, employee));
		}
		return employeeBankList;
	}

	public EmployeeBank uiDtoToDatabaseModel(BankDetailsDTO bankDetailsDto, Employee employee) {
		EmployeeBank employeeBank = new EmployeeBank();
		employeeBank.setBankId(bankDetailsDto.getBankId());

		employeeBank.setAccountType(bankDetailsDto.getAccountType());
		employeeBank.setAccountNumber(bankDetailsDto.getAccountNumber());
		employeeBank.setIfscCode(bankDetailsDto.getIfscCode());
		employeeBank.setEmployee(employee);
		employeeBank.setBankBranch(bankDetailsDto.getBankBranch());
		employeeBank.setEffectiveDate(bankDetailsDto.getEffectiveDate());
		employeeBank.setUserId(employee.getUserId());
		employeeBank.setDateCreated(bankDetailsDto.getDateCreated());
  		employeeBank.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());

		return employeeBank;
	}
 	public List<EmployeeBank> empUiDtoToDatabaseModelList(List<BankDetailsDTO> bankDetailsDtoList,Long employeeId) {
		List<EmployeeBank> employeeBankList = new ArrayList<EmployeeBank>();
		for (BankDetailsDTO bankDetailsDto : bankDetailsDtoList) {
 			employeeBankList.add(empUiDtoToDatabaseModel(bankDetailsDto,employeeId));
		}
		return employeeBankList;
	}
	public EmployeeBank empUiDtoToDatabaseModel(BankDetailsDTO bankDetailsDto, Long employeeId) {
		EmployeeBank employeeBank = new EmployeeBank();
		Employee employee=new Employee();
		employeeBank.setEmployeeBankId(bankDetailsDto.getEmployeeBankId());
		employeeBank.setBankId(bankDetailsDto.getBankId());
 		employeeBank.setAccountType(bankDetailsDto.getAccountType());
		employeeBank.setAccountNumber(bankDetailsDto.getAccountNumber());
		employeeBank.setIfscCode(bankDetailsDto.getIfscCode());
		employeeBank.setEmployee(employee);
		employeeBank.setBankBranch(bankDetailsDto.getBankBranch());
		employeeBank.setEffectiveDate(bankDetailsDto.getEffectiveDate());
		employeeBank.setUserId(bankDetailsDto.getUserId());
		employee.setEmployeeId(employeeId);
		employeeBank.setEmployee(employee);
		employeeBank.setActiveStatus(bankDetailsDto.getStatus());
		if(bankDetailsDto.getDateCreated()==null)
			employeeBank.setDateCreated(new Date());
		else
			employeeBank.setDateCreated(bankDetailsDto.getDateCreated());
		employeeBank.setDateUpdate(new Date());
		employeeBank.setUserIdUpdate(bankDetailsDto.getUserIdUpdate());
		return employeeBank;
	}
}
