package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.util.List;

import com.csipl.hrms.model.payroll.OtherIncome;

public interface OtherIncomeService {
	public List<OtherIncome> save(List<OtherIncome> otherIncomeList, Long companyId);
	public List<OtherIncome> findOtherIncomes(Long employeeId, Long companyId);
	public BigDecimal getTotalOtherIncome(Long employeeId, Long companyId);
}
