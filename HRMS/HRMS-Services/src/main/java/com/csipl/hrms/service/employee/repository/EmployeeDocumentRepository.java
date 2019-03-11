package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.EmployeeDocument;

public interface EmployeeDocumentRepository extends CrudRepository<EmployeeDocument, Long> {
	@Query(" from EmployeeDocument where employeeId=?1  ORDER BY  employeeDocumentsId  DESC")
	 public List<EmployeeDocument> findAllEmployeeDocument(Long employeeId);
}
