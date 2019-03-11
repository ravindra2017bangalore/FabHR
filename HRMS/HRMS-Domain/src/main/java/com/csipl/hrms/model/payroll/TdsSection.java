package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TdsSection database table.
 * 
 */
@Entity
@NamedQuery(name="TdsSection.findAll", query="SELECT t FROM TdsSection t")
public class TdsSection extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsSectionId;

	private BigDecimal addLimitOnAge;

	private Long ageForExtra;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String isParrentRecord;

	private BigDecimal maxLimit;

	private String tdsDescription;

	private String tdsSectionName;

	//bi-directional many-to-one association to TdsGroup
	@ManyToOne
	@JoinColumn(name="tdsGroupId")
	private TdsGroup tdsGroup;

	public TdsSection() {
	}

	public Long getTdsSectionId() {
		return this.tdsSectionId;
	}

	public void setTdsSectionId(Long tdsSectionId) {
		this.tdsSectionId = tdsSectionId;
	}

	public BigDecimal getAddLimitOnAge() {
		return this.addLimitOnAge;
	}

	public void setAddLimitOnAge(BigDecimal addLimitOnAge) {
		this.addLimitOnAge = addLimitOnAge;
	}

	public Long getAgeForExtra() {
		return this.ageForExtra;
	}

	public void setAgeForExtra(Long ageForExtra) {
		this.ageForExtra = ageForExtra;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getIsParrentRecord() {
		return this.isParrentRecord;
	}

	public void setIsParrentRecord(String isParrentRecord) {
		this.isParrentRecord = isParrentRecord;
	}

	public BigDecimal getMaxLimit() {
		return this.maxLimit;
	}

	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getTdsDescription() {
		return this.tdsDescription;
	}

	public void setTdsDescription(String tdsDescription) {
		this.tdsDescription = tdsDescription;
	}

	public String getTdsSectionName() {
		return this.tdsSectionName;
	}

	public void setTdsSectionName(String tdsSectionName) {
		this.tdsSectionName = tdsSectionName;
	}

	public TdsGroup getTdsGroup() {
		return this.tdsGroup;
	}

	public void setTdsGroup(TdsGroup tdsGroup) {
		this.tdsGroup = tdsGroup;
	}

}
