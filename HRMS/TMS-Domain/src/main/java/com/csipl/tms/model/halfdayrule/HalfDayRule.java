package com.csipl.tms.model.halfdayrule;

import java.io.Serializable;
import javax.persistence.*;

//import com.csipl.hrms.common.model.Company;

import java.util.Date;

/**
 * The persistent class for the HailfDayRule database table.
 * 
 */
@Entity
@Table(name = "TMSHalfDayRule")
@NamedQuery(name = "HalfDayRule.findAll", query = "SELECT h FROM HalfDayRule h")
public class HalfDayRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long halfDayRuleId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private Long maximumRequireHour;

	private Long minimumRequireHour;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private Long updatedId;

	private Long userId;

	// bi-directional many-to-one association to Company

	/* @ManyToOne
	@JoinColumn(name = "companyId")
	private Company company; */
	private Long companyId;
	

	public HalfDayRule() {
	}

	public Long getHalfDayRuleId() {
		return this.halfDayRuleId;
	}

	public void setHalfDayRuleId(Long halfDayRuleId) {
		this.halfDayRuleId = halfDayRuleId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getMaximumRequireHour() {
		return this.maximumRequireHour;
	}

	public void setMaximumRequireHour(Long maximumRequireHour) {
		this.maximumRequireHour = maximumRequireHour;
	}

	public Long getMinimumRequireHour() {
		return this.minimumRequireHour;
	}

	public void setMinimumRequireHour(Long minimumRequireHour) {
		this.minimumRequireHour = minimumRequireHour;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdatedId() {
		return this.updatedId;
	}

	public void setUpdatedId(Long updatedId) {
		this.updatedId = updatedId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/*public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

}