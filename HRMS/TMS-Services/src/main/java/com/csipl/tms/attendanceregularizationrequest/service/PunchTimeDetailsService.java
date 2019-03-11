package com.csipl.tms.attendanceregularizationrequest.service;

import java.util.List;

import com.csipl.tms.model.attendanceregularizationrequest.PunchTimeDetail;

public interface PunchTimeDetailsService {
	public void save(PunchTimeDetail punchDetails);
	public List<PunchTimeDetail> getAllPunchtime(String employeeCode,Long companyId,String InOut);
	public List<Object[]>  getEmpAttendaceList(Long companyid);
	
}
