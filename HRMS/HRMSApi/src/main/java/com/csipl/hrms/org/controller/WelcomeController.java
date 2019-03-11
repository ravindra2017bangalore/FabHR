package com.csipl.hrms.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.authorization.LoginService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.users.UserService;
import com.csipl.hrms.util.UserAccessHelper;
 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Welcome")
public class WelcomeController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	boolean status = false;

	@Autowired
	LoginService loginService;

	@Autowired
	UserService userService;

//	@Autowired
//	LoginRepository loginRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Resource(name = "tokenStore")
	TokenStore tokenStore;

	@RequestMapping(path = "/log", method = RequestMethod.POST)
	public @ResponseBody void welcome22(HttpServletRequest req) {
		logger.info("Hi Sir Welcone ");
	}

	@RequestMapping(path = "/log1", method = RequestMethod.POST)
	public @ResponseBody void welcome11(@RequestParam("id") String id, HttpServletRequest req) {
		logger.info("Hi Sir Welcone ");
	}

	@RequestMapping(path = "/userLogOut", method = RequestMethod.GET)
	public @ResponseBody Boolean userLogOut(HttpServletRequest req) {
		logger.info("Hi Sir Welcone ");
		HttpSession session = req.getSession();
		session.setAttribute("User", null);
		session.invalidate();

		return true;
	}

	@ApiOperation(value = "welcome", response = ErrorHandling.class, notes = "User login authentication", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public @ResponseBody UserDTO welcome(@RequestBody UserDTO userForm, HttpServletRequest req) {

		Long MAX_ATTEMPTS = 0L;
		final int ATTEMPTS = 5;
		// HttpHeaders headers = new HttpHeaders();
		ErrorHandling error = new ErrorHandling();
		HttpSession session = req.getSession(true);
		UserDTO userDTO = new UserDTO();

		logger.info("Login Attentication user name  " + userForm.getUsername());
		logger.info("Login Attentication user password   " + userForm.getPassword());

	        String username = userForm.getUsername();
			String password = userForm.getPassword();

			if ((username!= null &&( !username.trim().equals("")) )&& (password!= null &&(!password.trim().equals("")))) {
				
			     User user = loginService.findUserByUserName(username.trim());
                 logger.info("Login user>>    " + user);
                 
				
             if (user != null ) {
					
				if(user.getUserAttempts() < ATTEMPTS) {	
					
				if(user.getUserPassword().equals(AppUtils.SHA1(password).trim())) {
					Employee emp = employeePersonalInformationService.findEmployees(user.getNameOfUser(),user.getCompany().getCompanyId());

					   session.setAttribute("User", user);

					if (user.getChangePassword() == null || ("").equals(user.getChangePassword())) {
						error.setErrorMessage("change");
						UserAccessHelper userAccessHelper = new UserAccessHelper();
						userDTO = userAccessHelper.setRolePermissionForUIUser(userDTO, user);
						userDTO.setCompanyId(user.getCompany().getCompanyId());
						userDTO.setUserIdUpadate(user.getUserId());
						userDTO.setUserId(user.getUserId());
						userDTO.setGroupId(user.getCompany().getGroupg().getGroupId());
						userDTO.setUserId(user.getUserId());
						userDTO.setNameOfUser(user.getNameOfUser());
						userDTO.setLoginName(user.getLoginName());
						userDTO.setUsername(emp.getFirstName() + " " + emp.getLastName());
						userDTO.setMessage("change");
						userDTO.setEmployeeId(emp.getEmployeeId());
					} else {

                            UserAccessHelper userAccessHelper = new UserAccessHelper();
							userDTO = userAccessHelper.setRolePermissionForUIUser(userDTO, user);
							userDTO.setCompanyId(user.getCompany().getCompanyId());
							userDTO.setUserIdUpadate(user.getUserId());
							userDTO.setUserId(user.getUserId());
							userDTO.setGroupId(user.getCompany().getGroupg().getGroupId());
							userDTO.setUserId(user.getUserId());
							userDTO.setNameOfUser(user.getNameOfUser());
							userDTO.setLoginName(user.getLoginName());
							userDTO.setUsername(emp.getFirstName() + " " + emp.getLastName());
 							userDTO.setEmployeeId(emp.getEmployeeId());

							
							if( user.getUserAttempts() != 0)
								userService.userAttemptsUpdate(MAX_ATTEMPTS, user.getNameOfUser());
						
							userDTO.setEmailOfUser(user.getEmailOfUser());
							userDTO.setMessage("success");
						

					}

				}
					else {
  						
					 if(user.getUserAttempts() < ATTEMPTS)
					 { 
 
						MAX_ATTEMPTS = 	user.getUserAttempts();
						logger.info("MAX_ATTEMPTS >-" + MAX_ATTEMPTS);
						MAX_ATTEMPTS = MAX_ATTEMPTS + 1;
						userService.userAttemptsUpdate(MAX_ATTEMPTS, user.getNameOfUser());
						userDTO.setUserAttempts(MAX_ATTEMPTS);
						userDTO.setMessage("You have made  " +MAX_ATTEMPTS+ "  unsuccessful attempt(s) out of 5 allowed attempts.");
						
					 }
					 else
					 {
 
 						logger.info("Error! User Blockedsss  MAX_ATTEMPTS  " + MAX_ATTEMPTS);
						userDTO.setMessage("Error! User Blocked");
					 }
						}

             }
             else {
					logger.info("Error! User Blocked  MAX_ATTEMPTS  " + MAX_ATTEMPTS);
					userDTO.setMessage("Error! User Blocked");
				}
             }
				else {
					userDTO.setMessage("Error! Invalid credentials");
					logger.info("Please Check your UserName and Password ");
				}
			}
			else {
				userDTO.setMessage("Error! Invalid credentials");
			    logger.info("Please Check your UserName and Password ");
			}

	

		return userDTO;
	}

	@RequestMapping(path = "/loginApp", method = RequestMethod.POST)
	public @ResponseBody UserDTO loginApp(@RequestBody UserDTO userForm, HttpServletRequest req) {

		// HttpHeaders headers = new HttpHeaders();
		ErrorHandling error = new ErrorHandling();
		HttpSession session = req.getSession(true);
		UserDTO userDTO = new UserDTO();
		

		logger.info("Login Attentication user name  " + userForm.getUsername());
		logger.info("Login Attentication user password   " + userForm.getPassword());

		try {
			String username = userForm.getUsername();

			String password = userForm.getPassword();

			logger.info("username=============" + username + "password===========" + password);
			if (userForm.getUsername() != null || userForm.getUsername() == "" && userForm.getPassword() != null
					|| userForm.getPassword() == "") {
				User user = loginService.findUser(username, AppUtils.SHA1(password).trim());
				// first time login 77762850e72f194e0320b19608e440b5e234b82e
				logger.info("Login user    " + user);
				if (user != null) {
					session.setAttribute("User", user);
					if (user.getChangePassword() == null || ("").equals(user.getChangePassword())) {
						error.setErrorMessage("change");
						userDTO.setMessage("change");
					} else {
						Employee emp = employeePersonalInformationService.findEmployees(user.getNameOfUser(),user.getCompany().getCompanyId());

						// error.setErrorMessage("success");
						userDTO.setEmployeeId(emp.getEmployeeId());
						userDTO.setUserId(user.getUserId());
						userDTO.setCompanyId((user.getCompany().getCompanyId()));
						userDTO.setEmployeeLogoPath(emp.getEmployeeLogoPath());
						userDTO.setCurrentRole(user.getUserRoles().get(0).getRoleMaster().getRoleDescription());
						user.getUserRoles();
						userDTO.setNameOfUser(username);
						userDTO.setEmailOfUser(user.getEmailOfUser());
						userDTO.setUsername(emp.getFirstName() + " " + emp.getLastName());
						userDTO.setMessage("success");
					}
				} else {
					error.setErrorMessage("fail");
					userDTO.setMessage("fail");
					logger.info("Please Check your UserName and Password ");
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
			error.setErrorMessage("fail");
			return null;
		}

		return userDTO;
	}

	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public  @ResponseBody UserDTO changePassword(@RequestBody UserDTO user1, HttpServletRequest req) {
    		User user = loginService.findUserByUserName(user1.getLoginName().trim());
		try {
 			String password = user1.getNewPassword();
			user.setChangePassword(user.getUserPassword());
			user.setUserPassword(AppUtils.SHA1(password));
 			loginService.create(user);
			user1.setMessage("success");

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
 			user1.setMessage("fail");
 		}
		return user1;
 	}

	@RequestMapping(path = "/updatePassword", method = RequestMethod.POST)
	public @ResponseBody UserDTO updatePassword(@RequestBody UserDTO user1)
			throws ErrorHandling {
 		User user = loginService.findUserByUserName(user1.getLoginName().trim());
 		try {
 			logger.info("user.getUserPassword()>>>>>" + user.getUserPassword());
			logger.info("user1.getOldPassword()>>>>>" + user1.getOldPassword());
			if (user.getUserPassword().equals(AppUtils.SHA1(user1.getOldPassword()))) {
				user.setChangePassword(AppUtils.SHA1(user1.getOldPassword()));
				user.setUserPassword(AppUtils.SHA1(user1.getNewPassword()));
				loginService.create(user);
				user1.setMessage("success");
			} else {
				user1.setMessage("fail");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
			user1.setMessage("fail");
 		}
		return user1;
 	}

}
