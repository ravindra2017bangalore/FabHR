package com.csipl.hrms.dto.payroll;

import java.util.Date;

import com.csipl.hrms.model.BaseModel;
 
public class FinancialYearDTO extends BaseModel{
	private Long financialYearId;	
	private Date dateFrom;	
	private String isPayrollDaysManuals;	
	private String financialYear;	
	private Long userId;
	private Date dateCreated;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getIsPayrollDaysManuals() {
		return isPayrollDaysManuals;
	}

	public void setIsPayrollDaysManuals(String isPayrollDaysManuals) {
		this.isPayrollDaysManuals = isPayrollDaysManuals;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
}
