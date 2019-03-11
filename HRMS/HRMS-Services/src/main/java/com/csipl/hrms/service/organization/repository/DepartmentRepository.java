package com.csipl.hrms.service.organization.repository;

 
 import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.organisation.Department;

 
public interface DepartmentRepository extends CrudRepository<Department, Long>{
 
 	@Query(" from Department where companyId=?1 ORDER BY  departmentId  DESC")
 	public List<Department> findAllDepartment(Long companyId );
 	
	@Query("FROM Department d where d.departmentId not in (SELECT p.id.departmentId FROM PayRollLock p where p.id.processMonth=?1 and p.isPayRollLocked='false')") 
 	public  List<Department> findDepartment(String processMonth);//,Long companyId
 	
}

