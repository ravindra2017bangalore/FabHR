package com.csipl.tms.leave.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.csipl.tms.model.leave.TMSLeaveEntry;

public interface LeaveEntryRepository extends CrudRepository<TMSLeaveEntry, Long> {

	String QUERY_LEAVE_BALANCE = "SELECT tmsLeaveTypeHd.leaveTypeHdId,tmsLeaveTypeHd.leaveRuleType,tmsLeaveType.leaveType,tmsLeaveType.yearlyLimit,tmsLeaveType.indexCol,tmsLeaveType.indexDays,tmsLeaveType.maxLeaveInMonth,tmsLeaveType.leaveFrequencyInMonth, sum( tmsLeaveEntries.days) , tmsLeaveTypeHd.effectiveStartDate, tmsLeaveTypeHd.effectiveEndDate,tmsLeaveType.leaveTypeId FROM TMSLeaveTypeHd tmsLeaveTypeHd JOIN TMSLeaveType tmsLeaveType ON tmsLeaveTypeHd.leaveTypeHdId = tmsLeaveType.leaveTypeHdId LEFT OUTER JOIN TMSLeaveEntries tmsLeaveEntries ON tmsLeaveEntries.leaveTypeId = tmsLeaveType.leaveTypeId AND CURRENT_DATE BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.employeeId =?1 AND tmsLeaveEntries.status = 'APR' AND tmsLeaveTypeHd.activestatus='AC' AND tmsLeaveEntries.fromDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.toDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate GROUP BY tmsLeaveType.leaveType";
	String QUERY_EMPLOYEE_DETAIL = "SELECT dept.departmentId,  desig.designationId,   emp.dateOfJoining, dept.patternId,  tmsWeekOffPattern.day FROM  Employee emp JOIN Department dept ON  dept.departmentId = emp.departmentId JOIN Designation desig ON desig.designationId = emp.designationId LEFT JOIN TMSWeekOffPattern tmsWeekOffPattern  ON    tmsWeekOffPattern.patternId = dept.patternId WHERE emp.employeeId =?1";
	String QUERY_LEAVE_BALANCE_LOGIC = "SELECT tmsLeaveTypeHd.leaveTypeHdId, tmsLeaveTypeHd.leaveRuleType,   tmsLeaveType.leaveType,  tmsLeaveType.yearlyLimit,  tmsLeaveType.indexCol,  tmsLeaveType.indexDays,   tmsLeaveType.maxLeaveInMonth,  tmsLeaveType.leaveFrequencyInMonth,  SUM(tmsLeaveEntries.days),  tmsLeaveTypeHd.effectiveStartDate,   tmsLeaveTypeHd.effectiveEndDate,emp.dateOfJoining, dept.departmentId,tmsWeekOffPattern.patternId,  tmsWeekOffPattern.day,  tmsLeaveType.isWeekOffAsPL,  tmsLeaveType.weekOffAsPLCount,  tmsLeaveType.isLeaveInProbation,    emp.probationDays FROM TMSLeaveTypeHd tmsLeaveTypeHd JOIN TMSLeaveType tmsLeaveType ON   tmsLeaveTypeHd.leaveTypeHdId = tmsLeaveType.leaveTypeHdId LEFT OUTER JOIN TMSLeaveEntries tmsLeaveEntries ON  tmsLeaveEntries.leaveTypeId = tmsLeaveType.leaveTypeId AND CURRENT_DATE BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.activestatus='AC' AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.employeeId =?1 AND tmsLeaveType.leaveTypeId=?2 AND tmsLeaveEntries.status = 'APR'   AND tmsLeaveEntries.fromDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.toDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate JOIN Employee emp ON   emp.employeeId = tmsLeaveEntries.employeeId  JOIN Department dept ON  emp.departmentId = dept.departmentId JOIN TMSWeekOffPattern tmsWeekOffPattern ON  dept.patternId = tmsWeekOffPattern.patternId";
	String QUERY_LEAVE_PENDING = "SELECT   tmsLeaveTypeHd.leaveTypeHdId,   tmsLeaveTypeHd.leaveRuleType,  tmsLeaveType.leaveType,    tmsLeaveType.yearlyLimit,   tmsLeaveType.indexCol,     tmsLeaveType.indexDays,  tmsLeaveType.maxLeaveInMonth,  tmsLeaveType.leaveFrequencyInMonth,  SUM(tmsLeaveEntries.days),   tmsLeaveTypeHd.effectiveStartDate,  tmsLeaveTypeHd.effectiveEndDate,   emp.dateOfJoining,  dept.departmentId,   tmsWeekOffPattern.patternId,  tmsWeekOffPattern.day,  tmsLeaveType.isWeekOffAsPL,     tmsLeaveType.weekOffAsPLCount,tmsLeaveType.isLeaveInProbation,emp.probationDays FROM   TMSLeaveTypeHd tmsLeaveTypeHd JOIN TMSLeaveType tmsLeaveType ON   tmsLeaveTypeHd.leaveTypeHdId = tmsLeaveType.leaveTypeHdId JOIN TMSLeaveEntries tmsLeaveEntries ON  tmsLeaveEntries.leaveTypeId = tmsLeaveType.leaveTypeId AND CURRENT_DATE BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.employeeId =?1 AND tmsLeaveType.leaveTypeId =?2 AND tmsLeaveEntries.status = 'PEN' AND tmsLeaveEntries.fromDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate AND tmsLeaveEntries.toDate BETWEEN tmsLeaveTypeHd.effectiveStartDate AND tmsLeaveTypeHd.effectiveEndDate  JOIN Employee emp ON emp.employeeId = tmsLeaveEntries.employeeId JOIN Department dept ON  emp.departmentId = dept.departmentId JOIN TMSWeekOffPattern tmsWeekOffPattern ON  dept.patternId = tmsWeekOffPattern.patternId GROUP BY   tmsLeaveType.leaveType";
	String QUERY_APPROVED_LEAVE_IN_DURATION = "SELECT tmsLeaveEntries.status, SUM(tmsLeaveEntries.days) FROM TMSLeaveEntries tmsLeaveEntries  JOIN TMSLeaveType tmsLeaveType ON tmsLeaveEntries.leaveTypeId=tmsLeaveType.leaveTypeId WHERE tmsLeaveEntries.fromDate >=?1 AND tmsLeaveEntries.toDate <=?2 AND tmsLeaveEntries.employeeId=?3 AND  tmsLeaveEntries.leaveTypeId=?4";
	String QUERY_WEEKOFF_PATTERN = "select tmsWeekOffPattern.patternId,tmsWeekOffPattern.day from TMSWeekOffPattern tmsWeekOffPattern JOIN Department department On department.patternId=tmsWeekOffPattern.patternId JOIN Employee employee ON employee.departmentId=department.departmentId WHERE employee.employeeId=?1";
	
