package com.csipl.hrms.dto.esipf.dashboard;

import java.util.ArrayList;



public class GraphDto {
	Chart chart;
	
	ArrayList<Data> data= new ArrayList<>();
	
	
               
	public GraphDto(Chart chart, ArrayList<Data> data) {
	
		this.chart = chart;
		this.data = data;
	}
	
	
	

	public Chart getChart() {
		return chart;
	}
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	

	

}
