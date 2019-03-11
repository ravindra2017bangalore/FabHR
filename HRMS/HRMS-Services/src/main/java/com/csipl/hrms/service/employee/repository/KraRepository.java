package com.csipl.hrms.service.employee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.Kra;

public interface KraRepository extends CrudRepository<Kra, Long>
{
 	@Query("from Kra where companyId=?1 ORDER BY  kraId  DESC") 
 	public List<Kra> findAllKras(Long companyId);
 }

