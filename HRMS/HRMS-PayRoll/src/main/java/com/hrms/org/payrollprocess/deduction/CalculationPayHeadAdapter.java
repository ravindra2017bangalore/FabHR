package com.hrms.org.payrollprocess.deduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public interface CalculationPayHeadAdapter<DEDUCTION,EARNING,ATTENDANCE> {
	
//public ArrayList<DEDUCTION> earningToDeductionModelList(List<EARNING> earnigobj , ATTENDANCE attendance);

public ArrayList<ArrayList<HashMap<String, Object>>> earningToDeductionModelList(List<EARNING> paystructureObj,
		ATTENDANCE attendance);


	
	
	
	
	

}
