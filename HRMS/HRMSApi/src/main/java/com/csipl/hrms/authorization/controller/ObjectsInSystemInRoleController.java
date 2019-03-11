package com.csipl.hrms.authorization.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.dto.authorization.ObjectsInSystemInRoleDTO;
import com.csipl.hrms.model.authoriztion.ObjectsInSystemInRole;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.ObjectsInSystemInRoleAdaptor;
import com.csipl.hrms.service.authorization.ObjectsInSystemInRoleService;

@RequestMapping("/objectsInSystemInRole")
@RestController
public class ObjectsInSystemInRoleController {

	ObjectsInSystemInRoleAdaptor objectsInSystemInRoleAdaptor = new ObjectsInSystemInRoleAdaptor();
	
	@Autowired
	ObjectsInSystemInRoleService objectsInSystemInRoleService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveObjectsInSystemInRole(@RequestBody List<ObjectsInSystemInRoleDTO> objectsInSystemInRoleDtoList, HttpServletRequest req) {
		List<ObjectsInSystemInRole> objectsInSystemInRoleList = objectsInSystemInRoleAdaptor.uiDtoToDatabaseModelList(objectsInSystemInRoleDtoList);
		
		objectsInSystemInRoleService.saveAllObjectsInSystemInRole(objectsInSystemInRoleList);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ObjectsInSystemInRoleDTO> getAllObjectsInSystemInRole() {
		return objectsInSystemInRoleAdaptor.databaseModelToUiDtoList(objectsInSystemInRoleService.findAllObjectsInSystemInRole());
	}
}
