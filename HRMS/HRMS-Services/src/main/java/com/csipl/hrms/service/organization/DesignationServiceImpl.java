package com.csipl.hrms.service.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.service.organization.repository.DesignationRepository;

@Service("designationService")
public class DesignationServiceImpl implements DesignationService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DesignationServiceImpl.class);

	@Autowired
	private DesignationRepository designationRepository;

	/**
	 * Save OR update designation object into Database
	 */
	@Override
	public Designation save(Designation designation) {
		return designationRepository.save(designation);
	}
	/**
	 * To get List of designations from Database based on companyId
	 */
	@Override
	public List<Designation> findAllDesignation(Long companyId) {
		return designationRepository.findAllDesignations(companyId);
 	}

	/**
	 * To get List of designations from Database based on companyId and departmentId
	 */
	@Override
	public List<Designation> designationListBasedOnDepartmnt(Long companyId, Long departmentId) {
		return designationRepository.designationListBasedOnDepartmnt(companyId, departmentId);
	}
}
