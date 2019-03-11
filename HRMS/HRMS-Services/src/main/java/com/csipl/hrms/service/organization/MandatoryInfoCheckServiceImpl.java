package com.csipl.hrms.service.organization;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;

@Service("mandatoryInfoCheckService")
public class MandatoryInfoCheckServiceImpl implements MandatoryInfoCheckService{
	private static final Logger logger = LoggerFactory.getLogger(MandatoryInfoCheckServiceImpl.class);

	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;
	
	@Override
	public MandatoryInfoCheck updateMandatoryInfoCheck(Long employeeId) {
		return mandatoryInfoCheckRepository.getMandatoryInfoCheck(employeeId);	
	}


	


}
