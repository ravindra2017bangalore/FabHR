package com.csipl.tms.leave.adaptor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.model.employee.Employee;

import com.csipl.tms.dto.leave.LeaveBalanceDTO;
import com.csipl.tms.dto.leave.LeaveBalanceSummryDTO;

//import com.csipl.hrms.common.model.Company;
//import com.csipl.hrms.common.model.Employee;

import com.csipl.tms.dto.leave.LeaveEntryDTO;

import com.csipl.tms.dto.leave.TeamLeaveOnCalenderDTO;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;

import com.csipl.tms.model.leave.LeaveSearchDTO;
import com.csipl.tms.model.leave.TMSLeaveEntry;
import com.csipl.tms.model.leave.TMSLeaveType;

public class LeaveEntryAdaptor {

	public List<TMSLeaveEntry> uiDtoToDatabaseModelList(List<LeaveEntryDTO> leaveEntryDtoList) {
		List<TMSLeaveEntry> leaveEntryList = new ArrayList<TMSLeaveEntry>();
		for (LeaveEntryDTO leaveEntryDto : leaveEntryDtoList) {
			//leaveEntryList.add(uiDtoToDatabaseModel(leaveEntryDto));
		}
		return leaveEntryList;
	}

	public TMSLeaveEntry uiDtoToDatabaseModel(LeaveBalanceSummryDTO leaveBalanceSummryDto) {
		TMSLeaveEntry leaveEntry = new TMSLeaveEntry();
		TMSLeaveType leaveType = new TMSLeaveType();
		leaveEntry.setApprovalRemark(leaveBalanceSummryDto.getApprovalRemark());
		leaveEntry.setDays(leaveBalanceSummryDto.getDays());

		leaveEntry.setEmployeeRemark(leaveBalanceSummryDto.getEmployeeRemark());
		leaveEntry.setFromDate(leaveBalanceSummryDto.getFromDate());
		leaveEntry.setHalfFullDay(leaveBalanceSummryDto.getHalf_fullDay());
		leaveEntry.setHalfDayFor(leaveBalanceSummryDto.getHalfDayFor());
		//leaveEntry.setIsApproved(leaveBalanceSummryDto.getIsApproved());
		//leaveEntry.setIsApproved();
		leaveEntry.setStatus(leaveBalanceSummryDto.getStatus());
		leaveEntry.setToDate(leaveBalanceSummryDto.getToDate());
		//leaveEntry.setIsRead(leaveBalanceSummryDto.getIsRead());
		// byte isRead = (byte) (leaveEntryDto.getIsRead() ? 1 : 0);
		// leaveEntry.setIsRead(isRead);
		leaveType.setLeaveTypeId(leaveBalanceSummryDto.getLeaveTypeId());
		leaveEntry.setCompanyId(leaveBalanceSummryDto.getCompanyId());
		leaveEntry.setTmsleaveType(leaveType);

		if (leaveBalanceSummryDto.getLeaveId() != null) {
			leaveEntry.setLeaveId(leaveBalanceSummryDto.getLeaveId());
			leaveEntry.setDateCreated(leaveBalanceSummryDto.getDateCreated());
		} else
		leaveEntry.setDateCreated(new Date());
		leaveEntry.setUserIdUpdate(leaveBalanceSummryDto.getUserIdUpdate());
		leaveEntry.setDateUpdate(new Date());
		leaveEntry.setUserId(leaveBalanceSummryDto.getUserId());
		leaveEntry.setEmployeeId(leaveBalanceSummryDto.getEmployeeId());
		leaveEntry.setApprovalId(leaveBalanceSummryDto.getApprovalId());
		leaveEntry.setEmployeeCode(leaveBalanceSummryDto.getEmployeeCode());
		leaveEntry.setHalfDayFor(leaveBalanceSummryDto.getHalfDayFor());
		if (leaveEntry.getApprovalId() != null)
			leaveEntry.setActionableDate(new Date());
		StringBuilder sb = new StringBuilder();
for (Employee employee : leaveBalanceSummryDto.getNotifyEmployeeList()) {
	sb.append(employee.getEmployeeId().toString()).append(",");
}
System.out.println("sb..."+sb);
if(sb.length()>0)
leaveEntry.setNotifyEmployee(sb.substring(0, sb.length() - 1).toString());
System.out.println("---------------"+leaveEntry.getNotifyEmployee());
		return leaveEntry;
	}

	public List<LeaveEntryDTO> databaseModelToUiDtoList(List<TMSLeaveEntry> leaveEntryList) {
		List<LeaveEntryDTO> leaveEntryDtoList = new ArrayList<LeaveEntryDTO>();

		for (TMSLeaveEntry leaveEntry : leaveEntryList) {
			leaveEntryDtoList.add(databaseModelToUiDto(leaveEntry, null, null,null));
		}
		return leaveEntryDtoList;
	}

