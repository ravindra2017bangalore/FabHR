package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;

public class PreviousEmployerIncomeTdsDTO {

	private Long previousEmployerIncomeTdsId;
	private BigDecimal amount;
	private Long employeeId;
	private String financialYear;
	private Long previousEmployerIncomeId;
	private String particular;
	private Long userId;
	private String dateCreated;
	private Long userIdUpdate;
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public Long getPreviousEmployerIncomeTdsId() {
		return previousEmployerIncomeTdsId;
	}
	public void setPreviousEmployerIncomeTdsId(Long previousEmployerIncomeTdsId) {
		this.previousEmployerIncomeTdsId = previousEmployerIncomeTdsId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public Long getPreviousEmployerIncomeId() {
		return previousEmployerIncomeId;
	}
	public void setPreviousEmployerIncomeId(Long previousEmployerIncomeId) {
		this.previousEmployerIncomeId = previousEmployerIncomeId;
	}
	
}
