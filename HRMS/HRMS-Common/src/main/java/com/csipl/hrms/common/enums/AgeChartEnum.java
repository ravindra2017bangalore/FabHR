package com.csipl.hrms.common.enums;

public enum AgeChartEnum {

      
     	formatnumberscale("1"),
     	use3DLighting( "1" ),
		enableSmartLabels( "1" ),
		startingAngle(  "30" ),
		showLabels("1"),
		showPercentValues("0"),
		showLegend("1"),
		centerLabelBold("1"),
		showTooltip("1"),
		decimals("0"),
		useDataPlotColorForLabels("0"),
		theme("fint")
		
	    ;
		
	
		public String pieChartValue ;
		
		

		AgeChartEnum (String pieChartValue  ) {
			
			this.pieChartValue = pieChartValue;
		}



		public String getPieChartValue() {
			return pieChartValue;
		}



		public void setPieChartValue(String pieChartValue) {
			this.pieChartValue = pieChartValue;
		}
		

		
	}

