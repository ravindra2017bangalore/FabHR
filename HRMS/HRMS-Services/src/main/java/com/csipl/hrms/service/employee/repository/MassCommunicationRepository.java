package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.MassCommunication;

public interface MassCommunicationRepository extends CrudRepository<MassCommunication, Long>  {

	@Query(" from MassCommunication where companyId=?1 ORDER BY  massCommunicationId  DESC ")
	 List<MassCommunication> findAllMassCommunications(Long companyId);
}
