package com.csipl.tms.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.model.leave.TMSLeaveRuleMaster;

@Repository
public interface TMSLeaveRuleMasterRepository extends CrudRepository<TMSLeaveRuleMaster, Long>{
	
	@Query(" from TMSLeaveRuleMaster where companyId =?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
    public List<TMSLeaveRuleMaster> findAllLeaveRule(Long companyId);
	
}
