package com.hrms.org.payrollprocess.deduction;

import java.util.ArrayList;
import java.util.List;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;
import com.hrms.org.payrollprocess.dto.PayRollProcessHDDTO;

public abstract class Calculation {
	
	public  abstract ArrayList<PayOut> getCalculation(  List<PayRollProcessDTO> processList , PayRollProcessHDDTO payRollProcessHDDTO, PayrollControl payrollControl );
	
}
