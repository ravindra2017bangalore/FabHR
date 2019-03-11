package com.csipl.tms.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.tms.model.leave.CompensatoryOff;


public interface CompensatoryOffRepository extends CrudRepository<CompensatoryOff, Long>{

	@Query(" from CompensatoryOff where companyId =?1 ORDER BY  tmsCompensantoryOffId  DESC ")
	public List<CompensatoryOff> findAllCompensatoryOff(Long companyId);
	
	@Query(" from CompensatoryOff where employeeId=?1 AND status=?2 ORDER BY  tmsCompensantoryOffId  DESC") 
 	public List<CompensatoryOff> findMyCompOffPendingReqList(Long employeeId, String status);

	@Query("   FROM CompensatoryOff where employeeId=?1 AND  status NOT IN ( ?2 )  ORDER BY  tmsCompensantoryOffId  DESC") 
 	public List<CompensatoryOff> findMyCompOffExcludedPendingReqList(Long employeeId, String status);
	
	@Query(" from CompensatoryOff where companyId=?1 AND status=?2 ORDER BY  tmsCompensantoryOffId  DESC") 
 	public List<CompensatoryOff> findAllCompOffPendingReqList(Long companyId, String status);

	@Query(" FROM CompensatoryOff where companyId=?1 AND  status NOT IN ( ?2 )  ORDER BY  tmsCompensantoryOffId  DESC") 
 	public List<CompensatoryOff> findAllCompOffExcludedPendingReqList(Long companyId, String status);
	
	@Query(" SELECT count(*) from CompensatoryOff  where companyId=?1 AND status =?2")
	int countAllCompOffPendingReqList(long longCompanyId,String status);
	
	@Query(" SELECT count(*) from CompensatoryOff  where companyId=?1  AND status NOT IN ( ?2 )")
	int countAllCompOffExcludedPendingReqList(long longCompanyId,String status);
	
	
}
