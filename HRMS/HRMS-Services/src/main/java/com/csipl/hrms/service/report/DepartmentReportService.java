package com.csipl.hrms.service.report;




import java.util.List;

import com.csipl.hrms.dto.report.DepartmentReportDTO;


public interface DepartmentReportService {
	
 public List<DepartmentReportDTO> departmentWiseCTC(Long companyId,Long p_process_month);
 
 public String processmonthbyLastmonth(Long companyId,Long p_process_month);
 
 public List<DepartmentReportDTO> LastSixMonthCTC(Long companyId,Long p_process_month);
 


}
