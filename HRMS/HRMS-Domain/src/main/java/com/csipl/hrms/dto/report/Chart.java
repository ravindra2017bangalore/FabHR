package com.csipl.hrms.dto.report;


public class Chart {
	

	
	String skipOverlapLabels;
	String  yAxisName;
	String  paletteColors;
	String  bgColor;
	
	String  showCanvasBorder;
	String  usePlotGradientColor;
	String  plotBorderAlpha;
	String  placeValuesInside;
	String  valueFontColor;
	String  showAxisLines;
	String  axisLineAlpha;
	String  divLineAlpha;
	String  alignCaptionWithCanvas;
	String  showAlternateVGridColor;
	String  captionFontSize;
	String  subcaptionFontSize;
	String  subcaptionFontBold;

	String toolTipColor;
	String  toolTipBorderThickness;
	String  toolTipBgColor;
	String  toolTipBgAlpha;
	String  toolTipBorderRadius;
	String  toolTipPadding;

	String startingangle;
	String showlabels;
	String showlegend;
	String enablemultislicing;
	String slicingdistance;
	String showpercentvalues;
	String showpercentintooltip;
	
	//////////////////////
	
	String caption, numberPrefix,formatnumberscale,showBorder,use3DLighting;
	String  enableSmartLabels,startingAngle,showLabels,showPercentValues,showLegend;
	String  thousandSeparatorPosition,baseFont,baseFontSize,baseFontColor, centerLabelBold;
	String  showTooltip,decimals,theme;
    
	
	public Chart() {
		
		
	}
	
	
  public Chart(String caption,String numberPrefix,String formatnumberscale,String showBorder,String use3DLighting,
	String  enableSmartLabels,String startingAngle,String showLabels,String showPercentValues,String showLegend,
	String  thousandSeparatorPosition,String baseFont,String baseFontSize,String baseFontColor,String  centerLabelBold,
	String  showTooltip,String decimals,String theme) {
		
	  this.caption=caption;
	  this.numberPrefix=numberPrefix;
	  this.formatnumberscale=formatnumberscale;
	  this.showBorder=showBorder;
	  this.use3DLighting=use3DLighting;
	  this.enableSmartLabels=enableSmartLabels;
	  this.startingAngle=startingAngle;
	  this.showLabels=showLabels;
	  this.showPercentValues=showPercentValues;
	  this.showLegend=showLegend;
	  this.thousandSeparatorPosition=thousandSeparatorPosition;
	  this.baseFont=baseFont;
	  this.baseFontSize=baseFontSize;
	  this.baseFontColor=baseFontColor;
	  this.centerLabelBold=centerLabelBold;
	  this.showTooltip=showTooltip;
	  this.decimals=decimals;
	  this.theme=theme;
		
	}
	
	
	public Chart(String numberPrefix, String decimals, String skipOverlapLabels, String theme) {
	
		this.numberPrefix = numberPrefix;
		this.decimals = decimals;
		this.skipOverlapLabels = skipOverlapLabels;
		this.theme = theme;
	}
	

    


