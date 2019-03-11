package com.csipl.hrms.dto.report;

import java.util.ArrayList;
import java.util.List;

public class DatasetJoined {

 String	seriesname="Joined";
 
 List<DataJoined> data= new ArrayList<DataJoined>();
 
 
 public DatasetJoined(ArrayList<DataJoined> data) {
	 this.data=data;
 }


public String getSeriesname() {
	return seriesname;
}


public void setSeriesname(String seriesname) {
	this.seriesname = seriesname;
}


public List<DataJoined> getData() {
	return data;
}


public void setData(List<DataJoined> data) {
	this.data = data;
}
 
 
 
}
