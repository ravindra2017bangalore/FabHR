package com.csipl.hrms.service.authorization;

import java.util.List;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;

public interface ObjectInSystemService {
 	public List<ObjectsInSystem> getAllObjectInSystems();

	 public ObjectsInSystem save(ObjectsInSystem objectsInSystem);
	 public ObjectsInSystem update(ObjectsInSystem objectsInSystem);

}
