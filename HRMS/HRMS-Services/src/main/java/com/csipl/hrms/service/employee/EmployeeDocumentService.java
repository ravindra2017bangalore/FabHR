package com.csipl.hrms.service.employee;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.employee.EmployeeDocument;

public interface EmployeeDocumentService {

	public List<EmployeeDocument> findAllEmployeeDocument(String empId);
	 public void save(EmployeeDocument employeeDocument , MultipartFile file , boolean fileFlag);
	 public void delete(Long empDocId);
	 public EmployeeDocument update(EmployeeDocument EmployeeDocument);
}
