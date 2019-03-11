package com.csipl.tms.empcommondetail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.empcommondetails.EmpCommonDetail;

public interface EmpCommonDetailRepository extends CrudRepository<EmpCommonDetail, Long> {

	
	@Query("from EmpCommonDetail where employeeId=?1")
	public EmpCommonDetail getEmployeeCommonDetails(Long employeeId);
	
	@Query("from EmpCommonDetail where companyId=?1")
	public List<EmpCommonDetail> getEmployeeCommonDetailsList(Long companyId);

	@Query("SELECT e.joiningDate FROM EmpCommonDetail e where employeeId=?1")
	public Object[] getEmployeeJoiningDate(Long employeeId);
	

}
