package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Esi database table.
 * 
 */
@Entity
@NamedQuery(name="Esi.findAll", query="SELECT e FROM Esi e")
public class Esi extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long esiId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private BigDecimal employeePer;

	private BigDecimal employerPer;

	private String esiName;

	private BigDecimal maxGrossLimit;

	public Esi() {
	}

	public Long getEsiId() {
		return this.esiId;
	}

	public void setEsiId(Long esiId) {
		this.esiId = esiId;
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

	public BigDecimal getEmployeePer() {
		return this.employeePer;
	}

	public void setEmployeePer(BigDecimal employeePer) {
		this.employeePer = employeePer;
	}

	public BigDecimal getEmployerPer() {
		return this.employerPer;
	}

	public void setEmployerPer(BigDecimal employerPer) {
		this.employerPer = employerPer;
	}

	public String getEsiName() {
		return this.esiName;
	}

	public void setEsiName(String esiName) {
		this.esiName = esiName;
	}

	public BigDecimal getMaxGrossLimit() {
		return this.maxGrossLimit;
	}

	public void setMaxGrossLimit(BigDecimal maxGrossLimit) {
		this.maxGrossLimit = maxGrossLimit;
	}
}