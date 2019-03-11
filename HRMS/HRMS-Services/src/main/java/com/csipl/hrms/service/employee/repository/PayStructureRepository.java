package com.csipl.hrms.service.employee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
import com.csipl.hrms.model.employee.PayStructureHd;
  
public interface PayStructureRepository extends CrudRepository<PayStructureHd, Long> {

	@Query(" from PayStructureHd where  ( dateEnd is null or dateEnd>=?1) and (effectiveDate is NOT null and effectiveDate<=?1) and employeeId=?2") 
 	public PayStructureHd payStructureRevisionList(Date currentDate,Long employeeId);
	
 	@Query(" from PayStructureHd where  (dateEnd is null) and (effectiveDate is NOT null and effectiveDate>?1) and employeeId=?2") 
	public PayStructureHd getPayRevision(Date currentDate,Long employeeId);
 	
 	@Query(" from PayStructureHd where  employeeId=?1") 
	public List<PayStructureHd> getEmployeePayRevisionList(Long employeeId);
 	
  }
