package com.csipl.tms.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.leave.TMSLeaveTypeMaster;



public interface LeaveTypeMasterRepository extends CrudRepository<TMSLeaveTypeMaster, Long>{
	@Query(" from TMSLeaveTypeMaster where companyId =?1 ")
    public List<TMSLeaveTypeMaster> findAllLeaveTypeMaster(Long companyId);
}
