package com.csipl.hrms.org.controller;

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

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.DepartmentAdaptor;
import com.csipl.hrms.service.organization.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;

	DepartmentAdaptor departmentAdaptor = new DepartmentAdaptor();

	/**
	 * @param departmentDto
	 *            This is the first parameter for getting Department Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveDepartment(@RequestBody DepartmentDTO departmentDto, HttpServletRequest req) {
		logger.info("saveDepartment is calling : DepartmentDTO "+ departmentDto);
		Department department = departmentAdaptor.uiDtoToDatabaseModel(departmentDto);
		/*boolean newFlag = (department != null) && (department.getDepartmentId() != null ? false : true);
		editLogInfo(department, newFlag, req);*/
		departmentService.save(department);
		logger.info("saveDepartment is end  :"  + department);
	}
	/**
	 * to get all departments List from database based on companyId
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getAllDepartments(@RequestParam("companyId") String companyId,HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("getAllDepartments is calling :  " );
		Long longcompanyId = Long.parseLong(companyId);
		List<Department> departmentList = departmentService.findAllDepartment( longcompanyId );
		logger.info("getAllDepartments is end : Department List " + departmentList );
		if (departmentList != null)
			return departmentAdaptor.databaseModelToUiDtoList(departmentList);
		else
			throw new ErrorHandling("Departments are not available in company");
	}
 	/**
	 * to get department object  from database based on departmentId
	 */
	@RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
	public @ResponseBody DepartmentDTO getDepartment(@PathVariable("departmentId") String departmentId,HttpServletRequest req) {
		logger.info("getDepartment is calling : departmentId ="+ departmentId );
		Long departmentID = Long.parseLong(departmentId);
		return departmentAdaptor.databaseModelToUiDto(departmentService.findDepartment(departmentID));
	}
}
