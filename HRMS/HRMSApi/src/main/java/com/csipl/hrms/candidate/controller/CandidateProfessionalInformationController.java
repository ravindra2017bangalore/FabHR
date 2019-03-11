package com.csipl.hrms.candidate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;

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

import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.service.adaptor.CandidateProfessionalInformationAdaptor;
import com.csipl.hrms.service.adaptor.CandidateSkillAdaptor;
import com.csipl.hrms.service.candidate.CandidateProfessionalInformationService;
import com.csipl.hrms.service.candidate.CandidateSkillService;
import com.csipl.hrms.service.organization.StorageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/candidate")
@Api(description = "CandidateProfessionalInformation")
public class CandidateProfessionalInformationController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */

	private static final Logger logger = LoggerFactory.getLogger(CandidateProfessionalInformationController.class);
	@Autowired
	CandidateProfessionalInformationService candidateProfessionalInformationService;

	@Autowired
	CandidateSkillService candidateSkillService;

	@Autowired
	StorageService storageService;

	CandidateProfessionalInformationAdaptor candidateProfInfoAdaptor = new CandidateProfessionalInformationAdaptor();
	CandidateSkillAdaptor candidateSkillAdaptor = new CandidateSkillAdaptor();

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "Save or update CandidateSkill")

	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public List<CandidateSkillDTO> saveCandidateSkills(@RequestBody List<CandidateSkillDTO> candidateSkillDtoList,
			HttpServletRequest req) {
		logger.info("candidateSkillDtoList===" + candidateSkillDtoList);
		CandidateSkillAdaptor candidateSkillAdaptor = new CandidateSkillAdaptor();
		List<CandidateSkill> candidateSkillList = candidateSkillService
				.save(candidateSkillAdaptor.uiDtoToDatabaseModelList(candidateSkillDtoList));

		return candidateSkillAdaptor.databaseModelToUiDtoList(candidateSkillList);
	}

	@PostMapping(value = "/professional/{candidateId}", headers = "Content-Type= multipart/form-data")
	public List<CandidateProfessionalInformationDTO> saveCandidateProfessionalInformation(
			@PathVariable("candidateId") Long candidateId, HttpServletRequest req) throws Exception {
		logger.info("--------saveCandidateProfessionalInformation is calling-------");

		logger.info("req.getParameter---" + req.getParameter("fileInfo"));

		List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList = candidateProfInfoAdaptor
				.jsonArrayToCandidateProfessionalInfoDto(new JSONArray(req.getParameter("fileInfo")));

		List<CandidateProfessionalInformation> candidateProfessionalInfoList = candidateProfInfoAdaptor
				.uiDtoToDatabaseModelList(candidateProfessionalInformationDtoList, candidateId);
		List<CandidateProfessionalInformation> candidateProfessionalInformationList = candidateProfessionalInformationService
				.save(candidateProfessionalInfoList, req);
		return candidateProfInfoAdaptor.databaseModelToUiDtoList(candidateProfessionalInformationList);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a CandidateProfessionalInformation based on candidateId ")
	@RequestMapping(value = "/professional/{candidateId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateProfessionalInformationDTO> getAllCandidateProfessionalInformation(
			@PathVariable("candidateId") Long candidateId) throws ErrorHandling {
		logger.info("getAllCandidateProfessionalInformation is calling : ");
		List<CandidateProfessionalInformation> candidateProfessionalInformationList = candidateProfessionalInformationService
				.getAllCandidateProfessionalInformation(candidateId);
		logger.info("getAllCandidateProfessionalInformation is end  :" + candidateProfessionalInformationList);
		if (candidateProfessionalInformationList != null)
			return candidateProfInfoAdaptor.databaseModelToUiDtoList(candidateProfessionalInformationList);
		else
			throw new ErrorHandling("CandidateProfessionalInformation not found");
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a CandidateSkill based on candidateId ")
	@RequestMapping(value = "/skills/{candidateId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateSkillDTO> getAllCandidateSkill(@PathVariable("candidateId") Long candidateId)
			throws ErrorHandling {
		logger.info("getAllCandidateSkill is calling : ");
		List<Object[]> candidateSkillList = candidateSkillService.getAllCandidateSkill(candidateId);
		logger.info("candidateSkillList is end  :" + candidateSkillList);
		if (candidateSkillList != null)
			return candidateSkillAdaptor.databaseModelObjToUiDtoList(candidateSkillList);
		else
			throw new ErrorHandling("CandidateSkill not found");
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteSkill(@RequestParam("candidateSkillsId") Long candidateSkillsId, HttpServletRequest req) {
		candidateSkillService.deleteSkill(candidateSkillsId);
	}

}
