package com.csipl.hrms.service.report.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.csipl.hrms.model.common.Branch;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public interface PayrollReportRepository extends CrudRepository<ReportPayOut, Long> {

	
	String findPTReport ="CALL  pro_emp_reportpt_bymonth( :p_comp_id,:p_from_process_month,:p_to_process_month,:p_emp_id,:p_state_id,:p_dept_id)" ;

	@Query(value=findPTReport,nativeQuery = true)
	public List<Object[]> findPTReport(@Param(value = "p_comp_id") Long p_comp_id  ,@Param(value = "p_from_process_month") String p_from_process_month ,@Param(value = "p_to_process_month") String p_to_process_month,@Param(value = "p_emp_id") Long p_emp_id,@Param(value = "p_state_id") Long p_state_id,@Param(value = "p_dept_id") Long p_dept_id);																			// empCode,Long stateId

	String findProvisionReport = "SELECT rp.Name ,rp.employeeCode,rp.bankName,rp.accountNumber,rp.NetPayableAmount,pr.dateCreated,dept.departmentName \r\n" + 
			"    FROM ReportPayOut rp join Provision pr ON  rp.employeeId = pr.employeeId\r\n" + 
			"   join Department dept ON pr.departmentId = dept.departmentId\r\n" + 
			"    WHERE  pr.companyId =?1 AND rp.processMonth IN (select p.processMonth from Provision p where  pr.dateCreated BETWEEN ?2 and ?3 ) ";

	@Query(value = findProvisionReport, nativeQuery = true)
	List<Object[]> findProvisionReport( Long companyId,Date fromDate, Date toDate);// Date fromDate, Date toDate,

	String findProvisionReportByDept = "SELECT rp.Name ,rp.employeeCode,rp.bankName,rp.accountNumber,rp.NetPayableAmount,pr.dateCreated,dept.departmentName \r\n" + 
			"    FROM ReportPayOut rp join Provision pr ON  rp.employeeId = pr.employeeId\r\n" + 
			"   join Department dept ON pr.departmentId = dept.departmentId\r\n" + 
			"    WHERE  pr.departmentId =?4 AND pr.companyId =?1 AND rp.processMonth IN (select p.processMonth from Provision p where  pr.dateCreated BETWEEN ?2 and ?3 ) ";

	@Query(value = findProvisionReportByDept, nativeQuery = true)
	List<Object[]> findProvisionReportbydeptId(Long companyId, Date fromDate, Date toDate, Long departmentId);																				// empCode,Long stateId

	String findPayrollReportByMonth = "SELECT   rp .Name ,rp.employeeCode,rp.bankName,rp.accountNumber, rp.dateOfJoining,\r\n"
			+ "			rp.Basic ,rp.dearnessAllowance,rp.ConveyanceAllowance,rp.HRA,rp.MedicalAllowance,\r\n"
			+ "			rp.AdvanceBonus,rp.SpecialAllowance ,rp.CompanyBenefits ,rp.otherAllowance \r\n"
			+ "			,rp.GrossSalary ,rp.absense,rp.casualleave,rp.seekleave,rp.paidleave\r\n"
			+ "			,rp.presense ,rp.publicholidays ,rp.weekoff,rp.overtime ,rp.payDays ,rp.BasicEarning \r\n"
			+ "			,rp.dearnessAllowanceEarning,rp.ConveyanceAllowanceEarning ,rp.HRAEarning,rp.MedicalAllowanceEarning\r\n"
			+ "			,rp.AdvanceBonusEarning, rp.SpecialAllowanceEarning,rp.CompanyBenefitsEarning,rp.otherAllowanceEarning\r\n"
			+ "			,rp.TotalEarning,rp.EmployeeLoansAdvnaceEarning,rp.ProvidentFundEmployee,rp.ESI_Employee,\r\n"
			+ "			rp.PT,rp.TDS,rp.TotalDeduction,rp.NetPayableAmount\r\n"
			+ "			,dept.departmentName\r\n"  
			+"				 FROM ReportPayOut  rp JOIN Department dept ON rp.departmentId= dept.departmentId \r\n"
			+ "			 WHERE rp.processMonth=?2 \r\n"
			+ "			 AND rp.companyId=?1\r\n"
			+ "			ORDER BY  rp.dateOfJoining  ASC";

	@Query(value = findPayrollReportByMonth, nativeQuery = true)

	List<Object[]> findPayrollReportByMonth(Long companyId,  String processMonth);
	
	String findPayrollReportByMonthBydept = "SELECT   rp .Name ,rp.employeeCode,rp.bankName,rp.accountNumber, rp.dateOfJoining,\r\n"
			+ "			rp.Basic ,rp.dearnessAllowance,rp.ConveyanceAllowance,rp.HRA,rp.MedicalAllowance,\r\n"
			+ "			rp.AdvanceBonus,rp.SpecialAllowance ,rp.CompanyBenefits ,rp.otherAllowance \r\n"
			+ "			,rp.GrossSalary ,rp.absense,rp.casualleave,rp.seekleave,rp.paidleave\r\n"
			+ "			,rp.presense ,rp.publicholidays ,rp.weekoff,rp.overtime ,rp.payDays ,rp.BasicEarning \r\n"
			+ "			,rp.dearnessAllowanceEarning,rp.ConveyanceAllowanceEarning ,rp.HRAEarning,rp.MedicalAllowanceEarning\r\n"
			+ "			,rp.AdvanceBonusEarning, rp.SpecialAllowanceEarning,rp.CompanyBenefitsEarning,rp.otherAllowanceEarning\r\n"
			+ "			,rp.TotalEarning,rp.EmployeeLoansAdvnaceEarning,rp.ProvidentFundEmployee,rp.ESI_Employee,\r\n"
			+ "			rp.PT,rp.TDS,rp.TotalDeduction,rp.NetPayableAmount\r\n"
			+ "			,dept.departmentName\r\n" + 
			"				 FROM ReportPayOut  rp JOIN Department dept ON rp.departmentId= dept.departmentId  WHERE rp.processMonth=?3 AND rp.departmentId=?2 \r\n"
			+ "			 AND rp.companyId=?1\r\n"
			+ "			ORDER BY  rp.dateOfJoining  ASC";

	@Query(value = findPayrollReportByMonthBydept, nativeQuery = true)

	List<Object[]> findPayrollReportByMonthBydept(Long companyId, Long departmentId, String processMonth);

/*	String findPayrollReportByEmpId = "SELECT  rp.processMonth , rp .Name ,rp.employeeCode,rp.bankName,rp.accountNumber,rp.dateOfJoining, \r\n"
			+ "						rp.Basic ,rp.dearnessAllowance,rp.ConveyanceAllowance,rp.HRA,rp.MedicalAllowance, \r\n"
			+ "				rp.AdvanceBonus,rp.SpecialAllowance ,rp.CompanyBenefits ,rp.otherAllowance \r\n"
			+ "						,rp.GrossSalary ,rp.absense,rp.casualleave,rp.seekleave,rp.paidleave\r\n"
			+ "					,rp.presense ,rp.publicholidays ,rp.weekoff,rp.overtime ,rp.payDays ,rp.BasicEarning \r\n"
			+ "					,rp.dearnessAllowanceEarning,rp.ConveyanceAllowanceEarning ,rp.HRAEarning,rp.MedicalAllowanceEarning\r\n"
			+ "				,rp.AdvanceBonusEarning, rp.SpecialAllowanceEarning,rp.CompanyBenefitsEarning,rp.otherAllowanceEarning\r\n"
			+ "						,rp.TotalEarning,rp.EmployeeLoansAdvnaceEarning,rp.ProvidentFundEmployee,rp.ESI_Employee, \r\n"
			+ "			rp.PT,rp.TDS,rp.TotalDeduction,rp.NetPayableAmount\r\n"
			+ "					 FROM ReportPayOut  rp WHERE ( month(str_to_date(SUBSTRING_INDEX(rp.processMonth,'-',1),'%b')) BETWEEN month(str_to_date(SUBSTRING_INDEX(?3,'-',1),'%b'))  and month(str_to_date(SUBSTRING_INDEX(?4,'-',1),'%b'))) AND rp.employeeId=?2 \r\n"
			+ "					 AND rp.companyId=?1\r\n"
			+ "						ORDER BY  rp.dateOfJoining  ASC    pro_emp_reportpt_bymonth";
*/
	/*@Query(value = findPayrollReportByEmpId, nativeQuery = true)

	List<Object[]> findPayrollReportByEmpId(Long companyId, Long employeeId, String processMonth,
			String toProcessMonth);
*/
	@Query(value = findPayRollBankTRF, nativeQuery = true)
	List<Object[]> findPayRollBankTRF(Long companyId, String processMonth, String bankName);

	@Query("SELECT COUNT(1) FROM PayRollLock WHERE isPayRollLocked=?1 and departmentId=?2 and processMonth=?3")
	public Long checkForRecoReprotAvailability(String checkReco,Long longDeptId, String processMonth);

	
	String findPayRollBankTRF = "SELECT rp.employeeCode,rp.name,rp.bankName,rp.accountNumber,rp.NetPayableAmount,rp.processMonth,dept.departmentName FROM ReportPayOut rp JOIN Department dept ON dept.departmentId = rp.departmentId WHERE rp.companyId=?1 and rp.processMonth =?2 AND rp.bankName =?3";

	String findReconciliationReportWithDept = "SELECT DISTINCT rp.employeeCode,rp.name,rp.bankName,rp.accountNumber,rp.NetPayableAmount,rp.processMonth,dept.departmentName,rp.transactionNo,rp.dateUpdate \r\n" + 
			"FROM ReportPayOut rp LEFT JOIN Department dept ON dept.departmentId = rp.departmentId LEFT JOIN PayRollLock pl ON pl.processMonth = rp.processMonth\r\n" + 
			"WHERE rp.companyId =?1 AND rp.departmentId =?2 AND rp.processMonth =?3 and pl.isPayRollLocked=?4 AND rp.employeeId not in (select pr.employeeId from Provision pr where pr.processMonth=?3 AND pr.activeStatus=?5 )";
	
	String findReconciliationReportWithoutDept = "SELECT DISTINCT rp.employeeCode,rp.name,rp.bankName,rp.accountNumber,rp.NetPayableAmount,rp.processMonth,dept.departmentName,rp.transactionNo,rp.dateUpdate \r\n" + 
			"FROM ReportPayOut rp LEFT JOIN Department dept ON dept.departmentId = rp.departmentId LEFT JOIN PayRollLock pl ON pl.processMonth = rp.processMonth\r\n" + 
			"WHERE rp.companyId =?1 AND  rp.processMonth =?2 and pl.isPayRollLocked=?3 AND rp.employeeId not in (select pr.employeeId from Provision pr where pr.processMonth=?2 AND pr.activeStatus=?4 )";
	

	String findNonReconciliationReportWithDept = "SELECT DISTINCT rp.employeeCode,rp.name,rp.bankName,rp.accountNumber,rp.NetPayableAmount,rp.processMonth,dept.departmentName,rp.transactionNo,rp.dateUpdate \r\n" + 
			"FROM ReportPayOut rp LEFT JOIN Department dept ON dept.departmentId = rp.departmentId LEFT JOIN PayRollLock pl ON pl.processMonth = rp.processMonth\r\n" + 
			"WHERE rp.companyId =?1 AND rp.departmentId =?2 AND rp.processMonth =?3 and pl.isPayRollLocked=?4 AND rp.employeeId  in (select pr.employeeId from Provision pr where pr.processMonth=?3 AND pr.activeStatus=?5 )";
	
	String findNonReconciliationReportWithoutDept = "SELECT DISTINCT rp.employeeCode,rp.name,rp.bankName,rp.accountNumber,rp.NetPayableAmount,rp.processMonth,dept.departmentName,rp.transactionNo,rp.dateUpdate \r\n" + 
			"FROM ReportPayOut rp LEFT JOIN Department dept ON dept.departmentId = rp.departmentId LEFT JOIN PayRollLock pl ON pl.processMonth = rp.processMonth\r\n" + 
			"WHERE rp.companyId =?1 AND  rp.processMonth =?2 and pl.isPayRollLocked=?3 AND rp.employeeId  in (select pr.employeeId from Provision pr where pr.processMonth=?2 AND pr.activeStatus=?4 )";
	
	String findPayrollReportByEmpId ="CALL  pro_payrollreport_byempid( :p_comp_id,:p_emp_id,:p_from_process_month,:p_to_process_month)" ;

	@Query(value=findPayrollReportByEmpId,nativeQuery = true)
	public List<Object[]> findPayrollReportByEmpId(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_emp_id") Long p_emp_id ,@Param(value = "p_from_process_month") String p_from_process_month ,@Param(value = "p_to_process_month") String p_to_process_month);

	@Query(value = findReconciliationReportWithDept, nativeQuery = true)
	List<Object[]> findReconciliationReportWithDept(Long companyId, Long longDeptId, String processMonth,String checkReco ,String status);

	@Query(value = findReconciliationReportWithoutDept, nativeQuery = true)
 	public List<Object[]> findReconciliationReportWithoutDept(Long companyId, String processMonth, String checkReco,String status);
 	
 	@Query(value = findNonReconciliationReportWithDept, nativeQuery = true)
	List<Object[]> findNonReconciliationReportWithDept(Long companyId, Long longDeptId, String processMonth,String checkReco ,String status);

	@Query(value = findNonReconciliationReportWithoutDept, nativeQuery = true)
 	public List<Object[]> findNonReconciliationReportWithoutDept(Long companyId, String processMonth, String checkReco,String status);
 	String findEpfEcrReport ="SELECT rp.UANNO ,rp.Name,rp.TotalEarning,rp.BasicEarning,rp.PensionEarningSalary ,rp.absense,rp.ProvidentFundEmployee,rp.ProvidentFundEmployer ,rp.ProvidentFundEmployerPension  FROM ReportPayOut rp WHERE rp.processMonth=?2  AND rp.companyId=?1 AND ( rp.isNoPFDeduction='N' OR rp.isNoPFDeduction IS Null)";
 	@Query(value = findEpfEcrReport, nativeQuery = true)

	List<Object[]> findEpfEcrReport(Long companyId, String processMonth);
	
	String findEpfReport ="SELECT COUNT(rp.Name),SUM(rp.TotalEarning) FROM ReportPayOut rp WHERE rp.processMonth=?2 AND rp.isNoPFDeduction='Y' AND rp.companyId=?1";
 	@Query(value = findEpfReport, nativeQuery = true)

 	List<Object[]> findEpfReport(Long companyId, String processMonth);
 	
 	String findEsicEcrReport ="SELECT rp.ESICNumber, rp.Name,rp.payDays,rp.TotalEarning FROM ReportPayOut rp  JOIN Esi esi on esi.companyId=rp.companyId WHERE rp.GrossSalary<esi.maxGrossLimit AND rp.companyId=?1 AND rp.processMonth=?2";
 	@Query(value = findEsicEcrReport, nativeQuery = true)

	List<Object[]> findEsicEcrReport(Long companyId, String processMonth);
	
	String findEsicReport ="SELECT COUNT(rp.Name),sum(rp.TotalEarning) FROM ReportPayOut rp  JOIN Esi esi on esi.companyId=rp.companyId WHERE rp.GrossSalary>esi.maxGrossLimit AND rp.companyId=?1 AND rp.processMonth=?2";
 	@Query(value = findEsicReport, nativeQuery = true)

	List<Object[]> findEsicReport(Long companyId, String processMonth);
}
