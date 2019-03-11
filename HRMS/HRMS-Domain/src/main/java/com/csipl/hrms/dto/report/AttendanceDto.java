package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class AttendanceDto {

	AttendanceChart chart;
	ArrayList<AttendanceData> data = new ArrayList<>();

	public AttendanceDto(AttendanceChart chart, ArrayList<AttendanceData> data) {
		super();
		this.chart = chart;
		this.data = data;
	}

	public AttendanceChart getChart() {
		return chart;
	}

	public void setChart(AttendanceChart chart) {
		this.chart = chart;
	}

	public ArrayList<AttendanceData> getData() {
		return data;
	}

	public void setData(ArrayList<AttendanceData> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AttendanceDto [chart=" + chart + ", data=" + data + "]";
	}

}
