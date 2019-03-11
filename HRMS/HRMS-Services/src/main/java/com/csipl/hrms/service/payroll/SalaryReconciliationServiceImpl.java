package com.csipl.hrms.service.payroll;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.model.payrollprocess.PayRollLock;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.model.payrollprocess.ReportPayOutPK;
import com.csipl.hrms.service.payroll.repository.SalaryReconciliationRepository;
import com.csipl.hrms.service.util.ConverterUtil;
@Transactional
@Service("salaryReconciliationService")
public class SalaryReconciliationServiceImpl implements SalaryReconciliationService{

	@Autowired
	private SalaryReconciliationRepository salaryReconciliationRepository;
	
	@Autowired
	ReportPayOutService reportPayOutService;

	@Autowired
	PayRollLockService payRollLockService;
	@Override
	public List<ReportPayOut> fetchEmpDetailsForSalaryReconciliation(String processMonth,Long departmentId) {
		// TODO Auto-generated method stub
		//List<Object[]>  ReportPayOutList  = salaryReconciliationRepository.fetchEmpDetailsForSalaryReconciliation(departmentId, processMonth);
		//List<ReportPayOut> reportPayOutList = new ArrayList<ReportPayOut>();

		
		/* for ( Object[] report : ReportPayOutList ) { 
			ReportPayOut reportValidation = new ReportPayOut();
			ReportPayOutPK pk = new ReportPayOutPK();
			pk.setProcessMonth(ConverterUtil.getString(report[0]));
			pk.setEmployeeId( ConverterUtil.getLong(report[1]));
			reportValidation.setId( pk );
			reportValidation.setAccountNumber(ConverterUtil.getString( report[2]));
			reportValidation.setNetPayableAmount(ConverterUtil.getBigDecimal(report[3]));
			reportValidation.setTransactionNo(ConverterUtil.getString(report[4]));
			reportValidation.setEmployeeCode(ConverterUtil.getString(report[5]));
		
			reportPayOutList.add( reportValidation );
		}	*/
		return salaryReconciliationRepository.fetchEmpDetailsForSalaryReconciliation(processMonth,departmentId );
		
		
	}
	@Override
	public List<ReportPayOut> fetchEmpDetailsForSalRecoAllDept(String processMonth, Long compnayId) {
		// TODO Auto-generated method stub
		return salaryReconciliationRepository.fetchEmpDetailsForSalRecoAllDept(processMonth,compnayId );
		
	}
	@Override
	public void save(List<ReportPayOut> reportForSave, List<PayRollLock> prl) {
		// TODO Auto-generated method stub
		reportPayOutService.save(reportForSave);
		payRollLockService.save(prl);
		
	}
	@Override
	public void save(List<ReportPayOut> reportForSave, PayRollLock prl) {
		// TODO Auto-generated method stub
		reportPayOutService.save(reportForSave);
		payRollLockService.save(prl);
		
		
	}
	

}