	public LeaveEntryDTO databaseModelToUiDto(TMSLeaveEntry leaveEntry, Employee employeeEmp,
			Employee approvalEmp,List<EmployeeDTO> employeeDtoList) {
		LeaveEntryDTO leaveEntryDto = new LeaveEntryDTO();

		leaveEntryDto.setLeaveId(leaveEntry.getLeaveId());
		// leaveEntryDto.setApprovalId(leaveEntry.getApprovalEmployee().getEmployeeId());
		leaveEntryDto.setApprovalRemark(leaveEntry.getApprovalRemark());
		leaveEntryDto.setDays(leaveEntry.getDays());
		leaveEntryDto.setEmployeeRemark(leaveEntry.getEmployeeRemark());
		leaveEntryDto.setFromDate(leaveEntry.getFromDate());
		
		leaveEntryDto.setHalfDayFor(leaveEntry.getHalfDayFor());
		// leaveEntryDto.setIsApproved(leaveEntry.getIsApproved());
		leaveEntryDto.setIsRead(leaveEntry.getIsRead());
		leaveEntryDto.setStatus(leaveEntry.getStatus());
		/*if (leaveEntryDto.getStatus().equals("P")) {
			leaveEntryDto.setStatusValue("Pending");
		} else if (leaveEntryDto.getStatus().equals("R")) {
			leaveEntryDto.setStatusValue("Rejected");
		} else if (leaveEntryDto.getStatus().equals("A")) {
			leaveEntryDto.setStatusValue("Approved");
		}
		else if (leaveEntryDto.getStatus().equals("C")) {
			leaveEntryDto.setStatusValue("Canceled");
		}*/
		if (leaveEntry.getHalfDayFor() != null) {

			if (leaveEntry.getHalfDayFor().equals("1"))
				leaveEntryDto.setHalfDayForValue("First Half");
			else if (leaveEntry.getHalfDayFor().equals("2"))
				leaveEntryDto.setHalfDayForValue("Second Half");
		}
		leaveEntryDto.setLeaveTypeId(leaveEntry.getTmsleaveType().getLeaveTypeId());
		leaveEntryDto.setLeaveType(leaveEntry.getTmsleaveType().getTmsleaveTypeMaster().getLeaveName());
		if (leaveEntryDto.getStatus().equals(StatusMessage.PENDING_CODE)) {
			leaveEntryDto.setStatusValue(StatusMessage.PENDING_VALUE);
		} else if (leaveEntryDto.getStatus().equals(StatusMessage.REJECTED_CODE)) {
			leaveEntryDto.setStatusValue(StatusMessage.REJECTED_VALUE);
		} else if (leaveEntryDto.getStatus().equals(StatusMessage.APPROVED_CODE)) {
			leaveEntryDto.setStatusValue(StatusMessage.APPROVED_VALUE);
		}else if (leaveEntryDto.getStatus().equals(StatusMessage.CANCEL_CODE)) {
			leaveEntryDto.setStatusValue(StatusMessage.CANCEL_VALUE);
		}
		leaveEntryDto.setCompanyId(leaveEntry.getCompanyId());
		leaveEntryDto.setToDate(leaveEntry.getToDate());
		leaveEntryDto.setDateCreated(leaveEntry.getDateCreated());
		leaveEntryDto.setUserId(leaveEntry.getUserId());
		leaveEntryDto.setDateUpdate(leaveEntry.getDateUpdate());
		leaveEntryDto.setActionableDate(leaveEntry.getActionableDate());
		leaveEntryDto.setEmployeeId(leaveEntry.getEmployeeId());
		leaveEntryDto.setCancleRemark(leaveEntry.getCancleRemark());
		leaveEntryDto.setHalf_fullDay(leaveEntry.getHalfFullDay());
		leaveEntryDto.setNotifyEmployee(leaveEntry.getNotifyEmployee());
		leaveEntryDto.setNotifyEmployeeList(employeeDtoList);
		/*
		 * if (employeeDto != null) {
		 * leaveEntryDto.setEmployeeName(employeeDto.getFirstName() + " " +
		 * employeeDto.getLastName());
		 * leaveEntryDto.setDepartment(employeeDto.getDepartmentName());
		 * leaveEntryDto.setDesignation(employeeDto.getDesignationName());
		 * leaveEntryDto.setEmployeeCode(employeeDto.getEmployeeCode());
		 */

		if (employeeEmp != null) {
			leaveEntryDto.setEmployeeName(employeeEmp.getFirstName() + " " + employeeEmp.getLastName());
			leaveEntryDto.setDepartment(employeeEmp.getDepartment().getDepartmentName());
			leaveEntryDto.setDesignation(employeeEmp.getDesignation().getDesignationName());
			leaveEntryDto.setEmployeeCode(employeeEmp.getEmployeeCode());

		}
		if (approvalEmp != null) {
			leaveEntryDto.setApprovalId(approvalEmp.getEmployeeId());
			leaveEntryDto.setApprovalEmployeeName(approvalEmp.getFirstName() + " " + approvalEmp.getLastName());
			leaveEntryDto.setApprovalEmployeeDepartment(approvalEmp.getDepartment().getDepartmentName());
			leaveEntryDto.setApprovalEmployeeDesignation(approvalEmp.getDesignation().getDesignationName());
			leaveEntryDto.setApprovalEmployeeCode(approvalEmp.getEmployeeCode());
		}

		return leaveEntryDto;
	}

