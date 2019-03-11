package com.csipl.sqlserver.model.punchtimedetails;



import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PunchTimeDetails database table.
 * 
 */
@Entity
@Table(name="PunchTimeDetails")
@NamedQuery(name="PunchTimeDetail.findAll", query="SELECT p FROM PunchTimeDetail p")
public class PunchTimeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PunchTimeDetailsId")
	private Long punchTimeDetailsId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String flag;

	@Column(name="hh_mm")
	private double hhMm;

	private double hhmm;

	@Column(name="[INOUT]")
	private String inout;

	private double sno;

	private String tktno;

	private double tmmm;

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

	public double getHhMm() {
		return this.hhMm;
	}

	public void setHhMm(double hhMm) {
		this.hhMm = hhMm;
	}

	public double getHhmm() {
		return this.hhmm;
	}

	public void setHhmm(double hhmm) {
		this.hhmm = hhmm;
	}

	public String getInout() {
		return this.inout;
	}

	public void setInout(String inout) {
		this.inout = inout;
	}

	public double getSno() {
		return this.sno;
	}

	public void setSno(double sno) {
		this.sno = sno;
	}

	public String getTktno() {
		return this.tktno;
	}

	public void setTktno(String tktno) {
		this.tktno = tktno;
	}

	public double getTmmm() {
		return this.tmmm;
	}

	public void setTmmm(double tmmm) {
		this.tmmm = tmmm;
	}

}