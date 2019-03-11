package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.payroll.Overtime;
import com.csipl.hrms.service.payroll.repository.OvertimeRepository;

@Service("overtimeService")
public class OvertimeServiceImpl implements OvertimeService {

	@Autowired
	  private OvertimeRepository overtimeRepository;
	
	/**
	 * to get List of overtime objects  from database based on companyId
	 */
	@Override
	public List<Overtime> getAllOvertimeMethods(Long companyId) {
 		 return overtimeRepository.findAllOvertimeMethods(companyId);
 	}
	/**
	 * Method performed save operation , save overtime object into database
	 */
	@Override
	public Overtime save(Overtime overtime) {
 		return overtimeRepository.save(overtime);
	}
  
}
