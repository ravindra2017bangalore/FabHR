package com.csipl.hrms.common.enums;

public enum DesignationChartEnum {

	caption(""), numberPrefix("₹"), formatnumberscale("0"), showBorder(
			"0"), use3DLighting("1"), enableSmartLabels("1"), startingAngle("310"), showLabels("1"), showPercentValues(
					"1"), showLegend("1"), thousandSeparatorPosition("2,3"), baseFont("Verdana"), baseFontSize(
							"11"), baseFontColor("#333333"), centerLabelBold("0"), showTooltip(
									"1"), decimals("0"), useDataPlotColorForLabels("1"), theme("FintTheme");//FintTheme/Fint

	
	
	  
	public String pieChartValue;

	DesignationChartEnum(String pieChartValue) {

		this.pieChartValue = pieChartValue;
	}

	public String getPieChartValue() {
		return pieChartValue;
	}

	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}

}
