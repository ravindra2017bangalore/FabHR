package com.csipl.tms.model.attendanceregularizationrequest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PunchTimeDetail database table.
 * 
 */
@Entity
@NamedQuery(name="PunchTimeDetail.findAll", query="SELECT p FROM PunchTimeDetail p")
public class PunchTimeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long punchTimeDetailsId;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String flag;

	private Long hhMm;

	@Column(name="`in/out`")
	private String in_out;

	private Long sNo;

	private String time;

	private String tktNo;

	private Long tmmm;

	public PunchTimeDetail() {
	}

	public Long getPunchTimeDetailsId() {
		return this.punchTimeDetailsId;
	}

	public void setPunchTimeDetailsId(Long punchTimeDetailsId) {
		this.punchTimeDetailsId = punchTimeDetailsId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	public Long getHhMm() {
		return this.hhMm;
	}

	public void setHhMm(Long hhMm) {
		this.hhMm = hhMm;
	}

	public String getIn_out() {
		return this.in_out;
	}

	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}

	public Long getSNo() {
		return this.sNo;
	}

	public void setSNo(Long sNo) {
		this.sNo = sNo;
	}

	public String getTktNo() {
		return this.tktNo;
	}

	public void setTktNo(String tktNo) {
		this.tktNo = tktNo;
	}

	public Long getTmmm() {
		return this.tmmm;
	}

	public void setTmmm(Long tmmm) {
		this.tmmm = tmmm;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getsNo() {
		return sNo;
	}

	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}