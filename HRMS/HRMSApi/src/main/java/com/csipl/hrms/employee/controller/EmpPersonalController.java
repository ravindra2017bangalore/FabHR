package com.csipl.hrms.employee.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
 import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.candidate.CandidateDTO;
import com.csipl.hrms.dto.candidate.ProgressBarDTO;
import com.csipl.hrms.dto.common.ShiftDTO;
import com.csipl.hrms.dto.common.WeekOffPatternDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.adaptor.EmpPersonalAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;



@RestController
@RequestMapping("/employeePersonal")
 
public class EmpPersonalController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpPersonalController.class);

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	
	@Autowired
	private org.springframework.core.env.Environment environment;
 	
	EmpPersonalAdaptor empPersonalAdaptor =new EmpPersonalAdaptor();
	/**
	 * @param employeeDto
	 *            This is the first parameter for getting Employee Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @throws PayRollProcessException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public  @ResponseBody CandidateDTO save(@RequestBody CandidateDTO candidateDto, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		logger.info("save is calling : " + " : CandidateDTO " + candidateDto);
		Employee employee = employeePersonalInformationService.getEmployeeInfo(candidateDto.getCandidateId());
		employeePersonalInformationService.save(empPersonalAdaptor.candidateDtoToDatabaseModel(candidateDto,employee),
			null, false);
		CandidateDTO candidate = empPersonalAdaptor.databaseModelToUiDto(employee);
		return candidate;
	}
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CandidateDTO getEmployee(@PathVariable("employeeId") Long employeeId) {
		logger.info("getEmployee is calling : " + employeeId);
		Employee employee = employeePersonalInformationService.getEmployeeInfo(employeeId);
		System.out.println("employee..."+employee);
		ShiftDTO shiftDto = getshiftByRestTamplate(employee.getShiftId().toString());
		WeekOffPatternDTO weekOffDto=getWeekoffByRestTamplate(employee.getPatternId().toString());
		CandidateDTO candidateDto = empPersonalAdaptor.databaseModelToCandidateDto(employee,shiftDto);
		if(employee.getReportingToEmployee()!=null) {
		Employee reportingEmployee=employeePersonalInformationService.findEmployeesById(employee.getReportingToEmployee());
		candidateDto.setReportingToemployeeName(reportingEmployee.getFirstName()+" "+reportingEmployee.getLastName());
		candidateDto.setReportingToemployeeDesignation(reportingEmployee.getDesignation().getDesignationName());
		}
		candidateDto.setShiftName(shiftDto.getShiftFName());
		candidateDto.setPatternName(weekOffDto.getPatternName());
		return candidateDto;

	}
	/**
	 * @param file
	 *            This is the first parameter for taking file Input
	 * @param employeeDto
	 *            This is the second parameter for getting Employee Object from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 * @throws ErrorHandling
	 */
	@RequestMapping(value = "/employeefile", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void saveCandidateImage(@RequestPart("uploadFile") MultipartFile file,
			@RequestPart("info") CandidateDTO candidateDto, HttpServletRequest req) throws ErrorHandling {
		logger.info("saveEmp is calling : " + " : candidateId " + candidateDto + " : uploadFile" + file);
		employeePersonalInformationService.saveCandidateImage(candidateDto.getCandidateId(), file);
	}
	@RequestMapping(value = "/progressBar/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProgressBarDTO progressBar(@PathVariable("employeeId") Long employeeId) {
		System.out.println("Employee service is calling : " + employeeId);
		ProgressBarDTO progressBarDto = new ProgressBarDTO();
		List<Object[]> progressBarObj = employeePersonalInformationService.getOnBoardProgessBar(employeeId);
		Long professionalBar = 0l, idAddressProof = 0l, personalBar = 0l, educationBar = 0l, familyBar = 0l,
				statutoryBar = 0l, candidateBar = 0l,employeeBankBar = 0l;

		for (Object[] objects : progressBarObj) {
			personalBar = objects[0] != null ? Long.parseLong(objects[0].toString()) : 0;
			idAddressProof = objects[1] != null ? Long.parseLong(objects[1].toString()) : 0;
			professionalBar = objects[2] != null ? Long.parseLong(objects[2].toString()) : 0;
			educationBar = objects[3] != null ? Long.parseLong(objects[3].toString()) : 0;
			familyBar = objects[4] != null ? Long.parseLong(objects[4].toString()) : 0;
			statutoryBar = objects[5] != null ? Long.parseLong(objects[5].toString()) : 0;
			candidateBar = objects[6] != null ? Long.parseLong(objects[6].toString()) : 0;
			employeeBankBar = objects[7] != null ? Long.parseLong(objects[7].toString()) : 0;

		}

		progressBarDto.setCandidateBar(candidateBar);
		progressBarDto.setPersonalBar(personalBar);
		progressBarDto.setIdAddressProof(idAddressProof);
		progressBarDto.setProfessionalBar(professionalBar);
		progressBarDto.setEducationBar(educationBar);
		progressBarDto.setFamilyBar(familyBar);
		progressBarDto.setStatutoryBar(statutoryBar);
		progressBarDto.setEmployeeBankBar(employeeBankBar);

		return progressBarDto;

	}
	private ShiftDTO getshiftByRestTamplate(String shiftId) {
		logger.info("Shift Id----->" + shiftId);
		logger.info("getshiftByRestTamplate is calling : ");
		String url = environment.getProperty("application.shiftTemp");
 
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, String> params = new HashMap<>();
		params.put("shiftId", shiftId);
		return restTemplate.getForObject(url, ShiftDTO.class, params);
	}

	
	private WeekOffPatternDTO getWeekoffByRestTamplate(String patternId) {
		logger.info("patternId Id----->" + patternId);
		logger.info("getWeekoffByRestTamplate is calling : ");
		String url = environment.getProperty("application.weekoffpatternTemp");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, String> params = new HashMap<>();
		params.put("patternId", patternId);
		return restTemplate.getForObject(url, WeekOffPatternDTO.class, params);
	}
	
	/**
	 * @param candidateId
	 * 				This is to send  onboard credentials Mail to the candidate based on employeeId
	 */
	@RequestMapping(value = "/onboardMail/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void onboardMail(@PathVariable("employeeId") Long employeeId) {
		System.out.println("onboardMail service is calling : " + employeeId);
		Employee employee = employeePersonalInformationService.findEmployeesById(employeeId);
		employeePersonalInformationService.onboardMail(employee);
		
	}

}
