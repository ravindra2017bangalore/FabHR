package com.csipl.hrms.common.enums;

public enum EarningTypeEnum {

	Attendance_Based_Earnings("A"), Computation_Based_Earnings("C"), Flat_Rate_Based_Earnings(
			"F"), Production_Based_Earnings("P"), User_Defined_Earnings("U");

	String incomeType;

	public String getIncomeType() {
		return incomeType;
	}

	EarningTypeEnum(String incomeType) {
		this.incomeType = incomeType;
	}

	public static EarningTypeEnum parse(String incomeType) {

		for (EarningTypeEnum type : EarningTypeEnum.values()) {
			if (type.getIncomeType().equals(incomeType)) {
				return type;
			}
		}
		throw new IllegalArgumentException("The incomeType is unknown");
	}

}
