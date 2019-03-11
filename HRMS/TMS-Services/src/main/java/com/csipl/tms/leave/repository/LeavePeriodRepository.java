package com.csipl.tms.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.model.leave.TMSLeavePeriod;

public interface LeavePeriodRepository extends CrudRepository<TMSLeavePeriod, Long>{
	@Query(" from TMSLeavePeriod where companyId =?1 AND activeStatus!='"+StatusMessage.ACTIVE_CODE+"' ")
    public List<TMSLeavePeriod> findAllLeavePeriod(Long companyId);
	
	@Query(" from TMSLeavePeriod where companyId =?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
	  public List<TMSLeavePeriod> findleavePeriodStatus(Long companyId);
}
