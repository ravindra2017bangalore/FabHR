package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.organization.StorageService;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.TdsApprovalRepository;
import com.csipl.hrms.service.payroll.repository.TdsTransactionRepository;

@Service("tdsTransactionService")
public class TdsTransactionServiceImpl implements TdsTransactionService {

	@Autowired
	TdsTransactionRepository tdsTransactionRepository;
	
	@Autowired
	FinancialYearRepository financialYearRepository;
	
	@Autowired
	TdsApprovalRepository tdsApprovalRepository;
	
	@Autowired
	StorageService storageService;
	
	@Override
	public List<Object[]> getTdsTransactionObjectList(Long employeeId,Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		return tdsTransactionRepository.getTdsTransactionObjectList(employeeId, financialYear.getFinancialYear());
	}

	/**
	 * Save OR update department object into Database 
	 */
	@Override
	public void save(List<TdsTransaction> tdsTransactionList, Long employeeId,Long companyId) {		
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		tdsTransactionList.forEach(tdsTransaction->{
			tdsTransaction.setFinancialYear(financialYear.getFinancialYear());
		});
		tdsTransactionRepository.save(tdsTransactionList);
	}
	/**
	 * To get List of TdsTransaction objects from Database based on empIdId and financialYear
	 */
	@Override
	public List<TdsTransaction> getTdsTrasactionListforApproval(Long empId, String financialYear) {
		return tdsApprovalRepository.getTdsTrasactionList(empId,financialYear);
	}

	@Override
	public List<TdsTransaction> getTdsTransactionList(Long employeeId,Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		return tdsTransactionRepository.getTdsTransactionList(employeeId, financialYear.getFinancialYear());
	}

	@Override
	public List<Object[]> getTdsSummaryObjectList(Long employeeId, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		return  tdsTransactionRepository.getTdsSummaryObjectList(employeeId, financialYear.getFinancialYear());
	}

	@Override
	public BigDecimal getTotalInvestment(Long employeeId, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate,companyId);
		return tdsTransactionRepository.getTotalInvestment(employeeId, financialYear.getFinancialYear());
	}

}
