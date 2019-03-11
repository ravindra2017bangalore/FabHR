package com.csipl.hrms.authorization.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.authorization.ObjectInSystemDTO;
import com.csipl.hrms.model.authoriztion.ObjectsInSystem;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.ObjectInSystemAdaptor;
import com.csipl.hrms.service.authorization.ObjectInSystemService;
 
@RequestMapping("/objectInSystem")
@RestController
public class ObjectInSystemController extends BaseController {
	ObjectInSystemAdaptor objectInSystemAdaptor=new ObjectInSystemAdaptor();

 	@Autowired
 	ObjectInSystemService objectInSystemService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void   objectInSystem(@RequestBody ObjectInSystemDTO objectInSystemDto, HttpServletRequest req) {
		ObjectsInSystem objectsInSystem=objectInSystemAdaptor.uiDtoToDatabaseModel(objectInSystemDto);
			setUserProfileWithoutCG(objectsInSystem, req);
		    objectInSystemService.save(objectsInSystem);
  	}
 	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ObjectInSystemDTO>  findAllObjectsInSystems( HttpServletRequest req) {
 		return objectInSystemAdaptor.databaseModelToUiDtoList(objectInSystemService.getAllObjectInSystems());
   	}
 }
