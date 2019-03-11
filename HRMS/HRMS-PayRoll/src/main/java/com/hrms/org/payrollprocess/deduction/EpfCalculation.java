package com.hrms.org.payrollprocess.deduction;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;
import com.hrms.org.payrollprocess.dto.PayRollProcessHDDTO;
import com.hrms.org.payrollprocess.util.PayRollProcessUtil;

public class EpfCalculation extends Calculation {

	
	@Override
	public ArrayList<PayOut> getCalculation(  List<PayRollProcessDTO> epfList , PayRollProcessHDDTO payRollProcessHDDTO , PayrollControl payrollControl) {
		// TODO Auto-generated method stub
		BigDecimal amount = new BigDecimal(0);
		BigDecimal baseEarning = new BigDecimal(0);
		ArrayList<PayOut> listDeduction = new ArrayList<>();

	
		
				for (PayRollProcessDTO obj : epfList) {
					amount = amount.add(obj.getPayOut().getAmount()); // calculated
					baseEarning = baseEarning.add( obj.getPayStructure().getAmount() ); // original
				}
		
			
			
			Epf epf = payRollProcessHDDTO.getEpf();
			
			if (  epf.getMaxBasicLimit().compareTo(baseEarning) ==  1 ||  epf.getMaxBasicLimit().compareTo(baseEarning) == 0) { // EPF amount is less than 150000 ( max limit ) 
				
				//System.out.println(" EPF amount is less than 150000 ( max limit )  ");
				payRollProcessHDDTO.getReportPayOut().setPensionEarningSalary( amount );
				
				
				setPFValue(payRollProcessHDDTO, amount, listDeduction, epf);
				
				return listDeduction;

			} else if ( epf.getIsActual() != null &&   epf.getIsActual().equalsIgnoreCase("Y")  && ( epf.getMaxBasicLimit().compareTo(baseEarning) == -1 ) ) {
				
				ReportPayOut reportPayOut = payRollProcessHDDTO.getReportPayOut();
				BigDecimal pensionAmount = calcaulatePensionAmountInCaseMoreThanLimit( epf.getMaxBasicLimit() , reportPayOut, payrollControl );
				payRollProcessHDDTO.getReportPayOut().setPensionEarningSalary( pensionAmount );
				
				
				setPFValue(payRollProcessHDDTO, amount, listDeduction, epf);
				
				return listDeduction;
				
			} else if ( epf.getMaxBasicLimit().compareTo(baseEarning) == -1 ) { // EPF amount is greater than 150000 ( max limit ) 
				
				
				ReportPayOut reportPayOut = payRollProcessHDDTO.getReportPayOut();
				BigDecimal pensionAmount = calcaulatePensionAmountInCaseMoreThanLimit( epf.getMaxBasicLimit() , reportPayOut, payrollControl );
				
				payRollProcessHDDTO.getReportPayOut().setPensionEarningSalary( pensionAmount );
				
				
				//For employeer pension in LOP case	
				setPFValue(payRollProcessHDDTO, pensionAmount, listDeduction, epf);

				
					
				
				return listDeduction;
			} /*
				 * else if(1==2) {
				 * 
				 * //"Voluntary_Contribution"
				 * 
				 * if(epf.getMaxBasicLimit().equals(15000.00)) {
				 * 
				 * BigDecimal
				 * employee_contribution_Pf=pay.getAmount().divide((attandance.getPayDays().
				 * multiply(Days_Worked))).multiply(epf.getEmployeePer()); BigDecimal
				 * employee_voluntary_contribution= new
				 * BigDecimal("5000").multiply(epf.getEmployeePer()); BigDecimal
				 * employer_Contribution_For_PF=pay.getAmount().divide((attandance.getPayDays().
				 * multiply(Days_Worked))).multiply(epf.getEmployerPer()); BigDecimal
				 * employer_pension_Contribution=pay.getAmount().divide((attandance.getPayDays()
				 * .multiply(Days_Worked))).multiply(epf.getEmployerPensionPer()); BigDecimal
				 * employer_Pf=employer_Contribution_For_PF.add(employer_pension_Contribution);
				 * BigDecimal PF=employee_contribution_Pf.add(employer_Pf).add(
				 * employee_voluntary_contribution); PayStructure payStructure =new
				 * PayStructure(); payStructure.setAmount(PF); listDeduction.put("EPF",
				 * payStructure); }else if (epf.getMaxBasicLimit().doubleValue()>15000.00) {
				 * 
				 * BigDecimal
				 * employee_contribution_Pf=pay.getAmount().divide((attandance.getPayDays().
				 * multiply(Days_Worked))).multiply(epf.getEmployeePer()); BigDecimal
				 * employee_voluntary_contribution= new
				 * BigDecimal("5000").multiply(epf.getEmployeePer()); BigDecimal
				 * employer_Contribution_For_PF=epf.getMaxBasicLimit().divide((attandance.
				 * getPayDays().multiply(Days_Worked))).multiply(epf.getEmployerPer());
				 * BigDecimal
				 * employer_pension_Contribution=epf.getMaxBasicLimit().divide((attandance.
				 * getPayDays().multiply(Days_Worked))).multiply(epf.getEmployerPensionPer());
				 * BigDecimal
				 * employer_Pf=employer_Contribution_For_PF.add(employer_pension_Contribution);
				 * BigDecimal PF=employee_contribution_Pf.add(employer_Pf).add(
				 * employee_voluntary_contribution); PayStructure payStructure =new
				 * PayStructure(); payStructure.setAmount(PF); listDeduction.put("EPF",
				 * payStructure);
				 * 
				 * } }
				 */

		
		return listDeduction ;

	}

