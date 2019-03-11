package com.csipl.hrms.service.employee;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.employee.EmpHierarchyDTO;
import com.csipl.hrms.model.employee.Employee;
 
public interface EmployeePersonalInformationService {
	public Employee save(Employee employee , MultipartFile file , boolean fileFlag) throws ErrorHandling;
	public List<Object[]> findAllPersonalInformationDetails(Long companyId);
 	public Employee findEmployees(String  employeeCode, Long companyId);
 	public Employee findEmployeesById( long employeeId );
 	public void saveAll(List<Employee> employeeList);
 	public List<Employee> findAllEmpByDeptId(Long companyId,Long departmentId);

	public List<Employee> getAllDeactivateEmployees(Long companyId);
 	public List<Employee> fetchEmployee(Long companyId);
 	//public Long findEmployeeNoticePeriod(Long  employeeId);
 	public Employee getEmployeeInfo(Long employeeId);
 	public Long aadharCheck(String  adharNumber,Long employeeId);
 	public List<Object[]> searchEmployee( Long companyId );
 	public List<Employee> findBirthDayEmployees( Long companyId  );
 	public List<Employee> findAnniversaryEmployees( Long companyId  );
 	public List<Employee> findJoiningAnniversaryEmployees(Long companyId);
	public Long checkPayRollForEmployeeJoining(Long companyId, String dateStringWithYYYYMMDD, Long departmentId);
	public  List<EmpHierarchyDTO>  orgHierarchyList(Long employeeId);
	public void saveCandidateImage(Long candidateId, MultipartFile file);
	public List<Object[]> getOnBoardProgessBar(Long progressBar);
	public void onboardMail(Employee employee);
	public  Object[] getEmpShiftName(Long employeeId);
	public List<Object[]> getEmpReportingToEmail(Long employeeId);
	
	
}
 