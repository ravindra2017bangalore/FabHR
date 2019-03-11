package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.OneTimeDeduction;

public interface OneTimeDeductionService {

	public void save(OneTimeDeduction oneTimeDeduction);
	public List<Object[]> getAllOneTimeDeduction(Long companyId );
	public void saveOneTimeDeductionBulk(List<OneTimeDeduction> oneTimeDeductionList);
	public List<OneTimeDeduction> findOneTimeDeductionForEmployee(Long employeeId, String deductionMonth);
}
