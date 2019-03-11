package com.csipl.tms.dto.leave;

import java.util.ArrayList;

import com.csipl.hrms.dto.report.Data;

public class LeaveEntryChartDTO {
	LeaveEntryChart chart;
	ArrayList<Data> data= new ArrayList<>();
	
	
	public LeaveEntryChartDTO(LeaveEntryChart chart, ArrayList<Data> data) {
		super();
		this.chart = chart;
		this.data = data;
	}
	public LeaveEntryChart getChart() {
		return chart;
	}
	public void setChart(LeaveEntryChart chart) {
		this.chart = chart;
	}
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	
}
