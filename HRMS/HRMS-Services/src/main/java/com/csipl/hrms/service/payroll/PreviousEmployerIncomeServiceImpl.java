package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.PreviousEmployerIncomeRepository;

@Service("previousEmployerIncomeService")
public class PreviousEmployerIncomeServiceImpl implements PreviousEmployerIncomeService {

	@Autowired
	PreviousEmployerIncomeRepository previousEmployerIncomeRepository;
	
	@Autowired
	FinancialYearRepository financialYearRepository;
	
	@Override
	public List<Object[]> getPreviousEmployerIncomeObjectList(Long employeeId, String financialYear) {
		return previousEmployerIncomeRepository.findAllPreviousEmployerIncome(employeeId, financialYear);
	}

	@Override
	public void save(List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		previousEmployerIncomeTdsList.forEach(previousEmployerIncomeTds->{
			previousEmployerIncomeTds.setFinancialYear(financialYear.getFinancialYear());
		});
		previousEmployerIncomeRepository.save(previousEmployerIncomeTdsList);
	}

	@Override
	public List<PreviousEmployerIncomeTds> getPreviousEmployerIncomeList(Long employeeId, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		return previousEmployerIncomeRepository.getAllPreviousEmployerIncome(employeeId, financialYear.getFinancialYear());
	}
}
