package com.csipl.hrms.common.enums;

public enum StandardEarningEnum {
	
	BasicSalary ( 1 ),
	DearnessAllowance ( 2 ),
	HouseRentAllowance ( 3 ),
	ConveyanceAllowance ( 4 ),
	SpecialAllowance ( 5 ), 
	UniformAllowance ( 6 ),
	LeaveTravelAllowance ( 7 ),
	MedicalAllowance ( 8 ),
	AdvanceBonus ( 9 ),
	PerformanceLinkedIncome ( 10 ),
	CompanyBenefits ( 11 );
	
	
	long standardEarning;
	StandardEarningEnum( long standardEarning ){
		this.standardEarning = standardEarning;
	}
	
	public long getStandardEarning() {
		return standardEarning;
	}
	

}
