package com.csipl.hrms.service.organization;

import java.util.List;
import com.csipl.hrms.model.organisation.Designation;

public interface DesignationService {
	public Designation save(Designation designation);
 	public List<Designation> findAllDesignation(Long companyId);
 	public List<Designation> designationListBasedOnDepartmnt(Long companyId,Long departmentId);

}
