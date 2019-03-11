package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class DesignationPayrollChart {
	
	Chart chart;
	ArrayList<DesignationData> data = new ArrayList<DesignationData>();
	
	public DesignationPayrollChart(Chart chart, ArrayList<DesignationData> data) {
		super();
		this.chart = chart;
		this.data = data;
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public ArrayList<DesignationData> getData() {
		return data;
	}

	public void setData(ArrayList<DesignationData> data) {
		this.data = data;
	}
	
	
	
	

}
