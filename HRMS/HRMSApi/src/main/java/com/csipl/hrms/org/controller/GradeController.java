package com.csipl.hrms.org.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.internal.engine.groups.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.GradeDTO;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.organisation.GradesPayDefinition;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.GradeAdaptor;
import com.csipl.hrms.service.organization.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController  {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	GradeAdaptor gradeAdaptor = new GradeAdaptor();
	@Autowired
	GradeService gradeService;
	/**
	 * @param gradeDto
	 *            This is the first parameter for getting grade Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveGrade(@RequestBody GradeDTO gradeDto, HttpServletRequest req) {
		logger.info("saveGrade is calling : GradeDTO "+ gradeDto);
		Grade grade = gradeAdaptor.uiDtoToDatabaseModel(gradeDto);
		gradeService.save(grade);
	}
	/**
	 * to get all grades List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<GradeDTO> findAllGrades(@RequestParam("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllGrades is calling : ");
		Long longcompanyId = Long.parseLong(companyId);
		List<Grade> gradeList = gradeService.getAllGrades(longcompanyId);
		logger.info("findAllGrades  : gradeList " +gradeList);
		if (gradeList != null && gradeList.size() > 0)
			return gradeAdaptor.databaseModelToUiDtoList(gradeList);
		else
			throw new ErrorHandling("Grade data not present");
	}
	/**
	 * to get grade Object from database based on gradeId(Primary key)
	 */
	@RequestMapping(value = "/{gradeId}", method = RequestMethod.GET)
	public @ResponseBody GradeDTO findGradeDetails(@PathVariable("gradeId") String gradeId, HttpServletRequest req) {
		logger.info("findAllGrades is calling : gradeId "+gradeId);
		Long gradeLongId = Long.parseLong(gradeId);
		return gradeAdaptor.databaseModelToUiDto(gradeService.findGradeDetails(gradeLongId));
	}
}
