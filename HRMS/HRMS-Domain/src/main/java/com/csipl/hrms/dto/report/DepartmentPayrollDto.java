package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class DepartmentPayrollDto {

	DepartmentChartPayroll chart;
	ArrayList<DepartmentData> data= new ArrayList<>();
	
	
  
	
public DepartmentPayrollDto(DepartmentChartPayroll chart, ArrayList<DepartmentData> data) {
		
		this.chart = chart;
		this.data = data;
	}
	
	public ArrayList<DepartmentData> getData() {
		return data;
	}
	public void setData(ArrayList<DepartmentData> data) {
		this.data = data;
	}



	public DepartmentChartPayroll getPayrollChart() {
		return chart;
	}

	public void setPayrollChart(DepartmentChartPayroll desgChart) {
		this.chart = desgChart;
	}
	

}
