package com.csipl.hrms.dto.report;

public class DepartmentChart {
	
	String numberPrefix;
	
	String theme;

	String startingangle;
	String showlabels;
	String showlegend;
	String enablemultislicing;
	String slicingdistance;
	String showpercentvalues;
	String showpercentintooltip;
	
	
	public DepartmentChart() {
		
		
	}

	
	public DepartmentChart(String numberPrefix, String theme, String startingangle, String showlabels, String showlegend,
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


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
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
	
	
	

}
