package com.csipl.hrms.service.employee;

import com.csipl.hrms.model.employee.EmployeeAsset;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.ProfessionalInformation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.service.employee.repository.EmployeeAssetRepository;



@Service("employeeAssetService")
public class EmployeeAssetServiceImpl  implements EmployeeAssetService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAssetServiceImpl.class);
	@Autowired
	  private EmployeeAssetRepository employeeAssetRepository;

	
	/**
	 * Save OR update List of EmployeeAsset objects into Database
	 */
	@Override
	public List<EmployeeAsset> saveAll(List<EmployeeAsset> employeeAssetList) {
		logger.info("EmployeeAssetList is ===== "+employeeAssetList);
		List<EmployeeAsset> employeeAssetInfos = (List<EmployeeAsset>) employeeAssetRepository.save(employeeAssetList);
		return employeeAssetInfos;
	}
	/**
	 * To get List of EmployeeAssets from Database based on employeeId
	 */
	@Override
	public List<EmployeeAsset> findAllemployeeAssets(String empId) {
		Long employeeId=Long.parseLong(empId);
		
		return employeeAssetRepository.findAllEmpAssets(employeeId);
	}

	@Override
	public EmployeeAsset update(EmployeeAsset employeeAsset) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * delete Employee Asset from database based on assetsId (primary key)
	 */
	@Override
	public void delete(Long assetsId) {
		employeeAssetRepository.delete(assetsId);
		
	}
	

}
