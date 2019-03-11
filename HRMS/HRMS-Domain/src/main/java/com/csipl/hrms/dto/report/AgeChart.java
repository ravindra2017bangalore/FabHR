package com.csipl.hrms.dto.report;

public class AgeChart {
	
	
	
	String formatnumberscale,use3DLighting,enableSmartLabels,startingAngle,showLabels,showPercentValues,showLegend;
	String centerLabelBold,showTooltip,decimals,useDataPlotColorForLabels,theme;
	
	AgeChart(){
		
	}
	
	

	public AgeChart(String formatnumberscale, String use3dLighting, String enableSmartLabels, 
			String startingAngle,
			String showLabels, 
			String showPercentValues,
			String showLegend, 
			String centerLabelBold, 
			String showTooltip,
			String decimals, String useDataPlotColorForLabels,String theme) {
		
		this.formatnumberscale = formatnumberscale;
		this.use3DLighting = use3dLighting;
		this.enableSmartLabels = enableSmartLabels;
		this.startingAngle = startingAngle;
		this.showLabels = showLabels;
		this.showPercentValues = showPercentValues;
		this.showLegend = showLegend;
		this.centerLabelBold = centerLabelBold;
		this.showTooltip = showTooltip;
		this.decimals = decimals;
		this.useDataPlotColorForLabels = useDataPlotColorForLabels;
		this.theme = theme;
	}

	public String getFormatnumberscale() {
		return formatnumberscale;
	}

	public void setFormatnumberscale(String formatnumberscale) {
		this.formatnumberscale = formatnumberscale;
	}

	public String getUse3DLighting() {
		return use3DLighting;
	}

	public void setUse3DLighting(String use3dLighting) {
		use3DLighting = use3dLighting;
	}

	public String getEnableSmartLabels() {
		return enableSmartLabels;
	}

	public void setEnableSmartLabels(String enableSmartLabels) {
		this.enableSmartLabels = enableSmartLabels;
	}

	public String getStartingAngle() {
		return startingAngle;
	}

	public void setStartingAngle(String startingAngle) {
		this.startingAngle = startingAngle;
	}

	public String getShowLabels() {
		return showLabels;
	}

	public void setShowLabels(String showLabels) {
		this.showLabels = showLabels;
	}

	public String getShowPercentValues() {
		return showPercentValues;
	}

	public void setShowPercentValues(String showPercentValues) {
		this.showPercentValues = showPercentValues;
	}

	public String getShowLegend() {
		return showLegend;
	}

	public void setShowLegend(String showLegend) {
		this.showLegend = showLegend;
	}

	public String getCenterLabelBold() {
		return centerLabelBold;
	}

	public void setCenterLabelBold(String centerLabelBold) {
		this.centerLabelBold = centerLabelBold;
	}

	public String getShowTooltip() {
		return showTooltip;
	}

	public void setShowTooltip(String showTooltip) {
		this.showTooltip = showTooltip;
	}

	public String getDecimals() {
		return decimals;
	}

	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}

	public String getUseDataPlotColorForLabels() {
		return useDataPlotColorForLabels;
	}

	public void setUseDataPlotColorForLabels(String useDataPlotColorForLabels) {
		this.useDataPlotColorForLabels = useDataPlotColorForLabels;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
	

}
