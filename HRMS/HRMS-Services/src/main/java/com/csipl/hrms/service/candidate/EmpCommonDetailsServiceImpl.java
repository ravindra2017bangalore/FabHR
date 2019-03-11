package com.csipl.hrms.service.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.EmpCommonDetail;
import com.csipl.hrms.service.candidate.repository.EmpCommonDetailsRepository;

@Service("empCommonDetailsService")
public class EmpCommonDetailsServiceImpl implements EmpCommonDetailsService{

	@Autowired
	EmpCommonDetailsRepository  empCommonDetailsRepository ;
	
	@Override
	public void save(EmpCommonDetail empCommonDetail) {
		empCommonDetailsRepository.save(empCommonDetail);
	}

}
