package com.csipl.tms.attendanceregularizationrequest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.attendanceregularizationrequest.PunchTimeDetail;

public interface PunchTimeDetailsRepository extends CrudRepository<PunchTimeDetail, Long>{
	@Query("from PunchTimeDetail where tktNo=?1 AND companyId=?2 AND in_out =?3 AND date=?4")
	List<PunchTimeDetail> findAllPunchTime( String employeeCode,Long companyId,String InOut,Date date);
	
	String getEmpAttendaceList ="SELECT MIN(sno), MAX(sno),MIN(time) ,MAX(time),tktno ,date ,companyId FROM PunchTimeDetail WHERE date =?2 AND companyId=?1 GROUP BY tktno,date,companyId";
	@Query(value=getEmpAttendaceList,nativeQuery = true)
	List<Object[]> getEmpAttendaceList(Long companyId ,String date);
	
	
	//@Query("DISTINCT(tktNo) from PunchTimeDetail where  companyId=?1 AND date=?2")
	//List<PunchTimeDetail> findEmployeeCodeList( Long companyId,Date date);
}
