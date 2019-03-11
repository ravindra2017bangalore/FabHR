package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class DepartmentChartDto {

	
	public DepartmentChartEmpMaster  chart;
	ArrayList<DepartmentData> data =new ArrayList<DepartmentData>();
	
	
	
	
	public DepartmentChartDto(DepartmentChartEmpMaster chart, ArrayList<DepartmentData> data) {
		super();
		this.chart = chart;
		this.data = data;
	}

	public DepartmentChartEmpMaster getChart() {
		return chart;
	}

	public void setChart(DepartmentChartEmpMaster chart) {
		this.chart = chart;
	}

	public ArrayList<DepartmentData> getData() {
		return data;
	}

	public void setData(ArrayList<DepartmentData> data) {
		this.data = data;
	}
	
}
