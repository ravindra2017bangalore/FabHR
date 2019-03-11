package com.csipl.hrms.service.payroll.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.Epf;

public interface EpfRepository extends CrudRepository<Epf, Long> {
	
	/*@Query(" from Epf ORDER BY  epfId  DESC ") 
 	public List<Epf> findAllEpfs();*/
	
	@Query(" from Epf epf where epf.effectiveDate <= ?2 and epf.company.companyId = ?1 and activeStatus='AC' ") 
 	public Epf getEPF( Long companyId, Date today );
}
