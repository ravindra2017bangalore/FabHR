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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.service.adaptor.CandidateSkillAdaptor;
import com.csipl.hrms.service.adaptor.EmpSkillAdaptor;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.candidate.CandidateSkillDTO;
import com.csipl.hrms.dto.employee.EmployeeSkillDTO;
import com.csipl.hrms.dto.employee.ProfessionalInformationDTO;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.service.adaptor.ProfessionalInformationAdaptor;
import com.csipl.hrms.service.employee.EmployeeSkillService;
import com.csipl.hrms.service.employee.ProfessionalInformationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/professional")
public class ProfessionalInformationController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProfessionalInformationController.class);

	ProfessionalInformationAdaptor professionalInformationAdaptor = new ProfessionalInformationAdaptor();

	@Autowired
	ProfessionalInformationService professionalInformationService;
	@Autowired
	EmployeeSkillService employeeSkillService;

	EmpSkillAdaptor empSkillAdaptor = new EmpSkillAdaptor();

	/**
	 * Method performed save operation with file
	 * 
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param professionalInformationDtoList
	 *            This is the second parameter for getting ProfessionalInformation
	 *            Object from UI
	 * @param req
	 *            This is the forth parameter to maintain user session
	 */

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.POST)
	public @ResponseBody List<ProfessionalInformationDTO> saveProfessionalDetails(
			@PathVariable("employeeId") String empId,
			@RequestBody List<ProfessionalInformationDTO> professionalInformationDtoList, HttpServletRequest req) {

		logger.info("saveProfessionalDetails is calling : " + "employeeId : " + empId
				+ " : professionalInformationDtoList " + professionalInformationDtoList);
		List<ProfessionalInformation> professionalInformationList = professionalInformationAdaptor
				.ProfessionalInformationDtoToDatabaseModelList(professionalInformationDtoList, empId);
		// setUserProfileWithoutCGList(professionalInformationList, req);

		// professionalInformationList.forEach(professionalInformation -> {
		// boolean newFlag =professionalInformation!=null &&
		// professionalInformation.getHistoryId() != null ? false : true;
		// editLogInfoWithoutCG(professionalInformation, newFlag, req);
		// });

		List<ProfessionalInformation> professionalInformationListResult = professionalInformationService
				.saveAll(professionalInformationList);
		logger.info("saveProfessionalDetails is end  :" + professionalInformationListResult);
		return professionalInformationAdaptor.databaseModelToUiDtoList(professionalInformationListResult);
	}

/*	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a CandidateSkill based on candidateId ")
	@RequestMapping(value = "/skills/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateSkillDTO> getAllEmployeeSkill(@PathVariable("employeeId") Long employeeId)
			throws ErrorHandling {
		logger.info("getAllEmployeeSkill is calling : ");
		List<EmployeeSkill> employeeSkillList = employeeSkillService.getEmployeeSkills(employeeId);
		logger.info("getAllemployeeSkill is end  :" + employeeSkillList);
		if (employeeSkillList != null)
			return empSkillAdaptor.databaseModelToUiDtoList(employeeSkillList);
		else
			throw new ErrorHandling("CandidateSkill not found");
	}
*/
	/**
	 * to get List of ProfessionalInformation from database based on employeeId
	 */
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<ProfessionalInformationDTO> findAllProfessionals(@PathVariable("employeeId") String empId,
			HttpServletRequest req) {
		logger.info("findAllProfessionals is calling :" + "employeeId" + empId);
		List<ProfessionalInformationDTO> ProfessionalInformationDtoList = professionalInformationAdaptor
				.databaseModelToUiDtoList(professionalInformationService.findAllProfessionalInformation(empId));

		logger.info("findAllProfessionals is end  :" + ProfessionalInformationDtoList);
		return ProfessionalInformationDtoList;
	}

	/**
	 * delete ProfessionalInformation object from database based on historyId
	 * (Primary Key)
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteProfessional(@RequestParam("ID") String ID, HttpServletRequest req) {
		logger.info("deleteProfessional start  : ID is " + ID);
		Long historyId = Long.parseLong(ID);
		professionalInformationService.delete(historyId);
		logger.info("deleteProfessional end  ");
	}

	
}