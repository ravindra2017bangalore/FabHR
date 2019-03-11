package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class TdsStandardExemptionDTO {
	
	private Long tdsStandardExemptionId;
	private BigDecimal amount;
	private Date dateCreated;
	private String financialYear;
	private Long userId;
	private Long companyId;
	private Long userIdUpdate;

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getTdsStandardExemptionId() {
		return tdsStandardExemptionId;
	}
	public void setTdsStandardExemptionId(Long tdsStandardExemptionId) {
		this.tdsStandardExemptionId = tdsStandardExemptionId;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
