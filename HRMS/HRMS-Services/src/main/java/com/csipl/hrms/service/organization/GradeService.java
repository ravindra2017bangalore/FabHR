package com.csipl.hrms.service.organization;

 
import java.util.List;
 import com.csipl.hrms.model.organisation.Grade;


public interface GradeService {
	
	public List<Grade> getAllGrades(Long companyId);
 	 public Grade save(Grade grade);
  	 public Grade findGradeDetails(Long gradeId);
 	  public Grade findGradeByName(String grade, Long companyId);

}

