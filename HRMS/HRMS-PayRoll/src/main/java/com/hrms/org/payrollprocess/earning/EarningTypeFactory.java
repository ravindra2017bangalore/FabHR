package com.hrms.org.payrollprocess.earning;

import com.csipl.hrms.common.enums.EarningTypeEnum;

public class EarningTypeFactory {

	private String earningType;

	public EarningTypeFactory(String earningType) {
		this.earningType = earningType;
	}

	public EarningType getEarningType() {

		EarningTypeEnum earningTypeEnum = EarningTypeEnum.parse(earningType);

		switch (earningTypeEnum) {

		case Attendance_Based_Earnings:
			return new AttendanceBased();

		case Computation_Based_Earnings:
			return new ComputationBased();

		case Flat_Rate_Based_Earnings:
			return new FlatRateBased();

		case Production_Based_Earnings:
			return new ProductionBased();

		case User_Defined_Earnings:
			return new UserDefinedBased();

		default:
			throw new IllegalArgumentException("The earning type does not exist.");

		}

	}

}