	public List<LeaveBalanceDTO> objectArrayToUiDtoList(List<Object[]> leaveBalanceObjectDtoList,
			List<Object[]> employeeDetailsList, Long employeeId) {
		List<LeaveBalanceDTO> leaveBalanceDtoList = new ArrayList<LeaveBalanceDTO>();

		Long departmentId = null, desigantionId = null, weekOffPatternId = null;
		Date doj = null;
		String patternDays = null;

		for (Object[] employeeDetails : employeeDetailsList) {
			departmentId = employeeDetails[0] != null ? Long.parseLong(employeeDetails[0].toString()) : null;
			desigantionId = employeeDetails[1] != null ? Long.parseLong(employeeDetails[1].toString()) : null;
			doj = employeeDetails[2] != null ? (Date) (employeeDetails[2]) : null;
			weekOffPatternId = employeeDetails[3] != null ? Long.parseLong(employeeDetails[3].toString()) : null;
			patternDays = employeeDetails[4] != null ? (String) employeeDetails[4] : null;
		}
		System.out.println("LeaveType        TOTAL TAKEN BALANCE");

		for (Object[] leaveBalanceObj : leaveBalanceObjectDtoList) {
			LeaveBalanceDTO leaveBalanceDto = new LeaveBalanceDTO();
			Long leaveTypeHdId = leaveBalanceObj[0] != null ? Long.parseLong(leaveBalanceObj[0].toString()) : null;
			String leaveRuleType = leaveBalanceObj[1] != null ? (String) leaveBalanceObj[1] : null;
			String leaveType = leaveBalanceObj[2] != null ? (String) leaveBalanceObj[2] : null;
			Long yearlyLimit = leaveBalanceObj[3] != null ? Long.parseLong(leaveBalanceObj[3].toString()) : null;
			BigDecimal index = leaveBalanceObj[4] != null ? (new BigDecimal(leaveBalanceObj[4].toString())) : null;

			Long indexDays = leaveBalanceObj[5] != null ? Long.parseLong(leaveBalanceObj[5].toString()) : null;
			Long maxLeaveInMonth = leaveBalanceObj[6] != null ? Long.parseLong(leaveBalanceObj[6].toString()) : null;
			Long leaveFrequencyInMonth = leaveBalanceObj[7] != null ? Long.parseLong(leaveBalanceObj[7].toString())
					: null;
			// Long sumdays = leaveBalanceObj[8] != null ?
			// Long.parseLong(leaveBalanceObj[8].toString()) : 0;
			BigDecimal sumdays = leaveBalanceObj[8] != null ? (new BigDecimal(leaveBalanceObj[8].toString()))
					: new BigDecimal("0.0");

			Date effectiveStartDate = leaveBalanceObj[9] != null ? (Date) (leaveBalanceObj[9]) : null;
			Date effectiveEndDate = leaveBalanceObj[10] != null ? (Date) (leaveBalanceObj[10]) : null;
			Long leaveTypeId = leaveBalanceObj[11] != null ? Long.parseLong(leaveBalanceObj[11].toString()) : null;

			leaveBalanceDto.setLeaveTypeId(leaveTypeId);
			leaveBalanceDto.setEmployeeId(employeeId);
			leaveBalanceDto.setLeaveRuleType(leaveRuleType);
			leaveBalanceDto.setMaxLeaveInMonth(maxLeaveInMonth);
			leaveBalanceDto.setLeaveFrequencyInMonth(leaveFrequencyInMonth);
			leaveBalanceDto.setLeaveType(leaveType);
			leaveBalanceDto.setEffectiveStartDate(effectiveStartDate);
			leaveBalanceDto.setEffectiveEndDate(effectiveEndDate);
			leaveBalanceDto.setLeaveTaken(sumdays);
			leaveBalanceDto.setWeekOffPatternId(weekOffPatternId);
			leaveBalanceDto.setPatternDays(patternDays);
			leaveBalanceDto.setLeaveTypeHdId(leaveTypeHdId);

			if (doj.before(effectiveStartDate) || doj.equals(effectiveStartDate)) {
				if (leaveRuleType.equals("LC")) {
					leaveBalanceDto.setYearlyLimit(yearlyLimit);

					BigDecimal bigYearlyLimit = new BigDecimal(yearlyLimit);

					leaveBalanceDto.setLeaveBalance(bigYearlyLimit.subtract(sumdays));
				} else {
					Long days = daysDifference(new Date(), effectiveStartDate);
					long new1 = days / indexDays;
					Long totalLeaveYearly = calculateDays(new1, index);

					BigDecimal bigTotalLeaveYearly = new BigDecimal(totalLeaveYearly);
					// long balance = bigTotalLeaveYearly.subtract(sumdays);
					leaveBalanceDto.setYearlyLimit(totalLeaveYearly);
					leaveBalanceDto.setLeaveBalance(bigTotalLeaveYearly.subtract(sumdays));
				}
			} else {
				if (leaveRuleType.equals("LC")) {
					Long days = daysDifference(effectiveEndDate, doj);
					Long yearlyLeave = (long) Math.round(yearlyLimit.doubleValue() * days.doubleValue() / 365);
					BigDecimal bigYearlyLeave = new BigDecimal(yearlyLeave);
					leaveBalanceDto.setYearlyLimit(yearlyLeave);
					leaveBalanceDto.setLeaveBalance(bigYearlyLeave.subtract(sumdays));
				} else {
					Long days = daysDifference(new Date(), doj);
					long new1 = days / indexDays;
					Long totalLeaveYearly = calculateDays(new1, index);
					BigDecimal bigTotalLeaveYearly = new BigDecimal(totalLeaveYearly);
					// long balance = totalLeaveYearly - sumdays;
					leaveBalanceDto.setYearlyLimit(totalLeaveYearly);
					leaveBalanceDto.setLeaveBalance(bigTotalLeaveYearly.subtract(sumdays));
				}
			}
			System.out.println(leaveBalanceDto.getLeaveType() + "       " + leaveBalanceDto.getYearlyLimit()
					+ "        " + leaveBalanceDto.getLeaveTaken() + "    " + leaveBalanceDto.getLeaveBalance());
			leaveBalanceDtoList.add(leaveBalanceDto);
		}
		return leaveBalanceDtoList;
	}

	public long calculateDays(long new1, BigDecimal index) {
		BigDecimal itemCost = BigDecimal.ZERO;
		BigDecimal totalCost = BigDecimal.ZERO;
		itemCost = index.multiply(new BigDecimal(new1));
		totalCost = totalCost.add(itemCost);
		return totalCost.longValue();
	}

	public long daysDifference(Date fromDate, Date toDate) {
		long diff = fromDate.getTime() - toDate.getTime();
		Long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return days;
	}

