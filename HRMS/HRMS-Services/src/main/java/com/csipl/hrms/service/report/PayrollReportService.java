package com.csipl.hrms.service.report;

import java.util.Date;
import java.util.List;

public interface PayrollReportService {
	public List<Object[]>  findPTReport(Long companyId ,String fromProcessMonth,String toProcessMonth,Long departmentId,Long empId,Long stateId);
	public List<Object[]>  findProvisionReport(Long companyId ,Date fromDate,Date toDate,Long departmentId);
	public List<Object[]>  findPayrollReportByMonth(Long companyId,Long departmentId, String processMonth);
	public List<Object[]>  findPayrollReportByempId(Long companyId,Long employeeId, String fromProcessMonth, String toProcessMonth);
	public List<Object[]> findPayRollBankTRF(Long companyId , String processMonth, String bankName );
	public Long checkForRecoReprotAvailability(Long longDeptId,String processMonth, String checkReco);
	public List<Object[]> findReconciliationReport(Long companyId, Long longDeptId, String processMonth, String checkReco);
	public List<Object[]>  findEpfEcrReport(Long companyId, String processMonth);
	public List<Object[]>  findEpfReport(Long companyId, String processMonth);
	public List<Object[]>  findEsicEcrReport(Long companyId, String processMonth);
	public List<Object[]>  findEsicReport(Long companyId, String processMonth);
}
