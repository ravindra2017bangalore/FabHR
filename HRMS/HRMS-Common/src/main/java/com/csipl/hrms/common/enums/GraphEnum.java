package com.csipl.hrms.common.enums;

public enum GraphEnum {
	//₹ INR
	 caption(""),
	 numberPrefix("₹" ),
	 formatnumberscale("0"),
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
	 theme(  "ocean" ),//fint//ocean "bgColor": "EEEEEE,CCCCCC",
	 startingangle("120"),
	 showlabels("0"),
	 showlegend("1"),
	 enablemultislicing("0"),
	 slicingdistance("15"),
	 showpercentvalues("1"),
	 showpercentintooltip("0"),
	 
	 
	 
	  yAxisName("Amount (In INR)"),
      paletteColors("#678dd6"),
      bgColor("EEEEEE"),
      showBorder("0"),
      showCanvasBorder("0"),
      usePlotGradientColor("0"),
      plotBorderAlpha("10"),
      placeValuesInside("1"),
      valueFontColor("#333333"),
      showAxisLines("1"),
      axisLineAlpha("25"),
      divLineAlpha("10"),
      alignCaptionWithCanvas("0"),
      showAlternateVGridColor("0"),
      captionFontSize("14"),
      subcaptionFontSize("14"),
      subcaptionFontBold("0"),
      toolTipColor("#ffffff"),
      toolTipBorderThickness("0"),
      toolTipBgColor("#000000"),
      toolTipBgAlpha("80"),
      toolTipBorderRadius("2"),
      toolTipPadding("5"),
	;
	//baar chart
	 
	public String pieChartValue ;
	
	

	GraphEnum (String pieChartValue  ) {
		
		this.pieChartValue = pieChartValue;
	}



	public String getPieChartValue() {
		return pieChartValue;
	}



	public void setPieChartValue(String pieChartValue) {
		this.pieChartValue = pieChartValue;
	}
	
	
}
