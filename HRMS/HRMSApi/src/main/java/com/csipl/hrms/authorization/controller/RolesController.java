package com.csipl.hrms.authorization.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.authorization.AdditionalUserObjectDTO;
import com.csipl.hrms.dto.authorization.ObjectInSystemDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.service.adaptor.AdditionalUserObjectAdaptor;
import com.csipl.hrms.service.adaptor.UserAdaptor;
import com.csipl.hrms.service.authorization.AdditionalUserObjectService;
import com.csipl.hrms.service.authorization.LoginService;
@RestController
public class RolesController {
	@Autowired
	LoginService loginService;
	@Autowired
	AdditionalUserObjectService additionalUserObjectService;
	
	AdditionalUserObjectAdaptor additionalUserObjectAdaptor =new AdditionalUserObjectAdaptor();
	UserAdaptor userAdaptor = new UserAdaptor();
	
	
	@RequestMapping(path = "/additionalUserObj", method = RequestMethod.POST)
	public void save(@RequestBody List<AdditionalUserObjectDTO> additionalUserObjectDtoList, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
      List<AdditionalUserObject> additionalUserObjectList = additionalUserObjectAdaptor.uiDtoToDatabaseModelList(additionalUserObjectDtoList);
      for (AdditionalUserObject additionalUserObject : additionalUserObjectList) {
    	  additionalUserObject.setSUserId(user.getUserId());
    	  } 
     additionalUserObjectService.save(additionalUserObjectList);
   }	
	
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public List<UserDTO> user( HttpServletRequest req ) {
		List<UserDTO> userList=	userAdaptor.databaseModelToUiDtoList(loginService.getAllUsers());
		for (UserDTO userDTO : userList) {
			System.out.println(userDTO.getUsername());
			System.out.println(userDTO.getPassword());
			
		}
		return userList;
    	 	
	}
	@RequestMapping(path = "/additionalUserObj", method = RequestMethod.GET)
	public @ResponseBody List<AdditionalUserObjectDTO>  findAllAdditionalUserObject( HttpServletRequest req) {
 		return additionalUserObjectAdaptor.databaseModelToUiDtoList(additionalUserObjectService.findAdditionaluserObject());
   	}
}
