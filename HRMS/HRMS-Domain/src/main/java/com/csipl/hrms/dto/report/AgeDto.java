package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class AgeDto {
	
	AgeChart chart;
	
	ArrayList<AgeData> data= new ArrayList<>();

	public AgeDto(AgeChart chart, ArrayList<AgeData> data) {
		super();
		this.chart = chart;
		this.data = data;
	}

	public AgeChart getChart() {
		return chart;
	}

	public void setChart(AgeChart chart) {
		this.chart = chart;
	}

	public ArrayList<AgeData> getData() {
		return data;
	}

	public void setData(ArrayList<AgeData> data) {
		this.data = data;
	}
	
	

}
