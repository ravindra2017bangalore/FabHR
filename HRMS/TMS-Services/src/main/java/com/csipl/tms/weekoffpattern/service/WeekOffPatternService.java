package com.csipl.tms.weekoffpattern.service;

import java.util.List;

import com.csipl.tms.model.weekofpattern.WeekOffPattern;

public interface WeekOffPatternService {

	public List<WeekOffPattern> getAllWeekOffPattern(Long companyId);
	
	public WeekOffPattern getWeekOffPattern(Long companyId);

	public void save(WeekOffPattern week_Off_Pattern);

	public WeekOffPattern findOne(Long patternId);

	public Object[] getWeekOffPatternByEmp(Long companyId,Long employeeId);
}
