package com.csipl.hrms.service.report;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.service.report.repository.PayrollReportRepository;

@Service("payrollReportService")
public class PayrollReportServiceImpl implements  PayrollReportService{

	
	@Autowired
	PayrollReportRepository payrollReportRepository;
	
	@Override
	public List<Object[]> findProvisionReport(Long companyId, Date fromDate, Date toDate, Long departmentId) {
	System.out.println("service===fromdate"+fromDate+ "toDate=="+toDate);
	if(departmentId==0) {
		return payrollReportRepository.findProvisionReport(companyId,fromDate,toDate);
	}
	else
		return payrollReportRepository.findProvisionReportbydeptId(companyId,fromDate,toDate,departmentId);
	}
	@Override
	public List<Object[]> findPayrollReportByMonth(Long companyId, Long departmentId, String processMonth) {
		if(departmentId==0)
			return payrollReportRepository.findPayrollReportByMonth( companyId, processMonth);
		else
			return payrollReportRepository.findPayrollReportByMonthBydept( companyId, departmentId, processMonth);	
	}
	@Override
	public List<Object[]> findPayrollReportByempId(Long companyId, Long employeeId, String fromProcessMonth,
			String toProcessMonth) {
		// TODO Auto-generated method stub
		return payrollReportRepository.findPayrollReportByEmpId(companyId, employeeId ,fromProcessMonth ,toProcessMonth);
	}
	@Override
	public List<Object[]> findPayRollBankTRF(Long companyId, String processMonth, String bankName) {
 		return payrollReportRepository.findPayRollBankTRF(companyId,processMonth, bankName);
	}
	@Override
	public Long checkForRecoReprotAvailability(Long longDeptId,String processMonth, String checkReco) {
   		return payrollReportRepository.checkForRecoReprotAvailability(checkReco,longDeptId,processMonth);
	}
	@Override
	public List<Object[]> findReconciliationReport(Long companyId, Long longDeptId, String processMonth, String checkReco) {
		String status=null;
		if(checkReco.equals("true")) {
			status ="AC";
  		 if(longDeptId==0) {
  		
  			return payrollReportRepository.findNonReconciliationReportWithoutDept(companyId,processMonth,checkReco,status);}
  		else
		return payrollReportRepository.findNonReconciliationReportWithDept(companyId,longDeptId,processMonth,checkReco,status);
  		}
		else
		{
			status ="AC";
			if(longDeptId==0)
	  			return payrollReportRepository.findReconciliationReportWithoutDept(companyId,processMonth,checkReco,status);
	  		else
			return payrollReportRepository.findReconciliationReportWithDept(companyId,longDeptId,processMonth,checkReco,status);	
		}
	}
	@Override
	public List<Object[]> findPTReport(Long companyId, String fromProcessMonth, String toProcessMonth,
			Long departmentId, Long empId, Long stateId) {
 		return payrollReportRepository.findPTReport(companyId,fromProcessMonth,toProcessMonth,empId,stateId,departmentId);
	}
	@Override
	public List<Object[]> findEpfEcrReport(Long companyId, String processMonth) {
		// TODO Auto-generated method stub
		return payrollReportRepository.findEpfEcrReport(companyId, processMonth);
	} 
	
	@Override
	public List<Object[]> findEpfReport(Long companyId, String processMonth) {
		// TODO Auto-generated method stub
		return payrollReportRepository.findEpfReport(companyId, processMonth);
	}
	@Override
	public List<Object[]> findEsicEcrReport(Long companyId, String processMonth) {
		// TODO Auto-generated method stub
		return payrollReportRepository.findEsicEcrReport(companyId, processMonth);
	}
	@Override
	public List<Object[]> findEsicReport(Long companyId, String processMonth) {
		// TODO Auto-generated method stub
		return payrollReportRepository.findEsicReport(companyId, processMonth);
	}
}
