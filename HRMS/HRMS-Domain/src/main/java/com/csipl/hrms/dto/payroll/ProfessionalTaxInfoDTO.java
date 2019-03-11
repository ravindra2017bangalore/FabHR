package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class ProfessionalTaxInfoDTO {
	private Long professionalTaxInfoId;
	private String category;
	private Date dateCreated;
	private BigDecimal limitFrom;
	private BigDecimal limitTo;
	private BigDecimal taxAmount;
	private Long userId;
	private Long userIdUpdate;
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Long getProfessionalTaxInfoId() {
		return professionalTaxInfoId;
	}

	public void setProfessionalTaxInfoId(Long professionalTaxInfoId) {
		this.professionalTaxInfoId = professionalTaxInfoId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getLimitFrom() {
		return limitFrom;
	}

	public void setLimitFrom(BigDecimal limitFrom) {
		this.limitFrom = limitFrom;
	}

	public BigDecimal getLimitTo() {
		return limitTo;
	}

	public void setLimitTo(BigDecimal limitTo) {
		this.limitTo = limitTo;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
