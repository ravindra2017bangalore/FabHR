package com.csipl.hrms.service.organization;

import java.util.List;

import com.csipl.hrms.model.organisation.DeptDesignation;

public interface DeptDesignationService {
	public List<DeptDesignation> saveAll(List<DeptDesignation> deptDesignation);
	public List<Object[]> findAllDeptDesignation(Long companyId);
	public List<DeptDesignation> findAllDeptbasedDesignation(Long companyId ,Long departmentId);
}
