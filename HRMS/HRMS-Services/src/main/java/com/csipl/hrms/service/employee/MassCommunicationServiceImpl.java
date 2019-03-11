package com.csipl.hrms.service.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.employee.MassCommunication;
import com.csipl.hrms.service.employee.repository.MassCommunicationRepository;

@Service("massCommunicationService")
public class MassCommunicationServiceImpl implements MassCommunicationService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(MassCommunicationServiceImpl.class);

	@Autowired
	private MassCommunicationRepository massCommunicationRepository;
	
	/**
	 * Method performed save OR update operation  
 	 */
	@Override
	public MassCommunication save(MassCommunication massCommunication) {
		logger.info("save massCommunication===== "+massCommunication);
		return massCommunicationRepository.save(massCommunication);
	}
	/**
	 * to get List of MassCommunications from database based on companyId
	 */
	@Override
	public List<MassCommunication> getAllMassCommunications(Long companyId) {
		logger.info(" massCommunicationList ===== "+companyId);
		return massCommunicationRepository.findAllMassCommunications(companyId);
	}
	
	
}