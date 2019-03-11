package com.csipl.hrms.common.enums;

public enum LeaveChartEnum {
	  showBorder("0"),
      use3DLighting("1"),
      enableSmartLabels("1"),
      startingAngle("30"),
      showLabels( "0"),
      showPercentValues( "1"),
      showLegend( "1"),
      centerLabelBold( "1"),
      showTooltip("1"),
      decimals("0"),
      useDataPlotColorForLabels("1"),
      theme("fint"),
      chartLeftMargin("0"),
      chartRightMargin("0"),
      defaultCenterLabel("d Available"),
      centerLabelColor("#212344"),
      doughnutRadius("22");
	
	public String pieChartValue ;
	
	

	LeaveChartEnum (String pieChartValue  ) {
		
		this.pieChartValue = pieChartValue;
	}



	public String getPieChartValue() {
		return pieChartValue;
	}



	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}
	
}
