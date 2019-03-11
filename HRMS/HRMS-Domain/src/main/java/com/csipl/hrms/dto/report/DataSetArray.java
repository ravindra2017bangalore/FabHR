package com.csipl.hrms.dto.report;

import java.util.ArrayList;

public class DataSetArray {
	
	String seriesname;
	ArrayList<Data> data =new ArrayList<>();
	
	 public DataSetArray() {
	
	}
	
	public DataSetArray(String seriesname,ArrayList<Data> data) {
	    this.seriesname=seriesname;
		this.data = data;
	}
	public String getSeriesname() {
		return seriesname;
	}
	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	
	

}
