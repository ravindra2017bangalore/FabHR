package com.csipl.tms.attendanceregularizationrequest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.attendanceregularizationrequest.repository.PunchTimeDetailsRepository;
import com.csipl.tms.model.attendanceregularizationrequest.PunchTimeDetail;

@Service("punchTimeDetailsService")
public class PunchTimeDetailsServiceImpl  implements PunchTimeDetailsService{

	@Autowired
	PunchTimeDetailsRepository punchTimeDetailsRepository;
	@Override
	public void save(PunchTimeDetail punchDetails) {
		// TODO Auto-generated method stub
		punchTimeDetailsRepository.save(punchDetails);
		
	}
	@Override
	public List<PunchTimeDetail> getAllPunchtime( String employeeCode ,Long companyId,String InOut) {
		Date date = new Date();
		return punchTimeDetailsRepository.findAllPunchTime(employeeCode,companyId,InOut,date);
	}
	@Override
	public List<Object[]> getEmpAttendaceList(Long companyId) {
		Date date = new Date();
		System.out.println("date..."+date);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd ");
		System.out.println(dateformat.format(date));
		
		return punchTimeDetailsRepository.getEmpAttendaceList(companyId,dateformat.format(date));//
	}


}
