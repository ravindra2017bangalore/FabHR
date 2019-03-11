package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.EmployeeStatuary;


public interface EmployeeStatuaryRepository extends CrudRepository<EmployeeStatuary, Long>{
 
	@Query(" from EmployeeStatuary where employeeId=?1 ") 
    public List<EmployeeStatuary> findAllEmployeeStatuarys(Long employeeId); 
}
