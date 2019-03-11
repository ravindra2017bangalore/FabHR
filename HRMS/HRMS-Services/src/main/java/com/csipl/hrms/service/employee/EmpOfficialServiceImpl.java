package com.csipl.hrms.service.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.hrms.service.employee.repository.EmployeeStatuaryRepository;
@Transactional
@Service("empOfficialService")
public class EmpOfficialServiceImpl implements EmpOfficialService{
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

	@Autowired
	EmployeePersonalInformationRepository empRepository;
	
	@Autowired
	EmployeeStatuaryRepository empStatutoryRepository;
	@Override
	public void saveOfficialInfo(Employee employee, List<EmployeeStatuary> statutoryList) {
		//System.out.println("employee inside emloyeeServImpl..."+employee.toString());
		Employee employeeNew=empRepository.save(employee);
	//	System.out.println("employee aftr save emloyeeServImpl..."+employeeNew.toString());
		List<EmployeeStatuary> employeeStatuaryInfos = (List<EmployeeStatuary>) empStatutoryRepository
				.save(statutoryList);
	}
 
}
