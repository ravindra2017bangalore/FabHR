package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.EmployeeEducation;


public interface EmployeeEducationRepository extends CrudRepository<EmployeeEducation, Long>{
 
	@Query(" from EmployeeEducation where employeeId=?1 ") 
    public List<EmployeeEducation> findAllEmployeeEducations(Long employeeId); 
}
