package com.csipl.hrms.authorization.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.authorization.RoleMasterDTO;
import com.csipl.hrms.model.authoriztion.RoleMaster;
import com.csipl.hrms.org.controller.DepartmentController;
import com.csipl.hrms.service.adaptor.RoleMasterAdaptor;
import com.csipl.hrms.service.authorization.RoleMasterService;

@RequestMapping("/roleMaster")
@RestController
public class RoleMasterController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	RoleMasterAdaptor roleMasterAdaptor = new RoleMasterAdaptor();

	@Autowired
	RoleMasterService roleMasterService;

	@RequestMapping(method = RequestMethod.POST)
	public void rolemaster(@RequestBody RoleMasterDTO roleMasterDto, HttpServletRequest req) {
		logger.info("rolemaster is calling : roleMasterDto " + roleMasterDto.toString());
		System.out.println("rolemaster is calling : roleMasterDto " + roleMasterDto.toString());

		RoleMaster roleMaster = roleMasterAdaptor.uiDtoToDatabaseModel(roleMasterDto);
		roleMasterService.save(roleMaster);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<RoleMasterDTO> findAllRoleMasters(HttpServletRequest req) {
		return roleMasterAdaptor.databaseModelToUiDtoList(roleMasterService.getAllRoleMasters());
	}
}
