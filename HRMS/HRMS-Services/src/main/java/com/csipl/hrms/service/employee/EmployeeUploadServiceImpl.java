package com.csipl.hrms.service.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.authorization.repository.RoleMasterRepository;
import com.csipl.hrms.service.authorization.repository.UserRoleRepository;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.employee.repository.UserRepository;

@Transactional
@Service("employeeUploadService")
public class EmployeeUploadServiceImpl implements EmployeeUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeUploadServiceImpl.class);

	@Autowired
	private EmployeePersonalInformationRepository employeePersonalInformationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MasterBookRepository masterBookRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Override
	public void saveAll(List<Employee> employeeList, List<User> userList, MasterBook masterBook,List<UserRole> userRoleList) {
 		employeePersonalInformationRepository.save(employeeList);
		userRepository.save(userList);
		userRoleRepository.save(userRoleList);
		if (masterBook != null)
			masterBookRepository.save(masterBook);
  	}
 	@Override
	public MasterBook findMasterBook(String bookCode, Long companyId, String bookType) {
		return masterBookRepository.getMasterBook(companyId, bookCode, bookType);
	}
 
}
