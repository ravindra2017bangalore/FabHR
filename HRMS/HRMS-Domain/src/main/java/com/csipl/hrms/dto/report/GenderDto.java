package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class GenderDto {
	
	GenderChart chart;
	ArrayList<Data> data= new ArrayList<>();
	
	
               
	public GenderDto(GenderChart chart, ArrayList<Data> data) {
	
		this.chart = chart;
		this.data = data;
	}



	public GenderChart getChart() {
		return chart;
	}



	public void setChart(GenderChart chart) {
		this.chart = chart;
	}



	public ArrayList<Data> getData() {
		return data;
	}



	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	
	
}
