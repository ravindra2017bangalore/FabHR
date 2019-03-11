package com.csipl.hrms.service.employee;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.model.employee.EmployeeDocument;
import com.csipl.hrms.service.employee.repository.EmployeeDocumentRepository;
import com.csipl.hrms.service.organization.StorageService;
@Transactional
@Service("employeeDocumentService")
public class EmployeeDocumentServiceImpl implements EmployeeDocumentService{
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDocumentServiceImpl.class);

	@Autowired
	private EmployeeDocumentRepository employeeDocumentRepository;
	
	/**
	 * to get List of EmployeeDocuments from database based on employeeId
	 */
	@Override
	public List<EmployeeDocument> findAllEmployeeDocument(String empId) {
		Long employeeId=Long.parseLong(empId);
		return employeeDocumentRepository.findAllEmployeeDocument(employeeId);
	}

	@Autowired
	StorageService storageService;
	
	/**
	 * Method performed save operation with file 
 	 */
	@Override
	public void save(EmployeeDocument employeeDocument , MultipartFile file, boolean fileFlag) {	
			String fileName = "";
				fileName = "Employee_" + employeeDocument.getEmployeeId().toString()+"_DocId_"+employeeDocument.getDocumentsId();
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				fileName = fileName + "." + extension;
				System.out.println("File with extension : " + fileName);	
				String path = File.separator + "images" + File.separator + "employeeDocImages";
				String dbPath = path + File.separator + fileName;
				System.out.println("dbPath " +dbPath);
		employeeDocument.setFileLocation(dbPath);
		employeeDocumentRepository.save(employeeDocument);
		storageService.store(file, path, fileName);
	}
	/**
	 * delete EmployeeDocument object from database based on documentId (Primary Key)
	 */
	@Override
	public void delete(Long empDocId) {
		employeeDocumentRepository.delete(empDocId);
	}

	@Override
	public EmployeeDocument update(EmployeeDocument EmployeeDocument) {
		// TODO Auto-generated method stub
		return null;
	}
}
