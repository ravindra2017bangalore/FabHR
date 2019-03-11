/*package com.csipl.tms.employeeinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.common.Employee;

public interface EmployeeInfoRepository extends CrudRepository<Employee, Long> {

	@Query("SELECT e.employeeId,e.employeeCode FROM Employee e where companyId=?1")
	List<Object[]> findEmployeeId(Long companyId);

}
*/