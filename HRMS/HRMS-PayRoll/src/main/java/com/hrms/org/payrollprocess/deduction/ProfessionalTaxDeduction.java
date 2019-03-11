package com.hrms.org.payrollprocess.deduction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.model.payroll.ProfessionalTaxInfo;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayOutPK;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;
import com.hrms.org.payrollprocess.dto.PayRollProcessHDDTO;
import com.hrms.org.payrollprocess.util.PayRollProcessUtil;

public class ProfessionalTaxDeduction extends Calculation {

	@Override
	public ArrayList<PayOut> getCalculation(List<PayRollProcessDTO> earningList,
			PayRollProcessHDDTO payRollProcessHDDTO, PayrollControl payrollControl ) {

		ArrayList<PayOut> listDeduction = new ArrayList<>();
		ProfessionalTax pt= payRollProcessHDDTO.getProfessionalTax();
		if ( pt != null ) {
		
			//BigDecimal grossAmountamount = payRollProcessHDDTO.getTotalGrossSalary();
			BigDecimal grossAmountamount = payRollProcessHDDTO.getReportPayOut().getTotalEarning();
			BigDecimal perMonthAmount  = new BigDecimal(0);
			boolean ptFlag = false;
			
			List<ProfessionalTaxInfo> ptTaxinfoList =   pt.getProfessionalTaxInfos();
			
			for (ProfessionalTaxInfo taxInfo : ptTaxinfoList) {

				if (taxInfo.getCategory().equals("A")) {
					if (isBetween(grossAmountamount, taxInfo)) {
						perMonthAmount = taxInfo.getTaxAmount();
						ptFlag = true;
						break;
					}

				} else if (taxInfo.getCategory().equals(payRollProcessHDDTO.getReportPayOut().getGender())) {
					if (isBetween(grossAmountamount, taxInfo)) {
						perMonthAmount = taxInfo.getTaxAmount();
						ptFlag = true;
						break;
					}

				}

			}
			
			
		  	
			if( ptFlag  ) {
				PayRollProcessUtil util = new PayRollProcessUtil();
				PayOut payOutEmpPT =new PayOut();
				PayOutPK pk = new PayOutPK();
				pk.setEmployeeId(payRollProcessHDDTO.getListPayRollProcessDTOs().get(0).getPayOut().getEmployee()
						.getEmployeeId());
				pk.setProcessMonth(payRollProcessHDDTO.getPayMonth());
			    pk.setPayHeadId( StandardDeductionEnum.PT.getStandardDeduction() );
				payOutEmpPT.setId(pk);
				Employee employee = new Employee();
				employee.setEmployeeId( payRollProcessHDDTO.getListPayRollProcessDTOs().get(0).getPayOut().getEmployee()
						.getEmployeeId() );
				payOutEmpPT.setAmount(perMonthAmount);
				payOutEmpPT.setEmployee( employee );
				
				util.fillDeductionValueInReportPayOut( payRollProcessHDDTO.getReportPayOut() , StandardDeductionEnum.PT.getStandardDeduction() , perMonthAmount );
				
				listDeduction.add(payOutEmpPT);
				
			}
		}
		
		return listDeduction;
	}

	
	    boolean isBetween( BigDecimal grossAmountamount, ProfessionalTaxInfo taxInfo ){
	    	  return ( taxInfo.getLimitFrom().compareTo( grossAmountamount ) < 0 && taxInfo.getLimitTo().compareTo( grossAmountamount ) > 0 );
		}
}
