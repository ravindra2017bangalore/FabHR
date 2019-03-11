package com.csipl.hrms.service.employee;

import java.util.List;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payrollprocess.PayOut;
  
public interface PayStructureService {
	public PayStructureHd save(PayStructureHd payStructureHd,Long companyId);
	public void  updateCTC( PayStructureHd payStructureHd, List<PayOut> payOutList );
	public PayStructureHd findPayStructure(Long employeeId);
	public List<PayOut> processPayroll(Long companyId,Long employeeId);
	public List<PayOut>  processPayrollForTds(Long companyId,Long employeeId,PayStructureHd payStructureHd);
 	public PayStructureHd getPayStructureHd(Long payStructureHdId);
	public void saveAll(List<PayStructureHd> payStructureHdList,Long empId,Long companyId ,PayStructureHd payStructure);
 	public void deletePayRevision(Long payStructureHdId);
	public	void getPayRevision(Long employeeId);
	public List<PayStructureHd> getEmployeePayRevisionList(Long employeeId);
	public PayStructureHd getPayStructure(Long longPayStructureHdId);
 }
