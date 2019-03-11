package com.csipl.hrms.employee.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.candidate.CandidateProfessionalInformationDTO;
import com.csipl.hrms.dto.candidate.CandidateSkillDTO;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.service.adaptor.CandidateSkillAdaptor;
import com.csipl.hrms.service.adaptor.EmpProfessionalAdaptor;
import com.csipl.hrms.service.adaptor.EmpSkillAdaptor;
import com.csipl.hrms.service.employee.EmployeeSkillService;
import com.csipl.hrms.service.employee.ProfessionalInformationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employeeProfessional")
public class EmpProfessionalController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpProfessionalController.class);

	EmpProfessionalAdaptor empProfessionalAdaptor = new EmpProfessionalAdaptor();
	@Autowired
	ProfessionalInformationService professionalInformationService;

	@Autowired
	EmployeeSkillService employeeSkillService;

	CandidateSkillAdaptor candidateSkillAdaptor = new CandidateSkillAdaptor();
	EmpSkillAdaptor empSkillAdaptor = new EmpSkillAdaptor();

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "Save or update EmployeeProfessionalInformation")

	@PostMapping(value = "/professional/{employeeId}", headers = "Content-Type= multipart/form-data")
	public List<CandidateProfessionalInformationDTO> saveEmployeeProfessionalInformation(
			@PathVariable("employeeId") Long employeeId, HttpServletRequest req) throws JSONException, ParseException {

		logger.info(
				"saveEmployeeProfessionalInformation is calling: req.getParameter---" + req.getParameter("fileInfo"));

		List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList = empProfessionalAdaptor
				.jsonArrayToEmployeeProfessionalInfoDto(new JSONArray(req.getParameter("fileInfo")));

		List<ProfessionalInformation> professionalInformationList = empProfessionalAdaptor
				.uiDtoToDatabaseModelList(candidateProfessionalInformationDtoList);

		List<ProfessionalInformation> empProfessionalInformationList = professionalInformationService
				.save(professionalInformationList, req);
		return empProfessionalAdaptor.databaseModelToUiDtoList(empProfessionalInformationList);
	}

	/**
	 * to get List of ProfessionalInformation from database based on employeeId
	 */
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateProfessionalInformationDTO> findAllProfessionals(
			@PathVariable("employeeId") String empId, HttpServletRequest req) {
		logger.info("findAllProfessionals is calling :" + "employeeId" + empId);
		List<CandidateProfessionalInformationDTO> ProfessionalInformationDtoList = empProfessionalAdaptor
				.databaseModelToUiDtoList(professionalInformationService.findAllProfessionalInformation(empId));

		logger.info("findAllProfessionals is end  :" + ProfessionalInformationDtoList);
		return ProfessionalInformationDtoList;
	}

	/**
	 * to delete EmployeeSkill from database based on employeeSkillsId
	 */
	@RequestMapping(value = "/skill", method = RequestMethod.DELETE)
	public void deleteSkill(@RequestParam("employeeSkillsId") Long employeeSkillsId, HttpServletRequest req) {
		employeeSkillService.deleteSkill(employeeSkillsId);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a CandidateSkill based on candidateId ")
	@RequestMapping(value = "/skills/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateSkillDTO> getAllEmployeeSkill(@PathVariable("employeeId") Long employeeId)
			throws ErrorHandling {
		logger.info("getAllEmployeeSkill is calling : ");
		List<Object[]> employeeSkillList = employeeSkillService.getEmployeeSkills(employeeId);
		logger.info("employeeSkillList  :" + employeeSkillList);
		if (employeeSkillList != null)
			return empSkillAdaptor.databaseModelObjToUiDtoList(employeeSkillList);
		else
			throw new ErrorHandling("CandidateSkill not found");
	}

	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public List<CandidateSkillDTO> saveEmployeeSkills(@RequestBody List<CandidateSkillDTO> candidateSkillDtoList,
			HttpServletRequest req) {
		logger.info("employeeSkillDtoList===" + candidateSkillDtoList);
		EmpSkillAdaptor empSkillAdaptor = new EmpSkillAdaptor();
		List<EmployeeSkill> employeeSkillList = employeeSkillService
				.save(empSkillAdaptor.uiDtoToDatabaseModelList(candidateSkillDtoList));

		return empSkillAdaptor.databaseModelToUiDtoList(employeeSkillList);
	}
}
