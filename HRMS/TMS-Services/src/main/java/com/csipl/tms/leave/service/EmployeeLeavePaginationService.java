package com.csipl.tms.leave.service;

import java.util.List;


import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.model.leave.LeaveSearchDTO;

public interface EmployeeLeavePaginationService {
	public void getEntityCount(long companyId, EntityCountDTO entityCountDto);
	public void getPendingEntityCount(long companyId, EntityCountDTO entityCountDto);
	public List<Object[]> getPendingEmployeeLeavebyPagination( long companyId, LeaveSearchDTO leaveSearchDto );
}
