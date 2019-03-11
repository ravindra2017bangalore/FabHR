package com.csipl.hrms.service.report.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.csipl.hrms.model.employee.Employee;




public interface EmployeeReportRepository  extends CrudRepository<Employee, Long>{

	String countEMPIMPTODAYDATE ="CALL  pro_emp_count_todaydate( :p_comp_id,:p_flag)" ;
	
	String fetchAnniversayEmpList ="CALL  pro_emp_count_todaydate( :p_comp_id,:p_flag)" ;
	
	String fetchBirthDayEmpList ="CALL  pro_emp_count_todaydate( :p_comp_id,:p_flag)" ;
	
	String fetchWorkAnniversayEmpList ="CALL  pro_emp_count_todaydate( :p_comp_id,:p_flag)" ;
	
	String fetchDesignationWiseCTC ="CALL  pro_designation_wise_ctc( :p_comp_id,:p_process_month)";
	
	String fetchHeadCountByBankPay ="CALL  pro_headcount_by_bankpay( :p_comp_id)";
	
	String empPayrollstatusbyMonth ="CALL  pro_emp_payrollmonth_status( :p_comp_id)";
	
	String empTicketStatus ="CALL  pro_emp_ticket_status(:p_comp_id,:p_user_id, :roleName)";
	
	String empTicketStatusWithMonth ="CALL  pro_emp_ticket_status(:p_comp_id, :lastMonth)";
	
	
	String fetchEmpPfContribution ="CALL  	pro_pf_contribution( :p_comp_id,:p_process_month)";
	
	String fetchEmpESIContribution ="CALL  	pro_esi_contribution( :p_comp_id,:p_process_month)";
	
	String fetchEmployeeDocumentConfirmation = "CALL  	pro_emp_doc_confirmation( :p_comp_id)";
	
	String countNotification = "CALL  	pro_emp_notification( :p_comp_id ,:p_flag)";
	
	String empNotification = "CALL  	pro_emp_notification( :p_comp_id ,:p_flag)";
	
	String fetchEmployeeSeprationInfo = "CALL  	pro_emp_sepration_status( :p_comp_id) "; 
	
	String empGenderWiseRatio ="CALL  	pro_emp_genderwise_ratio( :p_comp_id) ";
	
	String departmentWiseRatio = "CALL  pro_department_wise_ration( :p_comp_id) ";
	
	String empAttritionofResigned ="CALL  pro_emp_attrition_resigned( :p_comp_id) ";
	
	String empAttritionofJoined ="CALL  pro_emp_attrition_joined( :p_comp_id) ";
	
	String empAgeWiseRatio ="CALL  pro_emp_count_agewisedistribution( :p_comp_id) ";
	
	String empCountByDesignationWise="CALL 	pro_emp_count_designationwise( :p_comp_id) ";
	
	String empCountByDepartmentWise="CALL 	pro_emp_count_departmentwise( :p_comp_id) ";
	
	String empCompanyAnnouncement="CALL 	pro_company_announcement( :p_comp_id) ";
	
	String empAttendanceRatio="CALL 	pro_emp_attendance_bymonth( :p_comp_id,:p_emp_id) ";
	
	@Query(value=countEMPIMPTODAYDATE,nativeQuery = true)
	public List<Object[]> countEMPIMPTODAYDATE(@Param(value = "p_comp_id") Long p_comp_id, @Param(value = "p_flag") String p_flag);
		
	
	@Query(value=fetchBirthDayEmpList,nativeQuery = true)
	public List<Object[]> fetchBirthDayEmpList(@Param(value = "p_comp_id") Long p_comp_id, @Param(value = "p_flag") String p_flag);
	
	
	@Query(value=fetchAnniversayEmpList,nativeQuery = true)
	public List<Object[]> fetchAnniversaryDayEmpList(@Param(value = "p_comp_id") Long p_comp_id, @Param(value = "p_flag") String p_flag);
	        
	@Query(value=fetchWorkAnniversayEmpList,nativeQuery = true)
	public List<Object[]> fetchWorkAnniversaryDayEmpList(@Param(value = "p_comp_id") Long p_comp_id, @Param(value = "p_flag") String p_flag);
	
