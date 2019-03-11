package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayoutSearchDTO;
import com.csipl.hrms.service.payroll.repository.ReportPayOutPagingRepository;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;

@Service("reportPayOutPagingService")
public class ReportPayoutPagingServiceImpl implements ReportPayoutPagingService {

	@Autowired
	private ReportPayOutRepository reportPayOutRepository;

	@Autowired
	private ReportPayOutPagingRepository reportPayOutPagingRepository;

	@Override
	public void getCompanyPayoutReportCount(long companyId, String processMonth, EmployeeCountDTO employeeCountDto) {
		employeeCountDto.setCount(reportPayOutRepository.companyPayoutReportCount(companyId, processMonth));
	}

	@Override
	public void getDepartmentPayoutReportCount(long companyId, String processMonth, String departmentId,
			EmployeeCountDTO employeeCountDto) {
		employeeCountDto
				.setCount(reportPayOutRepository.departmentPayoutReportCount(companyId, processMonth, departmentId));

	}

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getReportPayOutByPaging(long companyId, ReportPayoutSearchDTO reportPayoutSearchDto) {

		return reportPayOutPagingRepository.findReportPayOutPagingResulst(companyId, reportPayoutSearchDto);
	}

	@Override
	public List<Object> payrollValidationByEmployeeCode(Long companyId, String processMonth, String employeeCodeSb) {

		return reportPayOutPagingRepository.payrollValidationByEmployeeCode(companyId, processMonth, employeeCodeSb);
	}

}
