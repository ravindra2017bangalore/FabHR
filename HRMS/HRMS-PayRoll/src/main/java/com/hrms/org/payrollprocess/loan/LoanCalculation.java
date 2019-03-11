package com.hrms.org.payrollprocess.loan;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;

import com.csipl.hrms.common.enums.PaymentMode;
import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.LoanEMI;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.hrms.org.payrollprocess.earning.AttendanceBased;

public class LoanCalculation {

	private final Logger logger = LoggerFactory.getLogger(LoanCalculation.class);

	public List<PayOut> calculateLoan(List<LoanIssue> loanIssues, ReportPayOut reportPayOut, String processMonth) {

		List<PayOut> payOuts = new ArrayList<PayOut>();

		for (LoanIssue loanIssue : loanIssues) {

			if (loanIssue.getActiveStatus().equalsIgnoreCase("AC")) {

				BigDecimal emiAmount = loanIssue.getEmiAmount();
				DateUtils dateUtils = new DateUtils();
				Date currentDate = dateUtils.getCurrentDate();

				PayOut payOut = new PayOut();
				PayOutPK pk = new PayOutPK();
				pk.setEmployeeId(reportPayOut.getId().getEmployeeId());
				pk.setProcessMonth(processMonth);
				pk.setPayHeadId(StandardDeductionEnum.Loand_And_advance.getStandardDeduction());
				payOut.setId(pk);

				if (loanIssue.getLoanEmis() != null) {
					calculatePendingEMI(loanIssue, reportPayOut, reportPayOut.getUserId(), payOut);
				}
				payOuts.add(payOut);

			}
		}

		return payOuts;
	}

	private void calculatePendingEMI(LoanIssue loanIssue, ReportPayOut reportPayOut, Long userId, PayOut payOut) {

		BigDecimal loanAmount = loanIssue.getLoanAmount();
		BigDecimal loanAmountAfter = loanIssue.getLoanAmount();
		BigDecimal totalAmountRecived = new BigDecimal(0.0);
		BigDecimal totalAmountRecivedAfter = new BigDecimal(0.0);
		BigDecimal pendingAmount = new BigDecimal(0.0);
		LoanEMI loanEMI = new LoanEMI();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		BigDecimal currentMonthLoanAmt = new BigDecimal(0.0);

		for (LoanEMI emi : loanIssue.getLoanEmis()) {
			if (emi.getEmiAmount() != null) {
				totalAmountRecived = totalAmountRecived.add(emi.getEmiAmount());
			}
		}
		
		pendingAmount = loanAmount.subtract(totalAmountRecived);

		if (pendingAmount.compareTo(reportPayOut.getTotalEarning()) > 0) {

			loanEMI.setLoanIssue(loanIssue);
			loanEMI.setDateCreated(currentDate);
			loanEMI.setEmiDate(currentDate);
			loanEMI.setEmiAmount(new BigDecimal(0.0));
			loanEMI.setEmiStatus("OP");
			loanEMI.setUserId(userId);
			loanEMI.setRemarks(
					"Less amount availble, No deduction for month " + reportPayOut.getId().getProcessMonth());
			loanIssue.getLoanEmis().add(loanEMI);

		} else {
			// Settle the loan
			if (loanIssue.getPaymentMode() != null
					&& loanIssue.getPaymentMode().equals(PaymentMode.Salary.getPaymentMode())) {

				closeLoan(loanIssue, userId, payOut, loanIssue.getSettlementAmount()  , loanEMI, currentDate);

			} else if ( loanIssue.getPaymentMode() != null
					&& loanIssue.getPaymentMode().equals(PaymentMode.Salary.getPaymentMode() )  
					 && loanIssue.getSettlementAmount().compareTo(reportPayOut.getTotalEarning()) > 0 ) {
				
				loanEMI.setLoanIssue(loanIssue);
				loanEMI.setDateCreated(currentDate);
				loanEMI.setEmiDate(currentDate);
				loanEMI.setEmiAmount(new BigDecimal(0.0));
				loanEMI.setEmiStatus("OP");
				loanEMI.setUserId(userId);
				loanEMI.setRemarks(
						"No settlement due to Less amount availble " + reportPayOut.getId().getProcessMonth());
				loanIssue.getLoanEmis().add(loanEMI);
				
			}   else {

				if (pendingAmount.compareTo(loanIssue.getEmiAmount()) <= 0) {

					closeLoan(loanIssue, userId, payOut, pendingAmount, loanEMI, currentDate);

				} else {

					loanEMI.setLoanIssue(loanIssue);
					loanEMI.setDateCreated(currentDate);
					loanEMI.setEmiDate(currentDate);
					loanEMI.setEmiAmount(loanIssue.getEmiAmount());

					loanEMI.setUserId(userId);
					loanEMI.setEmiStatus("AC");
					loanIssue.getLoanEmis().add(loanEMI);
					payOut.setAmount(loanIssue.getEmiAmount());

				}
			}

		}

		for (LoanEMI emi : loanIssue.getLoanEmis()) {
			if (emi.getEmiAmount() != null) {
				totalAmountRecivedAfter = totalAmountRecivedAfter.add(emi.getEmiAmount());
			}
		}

		loanAmountAfter = loanAmount.subtract(totalAmountRecivedAfter);
		logger.info(" pending amount ==== "+loanAmountAfter +"  employee Code "+ reportPayOut.getEmployeeCode());
		
		loanIssue.setLoanPendingAmount(loanAmountAfter);
		loanIssue.setDateUpdate(currentDate);

	}

	private void closeLoan(LoanIssue loanIssue, Long userId, PayOut payOut, BigDecimal pendingAmount, LoanEMI loanEMI,
			Date currentDate) {
		loanEMI.setLoanIssue(loanIssue);
		loanEMI.setDateCreated(currentDate);
		loanEMI.setEmiDate(currentDate);
		loanEMI.setEmiAmount(pendingAmount);

		loanEMI.setUserId(userId);
		loanEMI.setEmiStatus("CE");
		loanIssue.getLoanEmis().add(loanEMI);
		loanIssue.setActiveStatus("CE");

		payOut.setAmount(pendingAmount);
	}

}
