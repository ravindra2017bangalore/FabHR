package com.csipl.hrms.dto.report;

import java.util.ArrayList;

import com.csipl.hrms.dto.report.Chart ;

public class GraphDto {
	Chart chart;
	DepartmentChart deptChart;
//	DepartmentPayrollChart payrollChart;
	ArrayList<Data> data= new ArrayList<>();
	
	
               
	public GraphDto(Chart chart, ArrayList<Data> data) {
	
		this.chart = chart;
		this.data = data;
	}
	
	public GraphDto(DepartmentChart chart, ArrayList<Data> data) {
		
		this.deptChart = chart;
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

	public DepartmentChart getDeptChart() {
		return deptChart;
	}

	public void setDeptChart(DepartmentChart deptChart) {
		this.deptChart = deptChart;
	}

	

}
