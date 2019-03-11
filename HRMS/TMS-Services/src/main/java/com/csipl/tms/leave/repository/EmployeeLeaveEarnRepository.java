package com.csipl.tms.leave.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.tms.model.leave.EmployeeLeaveEarn;

public interface EmployeeLeaveEarnRepository extends CrudRepository<EmployeeLeaveEarn, Long> {
	@Query(" from EmployeeLeaveEarn where companyId=?1")
	public ArrayList<EmployeeLeaveEarn> leaveTypeList(Long companyId);

	 @Modifying
	@Query("UPDATE EmployeeLeaveEarn SET leaveTaken=leaveTaken+?4 WHERE financialYear=?3 AND leaveTypeId=?2 AND employeeId=?1")
	public void updateEmplyeeLeaveEarn(Long employeeId, Long leaveTypeId, String financialYear, Long days);
 }
