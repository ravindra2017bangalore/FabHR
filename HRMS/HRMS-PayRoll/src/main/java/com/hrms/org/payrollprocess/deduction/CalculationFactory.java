package com.hrms.org.payrollprocess.deduction;

import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;


public class CalculationFactory {
	
	//use getPlan method to get object of type Plan
	 public Object getCalculation(PayRollProcessDTO payRollProcessDTO){
	
		 
		 if(payRollProcessDTO == null){
	
          return "";
	      }
	
	      if(payRollProcessDTO.getPayStructure().getPayHead().getIsApplicableOnPf().equalsIgnoreCase("Y")) {
	    	
	    	  return new EpfCalculation();
	    
	      }
	     else if(payRollProcessDTO.getPayStructure().getPayHead().getIsApplicableOnEsi().equalsIgnoreCase("Y")){
	    
	    	 return new EsiCalculation() ;
        
	     }
	   
	     else if(payRollProcessDTO.getPayStructure().getPayHead().getIsApplicableOnPt().equalsIgnoreCase("Y")) {
	
         }
	      
	      return null;   
	
	 }
	 
	

}
