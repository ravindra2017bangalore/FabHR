package com.csipl.hrms.service.authorization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
//import com.csipl.hrms.service.authorization.repository.ObjectInSystemRepository;

@Service("objectInSystemService")
public class ObjectInSystemServiceImpl implements ObjectInSystemService {

	/*@Autowired
	  private ObjectInSystemRepository objectInSystemRepository;
	*/
	@Override
	public List<ObjectsInSystem> getAllObjectInSystems() {
 		 return null;
 	}

	@Override
	public ObjectsInSystem save(ObjectsInSystem objectsInSystem) {
 		return null;
	}

	@Override
	public ObjectsInSystem update(ObjectsInSystem objectsInSystem) {
 		return null;
	}


}
