package com.csipl.hrms.service.organization.repository;

 
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.Designation;
   
public interface DesignationRepository extends CrudRepository<Designation, Long>{
  	@Query("from Designation where companyId=?1 ORDER BY  designationId  DESC ") 
 	public List<Designation> findAllDesignations(Long companyId);
  	
  	@Query("from Designation where companyId=?1 And departmentId=?2 ORDER BY  designationId  DESC ") 
 	public List<Designation> designationListBasedOnDepartmnt(Long companyId,Long departmentId);
 }

