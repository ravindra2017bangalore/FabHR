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
import com.csipl.hrms.dto.employee.EmployeeEducationDTO;
import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.service.adaptor.EmployeeEducationAdaptor;
import com.csipl.hrms.service.employee.EmployeeEducationService;

@RestController
@RequestMapping("/eduInformation")
public class EmployeeEducationController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeEducationController.class);

	EmployeeEducationAdaptor eduInformationAdaptor = new EmployeeEducationAdaptor();

	@Autowired
	EmployeeEducationService eduInformationService;
	HttpServletRequest request = null;
	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param eduInformationDtoList
	 *            This is the second parameter for getting EmployeeEducation Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value="/{empId}", method = RequestMethod.POST)
	public List<EmployeeEducationDTO> eduInformations(@PathVariable("empId") String empId,
			@RequestBody List<EmployeeEducationDTO> eduInformationDtoList, HttpServletRequest req) {
		logger.info("eduInformations is calling : " + "employeeId : " + empId + " : List< EmployeeEducationDTO> "
				+ eduInformationDtoList);
		List<EmployeeEducation> employeeEducationList = eduInformationAdaptor
				.employeeEducationDtoToDatabaseModelList(eduInformationDtoList, empId);

		employeeEducationList.forEach(employeeEducation -> {
			// boolean newFlag = employeeEducation == null ||
			// employeeEducation.getEducationId() == null;
			// editLogInfo(employeeEducation, newFlag, req);
		});

		List<EmployeeEducation> employeeEducationListResult = eduInformationService.save(employeeEducationList,request);
		logger.info("eduInformations is end  :" + "employeeEducationList" + employeeEducationList);
		return eduInformationAdaptor.databaseModelToUiDtoList(employeeEducationListResult);
	}

	/**
	 * to get List of EmployeeEducation from database based on employeeId
	 */
	@RequestMapping(value="/{empId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeEducationDTO> findAllEducations(@PathVariable("empId") Long empId,
			HttpServletRequest req) {
		logger.info("findAllEducations is calling :" + "employeeId" + empId);

		return eduInformationAdaptor.databaseModelToUiDtoList(eduInformationService.findAllEduInformation(empId));
	}

	/**
	 * delete EmployeeEducation object from database based on educationId (Primary
	 * Key)
	 */
	@RequestMapping( method = RequestMethod.DELETE)
	public void deleteEmp(@RequestParam("eduID") String eduID, HttpServletRequest req) {
		Long eduId = Long.parseLong(eduID);
		logger.info("deleteEmp is calling :" + "employeeEducationaId" + eduID);
		eduInformationService.delete(eduId);
	}
}
