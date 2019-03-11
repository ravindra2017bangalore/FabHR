package com.csipl.tms.leave.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.tms.dto.leave.LeaveBalanceDTO;
import com.csipl.tms.dto.leave.LeaveBalanceSummryDTO;
import com.csipl.tms.dto.leave.LeaveEntryDTO;
import com.csipl.tms.dto.leave.TeamLeaveOnCalenderDTO;
import com.csipl.tms.model.leave.TMSLeaveEntry;

public interface EmployeeLeaveService {

	public TMSLeaveEntry saveLeaveEntry(TMSLeaveEntry leaveEntry);
	
	public boolean validateLeaveEntry(LeaveBalanceSummryDTO leaveBalanceSummryDto)throws ParseException, ErrorHandling;
	
 	public List<Object[]> leaveEntryList(Long companyId);
 	public LeaveEntryDTO  getLeaveEntry(Long leaveId);
 	public List<TMSLeaveEntry> getEmployeeLeaveEntry(Long employeeId);
 	public List<TMSLeaveEntry> getEmployeePendingLeaveEntry(Long employeeId);
 	public List<LeaveBalanceDTO> getEmployeeLeaveBalance(Long employeeId);
 	public List<LeaveBalanceSummryDTO> getEmployeeLeaveBalanceSummry(Long employeeId,Long companyId);
    public List<TeamLeaveOnCalenderDTO> getTeamLeaveOnCalender(String employeeId,String currentDate);
 	public BigDecimal appliedLeaveDays(LeaveEntryDTO leaveEntryDto) throws ParseException;
	public List<TMSLeaveEntry> getEmployeeApprovedLeaveEntry(Long employeeId);
	public List<TMSLeaveEntry> getAllEmployeeApprovedLeaveEntry(Long companyId);
	public List<Object[]> getMonthEmployeeLeaveEntry(long companyId,long employeeId, String fromDate, String toDate);
    public List<TMSLeaveEntry> getEmployeeLeaveEntryListByDate(Date date);
    public LeaveEntryDTO leaveCount(Long companyId,Long employeeId);

}
