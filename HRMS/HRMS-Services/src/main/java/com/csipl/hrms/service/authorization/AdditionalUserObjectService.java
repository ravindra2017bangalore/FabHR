package com.csipl.hrms.service.authorization;

import java.util.List;

import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.payroll.ProfessionalTax;

public interface AdditionalUserObjectService {
	 public List<AdditionalUserObject> findAdditionaluserObject();
	// public AdditionalUserObject save(AdditionalUserObject additionalUserObject);
	 public void save(List<AdditionalUserObject> AdditionalUserObject);
}
