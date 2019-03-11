package com.csipl.tms.leave.service;

import java.util.List;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.tms.model.leave.CompensatoryOff;

public interface CompensatoryOffService {
	public CompensatoryOff saveAll(CompensatoryOff compensatoryOff) ;
	public List<CompensatoryOff> findAllCompensatoryOff(Long companyId);
	public List<CompensatoryOff> findMyCompOffPendingReqList(Long employeeId);
	public List<CompensatoryOff> findMyCompOffExcludedPendingReqList(Long employeeId); 
	public List<CompensatoryOff> findAllCompOffPendingReqList(Long companyId);
	public List<CompensatoryOff> findAllCompOffExcludedPendingReqList(Long companyId); 
	public CompensatoryOff getCompensatoryOff(Long tmsCompensantoryOffId);
}