	public LeaveBalanceDTO objectArrayToUiDto(List<Object[]> leaveBalanceObjectDtoList, Long employeeId) {
		System.out.println("LeaveType        TOTAL TAKEN BALANCE");
		LeaveBalanceDTO leaveBalanceDto = new LeaveBalanceDTO();

		for (Object[] leaveBalanceObj : leaveBalanceObjectDtoList) {
			Long leaveTypeHdId = leaveBalanceObj[0] != null ? Long.parseLong(leaveBalanceObj[0].toString()) : null;
			String leaveRuleType = leaveBalanceObj[1] != null ? (String) leaveBalanceObj[1] : null;
			String leaveType = leaveBalanceObj[2] != null ? (String) leaveBalanceObj[2] : null;
			Long yearlyLimit = leaveBalanceObj[3] != null ? Long.parseLong(leaveBalanceObj[3].toString()) : null;
			BigDecimal index = leaveBalanceObj[4] != null ? (new BigDecimal(leaveBalanceObj[4].toString())) : null;
			Long indexDays = leaveBalanceObj[5] != null ? Long.parseLong(leaveBalanceObj[5].toString()) : null;
			Long maxLeaveInMonth = leaveBalanceObj[6] != null ? Long.parseLong(leaveBalanceObj[6].toString()) : null;
			Long leaveFrequencyInMonth = leaveBalanceObj[7] != null ? Long.parseLong(leaveBalanceObj[7].toString())
					: null;
			BigDecimal sumdays = leaveBalanceObj[8] != null ? (new BigDecimal(leaveBalanceObj[8].toString()))
					: new BigDecimal("0.0");

			Date effectiveStartDate = leaveBalanceObj[9] != null ? (Date) (leaveBalanceObj[9]) : null;
			Date effectiveEndDate = leaveBalanceObj[10] != null ? (Date) (leaveBalanceObj[10]) : null;

			Date doj = leaveBalanceObj[11] != null ? (Date) (leaveBalanceObj[11]) : null;
			Long departmentId = leaveBalanceObj[12] != null ? Long.parseLong(leaveBalanceObj[12].toString()) : null;
			Long weekOffPatternId = leaveBalanceObj[13] != null ? Long.parseLong(leaveBalanceObj[13].toString()) : null;
			String patternDays = leaveBalanceObj[14] != null ? (String) leaveBalanceObj[14] : null;

			// Boolean isWeekOffAsPl = leaveBalanceObj[15] != null ? (Boolean)
			// leaveBalanceObj[15] : null;

			// String weekOffAsPlCount = leaveBalanceObj[16] != null ? (String)
			// leaveBalanceObj[16] : null;

			String leaveInProbation = leaveBalanceObj[17] != null ? (String) leaveBalanceObj[17] : null;

			Long probationDays = leaveBalanceObj[18] != null ? Long.parseLong(leaveBalanceObj[18].toString()) : null;

			leaveBalanceDto.setLeaveTypeHdId(leaveTypeHdId);
			leaveBalanceDto.setEmployeeId(employeeId);
			leaveBalanceDto.setLeaveRuleType(leaveRuleType);
			leaveBalanceDto.setMaxLeaveInMonth(maxLeaveInMonth);
			leaveBalanceDto.setLeaveFrequencyInMonth(leaveFrequencyInMonth);
			leaveBalanceDto.setLeaveType(leaveType);
			leaveBalanceDto.setEffectiveStartDate(effectiveStartDate);
			leaveBalanceDto.setEffectiveEndDate(effectiveEndDate);
			leaveBalanceDto.setLeaveTaken(sumdays);
			leaveBalanceDto.setWeekOffPatternId(weekOffPatternId);
			leaveBalanceDto.setPatternDays(patternDays);
			leaveBalanceDto.setIsLeaveInProbation(leaveInProbation);
			leaveBalanceDto.setProbationDays(probationDays);
			leaveBalanceDto.setDateOfJoining(doj);
            System.out.println("effective date....."+effectiveStartDate);
			if (doj.before(effectiveStartDate) || doj.equals(effectiveStartDate)) {
				if (leaveRuleType.equals("LC")) {
					leaveBalanceDto.setYearlyLimit(yearlyLimit);
					BigDecimal bigYearlyLimit = new BigDecimal(yearlyLimit);
					leaveBalanceDto.setLeaveBalance(bigYearlyLimit.subtract(sumdays));
				} else {
					Long days = daysDifference(new Date(), effectiveStartDate);
					long new1 = days / indexDays;
					Long totalLeaveYearly = calculateDays(new1, index);
					BigDecimal bigTotalLeaveYearly = new BigDecimal(totalLeaveYearly);
					// long balance = bigTotalLeaveYearly.subtract(sumdays);
					leaveBalanceDto.setYearlyLimit(totalLeaveYearly);
					leaveBalanceDto.setLeaveBalance(bigTotalLeaveYearly.subtract(sumdays));
				}
			} else {
				if (leaveRuleType.equals("LC")) {
					Long days = daysDifference(effectiveEndDate, doj);
					Long yearlyLeave = (long) Math.round(yearlyLimit.doubleValue() * days.doubleValue() / 365);
					leaveBalanceDto.setYearlyLimit(yearlyLeave);
					BigDecimal bigYearlyLeave = new BigDecimal(yearlyLeave);

					leaveBalanceDto.setLeaveBalance(bigYearlyLeave.subtract(sumdays));
				} else {
					Long days = daysDifference(new Date(), doj);
					long new1 = days / indexDays;
					Long totalLeaveYearly = calculateDays(new1, index);
					BigDecimal bigTotalLeaveYearly = new BigDecimal(totalLeaveYearly);

					// long balance = totalLeaveYearly - sumdays;
					leaveBalanceDto.setYearlyLimit(totalLeaveYearly);
					leaveBalanceDto.setLeaveBalance(bigTotalLeaveYearly.subtract(sumdays));
				}
			}
			System.out.println(leaveBalanceDto.getLeaveType() + "       " + leaveBalanceDto.getYearlyLimit()
					+ "        " + leaveBalanceDto.getLeaveTaken() + "    " + leaveBalanceDto.getLeaveBalance());
		}
		return leaveBalanceDto;
	}

	public BigDecimal objectArrayToLongDays(List<Object[]> daysList) {
		BigDecimal days = new BigDecimal("0.0");

		for (Object[] requestedDays : daysList) {

			// days = requestedDays[1] != null ? Long.parseLong(requestedDays[1].toString())
			// : 0l;
			days = requestedDays[1] != null ? (new BigDecimal(requestedDays[1].toString())) : new BigDecimal("0.0");

		}
		return days;
	}

	public LeaveBalanceDTO weekOffPattenObjToUiDto(List<Object[]> weekOffPattenList) {

		LeaveBalanceDTO leaveBalanceDto = new LeaveBalanceDTO();

		for (Object[] leaveBalanceObj : weekOffPattenList) {
			Long patternId = leaveBalanceObj[0] != null ? Long.parseLong(leaveBalanceObj[0].toString()) : null;
			String patternDays = leaveBalanceObj[1] != null ? (String) leaveBalanceObj[1] : null;
			leaveBalanceDto.setWeekOffPatternId(patternId);
			leaveBalanceDto.setPatternDays(patternDays);
		}
		return leaveBalanceDto;

	}
	
