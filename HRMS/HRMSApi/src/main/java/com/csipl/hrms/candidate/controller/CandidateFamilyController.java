package com.csipl.hrms.candidate.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.dto.candidate.CandidateFamilyDTO;
import com.csipl.hrms.dto.employee.EmployeeFamilyDTO;
import com.csipl.hrms.model.candidate.CandidateFamily;
import com.csipl.hrms.service.adaptor.CandidateFamilyAdaptor;
import com.csipl.hrms.service.candidate.CandidateFamilyService;

@RestController
@RequestMapping(path="/candidate")
public class CandidateFamilyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateFamilyController.class);
	
	@Autowired
	CandidateFamilyService candidateFamilyService;

	CandidateFamilyAdaptor candidateFamilyAdaptor = new CandidateFamilyAdaptor();
	/**
	 * to save List of CandidateFamily  based on candidateId
	 */
	
	@RequestMapping(value="/candidateFamily",method = RequestMethod.POST)
	public List<CandidateFamilyDTO> saveCandidateFamily(@RequestBody List<CandidateFamilyDTO> CandidateFamilyDTOList, HttpServletRequest req) {
		logger.info("saveCandidateFamily is calling : CandidateFamilyDTO "+ CandidateFamilyDTOList);
		List<CandidateFamily> candidateFamilyList = candidateFamilyAdaptor.uiDtoToDatabaseModelList(CandidateFamilyDTOList);
	List<CandidateFamily> candidateFamilyListObj =	candidateFamilyService.saveAll(candidateFamilyList);
	System.out.println(candidateFamilyAdaptor.databaseModelToUiDtoList(candidateFamilyListObj).toString());
	return candidateFamilyAdaptor.databaseModelToUiDtoList(candidateFamilyListObj);
	}

	/**
	 * to get List of EmployeeFamily from database based on candidateId
	 */
	@RequestMapping(value="/candidateFamily/{candidateId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateFamilyDTO> getCandidateFamilyDetails(@PathVariable("candidateId") Long candidateId,
			HttpServletRequest req) {
		
		logger.info("FamilyDetailsController getAllEmployeeFamilyDetails  empId is :" + candidateId);
		List<CandidateFamily> candidateFamilyList=candidateFamilyService.findAllFamilyList(candidateId);
		
		List<CandidateFamilyDTO> candidateFamilyDTOList=candidateFamilyAdaptor.databaseModelToUiDtoList(candidateFamilyList);
		logger.info("getting  FamilyDetails :==========================="  + candidateFamilyList);
		return candidateFamilyDTOList;
	}
}
