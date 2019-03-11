package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.ProfessionalInformation;


public interface ProfessionalInformationRepository extends CrudRepository<ProfessionalInformation, Long>{

	@Query(" from ProfessionalInformation where employeeId=?1 ORDER BY  historyId  DESC")
    public List<ProfessionalInformation> findAllProfessionalInformation(Long employeeId);
	
	
}
