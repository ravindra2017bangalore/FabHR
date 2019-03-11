package com.csipl.tms.dto.attendanceregularizationrequest;

import java.util.Date;

public class SystemAttendanceDTO {
	private Long minSNo;
	
	private String tktNo;
	
	private String intime;
	
	private String outtime;
	
	private Long maxSNo;
	
	private Date date;
	
	private Long companyId;

	public Long getMinSNo() {
		return minSNo;
	}

	public void setMinSNo(Long minSNo) {
		this.minSNo = minSNo;
	}

	public String getTktNo() {
		return tktNo;
	}

	public void setTktNo(String tktNo) {
		this.tktNo = tktNo;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public Long getMaxSNo() {
		return maxSNo;
	}

	public void setMaxSNo(Long maxSNo) {
		this.maxSNo = maxSNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
