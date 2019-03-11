package com.csipl.hrms.dto.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PfReportDTO {
	
	private String name;
	private String uanno;
	private Date dob;
	private String aadharNo;
	private String fatherName;
	private String mobileNo;
	private List<PfReportTableDTO> pfReportTableDtoList = new ArrayList<PfReportTableDTO>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUanno() {
		return uanno;
	}
	public void setUanno(String uanno) {
		this.uanno = uanno;
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
	public List<PfReportTableDTO> getPfReportTableDtoList() {
		return pfReportTableDtoList;
	}
	public void setPfReportTableDtoList(List<PfReportTableDTO> pfReportTableDtoList) {
		this.pfReportTableDtoList = pfReportTableDtoList;
	}
	
}