	String QUERY_PENDING_LEAVE_IN_DURATION_BASED_ON_PK = "SELECT tmsLeaveEntries.status, SUM(tmsLeaveEntries.days) FROM TMSLeaveEntries tmsLeaveEntries  JOIN TMSLeaveType tmsLeaveType ON tmsLeaveEntries.leaveTypeId=tmsLeaveType.leaveTypeId WHERE tmsLeaveEntries.fromDate >=?1 AND tmsLeaveEntries.toDate <=?2 AND tmsLeaveEntries.employeeId=?3 AND  tmsLeaveEntries.leaveTypeId=?4 and tmsLeaveEntries.leaveId=?5 AND tmsLeaveEntries.status='PEN'";
	String QUERY_MONTLY_FREQUENCY_CHECK = "SELECT tmsLeaveEntries.status, SUM(tmsLeaveEntries.days) FROM TMSLeaveEntries tmsLeaveEntries  JOIN TMSLeaveType tmsLeaveType ON tmsLeaveEntries.leaveTypeId=tmsLeaveType.leaveTypeId WHERE tmsLeaveEntries.fromDate >=?1 AND tmsLeaveEntries.toDate <=?2 AND tmsLeaveEntries.employeeId=?3 AND  tmsLeaveEntries.leaveTypeId=?4";

