package com.csipl.hrms.service.organization.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.Groupg;



public interface GroupRepository extends CrudRepository<Groupg, Long> {
 	@Query(" from Groupg ORDER BY  groupId  DESC ")
    public List<Groupg> findAllGroup();
 }

