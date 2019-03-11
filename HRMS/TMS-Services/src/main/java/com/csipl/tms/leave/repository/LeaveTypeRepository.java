package com.csipl.tms.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.csipl.tms.model.leave.TMSLeaveType;

public interface LeaveTypeRepository extends CrudRepository<TMSLeaveType, Long>{
	@Query(" from TMSLeaveType where companyId =?1 ")
    public List<TMSLeaveType> findAllLeaveType(Long companyId);
	@Query(" from TMSLeaveType where leaveTypeId =?1 ") 
 	public TMSLeaveType getLeaveTypeById(Long leaveTypeId);
	
	@Query(" from TMSLeaveType where leavePeriodId =?1 ")
    public List<TMSLeaveType> findAllPeriod(Long leavePeriodId);
	
}