	String QUERY_LEAVEENTRY = "SELECT ecd.firstName,ecd.lastName,ecd.departmentName,ecd.designationName,ecd.employeeCode,le.leaveId,le.approvalRemark,le.days,le.employeeRemark,le.fromDate,le.halfFullDay,le.halfDayFor,le.isRead,le.status,le.leaveTypeId,lt.leaveMode,le.companyId,le.toDate,le.dateCreated,le.userId,le.dateUpdate,le.actionableDate,le.employeeId FROM TMSLeaveEntries le JOIN TMSLeaveType lt ON lt.leaveTypeId=le.leaveTypeId JOIN EmpCommonDetails ecd on ecd.employeeId=le.employeeId where le.companyId=?1";

	String QUERY_LEAVEBALANCESUMMRY="SELECT tmsLeaveType.leaveTypeId ,tmsLeaveType.leavePeriodId,tmsLeaveType.leaveTypeMasterId,tmsLeaveType.leaveMode ,ltm.leaveName \r\n" + 
			",tmsLeaveType.yearlyLimit,SUM(IFNULL(lc.leaveCount, 0)) as \r\n" + 
			"			carryForwordLeave, (tmsLeaveType.yearlyLimit + IFNULL(lc.leaveCount, 0)) as totalleave,SUM(IFNULL(tmsLeaveEntries.days,0)) as consumed,((IFNULL(tmsLeaveType.yearlyLimit,0)+IFNULL(lc.leaveCount, 0) )-SUM(IFNULL(tmsLeaveEntries.days,0)) ) as balanceleave ,tmsLeaveType.indexDays,tmsLeaveType.maxLeaveInMonth,tmsLeaveType.leaveFrequencyInMonth ,tmsLeaveType.isLeaveInProbation,tmsLeaveType.carryForwardLimit,tmsLeaveType.nature,\r\n" + 
			"            tmsLeaveType.notice,tmsLeaveType.weekOffAsPLCount ,tmsLeaveTypeHd.leavePeriodName ,lp.startDate ,lp.endDate ,employee.dateOfJoining FROM TMSLeavePeriod tmsLeaveTypeHd JOIN TMSLeaveType \r\n" + 
			"			tmsLeaveType ON tmsLeaveTypeHd.leavePeriodId = tmsLeaveType.leavePeriodId  AND tmsLeaveType.activeStatus ='AC'\r\n" + 
			"			LEFT JOIN TMSLeaveEntries tmsLeaveEntries ON\r\n" + 
			"            tmsLeaveEntries.leaveTypeId =  \r\n" + 
			"			tmsLeaveType.leaveTypeId AND tmsLeaveEntries.employeeId =?1 AND  \r\n" + 
			"			(tmsLeaveEntries.status = 'APR' OR tmsLeaveEntries.status = 'PEN') AND tmsLeaveTypeHd.activestatus='AC' \r\n" + 
			"			Left JOIN TMSLeaveCarryForward lc on lc.leavePeriodId=tmsLeaveType.leavePeriodId  \r\n" + 
			"			and lc.leaveTypeMasterId=tmsLeaveType.leaveTypeMasterId and\r\n" + 
			"			lc.employeeId=tmsLeaveEntries.employeeId\r\n" + 
			"         Left join TMSLeaveTypeMaster ltm on ltm.leaveId=tmsLeaveType.leaveTypeMasterId\r\n"
			+ " Left join TMSLeavePeriod lp on lp.leavePeriodId=tmsLeaveType.leavePeriodId\r\n" + 
			"           Left join Employee employee on employee.employeeId=?1\r\n" +
			
			"		 where tmsLeaveTypeHd.activeStatus='AC' And ltm.companyId=?2  GROUP BY tmsLeaveType.leaveTypeId" ;
	

