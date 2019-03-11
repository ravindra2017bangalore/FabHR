package com.csipl.hrms.service.organization;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.csipl.hrms.model.organisation.Project;
 import com.csipl.hrms.service.organization.repository.ProjectRepository;
 
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
 	@Autowired
	  private ProjectRepository projectRepository;
	
	/**
	 * to get List of projects from database based on companyId
	 */
	@Override
	public List<Project> getAllProjects(Long companyId) {
 		return projectRepository.findAllProject(companyId);
 	}

	/**
	 * to get project object from database  
	 */
	@Override
	public Project save(Project project) {
  		return projectRepository.save(project);
	}
 
}
