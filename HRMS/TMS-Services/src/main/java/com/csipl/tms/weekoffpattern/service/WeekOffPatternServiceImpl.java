package com.csipl.tms.weekoffpattern.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.tms.model.weekofpattern.WeekOffPattern;
import com.csipl.tms.weekoffpattern.repository.WeekOffPatternRepository;

@Transactional
@Service("week_Off_PatternService")
public class WeekOffPatternServiceImpl implements WeekOffPatternService {

	@Autowired
	WeekOffPatternRepository week_Off_PatternRepository;

	@Override
	public List<WeekOffPattern> getAllWeekOffPattern(Long companyId) {
		return week_Off_PatternRepository.getAllWeekOffPattern(companyId);
	}

	@Override
	public void save(WeekOffPattern week_Off_Pattern) {
		week_Off_PatternRepository.save(week_Off_Pattern);
	}

	@Override
	public WeekOffPattern findOne(Long patternId) {
		return week_Off_PatternRepository.findOne(patternId);
	}

	@Override
	public WeekOffPattern getWeekOffPattern(Long companyId) {
		return week_Off_PatternRepository.getWeekOffPattern(companyId);
	}

	@Override
	public Object[] getWeekOffPatternByEmp(Long companyId, Long employeeId) {
		return week_Off_PatternRepository.getWeekOffPatternByEmp(companyId,employeeId);
	}

}
