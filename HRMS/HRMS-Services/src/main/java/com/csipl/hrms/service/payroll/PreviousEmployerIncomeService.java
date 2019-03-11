package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;

public interface PreviousEmployerIncomeService {

	public void  save(List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList, Long companyId);
	public List<Object[]> getPreviousEmployerIncomeObjectList(Long employeeId,String financialYear);
	public List<PreviousEmployerIncomeTds> getPreviousEmployerIncomeList(Long employeeId,Long companyId);

}
