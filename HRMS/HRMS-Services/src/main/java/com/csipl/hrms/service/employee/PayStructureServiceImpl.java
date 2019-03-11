package com.csipl.hrms.service.employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.OtherIncome;
import com.csipl.hrms.model.payroll.PayHead;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.service.employee.repository.PayStructureRepository;
import com.csipl.hrms.service.payroll.FinancialYearService;
import com.csipl.hrms.service.payroll.InvestmentService;
import com.csipl.hrms.service.payroll.OtherIncomeService;
import com.csipl.hrms.service.payroll.PayHeadService;
import com.csipl.hrms.service.payroll.PayRollService;
import com.csipl.hrms.service.payroll.TdsApprovalService;
import com.csipl.hrms.service.payroll.TdsPayrollService;
import com.csipl.hrms.service.payroll.TdsStandardExemptionService;
import com.csipl.hrms.service.payroll.TdsTransactionFileService;
import com.csipl.hrms.service.payroll.TdsTransactionService;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;

@Transactional
@Service("payStructureService")
public class PayStructureServiceImpl implements PayStructureService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(PayStructureServiceImpl.class);

	@Autowired
	private PayStructureRepository payStructureRepository;

	@Autowired
	TdsApprovalService tdsApprovalService;
	
	@Autowired
	PayRollService payRollService;
	
	@Autowired
	PayHeadService payHeadService;
	
	@Autowired
	private ReportPayOutRepository reportPayOutRepository;
	
	@Autowired
	PayStructureService payStructureService;
	
	@Autowired
	InvestmentService investmentService;

	@Autowired
	FinancialYearService financialYearService;

	@Autowired
	TdsPayrollService tdsPayrollService;


	@Autowired
	TdsTransactionService tdsTransactionService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	TdsTransactionFileService tdsTransactionFileService;

	@Autowired
	OtherIncomeService otherIncomeService;

	@Autowired
	TdsStandardExemptionService tdsStandardExemptionService;
	
	

	/**
	 * Method performed save OR update operation
	 */
	@Override
	public PayStructureHd save(PayStructureHd payStructureHd,Long companyId) {
		logger.info("save payStructureHd===== "+payStructureHd);
 		if(payStructureHd.isUpdateFlage() && payStructureHd.getPayStructureHdId()!=null) {
			payStructureRepository.delete(payStructureHd.getPayStructureHdId());
		}
 		PayStructureHd PayStructureHd=payStructureRepository.save(payStructureHd);
 		
 		//Tds Calculate
 		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		Long empId= payStructureHd.getEmployee().getEmployeeId();
		//Long companyId=payStructureHd.getEmployee().getCompany().getCompanyId();
	    logger.info("tdsDeclaration is calling employeeId :"+empId+"companyId is :"+companyId+"currentDate :"+currentDate);

		List<PayOut> payOutList1 = payStructureService.processPayrollForTds(companyId, empId,payStructureHd);
		
        TdsStandardExemption tdsStandardExemption1 = tdsStandardExemptionService.getTdsStandardExemption(companyId);
		List<OtherIncome> otherIncomeList1 = otherIncomeService.findOtherIncomes(empId, companyId);
		Employee employee1 = employeePersonalInformationService.findEmployeesById(empId);
        
		logger.info("payOutList "+payOutList1+"tdsStandardExemption : "+tdsStandardExemption1+"otherIncomeList :"+otherIncomeList1+"employee"+employee1);
		
		//tds declaration process required data gethering----
		FinancialYear financialYear1 = financialYearService.findCurrentFinancialYear(currentDate,companyId);
		//List<TdsGroup> tdsGroupList = investmentService.getInvestmentList(companyId);
		List<TdsTransaction> tdsTrasactionist = tdsTransactionService.getTdsTrasactionListforApproval(empId,financialYear1.getFinancialYear());
		
		TransactionApprovedHd transactionApprovedHd1 = tdsApprovalService.getTransactionApprovedHd(employee1.getEmployeeId(), financialYear1.getFinancialYear());

		logger.info("financialYear "+financialYear1+"tdsTrasactionist :"+tdsTrasactionist+"getCompanyId"+companyId);
 		
 		
 		
 		
 		
 		//
 		
 		tdsApprovalService.saveTdsApprovalsList(transactionApprovedHd1, employee1, financialYear1,companyId, null,payOutList1, tdsStandardExemption1, otherIncomeList1,true,null);
		 return PayStructureHd;
	}
	/**
	 * to get PayStructureHd object from database based on employeeId and current date
	 */
	@Override
	public PayStructureHd findPayStructure(Long employeeId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		logger.info("currentDate payStructureService == "+currentDate);
		logger.info("employeeId payStructureService == "+employeeId);
  		return payStructureRepository.payStructureRevisionList(currentDate,employeeId);
  	}
	/**
	 * to get Employee Earning and Deduction from database based on employeeId and companyId
	 */
	@Override
  	public List<PayOut> processPayroll(Long companyId,Long employeeId) {
		logger.info(" payStructureHd===== "+"companyId"+companyId +" employeeId "+employeeId);
		List<PayHead>  payHeads = payHeadService.findAllPayHeadOfCompany(companyId);
		List<PayOut> payOuts = payRollService.processPayRoll(companyId, employeeId);
		
		for ( PayOut payOut : payOuts ) {
			for ( PayHead payHead : payHeads) {
				if ( payHead.getPayHeadId() == payOut.getId().getPayHeadId() ) {
					payOut.setPayHeadName(payHead.getPayHeadName());
					payOut.setEarningDeduction(payHead.getEarningDeduction());
					break;
				}
			}
 		}
		
	
		
  		return payOuts;
    }

	
	
	@Override
  	public List<PayOut> processPayrollForTds(Long companyId,Long employeeId,PayStructureHd payStructureHd ){
		
		logger.info(" processPayrollForTds===== "+"companyId"+companyId +" employeeId "+employeeId);
		
		List<PayHead>  payHeads = payHeadService.findAllPayHeadOfCompany(companyId);
		List<PayOut> payOuts = payRollService.processPayRollForTds(companyId, employeeId,payStructureHd);
		
		for ( PayOut payOut : payOuts ) {
			for ( PayHead payHead : payHeads) {
				if ( payHead.getPayHeadId() == payOut.getId().getPayHeadId() ) {
					payOut.setPayHeadName(payHead.getPayHeadName());
					payOut.setEarningDeduction(payHead.getEarningDeduction());
					break;
				}
			}
 		}
		
	
		
  		return payOuts;
		
	}
	@Override
	public void updateCTC( PayStructureHd payStructureHd, List<PayOut> payOutList ) {
		BigDecimal grossPay =   payStructureHd.getGrossPay(); 
		BigDecimal ctc =   new BigDecimal(0); 
		BigDecimal employeerDeduction = new BigDecimal(0);
		
		ctc = 	ctc.add( grossPay );
		
		
		BigDecimal emplyoer_pf = new BigDecimal(0);
		BigDecimal emplyoeresi = new BigDecimal(0);
		BigDecimal emplyoer_pension = new BigDecimal(0);
		
		for ( PayOut  payOut :  payOutList ) {
			
			if ( payOut.getId().getPayHeadId() == StandardDeductionEnum.PF_Employer_Contribution.getStandardDeduction() ) {
				 emplyoer_pf =  emplyoer_pf.add( payOut.getAmount() );
				 ctc = ctc.add( emplyoer_pf );
				
			} else if ( payOut.getId().getPayHeadId() == StandardDeductionEnum.ESI_Employer_Contribution.getStandardDeduction() ) {
				 emplyoeresi = emplyoeresi.add( payOut.getAmount() );
				 ctc = ctc.add( emplyoeresi );
				
			} else if ( payOut.getId().getPayHeadId() == StandardDeductionEnum.Pension_Employer_Contribution.getStandardDeduction() ) {
				 emplyoer_pension = emplyoer_pension.add( payOut.getAmount() );
				 ctc = ctc.add( emplyoer_pension );
			}
			
		}
 		payStructureHd.setCostToCompany( ctc );
		payStructureRepository.save(payStructureHd);
	}

	/**
	 * to get Employee Pay object from database based on payStructureHdId (Primary Key)
	 */
	@Override
	public PayStructureHd getPayStructureHd(Long payStructureHdId) {
 		return payStructureRepository.findOne(payStructureHdId);
	}
	/**
	 * Method Performed save operation ,save List of pay structure into database
	 * 
	 */
	@Override
	public void saveAll(List<PayStructureHd> payStructureHdList,Long empId,Long companyId,PayStructureHd payStructureHd) {
    		  payStructureRepository.save(payStructureHdList);

    	 		//Tds Calculate
    	 		DateUtils dateUtils = new DateUtils();
    			Date currentDate = dateUtils.getCurrentDate();
    			//Long empId= payStructureHd.getEmployee().getEmployeeId();
    			//Long companyId=payStructureHd.getEmployee().getCompany().getCompanyId();
    		    logger.info("tdsDeclaration is calling employeeId :"+empId+"companyId is :"+companyId+"currentDate :"+currentDate);

    			List<PayOut> payOutList1 = payStructureService.processPayrollForTds(companyId, empId,payStructureHd);
    			
    	        TdsStandardExemption tdsStandardExemption1 = tdsStandardExemptionService.getTdsStandardExemption(companyId);
    			List<OtherIncome> otherIncomeList1 = otherIncomeService.findOtherIncomes(empId, companyId);
    			Employee employee1 = employeePersonalInformationService.findEmployeesById(empId);
    	        
    			logger.info("payOutList "+payOutList1+"tdsStandardExemption : "+tdsStandardExemption1+"otherIncomeList :"+otherIncomeList1+"employee"+employee1);
    			
    			//tds declaration process required data gethering----
    			FinancialYear financialYear1 = financialYearService.findCurrentFinancialYear(currentDate,companyId);
    			//List<TdsGroup> tdsGroupList = investmentService.getInvestmentList(companyId);
    			List<TdsTransaction> tdsTrasactionist = tdsTransactionService.getTdsTrasactionListforApproval(empId,financialYear1.getFinancialYear());
    			
    			TransactionApprovedHd transactionApprovedHd1 = tdsApprovalService.getTransactionApprovedHd(employee1.getEmployeeId(), financialYear1.getFinancialYear());

    			logger.info("financialYear "+financialYear1+"tdsTrasactionist :"+tdsTrasactionist+"getCompanyId"+companyId);
    	 		
    	 		
    	 		
    	 		
    	 		
    	 		//
    	 		
    	 		tdsApprovalService.saveTdsApprovalsList(transactionApprovedHd1, employee1, financialYear1,companyId, null,payOutList1, tdsStandardExemption1, otherIncomeList1,true,null);

	}
	/**
	 * Delete employee pay  from database based on payStructureHdId (Primary key)
	 */
	@Override
	public void deletePayRevision(Long payStructureHdId) {
		payStructureRepository.delete(payStructureHdId);
		
	}
	/**
	 * to get Employee Pay from database based on employeeId and currentDate and delete 
	 * if Employee Pay presents in database 
	 */
	@Override
	public void getPayRevision(Long employeeId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		PayStructureHd payStructureHd=	payStructureRepository.getPayRevision(currentDate,employeeId);
		if(payStructureHd!=null && payStructureHd.getPayStructureHdId()!=null) 
		payStructureRepository.delete(payStructureHd.getPayStructureHdId());
 	}
	/**
	 * to get List of Employee Pay from database based on employeeId
	 */
	@Override
	public List<PayStructureHd> getEmployeePayRevisionList(Long employeeId) {
 		return payStructureRepository.getEmployeePayRevisionList(employeeId);
	}
	@Override
	public PayStructureHd getPayStructure(Long longPayStructureHdId) {
 		return payStructureRepository.findOne(longPayStructureHdId);
	}
}
