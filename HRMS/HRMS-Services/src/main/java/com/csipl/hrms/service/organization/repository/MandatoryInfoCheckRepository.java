package com.csipl.hrms.service.organization.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.MandatoryInfoCheck;

public interface MandatoryInfoCheckRepository extends CrudRepository<MandatoryInfoCheck, Long> {
	
	/*@Query("UPDATE MandatoryInfoCheck man set man.bankAccFlag ='BA' WHERE man.empId=?1")
	public  int updateMandatoryInfoCheck(Long empId);*/
	@Query("from MandatoryInfoCheck man where man.employee.employeeId=?1")
	public MandatoryInfoCheck getMandatoryInfoCheck(Long empId);
}
