package com.csipl.hrms.service.organization;

import java.util.List;

import com.csipl.hrms.model.organisation.Project;

public interface ProjectService {

	public List<Project> getAllProjects(Long companyId);

	public Project save(Project project);

 
}
