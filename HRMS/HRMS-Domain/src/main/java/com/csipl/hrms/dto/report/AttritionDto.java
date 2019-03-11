package com.csipl.hrms.dto.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttritionDto {

	AttritionChart chart;
	
	List<HashMap<String,ArrayList<Category>>> categories = new ArrayList<HashMap<String,ArrayList<Category>>>();
//	List<HashMap<String,ArrayList<Category>>> categories = new ArrayList<HashMap<String,ArrayList<Category>>>();
	ArrayList<Object> dataset = new ArrayList<Object>();
	public AttritionDto(AttritionChart chart, ArrayList<HashMap<String,ArrayList<Category>>> categories,ArrayList<Object> dataset) {
		
		this.chart = chart;
		this.categories = categories;
		this.dataset = dataset;
	}
	public AttritionChart getChart() {
		return chart;
	}
	public void setChart(AttritionChart chart) {
		this.chart = chart;
	}
	
	
	
	
	public List<HashMap<String, ArrayList<Category>>> getCategories() {
		return categories;
	}
	public void setCategories(List<HashMap<String, ArrayList<Category>>> categories) {
		this.categories = categories;
	}
	public ArrayList<Object> getDataset() {
		return dataset;
	}
	public void setDataset(ArrayList<Object> dataset) {
		this.dataset = dataset;
	}
	
	
	
	
	
	
	
}
