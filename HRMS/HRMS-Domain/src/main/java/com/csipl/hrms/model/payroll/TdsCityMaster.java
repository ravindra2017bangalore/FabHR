package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the TdsCityMaster database table.
 * 
 */
@Entity
@NamedQuery(name="TdsCityMaster.findAll", query="SELECT t FROM TdsCityMaster t")
public class TdsCityMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tdsCityMasterId;

	private String cityType;

	private Long companyId;

	private String financialYear;

	private BigDecimal percentage;

	public TdsCityMaster() {
	}

	public int getTdsCityMasterId() {
		return this.tdsCityMasterId;
	}

	public void setTdsCityMasterId(int tdsCityMasterId) {
		this.tdsCityMasterId = tdsCityMasterId;
	}

	public String getCityType() {
		return this.cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

}