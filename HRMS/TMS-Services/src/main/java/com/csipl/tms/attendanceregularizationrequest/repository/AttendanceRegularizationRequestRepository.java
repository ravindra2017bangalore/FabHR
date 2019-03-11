package com.csipl.tms.attendanceregularizationrequest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.attendanceregularizationrequest.AttendanceRegularizationRequest;

public interface AttendanceRegularizationRequestRepository
		extends CrudRepository<AttendanceRegularizationRequest, Long> {

	/*
	 * @Query("from AttendanceRegularizationRequest where companyId=?1") public
	 * List<AttendanceRegularizationRequest> getAllARRequest(Long companyId);
	 */

	@Query("from AttendanceRegularizationRequest where arID=?1")
	public AttendanceRegularizationRequest getARRequest(Long arID);

	@Query("from AttendanceRegularizationRequest where employeeId=?1 AND status ='PEN'")
	public List<AttendanceRegularizationRequest> getEmployeePendingARRequest(Long employeeId);

	@Query("from AttendanceRegularizationRequest where employeeId=?1 AND status !='PEN'")
	public List<AttendanceRegularizationRequest> getEmployeeARRequest(Long employeeId);

	/*
	 * @Query("FROM AttendanceRegularizationRequest WHERE companyId=?1 AND employeeId=?2"
	 * ) public List<AttendanceRegularizationRequest>
	 * getAttendanceRegularizationRequest(Long companyId, Long employeeId);
	 */

	@Query("SELECT count(1) from AttendanceRegularizationRequest WHERE ( (fromDate <=?2 AND toDate >=?2) OR (fromDate <=?3 AND toDate=?3) OR (fromDate >?2 AND toDate < ?3) )AND employeeId=?1 AND (status='PEN' OR status='APR')")
	public int checkDateValidationOfAROnSameDate(Long employeeId, Date fromDate, Date toDate);

	@Query("SELECT count(1) from AttendanceRegularizationRequest WHERE ( (fromDate <=?2 AND toDate >=?2) OR (fromDate <=?3 AND toDate=?3) OR (fromDate >?2 AND toDate < ?3) )AND employeeId=?1 AND (status='PEN' OR status='APR') AND arID NOT IN (?4)")
	public int checkDateValidationOfAR(Long employeeId, Date fromDate, Date toDate, Long arID);

	@Query("SELECT COUNT(*) FROM AttendanceRegularizationRequest WHERE companyId=?1 and employeeId=?2 and status='PEN'")
	public int arCount(Long companyId, Long employeeId);

	@Query("SELECT COUNT(*) FROM AttendanceRegularizationRequest WHERE companyId=?1 and status='PEN'")
	public int getPendingARCount(long longCompanyId);

	@Query("SELECT COUNT(*) FROM AttendanceRegularizationRequest WHERE companyId=?1 and status !='PEN'")
	public int getNonPendingARCount(long longCompanyId);
}
