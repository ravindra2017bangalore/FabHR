package com.csipl.hrms.dto.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsiInfoDTO {
	private String name;
	private String esicNumber;
	private Date dob;
	private String aadharNo;
	private String fatherName;
	private String mobileNo;
	private List<EsiReportTableDTO> esiReportTableDtoList = new ArrayList<EsiReportTableDTO>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getEsicNumber() {
		return esicNumber;
	}
	public void setEsicNumber(String esicNumber) {
		this.esicNumber = esicNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<EsiReportTableDTO> getEsiReportTableDtoList() {
		return esiReportTableDtoList;
	}
	public void setEsiReportTableDtoList(List<EsiReportTableDTO> esiReportTableDtoList) {
		this.esiReportTableDtoList = esiReportTableDtoList;
	}
	
	
	
}
