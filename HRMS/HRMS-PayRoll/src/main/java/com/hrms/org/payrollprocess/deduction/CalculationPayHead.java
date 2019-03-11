package com.hrms.org.payrollprocess.deduction;



import java.util.ArrayList;
import java.util.List;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;
import com.hrms.org.payrollprocess.dto.PayRollProcessHDDTO;





public class CalculationPayHead  {
	
	
	
	
 
    
  public List<PayOut>  calculationDeduction(PayRollProcessHDDTO payRollProcessHDDTO, PayrollControl payrollControl, PayStructureHd payStructureHd ){
	  List<PayOut> listDeduction = new ArrayList<PayOut>();
	
		   List<PayRollProcessDTO> epfList = new ArrayList<PayRollProcessDTO>();
		   List<PayRollProcessDTO> esiList = new ArrayList<PayRollProcessDTO>();
		   List<PayRollProcessDTO> ptList = new ArrayList<PayRollProcessDTO>();
		
		for(PayRollProcessDTO payRollProcessDTO : payRollProcessHDDTO.getListPayRollProcessDTOs()) {
			
			PayStructure payStructure=payRollProcessDTO.getPayStructure();
			esiList.add( payRollProcessDTO );
					
			
			if( payStructure.getPayHead().getIsApplicableOnPf().equalsIgnoreCase("Y") ) { 
				
				epfList.add( payRollProcessDTO );
				
			} /* else if ( payStructure.getPayHead().getIsApplicableOnPf().equalsIgnoreCase("Y") ) {
				
				esiList.add( payRollProcessDTO );
			} */
		}
		
		if ( payStructureHd.getIsNoPFDeduction() == null  
				|| ( payStructureHd.getIsNoPFDeduction() != null &&  payStructureHd.getIsNoPFDeduction().equals("") ) 
				|| ( payStructureHd.getIsNoPFDeduction() != null &&  payStructureHd.getIsNoPFDeduction().equals("N") ) ) {
		EpfCalculation epfCalculation= new EpfCalculation();	
		listDeduction.addAll( epfCalculation.getCalculation(epfList,payRollProcessHDDTO, payrollControl) );
		}
		
		
		EsiCalculation esiCalculation =new EsiCalculation();	
		listDeduction.addAll( esiCalculation.getCalculation(esiList,payRollProcessHDDTO, payrollControl) );
		
		ProfessionalTaxDeduction ptCalculation = new ProfessionalTaxDeduction();
		listDeduction.addAll(ptCalculation.getCalculation(ptList, payRollProcessHDDTO, payrollControl));
		
	  return listDeduction;
  }



}
