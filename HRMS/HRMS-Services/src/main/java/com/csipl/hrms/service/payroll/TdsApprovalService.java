package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.dto.payroll.TdsSummaryDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.OtherIncome;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayOut;

public interface TdsApprovalService {

	public void saveTdsApprovalsList(TransactionApprovedHd transactionApprovedHd, Employee employee, FinancialYear financialYear, Long companyId, Long userId, List<PayOut> payOutList, TdsStandardExemption tdsStandardExemption, List<OtherIncome> otherIncomeList,boolean payrollflag,List<TdsTransaction> tdsTrasactionist);
	public TransactionApprovedHd createTdsApprovals( List<TdsGroup> tdsGroupList,List<TdsTransaction> tdsTrasactionist,Employee employee,Long companyId,FinancialYear financialYear,String status );
	public TransactionApprovedHd getTdsApproved(Long employeeId, Long companyId);
	public TdsSummaryDTO getTdsSummary(Employee employee, Long companyId, List<PayOut> payOutList, TdsStandardExemption tdsStandardExemption);
	
	public TransactionApprovedHd getTransactionApprovedHd(Long employeeId,String FinancialYear);

}
