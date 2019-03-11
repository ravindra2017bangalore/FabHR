package com.csipl.tms.attendancelog.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.tms.model.attendancelog.AttendanceLog;

public interface AttendanceLogRepository  extends CrudRepository<AttendanceLog, Long>{

	@Query("FROM AttendanceLog  WHERE companyId=?1 AND attendanceDate=?2")
	List<AttendanceLog> getAttendanceLog(Long companyId,Date date);


}
