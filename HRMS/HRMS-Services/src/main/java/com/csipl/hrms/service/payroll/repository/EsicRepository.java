package com.csipl.hrms.service.payroll.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.Esi;

public interface EsicRepository extends CrudRepository<Esi, Long> {
	
	/*@Query("from Esi ORDER BY esiId  DESC")
    public List<Esi> findAllEsic();*/
	
	@Query(" from Esi esi where esi.effectiveDate <= ?2 and esi.company.companyId = ?1 and activeStatus='AC' ") 
    public Esi getESI( long companyId, Date today );
	
}
