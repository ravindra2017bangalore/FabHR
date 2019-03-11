package com.csipl.hrms.service.organization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.EmployeeAsset;
import com.csipl.hrms.model.organisation.DeptDesignation;
import com.csipl.hrms.service.organization.repository.DeptDesignationRepository;

@Service("deptDesignationService")
public class DeptDesignationServiceImpl implements  DeptDesignationService{
	@Autowired
	DeptDesignationRepository deptDesignationRepository;
	@Override
	public List<DeptDesignation> saveAll(List<DeptDesignation> deptDesignationList) {
		List<DeptDesignation> deptDesignationObjList = (List<DeptDesignation>) deptDesignationRepository.save(deptDesignationList);
		return deptDesignationObjList;
	}
	@Override
	public List<Object[]> findAllDeptDesignation(Long companyId) {
		// TODO Auto-generated method stub
		return deptDesignationRepository.findAllDeptDesignation(companyId);
	}
	@Override
	public List<DeptDesignation> findAllDeptbasedDesignation(Long companyId, Long departmentId) {
		// TODO Auto-generated method stub
		return deptDesignationRepository.AllDeptbasedDesignation(companyId,departmentId);
	}
 
}
