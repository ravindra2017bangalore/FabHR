package com.csipl.hrms.service.authorization;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.service.authorization.repository.AdditionalUserObjectRepository;

@Transactional
@Service("additionalUserObjectService")
public class AdditionalUserObjectServiceImpl  implements AdditionalUserObjectService{
	@Autowired
	  private AdditionalUserObjectRepository additionalUserObjectRepository;

	@Override
	public List<AdditionalUserObject> findAdditionaluserObject() {
		
		return additionalUserObjectRepository.findAdditionaluserObject();
	}
	@Override
	public void save(List<AdditionalUserObject> additionalUserObjectList) {
		
		  additionalUserObjectRepository.save(additionalUserObjectList);
		
	}
 
}
