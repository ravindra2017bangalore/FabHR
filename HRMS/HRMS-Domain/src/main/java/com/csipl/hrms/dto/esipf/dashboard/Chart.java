package com.csipl.hrms.dto.esipf.dashboard;


public class Chart {
	

	
	
	String  numberPrefix,formatnumberscale,decimals,skipOverlapLabels,theme;
	
	
	

    

	
	
	public Chart(String numberPrefix, String formatnumberscale, String decimals, String skipOverlapLabels,
			String theme) {
		super();
		this.numberPrefix = numberPrefix;
		this.formatnumberscale = formatnumberscale;
		this.decimals = decimals;
		this.skipOverlapLabels = skipOverlapLabels;
		this.theme = theme;
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
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}






	public String getFormatnumberscale() {
		return formatnumberscale;
	}






	public void setFormatnumberscale(String formatnumberscale) {
		this.formatnumberscale = formatnumberscale;
	}






	public String getSkipOverlapLabels() {
		return skipOverlapLabels;
	}






	public void setSkipOverlapLabels(String skipOverlapLabels) {
		this.skipOverlapLabels = skipOverlapLabels;
	}



	
	
	
}