    String QUERY_APPROVED_PENDING_LEAVE_IN_DURATION = "SELECT IFNULL(SUM(tmsLeaveEntries.days),0) FROM TMSLeaveEntries tmsLeaveEntries WHERE tmsLeaveEntries.fromDate >=?1 AND tmsLeaveEntries.toDate <=?2 AND tmsLeaveEntries.employeeId=?3 AND tmsLeaveEntries.leaveTypeId=?4 and tmsLeaveEntries.status in('APR','PEN')";
	
	
	
	String QUERY_TEAMONLEAVE="SELECT a.employeeId,a.employeeCode,\r\n" + 
			"UPPER(concat(concat(a.firstName,' '),a.lastName)) as empname\r\n" + 
			",tle.status,tle.fromDate,tle.toDate\r\n" + 
			",(CASE \r\n" + 
			"  WHEN (Month(tle.fromDate)=Month(tle.toDate)) THEN DAY(tle.toDate)-DAY(tle.fromDate)\r\n" + 
			"  WHEN (Month(tle.fromDate)<Month(tle.toDate)) THEN DAY(LAST_DAY(tle.fromDate))-DAY(tle.fromDate)+DAY(tle.toDate)\r\n" + 
			"\r\n" + 
			"  END )as 'leaves'\r\n" + 
			"FROM Employee a\r\n" + 
			"INNER JOIN Employee b ON   b.employeeId =?1 and b.ReportingToEmployee=a.ReportingToEmployee\r\n" + 
			" join TMSLeaveEntries tle on tle.employeeId=a.employeeId and tle.status='APR' and Month(tle.fromDate)=Month(?2)\r\n" + 
			" \r\n" + 
			" UNION\r\n" + 
			" \r\n" + 
			" SELECT a.employeeId,a.employeeCode,\r\n" + 
			"UPPER(concat(concat(a.firstName,' '),a.lastName)) as empname\r\n" + 
			",tle.status,tle.fromDate,tle.toDate\r\n" + 
			",(CASE \r\n" + 
			"  WHEN (Month(tle.fromDate)=Month(tle.toDate)) THEN DAY(tle.toDate)-DAY(tle.fromDate)\r\n" + 
			"  WHEN (Month(tle.fromDate)<Month(tle.toDate)) THEN DAY(LAST_DAY(tle.fromDate))-DAY(tle.fromDate)+DAY(tle.toDate)\r\n" + 
			"\r\n" + 
			"  END )as 'leaves'\r\n" + 
			"FROM Employee a\r\n" + 
			"INNER JOIN Employee b ON   b.employeeId =?1 and b.ReportingToEmployee=a.ReportingToEmployee\r\n" + 
			" join TMSLeaveEntries tle on tle.employeeId=a.employeeId and  tle.status='PEN' and Month(tle.fromDate)=Month(?2)";
	

	
	@Query(value = QUERY_LEAVEENTRY, nativeQuery = true)
	public List<Object[]> leaveEntryList(Long companyId);

	/*
	 * @Query(" from LeaveEntry where companyId=?1 ORDER BY  leaveId  DESC") public
	 * List<LeaveEntry> leaveEntryList(Long companyId);
	 */

	@Query(" from TMSLeaveEntry where employeeId=?1")
	public List<TMSLeaveEntry> getEmployeeLeaveEntry(Long employeeId);

	@Query(" from TMSLeaveEntry where employeeId=?1 AND status='PEN'")
	public List<TMSLeaveEntry> getEmployeePendingLeaveEntry(Long employeeId);
	
	@Query(" from TMSLeaveEntry where employeeId=?1 AND status='APR' or status='REJ' or status='CEN'")
	public List<TMSLeaveEntry> getEmployeeApprovedLeaveEntry(Long employeeId);

	@Query(value = QUERY_LEAVE_BALANCE, nativeQuery = true)
	public List<Object[]> getEmployeeLeaveBalance(Long employeeId);

	@Query(value = QUERY_EMPLOYEE_DETAIL, nativeQuery = true)
	public List<Object[]> getEmployeeDetails(Long employeeId);

