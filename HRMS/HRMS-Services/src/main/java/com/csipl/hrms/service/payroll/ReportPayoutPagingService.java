package com.csipl.hrms.service.payroll;


import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayoutSearchDTO;

public interface ReportPayoutPagingService {
	
	public List<Object[]> getReportPayOutByPaging( long companyId, ReportPayoutSearchDTO reportPayoutSearchDto );// , SearchDTO searchDto, );

	public void getDepartmentPayoutReportCount(long companyId, String processMonth , String departmentId , EmployeeCountDTO employeeCountDto);

	public void getCompanyPayoutReportCount(long companyId, String processMonth, EmployeeCountDTO employeeCountDto);

	public List<Object> payrollValidationByEmployeeCode(Long companyId, String processMonth, String employeeCodeSb);
	

}
