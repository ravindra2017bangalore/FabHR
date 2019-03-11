package com.csipl.hrms.employee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.dto.employee.EmployeeDocumentDTO;
import com.csipl.hrms.model.employee.EmployeeDocument;
import com.csipl.hrms.service.adaptor.EmployeeDocumentAdaptor;
import com.csipl.hrms.service.employee.EmployeeDocumentService;
import com.csipl.hrms.service.organization.StorageService;

@RestController
@RequestMapping("/employeeDocument")
public class EmployeeDocumentController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAssetController.class);

	EmployeeDocumentAdaptor employeeDocumentAdaptor = new EmployeeDocumentAdaptor();

	@Autowired
	EmployeeDocumentService employeeDocumentService;
	@Autowired
	StorageService storageService;

	/**
	 * Method performed save operation with file
	 * 
	 * @param empId
	 *            This is the first parameter for getting employeeId from UI
	 * @param file
	 *            This is the second parameter for taking file Input
	 * @param employeeDocumentDto
	 *            This is the third parameter for getting employeeDocument Object
	 *            from UI
	 * @param req
	 *            This is the forth parameter to maintain user session
	 */
	@RequestMapping(value="/{empId}",method = RequestMethod.POST, consumes = "multipart/form-data")

	public void saveEmployeeDocumentDetails(@PathVariable("empId") String empId,
			@RequestPart("uploadFile") MultipartFile file, @RequestPart("info") EmployeeDocumentDTO employeeDocumentDto,
			HttpServletRequest req) {
		logger.info("saveEmployeeDocumentDetails is calling : " + "employeeId : " + empId + " : EmployeeDocumentDTO "
				+ employeeDocumentDto + " : uploadFile" + file);
		EmployeeDocument employeeDocument = employeeDocumentAdaptor.empDocDtoToDatabaseModel(employeeDocumentDto,
				empId);
		// boolean newFlag= employeeDocument == null ||
		// employeeDocument.getEmployeeDocumentsId() == null;
		// editLogInfoWithoutCG(employeeDocument, newFlag, req);
		logger.info("saveEmployeeDocumentDetails is end  :" + employeeDocument);
		employeeDocumentService.save(employeeDocument, file, true);
	}

	/**
	 * to get List of EmployeeDocuments from database based on employeeId
	 */
	@RequestMapping(value="/{empId}",method = RequestMethod.GET)
	public @ResponseBody List<EmployeeDocumentDTO> findAllEmployeeDocuments(@PathVariable("empId") String empId,
			HttpServletRequest req) {
		logger.info("findAllEmployeeDocuments is calling :" + "employeeId" + empId);
		return employeeDocumentAdaptor.databaseModelToUiDtoList(employeeDocumentService.findAllEmployeeDocument(empId));
	}

	/**
	 * delete EmployeeDocument object from database based on documentId (Primary
	 * Key)
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteEmployeeDocument(@RequestParam("ID") String documentId, HttpServletRequest req) {
		logger.info("deleteEmployeeDocument is calling :" + "documentId" + documentId);
		Long empDocId = Long.parseLong(documentId);
		employeeDocumentService.delete(empDocId);
	}
}
