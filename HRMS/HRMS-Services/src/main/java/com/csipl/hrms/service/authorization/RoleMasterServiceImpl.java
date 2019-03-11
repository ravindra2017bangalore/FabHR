package com.csipl.hrms.service.authorization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.service.authorization.repository.RoleMasterRepository;

@Service("roleMasterService")
public class RoleMasterServiceImpl implements RoleMasterService {

	/* @Autowired
	  private RoleMasterRepository roleMasterRepository; */
	
	@Override
	public List<RoleMaster> getAllRoleMasters() {
 		// return roleMasterRepository.findAllRoleMasters();
		return null;
 	}

	@Override
	public RoleMaster save(RoleMaster roleMaster) {
 		//return roleMasterRepository.save(roleMaster);
		return null;
	}

	@Override
	public RoleMaster update(RoleMaster roleMaster) {
 		return null;
	}

}
