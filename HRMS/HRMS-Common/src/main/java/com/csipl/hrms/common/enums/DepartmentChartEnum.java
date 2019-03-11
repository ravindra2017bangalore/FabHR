package com.csipl.hrms.common.enums;

public enum DepartmentChartEnum {

	caption(""), showBorder("0"), use3DLighting("1"), enableSmartLabels("1"), startingAngle(
			"310"), showLabels("1"), showPercentValues("1"), showLegend("1"), centerLabelBold(
					"1"), showTooltip("1"), decimals("0"), useDataPlotColorForLabels("1"), theme("FintTheme");

	public String pieChartValue;

	DepartmentChartEnum(String pieChartValue) {

		this.pieChartValue = pieChartValue;
	}

	public String getPieChartValue() {
		return pieChartValue;
	}

	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}

}