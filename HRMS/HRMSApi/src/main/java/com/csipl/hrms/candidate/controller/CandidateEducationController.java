package com.csipl.hrms.candidate.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.candidate.CandidateEducationDTO;
import com.csipl.hrms.dto.employee.EmployeeEducationDTO;
import com.csipl.hrms.model.candidate.CandidateEducation;
import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.service.adaptor.CandidateEdcationAdaptor;
import com.csipl.hrms.service.candidate.CandidateEducationService;

@RestController
@RequestMapping("/candidateEducation")

public class CandidateEducationController {
	
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CandidateEducationController.class);
	
	CandidateEdcationAdaptor candidateEdcationAdaptor=new CandidateEdcationAdaptor();
	
	@Autowired
	CandidateEducationService candidateEducationService;
	
	
	
//	@PostMapping("/{candidateId}")
//	public void uploadMultiFiles(@PathVariable("candidateId") String candidateId,
//			HttpServletRequest request) throws Exception {
//		System.out.println("Data============"+candidateId);
//		System.out.println("Data============"+request.getParameter("fileInfo"));
//		
//	}
	
	@PostMapping("/{candidateId}")
	public List<CandidateEducationDTO> eduInformations(@PathVariable("candidateId") String candidateId,
			HttpServletRequest request) throws Exception {
		System.out.println("hitting uploadFiles");
		List documentList = new ArrayList<>();
		List<CandidateEducationDTO> candidateEduList = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(request.getParameter("fileInfo"));
		System.out.println("--------->>>>>JSONArray"+jsonArray);
		Set<Integer> index = new HashSet<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			CandidateEducationDTO candidateEducationDto = new CandidateEducationDTO();
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			// documentList.add(jsonObj);
			
			candidateEducationDto.setDegreeName(jsonObj.getString("degreeName"));
			candidateEducationDto.setMarksPer(BigDecimal.valueOf(jsonObj.optDouble("marksPer")));
			candidateEducationDto.setNameOfBoard(jsonObj.getString("nameOfBoard"));
			candidateEducationDto.setNameOfInstitution(jsonObj.getString("nameOfInstitution"));
			candidateEducationDto.setPassingYear(jsonObj.getLong("passingYear"));
			candidateEducationDto.setQualificationId(jsonObj.getString("qualificationId"));
			candidateEducationDto.setCompanyId(jsonObj.getLong("companyId"));
			candidateEducationDto.setUserId(jsonObj.getLong("userId"));
			candidateEducationDto.setRegularCorrespondance(jsonObj.getString("regularCorrespondance"));
	
			
			if (jsonObj.has("educationId")) {
				candidateEducationDto.setEducationId(Long.valueOf(jsonObj.optInt("educationId")));
			}
			if (jsonObj.has("documentFile")) {
				String s1 = jsonObj.getString("documentFile");
				System.out.println(s1 + "=====");
				candidateEducationDto.setDocumentName(s1);
				candidateEducationDto.setDocIndex(Long.valueOf(i));
			}else if(jsonObj.has("candidateEducationDoc") && jsonObj.has("documentName")) {
				
				candidateEducationDto.setCandidateEducationDoc(jsonObj.getString("candidateEducationDoc"));
				candidateEducationDto.setDocumentName(jsonObj.getString("documentName"));

			}
			logger.info(
					"===============Length of set   " + Arrays.toString(index.toArray()));
			candidateEduList.add(candidateEducationDto);
			System.out.println("index " + i + " --  " + jsonObj);
		}
		
		List<CandidateEducation> candidateEducationList = candidateEdcationAdaptor.candidateEducationDtoToDatabaseModelList(candidateEduList, candidateId);
		List<CandidateEducation> candidateEducationListResult = candidateEducationService.save(candidateEducationList, request);	
		logger.info("eduInformations ---------------------------- is end  :" + "employeeEducationList" + candidateEducationList);
		return candidateEdcationAdaptor.databaseModelToUiDtoList(candidateEducationListResult);
	}
	
	/**
	 * to get List of CandidateEducation from database based on employeeId
	 */
	@RequestMapping(value="/get/{candidateId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateEducationDTO> findAllEducations(@PathVariable("candidateId") Long candidateId,
			HttpServletRequest req) {
		logger.info("findAllEducations is calling :" + "candidateId" + candidateId);

		return candidateEdcationAdaptor.databaseModelToUiDtoList(candidateEducationService.findAllEduInformation(candidateId));
	}

	
	
}
