package com.csipl.tms.leave.repository;

import java.util.List;

import com.csipl.tms.model.leave.LeaveSearchDTO;

public interface EmployeeLeavePaginationRepository {
	public List<Object[]> getPendingEmployeeLeavebyPagination( Long companyId, LeaveSearchDTO leaveSearchDto );
}
