package com.csipl.hrms.common.enums;

public enum StandardDeductionEnum {
	PF_Employee_Contribution ( 101 ),
	PF_Employer_Contribution ( 102 ),
	Pension_Employer_Contribution ( 103 ),
	ESI_Employee_Contribution ( 104 ),
	ESI_Employer_Contribution ( 105 ),
	PT( 106 ),
	TDS ( 107 ),
	LWF ( 108 ), 
	Insurance ( 109 ),
	Loand_And_advance ( 110 ),
	Others ( 111 );
	
	
	long standardDeduction;
	StandardDeductionEnum( long standardDeduction ){
		this.standardDeduction = standardDeduction;
	}
	
	public long getStandardDeduction() {
		return standardDeduction;
	}
	public void setStandardDeduction(long standardDeduction) {
		this.standardDeduction = standardDeduction;
	}
	
}
