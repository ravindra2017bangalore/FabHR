package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.employee.EmployeeAsset;
import com.csipl.hrms.model.employee.EmployeeIdProof;



public interface EmployeeAssetRepository extends CrudRepository<EmployeeAsset, Long> {
	@Query(" from EmployeeAsset where employeeId=?1")
    public List<EmployeeAsset> findAllEmpAssets(Long employeeId);

}