	public List<LeaveBalanceSummryDTO> leaveBalanceSummryObjToUiDto(List<Object[]> leaveBalanceSummryList) {


//leaveTypeId,leavePeriodId,leaveTypeMasterId,leaveMode,leaveName,yearlyLimit,carryForwordLeave,totalleave,consumed
//balanceleave,indexDays,indexDays,maxLeaveInMonth,leaveFrequencyInMonth

		List<LeaveBalanceSummryDTO> LeaveBalanceSummryList = new ArrayList<LeaveBalanceSummryDTO>();
		for (Object[] leaveBalanceObj : leaveBalanceSummryList) {
			LeaveBalanceSummryDTO leaveBalanceSummryDto = new LeaveBalanceSummryDTO();
			Long leaveTypeId = leaveBalanceObj[0] != null ? Long.parseLong(leaveBalanceObj[0].toString()) : null;
			Long leavePeriodId = leaveBalanceObj[1] != null ? Long.parseLong(leaveBalanceObj[1].toString()) : null;
			Long leaveTypeMasterId = leaveBalanceObj[2] != null ? Long.parseLong(leaveBalanceObj[2].toString()) : null;
			String leaveMode= leaveBalanceObj[3] != null ? (String)leaveBalanceObj[3] : null;
			String leaveName= leaveBalanceObj[4] != null ? (String)leaveBalanceObj[4] : null;
			Long yearlyLimit = leaveBalanceObj[5] != null ? Long.parseLong(leaveBalanceObj[5].toString()) : null;
			Long carryForwordLeave = leaveBalanceObj[6] != null ? Long.parseLong(leaveBalanceObj[6].toString()) : null;
			Long totalleave = leaveBalanceObj[7] != null ? Long.parseLong(leaveBalanceObj[7].toString()) : null;
			
			BigDecimal consumed = leaveBalanceObj[8]!=null?(new BigDecimal(leaveBalanceObj[8].toString())):null;
			BigDecimal balanceleave = leaveBalanceObj[9]!=null?(new BigDecimal(leaveBalanceObj[9].toString())):null;

		//	Long consumed = leaveBalanceObj[8] != null ? getLong(leaveBalanceObj[8]) : null;
			//Long balanceleave=leaveBalanceObj[9]!=null?(getLong(leaveBalanceObj[9])):null;
			
			Long indexDays = leaveBalanceObj[10] != null ? Long.parseLong(leaveBalanceObj[10].toString()) : null;
			Long maxLeaveInMonth = leaveBalanceObj[11] != null ? Long.parseLong(leaveBalanceObj[11].toString()) : null;
			Long leaveFrequencyInMonth = leaveBalanceObj[12] != null ? Long.parseLong(leaveBalanceObj[12].toString()) : null;
			String isLeaveInProbation=leaveBalanceObj[13]!=null?(getString(leaveBalanceObj[13])):null;
			Long carryForwordLimit = leaveBalanceObj[14] != null ? Long.parseLong(leaveBalanceObj[14].toString()) : null;
			String nature=leaveBalanceObj[15]!=null?(getString(leaveBalanceObj[15])):null;
			Long notice = leaveBalanceObj[16] != null ? Long.parseLong(leaveBalanceObj[16].toString()) : null;
			Long weekoffAsPlCount = leaveBalanceObj[17] != null ? Long.parseLong(leaveBalanceObj[17].toString()) : null;
			
			String leavePeriodName=leaveBalanceObj[18]!=null?(getString(leaveBalanceObj[18])):null;
			Date leavePeriodStartDate = leaveBalanceObj[19] != null ? (Date) (leaveBalanceObj[19]) : null;
			Date leavePeriodEndDate = leaveBalanceObj[20] != null ? (Date) (leaveBalanceObj[20]) : null;
			Date employeeJoiningDate = leaveBalanceObj[21] != null ? (Date) (leaveBalanceObj[21]) : null;
		//	String leaveMode=leaveBalanceObj[22]!=null?(getString(leaveBalanceObj[22])):null;
            
			leaveBalanceSummryDto.setLeaveTypeId(leaveTypeId);
			leaveBalanceSummryDto.setTmsleavePeriodId(leavePeriodId);
			leaveBalanceSummryDto.setTmsleaveTypeMasterId(leaveTypeMasterId);
			leaveBalanceSummryDto.setLeaveMode(leaveMode);
			leaveBalanceSummryDto.setLeaveName(leaveName);
			leaveBalanceSummryDto.setYearlyLimit(yearlyLimit);
			leaveBalanceSummryDto.setCarryForwordLeave(carryForwordLeave);
			
			
			if(employeeJoiningDate.after(leavePeriodStartDate) ) {
					
				long timeDiff = Math.abs(leavePeriodEndDate.getTime() - employeeJoiningDate.getTime());
				double empJoinedDays = Math.ceil(timeDiff / (1000 * 3600 * 24)) + 1;
				
				long leavePeriodTimeDiff = Math.abs(leavePeriodEndDate.getTime() - leavePeriodStartDate.getTime());
				double leavePeriodTimeDiffDays = Math.ceil(leavePeriodTimeDiff / (1000 * 3600 * 24)) + 1;
				
				totalleave=(new BigDecimal(empJoinedDays).multiply(new BigDecimal(totalleave)).divide(new BigDecimal(leavePeriodTimeDiffDays), 2,RoundingMode.CEILING)).longValue();
			
				if(leaveMode.equals("IN")) {
					long timeDiffIndex = Math.abs(new Date().getTime() - employeeJoiningDate.getTime());
					double empJoinedIndexDays = Math.ceil(timeDiffIndex / (1000 * 3600 * 24)) + 1;
					
					BigDecimal indexdays= (new BigDecimal(empJoinedIndexDays)).divide(new BigDecimal(indexDays), 2,RoundingMode.CEILING);
					
					if(indexdays.compareTo(new BigDecimal(totalleave))<0) {
						totalleave=indexdays.longValue();
						
					}
				
				
				}
				
				
			}
			else{
	                   if(leaveMode.equals("IN")) {
	                		long timeDiffIndex = Math.abs(new Date().getTime() - leavePeriodStartDate.getTime());
	    					double empJoinedIndexDays = Math.ceil(timeDiffIndex / (1000 * 3600 * 24)) + 1;
	    					
	    					BigDecimal indexdays= (new BigDecimal(empJoinedIndexDays)).divide(new BigDecimal(indexDays), 2,RoundingMode.CEILING);
	    				
	    					if(indexdays.compareTo(new BigDecimal(totalleave))<0) {
	    						totalleave=indexdays.longValue();
	    						
	    					}
	    				
				}
			}
			balanceleave=new BigDecimal(totalleave).subtract(consumed);
			leaveBalanceSummryDto.setTotalLeave(totalleave);
			leaveBalanceSummryDto.setLeaveConsumedCount(consumed);
			leaveBalanceSummryDto.setLeaveBalancedCount(balanceleave);
			leaveBalanceSummryDto.setIndexDays(indexDays);
			leaveBalanceSummryDto.setMaxLeaveInMonth(maxLeaveInMonth);
			leaveBalanceSummryDto.setLeaveFrequencyInMonth(leaveFrequencyInMonth);
			leaveBalanceSummryDto.setIsLeaveInProbation(isLeaveInProbation);
			leaveBalanceSummryDto.setCarryForwardLimit(carryForwordLimit);
			leaveBalanceSummryDto.setNature(nature);
			leaveBalanceSummryDto.setNotice(notice);
			leaveBalanceSummryDto.setWeekOffAsPLCount(weekoffAsPlCount);
			LeaveBalanceSummryList.add(leaveBalanceSummryDto);
		}
		return LeaveBalanceSummryList;
		
	}

