package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payroll.Overtime;

public interface OvertimeService {
 	public List<Overtime> getAllOvertimeMethods(Long companyId);
	 public Overtime save(Overtime overtime);
 
}
