package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.util.Date;


/**
 * The persistent class for the Gratuaty database table.
 * 
 */

@Entity
@NamedQuery(name="Gratuaty.findAll", query="SELECT g FROM Gratuaty g")
public class Gratuaty extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long graduityId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private Long noOfDays;

	private Long noOfDaysDevide;

	private Long noOfMonths;

	public Gratuaty() {
	}

	public Long getGraduityId() {
		return this.graduityId;
	}

	public void setGraduityId(Long graduityId) {
		this.graduityId = graduityId;
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

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Long getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(Long noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Long getNoOfDaysDevide() {
		return this.noOfDaysDevide;
	}

	public void setNoOfDaysDevide(Long noOfDaysDevide) {
		this.noOfDaysDevide = noOfDaysDevide;
	}

	public Long getNoOfMonths() {
		return this.noOfMonths;
	}

	public void setNoOfMonths(Long noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
}