	/**
	 * @param payRollProcessHDDTO
	 * @param amount
	 * @param listDeduction
	 * @param epf
	 */
	private void setPFValue(PayRollProcessHDDTO payRollProcessHDDTO, BigDecimal amount, ArrayList<PayOut> listDeduction,
			Epf epf) {
		BigDecimal employee_contribution_Pf1 = amount.multiply(epf.getEmployeePer()).divide(new BigDecimal(100),
				2, RoundingMode.HALF_UP);
		
		BigDecimal employer_Contribution_For_PF = amount.multiply(epf.getEmployerPer())
				.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);

		BigDecimal employer_pension_Contribution = amount.multiply(epf.getEmployerPensionPer())
				.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
		

		setProvidentFundValue(payRollProcessHDDTO, 
				listDeduction, employee_contribution_Pf1, 
				 StandardDeductionEnum.PF_Employee_Contribution.getStandardDeduction());
		
		
		setProvidentFundValue(payRollProcessHDDTO, 
				listDeduction, employer_Contribution_For_PF, 
				 StandardDeductionEnum.PF_Employer_Contribution.getStandardDeduction());
		
		
		setProvidentFundValue(payRollProcessHDDTO, 
				listDeduction, employer_pension_Contribution, 
				 StandardDeductionEnum.Pension_Employer_Contribution.getStandardDeduction());
	}
	
	private BigDecimal calcaulatePensionAmountInCaseMoreThanLimit( BigDecimal maxLimit, ReportPayOut reportPayOut, PayrollControl payrollControl ) {
		
		BigDecimal payDays =  new BigDecimal( payrollControl.getPayrollDays());
		int daysWorkedStep1 = payDays.subtract( reportPayOut.getAbsense() ).intValueExact();
		BigDecimal dayWorked = new BigDecimal( daysWorkedStep1 );
		BigDecimal pensionAmount1 = maxLimit.divide(payDays, 3, RoundingMode.HALF_UP );
		BigDecimal pensionAmount = pensionAmount1.multiply( dayWorked );
		BigDecimal finalAmount  = pensionAmount.setScale(1, RoundingMode.HALF_UP );
		
		return finalAmount;
	}

	private void setProvidentFundValue(PayRollProcessHDDTO payRollProcessHDDTO, ArrayList<PayOut> listDeduction,
			BigDecimal amount_contribution_Pf, long standardDeduction ) {
		PayRollProcessUtil util = new PayRollProcessUtil();
		PayOut payOutEmpPF = new PayOut();
		PayOutPK pk = new PayOutPK();
		pk.setEmployeeId(payRollProcessHDDTO.getListPayRollProcessDTOs().get(0).getPayOut().getEmployee()
				.getEmployeeId());
		pk.setProcessMonth(payRollProcessHDDTO.getPayMonth());
		pk.setPayHeadId( standardDeduction );
		
		payOutEmpPF.setId(pk);
		payOutEmpPF.setAmount(amount_contribution_Pf);
		
		Employee employee = new Employee();
		employee.setEmployeeId( payRollProcessHDDTO.getListPayRollProcessDTOs().get(0).getPayOut().getEmployee()
				.getEmployeeId() );
		
		util.fillDeductionValueInReportPayOut( payRollProcessHDDTO.getReportPayOut() , standardDeduction, amount_contribution_Pf );
		
		payOutEmpPF.setEmployee( employee );
		listDeduction.add(payOutEmpPF);
	}

}
