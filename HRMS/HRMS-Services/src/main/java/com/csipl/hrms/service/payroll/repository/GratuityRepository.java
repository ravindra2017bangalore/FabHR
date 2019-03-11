package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.Gratuaty;

public interface GratuityRepository extends CrudRepository<Gratuaty, Long> {

	@Query(" from Gratuaty where companyId=?1 ORDER BY  graduityId DESC")
	public List<Gratuaty> findAllGratuity(Long cmopanyId);

}