     public List<TeamLeaveOnCalenderDTO> teamLeaveOnCalenderObjToUiDto(List<Object[]> teamLeaveOnCalenderList) {
				List<TeamLeaveOnCalenderDTO> TeamLeaveOnCalenderDTOList = new ArrayList<TeamLeaveOnCalenderDTO>();
				for (Object[] leaveObj : teamLeaveOnCalenderList) {
					TeamLeaveOnCalenderDTO teamLeaveOnCalenderDTO = new TeamLeaveOnCalenderDTO();
		 			BigInteger employeeId=leaveObj[0]!=null?(new BigInteger(leaveObj[0].toString())):null;
				    String employeeCode = leaveObj[1] != null ? (String)leaveObj[1] : null;
					String employeeName= leaveObj[2] != null ? (String)leaveObj[2] : null;
					String status= leaveObj[3] != null ? (String)leaveObj[3] : null;
					Date fromDate = leaveObj[4] != null ? (Date)leaveObj[4] : null;
					Date toDate = leaveObj[5] != null ? (Date)leaveObj[5] : null;
					BigInteger leaves = leaveObj[6]!=null?(new BigInteger(leaveObj[6].toString())):null;
					teamLeaveOnCalenderDTO.setEmployeeId(employeeId.toString());
					teamLeaveOnCalenderDTO.setEmployeeCode(employeeCode);
					teamLeaveOnCalenderDTO.setEmployeeName(employeeName);
					teamLeaveOnCalenderDTO.setStatus(status);
					teamLeaveOnCalenderDTO.setFromDate(fromDate.toString());
					teamLeaveOnCalenderDTO.setToDate(toDate.toString());
					teamLeaveOnCalenderDTO.setLeaves(leaves.toString());
					TeamLeaveOnCalenderDTOList.add(teamLeaveOnCalenderDTO);
				}
				return TeamLeaveOnCalenderDTOList;
				
			}

	public static String getString( Object value ) { 
		String ret = null ;
		  if( value != null ) { 
			  ret = String.valueOf( value );
			
		  }
		  return ret;
	}
	public static Long getLong( Object value ) { 
		Long ret = null;
		  if( value != null ) { 
			  String stringToConvert = String.valueOf( value );
			  ret =  Long.parseLong( stringToConvert );

		  }
		  return ret;
	}


	public List<LeaveEntryDTO> databaseModelObjToUiDtoList(List<Object[]> leaveEntryObjList) {
		List<LeaveEntryDTO> leaveEntryDtoList = new ArrayList<LeaveEntryDTO>();
		for (Object[] leaveEntryObj : leaveEntryObjList) {

			LeaveEntryDTO leaveEntryDto = new LeaveEntryDTO();
			Long companyId = leaveEntryObj[1] != null ? Long.parseLong(leaveEntryObj[1].toString()) : null;
			Long employeeId = leaveEntryObj[2] != null ? Long.parseLong(leaveEntryObj[2].toString()) : null;
			String half_fullDay = leaveEntryObj[6] != null ? (String) leaveEntryObj[6] : null;
			String status = leaveEntryObj[7] != null ? (String) leaveEntryObj[7] : null;
			Date fromDate = leaveEntryObj[8] != null ? (Date) (leaveEntryObj[8]) : null;
			Date toDate = leaveEntryObj[9] != null ? (Date) (leaveEntryObj[9]) : null;
			// Long day = leaveEntryObj[10] != null ?
			// Long.parseLong(leaveEntryObj[10].toString()) : null;
			BigDecimal day = leaveEntryObj[10] != null ? (new BigDecimal(leaveEntryObj[10].toString()))
					: new BigDecimal("0.0");

			leaveEntryDto.setCompanyId(companyId);
			leaveEntryDto.setEmployeeId(employeeId);
			leaveEntryDto.setHalf_fullDay(half_fullDay);
			leaveEntryDto.setStatus(status);
			leaveEntryDto.setFromDate(fromDate);
			leaveEntryDto.setToDate(toDate);
			leaveEntryDto.setDays(day);
			leaveEntryDtoList.add(leaveEntryDto);
		}

		return leaveEntryDtoList;
	}