  public Chart(String numberPrefix, String yAxisName, String paletteColors, String bgColor, String showBorder,
			String showCanvasBorder, String usePlotGradientColor, String plotBorderAlpha, String placeValuesInside,
			String valueFontColor, String showAxisLines, String axisLineAlpha, String divLineAlpha,
			String alignCaptionWithCanvas, String showAlternateVGridColor, String captionFontSize,
			String subcaptionFontSize, String subcaptionFontBold, String toolTipColor, String toolTipBorderThickness,
			String toolTipBgColor, String toolTipBgAlpha, String toolTipBorderRadius, String toolTipPadding,String thousandSeparatorPosition) {

		this.numberPrefix = numberPrefix;
		this.yAxisName = yAxisName;
		this.paletteColors = paletteColors;
		this.bgColor = bgColor;
		this.showBorder = showBorder;
		this.showCanvasBorder = showCanvasBorder;
		this.usePlotGradientColor = usePlotGradientColor;
		this.plotBorderAlpha = plotBorderAlpha;
		this.placeValuesInside = placeValuesInside;
		this.valueFontColor = valueFontColor;
		this.showAxisLines = showAxisLines;
		this.axisLineAlpha = axisLineAlpha;
		this.divLineAlpha = divLineAlpha;
		this.alignCaptionWithCanvas = alignCaptionWithCanvas;
		this.showAlternateVGridColor = showAlternateVGridColor;
		this.captionFontSize = captionFontSize;
		this.subcaptionFontSize = subcaptionFontSize;
		this.subcaptionFontBold = subcaptionFontBold;
		this.toolTipColor = toolTipColor;
		this.toolTipBorderThickness = toolTipBorderThickness;
		this.toolTipBgColor = toolTipBgColor;
		this.toolTipBgAlpha = toolTipBgAlpha;
		this.toolTipBorderRadius = toolTipBorderRadius;
		this.toolTipPadding = toolTipPadding;
		this.thousandSeparatorPosition=thousandSeparatorPosition;
	}
	
	public Chart(String numberPrefix, String theme, String startingangle, String showlabels, String showlegend,
			String enablemultislicing, String slicingdistance, String showpercentvalues, String showpercentintooltip) {

		this.numberPrefix = numberPrefix;
		this.theme = theme;
		this.startingangle = startingangle;
		this.showlabels = showlabels;
		this.showlegend = showlegend;
		this.enablemultislicing = enablemultislicing;
		this.slicingdistance = slicingdistance;
		this.showpercentvalues = showpercentvalues;
		this.showpercentintooltip = showpercentintooltip;
		}
	
