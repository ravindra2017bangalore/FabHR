package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payrollprocess.ReportPayOut;

 
public interface ReportPayOutService {
	public List<Object[]> findPayOutReportOfDepartment(Long departmentId,String processMonth);
	
	public List<Object[]> findPayOutReportOfCompany(Long companyId,String processMonth);
	
 	public List<ReportPayOut> findEmployeesPayOutReport(Long departmentId,String processMonth);
 	
 	public List<ReportPayOut> findEmployeesPaysheetBydept(Long companyId,Long departmentId,String processMonth);
 	
	public ReportPayOut findEmployeePayOutPdf(String  employeeCode,String processMonth,Long companyId);
	
	public List<Object[]> findEsiEpfReport(String processMonth,Long companyId);
	
	public List<Object[]> findEmployeesESIPayOutReport( Long companyId, String processMonth );
	
	public List<ReportPayOut> findEsiReport(String esicNo);
	
	public List<ReportPayOut> findPfReport(String uanno);
	
 	public List<ReportPayOut> findAllEmployeesPayOutReport(Long companyId,String processMonth);
 	
 	public List<ReportPayOut> findAllEmployeesPaysheet(Long companyId,String processMonth);
 	
 	public void save(List<ReportPayOut> payout);
 	
 	public List<Object[]>  findAllEmployeesPayOutReportForSalaryProcess(Long companyId, String processMonth);
 	
 	public	List<Object[]>  findEmployeesPayOutReportForSalaryProcess(Long departmentId, String processMonth);
 	
	public Long checkEmployeePayroll(Long empId);
	
	public Long checkEmployeePayrollForSalarySlip(String  employeeCode,String processMonth,Long companyId);
	
	public Long checkPayrollOfEmployee(Long employeeId,String processMonth);
	
	public void saveReportPayout(ReportPayOut reportPayout);
	
	public ReportPayOut findReportPayout(Long employeeId,String processMonth,Long companyId);

}
