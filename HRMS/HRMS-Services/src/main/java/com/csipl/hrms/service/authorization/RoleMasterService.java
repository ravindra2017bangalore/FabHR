package com.csipl.hrms.service.authorization;

import java.util.List;
import com.csipl.hrms.model.authoriztion.RoleMaster;

public interface RoleMasterService {
 	public List<RoleMaster> getAllRoleMasters();

	 public RoleMaster save(RoleMaster roleMaster);
	 public RoleMaster update(RoleMaster roleMaster);

}
