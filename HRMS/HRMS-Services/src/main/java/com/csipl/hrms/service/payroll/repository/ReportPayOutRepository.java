package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public interface ReportPayOutRepository extends CrudRepository<ReportPayOut, Long> {

	String summaryReportQueryForDepartment = "select ReportPayOut.departmentId, Department.departmentName ,sum(ReportPayOut.BasicEarning),sum(ReportPayOut.GrossSalary),sum(ReportPayOut.NetPayableAmount),sum(ReportPayOut.ProvidentFundEmployee),sum(ReportPayOut.ProvidentFundEmployer),sum(ReportPayOut.ESI_Employee),sum(ReportPayOut.ESI_Employer),sum(ReportPayOut.PT),sum(ReportPayOut.TDS),sum(ReportPayOut.Loan) from ReportPayOut , Department where ReportPayOut.departmentId = Department.departmentId and ReportPayOut.processMonth=?2\r\n"
			+ " and ReportPayOut.departmentId =?1 group by ReportPayOut.departmentId , Department.departmentName";

	String sumaryReportForCompany = "select ReportPayOut.departmentId, Department.departmentName ,sum(ReportPayOut.BasicEarning),sum(ReportPayOut.GrossSalary),sum(ReportPayOut.NetPayableAmount),sum(ReportPayOut.ProvidentFundEmployee),sum(ReportPayOut.ProvidentFundEmployer),sum(ReportPayOut.ESI_Employee),sum(ReportPayOut.ESI_Employer),sum(ReportPayOut.PT),sum(ReportPayOut.TDS),sum(ReportPayOut.Loan) from ReportPayOut , Department where ReportPayOut.departmentId = Department.departmentId and ReportPayOut.processMonth=?2\r\n"
			+ " and ReportPayOut.companyId =?1 group by ReportPayOut.departmentId , Department.departmentName";

	String salarySlipProcessForDepartment = "SELECT ReportPayOut.departmentId, ReportPayOut.employeeCode, ReportPayOut.Name, ReportPayOut.dateOfJoining, Department.departmentName, Designation.designationName,ReportPayOut.email,ReportPayOut.employeeId,ReportPayOut.processMonth FROM ReportPayOut, Department, Employee, Designation WHERE ReportPayOut.departmentId = Department.departmentId AND ReportPayOut.employeeId=Employee.employeeId AND Employee.designationId=Designation.designationId AND ReportPayOut.departmentId=?1 AND ReportPayOut.processMonth =?2";
	String salarySlipProcessForAll = "SELECT ReportPayOut.departmentId, ReportPayOut.employeeCode, ReportPayOut.Name, ReportPayOut.dateOfJoining, Department.departmentName, Designation.designationName,ReportPayOut.email,ReportPayOut.employeeId,ReportPayOut.processMonth FROM ReportPayOut, Department, Employee, Designation WHERE ReportPayOut.departmentId = Department.departmentId AND ReportPayOut.employeeId=Employee.employeeId AND Employee.designationId=Designation.designationId AND  ReportPayOut.processMonth =?2 AND ReportPayOut.companyId =?1";

	String tdsSummary = "SELECT SUM(GrossSalary), SUM(ProvidentFundEmployee), SUM(ESI_Employee), SUM(PT), processMonth \r\n"
			+ "FROM ReportPayOut where employeeId=?1 and processMonth in (?2)";

	String processMonthForTdsSummary = "select processMonth FROM ReportPayOut WHERE employeeId=?1 and processMonth IN (?2)";
	/*
	 * String summaryQueryList= "select ReportPayOut.departmentId," +
	 * " Department.departmentName ,sum(ReportPayOut.BasicEarning)," +
	 * "sum(ReportPayOut.GrossSalary),sum(ReportPayOut.NetPayableAmount)," +
	 * "sum(ReportPayOut.ProvidentFundEmployee),sum(ReportPayOut.ProvidentFundEmployer),"
	 * +
	 * "sum(ReportPayOut.ESI_Employee),sum(ReportPayOut.ESI_Employer),sum(ReportPayOut.PT),"
	 * + "sum(ReportPayOut.TDS),sum(ReportPayOut.Loan) from ReportPayOut ," +
	 * " Department where ReportPayOut.departmentId = Department.departmentId and ReportPayOut.companyId=?1 and  ReportPayOut.processMonth=?2  group by ReportPayOut.departmentId , Department.departmentName"
	 * ;
	 */

	@Query(value = summaryReportQueryForDepartment, nativeQuery = true)
	List<Object[]> findPayOutReportOfDepartment(Long departmentId, String processMonth);

	@Query(value = sumaryReportForCompany, nativeQuery = true)
	List<Object[]> findPayOutReportOfCompany(Long companyId, String processMonth);

	/*
	 * @Query(value=summaryQueryList,nativeQuery = true) List<Object[]>
	 * findPayOutSumaryReportOfDepartment(Long companyId, String processMonth);
	 */

	// @Query(" from ReportPayOut where departmentId=?1 AND processMonth=?2 ORDER BY
	// departmentId DESC")
	@Query(" from ReportPayOut rp where rp.departmentId=?1  AND  rp.id.processMonth=?2 AND rp.employee.employeeId not in (select p.employee.employeeId from Provision p where p.processMonth=?2 ) ORDER BY  rp.departmentId  DESC")
	List<ReportPayOut> findEmployeesPayOutReport(Long departmentId, String processMonth);

	@Query(" from ReportPayOut rp where employeeCode=?1  AND  rp.id.processMonth=?2 and rp.companyId =?3 ")
	ReportPayOut findEmployeePayOutPdf(String employeeCode, String processMonth, Long companyId);

	@Query(" from ReportPayOut rp where    rp.ESICNumber =?1 ")
	List<ReportPayOut> findEsiReport(String esicNO);

	@Query(" from ReportPayOut rp where rp.uanno=?1")
	List<ReportPayOut> findPfReport(String uanno);

	// @Query(" from ReportPayOut where companyId=?1 AND processMonth=?2 ORDER BY
	// departmentId DESC")

	@Query(" from ReportPayOut rp where rp.companyId=?1  AND  rp.id.processMonth=?2 AND rp.employee.employeeId not in (select p.employee.employeeId from Provision p where p.processMonth=?2 )")
	List<ReportPayOut> findAllEmployeesPayOutReport(Long companyId, String processMonth);

	@Query(" from ReportPayOut rp where rp.companyId=?1  AND  rp.id.processMonth=?2 ORDER BY  rp.dateOfJoining  ASC")
	List<ReportPayOut> findAllEmployeesPaysheet(Long companyId, String processMonth);

	String findESICReport = "SELECT   rp.employeeCode,rp.ESICNumber ,rp .Name ,rp.fatherName,\r\n"
			+ "family.name,family.relation,rp.DOB,rp.gender,rp.esicjoining,\r\n"
			+ "rp.presense,rp.GrossSalary,rp.TotalEarning ,rp.ESI_Employee\r\n"
			+ "   FROM ReportPayOut  rp   LEFT JOIN EmployeeStatuary st ON rp.employeeId= st.employeeId \r\n"
			+ "   LEFT JOIN EmployeeFamily family ON family.familyId= st.familyId \r\n"
			+ "   JOIN Esi esi on esi.companyId=rp.companyId  where  rp.GrossSalary<esi.maxGrossLimit AND rp.processMonth=?2 and rp.companyId =?1 AND rp.isNoPFDeduction='N' and st.statuaryType='ES' or st.statuaryType=' ' or st.statuaryType is null   ORDER BY  dateOfJoining  ASC";

	// @Query(" from ReportPayOut where companyId=?1 AND processMonth=?2 and
	// ESI_Employee > 0 ORDER BY dateOfJoining ASC")
	@Query(value = findESICReport, nativeQuery = true)
	List<Object[]> findEmployeesESIPayOutReport(Long companyId, String processMonth);

	String findEPFReport = "SELECT   rp.employeeCode,rp.UANNO ,rp .Name ,rp.fatherName,rp.epfNominee,rp.epfNomineeRelation,rp.DOB,rp.gender,rp.epfJoining,rp.maritalStatus,rp.accountNumber,rp.IFSCCode, rp.aadharNo,rp.PANNO,rp.mobileNo,rp.email,rp.GrossSalary,rp.dearnessAllowance,rp.Basic,rp.presense,rp.absense,rp.TotalEarning,rp.BasicEarning,rp.PensionEarningSalary ,rp.ProvidentFundEmployee\r\n"
			+ "     FROM ReportPayOut  rp where   rp.processMonth=?1 and rp.companyId =?2 AND ( rp.isNoPFDeduction= 'N' OR rp.isNoPFDeduction IS Null) ORDER BY  dateOfJoining  ASC";

	@Query(value = findEPFReport, nativeQuery = true)
	// @Query(" from ReportPayOut rp where rp.id.processMonth=?1 and rp.companyId
	// =?2 and rp.providentFundEmployee > 0 ORDER BY dateOfJoining ASC")
	List<Object[]> findEsiEpfReport(String processMonth, Long companyId);

	@Query(value = salarySlipProcessForDepartment, nativeQuery = true)
	List<Object[]> findEmployeesPayOutReportForSalaryProcess(Long departmentId, String processMonth);

	@Query(value = salarySlipProcessForAll, nativeQuery = true)
	List<Object[]> findAllEmployeesPayOutReportForSalaryProcess(Long companyId, String processMonth);

	@Query(" select COUNT(1) from ReportPayOut WHERE employeeId=?1 ")
	Long checkEmployeePayrollProcess(Long employeeId);

	@Query("select COUNT(1) from ReportPayOut WHERE employeeCode=?1 And processMonth=?2 And companyId=?3")
	Long checkEmployeePayrollForSalarySlip(String employeeCode, String processMonth, Long companyId);

	String companypayoutReportCount = "Select COUNT(*) from ReportPayOut rp where rp.companyId=?1 AND rp.processMonth=?2 AND rp.employeeId not in (select p.employeeId from Provision p where p.processMonth=?2)";

	@Query(value = companypayoutReportCount, nativeQuery = true)
	public int companyPayoutReportCount(Long companyId, String processMonth);

	String departmentpayoutReportCount = "select COUNT( * ) from ReportPayOut , Department where ReportPayOut.departmentId = Department.departmentId and ReportPayOut.companyId=?1 and ReportPayOut.processMonth=?2 and ReportPayOut.departmentId =?3 group by ReportPayOut.departmentId , Department.departmentName";

	@Query(value = departmentpayoutReportCount, nativeQuery = true)
	public int departmentPayoutReportCount(Long companyId, String processMonth, String departmentId);

	@Query(value = processMonthForTdsSummary, nativeQuery = true)
	List<Object[]> findProcessMonthForTdsSummary(Long employeeId, String month);

	@Query(value = tdsSummary, nativeQuery = true)
	List<Object[]> findTdsSummary(Long employeeId, String month);

	@Query("select COUNT(1) from ReportPayOut WHERE companyId=?1 And processMonth=?2 And departmentId=?3")
	Long checkPayRollForEmployeeJoining(Long companyId, String processMonth, Long departmentId);

	@Query("SELECT COUNT(1) FROM ReportPayOut where employeeId=?1 AND processMonth=?2")
	Long checkPayrollOfEmployee(Long employeeId, String processMonth);

	@Query(" from ReportPayOut rp where employeeId=?1  AND  rp.id.processMonth=?2 and rp.companyId =?3 ")
	ReportPayOut findReportPayout(Long employeeId, String processMonth, Long companyId);

	@Query(" from ReportPayOut rp where rp.companyId=?1  AND  rp.id.processMonth=?3 AND  rp.departmentId=?2 ORDER BY  rp.dateOfJoining  ASC")
	List<ReportPayOut> findEmployeesPaysheetBydept(Long companyId, Long departmentId, String processMonth);

	
}
