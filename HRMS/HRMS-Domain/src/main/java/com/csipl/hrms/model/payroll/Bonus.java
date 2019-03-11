package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.organisation.Grade;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Bonus database table.
 * 
 */

@Entity
@NamedQuery(name="Bonus.findAll", query="SELECT b FROM Bonus b")
public class Bonus extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bonusId;

	private String activeStatus;

	private String allowModi;

	private BigDecimal bonusPer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private String financialYear;

	//bi-directional many-to-one association to Grade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gradesId")
	private Grade grade;
	
	public Bonus() {
	}

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
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

	public BigDecimal getBonusPer() {
		return this.bonusPer;
	}

	public void setBonusPer(BigDecimal bonusPer) {
		this.bonusPer = bonusPer;
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

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}