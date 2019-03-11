package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Overtime database table.
 * 
 */

@Entity
@NamedQuery(name="Overtime.findAll", query="SELECT o FROM Overtime o")
public class Overtime extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long overtimeId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal fixAmount;

	private Long noOfDays;

	private Long ratio;

	public Overtime() {
	}

	public Long getOvertimeId() {
		return this.overtimeId;
	}

	public void setOvertimeId(Long overtimeId) {
		this.overtimeId = overtimeId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public BigDecimal getFixAmount() {
		return this.fixAmount;
	}

	public void setFixAmount(BigDecimal fixAmount) {
		this.fixAmount = fixAmount;
	}

	public Long getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(Long noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Long getRatio() {
		return this.ratio;
	}

	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}
}
