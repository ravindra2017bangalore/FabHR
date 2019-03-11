package com.csipl.hrms.employee.controller;

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
import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.service.adaptor.EmpEducationAdapor;
import com.csipl.hrms.service.employee.EmployeeEducationService;

@RestController
@RequestMapping("/employeeEducation")
public class EmpEducationController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpEducationController.class);
	@Autowired
	EmployeeEducationService eduInformationService;
	
	EmpEducationAdapor employeeEducationAdapor = new EmpEducationAdapor();
	
	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param eduInformationDtoList
	 *            This is the second parameter for getting EmployeeEducation Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	
	@PostMapping("/{employeeId}")
	public List<CandidateEducationDTO> eduInformations(@PathVariable("employeeId") String employeeId,
			HttpServletRequest request) throws Exception {
		System.out.println("hitting uploadFiles");
		List documentList = new ArrayList<>();
		List<CandidateEducationDTO> candidateEducationList = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(request.getParameter("fileInfo"));
		System.out.println("--------->>>>>JSONArray"+jsonArray);
		System.out.println("EmployeeId"+employeeId);
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
			candidateEducationDto.setRegularCorrespondance(jsonObj.getString("regularCorrespondance"));
			
			
			candidateEducationDto.setCompanyId(jsonObj.getLong("companyId"));
			candidateEducationDto.setUserId(jsonObj.getLong("userId"));
//			candidateEducationDto.setPassingYear(jsonObj.getLong("passingYear"));
			
			if (jsonObj.has("educationId")) {
				candidateEducationDto.setEducationId(Long.valueOf(jsonObj.optInt("educationId")));
			}
			if (jsonObj.has("documentFile")) {
				String s1 = jsonObj.getString("documentFile");
				System.out.println(s1 + "=====");
				candidateEducationDto.setDocumentName(s1);
				candidateEducationDto.setDocIndex(Long.valueOf(i));
			}
			logger.info(
					"===============Length of set   " + Arrays.toString(index.toArray()));
			candidateEducationList.add(candidateEducationDto);
			System.out.println("index " + i + " --  " + jsonObj);
		}
		
		List<EmployeeEducation> employeeEducationList = employeeEducationAdapor.employeeEducationDtoToDatabaseModelList(candidateEducationList, employeeId);
		List<EmployeeEducation> employeeEducationListResult = eduInformationService.save(employeeEducationList, request);	
		logger.info("eduInformations ---------------------------- is end  :" + "employeeEducationList" + employeeEducationList);
		return employeeEducationAdapor.databaseModelToUiDtoList(employeeEducationListResult);
	}
	
	
//	
//@RequestMapping(value="/{employeeId}", method = RequestMethod.POST)
//	public List<CandidateEducationDTO> eduInformations(@PathVariable("employeeId") String employeeId,
//			@RequestBody List<CandidateEducationDTO> eduInformationDtoList, HttpServletRequest req) {
//		logger.info("eduInformations is calling : " + "employeeId : " + employeeId + " : List< EmployeeEducationDTO> "
//				+ eduInformationDtoList);
//		List<EmployeeEducation> employeeEducationList = employeeEducationAdapor
//				.employeeEducationDtoToDatabaseModelList(eduInformationDtoList, employeeId);
//
//		employeeEducationList.forEach(employeeEducation -> {
//			// boolean newFlag = employeeEducation == null ||
//			// employeeEducation.getEducationId() == null;
//			// editLogInfo(employeeEducation, newFlag, req);
//		});
//
//		List<EmployeeEducation> employeeEducationListResult = eduInformationService.save(employeeEducationList);
//		logger.info("eduInformations is end  :" + "employeeEducationList" + employeeEducationList);
//		return employeeEducationAdapor.databaseModelToUiDtoList(employeeEducationListResult);
//	}
	
	/**
	 * to get List of EmployeeEducation from database based on employeeId
	 */
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateEducationDTO> findAllEducations(@PathVariable("employeeId") Long employeeId,
			HttpServletRequest req) {
		logger.info("findAllEducations is calling :" + "employeeId" + employeeId);

		return employeeEducationAdapor.databaseModelToUiDtoList(eduInformationService.findAllEduInformation(employeeId));
	}
}
