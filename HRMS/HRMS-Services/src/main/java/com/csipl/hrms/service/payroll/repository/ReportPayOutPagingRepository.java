package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import com.csipl.hrms.dto.payrollprocess.ReportPayoutSearchDTO;

public interface ReportPayOutPagingRepository {

	List<Object[]> findReportPayOutPagingResulst(long companyId, ReportPayoutSearchDTO reportPayoutSearchDto);

	public List<Object> payrollValidationByEmployeeCode(Long companyId, String processMonth, String employeeCodeSb);

}
