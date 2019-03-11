package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class DesignationChartDto {
	
	DesignationChartEmpMaster chart;
	ArrayList<DesignationData> data =new ArrayList<DesignationData>();
	
	public DesignationChartDto(DesignationChartEmpMaster chart, ArrayList<DesignationData> data) {
		super();
		this.chart = chart;
		this.data = data;
	}

	public DesignationChartEmpMaster getChart() {
		return chart;
	}

	public void setChart(DesignationChartEmpMaster chart) {
		this.chart = chart;
	}

	public ArrayList<DesignationData> getData() {
		return data;
	}

	public void setData(ArrayList<DesignationData> data) {
		this.data = data;
	}
	
	

}
