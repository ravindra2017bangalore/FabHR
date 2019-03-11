package com.csipl.hrms.service.adaptor;

import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateStatuaryDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeStatuary;

public class EmpStatutoryBankAdaptor {
	public CandidateStatuaryDTO databaseModelToUiDtoList(EmployeeBank bankDetails,List<EmployeeStatuary> employeeStatuaryList) {
		CandidateStatuaryDTO candidateStatuaryDto = new CandidateStatuaryDTO();
		if(bankDetails!=null) {
		candidateStatuaryDto.setCandidateId(bankDetails.getEmployee().getEmployeeId());
		candidateStatuaryDto.setCandidateStatuaryId(bankDetails.getEmployeeBankId());
		candidateStatuaryDto.setDateCreated(bankDetails.getDateCreated());
		candidateStatuaryDto.setAccountNumber(bankDetails.getAccountNumber());
		candidateStatuaryDto.setActiveStatus(bankDetails.getActiveStatus());
		candidateStatuaryDto.setIfscCode(bankDetails.getIfscCode());
		//candidateStatuaryDto.setOldEsi(bankDetails.getOldEsi());
		candidateStatuaryDto.setUserIdUpdate(bankDetails.getUserIdUpdate());
		candidateStatuaryDto.setUserId(bankDetails.getUserId());
		candidateStatuaryDto.setBranch(bankDetails.getBankBranch());
		candidateStatuaryDto.setBankId(bankDetails.getBankId());
		//candidateStatuaryDto.setOldUan(bankDetails.getOldUan());
		//candidateStatuaryDto.setAccountType(bankDetails.getAccountType());
		candidateStatuaryDto.setAccountType(bankDetails.getAccountType());
		candidateStatuaryDto.setBankName(DropDownCache.getInstance().getDropDownValue(DropDownEnum.BankName.getDropDownName(),bankDetails.getBankId()));;
		}
		return candidateStatuaryDto;
		
	}

	public EmployeeBank UiDtoToDatabaseModel(CandidateStatuaryDTO candidateStatuaryDto, Long empId) {
		EmployeeBank employeeBank = new EmployeeBank();
		Employee employee=new Employee();
		employeeBank.setEmployeeBankId(candidateStatuaryDto.getCandidateStatuaryId());
		employeeBank.setBankId(candidateStatuaryDto.getBankId());
 		employeeBank.setAccountType(candidateStatuaryDto.getAccountType());
		employeeBank.setAccountNumber(candidateStatuaryDto.getAccountNumber());
		employeeBank.setIfscCode(candidateStatuaryDto.getIfscCode());
		
		employeeBank.setBankBranch(candidateStatuaryDto.getBranch());
		//employeeBank.setEffectiveDate(candidateStatuaryDto.getEffectiveDate());
		employeeBank.setUserId(candidateStatuaryDto.getUserId());
		//employeeBank.setUserId(1l);

		employee.setEmployeeId(empId);
		employeeBank.setEmployee(employee);
		employeeBank.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		if(candidateStatuaryDto.getDateCreated()==null)
			employeeBank.setDateCreated(new Date());
		else
			employeeBank.setDateCreated(candidateStatuaryDto.getDateCreated());
		employeeBank.setDateUpdate(new Date());
		employeeBank.setUserIdUpdate(candidateStatuaryDto.getUserIdUpdate());
		return employeeBank;
	}
}
