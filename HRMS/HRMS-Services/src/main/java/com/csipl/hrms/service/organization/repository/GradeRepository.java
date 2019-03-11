package com.csipl.hrms.service.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.organisation.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
	@Query("from Grade where companyId=?1 or gradesName='G0' ORDER BY  gradesId  DESC")
	public List<Grade> findAllGrades(Long companyId);
	
	//@Query("from Grade where gradesName=?1 and companyId=?2 and activeStatus='AC'")
	@Query("from Grade where gradesName=?1 and companyId=?2 ")
	public Grade findGradeByName(String  grade, Long companyId);
}
