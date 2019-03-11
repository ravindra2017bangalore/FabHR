package com.csipl.hrms.model.payroll;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ProfessionalTaxInfo database table.
 * 
 */
@Entity
@NamedQuery(name="ProfessionalTaxInfo.findAll", query="SELECT p FROM ProfessionalTaxInfo p")
public class ProfessionalTaxInfo extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProfessionalTaxInfoId")
	private Long professionalTaxInfoId;

	private String allowModi;

	private String category;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private BigDecimal limitFrom;

	private BigDecimal limitTo;

	private BigDecimal taxAmount;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to ProfessionalTax
	@ManyToOne
	@JoinColumn(name="ProfessionalTaxId")
	private ProfessionalTax professionalTax;

	public ProfessionalTaxInfo() {
	}

	public Long getProfessionalTaxInfoId() {
		return this.professionalTaxInfoId;
	}

	public void setProfessionalTaxInfoId(Long professionalTaxInfoId) {
		this.professionalTaxInfoId = professionalTaxInfoId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public BigDecimal getLimitFrom() {
		return this.limitFrom;
	}

	public void setLimitFrom(BigDecimal limitFrom) {
		this.limitFrom = limitFrom;
	}

	public BigDecimal getLimitTo() {
		return this.limitTo;
	}

	public void setLimitTo(BigDecimal limitTo) {
		this.limitTo = limitTo;
	}

	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public ProfessionalTax getProfessionalTax() {
		return this.professionalTax;
	}

	public void setProfessionalTax(ProfessionalTax professionalTax) {
		this.professionalTax = professionalTax;
	}

}