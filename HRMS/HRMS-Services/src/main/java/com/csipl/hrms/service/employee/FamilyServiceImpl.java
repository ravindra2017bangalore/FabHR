package com.csipl.hrms.service.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.service.payroll.repository.FamilyRepository;

@Service("familyService")
public class FamilyServiceImpl implements FamilyService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

	@Autowired
	FamilyRepository familyRepository;
	/**
	 * Method performed save OR update operation  
 	 */
 	@Override
	public List<EmployeeFamily> saveAll(List<EmployeeFamily> employeeFamilyList) {
 		logger.info("employeeFamilyList is ===== "+employeeFamilyList);
 		List<EmployeeFamily> employeeFamilyInfos = (List<EmployeeFamily>) familyRepository.save(employeeFamilyList);
		return employeeFamilyInfos;
 	}
 	/**
	 * to get List of EmployeeFamily from database based on employeeId
	 */
 	@Override
	public List<EmployeeFamily> findAllEmployeeDetails(String empId) {
 		logger.info("findAllEmployeeDetails is ===== "+empId);
 		Long employeeId=Long.parseLong(empId);
		return familyRepository.findAllEmployeeFamilyList(employeeId);
	}
 	/**
	 * delete EmployeeFamily object from database based on familyId (Primary Key)
	 */
	@Override
	public void delete(Long familyId) {
 		familyRepository.delete(familyId);
	}
	@Override
	public EmployeeFamily findFamily(Long familyId) {
		
		return familyRepository.findOne(familyId);
	}
}
