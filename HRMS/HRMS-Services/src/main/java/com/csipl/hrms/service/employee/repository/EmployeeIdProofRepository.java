package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.EmployeeIdProof;

public interface EmployeeIdProofRepository extends CrudRepository<EmployeeIdProof, Long>{
	@Query(" from EmployeeIdProof where employeeId=?1  ORDER BY  employeeIdProofsId  DESC")
    public List<EmployeeIdProof> findAllEmpIDProof(Long employeeId);

}
