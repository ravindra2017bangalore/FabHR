package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TdsGroup database table.
 * 
 */
@Entity
@NamedQuery(name="TdsGroup.findAll", query="SELECT t FROM TdsGroup t")
public class TdsGroup extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsGroupId;

	private String activeStatus;

	private BigDecimal addLimitOnAge;

	private Long ageForExtra;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String financialYear;
	
	private String isIncome;

	private String isSubGroupLimit;

	private String isSubGroupReq;

	private BigDecimal maxLimit;

	private String tdsDescription;

	private String tdsGroupName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveStartDate;
	
	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveEndDate;

	//bi-directional many-to-one association to TdsSection
	@OneToMany(mappedBy="tdsGroup", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<TdsSection> tdsSections;

	public TdsGroup() {
	}

	public Long getTdsGroupId() {
		return this.tdsGroupId;
	}

	public void setTdsGroupId(Long tdsGroupId) {
		this.tdsGroupId = tdsGroupId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	
	public String getIsIncome() {
		return this.isIncome;
	}

	public void setIsIncome(String isIncome) {
		this.isIncome = isIncome;
	}

	public String getIsSubGroupLimit() {
		return this.isSubGroupLimit;
	}

	public void setIsSubGroupLimit(String isSubGroupLimit) {
		this.isSubGroupLimit = isSubGroupLimit;
	}

	public String getIsSubGroupReq() {
		return this.isSubGroupReq;
	}

	public void setIsSubGroupReq(String isSubGroupReq) {
		this.isSubGroupReq = isSubGroupReq;
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

	public String getTdsGroupName() {
		return this.tdsGroupName;
	}

	public void setTdsGroupName(String tdsGroupName) {
		this.tdsGroupName = tdsGroupName;
	}

	public List<TdsSection> getTdsSections() {
		return this.tdsSections;
	}

	public void setTdsSections(List<TdsSection> tdsSections) {
		this.tdsSections = tdsSections;
	}

	public TdsSection addTdsSection(TdsSection tdsSection) {
		getTdsSections().add(tdsSection);
		tdsSection.setTdsGroup(this);

		return tdsSection;
	}

	public TdsSection removeTdsSection(TdsSection tdsSection) {
		getTdsSections().remove(tdsSection);
		tdsSection.setTdsGroup(null);

		return tdsSection;
	}

}