	public List<LeaveEntryDTO> databaseObjToUiDtoList(List<Object[]> objLeaveEntryList) {
		List<LeaveEntryDTO> leaveEntryDtoList = new ArrayList<LeaveEntryDTO>();
		for (Object[] leaveEntryObj : objLeaveEntryList) {
			LeaveEntryDTO leaveEntryDto = new LeaveEntryDTO();
			String firstName = leaveEntryObj[0] != null ? (String) leaveEntryObj[0] : null;
			String lastName = leaveEntryObj[1] != null ? (String) leaveEntryObj[1] : null;
			String departmentName = leaveEntryObj[2] != null ? (String) leaveEntryObj[2] : null;
			String designationName = leaveEntryObj[3] != null ? (String) leaveEntryObj[3] : null;
			String employeeCode = leaveEntryObj[4] != null ? (String) leaveEntryObj[4] : null;
			Long leaveId = leaveEntryObj[5] != null ? Long.parseLong(leaveEntryObj[5].toString()) : null;
			String approvalRemark = leaveEntryObj[6] != null ? (String) leaveEntryObj[6] : null;
			BigDecimal days = leaveEntryObj[7] != null ? (new BigDecimal(leaveEntryObj[7].toString()))
					: new BigDecimal("0.0");
			String employeeRemark = leaveEntryObj[8] != null ? (String) leaveEntryObj[8] : null;
			Date fromDate = leaveEntryObj[9] != null ? (Date) (leaveEntryObj[9]) : null;
			String halfFull_day = leaveEntryObj[10] != null ? (String) leaveEntryObj[10] : null;
			String halfDayFor = leaveEntryObj[11] != null ? (String) leaveEntryObj[11] : null;
			Boolean isRead = leaveEntryObj[12] != null ? (Boolean) leaveEntryObj[12] : null;
			String status = leaveEntryObj[13] != null ? (String) leaveEntryObj[13] : null;
			Long leaveTypeId = leaveEntryObj[14] != null ? Long.parseLong(leaveEntryObj[14].toString()) : null;
			String leaveType = leaveEntryObj[15] != null ? (String) leaveEntryObj[15] : null;
			Long companyId = leaveEntryObj[16] != null ? Long.parseLong(leaveEntryObj[16].toString()) : null;
			Date toDate = leaveEntryObj[17] != null ? (Date) (leaveEntryObj[17]) : null;
			Date dateCreated = leaveEntryObj[18] != null ? (Date) (leaveEntryObj[18]) : null;
			Long userId = leaveEntryObj[19] != null ? Long.parseLong(leaveEntryObj[19].toString()) : null;
			Date dateUpdate = leaveEntryObj[20] != null ? (Date) (leaveEntryObj[20]) : null;
			Date actionDate = leaveEntryObj[21] != null ? (Date) (leaveEntryObj[21]) : null;
			Long employeeId = leaveEntryObj[22] != null ? Long.parseLong(leaveEntryObj[22].toString()) : null;
			leaveEntryDto.setEmployeeName(firstName + " " + lastName);
			leaveEntryDto.setDepartment(departmentName);
			leaveEntryDto.setDesignation(designationName);
			leaveEntryDto.setEmployeeCode(employeeCode);
			leaveEntryDto.setLeaveId(leaveId);
			leaveEntryDto.setApprovalRemark(approvalRemark);
			leaveEntryDto.setDays(days);
			leaveEntryDto.setEmployeeRemark(employeeRemark);
			leaveEntryDto.setFromDate(fromDate);
			leaveEntryDto.setHalf_fullDay(halfFull_day);
			leaveEntryDto.setHalfDayFor(halfDayFor);
			if (leaveEntryDto.getHalfDayFor() != null) {

				if (leaveEntryDto.getHalfDayFor().equals("1"))
					leaveEntryDto.setHalfDayForValue("First Half");
				else if (leaveEntryDto.getHalfDayFor().equals("2"))
					leaveEntryDto.setHalfDayForValue("Second Half");
			}

			byte isReadByte = (byte) (isRead ? 1 : 0);
			leaveEntryDto.setIsRead(isReadByte);
			leaveEntryDto.setStatus(status);
			if (leaveEntryDto.getStatus().equals(StatusMessage.PENDING_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.PENDING_VALUE);
			} else if (leaveEntryDto.getStatus().equals(StatusMessage.REJECTED_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.REJECTED_VALUE);
			} else if (leaveEntryDto.getStatus().equals(StatusMessage.APPROVED_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.APPROVED_VALUE);
			}else if (leaveEntryDto.getStatus().equals(StatusMessage.CANCEL_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.CANCEL_VALUE);
			}
			leaveEntryDto.setLeaveTypeId(leaveTypeId);
			leaveEntryDto.setLeaveType(leaveType);
			leaveEntryDto.setCompanyId(companyId);
			leaveEntryDto.setToDate(toDate);
			leaveEntryDto.setDateCreated(dateCreated);
			leaveEntryDto.setUserId(userId);
			leaveEntryDto.setDateUpdate(dateUpdate);
			leaveEntryDto.setActionableDate(actionDate);
			leaveEntryDto.setEmployeeId(employeeId);
			leaveEntryDtoList.add(leaveEntryDto);
		}

		return leaveEntryDtoList;
	}
	
