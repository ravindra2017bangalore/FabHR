package com.hrms.org.payrollprocess.loan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.model.payroll.OneTimeDeduction;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public class OneTimeDeductionCalculation {
	 private final Logger logger = LoggerFactory.getLogger(OneTimeDeductionCalculation.class);
	 
	 public  PayOut  calculateOneTimeDeduction( List<OneTimeDeduction> oneTimeDeductionList , ReportPayOut reportPayOut, String processMonth ) {
		
		  BigDecimal deductionAmount = new BigDecimal(0);
		 for (OneTimeDeduction oneTimeDeduction : oneTimeDeductionList) {
			
			 deductionAmount = deductionAmount.add( oneTimeDeduction.getDeductionAmount() );
		 }
		 PayOut payOut = new PayOut();
			PayOutPK pk = new PayOutPK();
			pk.setEmployeeId(reportPayOut.getId().getEmployeeId());
			pk.setProcessMonth(processMonth);
			pk.setPayHeadId(StandardDeductionEnum.Others.getStandardDeduction());
			payOut.setId(pk);
			payOut.setAmount(deductionAmount);
			reportPayOut.setOtherDeduction(deductionAmount);
			
		 return payOut;
	 }
}
