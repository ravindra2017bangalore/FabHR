package com.csipl.hrms.service.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.service.organization.repository.GradeRepository;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GradeServiceImpl.class);

	@Autowired
	private GradeRepository gradeRepository;

	/**
	 * To get List of Grades from Database based on companyId
	 */
	@Override
	public List<Grade> getAllGrades(Long companyId) {
		return gradeRepository.findAllGrades(companyId);

	}

	/**
	 * Save OR update grade object into Database
	 */
	@Override
	public Grade save(Grade grade) {
		return gradeRepository.save(grade);
	}

	/**
	 * To get Grade object from Database based on gradeId (Primary key)
	 */
	@Override
	public Grade findGradeDetails(Long gradeId) {
		return gradeRepository.findOne(gradeId);
	}
	
	/**
	 * To get Grade object from Database based on gradeName and companyId
	 */
	@Override
	public Grade findGradeByName(String grade, Long companyId) {
		return gradeRepository.findGradeByName(grade, companyId);
	}

}
