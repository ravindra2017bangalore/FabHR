package com.csipl.hrms.service.employee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.EmployeeBank;


public interface BankDetailsRepository extends CrudRepository<EmployeeBank, Long>{

	@Query(" from EmployeeBank where employeeId=?1 AND activeStatus='AC' ORDER BY  employeeBankId  DESC") //and activeStatus='AC'
    public List<EmployeeBank> findAllBankDetails(Long employeeId);
	@Query(" from EmployeeBank where employeeId=?1  AND accountType ='SA' ORDER BY  employeeBankId  DESC") //and activeStatus='AC'
    public List<EmployeeBank> findBankDetails(Long employeeId);
}
