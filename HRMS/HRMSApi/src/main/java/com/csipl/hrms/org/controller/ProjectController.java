package com.csipl.hrms.org.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.ProjectDTO;
import com.csipl.hrms.model.organisation.Project;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.ProjectAdaptor;
import com.csipl.hrms.service.organization.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	boolean status = false;

 
	@Autowired
	ProjectService projectService;
	ProjectAdaptor projectAdaptor = new ProjectAdaptor();
	/** 
	 * Method performed save operation 
	 *  
	 * @param companyDto
	 *            This is the first parameter for getting project Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveProject(@RequestBody ProjectDTO projectDto, HttpServletRequest req) {
		logger.info("saveProject is calling : ProjectDTO "+projectDto );
		Project project = projectAdaptor.uiDtoToDatabaseModel(projectDto);
 		/*boolean newFlag =project!=null && project.getProjectId() != null ? false : true;
		editLogInfo(project, newFlag, req);*/
		logger.info("saveProject is end : project "+project );
 		projectService.save(project);
	}
	/**
	 * to get List of projects from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value="/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<ProjectDTO> findAllProjects(@PathVariable("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllProjects is calling : " );
		Long longcompanyId = Long.parseLong(companyId);
		List<Project> projectList = projectService.getAllProjects(longcompanyId);
		logger.info("findAllProjects ProjectList : " +projectList);

		if (projectList != null && projectList.size() > 0)
			return projectAdaptor.databaseModelToUiDtoList(projectList);
		else
			throw new ErrorHandling("Project data not present");
	}

}
