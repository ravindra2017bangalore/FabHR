package com.csipl.hrms.common.enums;

public enum EarningDeductionEnum {

	Earning("EA"),
	Deduction("DE");
	
	public String earningDeductionType;
	
	public String getEarningDeductionType() {
		return earningDeductionType;
	}

	EarningDeductionEnum( String earningDeductionType ){
		this.earningDeductionType =  earningDeductionType;
	}
}
