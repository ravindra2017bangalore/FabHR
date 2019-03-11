package com.csipl.hrms.service.report;



import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.model.employee.Employee;



public interface EmployeeReportService {
	
	 public EmployeeReportDTO countEMPIMPTODAYDATE(Long companyId,String value);
	 
	 public EmployeeReportDTO countNotification(Long companyId);
	 
	 public EmployeeReportDTO empTicketStatuswithMonth(Long companyId,Long lastMonth);
	 public EmployeeReportDTO empTicketStatus(Long companyId, Long userId,String roleName);
		
	 
	 public List<EmployeeReportDTO> empGenderWiseRatio(Long companyId);
	 
	 public List<EmployeeReportDTO> empAgeWiseRatio(Long companyId);
	 
	 
	 public List<EmployeeReportDTO> employeeNotification(Long companyId , String value);
	 
	 
	 
	 public List<EmployeeReportDTO> fetchBirthDayEmpList(Long companyId,String value);
	 
	 public List<EmployeeReportDTO> fetchAnniversaryDayEmpList(Long companyId,String value);
	 
	 public List<EmployeeReportDTO> fetchWorkAnniversaryDayEmpList(Long companyId,String value);  
	 
	 public List<EmployeeReportDTO> fetchEmployeeDocumentConfirmation(Long companyId);
	 
	 public List<EmployeeReportDTO> fetchEmployeeSeprationInfo(Long companyId);
	 
	 public List<EmployeeReportDTO> fetchDesignationWiseCTC(Long companyId,Long p_process_month);  
	 
	 public List<EmployeeReportDTO> fetchHeadCountByBankPay(Long companyId);
	 
	 public List<EmployeeReportDTO> empPayrollstatusbyMonth(Long companyId);
	 
	 
	 public List<EmployeeReportDTO> fetchEmpPfContribution(Long companyId,Long p_process_month);
	 
	 public List<EmployeeReportDTO> fetchEmpESIContribution(Long companyId ,Long p_process_month);
	 
	 
	 public List<EmployeeReportDTO> departmentWiseRatio(Long companyId);
	 
	 public List<EmployeeReportDTO> empCountByDesignationWise(Long companyId);
	 
	 public List<EmployeeReportDTO> empCountByDepartmentWise(Long companyId);
	 
	 
	 
	 public List<EmployeeReportDTO> EmpAttritionofResigned(Long companyId);
	 
	 public List<EmployeeReportDTO> EmpAttritionofJoined(Long companyId);
	 
	 public List<Employee> findEmployeesReportStatusBased(String status, Long companyId);
	 
	 public List<EmployeeReportDTO> empCompanyAnnouncement(Long companyId);

	 public List<Employee> findEmployeesReportDeptAndStatusBased(Long companyId, Date fromDate1, Date toDate1,
			Long departmentId, String status);
	 
	 
	 public List<EmployeeReportDTO> empAttendanceRatio(Long companyId,Long employeeId);
	 
	 
	 

	 
	 
}
