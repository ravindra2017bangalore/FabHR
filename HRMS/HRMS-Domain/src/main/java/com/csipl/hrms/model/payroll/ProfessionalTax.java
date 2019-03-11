package com.csipl.hrms.model.payroll;


import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.common.State;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ProfessionalTax database table.
 * 
 */
@Entity
@NamedQuery(name="ProfessionalTax.findAll", query="SELECT p FROM ProfessionalTax p")
public class ProfessionalTax  extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professionalHeadId;
	
	private String activeStatus;

	private String allowModi;

	

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveStartDate;

	@Temporal(TemporalType.DATE)
	private Date effectiveEndDate;


	private BigDecimal limitAmount;

	private BigDecimal perMonthAmount;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="stateId")
	private State state;

	//bi-directional many-to-one association to ProfessionalTaxInfo
	@OneToMany(mappedBy="professionalTax", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
	private List<ProfessionalTaxInfo> professionalTaxInfos;

	public ProfessionalTax() {
	}

	public Long getProfessionalHeadId() {
		return this.professionalHeadId;
	}

	public void setProfessionalHeadId(Long professionalHeadId) {
		this.professionalHeadId = professionalHeadId;
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

	public BigDecimal getLimitAmount() {
		return this.limitAmount;
	}

	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
	}

	public BigDecimal getPerMonthAmount() {
		return this.perMonthAmount;
	}

	public void setPerMonthAmount(BigDecimal perMonthAmount) {
		this.perMonthAmount = perMonthAmount;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<ProfessionalTaxInfo> getProfessionalTaxInfos() {
		return this.professionalTaxInfos;
	}

	public void setProfessionalTaxInfos(List<ProfessionalTaxInfo> professionalTaxInfos) {
		this.professionalTaxInfos = professionalTaxInfos;
	}

	public ProfessionalTaxInfo addProfessionalTaxInfo(ProfessionalTaxInfo professionalTaxInfo) {
		getProfessionalTaxInfos().add(professionalTaxInfo);
		professionalTaxInfo.setProfessionalTax(this);

		return professionalTaxInfo;
	}

	public ProfessionalTaxInfo removeProfessionalTaxInfo(ProfessionalTaxInfo professionalTaxInfo) {
		getProfessionalTaxInfos().remove(professionalTaxInfo);
		professionalTaxInfo.setProfessionalTax(null);

		return professionalTaxInfo;
	}

}