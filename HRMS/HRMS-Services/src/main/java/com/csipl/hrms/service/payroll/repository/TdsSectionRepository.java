package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsSection;

public interface TdsSectionRepository  extends CrudRepository<TdsSection, Long>{
	@Query(" from TdsSection ORDER BY  tdsSectionId  DESC")
    public  List<TdsSection> findAllTdsSections() ;
	
}
