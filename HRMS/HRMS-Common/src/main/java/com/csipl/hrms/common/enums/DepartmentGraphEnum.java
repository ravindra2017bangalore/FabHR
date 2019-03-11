package com.csipl.hrms.common.enums;

public enum DepartmentGraphEnum {

	 caption(""),
	 numberPrefix("₹" ),
	 formatnumberscale("0"),
	 showBorder("0"),
	 use3DLighting( "1"),
	 enableSmartLabels( "0"),
	  
	 startingAngle("310"),
	 showLabels( "1"),
     showPercentValues( "0"),
     showLegend( "0"),
     thousandSeparatorPosition( "2,3"),
     baseFont ("Verdana"),
     baseFontSize( "11"),
     baseFontColor("#333333 "),
     centerLabelBold( "0"),
     showTooltip( "1"),
     decimals( "0"),
     useDataPlotColorForLabels( "0"),
   
	// decimals( "1" ),
	 skipOverlapLabels( "1" ),
	 theme(  "FintTheme" ),//fint//FintTheme//ocean
	 startingangle("120"),
	 showlabels("0"),
	 showlegend("1"),
	 enablemultislicing("0"),
	 slicingdistance("15"),
	 showpercentvalues("1"),
	 showpercentintooltip("0"),
	 
	
	;
	//baar chart
	 
	public String pieChartValue ;
	
	

	DepartmentGraphEnum (String pieChartValue  ) {
		
		this.pieChartValue = pieChartValue;
	}



	public String getPieChartValue() {
		return pieChartValue;
	}



	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}
}
