package com.csipl.hrms.service.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.Kra;
import com.csipl.hrms.service.adaptor.KraAdaptor;
import com.csipl.hrms.service.employee.repository.KraRepository;

@Service("kraService")
public class KraServiceImpl implements KraService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(KraServiceImpl.class);

	@Autowired
	private KraRepository kraRepository;
	KraAdaptor kraAdaptor = new KraAdaptor();

	/**
	 * Method performed save OR update operation  
 	 */
	@Override
	public Kra save(Kra kra) {
		logger.info("Kra is ===== "+kra);
		return kraRepository.save(kra);
	}
	/**
	 * to get List of Kra from database based on companyId
	 */
	@Override
	public List<Kra> findAllKra(Long companyId) {
		logger.info("AllKra is ===== "+companyId);
		return kraRepository.findAllKras(companyId);
	}
	/**
	 * to get  Kra Object from database based on KraId (Primary Key)
	 */
	@Override
	public Kra findKra(Long kraId) {
		return kraRepository.findOne(kraId);
	}

}