package com.csipl.hrms.authorization.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.util.UserAccessHelper;

@RestController
public class UserPermissionController {

	@RequestMapping(path = "/user/userpermission", method = RequestMethod.GET)
	public UserDTO findUserPermission(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDTO userdto = new UserDTO();
		if (session.getAttribute("User") != null) {
			User user = (User) session.getAttribute("User");
			UserAccessHelper userAccessHelper = new UserAccessHelper();
			userdto = userAccessHelper.setRolePermissionForUIUser(userdto, user);
		} else {
/*//			 Set<String>	roles = new HashSet<String>();
//			 Set<String>	permissions	= new HashSet<String>();
//			 roles.add("ESSUser");
//			 
//			 userdto.setRoles(roles);
//				userdto.setPermissions(permissions);
//				userdto.setNameOfUser( "COM-27" );
*/		}

		return userdto;
	}
}