	@Query(value = QUERY_LEAVE_BALANCE_LOGIC, nativeQuery = true)
	public List<Object[]> getEmployeeLeaveLogic(Long employeeId, Long leaveTypeId);

	@Query(value = QUERY_LEAVE_PENDING, nativeQuery = true)
	public List<Object[]> getEmployeePendingLeave(Long employeeId, Long leaveTypeId);

	@Query(value = QUERY_APPROVED_PENDING_LEAVE_IN_DURATION, nativeQuery = true)
	public Object getEmployeeApprovedLeaveInDuration(Date fromDate, Date toDate, Long employeeId,
			Long leaveTypeId);

	@Query(value = QUERY_WEEKOFF_PATTERN, nativeQuery = true)
	public List<Object[]> getWeekOffPattern(Long employeeId);

	@Query("SELECT count(1) from TMSLeaveEntry WHERE ( (fromDate <=?2 AND toDate >=?2) OR (fromDate <=?3 AND toDate=?3) OR (fromDate >?2 AND toDate < ?3) )AND employeeId=?1 AND (status='PEN' OR status='APR') AND leaveId !=?4 ")
	public int checkDateValidation(Long employeeId, Date fromDate, Date toDate,Long leaveId);

	@Query("SELECT count(1) from TMSLeaveEntry WHERE ( (fromDate <=?2 AND toDate >=?2) OR (fromDate <=?3 AND toDate=?3) OR (fromDate >?2 AND toDate < ?3) )AND employeeId=?1 AND (status='PEN' OR status='APR') ")
	public int checkDateValidation1(Long employeeId, Date fromDate, Date toDate);
	
	
	@Query(value = QUERY_PENDING_LEAVE_IN_DURATION_BASED_ON_PK, nativeQuery = true)
	public List<Object[]> getEmployeePndingLeaveInDurationBasedOnPK(Date fromDate, Date toDate, Long employeeId,
			Long leaveTypeId, Long leaveId);

	@Query("SELECT COUNT(1) FROM  TMSLeaveEntry   WHERE fromDate >=?1 AND toDate <=?2 AND employeeId =?3 AND leaveTypeId = ?4 AND (status='APR' OR status='PEN')")
	public int getEmployeeMonthlyFrequencyCount(Date fromDate, Date toDate, Long employeeId, Long leaveTypeId);

	@Query(" from TMSLeaveEntry where ?1 BETWEEN fromDate AND toDate")
	public List<TMSLeaveEntry> getEmployeeLeaveEntryListByDate(Date date);
	
	@Query("SELECT COUNT(*) FROM TMSLeaveEntry WHERE companyId=?1 AND employeeId=?2 AND status='PEN'")
	public int leaveCount(Long companyId,Long employeeId);
	
	@Query(" from TMSLeaveEntry where companyId=?1 AND status='APR' or status='REJ' or status='CEN'")
	public List<TMSLeaveEntry> getAllEmployeeApprovedLeaveEntry(Long companyId);
	
	@Query(" SELECT count(*) from TMSLeaveEntry le JOIN Employee emp ON emp.employeeId=le.employeeId where le.companyId=?1 AND (le.status='APR' or le.status='REJ' or le.status='CEN') AND emp.activeStatus ='AC'")
	public int entitySearch(Long companyId);
	
	@Query("SELECT count(*) from TMSLeaveEntry le JOIN Employee emp ON emp.employeeId=le.employeeId where le.companyId=?1 AND le.status='PEN' AND emp.activeStatus ='AC'")
	public int pendingEntitySearch(Long companyId);
	
	
	@Query(value = QUERY_LEAVEBALANCESUMMRY, nativeQuery = true)
	public List<Object[]> getEmployeeLeaveBalanceSummry(Long employeeId,Long companyId);
	

    @Query(value = QUERY_TEAMONLEAVE, nativeQuery = true)
	public List<Object[]> getTeamLeaveOnCalender(String employeeId,String currentDate);
	
	
}
