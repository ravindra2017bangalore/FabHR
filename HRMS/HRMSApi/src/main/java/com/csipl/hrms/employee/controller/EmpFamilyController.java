package com.csipl.hrms.employee.controller;

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
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.service.adaptor.EmpFamilyAdaptor;
import com.csipl.hrms.service.employee.FamilyService;

@RestController
@RequestMapping("/employeeFamily")
public class EmpFamilyController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpFamilyController.class);
	@Autowired
	FamilyService familyService;
	EmpFamilyAdaptor empFamilyAdaptor =new EmpFamilyAdaptor();
	
	@RequestMapping(method = RequestMethod.POST)
	public List<CandidateFamilyDTO> saveCandidateFamily(@RequestBody List<CandidateFamilyDTO> candidateFamilyDTOList, HttpServletRequest req) {
		logger.info("saveEmployeeFamily is calling : CandidateFamilyDTO "+ candidateFamilyDTOList);
		//List<EmployeeFamily> employeeFamilyList = empFamilyAdaptor.uiDtoToDatabaseModelList(candidateFamilyDTOList);
	List<EmployeeFamily> employeeFamilyList=familyService.saveAll(empFamilyAdaptor.uiDtoToDatabaseModelList(candidateFamilyDTOList));
	return empFamilyAdaptor.databaseModelToUiDtoList(employeeFamilyList);
	}
	
	/**
	 * to get List of EmployeeFamily from database based on employeeId
	 */
	
	@RequestMapping(path="/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateFamilyDTO> getAllEmployeeFamilyDetails(@PathVariable("employeeId") String employeeId,
			HttpServletRequest req) {
		logger.info("FamilyDetailsController getAllEmployeeFamilyDetails  empId is :" + employeeId);
		return empFamilyAdaptor.databaseModelToUiDtoList(familyService.findAllEmployeeDetails(employeeId));
	}
}
