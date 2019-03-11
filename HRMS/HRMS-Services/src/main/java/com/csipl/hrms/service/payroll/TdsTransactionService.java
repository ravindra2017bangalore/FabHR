package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.payroll.TdsTransaction;

public interface TdsTransactionService {

	public List<Object[]> getTdsTransactionObjectList(Long employeeId,Long companyId);
	public List<Object[]> getTdsSummaryObjectList(Long employeeId,Long companyId);
	public void save(List<TdsTransaction> tdsTransactionList,Long employeeId, Long companyId);
	public List<TdsTransaction> getTdsTrasactionListforApproval(Long empId,String financialYear);
	public List<TdsTransaction> getTdsTransactionList(Long employeeId,Long companyId);
	public BigDecimal getTotalInvestment(Long employeeId,Long companyId);
}
