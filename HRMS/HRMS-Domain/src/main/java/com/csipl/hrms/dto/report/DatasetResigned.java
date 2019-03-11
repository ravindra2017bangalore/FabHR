package com.csipl.hrms.dto.report;

import java.util.ArrayList;
import java.util.List;

public class DatasetResigned {

	String	seriesname="Resigned";
	 
	 List<DataResigned> data= new ArrayList<DataResigned>();
	 
	 
	 public DatasetResigned(ArrayList<DataResigned> data) {
		 this.data=data;
	 }


	public String getSeriesname() {
		return seriesname;
	}


	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}


	public List<DataResigned> getData() {
		return data;
	}


	public void setData(List<DataResigned> data) {
		this.data = data;
	}


	
	
}
