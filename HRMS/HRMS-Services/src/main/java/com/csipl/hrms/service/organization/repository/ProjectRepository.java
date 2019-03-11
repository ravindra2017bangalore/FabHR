package com.csipl.hrms.service.organization.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.Project;



public interface ProjectRepository extends CrudRepository<Project, Long> {
	

	@Query(" from Project where companyId=?1 ORDER BY  projectId  DESC")
    public List<Project> findAllProject(Long companyId);
	
}
