package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.TdsCityMaster;

public interface TdsCityMasterRepository extends CrudRepository<TdsCityMaster, Long> {

	@Query("from TdsCityMaster where companyId=?1 and financialYear=?2")
	public List<TdsCityMaster> getTdsCityMaster(Long companyId, String financialYear);
}
