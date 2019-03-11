package com.csipl.hrms.org.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.GroupDTO;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.service.adaptor.GroupAdaptor;
import com.csipl.hrms.service.organization.GroupService;
import com.csipl.hrms.service.organization.StorageService;

@RestController
@RequestMapping("/group")
public class GroupController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	GroupAdaptor groupAdaptor = new GroupAdaptor();

	@Autowired
	GroupService groupService;
	@Autowired
	StorageService storageService;

	/**
	 * Method performed save operation with file
	 * 
	 * @param file
	 *            This is the first parameter for taking file Input
	 * @param groupDto
	 *            This is the second parameter for getting group Object from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value = "/file", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void saveGroup(@RequestPart("uploadFile") MultipartFile file, @RequestPart("info") GroupDTO groupDto,
			HttpServletRequest req) {
		logger.info("saveGroup is calling : GroupDTO " + groupDto + "uploadFile" + file);

		Groupg groupg = groupAdaptor.uiDtoToDatabaseModel(groupDto);
		logger.info("saveGroup : Groupg " + groupg + "user" + groupDto);
		setUserProfileforGroup(groupg, groupDto);
		groupService.save(groupg, file, true);
		logger.info("saveGroup is end : Groupg " + groupg);
	}

	/**
	 * Method performed save operation without any file
	 * 
	 * @param groupDto
	 *            This is the first parameter for getting group Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody GroupDTO groupDto, HttpServletRequest req) {
		logger.info("save is calling : GroupDTO " + groupDto);

		Groupg groupg = groupAdaptor.uiDtoToDatabaseModel(groupDto);
		logger.info("saveGroup : Groupg " + groupg + "user" + groupDto);
		setUserProfileforGroup(groupg, groupDto);
		groupService.save(groupg, null, false);
		logger.info("saveGroup is end : Groupg " + groupg);
	}

	public void setUserProfileforGroup(Groupg groupg, GroupDTO groupDto) {
		if (groupDto.getGroupId() != null) {
			groupg.setDateCreated(groupDto.getDateCreated());
		} else {
			groupg.setDateCreated(new Date());
		}
		if (groupDto.getUserId() != null) {
			System.out.println("groupgID-------"+groupg.getUserId());
			groupg.setUserId(groupDto.getUserId());
		}

		groupg.setUserIdUpdate(groupDto.getUserIdUpdate());
		groupg.setDateUpdate(new Date());
		groupg.getAddress().setUserId(groupDto.getUserId());
	}

	/**
	 * to get Group list from database
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<GroupDTO> findAllGroups() throws ErrorHandling {
		logger.info("findAllGroups is calling : ");
		List<Groupg> groupgList = groupService.getAllGroups();
		logger.info("findAllGroups  :groupgList " + groupgList);
		if (groupgList != null && groupgList.size() > 0)
			return groupAdaptor.databaseModelToUiDtoList(groupgList);
		else
			throw new ErrorHandling("Group data not present");
	}
}
