package com.hrms.org.payrollprocess.util;

import java.math.BigDecimal;

import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.common.enums.StandardEarningEnum;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

public class PayRollProcessUtil {

	  public ReportPayOut fillEarningValueInReportPayOut( ReportPayOut reportPayOut,
			  								long standardEarning, BigDecimal defaultValue,  BigDecimal calculatedValue ) {
		  
		  if ( standardEarning == StandardEarningEnum.HouseRentAllowance.getStandardEarning()  ) {
					
			  reportPayOut.setHra( defaultValue );
			  reportPayOut.setHRAEarning( calculatedValue );
			  
		  } else if ( standardEarning == StandardEarningEnum.BasicSalary.getStandardEarning()  ) {
				
				  reportPayOut.setBasic( defaultValue );
				  reportPayOut.setBasicEarning( calculatedValue );
				  
	     }  else if ( standardEarning == StandardEarningEnum.DearnessAllowance.getStandardEarning()  ) {
				
			  reportPayOut.setDearnessAllowance( defaultValue );
			  reportPayOut.setDearnessAllowanceEarning( calculatedValue );
			  
        }
	     else if ( standardEarning == StandardEarningEnum.ConveyanceAllowance.getStandardEarning()  ) {
				
			  reportPayOut.setConveyanceAllowance( defaultValue );
			  reportPayOut.setConveyanceAllowanceEarning(calculatedValue );
			  
       } else if ( standardEarning == StandardEarningEnum.MedicalAllowance.getStandardEarning()  ) {
				
			  reportPayOut.setMedicalAllowance( defaultValue );
			  reportPayOut.setMedicalAllowanceEarning(calculatedValue );
			  
      } else if ( standardEarning == StandardEarningEnum.SpecialAllowance.getStandardEarning()  ) {
			
			  reportPayOut.setSpecialAllowance( defaultValue );
			  reportPayOut.setSpecialAllowanceEarning(calculatedValue );
			  
      } else if ( standardEarning == StandardEarningEnum.CompanyBenefits.getStandardEarning()  ) {
			
		  reportPayOut.setCompanyBenefits( defaultValue );
		  reportPayOut.setCompanyBenefitsEarning(calculatedValue );
		  
     } else if ( standardEarning == StandardEarningEnum.LeaveTravelAllowance.getStandardEarning()  ) {
			
		  reportPayOut.setLeaveTravelAllowance( defaultValue );
		  reportPayOut.setLeaveTravelAllowanceEarning( calculatedValue );
		  
     } 
     else if ( standardEarning == StandardEarningEnum.PerformanceLinkedIncome.getStandardEarning()  ) {
			
		  reportPayOut.setPerformanceLinkedIncome( defaultValue );
		  reportPayOut.setPerformanceLinkedIncomeEarning( calculatedValue );
		  
    } else if ( standardEarning == StandardEarningEnum.UniformAllowance.getStandardEarning()  ) {
		
		  reportPayOut.setUniformAllowance( defaultValue );
		  reportPayOut.setUniformAllowanceEarning( calculatedValue );
		  
  } else if ( standardEarning == StandardEarningEnum.AdvanceBonus.getStandardEarning()  ) {
		
	  reportPayOut.setAdvanceBonus( defaultValue );
	  reportPayOut.setAdvanceBonusEarning( calculatedValue );
	  
   }  else {
    	 
    	 BigDecimal otherAllowance = reportPayOut.getOtherAllowance();
    	 BigDecimal otherAllowanceEarning = reportPayOut.getOtherAllowanceEarning();
    	 
    	 if ( otherAllowance == null ) otherAllowance = new BigDecimal(0.0);
    	 if ( otherAllowanceEarning == null ) otherAllowanceEarning = new BigDecimal(0.0);
    	 
    	 
    	 BigDecimal newOtherAllowance = otherAllowance.add( defaultValue ); 
    	 BigDecimal newOtherAllowanceEarning = otherAllowanceEarning.add( calculatedValue ); 
    	 
    	 reportPayOut.setOtherAllowance(newOtherAllowance);
    	 reportPayOut.setOtherAllowanceEarning(newOtherAllowanceEarning);
    	 
     }
     
		  
		  
		
		  return reportPayOut;
	}
	  
	  
	  public ReportPayOut fillDeductionValueInReportPayOut( ReportPayOut reportPayOut,
				long standardDeduction,  BigDecimal deductionValue ) {
			
			if ( standardDeduction == StandardDeductionEnum.PF_Employee_Contribution.getStandardDeduction()  ) {
			
				reportPayOut.setProvidentFundEmployee( deductionValue ); 
		
			
			} else if ( standardDeduction == StandardDeductionEnum.PF_Employer_Contribution.getStandardDeduction()  ) {
			
			reportPayOut.setProvidentFundEmployer( deductionValue );  
			
			} else if ( standardDeduction == StandardDeductionEnum.Pension_Employer_Contribution.getStandardDeduction()  ) {
				
				reportPayOut.setProvidentFundEmployerPension( deductionValue );  
				
			} else if ( standardDeduction == StandardDeductionEnum.ESI_Employee_Contribution.getStandardDeduction()  ) {
				
				reportPayOut.setESI_Employee( deductionValue );  
				
			} else if ( standardDeduction == StandardDeductionEnum.ESI_Employer_Contribution.getStandardDeduction()  ) {
				
				reportPayOut.setESI_Employer( deductionValue );   
				
			} else if ( standardDeduction == StandardDeductionEnum.PT.getStandardDeduction()  ) {
				
				reportPayOut.setPt( deductionValue );   		
			}
			
			return reportPayOut;
			}
	
	
}
