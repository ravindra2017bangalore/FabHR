package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;

@Transactional
@Service("reportPayOutService")
public class ReportPayOutServiceImpl implements ReportPayOutService {

	@Autowired
	private ReportPayOutRepository reportPayOutRepository;

	/**
	 * to get List of Objects from database based on departmentId And processMonth
	 */
	@Override
	public List<Object[]> findPayOutReportOfDepartment(Long departmentId, String processMonth) {
		return reportPayOutRepository.findPayOutReportOfDepartment(departmentId, processMonth);

	}

	/**
	 * to get List of Objects from database based on companyId And processMonth
	 */
	@Override
	public List<Object[]> findPayOutReportOfCompany(Long companyId, String processMonth) {
		return reportPayOutRepository.findPayOutReportOfCompany(companyId, processMonth);
	}

	/**
	 * to get List of ReportPayOut objects from database based on departmentId And
	 * processMonth
	 */
	@Override
	public List<ReportPayOut> findEmployeesPayOutReport(Long departmentId, String processMonth) {
		return reportPayOutRepository.findEmployeesPayOutReport(departmentId, processMonth);
	}

	/**
	 * to get List of ReportPayOut objects from database based on processMonth And
	 * companyId
	 */
	@Override
	public ReportPayOut findEmployeePayOutPdf(String employeeCode, String processMonth, Long companyId) {
		return reportPayOutRepository.findEmployeePayOutPdf(employeeCode, processMonth, companyId);
	}

	/**
	 * to get List of ReportPayOut objects from database based on processMonth And
	 * companyId
	 */
	@Override
	public List<Object[]> findEsiEpfReport(String processMonth, Long companyId) {
		return reportPayOutRepository.findEsiEpfReport(processMonth, companyId);
	}

	/**
	 * to get List of ReportPayOut objects from database based on esicNo
	 */
	@Override
	public List<ReportPayOut> findEsiReport(String esicNo) {
		return reportPayOutRepository.findEsiReport(esicNo);
	}

	@Override
	public List<ReportPayOut> findPfReport(String uanno) {
		return reportPayOutRepository.findPfReport(uanno);
	}

	/**
	 * to get List of ReportPayOut objects from database based on processMonth And
	 * companyId
	 */
	@Override
	public List<ReportPayOut> findAllEmployeesPayOutReport(Long companyId, String processMonth) {
		return reportPayOutRepository.findAllEmployeesPayOutReport(companyId, processMonth);
	}

	/**
	 * to get List of ReportPayOut objects from database based on processMonth And
	 * companyId
	 */
	@Override
	public List<ReportPayOut> findAllEmployeesPaysheet(Long companyId, String processMonth) {
		return reportPayOutRepository.findAllEmployeesPaysheet(companyId, processMonth);
	}

	/**
	 * to get List of ReportPayOut objects from database based on companyId And
	 * processMonth
	 */
	@Override
	public List<Object[]> findEmployeesESIPayOutReport(Long companyId, String processMonth) {
		return reportPayOutRepository.findEmployeesESIPayOutReport(companyId, processMonth);
	}

	/**
	 * Save OR update List of ReportPayOut objects into database
	 */
	@Override
	public void save(List<ReportPayOut> payout) {
		reportPayOutRepository.save(payout);
	}

	@Override
	public List<Object[]> findAllEmployeesPayOutReportForSalaryProcess(Long companyId, String processMonth) {
		return reportPayOutRepository.findAllEmployeesPayOutReportForSalaryProcess(companyId, processMonth);
	}

	/**
	 * to get List of ReportPayOutSalary objects from database based on departmentId
	 * And processMonth
	 */
	@Override
	public List<Object[]> findEmployeesPayOutReportForSalaryProcess(Long departmentId, String processMonth) {
		return reportPayOutRepository.findEmployeesPayOutReportForSalaryProcess(departmentId, processMonth);

	}

	/**
	 * to check is payroll process or not for employee
	 */
	@Override
	public Long checkEmployeePayroll(Long empId) {
		return reportPayOutRepository.checkEmployeePayrollProcess(empId);
	}

	/**
	 * to check is payroll process or not for SalarySlip based on employeeCode and
	 * processMonth
	 */
	@Override
	public Long checkEmployeePayrollForSalarySlip(String employeeCode, String processMonth, Long companyId) {
		return reportPayOutRepository.checkEmployeePayrollForSalarySlip(employeeCode, processMonth, companyId);
	}

	@Override
	public Long checkPayrollOfEmployee(Long employeeId, String processMonth) {
		return reportPayOutRepository.checkPayrollOfEmployee(employeeId, processMonth);
	}

	@Override
	public ReportPayOut findReportPayout(Long employeeId, String processMonth, Long companyId) {

		return reportPayOutRepository.findReportPayout(employeeId, processMonth, companyId);
	}

	@Override
	public void saveReportPayout(ReportPayOut reportPayout) {
		reportPayOutRepository.save(reportPayout);

	}

	@Override
	public List<ReportPayOut> findEmployeesPaysheetBydept(Long companyId, Long departmentId, String processMonth) {

		return reportPayOutRepository.findEmployeesPaysheetBydept(companyId, departmentId, processMonth);
	}
}
