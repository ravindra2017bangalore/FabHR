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
import com.csipl.hrms.dto.employee.EmployeeStatuaryDTO;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.service.adaptor.EmployeeStatuaryAdaptor;
import com.csipl.hrms.service.adaptor.MandatoryInfoCheckAdaptor;
import com.csipl.hrms.service.employee.EmployeeStatuaryService;
import com.csipl.hrms.service.organization.MandatoryInfoCheckService;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;

@RestController
@RequestMapping("/statuary")
public class EmployeeStatuaryController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeStatuaryController.class);
	EmployeeStatuaryAdaptor employeeStatuaryAdaptor = new EmployeeStatuaryAdaptor();

	@Autowired
	EmployeeStatuaryService employeeStatuaryService;

	@Autowired
	MandatoryInfoCheckService mandatoryInfoCheckService;

	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;

	MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
	MandatoryInfoCheckAdaptor mandatoryInfoCheckAdaptor = new MandatoryInfoCheckAdaptor();

	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param employeeStatuaryDtoList
	 *            This is the second parameter for getting EmployeeStatuary Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value="/{empId}", method = RequestMethod.POST)
	public List<EmployeeStatuaryDTO> employeeStatuarys(@PathVariable("empId") String empId,
			@RequestBody List<EmployeeStatuaryDTO> employeeStatuaryDtoList, HttpServletRequest req) {
		logger.info("employeeStatuarys empId :" + empId);
		Long employeeId = Long.parseLong(empId);
		List<EmployeeStatuary> employeeStatuaryList = employeeStatuaryAdaptor
				.empStaturyDtoToDatabaseModelList(employeeStatuaryDtoList, empId);
		// employeeStatuaryList.forEach(employeeStatuary -> {
		// boolean newFlag = employeeStatuary != null &&
		// employeeStatuary.getStatuaryId() != null ? false : true;
		// editLogInfoWithoutCG(employeeStatuary, newFlag, req);
		// });
		List<EmployeeStatuary> employeeStatuaryListResult = employeeStatuaryService.save(employeeStatuaryList,
				employeeId);

		return employeeStatuaryAdaptor.databaseModelToUiDtoList(employeeStatuaryListResult);
	}

	/**
	 * to get List of EmployeeStatuary from database based on employeeId
	 */
	@RequestMapping(value="/{empId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeStatuaryDTO> findAllEmployeeStatuarys(@PathVariable("empId") String empId,
			HttpServletRequest req) {

		Long employeeId = Long.parseLong(empId);
		return employeeStatuaryAdaptor
				.databaseModelToUiDtoList(employeeStatuaryService.findAllEmployeeStatuary(employeeId));
	}

	/**
	 * delete EmployeeStatuary object from database based on staturyId (Primary Key)
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteEmp(@RequestParam("statuaryId") String statuaryId, HttpServletRequest req) {
		Long staturyId = Long.parseLong(statuaryId);
		System.out.println("Statuary Id " + statuaryId);
		employeeStatuaryService.delete(staturyId);
	}
}
