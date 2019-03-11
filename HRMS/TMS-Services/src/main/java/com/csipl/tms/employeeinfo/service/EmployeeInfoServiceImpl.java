/*package com.csipl.tms.employeeinfo.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.tms.employeeinfo.repository.EmployeeInfoRepository;

@Transactional
@Service("employeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	EmployeeInfoRepository employeeInfoRepository;

	@Override
	public List<Object[]> findEmployeeId(Long companyId) {

		return employeeInfoRepository.findEmployeeId(companyId);
	}

}
*/