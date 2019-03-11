package com.csipl.hrms.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.csipl.common.model.Notification;
import com.csipl.hrms.common.util.ErrorHandling;
//import com.csipl.hrms.common.exception.PayRollProcessException;
//import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.service.adaptor.NotificationConfigAdaptor;
import com.csipl.hrms.service.common.NotificationConfigService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.csipl.common.dto.notification.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/notificationConfig")
@RestController
public class NotificationConfigController {
	
	@Autowired
	NotificationConfigService notificationConfigService;
	NotificationConfigAdaptor notificationConfigAdaptor=new NotificationConfigAdaptor();
	
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(NotificationConfigController.class);
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved or update"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update the resource"),
			@ApiResponse(code = 403, message = "You were trying to save resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "Save or Update Notification")
	@RequestMapping(method = RequestMethod.POST)
	public void saveDesignation(@RequestBody NotificationDTO notificationDTO, HttpServletRequest req) {
		logger.info("saveNotification is calling : "+" : NotificationDTO "+notificationDTO);
		Notification notification = notificationConfigAdaptor.uiDtoToDatabaseModel(notificationDTO);
		logger.info("saveNotification is end  :" + "Notification" + notification);
		notificationConfigService.save(notification);
	}
	

	
	@ApiOperation(value = "get Notification List")
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<NotificationDTO> getAllNotifications(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling {
		logger.info("getAllNotifications is calling : companyId"+companyId);
		Long longcompanyId = Long.parseLong(companyId);
		List<Notification> notificationList = notificationConfigService.findAllNotificationConfigList( longcompanyId );
		if (notificationList != null && notificationList.size() > 0) {
			logger.info("getAllNotifications is end  :" + "NotificationList" + notificationList);
			return notificationConfigAdaptor.databaseModelToUiDtoList(notificationList);}
		else
			throw new ErrorHandling("Notification data not present");
	}
}
