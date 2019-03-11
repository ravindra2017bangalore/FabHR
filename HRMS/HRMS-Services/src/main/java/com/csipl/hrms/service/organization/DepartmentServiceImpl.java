package com.csipl.hrms.service.organization;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.service.organization.repository.DepartmentRepository;

 
 
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;
 	@Override
 	/**
	 * Save OR update department object  into Database 
	 */
	public Department save(Department  department) {
 		return departmentRepository.save(department);
  	}
	/**
	 * To get List of departments from Database based on company
	 */
  	@Override
	public List<Department> findAllDepartment(Long companyId) {
   		return departmentRepository.findAllDepartment(companyId ); 
  	}
	/**
	 * To Department from Database based on departmentId (Primary key)
	 */
	@Override
	public Department findDepartment(Long departmentId) {
 		return  departmentRepository.findOne(departmentId);
	}
	/**
	 * To get List of departments from Database based on processMonth and companyId
	 */
	@Override
	public  List<Department> findDepartmentByProcessMonth(String processMonth,Long companyId) {
 		return departmentRepository.findDepartment(processMonth);//,companyId
	}
  }
  
   
 