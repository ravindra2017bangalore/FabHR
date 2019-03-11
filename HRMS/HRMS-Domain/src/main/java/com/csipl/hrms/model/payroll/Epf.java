package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Epf database table.
 * 
 */

@Entity
@NamedQuery(name="Epf.findAll", query="SELECT e FROM Epf e")
public class Epf extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long epfId;

	private String activeStatus;

	private BigDecimal adminPer;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal edliExpPer;

	private BigDecimal edliPer;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private BigDecimal employeePer;

	private BigDecimal employerPensionPer;

	private BigDecimal employerPer;

	private String epfName;

	private BigDecimal maxBasicLimit;
	
	private BigDecimal maxPensionLimit;

	private String isActual;	
	
	public String getIsActual() {
		return isActual;
	}

	public void setIsActual(String isActual) {
		this.isActual = isActual;
	}

	public BigDecimal getMaxPensionLimit() {
		return maxPensionLimit;
	}

	public void setMaxPensionLimit(BigDecimal maxPensionLimit) {
		this.maxPensionLimit = maxPensionLimit;
	}

	public Epf() {
	}

	public Long getEpfId() {
		return this.epfId;
	}

	public void setEpfId(Long epfId) {
		this.epfId = epfId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public BigDecimal getAdminPer() {
		return this.adminPer;
	}

	public void setAdminPer(BigDecimal adminPer) {
		this.adminPer = adminPer;
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

	public BigDecimal getEdliExpPer() {
		return this.edliExpPer;
	}

	public void setEdliExpPer(BigDecimal edliExpPer) {
		this.edliExpPer = edliExpPer;
	}

	public BigDecimal getEdliPer() {
		return this.edliPer;
	}

	public void setEdliPer(BigDecimal edliPer) {
		this.edliPer = edliPer;
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

	public BigDecimal getEmployerPensionPer() {
		return this.employerPensionPer;
	}

	public void setEmployerPensionPer(BigDecimal employerPensionPer) {
		this.employerPensionPer = employerPensionPer;
	}

	public BigDecimal getEmployerPer() {
		return this.employerPer;
	}

	public void setEmployerPer(BigDecimal employerPer) {
		this.employerPer = employerPer;
	}

	public String getEpfName() {
		return this.epfName;
	}

	public void setEpfName(String epfName) {
		this.epfName = epfName;
	}
	
	public BigDecimal getMaxBasicLimit() {
		return this.maxBasicLimit;
	}

	public void setMaxBasicLimit(BigDecimal maxBasicLimit) {
		this.maxBasicLimit = maxBasicLimit;
	}



}