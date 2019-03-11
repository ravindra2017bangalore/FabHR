package com.csipl.hrms.common.enums;

public enum AttritionEnum {
	
	caption("January-2018 to December-2018" ),
	yAxisName( "No. of Employees" ),
	plotgradientcolor( "" ),
	bgcolor(  "FFFFFF" ),//fint
	showalternatehgridcolor("1"),
	divlinecolor("CCCCCC"),
	showvalues("1"),
	showcanvasborder("1"),
	canvasborderalpha("1"),
	canvasbordercolor("CCCCCC"),
	canvasborderthickness("1"),
	
      yaxismaxvalue("0"),
      captionpadding("30"),
      linethickness("3"),
      yaxisvaluespadding("15"),
      legendshadow("1"),
      legendborderalpha("1"),
      palettecolors("#f8bd19,#008ee4,#33bdda,#e44a00,#6baa01,#583e78"),
      showborder("1");
     
	//baar chart
	
	public String pieChartValue ;
	
	

	AttritionEnum (String pieChartValue  ) {
		
		this.pieChartValue = pieChartValue;
	}



	public String getPieChartValue() {
		return pieChartValue;
	}



	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}
	

}
