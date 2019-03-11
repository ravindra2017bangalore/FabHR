package com.csipl.hrms.service.employee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

 import com.csipl.hrms.model.employee.Separation;
 
public interface SeparationRepository extends CrudRepository<Separation, Long> {
	@Query(" from Separation where employeeId=?1 And companyId=?2 ORDER BY  separationId  DESC") 
 	public List<Separation> getSeparationList(Long employeeId,Long companyId);

	@Query(" from Separation where companyId=?1  ORDER BY  separationId  DESC") 
	public List<Separation> getAllseparationList(Long companyId);
 		
	@Query("select count(1) from Separation WHERE employeeId=?1  and (status=?2 OR status=?3)") 
 	public Long checkSeparationForRequest(Long employeeId,String status1,String status2);
	
	@Query(" from Separation where companyId=?1  AND dateCreated=?2 AND status='P' ORDER BY  separationId  DESC") 
	public List<Separation> getAllseparationPendingList(Long companyId, Date currentDate);
	

	@Query("select count(*) from Separation where companyId=?1 AND  endDate>=Now() AND (status='A' or status='P')") 
	public Long getNoticePeriodCount(Long companyId);

	@Query("SELECT COUNT(*) FROM Separation WHERE companyId=?1 AND MONTH(NOW())=MONTH(endDate)")
	public int seperationCount(Long companyId);
	
	@Query("from Separation where employeeId=?1 AND (status=?2 OR status=?3) ORDER BY  separationId  DESC") 
 	public List<Separation> employeeCancelledResignReqList(Long employeeId,String status,String status2);

	
	@Query(" from Separation where employeeId=?1 AND (status=?2 OR status=?3 )ORDER BY  separationId  DESC") 
 	public Separation employeePendingResignReq(Long employeeId,String status,String approvedStatus2);

	@Modifying
 	@Query(" UPDATE Separation SET status =?2, description=?3 WHERE separationId=?1") 
	public void updateRequestStatus(Long separationId, String status, String description);

	@Query(" from Separation where companyId=?1 AND status=?2 ORDER BY  separationId  DESC") 
 	public List<Separation> findAllSeparationPendingReqList(Long companyId, String status);

	@Query("   FROM Separation WHERE companyId=?1 AND  status NOT IN ( ?2 )  ORDER BY  separationId  DESC") 
 	public List<Separation> findAllSeparationExcludedPendingReqList(Long companyId, String status);

	@Query(" SELECT count(*) from Separation  where companyId=?1 AND status =?2  ")
 	public int getPendingSeparationCount(Long companyId, String strStatus);

	@Query(" SELECT count(*) from Separation  where companyId=?1 AND  status NOT IN ( ?2 ) ")
 	public int getExcludedPendingSeparationCount(Long companyId, String strStatus);
 

}
