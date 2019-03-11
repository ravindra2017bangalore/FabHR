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
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.service.adaptor.EmployeeIdProofAdaptor;
import com.csipl.hrms.service.employee.EmployeeIdProofService;

@RestController
@RequestMapping("/EmpIdProof")
public class EmployeeIdProofController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeIdProofController.class);
	EmployeeIdProofAdaptor employeeIdProofAdaptor = new EmployeeIdProofAdaptor();

	@Autowired
	EmployeeIdProofService employeeIdProofService;

	/**
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param employeeIdProofDTOList
	 *            This is the second parameter for getting EmployeeIdProof Object
	 *            from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.POST)
	public List<EmployeeIdProofDTO> saveEmployeeIdProof(@PathVariable("employeeId") String employeeId,
			@RequestBody List<EmployeeIdProofDTO> employeeIdProofDTOList, HttpServletRequest req) {
		logger.info("saveEmployeeIdProof is calling : " + "employeeId : " + employeeId + " : List<EmployeeIdProofDTO>  "
				+ employeeIdProofDTOList);
		Long empId = Long.parseLong(employeeId);
		List<EmployeeIdProof> employeeIdProofList = employeeIdProofAdaptor
				.employeeIdProofDtoToDatabaseModelList(employeeIdProofDTOList, empId);
		//// employeeIdProofList.forEach(employeeIdProof -> {
		//// boolean newFlag = employeeIdProof == null ||
		//// employeeIdProof.getEmployeeIdProofsId() == null;
		//// editLogInfoWithoutCG(employeeIdProof, newFlag, req);
		// });

		List<EmployeeIdProof> employeeIdProofListResult = employeeIdProofService.save(employeeIdProofList,req);
		logger.info("saveEmployeeIdProof is end  :" + "employeeIdProofListResult" + employeeIdProofListResult);
		return employeeIdProofAdaptor.databaseModelToUiDtoList(employeeIdProofListResult);
	}	

	/**
	 * to get List of EmployeeIdProof from database based on employeeId
	 */
	@RequestMapping(value="/{empid}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeIdProofDTO> findEmpIdProofs(@PathVariable("empid") String empId,
			HttpServletRequest req) {
		logger.info("findEmpIdProofs is calling :" + "employeeId" + empId);
		Long empIdProofId = Long.parseLong(empId);
		return employeeIdProofAdaptor
				.databaseModelToUiDtoList(employeeIdProofService.findAllemployeeIdProofs(empIdProofId));

	}

	/**
	 * delete EmployeeIdProof object from database based on employeeIdProofId
	 * (Primary Key)
	 */
	@RequestMapping( method = RequestMethod.DELETE)
	public void deleteEmpIdProof(@RequestParam("empIdProofId") String empIdProofId, HttpServletRequest req) {
		logger.info("deleteEmp is calling :" + "empIdProofId" + empIdProofId);
		Long ID = Long.parseLong(empIdProofId);
		employeeIdProofService.delete(ID);
	}

}