	public List<LeaveEntryDTO> modeltoDTOList(List<Object[]> objLeaveEntryList,LeaveSearchDTO leavesearchDto) {
		List<LeaveEntryDTO> leaveEntryDtoList = new ArrayList<LeaveEntryDTO>();
		for (Object[] leaveEntryObj : objLeaveEntryList) {
			LeaveEntryDTO leaveEntryDto = new LeaveEntryDTO();
			Long leaveId = leaveEntryObj[0] != null ? Long.parseLong(leaveEntryObj[0].toString()) : null;
			//Long leaveTypeId = leaveEntryObj[1] != null ? Long.parseLong(leaveEntryObj[1].toString()) : null;
			Long employeeId = leaveEntryObj[1] != null ? Long.parseLong(leaveEntryObj[1].toString()) : null;
			Long approvalId = leaveEntryObj[2] != null ? Long.parseLong(leaveEntryObj[2].toString()) : null;
			Date dateCreated = leaveEntryObj[3] != null ? (Date) (leaveEntryObj[3]) : null;
			BigDecimal days = leaveEntryObj[4] != null ? (new BigDecimal(leaveEntryObj[4].toString()))
					: new BigDecimal("0.0");
			String status = leaveEntryObj[5] != null ? (String) leaveEntryObj[5] : null;
			String designationName = leaveEntryObj[6] != null ? (String) leaveEntryObj[6] : null;
			String firstName = leaveEntryObj[7] != null ? (String) leaveEntryObj[7] : null;
			String lastName = leaveEntryObj[8] != null ? (String) leaveEntryObj[8] : null;
		
			String leaveName = leaveEntryObj[9] != null ? (String) leaveEntryObj[9] : null;
			String employeeRemark = leaveEntryObj[10] != null ? (String) leaveEntryObj[10] : null;
			String approvalRemark = leaveEntryObj[11] != null ? (String) leaveEntryObj[11] : null;
			String cancelRemark = leaveEntryObj[12] != null ? (String) leaveEntryObj[12] : null;
			Date fromDate = leaveEntryObj[13] != null ? (Date) (leaveEntryObj[13]) : null;
			Date toDate = leaveEntryObj[14] != null ? (Date) (leaveEntryObj[14]) : null;
		/*	String approveEmpfirstName = leaveEntryObj[14] != null ? (String) leaveEntryObj[14] : null;
			String approveEmplastName = leaveEntryObj[15] != null ? (String) leaveEntryObj[15] : null;
			String aproveEmpdesignationName = leaveEntryObj[16] != null ? (String) leaveEntryObj[16] : null;
			*/
			
		/*	Date fromDate = leaveEntryObj[9] != null ? (Date) (leaveEntryObj[9]) : null;
			String halfFull_day = leaveEntryObj[10] != null ? (String) leaveEntryObj[10] : null;
			String halfDayFor = leaveEntryObj[11] != null ? (String) leaveEntryObj[11] : null;
			Boolean isRead = leaveEntryObj[12] != null ? (Boolean) leaveEntryObj[12] : null;
			String status = leaveEntryObj[13] != null ? (String) leaveEntryObj[13] : null;
			Long leaveTypeId = leaveEntryObj[14] != null ? Long.parseLong(leaveEntryObj[14].toString()) : null;
			String leaveType = leaveEntryObj[15] != null ? (String) leaveEntryObj[15] : null;
			Long companyId = leaveEntryObj[16] != null ? Long.parseLong(leaveEntryObj[16].toString()) : null;
			Date toDate = leaveEntryObj[17] != null ? (Date) (leaveEntryObj[17]) : null;
			
			Long userId = leaveEntryObj[19] != null ? Long.parseLong(leaveEntryObj[19].toString()) : null;
			Date dateUpdate = leaveEntryObj[20] != null ? (Date) (leaveEntryObj[20]) : null;
			Date actionDate = leaveEntryObj[21] != null ? (Date) (leaveEntryObj[21]) : null;
			Long employeeId = leaveEntryObj[22] != null ? Long.parseLong(leaveEntryObj[22].toString()) : null;*/
			
			leaveEntryDto.setLeaveId(leaveId);
			//leaveEntryDto.setLeaveTypeId(leaveTypeId);
			leaveEntryDto.setEmployeeName(firstName + " " + lastName);
			leaveEntryDto.setEmployeeId(employeeId);
			leaveEntryDto.setApprovalId(approvalId);
			leaveEntryDto.setDesignation(designationName);
		//	leaveEntryDto.setEmployeeCode(employeeCode);
			
			
			leaveEntryDto.setDays(days);
			leaveEntryDto.setEmployeeRemark(employeeRemark);
			leaveEntryDto.setCancleRemark(cancelRemark);
			leaveEntryDto.setApprovalRemark(approvalRemark);
			if (leaveEntryDto.getHalfDayFor() != null) {

				if (leaveEntryDto.getHalfDayFor().equals("1"))
					leaveEntryDto.setHalfDayForValue("First Half");
				else if (leaveEntryDto.getHalfDayFor().equals("2"))
					leaveEntryDto.setHalfDayForValue("Second Half");
			}
			//leaveEntryDto.setApprovalEmployeeName(approveEmpfirstName+" "+approveEmplastName);
		
			//leaveEntryDto.setApprovalEmployeeDesignation(aproveEmpdesignationName);
			leaveEntryDto.setStatus(status);
		
			if (leaveEntryDto.getStatus().equals(StatusMessage.PENDING_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.PENDING_VALUE);
			} else if (leaveEntryDto.getStatus().equals(StatusMessage.REJECTED_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.REJECTED_VALUE);
			} else if (leaveEntryDto.getStatus().equals(StatusMessage.APPROVED_CODE)) {
				leaveEntryDto.setStatusValue(StatusMessage.APPROVED_VALUE);
			}
			leaveEntryDto.setLeaveType(leaveName);
			
			leaveEntryDto.setDateCreated(dateCreated);
			//byte isReadByte = (byte) (isRead ? 1 : 0);
			//leaveEntryDto.setIsRead(isReadByte);
			//leaveEntryDto.setCompanyId(companyId);
			leaveEntryDto.setToDate(toDate);
			//leaveEntryDto.setUserId(userId);
			//leaveEntryDto.setDateUpdate(dateUpdate);
			//leaveEntryDto.setActionableDate(actionDate);
			leaveEntryDto.setFromDate(fromDate);
			//leaveEntryDto.setHalf_fullDay(halfFull_day);
			//leaveEntryDto.setHalfDayFor(halfDayFor);
			
			leaveEntryDtoList.add(leaveEntryDto);
		}

		return leaveEntryDtoList;
	}
}
