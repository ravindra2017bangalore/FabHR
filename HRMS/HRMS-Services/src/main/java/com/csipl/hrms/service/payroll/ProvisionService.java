package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.dto.payroll.ProvisionDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.model.payroll.Provision;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public interface ProvisionService {
	 public Provision save(Provision provision);
		public List<Object[]>  findAllProvision(Long companyId);
		public Provision findProvision(Long provisionId);
		public List<Object[]>  findAllProvisionforFNF(Long companyId ,List<ProvisionDTO> provisionDtoList);
		public void  saveProvisionSeletment(Provision provision,ReportPayOut reportPayOut);

}
