package com.csipl.hrms.service.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.DeptDesignation;

public interface DeptDesignationRepository extends CrudRepository<DeptDesignation,Long>{
	
 	String findAllDeptDesignation="select  DISTINCT deptdesg.departmentId , dept.departmentName ,deptdesg.userId from DeptDesignation deptdesg  LEFT JOIN Department dept ON dept.departmentId= deptdesg.departmentId where deptdesg. companyId=?1 AND deptdesg.activeStatus='AC'";
 	@Query(value=findAllDeptDesignation,nativeQuery = true) 
	List<Object[]>  findAllDeptDesignation(Long companyId);
	
	 	@Query(" from DeptDesignation where companyId=?1 and departmentId =?2 and activeStatus ='AC' ORDER BY  deptDesgId  DESC")
 	public List<DeptDesignation> AllDeptbasedDesignation(Long companyId ,Long dedpartmentId);
}
