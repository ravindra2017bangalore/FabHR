package com.csipl.tms.leave.repository;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;


public interface LeaveRulesHdRepository extends CrudRepository<TMSLeaveRulesHd, Long>{
	
	@Query(" from TMSLeaveRulesHd where companyId =?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
    public List<TMSLeaveRulesHd> findAllLeaveRulesHd(Long companyId);
	@Query(" from TMSLeaveRulesHd where companyId =?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
    public TMSLeaveRulesHd findLeaveRulesHd(Long companyId);
	//@Query("Select from TMSLeaveRulesHd hd join TMSLeaveRules rule ON hd.leaveRulesHdId=rule.leaveRuleHdId AND tlrh.leavePeriodId=?1 ")
	
	@Query(nativeQuery = true,value="Select * from TMSLeaveRulesHd hd join TMSLeaveRules rule ON hd.leaveRulesHdId=rule.leaveRuleHdId where leavePeriodId=?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
	 public List<TMSLeaveRulesHd> findAllLeavePeriodId(Long leavePeriodId);

	@Query(" from TMSLeaveRulesHd where leavePeriodId =?1 AND activeStatus='"+StatusMessage.ACTIVE_CODE+"'")
    public TMSLeaveRulesHd findLeaveRulesHdByPeriodId(Long leavePeriodId);
	
	@Query(nativeQuery=true, value="Select rule.*, ms.ruleName from TMSLeaveRulesHd hd join TMSLeaveRules rule ON hd.leaveRulesHdId=rule.leaveRuleHdId join TMSLeaveRuleMaster ms ON ms.leaveRuleMasterId=rule.leaveRuleMasterId where leavePeriodId=?1 ")
    public List<Object[]> findAllRulesByPeriodId(Long leavePeriodId);
	
}
