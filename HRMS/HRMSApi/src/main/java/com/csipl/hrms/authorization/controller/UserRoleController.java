package com.csipl.hrms.authorization.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.authorization.UserRoleDTO;
import com.csipl.hrms.dto.organisation.RoleMasterDTO;
import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.RoleAdaptor;
import com.csipl.hrms.service.adaptor.UserAdaptor;
import com.csipl.hrms.service.adaptor.UserRoleAdaptor;
import com.csipl.hrms.service.authorization.LoginService;
import com.csipl.hrms.service.authorization.RoleMasterService;
import com.csipl.hrms.service.authorization.UserRoleService;
import com.csipl.hrms.service.users.UserService;

@RestController
public class UserRoleController extends BaseController {
	@Autowired
	LoginService loginService;

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	RoleMasterService roleMasterService;

	@Autowired
	UserService userService;

	RoleAdaptor roleAdaptor = new RoleAdaptor();
	UserAdaptor userAdaptor = new UserAdaptor();
	UserRoleAdaptor userRoleAdaptor = new UserRoleAdaptor();

	/*
	 * @RequestMapping(path = "/user", method = RequestMethod.GET) public
	 * List<UserDTO> user(HttpServletRequest req) { return
	 * userAdaptor.databaseModelToUiDtoList(loginService.getAllUsers()); }
	 */

	@RequestMapping(path = "/role", method = RequestMethod.GET)
	public List<RoleMasterDTO> role(HttpServletRequest req) {
		return roleAdaptor.databaseModelToUiDtoList(roleMasterService.getAllRoleMasters());
	}

	@RequestMapping(path = "/userRole", method = RequestMethod.GET)
	public List<UserRoleDTO> userRole(HttpServletRequest req) {
		List<UserRoleDTO> userRoleDtoList = userRoleAdaptor
				.databaseModelToUiDtoList(userRoleService.findAllUserRoles());
		return userRoleDtoList;
	}

	@RequestMapping(path = "/userRole", method = RequestMethod.POST)
	public void save(@RequestBody List<UserRoleDTO> userRoleDtoList, HttpServletRequest req) {
		List<UserRole> userRoleList = userRoleAdaptor.uiDtoToDatabaseModelList(userRoleDtoList);
		userRoleService.saveAll(userRoleList);
	}

	@RequestMapping(path = "/userRoles", method = RequestMethod.GET)
	public List<UserRoleDTO> userRoles(@RequestParam("employeeId") String employeeId, HttpServletRequest req) {
		Long empId = Long.parseLong(employeeId);
		List<UserRole> UserRoleList = userRoleService.findUserRoles(empId);
		List<UserRoleDTO> userRoleDtoList = userRoleAdaptor.databaseModelToUiDtoList(UserRoleList);
		return userRoleDtoList;
	}

	@RequestMapping(path = "/userRoles", method = RequestMethod.DELETE)
	public void deleteUserRole(@RequestParam("userRolesSrNo") String userRolesSrNo, HttpServletRequest req) {
		Long longUserRolesSrNo = Long.parseLong(userRolesSrNo);
		userRoleService.delete(longUserRolesSrNo);
	}

	@RequestMapping(path = "/userLOV", method = RequestMethod.GET)
	public Long user(@RequestParam("employeeId") String employeeId, HttpServletRequest req) {
		Long empId = Long.parseLong(employeeId);
		Long userId = userService.findUserRoles(empId);
 		return userId;
	}
}
