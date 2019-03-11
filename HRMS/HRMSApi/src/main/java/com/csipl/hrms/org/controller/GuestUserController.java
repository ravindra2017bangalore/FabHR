package com.csipl.hrms.org.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.dto.organisation.GuestUserDTO;
import com.csipl.hrms.model.common.GuestUser;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.GuestUserAdaptor;
import com.csipl.hrms.service.authorization.GuestUserService;

@RestController
public class GuestUserController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GuestUserController.class);
 	GuestUserAdaptor guestUserAdaptor=new GuestUserAdaptor();
  	@Autowired
	GuestUserService guestUserService;

	@RequestMapping(path = "/guest", method = RequestMethod.POST)
	public void signup(@RequestBody GuestUserDTO guestUserDto, HttpServletRequest req) {
		logger.info("signup is calling : GuestUserDTO "+guestUserDto );
 			GuestUser guestUser=guestUserAdaptor.uiDtoToDatabaseModel(guestUserDto);
 		    guestUserService.save(guestUser);
  	}
 }
