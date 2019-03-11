package com.csipl.tms.weekoffpattern.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.weekofpattern.WeekOffPattern;

public interface WeekOffPatternRepository extends CrudRepository<WeekOffPattern, Long> {
	@Query("from WeekOffPattern where companyId=?1")
	public List<WeekOffPattern> getAllWeekOffPattern(Long companyId);
	
	@Query("from WeekOffPattern where companyId=?1")
	public WeekOffPattern getWeekOffPattern(Long companyId);
	
	String weekOffPatternByEmp="SELECT wop.day FROM Employee e JOIN Department d ON d.departmentId = e.departmentId JOIN TMSWeekOffPattern wop ON wop.patternId = d.patternId where e.companyId=?1 AND e.employeeId=?2";
	
	@Query(value=weekOffPatternByEmp, nativeQuery = true)
	public Object[] getWeekOffPatternByEmp(Long companyId, Long employeeId);
}
