package com.csipl.hrms.service.employee;

import java.util.List;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeFamily;


public interface BankDetailsService {
	public List<EmployeeBank>  saveAll(List<EmployeeBank> employeeBankList);
 	public List<EmployeeBank> findAllBankDetails(String empId);
	 public EmployeeBank save(EmployeeBank employeeBank);
	 public EmployeeBank update(EmployeeBank employeeBank);
	 public void delete(Long empBankId);
	 public EmployeeBank findBankDetails(Long employeeId);
}
