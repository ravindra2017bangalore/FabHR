package com.csipl.tms.dto.attendanceregularizationrequest;

import java.util.Date;

public class PunchTimeDetailDTO {
	private Long punchTimeDetailsId;
	
	private Date date;
	
	private String flag;
	
	private String time;
	
	private Long hhMm;
	
	public Long getHhMm() {
		return hhMm;
	}

	public void setHhMm(Long hhMm) {
		this.hhMm = hhMm;
	}

	private Long companyId;
	
	private String in_out;
	
	private Long sNo;
	
	private String tktNo;
	
	private String intime;
	
	private String outtime;

	public Long getPunchTimeDetailsId() {
		return punchTimeDetailsId;
	}

	public void setPunchTimeDetailsId(Long punchTimeDetailsId) {
		this.punchTimeDetailsId = punchTimeDetailsId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getIn_out() {
		return in_out;
	}

	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	

	

	public Long getsNo() {
		return sNo;
	}

	public void setsNo(Long sNo) {
		this.sNo = sNo;
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
}
