package com.csipl.hrms.dto.report;



public class DepartmentPayrollChart {
	
	String  caption ,numberPrefix,formatnumberscale,showBorder,use3DLighting,enableSmartLabels,startingAngle;
	String  showLabels,showPercentValues,showLegend,thousandSeparatorPosition,baseFont;
	String baseFontSize,baseFontColor,centerLabelBold,showTooltip,decimals,theme;
	public DepartmentPayrollChart(String caption, String numberPrefix, String formatnumberscale, String showBorder,
			String use3dLighting, String enableSmartLabels, String startingAngle, String showLabels,
			String showPercentValues, String showLegend, String thousandSeparatorPosition, String baseFont,
			String baseFontSize, String baseFontColor, String centerLabelBold, String showTooltip, String decimals,
			String theme) {
		super();
		this.caption = caption;
		this.numberPrefix = numberPrefix;
		this.formatnumberscale = formatnumberscale;
		this.showBorder = showBorder;
		use3DLighting = use3dLighting;
		this.enableSmartLabels = enableSmartLabels;
		this.startingAngle = startingAngle;
		this.showLabels = showLabels;
		this.showPercentValues = showPercentValues;
		this.showLegend = showLegend;
		this.thousandSeparatorPosition = thousandSeparatorPosition;
		this.baseFont = baseFont;
		this.baseFontSize = baseFontSize;
		this.baseFontColor = baseFontColor;
		this.centerLabelBold = centerLabelBold;
		this.showTooltip = showTooltip;
		this.decimals = decimals;
		this.theme = theme;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getNumberPrefix() {
		return numberPrefix;
	}
	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}
	public String getFormatnumberscale() {
		return formatnumberscale;
	}
	public void setFormatnumberscale(String formatnumberscale) {
		this.formatnumberscale = formatnumberscale;
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
	public String getThousandSeparatorPosition() {
		return thousandSeparatorPosition;
	}
	public void setThousandSeparatorPosition(String thousandSeparatorPosition) {
		this.thousandSeparatorPosition = thousandSeparatorPosition;
	}
	public String getBaseFont() {
		return baseFont;
	}
	public void setBaseFont(String baseFont) {
		this.baseFont = baseFont;
	}
	public String getBaseFontSize() {
		return baseFontSize;
	}
	public void setBaseFontSize(String baseFontSize) {
		this.baseFontSize = baseFontSize;
	}
	public String getBaseFontColor() {
		return baseFontColor;
	}
	public void setBaseFontColor(String baseFontColor) {
		this.baseFontColor = baseFontColor;
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	

}
