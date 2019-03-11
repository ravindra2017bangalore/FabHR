package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.model.employee.Separation;

public interface SeparationService {
	public Separation save(Separation separation);
 	public List<Separation> getSeparationList(Long employeeId,Long companyId); 
	public List<Separation> getAllseparationList(Long companyId); 
	public Long checkSeparationForRequest(Long employeeId); 
 	public Separation getSeparation(Long separationId); 
	public List<Separation> getAllseparationPendingList(Long companyId);
	public SeparationDTO getNoticePeriodCount(Long companyId);
	public SeparationDTO seperationCount(Long companyId);
	public List<Separation> employeeCancelledResignReqList(Long employeeId);
   	public Separation employeePendingResignReq(Long employeeId);
	public void updateRequestStatus(Long separationId, String status, String description);
	public List<Separation> findAllSeparationPendingReqList(Long companyId);
	public List<Separation> findAllSeparationExcludedPendingReqList(Long companyId); 

  }
