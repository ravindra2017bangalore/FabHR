package com.csipl.hrms.service.employee;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.model.payroll.TdsGroup;

public interface EmployeeIdProofService {

	public List<EmployeeIdProof> save(List<EmployeeIdProof> employeeIdProof,HttpServletRequest request);
	public List<EmployeeIdProof> findAllemployeeIdProofs(Long employeeId);
	public EmployeeIdProof update(EmployeeIdProof employeeIdProof);
	public void delete(Long empIdProofId);
	public List<EmployeeIdProof> saveEmployeeIdProof(List<EmployeeIdProof> employeeIdProofList);

}
