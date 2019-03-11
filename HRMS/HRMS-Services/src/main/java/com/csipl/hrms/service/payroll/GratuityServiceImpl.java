package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.payroll.Gratuaty;
import com.csipl.hrms.service.payroll.repository.GratuityRepository;

@Service("gratuityService")
public class GratuityServiceImpl implements GratuityService {

	@Autowired
	private GratuityRepository gratuityRepository;
	/**
	 * to get List of gratuity Objects from database based on companyId
	 */
	@Override
	public List<Gratuaty> getAllGratuity(Long companyId) {
		return gratuityRepository.findAllGratuity(companyId);

	}
	/**
	 * Save OR update gratuaty object  into Database 
	 */
	@Override
	public Gratuaty save(Gratuaty gratuaty) {
		return gratuityRepository.save(gratuaty);
	}
 	 
}