	public String getNumberPrefix() {
		return numberPrefix;
	}
	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}
	public String getDecimals() {
		return decimals;
	}
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	public String getSkipOverlapLabels() {
		return skipOverlapLabels;
	}
	public void setSkipOverlapLabels(String skipOverlapLabels) {
		this.skipOverlapLabels = skipOverlapLabels;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}




	public String getyAxisName() {
		return yAxisName;
	}




	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}




	public String getPaletteColors() {
		return paletteColors;
	}




	public void setPaletteColors(String paletteColors) {
		this.paletteColors = paletteColors;
	}




	public String getBgColor() {
		return bgColor;
	}




	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}




	public String getShowBorder() {
		return showBorder;
	}




	public void setShowBorder(String showBorder) {
		this.showBorder = showBorder;
	}




	public String getShowCanvasBorder() {
		return showCanvasBorder;
	}




	public void setShowCanvasBorder(String showCanvasBorder) {
		this.showCanvasBorder = showCanvasBorder;
	}




	public String getUsePlotGradientColor() {
		return usePlotGradientColor;
	}




	public void setUsePlotGradientColor(String usePlotGradientColor) {
		this.usePlotGradientColor = usePlotGradientColor;
	}




	public String getPlotBorderAlpha() {
		return plotBorderAlpha;
	}




	public void setPlotBorderAlpha(String plotBorderAlpha) {
		this.plotBorderAlpha = plotBorderAlpha;
	}




	public String getPlaceValuesInside() {
		return placeValuesInside;
	}




	public void setPlaceValuesInside(String placeValuesInside) {
		this.placeValuesInside = placeValuesInside;
	}




	public String getValueFontColor() {
		return valueFontColor;
	}




	public void setValueFontColor(String valueFontColor) {
		this.valueFontColor = valueFontColor;
	}




	public String getShowAxisLines() {
		return showAxisLines;
	}




	public void setShowAxisLines(String showAxisLines) {
		this.showAxisLines = showAxisLines;
	}




	public String getAxisLineAlpha() {
		return axisLineAlpha;
	}




	public void setAxisLineAlpha(String axisLineAlpha) {
		this.axisLineAlpha = axisLineAlpha;
	}




	public String getDivLineAlpha() {
		return divLineAlpha;
	}




	public void setDivLineAlpha(String divLineAlpha) {
		this.divLineAlpha = divLineAlpha;
	}




	public String getAlignCaptionWithCanvas() {
		return alignCaptionWithCanvas;
	}




	public void setAlignCaptionWithCanvas(String alignCaptionWithCanvas) {
		this.alignCaptionWithCanvas = alignCaptionWithCanvas;
	}




	public String getShowAlternateVGridColor() {
		return showAlternateVGridColor;
	}




	public void setShowAlternateVGridColor(String showAlternateVGridColor) {
		this.showAlternateVGridColor = showAlternateVGridColor;
	}




	public String getCaptionFontSize() {
		return captionFontSize;
	}




	public void setCaptionFontSize(String captionFontSize) {
		this.captionFontSize = captionFontSize;
	}




	public String getSubcaptionFontSize() {
		return subcaptionFontSize;
	}




	public void setSubcaptionFontSize(String subcaptionFontSize) {
		this.subcaptionFontSize = subcaptionFontSize;
	}




	public String getSubcaptionFontBold() {
		return subcaptionFontBold;
	}




	public void setSubcaptionFontBold(String subcaptionFontBold) {
		this.subcaptionFontBold = subcaptionFontBold;
	}




	public String getToolTipColor() {
		return toolTipColor;
	}




	public void setToolTipColor(String toolTipColor) {
		this.toolTipColor = toolTipColor;
	}




	public String getToolTipBorderThickness() {
		return toolTipBorderThickness;
	}




	public void setToolTipBorderThickness(String toolTipBorderThickness) {
		this.toolTipBorderThickness = toolTipBorderThickness;
	}




	public String getToolTipBgColor() {
		return toolTipBgColor;
	}




	public void setToolTipBgColor(String toolTipBgColor) {
		this.toolTipBgColor = toolTipBgColor;
	}




	public String getToolTipBgAlpha() {
		return toolTipBgAlpha;
	}




	public void setToolTipBgAlpha(String toolTipBgAlpha) {
		this.toolTipBgAlpha = toolTipBgAlpha;
	}




	public String getToolTipBorderRadius() {
		return toolTipBorderRadius;
	}




	public void setToolTipBorderRadius(String toolTipBorderRadius) {
		this.toolTipBorderRadius = toolTipBorderRadius;
	}




	public String getToolTipPadding() {
		return toolTipPadding;
	}




	public void setToolTipPadding(String toolTipPadding) {
		this.toolTipPadding = toolTipPadding;
	}




	public String getThousandSeparatorPosition() {
		return thousandSeparatorPosition;
	}




	public void setThousandSeparatorPosition(String thousandSeparatorPosition) {
		this.thousandSeparatorPosition = thousandSeparatorPosition;
	}




	public String getStartingangle() {
		return startingangle;
	}




	public void setStartingangle(String startingangle) {
		this.startingangle = startingangle;
	}




	public String getShowlabels() {
		return showlabels;
	}




	public void setShowlabels(String showlabels) {
		this.showlabels = showlabels;
	}




	public String getShowlegend() {
		return showlegend;
	}




	public void setShowlegend(String showlegend) {
		this.showlegend = showlegend;
	}




	public String getEnablemultislicing() {
		return enablemultislicing;
	}




	public void setEnablemultislicing(String enablemultislicing) {
		this.enablemultislicing = enablemultislicing;
	}




	public String getSlicingdistance() {
		return slicingdistance;
	}




	public void setSlicingdistance(String slicingdistance) {
		this.slicingdistance = slicingdistance;
	}




	public String getShowpercentvalues() {
		return showpercentvalues;
	}




	public void setShowpercentvalues(String showpercentvalues) {
		this.showpercentvalues = showpercentvalues;
	}




	public String getShowpercentintooltip() {
		return showpercentintooltip;
	}




	public void setShowpercentintooltip(String showpercentintooltip) {
		this.showpercentintooltip = showpercentintooltip;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
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
	
	
	
	
}
