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
import com.csipl.hrms.dto.employee.EmployeeFamilyDTO;
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.service.adaptor.FamilyAdaptor;
import com.csipl.hrms.service.employee.FamilyService;

@RestController
@RequestMapping("/familyDetails")
public class FamilyDetailsController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(FamilyDetailsController.class);
	@Autowired
	FamilyService familyService;
	FamilyAdaptor familyAdaptor = new FamilyAdaptor();

	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param employeeFamilyDtoList
	 *            This is the second parameter for getting EmployeeFamily Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value="/{empId}" ,method = RequestMethod.POST)
	public List<EmployeeFamilyDTO> save(@PathVariable("empId") String empId,
			@RequestBody List<EmployeeFamilyDTO> employeeFamilyDtoList, HttpServletRequest req) {

		logger.info(
				"FamilyDetailsController save empId is :" + empId + "employeeFamilyDtoList" + employeeFamilyDtoList);
		List<EmployeeFamily> employeeFamilyList = familyAdaptor.empFamilyDtoToDatabaseModelList(employeeFamilyDtoList,
				empId);
		// employeeFamilyList.forEach(employeeFamily -> {
		// boolean newFlag =employeeFamily!=null && employeeFamily.getFamilyId() != null
		// ? false : true;
		// editLogInfoWithoutCG(employeeFamily, newFlag, req);
		// });
		return familyAdaptor.databaseModelToUiDtoList(familyService.saveAll(employeeFamilyList));
	}

	/**
	 * to get List of EmployeeFamily from database based on employeeId
	 */
	@RequestMapping(path="/{empId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeFamilyDTO> getAllEmployeeFamilyDetails(@PathVariable("empId") String empId,
			HttpServletRequest req) {
		logger.info("FamilyDetailsController getAllEmployeeFamilyDetails  empId is :" + empId);
		return familyAdaptor.databaseModelToUiDtoList(familyService.findAllEmployeeDetails(empId));
	}

	/**
	 * delete EmployeeFamily object from database based on familyId (Primary Key)
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteEmp(@RequestParam("familyID") String familyID, HttpServletRequest req) {
		logger.info("FamilyDetailsController deleteEmp is :" + familyID);

		Long familyId = Long.parseLong(familyID);
		familyService.delete(familyId);
	}
}
