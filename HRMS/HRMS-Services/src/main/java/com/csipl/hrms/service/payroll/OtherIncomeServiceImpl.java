package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.OtherIncome;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.OtherIncomeRepository;

@Service("otherIncomeService")
public class OtherIncomeServiceImpl implements OtherIncomeService {

	@Autowired
	OtherIncomeRepository otherIncomeRepository;
	
	@Autowired
	FinancialYearRepository financialYearRepository;
	
	@Override
	public List<OtherIncome> save(List<OtherIncome> otherIncomeList, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate, companyId);
		otherIncomeList.forEach(otherIncome->{
			otherIncome.setFinancialYear(financialYear.getFinancialYear());
		});
		List<OtherIncome> otherIncomes=(List<OtherIncome>) otherIncomeRepository.save(otherIncomeList);
		return otherIncomes;
	}

	@Override
	public List<OtherIncome> findOtherIncomes(Long employeeId, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate, companyId);
		return otherIncomeRepository.findAllOtherIncome(employeeId,financialYear.getFinancialYear());
	}

	@Override
	public BigDecimal getTotalOtherIncome(Long employeeId, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate, companyId);
		return otherIncomeRepository.findOtherIncomeSum(employeeId, financialYear.getFinancialYear());
	}

}
