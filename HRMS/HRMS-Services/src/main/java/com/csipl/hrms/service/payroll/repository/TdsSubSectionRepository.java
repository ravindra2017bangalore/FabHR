package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsSection;
import com.csipl.hrms.model.payroll.TdsSubSection;

public interface TdsSubSectionRepository  extends CrudRepository<TdsSubSection, Long> {
	@Query(" from TdsSubSection ORDER BY  tdsSubSectionId  DESC")
    public  List<TdsSubSection> save() ;
	@Query(" from TdsSubSection ORDER BY  tdsSubSectionId  DESC")
    public  List<TdsSubSection> findAllTdsSubSections() ;
	

}
