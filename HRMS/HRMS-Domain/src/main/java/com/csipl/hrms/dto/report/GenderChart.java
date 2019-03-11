package com.csipl.hrms.dto.report;

public class GenderChart {
	
	String showBorder, use3DLighting, enableSmartLabels, startingAngle;
	String showLabels,showPercentValues,showLegend,centerLabelBold;
    String  showTooltip,decimals, useDataPlotColorForLabels, theme;
    String chartLeftMargin,chartRightMargin,centerlabel,centerLabelColor,doughnutRadius;
    
    
	
    public GenderChart(String showBorder, String use3dLighting, String enableSmartLabels, String startingAngle,
			String showLabels, String showPercentValues, String showLegend, String centerLabelBold, String showTooltip,
			String decimals, String useDataPlotColorForLabels, String theme) {
		super();
		this.showBorder = showBorder;
		use3DLighting = use3dLighting;
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
	public GenderChart(String showBorder, String use3dLighting, String enableSmartLabels, String startingAngle,
			String showLabels, String showPercentValues, String showLegend, String centerLabelBold, String showTooltip,
			String decimals, String useDataPlotColorForLabels, String theme, String chartLeftMargin,
			String chartRightMargin, String centerlabel, String centerLabelColor, String doughnutRadius) {
		super();
		this.showBorder = showBorder;
		use3DLighting = use3dLighting;
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
		this.chartLeftMargin = chartLeftMargin;
		this.chartRightMargin = chartRightMargin;
		this.centerlabel = centerlabel;
		this.centerLabelColor = centerLabelColor;
		this.doughnutRadius = doughnutRadius;
	}

	
	public String getChartLeftMargin() {
		return chartLeftMargin;
	}

	public void setChartLeftMargin(String chartLeftMargin) {
		this.chartLeftMargin = chartLeftMargin;
	}

	public String getChartRightMargin() {
		return chartRightMargin;
	}

	public void setChartRightMargin(String chartRightMargin) {
		this.chartRightMargin = chartRightMargin;
	}

	public String getShowBorder() {
		return showBorder;
	}
	public void setShowBorder(String showBorder) {
		this.showBorder = showBorder;
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

	public String getCenterlabel() {
		return centerlabel;
	}

	public void setCenterlabel(String centerlabel) {
		this.centerlabel = centerlabel;
	}

	public String getCenterLabelColor() {
		return centerLabelColor;
	}

	public void setCenterLabelColor(String centerLabelColor) {
		this.centerLabelColor = centerLabelColor;
	}


	public String getDoughnutRadius() {
		return doughnutRadius;
	}


	public void setDoughnutRadius(String doughnutRadius) {
		this.doughnutRadius = doughnutRadius;
	}
    
    

}