	@Query(value=fetchDesignationWiseCTC,nativeQuery = true)
	public List<Object[]> fetchDesignationWiseCTCList(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "p_process_month") Long p_process_month);

	
	@Query(value=fetchHeadCountByBankPay,nativeQuery = true)
	public List<Object[]> fetchHeadCountByBankPay(@Param(value = "p_comp_id") Long p_comp_id);
	
	@Query(value=empPayrollstatusbyMonth,nativeQuery = true)
	public List<Object[]> empPayrollstatusbyMonth(@Param(value = "p_comp_id") Long p_comp_id);
	
	
	@Query(value=empTicketStatus,nativeQuery = true)
	public List<Object[]> empTicketStatus(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "p_user_id") Long p_user_id,@Param(value = "roleName") String roleName);
	
	
	@Query(value=empTicketStatusWithMonth,nativeQuery = true)
	public List<Object[]> empTicketStatuswithMonth(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "lastMonth") Long lastMonth);
	
	@Query(value=fetchEmpPfContribution,nativeQuery = true)
	public List<Object[]> fetchEmpPfContribution(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "p_process_month") Long p_process_month);
	
	@Query(value=fetchEmpESIContribution,nativeQuery = true)
	public List<Object[]> fetchEmpESIContribution(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "p_process_month") Long p_process_month);
	
	@Query(value=fetchEmployeeDocumentConfirmation,nativeQuery = true)
	public List<Object[]> fetchEmployeeDocumentConfirmation(@Param(value = "p_comp_id") Long p_comp_id);
	
	@Query(value=fetchEmployeeSeprationInfo,nativeQuery = true)
	public List<Object[]> fetchEmployeeSeprationInfo(@Param(value = "p_comp_id") Long p_comp_id);
	
	
	
	@Query(value=countNotification,nativeQuery = true)
	public List<Object> countNotification(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_flag")  String p_flag);
	
	
	@Query(value=empNotification,nativeQuery = true)
	public List<Object[]> employeeNotification(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_flag")  String p_flag);
	
	
	@Query(value=empGenderWiseRatio,nativeQuery = true)
	public List<Object[]> empGenderWiseRatio(@Param(value = "p_comp_id") Long p_comp_id );
	
	
	@Query(value=departmentWiseRatio,nativeQuery = true)
	public List<Object[]> departmentWiseRatio(@Param(value = "p_comp_id") Long p_comp_id );
	
	
	@Query(value=empAttritionofResigned,nativeQuery = true)
	public List<Object[]> EmpAttritionofResigned(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=empAttritionofJoined,nativeQuery = true)
	public List<Object[]> EmpAttritionofJoined(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=empAgeWiseRatio,nativeQuery = true)
	public List<Object[]> empAgeWiseRatio(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=empCountByDesignationWise,nativeQuery = true)
	public List<Object[]> empCountByDesignationWise(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=empCountByDepartmentWise,nativeQuery = true)
	public List<Object[]> empCountByDepartmentWise(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=empCompanyAnnouncement,nativeQuery = true)
	public List<Object[]> empCompanyAnnouncement(@Param(value = "p_comp_id") Long p_comp_id );
	
	@Query(value=findEmployeesReportStatusBased,nativeQuery = true)
 	public List<Object[]> findEmployeesReportStatusBased(Long companyId,String status);
  	

 	
 	String findEmployeesReportStatusBased ="\r\n" + 
 			"SELECT\r\n" + 
 			"    emp.employeeCode,\r\n" + 
 			"    emp.firstName,\r\n" + 
 			"    emp.middleName,\r\n" + 
 			"    emp.lastName,\r\n" + 
 			"    emp.dateOfBirth,\r\n" + 
 			"    emp.gender,\r\n" + 
 			"    emp.maritalStatus,\r\n" + 
 			"    addrs.addressText,\r\n" + 
 			"    addrs.landmark,\r\n" + 
 			"    addrsCountry.countryName,\r\n" + 
 			"    addrsState.stateName,\r\n" + 
 			"    addrsCity.cityName,\r\n" + 
 			"    addrs.pincode,\r\n" + 
 			"    addrs.mobile,\r\n" + 
 			"    addrs.telephone,\r\n" + 
 			"    addrs.emailId,\r\n" + 
 			"    state.stateName AS jobLocationState,\r\n" + 
 			"    city.cityName AS jobLocationCity,\r\n" + 
 			"    emp.bloodGroup,\r\n" + 
 			"    emp.probationDays,\r\n" + 
 			"    emp.empType,\r\n" + 
 			"    dept.departmentName,\r\n" + 
 			"    designation.designationName,\r\n" + 
 			"    emp.contractOverDate,\r\n" + 
 			"    emp.referenceName,\r\n" + 
 			"    emp.dateOfJoining,eBank.accountType,eBank.bankId,eBank.accountNumber,eBank.ifscCode,\r\n" + 
 			"     GROUP_CONCAT(DISTINCT eIdProofs.idTypeId SEPARATOR ',') as IdTypeeIdProofs, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eIdProofs.idNumber SEPARATOR ',') as IdNumbereIdProofs, \r\n" + 
 			"     GROUP_CONCAT(DISTINCT eStatuary.statuaryType SEPARATOR ',') as statuaryType, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eStatuary.statuaryNumber SEPARATOR ',') as statuaryNumber,\r\n" + 
 			"                    GROUP_CONCAT(  ePayStructure.payHeadId SEPARATOR ',') as payHeadId,\r\n" + 
 			"                           GROUP_CONCAT(  ePayStructure.amount SEPARATOR ',') as amount\r\n" + 
 			"\r\n" + 
 			"\r\n" + 
 			"    \r\n" + 
 			" \r\n" + 
 			"FROM\r\n" + 
 			"    Employee emp\r\n" + 
 			"LEFT JOIN PayStructureHd ph ON\r\n" + 
 			"    ph.employeeId = emp.employeeId AND(\r\n" + 
 			"        ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE\r\n" + 
 			"    ) AND(\r\n" + 
 			"        ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE\r\n" + 
 			"    ) AND ph.activeStatus = 'AC'\r\n" + 
 			"    LEFT JOIN PayStructure ePayStructure ON\r\n" + 
 			"    ePayStructure.payStructureHdId = ph.payStructureHdId\r\n" + 
 			"    \r\n" + 
 			"    LEFT  JOIN EmployeeIdProofs eIdProofs ON\r\n" + 
 			"    eIdProofs.employeeId =emp.employeeId\r\n" + 
 			" LEFT  JOIN EmployeeStatuary eStatuary ON\r\n" + 
 			"     eStatuary.employeeId=  emp.employeeId\r\n" + 
 			"LEFT   JOIN EmployeeBank eBank ON\r\n" + 
 			"    eBank.employeeId = emp.employeeId AND (eBank.activeStatus='AC' AND eBank.accountType='SA')\r\n" + 
 			"  \r\n" + 
 			"LEFT JOIN Address addrs ON\r\n" + 
 			"    addrs.addressId = emp.presentAddressId\r\n" + 
 			"LEFT JOIN State state ON\r\n" + 
 			"    state.stateId = emp.stateId\r\n" + 
 			"LEFT JOIN City city ON\r\n" + 
 			"    city.cityId = emp.cityId\r\n" + 
 			"LEFT JOIN Country addrsCountry ON\r\n" + 
 			"    addrsCountry.countryId = addrs.countryId\r\n" + 
 			"LEFT JOIN State addrsState ON\r\n" + 
 			"    addrsState.stateId = addrs.stateId\r\n" + 
 			"LEFT JOIN City addrsCity ON\r\n" + 
 			"    addrsCity.cityId = addrs.cityId\r\n" + 
 			"LEFT JOIN Department dept ON\r\n" + 
 			"    dept.departmentId = emp.departmentId\r\n" + 
 			"LEFT JOIN Designation designation ON\r\n" + 
 			"    designation.designationId = emp.designationId\r\n" + 
 			"  WHERE  emp.companyId=?1 and emp.activeStatus=?2 \r\n" + 
 			"GROUP BY\r\n" + 
 			"emp.employeeId ,eBank.bankId,eBank.accountType,eBank.ifscCode,eBank.accountNumber";

 /*	String findEmployeesReportDeptAndStatusBased ="\r\n" + 
 			"SELECT\r\n" + 
 			"    emp.employeeCode,\r\n" + 
 			"    emp.firstName,\r\n" + 
 			"    emp.middleName,\r\n" + 
 			"    emp.lastName,\r\n" + 
 			"    emp.dateOfBirth,\r\n" + 
 			"    emp.gender,\r\n" + 
 			"    emp.maritalStatus,\r\n" + 
 			"    addrs.addressText,\r\n" + 
 			"    addrs.landmark,\r\n" + 
 			"    addrsCountry.countryName,\r\n" + 
 			"    addrsState.stateName,\r\n" + 
 			"    addrsCity.cityName,\r\n" + 
 			"    addrs.pincode,\r\n" + 
 			"    addrs.mobile,\r\n" + 
 			"    addrs.telephone,\r\n" + 
 			"    addrs.emailId,\r\n" + 
 			"    state.stateName AS jobLocationState,\r\n" + 
 			"    city.cityName AS jobLocationCity,\r\n" + 
 			"    emp.bloodGroup,\r\n" + 
 			"    emp.probationDays,\r\n" + 
 			"    emp.empType,\r\n" + 
 			"    dept.departmentName,\r\n" + 
 			"    designation.designationName,\r\n" + 
 			"    emp.contractOverDate,\r\n" + 
 			"    emp.referenceName,\r\n" + 
 			"    emp.dateOfJoining,eBank.accountType,eBank.bankId,eBank.accountNumber,eBank.ifscCode,\r\n" + 
 			"     GROUP_CONCAT(DISTINCT eIdProofs.idTypeId SEPARATOR ',') as IdTypeeIdProofs, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eIdProofs.idNumber SEPARATOR ',') as IdNumbereIdProofs, \r\n" + 
 			"     GROUP_CONCAT(DISTINCT eStatuary.statuaryType SEPARATOR ',') as statuaryType, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eStatuary.statuaryNumber SEPARATOR ',') as statuaryNumber,\r\n" + 
 			"                    GROUP_CONCAT(  ePayStructure.payHeadId SEPARATOR ',') as payHeadId,\r\n" + 
 			"                           GROUP_CONCAT(  ePayStructure.amount SEPARATOR ',') as amount\r\n" + 
 			"\r\n" + 
 			"\r\n" + 
 			"    \r\n" + 
 			" \r\n" + 
 			"FROM\r\n" + 
 			"    Employee emp\r\n" + 
 			"LEFT JOIN PayStructureHd ph ON\r\n" + 
 			"    ph.employeeId = emp.employeeId AND(\r\n" + 
 			"        ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE\r\n" + 
 			"    ) AND(\r\n" + 
 			"        ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE\r\n" + 
 			"    ) AND ph.activeStatus = 'AC'\r\n" + 
 			"    LEFT JOIN PayStructure ePayStructure ON\r\n" + 
 			"    ePayStructure.payStructureHdId = ph.payStructureHdId\r\n" + 
 			"    \r\n" + 
 			"    LEFT  JOIN EmployeeIdProofs eIdProofs ON\r\n" + 
 			"    eIdProofs.employeeId =emp.employeeId\r\n" + 
 			" LEFT  JOIN EmployeeStatuary eStatuary ON\r\n" + 
 			"     eStatuary.employeeId=  emp.employeeId\r\n" + 
 			"LEFT   JOIN EmployeeBank eBank ON\r\n" + 
 			"    eBank.employeeId = emp.employeeId AND (eBank.activeStatus='AC' AND eBank.accountType='SA')\r\n" + 
 			"  \r\n" + 
 			"LEFT JOIN Address addrs ON\r\n" + 
 			"    addrs.addressId = emp.presentAddressId\r\n" + 
 			"LEFT JOIN State state ON\r\n" + 
 			"    state.stateId = emp.stateId\r\n" + 
 			"LEFT JOIN City city ON\r\n" + 
 			"    city.cityId = emp.cityId\r\n" + 
 			"LEFT JOIN Country addrsCountry ON\r\n" + 
 			"    addrsCountry.countryId = addrs.countryId\r\n" + 
 			"LEFT JOIN State addrsState ON\r\n" + 
 			"    addrsState.stateId = addrs.stateId\r\n" + 
 			"LEFT JOIN City addrsCity ON\r\n" + 
 			"    addrsCity.cityId = addrs.cityId\r\n" + 
 			"LEFT JOIN Department dept ON\r\n" + 
 			"    dept.departmentId = emp.departmentId\r\n" + 
 			"LEFT JOIN Designation designation ON\r\n" + 
 			"    designation.designationId = emp.designationId\r\n" + 
 			"  WHERE  emp.companyId=?1 and emp.activeStatus=?2 emp.departmentId=?3 and (emp.dateOfJoining>=?4 and emp.dateOfJoining<=?5) \r\n" + 
 			"GROUP BY\r\n" + 
 			"emp.employeeId ,eBank.bankId,eBank.accountType,eBank.ifscCode,eBank.accountNumber";
*/
 	
 	String findEmployeesReportDeptAndStatusBased ="SELECT\r\n" + 
 			"    emp.employeeCode,\r\n" + 
 			"    emp.firstName,\r\n" + 
 			"    emp.middleName,\r\n" + 
 			"    emp.lastName,\r\n" + 
 			"    emp.dateOfBirth,\r\n" + 
 			"    emp.gender,\r\n" + 
 			"    emp.maritalStatus,\r\n" + 
 			"    addrs.addressText,\r\n" + 
 			"    addrs.landmark,\r\n" + 
 			"    addrsCountry.countryName,\r\n" + 
 			"    addrsState.stateName,\r\n" + 
 			"    addrsCity.cityName,\r\n" + 
 			"    addrs.pincode,\r\n" + 
 			"    addrs.mobile,\r\n" + 
 			"    addrs.telephone,\r\n" + 
 			"    addrs.emailId,\r\n" + 
 			"    state.stateName AS jobLocationState,\r\n" + 
 			"    city.cityName AS jobLocationCity,\r\n" + 
 			"    emp.bloodGroup,\r\n" + 
 			"    emp.probationDays,\r\n" + 
 			"    emp.empType,\r\n" + 
 			"    dept.departmentName,\r\n" + 
 			"    designation.designationName,\r\n" + 
 			"    emp.contractOverDate,\r\n" + 
 			"    emp.referenceName,\r\n" + 
 			"    emp.dateOfJoining,eBank.accountType,eBank.bankId,eBank.accountNumber,eBank.ifscCode,\r\n" + 
 			"     GROUP_CONCAT(DISTINCT eIdProofs.idTypeId SEPARATOR ',') as IdTypeeIdProofs, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eIdProofs.idNumber SEPARATOR ',') as IdNumbereIdProofs, \r\n" + 
 			"     GROUP_CONCAT(DISTINCT eStatuary.statuaryType SEPARATOR ',') as statuaryType, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eStatuary.statuaryNumber SEPARATOR ',') as statuaryNumber,\r\n" + 
 			"                    GROUP_CONCAT(  ePayStructure.payHeadId SEPARATOR ',') as payHeadId,\r\n" + 
 			"                           GROUP_CONCAT(  ePayStructure.amount SEPARATOR ',') as amount\r\n" + 
 			"\r\n" + 
 			"FROM\r\n" + 
 			"    Employee emp\r\n" + 
 			"LEFT JOIN PayStructureHd ph ON\r\n" + 
 			"    ph.employeeId = emp.employeeId AND(\r\n" + 
 			"        ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE\r\n" + 
 			"    ) AND(\r\n" + 
 			"        ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE\r\n" + 
 			"    ) AND ph.activeStatus = 'AC'\r\n" + 
 			"    LEFT JOIN PayStructure ePayStructure ON\r\n" + 
 			"    ePayStructure.payStructureHdId = ph.payStructureHdId\r\n" + 
 			"    \r\n" + 
 			"    LEFT  JOIN EmployeeIdProofs eIdProofs ON\r\n" + 
 			"    eIdProofs.employeeId =emp.employeeId\r\n" + 
 			" LEFT  JOIN EmployeeStatuary eStatuary ON\r\n" + 
 			"     eStatuary.employeeId=  emp.employeeId\r\n" + 
 			"LEFT   JOIN EmployeeBank eBank ON\r\n" + 
 			"    eBank.employeeId = emp.employeeId AND (eBank.activeStatus='AC' AND eBank.accountType='SA')\r\n" + 
 			"  \r\n" + 
 			"LEFT JOIN Address addrs ON\r\n" + 
 			"    addrs.addressId = emp.presentAddressId\r\n" + 
 			"LEFT JOIN State state ON\r\n" + 
 			"    state.stateId = emp.stateId\r\n" + 
 			"LEFT JOIN City city ON\r\n" + 
 			"    city.cityId = emp.cityId\r\n" + 
 			"LEFT JOIN Country addrsCountry ON\r\n" + 
 			"    addrsCountry.countryId = addrs.countryId\r\n" + 
 			"LEFT JOIN State addrsState ON\r\n" + 
 			"    addrsState.stateId = addrs.stateId\r\n" + 
 			"LEFT JOIN City addrsCity ON\r\n" + 
 			"    addrsCity.cityId = addrs.cityId\r\n" + 
 			"LEFT JOIN Department dept ON\r\n" + 
 			"    dept.departmentId = emp.departmentId\r\n" + 
 			"LEFT JOIN Designation designation ON\r\n" + 
 			"    designation.designationId = emp.designationId\r\n" + 
 			"  WHERE emp.companyId =?1 AND emp.departmentId =?2\r\n" + 
 			"    and \r\n" + 
 			"          emp.activeStatus =?3 AND(\r\n" + 
 			"            emp.dateOfJoining >= ?4 AND emp.dateOfJoining <=?5)\r\n" + 
 			"    \r\n" + 
 			"    \r\n" + 
 			"        GROUP BY\r\n" + 
 			"            emp.employeeId,\r\n" + 
 			"            eBank.bankId,\r\n" + 
 			"            eBank.accountType,\r\n" + 
 			"            eBank.ifscCode,\r\n" + 
 			"            eBank.accountNumber";
 	
 	String findEmployeesReportStatusAndDurationBased ="SELECT\r\n" + 
 			"    emp.employeeCode,\r\n" + 
 			"    emp.firstName,\r\n" + 
 			"    emp.middleName,\r\n" + 
 			"    emp.lastName,\r\n" + 
 			"    emp.dateOfBirth,\r\n" + 
 			"    emp.gender,\r\n" + 
 			"    emp.maritalStatus,\r\n" + 
 			"    addrs.addressText,\r\n" + 
 			"    addrs.landmark,\r\n" + 
 			"    addrsCountry.countryName,\r\n" + 
 			"    addrsState.stateName,\r\n" + 
 			"    addrsCity.cityName,\r\n" + 
 			"    addrs.pincode,\r\n" + 
 			"    addrs.mobile,\r\n" + 
 			"    addrs.telephone,\r\n" + 
 			"    addrs.emailId,\r\n" + 
 			"    state.stateName AS jobLocationState,\r\n" + 
 			"    city.cityName AS jobLocationCity,\r\n" + 
 			"    emp.bloodGroup,\r\n" + 
 			"    emp.probationDays,\r\n" + 
 			"    emp.empType,\r\n" + 
 			"    dept.departmentName,\r\n" + 
 			"    designation.designationName,\r\n" + 
 			"    emp.contractOverDate,\r\n" + 
 			"    emp.referenceName,\r\n" + 
 			"    emp.dateOfJoining,eBank.accountType,eBank.bankId,eBank.accountNumber,eBank.ifscCode,\r\n" + 
 			"     GROUP_CONCAT(DISTINCT eIdProofs.idTypeId SEPARATOR ',') as IdTypeeIdProofs, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eIdProofs.idNumber SEPARATOR ',') as IdNumbereIdProofs, \r\n" + 
 			"     GROUP_CONCAT(DISTINCT eStatuary.statuaryType SEPARATOR ',') as statuaryType, \r\n" + 
 			"    GROUP_CONCAT(DISTINCT eStatuary.statuaryNumber SEPARATOR ',') as statuaryNumber,\r\n" + 
 			"                    GROUP_CONCAT(  ePayStructure.payHeadId SEPARATOR ',') as payHeadId,\r\n" + 
 			"                           GROUP_CONCAT(  ePayStructure.amount SEPARATOR ',') as amount\r\n" + 
 			"\r\n" + 
 			"FROM\r\n" + 
 			"    Employee emp\r\n" + 
 			"LEFT JOIN PayStructureHd ph ON\r\n" + 
 			"    ph.employeeId = emp.employeeId AND(\r\n" + 
 			"        ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE\r\n" + 
 			"    ) AND(\r\n" + 
 			"        ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE\r\n" + 
 			"    ) AND ph.activeStatus = 'AC'\r\n" + 
 			"    LEFT JOIN PayStructure ePayStructure ON\r\n" + 
 			"    ePayStructure.payStructureHdId = ph.payStructureHdId\r\n" + 
 			"    \r\n" + 
 			"    LEFT  JOIN EmployeeIdProofs eIdProofs ON\r\n" + 
 			"    eIdProofs.employeeId =emp.employeeId\r\n" + 
 			" LEFT  JOIN EmployeeStatuary eStatuary ON\r\n" + 
 			"     eStatuary.employeeId=  emp.employeeId\r\n" + 
 			"LEFT   JOIN EmployeeBank eBank ON\r\n" + 
 			"    eBank.employeeId = emp.employeeId AND (eBank.activeStatus='AC' AND eBank.accountType='SA')\r\n" + 
 			"  \r\n" + 
 			"LEFT JOIN Address addrs ON\r\n" + 
 			"    addrs.addressId = emp.presentAddressId\r\n" + 
 			"LEFT JOIN State state ON\r\n" + 
 			"    state.stateId = emp.stateId\r\n" + 
 			"LEFT JOIN City city ON\r\n" + 
 			"    city.cityId = emp.cityId\r\n" + 
 			"LEFT JOIN Country addrsCountry ON\r\n" + 
 			"    addrsCountry.countryId = addrs.countryId\r\n" + 
 			"LEFT JOIN State addrsState ON\r\n" + 
 			"    addrsState.stateId = addrs.stateId\r\n" + 
 			"LEFT JOIN City addrsCity ON\r\n" + 
 			"    addrsCity.cityId = addrs.cityId\r\n" + 
 			"LEFT JOIN Department dept ON\r\n" + 
 			"    dept.departmentId = emp.departmentId\r\n" + 
 			"LEFT JOIN Designation designation ON\r\n" + 
 			"    designation.designationId = emp.designationId\r\n" + 
 			"  WHERE emp.companyId =?1 " + 
 			"    and \r\n" + 
 			"          emp.activeStatus =?2 AND(\r\n" + 
 			"            emp.dateOfJoining >= ?3 AND emp.dateOfJoining <=?4)\r\n" + 
 			"    \r\n" + 
 			"    \r\n" + 
 			"        GROUP BY\r\n" + 
 			"            emp.employeeId,\r\n" + 
 			"            eBank.bankId,\r\n" + 
 			"            eBank.accountType,\r\n" + 
 			"            eBank.ifscCode,\r\n" + 
 			"            eBank.accountNumber";
 	
 	@Query("from Employee where companyId=?1 and activeStatus=?2 ORDER BY  employeeId  DESC ") 
 	public List<Employee> findEmployeesReportStatusBased11(Long companyId,String status);
 	//@Query(value=findEmployeesReportDeptAndStatusBased,nativeQuery = true)
 	
 	 	@Query("from Employee where companyId=?1 and departmentId=?2 and activeStatus=?3  AND(dateOfJoining >=?4 AND dateOfJoining <=?5)  ORDER BY  employeeId  DESC") 
 	 	public List<Employee> findEmployeesReportDeptAndStatusBased(Long companyId,Long departmentId, 
 				 String status, Date fromDate1, Date toDate1);
 	 	
 	 
 		// @Query(value=findEmployeesReportStatusAndDurationBased,nativeQuery = true)
 	 	@Query("from Employee where companyId=?1   and activeStatus=?2  AND(dateOfJoining >=?3 AND dateOfJoining <=?4)  ORDER BY  employeeId  DESC") 
 	 	public List<Employee> findEmployeesReportStatusAndDurationBased(Long companyId, 
 				 String status, Date fromDate1, Date toDate1);
 	 	
 		@Query("from Employee where companyId=?1   and activeStatus=?2  AND(dateUpdate >=?3 AND dateUpdate <=?4)  ORDER BY  employeeId  DESC") 
 	 	public List<Employee> findDeactivateEmployeesReportDurationBased(Long companyId, 
 				 String status, Date fromDate1, Date toDate1);
 	 	
 		@Query("from Employee where companyId=?1 and departmentId=?2 and activeStatus=?3  AND(dateUpdate >=?4 AND dateUpdate <=?5)  ORDER BY  employeeId  DESC") 
 	 	public List<Employee> findDeactivateEmployeesReportDurationAndDeptBased(Long companyId,Long departmentId, 
 				 String status, Date fromDate1, Date toDate1);
 		
 		
 		@Query(value=empAttendanceRatio,nativeQuery = true)
 		public List<Object[]> empAttendanceRatio(@Param(value = "p_comp_id") Long p_comp_id,@Param(value = "p_emp_id") Long p_emp_id);		 
}